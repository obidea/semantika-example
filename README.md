[Learn the examples](https://github.com/obidea/semantika-api/tree/master/example): A quick start to integrate Semantika into your Java application right now!

Download latest: [Semantika Core 1.4](https://github.com/obidea/semantika-api/releases) (Apr 17, 2014)

Check [our Wikipage](https://github.com/obidea/semantika-api/wiki) for a brief introduction, or if you need help please join the [OBDA Semantika discussion group](https://groups.google.com/forum/#!forum/obda-semantika).

API Overview
------------

### System Setup

An instance of ApplicationManager class can be created by loading `application.cfg.xml` in your classpath
([Read our wiki](https://github.com/obidea/semantika-api/wiki/1.-XML-Configuration-File) for more details on
Semantika configuration file).
```java
ApplicationManager manager = new ApplicationFactory()
             .configure("application.cfg.xml")
             .createApplicationManager();
```

### Query Answer

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

### RDB2RDF Export

To enable RDB2RDF data export in your Java application:

```java
IMaterializerEngine exporter = manager.createMaterializerEngine().useNTriples();
exporter.start();
exporter.materialize(fout);
exporter.stop();
```

What's Next?
------------

--

