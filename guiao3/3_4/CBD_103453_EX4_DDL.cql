create keyspace cbd_103453_ex4 with replication = {'class' : 'SimpleStrategy', 'replication_factor' : '1'} and durable_writes = true;
use cbd_103453_ex4;

// creating tables - 4 tabelas:
CREATE TABLE IF NOT EXISTS cidade(name text, moeda text, country text, primary key((name, country)));
CREATE TABLE IF NOT EXISTS paises(name text, description text, continent text, primary key((name, continent)));
CREATE TABLE IF NOT EXISTS prato(name text, pais text, primary key((name, pais)));
CREATE TABLE IF NOT EXISTS tourism(type text, region text, description text, primary key((type, region)));

// indexes:
CREATE INDEX IF NOT EXISTS ON tourism (type) ;
CREATE INDEX IF NOT EXISTS ON paises (description) ;
 