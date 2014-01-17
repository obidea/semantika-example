RDB-to-RDF Materializer
=======================

An RDB-to-RDF data exporter using Semantika engine. **Download latest**: [v0.6](https://github.com/obidea/semantika-materializer/releases)

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
./semantika materialize -config=configuration.xml -output=fout.n3 -useNTriples
```

Code Examples
-------------

To provide a clear look on how to integrate the materializer in your Java application, please have a look at the
[code example](https://github.com/obidea/semantika-materializer/tree/master/example). The example includes:
* code snippet how to export data using [NTriples][1], [Turtle][2], [RDF/XML][3] and [JSON-LD][4] format,
* a configuration file (i.e., used to define DB connection), and
* a mapping file (i.e., used as data-to-domain model).

All the examples have been tested and successfully run using [H2][5] (v1.3), [MySQL][6] (v5.6) and [PostgreSQL][7] (v9.3)

For the sample data, I used [Employee Sample Database](http://dev.mysql.com/doc/employee/en/index.html) provided freely
at MySQL development site. You can download it from [Launchpad](https://launchpad.net/test-db/) and store locally.

**Note:** The dataset is prepared for MySQL only, thus data migration is required for running the other examples in H2
and PostgreSQL. I used [DBCopy Plugin](http://dbcopyplugin.sourceforge.net/) for
[SQuirreL SQL Client](http://squirrel-sql.sourceforge.net/) for doing the migration.

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
  