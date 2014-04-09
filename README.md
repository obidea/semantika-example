[Learn the examples](https://github.com/obidea/semantika-api/tree/master/example): A quick start to integrate Semantika into your Java application right now!

Download latest: [Semantika Core 1.3](https://github.com/obidea/semantika-api/releases) (Apr 9, 2014)

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
   IQueryResult result = queryEngine.createQuery(sparql).setFirstResult(offset).setMaxResults(limit).evaluate();
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

The upcoming 1.4 will revisit the SPARQL OPTINAL statement:

* **Multiline OPTIONAL**. The Query engine will be able to execute more advanced query using OPTIONAL keyword.
```
 SELECT ?x ?propA ?propB ?propC
 WHERE {
   ?x :hasPropertyA ?propA
   OPTIONAL {
     ?x :hasPropertyB ?propB;
        :hasPropertyY ?y .  
     ?y :hasPropertyC ?propC    
   }
 }
```

* **Nested OPTIONAL**. The Query engine will be able to execute more advanced query using OPTIONAL keyword.
```
 SELECT ?x ?propA ?propB ?propC ?propD ?propE
 WHERE {
   ?x :hasPropertyA ?propA
   OPTIONAL {
     ?x :hasPropertyB ?propB;
        :hasPropertyY ?y .  
     ?y :hasPropertyC ?propC
     OPTIONAL {
        ?y :hasPropertyD ?propD;
           :hasPropertyE ?propE
     }    
   }
 }
```

Q & A
-----

Some of you may have wondered about the missing source code of Semantika. That is true
the source code is not here. The files are still in my private repository and I haven't
published them yet. I decided to keep the code privately because there are still many
code refactors and it can be unpleasant for those who want to study the code. However,
I will remain to my initial purpose to make it open source and will be soon published.
So stay tune!

