-- EX:B

-- comments:
SELECT json * FROM comments;

-- events:
SELECT json * FROM events;

-- followers:
SELECT json * FROM followers;

-- rating:
SELECT json * FROM rating;

-- users:
SELECT json * FROM users;

-- videos:
SELECT json * FROM videos;

 --------------------- done -------------------------

-- EX:C:7
SELECT * FROM videos WHERE author='Thomas Eddison';

-- EX:C:8
SELECT * FROM comments1 WHERE author='Elsip' ORDER BY time DESC;

-- EX:C:9
SELECT * FROM comments WHERE video='Daily Dose of Internet' ORDER BY time DESC;

-- EX:C:10
SELECT avg(score) as average_score FROM rating WHERE video_name='Daily Dose of Internet';



-- EX:D:1
SELECT * FROM comments WHERE video = 'Daily Dose of Internet' ORDER BY time DESC LIMIT 3;

-- EX:D:2
SELECT tags FROM videos WHERE name = 'Daily Dose of Internet' AND author = 'Thomas Eddison';

-- EX:D:3
SELECT * FROM videos WHERE tags CONTAINS 'Aveiro';

-- EX:D:4
SELECT * FROM events WHERE video_author='Thomas Eddison' AND video_name='Daily Dose of Internet' AND username = 'Bremmer' ORDER BY datetime DESC LIMIT 5;

-- EX:D:5
SELECT * FROM videos WHERE author='Carlo Montana' AND uploads='2021-07-13T14:11:03Z' ALLOW FILTERING;

-- EX:D:6
-- Não é possível executar este query, pois normalmente é sempre necessário especificar as primary keys, nao sendo portanto, fazivel para este query.

-- EX:D:7
SELECT username FROM followers where video_name='Daily Dose of Internet' AND video_author='Thomas Eddison';

-- EX:D:8
-- Seria necessário agregar as tabelas de comments e de followers, o que não é permitido em Cassandra, pelo que se torna impossível de concretizar esta query.

-- EX:D:9
-- Não é possível obter os 5 videos com maior rating pois é necessário específicar sempre um video, com as chaves primarias da tabela onde se insere a informacao

-- EX:D:10
-- Embora seja possível listar todos os videos da tabela videos, não é possivel ordernar a mesma de forma especifica, sem especificar tambem as suas chaves.

-- EX:D:11
-- Não é possivel.

-- EX:D:12
SELECT ...;

-- EX:D:13
SELECT ...;