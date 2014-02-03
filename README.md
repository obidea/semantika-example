Semantika API
=============

A practical guide to integrate Semantika Core Framework in your Java application!

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
   IQueryResult result = queryEngine.createQuery(sparql).setFirstResult(offset).setMaxResults(limit).evaluate();
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