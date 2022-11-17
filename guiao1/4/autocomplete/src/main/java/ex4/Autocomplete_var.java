package ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.*;
import java.util.Scanner;
import java.util.Map.Entry;

import redis.clients.jedis.Jedis;

public class Autocomplete_var {

    public static LinkedHashMap<String, Double> sortHashMap(LinkedHashMap<String, Double> mapa){

        List <Entry<String, Double>> temp = new LinkedList<>(mapa.entrySet());
        Collections.sort(temp, (l1, l2) -> l2.getValue().compareTo(l1.getValue()));

        LinkedHashMap<String, Double> result = new LinkedHashMap<>();

        for (Map.Entry<String, Double> entry : temp) {
        result.put(entry.getKey(), entry.getValue());
    }

    return result;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        
        //1º passo fazer upload do ficheiro "names.txt" e passar para uma lista
        try {
            Scanner scanner = new Scanner(new File("./nomes-pt-2021.csv"));
            while (scanner.hasNextLine()){
                String input = scanner.nextLine();
                jedis.zadd("nomes", Double.parseDouble(input.split(";")[1]), input.split(";")[0]);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Nao foi possivel abrir o ficheiro!");
        }

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Double> temp = new LinkedHashMap<>();

        // criar interface com o user:
        while(true){

            System.out.print("Search for ('Enter' for quit): ");
            String input = scanner.nextLine();

            for (String nome : jedis.zrange("nomes", 0, -1)){
                if (nome.toLowerCase().startsWith(input.toLowerCase())){
                    temp.put(nome, jedis.zscore("nomes", nome));
                }
            }

            if (input.length()==0){
                break;
            }

            temp = sortHashMap(temp);

            for (String key : temp.keySet()){
                System.out.printf("%s - %s \n", key, temp.get(key).toString());
            }
            temp.clear();

        }

        scanner.close();

        jedis.flushAll(); //eliminar tudo
        jedis.close();
    }
}
