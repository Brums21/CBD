package exercicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;

import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Sorts.*;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;


public final class App {
    private App() {
    }

    public static void insertADoc(MongoCollection<Document> collection){
        collection.insertOne(new Document()
        .append("_id", new ObjectId())
        .append("address", new Document("building", "1234")
            .append("coord", Arrays.asList(-0, 50))
            .append("rua", "Rua qualquer")
            .append("zipcode", "1234")
            )
        .append("localidade", "Aveiro")
        .append("gastronomia", "Sushi")
        .append("grades", Arrays.asList(new Document("date", "2022-10-30T00:00:00Z").append("grade", "B").append("score", 6) ))
        .append("nome", "Nome restaurante")
        .append("restaurant_id", "12345678"));
        System.out.println("Inserted with sucess");
    }

    public static void updateDoc(MongoCollection<Document> collection, String nome, String valor_antigo, String valor_novo){
        collection.updateMany(Filters.eq(nome, valor_antigo), Updates.set(nome, valor_novo));
    }

    public static void searchDoc(MongoCollection<Document> collection, String field_name, String field_value){        
        Document doc = collection.find(eq(field_name, field_value)).first();
        if (doc!= null){
            System.out.println(doc.toJson());
            return;
        }
        System.out.println("Search not found -> Can throw null pointer exception here.");
    }

    public static void createIndex(MongoCollection<Document> collection, String field){
        collection.createIndex(Indexes.ascending(field));
    }

    public static void createTextIndex(MongoCollection<Document> collection, String field){
        collection.createIndex(Indexes.text(field));
    }

    public static void alineaC(MongoCollection<Document> collection){
        //Alineas 5, 9, 13, 17, 21:

        //Alinea 5)
        //db.restaurants.find({localidade: 'Bronx'}).sort({nome: 1}).limit(15)
        FindIterable<Document> exemplo = collection.find(eq("localidade", "Bronx")).sort(ascending("nome")).limit(15);
        exemplo.forEach(document -> System.out.println(document.toJson())); // printa todos

        //Alinea 9)
        //db.restaurants.find({gastronomia : {$ne : 'American'}, "grades.score": {"$gt": 70}, "address.coord.0" : {"$lt" : -65 }})
        Bson filter = Filters.and(ne("gastronomia", "American"), gt("grades.score", 70), lt("address.coord.0", 65));
        exemplo = collection.find(filter);
        exemplo.forEach(document -> System.out.println(document.toJson()));

        //Alinea 13)
        //db.restaurants.find({"grades.score":{$not: {$gt :3 }}}, {nome: 1, localidade: 1, gastronomia:1, "grades.score": 1})
        filter = Filters.and(not(gt("grades.score", 3)));
        Bson projection = Projections.fields(Projections.include("nome", "localidade", "gastronomia", "grades.score"));
        exemplo = collection.find(filter).projection(projection);
        exemplo.forEach(document -> System.out.println(document.toJson()));

        //Alinea 17)
        //db.restaurants.find({}, {nome: 1, localidade:1, gastronomia:1}).sort({gastronomia: 1, localidade:-1})
        projection = Projections.fields(Projections.include("nome", "localidade", "gastronomia"));
        Bson sorting = Sorts.orderBy(Sorts.ascending("gastronomia"), Sorts.descending("localidade"));
        exemplo = collection.find().projection(projection).sort(sorting);
        exemplo.forEach(document -> System.out.println(document.toJson()));

        //Alinea 21)
        //db.restaurants.aggregate( [{$project: {sumTotal: {$sum : "$grades.score"}, "_id":0 , "nome":1, "gastronomia": 1, "address": 1}}, {$match : {"sumTotal" : {$gt: 50}, "address.coord.0":{$lt: -60}, "gastronomia":"Portuguese"}}])
        List<Bson> pipeline = Arrays.asList(
            project(
                fields(
                    include("nome", "gastronomia", "address"),
                    computed("sumTotal", eq("$sum", "$grades.score")),
                    excludeId()
                )
            ),
            match(
                and(
                    gt("sumTotal", 50),
                    lt("address.coord.0", -60),
                    eq("gastronomia", "Portuguese")
                )
            )

        );

        collection.aggregate(pipeline).forEach(document -> System.out.println(document.toJson()));
    }

    public static void compareSearchTime(MongoCollection<Document> collection){
        collection.dropIndexes();
        long start_time = System.currentTimeMillis();
        searchDoc(collection, "localidade", "Brooklyn");
        long finish_time = System.currentTimeMillis();

        System.out.println("No indexes search time: " + (finish_time-start_time));

        //mudar conforme o indice que queremos indexar
        createIndex(collection, "localidade");
        createIndex(collection, "gastronomia");
        createTextIndex(collection, "nome");

        //criar pesquisa depois da criacao dos indexes:
        start_time = System.currentTimeMillis();
        searchDoc(collection, "localidade", "Brooklyn");
        finish_time = System.currentTimeMillis();

        System.out.println("With indexes search time: " + (finish_time-start_time));
        
    }


    public static AggregateIterable<Document> getDiffLocalidades(MongoCollection<Document> collection){
        List<Bson> pipeline = Arrays.asList(
            new Document("$group", new Document().
            append("_id", "$localidade").
            append("totalLoc", new Document("$count", new Document())))
        );

        AggregateIterable<Document> documentos = collection.aggregate(pipeline);
        
        return documentos;
    }

    public static int countLocalidades(MongoCollection<Document> collection){

        int contador = 0;
        MongoCursor<Document> documentos = getDiffLocalidades(collection).cursor();
        while(documentos.hasNext()){
            documentos.next();
            contador += 1;
        }
        //System.out.println(contador);
        return contador;
    }

    public static List<String> getRestWithNameCloserTo(MongoCollection<Document> collection, String name){
        
        Bson filter = Filters.regex("nome", name);
        Bson projection = Projections.fields(Projections.excludeId(), Projections.include("nome"));
        MongoCursor<Document> cursor = collection.find(filter).projection(projection).iterator();
        ArrayList<String> lista = new ArrayList<>();

        System.out.println("Nome de restaurantes contendo '"+ name + "' no nome:");
        while (cursor.hasNext()){
            String nome = cursor.next().get("nome").toString();
            System.out.println(" -> " + nome);
            lista.add(nome);
        }

        return lista;
    }

    public static Map<String, Integer> countRestByLocalidade(MongoCollection<Document> collection){
        System.out.println("Numero de restaurantes por localidade: ");
        MongoCursor<Document> documentos = getDiffLocalidades(collection).cursor();
        Map<String, Integer> mapa = new TreeMap<String,Integer>();
        while (documentos.hasNext()){
            Document linha = documentos.next();
            mapa.put(linha.getString("_id"), linha.getInteger("totalLoc"));
        }  
        return mapa; 
    } 

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        String uri = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("cbd");    //esta tem a collections restaurant
        MongoCollection<Document> collection = database.getCollection("restaurants");      //nem collection to test
        
        //to insert one:
        //insertADoc(collection);
        //updateDoc(collection, "nome", "Nome restaurante", "Nome qlq");

        //compare search times:
        //compareSearchTime(collection);
        
        //alineaC(collection);

        //System.out.println("Numero de localidades: " + countLocalidades(collection));
        //Map<String, Integer> mapa = countRestByLocalidade(collection);
        //for (String localidade : mapa.keySet()){
        //    System.out.println(" -> " + localidade + " - " + mapa.get(localidade));
        //}

        System.out.println("Introduza o regex para procurar na lista de restaurantes");
        String name = in.nextLine();
        getRestWithNameCloserTo(collection, name);

        in.close();

    }
}
