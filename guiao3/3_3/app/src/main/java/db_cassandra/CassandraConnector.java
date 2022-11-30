package db_cassandra;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.cql.ColumnDefinition;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;
import com.datastax.oss.driver.api.querybuilder.insert.InsertInto;
import com.datastax.oss.driver.api.querybuilder.insert.JsonInsert;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.select.Selector;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class CassandraConnector {

    private CqlSession session;

    public CassandraConnector(String node, Integer port, String db, String keyspace){
        CqlSessionBuilder builder = connect(node, port, db);
        session = builder.build();


        //test some parameters with a newly (hopefully empty) keyspace;
        testInsertion();

        //using the keyspace created from ex2:
        implementSomeDBqueries(keyspace);
        
    }

    public CqlSessionBuilder connect(String node, Integer port, String db) {
        CqlSessionBuilder builder = CqlSession.builder();
        builder.addContactPoint(new InetSocketAddress(node, port));
        builder.withLocalDatacenter(db);
        return builder;
    }

    public void testInsertion(){
        // create new keyspace to test insert/update/etc:
        session.execute("create keyspace IF NOT EXISTS ex_keyspace with replication = {'class' : 'SimpleStrategy', 'replication_factor' : '1'} and durable_writes = true");
        session.execute("USE ex_keyspace");
        
        //create a random table, if not exists:
        session.execute("CREATE TABLE IF NOT EXISTS tabela_exemplo(text_id text, name text, number int, PRIMARY KEY ((text_id)) )");
        session.execute("INSERT INTO tabela_exemplo (text_id, name, number) values('id1', 'descricao do id1', 5) ");
        session.execute("INSERT INTO tabela_exemplo (text_id, name, number) values('id2', 'descricao do id2', 3) ");
        session.execute("INSERT INTO tabela_exemplo (text_id, name, number) values('id3', 'descricao do id3', 2) ");
        session.execute("INSERT INTO tabela_exemplo (text_id, name, number) values('id4', 'descricao do id4', 6) ");
        ResultSet result = session.execute("SELECT * FROM tabela_exemplo");
        printResults(result);
        result = session.execute("select * from tabela_exemplo where text_id in ('id1', 'id3')");
        printResults(result);
                
        
    }

    public void implementSomeDBqueries(String keyspace){

        //use the referenced keyspace
        ResultSet result = session.execute("USE " + CqlIdentifier.fromCql(keyspace));

        //query 1:
        result = session.execute("SELECT * FROM comments WHERE video = 'Daily Dose of Internet' ORDER BY time DESC LIMIT 3");
        printResults(result);

        //query 2:
        result = session.execute("SELECT * FROM events WHERE video_author='Thomas Eddison' AND video_name='Daily Dose of Internet' AND username = 'Bremmer' ORDER BY datetime DESC LIMIT 5");
        printResults(result);

        //query 3:
        result = session.execute("SELECT username FROM followers where video_name='Daily Dose of Internet' AND video_author='Thomas Eddison'");
        printResults(result);

        //query 4:
        result = session.execute("SELECT * FROM videos WHERE author='Carlo Montana' AND uploads='2021-07-13T14:11:03Z' ALLOW FILTERING");
        printResults(result);
    }

    private void printResults(ResultSet results) {


        System.out.println("----------------------------------------------------------------------------------");
        int size = 100 / results.getColumnDefinitions().size();

        Map<String, String> cols = new LinkedHashMap<>();
        StringBuilder output = new StringBuilder();
        for(ColumnDefinition columnDefinition:results.getColumnDefinitions()) {
            output.append(String.format("%"+size+"s  ", columnDefinition.getName().toString()));
            cols.put(columnDefinition.getName().toString(), columnDefinition.getType().toString());
        }
        System.out.println(output.toString());

        for(Row row:results) {
            for(Map.Entry<String, String> col:cols.entrySet()) {
                StringBuilder outputset = new StringBuilder();
                switch (col.getValue()) {
                    case "TEXT":
                        System.out.print(String.format(
                                "%" + size + "." + size + "s  ", row.getString(col.getKey())
                        ));
                        break;
                    case "TIMESTAMP":
                        System.out.print(String.format(
                                "%" + size + "." + size + "s  ", row.getInstant(col.getKey()).toString()
                        ));
                        break;
                    case "INT":
                        System.out.print(String.format(
                                "%" + size + "d  ", row.getInt(col.getKey())
                        ));
                        break;
                    case "List(TEXT, not frozen)":
                        List<String> list = row.getList(col.getKey(), String.class);
                        outputset = new StringBuilder();
                        for (String s:list) {
                            outputset.append(s);
                            outputset.append("; ");
                        }
                        System.out.print(String.format(
                                "%" + size + "." + size + "s  ", outputset.toString()
                        ));
                        break;
                    case "Set(TEXT, not frozen)":
                        Set<String> set = row.getSet(col.getKey(), String.class);
                        outputset = new StringBuilder();
                        for (String s:set) {
                            outputset.append(s);
                            outputset.append("; ");
                        }
                        System.out.print(String.format(
                                "%" + size + "." + size + "s  ", outputset.toString()
                        ));
                        break;
                    default:
                        System.out.println(col.getValue());
                        System.out.print(String.format("format not recognised!"));
                }
            }
            System.out.println();
        }
    }


    public CqlSession getSession() {
        return this.session;
    }

    public void close() {
        session.close();
    }
}