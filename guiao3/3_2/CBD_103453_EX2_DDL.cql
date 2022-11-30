// creating the keyspace:

create keyspace cbd_103453_ex2 with replication = {'class' : 'SimpleStrategy', 'replication_factor' : '1'} and durable_writes = true;

// using that keyspace:

use cbd_103453_ex2;

// creating tables:

-- Users:
create table if not exists users(username text PRIMARY KEY, name text, email text, time_regist timestamp);

-- Videos:
create table if not exists videos(author text, name text, description text, tags list<text>, uploads timestamp, primary key((author, name), uploads)) WITH CLUSTERING ORDER BY (uploads DESC);

-- Comentarios - para ambas as queries: (not sure if right)
-- criadas 2 tabelas para permitir a pesquisa personalizada

CREATE TABLE if NOT EXISTS comments1(video_author text, video text, comment text, time timestamp, author text, primary key((author), time)) WITH CLUSTERING ORDER BY (time DESC);
CREATE TABLE if NOT EXISTS comments(video_author text, video text, comment text, time timestamp, author text, primary key((video), time)) WITH CLUSTERING ORDER BY (time DESC);

-- Seguidores:
CREATE TABLE if NOT EXISTS followers(username text, video_name text, video_author text, primary key ((video_name, video_author), username));

-- Eventos:
CREATE TABLE if NOT EXISTS events(video_author text, video_name text, username text, type text, time text, datetime timestamp, primary key((video_author, video_name, username), datetime));

-- Rating:
CREATE TABLE if NOT EXISTS rating(video_author text, video_name text, score int, author text, primary key (author, video_name)); 


CREATE INDEX ON videos (tags) ;

-- pesquisa de todos os videos de determinado autor:
CREATE INDEX IF NOT EXISTS ON videos (author);

-- pesquisa do rating medio de um video e quantas vezes foi votado.
CREATE INDEX IF NOT EXISTS ON rating (video_name);
 