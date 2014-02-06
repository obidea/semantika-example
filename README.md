Semantika API
=============

Learn the examples: A practical guide to start integrating Semantika Core Framework in your Java application right now!

Download latest release: [Semantika Core 1.0](https://github.com/obidea/semantika-api/releases/download/v1.0/semantika-core-1.0.jar)

Download extra: [Employee DB (empdb)](https://github.com/obidea/semantika-api/releases/download/v1.0/h2-semantika.zip)

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