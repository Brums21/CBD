package ex5;

import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class SistemaMensagens {

    public static Jedis jedis = new Jedis();

    public static void addUser(String username){

        //adicionar utilizador a base de dados: --done 
        //por conveniencia, cada um segue se a si proprio

        jedis.sadd("users", username);
        follow(username, username);

    }

    public static void addUsers(String[] usernames){

        //adicionar utilizador a base de dados: --done 
        //por conveniencia, cada um segue se a si proprio 

        for (String username : usernames){
            jedis.sadd("users", username);
            follow(username, username);
        }

    }

    public static void storeMsg(String user, String msg){
        jedis.hset("messages", user, msg);
    }

    public static void follow(String user, String follower){
        jedis.sadd(user, follower);
    }

    public static void readMsg(String user){
        // faz tudo - ve todos os seguidores etc

        if ((!jedis.hexists("messages", user)) && jedis.smembers(user).isEmpty()){
            System.out.println("No messages to read");
        } 
        else {
            for (String follower: jedis.smembers(user)){
                System.out.println(follower + ": " + jedis.hget("messages", follower));
            }
        }

    }

    public static void main(String[] args) {

        /* Notas previas: necessario criar 3 relacoes chave - valor :
            - 1 para todos os utilizadores -> users ("users" -> lista de users)
            - x para todas as relacoes utilizador-outros utilizadores subscritos (utilizador -> following)
            - 1 para todas as stored messages -> user - mensagem ("messages" -> mapa (utilizador -> mensagem))
            neste ultimo, ver no 2o ponto qual os outros users relacionados com o user que mandou a mensagem 
        */ 

        /*
        //criacao de utilizadores na base de dados: para teste
        jedis.sadd("users", "admin");
        
        String[] utilizadores = {"Diogo", "Francisca", "Filomena"};
        addUsers(utilizadores);

        follow("Matilde", "Diogo"); //matilde segue o diogo
        follow("Matilde", "Filomena");

        storeMsg("Diogo", "Hoje esta frio."); // matilde deve conseguir visualizar esta mensagem
        storeMsg("Matilde", "Hoje tenho frio.");
        storeMsg("Filomena", "Nao tenho seguidores.");
        
        readMsg("Matilde"); //ver todas as mensagens que a matilde tem        

        */

        printcoisas();

        //terminar o programa:
        jedis.flushAll();
        jedis.flushDB();
        jedis.close();
    
    }

    public static void printcoisas(){

        System.out.println("Bem vindo/(a) ao sistema de mensagens!");
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("1 - Registar novo utilizador");
            System.out.println("2 - Seguir alguem");
            System.out.println("3 - Enviar mensagem");
            System.out.println("4 - Ler mensagens");

            String input = scanner.nextLine();

            if (input.length()==0){
                break;
            }

            String utilizador = null;

            switch (input) {

                case "1":
                    System.out.println("Indique o novo utilizador: ");
                    addUser(scanner.nextLine());
                    System.out.println("Utilizador gravado com sucesso.");
                    break;

                case "2":
                    System.out.println("Indique quem e:");
                    utilizador = scanner.nextLine();
                    addUser(utilizador);
                    System.out.println("Indique quem pretende seguir:");
                    follow(utilizador, scanner.nextLine());
                    break;
        
                case "3":
                    System.out.println("Indique quem e:");
                    utilizador = scanner.nextLine();
                    addUser(utilizador);
                    System.out.println("Indique a mensagem que pretende enviar: ");
                    storeMsg(utilizador, scanner.nextLine());
                    break;
        
                case "4":
                    System.out.println("Indique quem e:");
                    utilizador = scanner.nextLine();
                    addUser(utilizador);
                    readMsg(utilizador);
                    break;
            
                default:
                    System.out.println("Nao introduziu um numero valido!");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
