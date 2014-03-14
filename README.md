Learn the examples: A practical guide to start integrating Semantika Core Framework into your Java
application right now!

Download latest: [Semantika Core 1.1](https://github.com/obidea/semantika-api/releases/download/v1.1/semantika-core-1.1.jar) (Feb 25, 2014)

Check [our Wikipage](https://github.com/obidea/semantika-api/wiki) for a brief introduction.
Need help? Join [OBDA Semantika Forum](https://groups.google.com/forum/#!forum/obda-semantika).

System Setup
------------

An instance of ApplicationManager class can be created by loading `configuration.xml` in your classpath
(See [wiki](https://github.com/obidea/semantika-api/wiki/1.-XML-Configuration-File) for more details on
Semantika configuration file).
```java
ApplicationManager manager = new ApplicationFactory()
             .configure("configuration.xml")
             .createApplicationManager();
```

Query Answer
------------

To enable query answer in your Java application:
```java
IQueryEngine queryEngine = manager.createQueryEngine(); 
queryEngine.start();
IQueryResult result = queryEngine.evaluate(sparql);
// do something with the result
// ...
queryEngine.stop();
```

In addition, the "extended" query engine allows you to create result paging for efficient data retrieval:

```java
IQueryEngineExt queryEngine = manager.createQueryEngine();
queryEngine.start();
int offset = 0;
int limit = 100;
int maxPage = 10;
int pageNum = 1;
while (pageNum <= maxPage) {
   IQueryResult result = queryEngine.createQuery(sparql)
                                    .setFirstResult(offset)
                                    .setMaxResults(limit).evaluate();
   // do something with the result
   // ...
   offset += limit;
   pageNum++;
}
queryEngine.stop();
```

RDB2RDF Export
--------------

To enable RDB2RDF data export in your Java application:

```java
IMaterializerEngine exporter = manager.createMaterializerEngine().useNTriples();
exporter.start();
exporter.materialize(fout);
exporter.stop();
```

What's Next?
------------

The upcoming 1.2 has several exciting features to come:

* Add support to datatype-able term map in mapping language to generate typed literals.
Usually the datatype of literals are automatically determined based on the SQL datatype
of the underlying logical table column. With the new sytax `rr:datatype` users can 
explicitly override the type and the system will produce a datatype-override RDF literal.

* More support on SPARQL built-in functions: `BOUND`, `LANG`, `LANGMATCHES` and `REGEX`.


Q & A
-----

Some of you may have wondered about the missing source code of Semantika. The truth is
the code is still in my private repository. I decided to keep the code privately because
there are many refactors still happening and this situation can be unpleasant for those
who want to study the code. However, I will remain to my true intention to make it open
source and it will soon be published. In the meantime, your feedback is the most valuable
matter that I wish to receive.

