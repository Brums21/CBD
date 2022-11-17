package ex4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import redis.clients.jedis.Jedis;

public class Autocomplete {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        
        //1º passo fazer upload do ficheiro "names.txt" e passar para uma lista
        try {
            Scanner scanner = new Scanner(new File("./names.txt"));
            while (scanner.hasNextLine()){
                jedis.sadd("nomes", scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Nao foi possivel abrir o ficheiro!");
        }

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> temp = new ArrayList<>();

        // criar interface com o user:
        while(true){

            System.out.print("Search for ('Enter' for quit): ");
            String input = scanner.nextLine();

            for (String nome : jedis.smembers("nomes")){
                if (nome.toLowerCase().startsWith(input.toLowerCase())){
                    temp.add(nome);
                }
            }

            if (input.length()==0){
                break;
            }

            Collections.sort(temp);
            
            temp.forEach(System.out::println);
            System.out.println();
            temp.clear();

        }

        scanner.close();

        jedis.flushAll(); //eliminar tudo
        jedis.close();
    }
}
