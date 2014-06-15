Learn the Example
-----------------

### Step 1: Download Semantika

[Download the latest distribution package](https://github.com/obidea/semantika-api/releases) and unpack it into your local directory.

```
$ unzip semantika-dist-<version>.zip
```

### Step 2: Prepare the database

If you haven't done this before, [please follow the sample database installation guide here](https://github.com/obidea/semantika-api/tree/master/example#empdb-lite-database) and return to this page again after you have completed the installation. Make sure the H2 server is running.

### Step 3: Get the examples

To get the example code, we are going to use some commands in [Git](http://git-scm.com/downloads) so make sure your system has Git already installed.

Now we are going to do something different. We are *not* going to use `git clone` as usual and getting the whole branches of this repository. But instead we are going to use `git fetch` to get *only* the example code and append the files immediately into Semantika distribution folder.

The commands below have been tested using Git 1.8.x:

```
$ cd semantika-dist-<version>
$ git init
$ git remote add origin https://github.com/obidea/semantika-api.git
$ git fetch origin master
$ git reset --hard FETCH_HEAD
```

Now if you type `ls` (or `dir` in Windows), you will see the `example/` folder and other extra files have been added properly. You still can use command `git pull` to update any future changes in the example code.

### Step 4: Compile the examples

To compile the examples you will need [Java SDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) in your local system. 

The `example/` folder contains two main test cases for testing "SPARQL Query Answer" and "RDB2RDF Data Export" feature. Use the commands below to start compiling the source code.

```
$ javac -cp .:*:lib/* example/queryanswer/QueryAnswerTest.java
$ javac -cp .:*:lib/* example/rdb2rdf/ExportTest.java
```

**Note**: Replace colon `:` with semi-colon `;` for Windows system.

### Step 5: Run the examples

The first example is to test "SPARQL Query Answer" feature. We have prepared some SPARQL queries about employee's profile (e.g., name, salary, department, etc.). The test will display the total number of returned data and the associated SPARQL query.

```
$ java -cp .:*:jdbc/*:lib/* org.junit.runner.JUnitCore example.queryanswer.QueryAnswerTest
```

The second example is to test "RDB2RDF Data Export" feature. The test will produce four RDF files in different export format (i.e., NTriples, Turtle, XML and JSON-LD).
```
$ java -cp .:*:jdbc/*:lib/* org.junit.runner.JUnitCore example.rdb2rdf.ExportTest
```

What Next?
----------

The examples above have demonstrated how Semantika can seamlessly connect to a relational database and answers SPARQL queries based on the semantic mapping model provided by users. In addition, Semantika will include a reasoning step if a domain model (i.e., an OWL ontology) is presented.

**Be pragmatic!**

To know better the system, you need to understand the concept of semantic mapping model. It's simple BTW. The mappings are just a specification about how your data (in database) has a certain meaning in your domain application.
* Go inside the `model/` folder and take a look at the [bsbm.mod.ttl](https://github.com/obidea/semantika-api/blob/master/model/empdb.mod.ttl) file (or alternatively [bsbm.mod.xml](https://github.com/obidea/semantika-api/blob/master/model/empdb.mod.xml)).
* Read some resources about [R2RML](http://www.w3.org/TR/r2rml/) or [TERMAL/XML](https://github.com/obidea/semantika-api/wiki/2.-Basic-RDB-RDF-Mapping). Once you have mastered one of them, the other is just easy as pie. *Well, they both are similar!* :)

Once you passed the mapping model, the rest is easy!
* Configuration file. The configuration file is the place where you set everything altogether (i.e., connection settings, domain model resources and mapping model resources). [See example](https://github.com/obidea/semantika-api/blob/master/example/queryanswer/application.cfg.xml).
* Java code. This is the part where you add some few lines of Semantika code for your semantic application. [See example](https://github.com/obidea/semantika-api/blob/master/example/queryanswer/QueryAnswerTest.java).

Troubleshooting
---------------

* Ignore these warning lines when runnning the examples. These messages come from the [R2RML parser](https://github.com/johardi/jr2rml-parser) and have no harm to the overall system.

```
Could not find DatatypeHandler : org.openrdf.rio.datatypes.xmlschema
Could not find DatatypeHandler : org.openrdf.rio.datatypes.rdf
Could not find DatatypeHandler : org.openrdf.rio.datatypes.dbpedia
Could not find DatatypeHandler : org.openrdf.rio.datatypes.virtuosogeometry
Could not find DatatypeHandler : org.openrdf.rio.datatypes.geosparql
Could not find LanguageHandler : org.openrdf.rio.languages.RFC3066
```

Looking for the Source Code?
----------------------------

[The source code is distributed under Apache License 2.0 and it is available here.](https://github.com/obidea/semantika-core)

Need Help?
----------
Please go through [our user guide](https://github.com/obidea/semantika-api/wiki) to read some specification details about the system, or if you have any questions, please post them to [OBDA Semantika discussion group](https://groups.google.com/forum/#!forum/obda-semantika) and we are ready to give you a hand.
