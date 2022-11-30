# Rules for delivering Lab 3

Be careful, not following the rules might cause your submission not to be picked up by some of our scripts.

## Exercise 2
Delivery for Ex.2 must consist of at least 3 files:
These files must be runnable as is.

### Keyspace
You will be responsible for creating you own `KEYSPACE` following this naming convention `cbd_<NMEC>_ex2` and `cbd_<NMEC>_ex4`.
Your scripts must explicitly use your keyspace: `USE cbd_<NMEC>_ex2;`

For example:
```
CREATE KEYSPACE IF NOT EXISTS cbd_46268_ex2 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE cbd_46268_ex2;
```

### Files

* `CBD_<NMEC>_EX2_DDL.cql`

Must contain all the tables and indexes creation.


* `CBD_<NMEC>_EX2_SEEDDATA.cql`

Must contain all the insert calls for seed data

* `CBD_<NMEC>_EX2_QUERIES.cql`

The queries from all the exercice, separated by comments as shown in the example.
Don't need to include the output. Feel free to add additional comments.    

For example:
```
-- EX:C:7
SELECT * FROM ...;
-- EX:C:8
SELECT * FROM ...;
-- EX:C:9
SELECT * FROM ...;

-- EX:D:1
SELECT ...;
-- EX:D:2
...
```

Additionally, you must include a separate json file for each table with the json results from queries in Ex.2b)
* `CBD_<NMEC>_EX2_<tablename>.json`

### Other Remarks

The `<NMEC>` and `<tablename>` in the description above must be replaced by your MEC Number and table names respectively.
For instance, `CBD_12345_EX2_videos.json`.

## Exercise 3

You must deliver your codebase as in the previous labs. Create a separate project for this exercice.

This exercise must re-use the same database created in the EX2.

## Exercise 4

Follow the same guidelines of EX2. Make sure you update the exercise number in the file headers.

## Exercise 5

Follow the same guidelines of EX2. Make sure you update the exercise number in the file headers.