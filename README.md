RDB-to-RDF Materializer
=======================

An RDB-to-RDF materializer using Semantika engine.

Java API
--------

Code directly within your Java application:

```java
ApplicationManager manager = new ApplicationFactory()
      .configure("configuration.xml")
      .createApplicationManager();
      
// Create the materializer engine and use NTriples as the output format.
MaterializerEngine materializer = manager.createMaterializerEngine().useNTriples();
materializer.start();
materializer.materialize(fout);
materializer.stop();
```

Command-line Tool
-----------------

Or, run the materializer immediately to get things done!

```
semantika materialize -config=... -output=... -useNTriples
```

Code Examples
-------------

The [code examples](https://github.com/obidea/semantika-materializer/tree/master/example) include:
* How to materialize in [NTriples][1] format,
* How to materialize in [Turtle][2] format,
* How to materialize in [RDF/XML][3] format,
* How to materialize in [JSON-LD][4] format.

All the examples have been tested using [H2][5] (1.3), [MySQL][6] (5.6) and [PostgreSQL][7] (9.3)

The examples above are using [Employee Sample Database](http://dev.mysql.com/doc/employee/en/index.html) provided in MySQL development site
which can be downloaded from [Launchpad](https://launchpad.net/test-db/).

**Note:** The dataset is prepared for MySQL, thus data migration is required for running the examples in H2 and PostgreSQL. I use 
[DBCopy Plugin](http://dbcopyplugin.sourceforge.net/) for SQuirreL SQL Client to do the migration.

  [1]: http://www.w3.org/TR/n-triples/   "W3C recommendation on NTriples syntax"
  [2]: http://www.w3.org/TR/turtle/   "W3C recommendation on Turtle syntax"
  [3]: http://www.w3.org/TR/rdf-syntax-grammar/   "W3C recommendation on RDF/XML syntax"
  [4]: http://www.w3.org/TR/json-ld/   "W3C recommendation on JSON-LD syntax"
  [5]: http://www.h2database.com/   "H2 site"
  [6]: http://www.mysql.com/   "MySQL site"
  [7]: http://www.postgresql.org/   "PostgreSQL site"


