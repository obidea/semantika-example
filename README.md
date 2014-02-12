Semantika API
=============

Learn the examples: A practical guide to start integrating Semantika Core Framework into your Java application right now!

Download the API: [Semantika Core 1.0](https://github.com/obidea/semantika-api/releases/download/v1.0/semantika-core-1.0.jar)

Check [our Wikipage](https://github.com/obidea/semantika-api/wiki) for a brief introduction.
Need help? Join [OBDA Semantika Forum](https://groups.google.com/forum/#!forum/obda-semantika).

Query Answer
------------

To enable query answer in your Java application:

```java
ApplicationManager manager = new ApplicationFactory()
      .configure("configuration.xml")
      .createApplicationManager();
      
IQueryEngine queryEngine = mAppManager.createQueryEngine();
queryEngine.start();
IQueryResult result = queryEngine.evaluate(sparqlString);
// do something with the result
// ...
queryEngine.stop();
```

In addition, an "extended" query engine supports paging and your application can be written:

```java
ApplicationManager manager = new ApplicationFactory()
      .configure("configuration.xml")
      .createApplicationManager();
      
IQueryEngineExt queryEngine = mAppManager.createQueryEngine(); // use IQueryEngineExt
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
ApplicationManager manager = new ApplicationFactory()
      .configure("configuration.xml")
      .createApplicationManager();
      
IMaterializerEngine materializer = manager.createMaterializerEngine().useNTriples();
materializer.start();
materializer.materialize(fileOut);
materializer.stop();
```

What's Next?
------------

The upcoming 1.1 has several exciting features to come:

* Implement QueryReducer that will minimize the number of joins in the final SQL production,
resulting faster query execution.

* Support SPARQL OPTIONAL keyword in input query.

* Support datatype-able term map in mapping language to generate typed literals. Usually
the datatype of literals are automatically determined based on the SQL datatype of the
underlying logical table column. With the new sytax `rr:datatype` users can explicitly
override the type and the system will produce a datatype-override RDF literal.