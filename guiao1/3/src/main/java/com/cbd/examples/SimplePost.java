package com.cbd.examples;
import java.util.HashMap;

import redis.clients.jedis.Jedis;


public class SimplePost {
    public static String USERS_KEY = "users"; // Key set for users' name
        public static void main(String[] args) {
        Jedis jedis = new Jedis();
        // some users
        jedis.flushAll();
        String[] users = { "Ana", "Pedro", "Maria", "Luis" };
        // jedis.del(USERS_KEY); // remove if exists to avoid wrong type

        System.out.println("Set:");
        for (String user : users)
            jedis.sadd(USERS_KEY, user);
        jedis.smembers(USERS_KEY).forEach(System.out::println);
        jedis.del(USERS_KEY); // remove if exists to avoid wrong type
        System.out.println();;
        //esta certo

        //para uma lista (i):
        System.out.println("List:");
        for (String user : users)
            jedis.rpush(USERS_KEY, user);
        jedis.lrange(USERS_KEY, 0, jedis.llen(USERS_KEY)).forEach(System.out::println);
        jedis.del(USERS_KEY); // remove if exists to avoid wrong type
        System.out.println();
        //esta certo

        //para um hashmap (ii):
        System.out.println("HashMap:");
        int i = 0;
        HashMap<String, String> mapa = new HashMap<>();
        for (String user : users){
            mapa.put("nome" + i, user);
            i++;
        }

        jedis.hset(USERS_KEY, mapa);
        jedis.hvals(USERS_KEY).forEach(System.out::println);;
        //esta certo

        jedis.flushDB();
        jedis.close();
    }
}