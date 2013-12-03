RDB-to-RDF Materializer
=======================

An RDB-to-RDF data exporter using Semantika engine. Download latest: [v0.5-alpha](https://github.com/obidea/semantika-materializer/releases)

Java API
--------

Code the materializer directly inside your Java application:

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

Or, just run the materializer to get things done immediately!

```
./semantika materialize -config=... -output=... -useNTriples
```

Code Examples
-------------

The [code examples](https://github.com/obidea/semantika-materializer/tree/master/example) include:
* How to export data to [NTriples][1] format,
* How to export data to [Turtle][2] format,
* How to export data to [RDF/XML][3] format,
* How to export data to [JSON-LD][4] format.

All the examples have been tested and successfully run using [H2][5] (1.3), [MySQL][6] (5.6) and [PostgreSQL][7] (9.3)

For the sample data, I used [Employee Sample Database](http://dev.mysql.com/doc/employee/en/index.html) provided freely
in MySQL development site. You can download it from [Launchpad](https://launchpad.net/test-db/).

**Note:** The dataset is prepared for MySQL, thus data migration is required for running the other examples in H2 and 
PostgreSQL. I use [DBCopy Plugin](http://dbcopyplugin.sourceforge.net/) for SQuirreL SQL Client to do the migration.

Wiki
----

Please visit https://github.com/obidea/semantika-materializer/wiki

  [1]: http://www.w3.org/TR/n-triples/   "W3C recommendation on NTriples syntax"
  [2]: http://www.w3.org/TR/turtle/   "W3C recommendation on Turtle syntax"
  [3]: http://www.w3.org/TR/rdf-syntax-grammar/   "W3C recommendation on RDF/XML syntax"
  [4]: http://www.w3.org/TR/json-ld/   "W3C recommendation on JSON-LD syntax"
  [5]: http://www.h2database.com/   "H2 site"
  [6]: http://www.mysql.com/   "MySQL site"
  [7]: http://www.postgresql.org/   "PostgreSQL site"


