package db_cassandra;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        CassandraConnector cassandra = new CassandraConnector("127.0.0.1", 9042, "datacenter1", "cbd_103453_ex2");
        cassandra.close();
    }
}
