OBDA Semantika API
==================

This repository presents a working example for developing Semantika application. The demonstration uses JUnit test framework to run the program.

Latest release: [1.7.1 is available!](https://github.com/obidea/semantika-api/releases/tag/v1.7.1) (July 31, 2014)

Learn the Example
-----------------

### Step 1: Download Semantika

[Download the latest distribution package](https://github.com/obidea/semantika-api/releases) and unpack it into your local directory.

```
$ unzip semantika-dist-<version>.zip
```

### Step 2: Get the Example source code

We are going to use some Git commands to get the example source code. Don't worry if you are not familiar with Git, just make sure your computer [has it installed](http://git-scm.com/downloads).

Follow the commands below to add the example code files into the Semantika distribution folder. We have tested using Git 1.8.x:

```
$ cd semantika-dist-<version>
$ git init
$ git remote add origin https://github.com/obidea/semantika-example.git
$ git fetch origin master
$ git reset --hard FETCH_HEAD
```

Note that when you list the directory content, you should see the `example/` folder and other extra files.

### Step 3: Compile the source code

Make sure you have the [Java SDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) in your local system.

```
$ javac -version
javac 1.7.0_45
```

The `example/` folder contains two main test cases for testing "SPARQL Query Answer" and "RDB2RDF Data Export". Compile both source code using the commands below:

```
$ javac -cp .:*:lib/* example/queryanswer/QueryAnswerTest.java
$ javac -cp .:*:lib/* example/rdb2rdf/ExportTest.java
```

(Replace colon `:` with semi-colon `;` for Windows system)

### Step 4: Setup the database

[Please jump to the database installation guide](https://github.com/obidea/semantika-api/tree/master/example#empdb-lite-database) and don't forget to return to this page again when you have done with the installation. Make sure the H2 database is running properly!

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

**Learning highlights**

1. The mapping model. Take a look inside the `model/` folder and open the files inside. Find out more about the syntax [here](https://github.com/obidea/semantika-api/wiki/2.-Basic-RDB-RDF-Mapping) and [here](http://www.w3.org/TR/r2rml/).
2. The `application.cfg.xml` file. The configuration file is the place where you glue everything together (i.e., connection settings, domain model resources and mapping model resources). Find out the parameters [here](https://github.com/obidea/semantika-api/wiki/1.-Semantika-Configuration).
3. The Java code. This is your application code! Check the `example/` folder to study the source code.

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
