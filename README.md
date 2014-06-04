Learn the Example
-----------------

### Step 1: Download Semantika

Please download the latest distribution package and unpack it into your local directory.

```
$ unzip semantika-dist-<version>.zip
```

### Step 2: Prepare the database

[Please jump to this page and follow the installation guide to prepare the example database](https://github.com/obidea/semantika-api/tree/master/example#empdb-lite-database). Return to this page again when you have finished the installation and make sure the H2 server is running.

### Step 3: Get the examples

We are going to use commands in [Git](http://git-scm.com/downloads) so make sure your system has Git already installed. To download the examples, we are *not* going to use `git clone` but instead we are going to use `git fetch` and add the examples immediately into Semantika distribution folder. The commands below have been tested using Git 1.8.x

```
$ cd semantika-dist-<version>
$ git init
$ git remote add origin https://github.com/obidea/semantika-api.git
$ git fetch origin master
$ git reset --hard FETCH_HEAD
```

Now if you do `ls` (or `dir` in Windows), you will see the example folder and other extra files from this repository.

### Step 4: Compile the examples

To compile the examples you will need [Java SDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) in your local system. 

The example folder consists of two main examples for testing the "SPARQL Query Answer" feature and "RDB2RDF Data Export" feature.

```
$ javac -cp .:*:lib/* example/queryanswer/QueryAnswerTest.java
$ javac -cp .:*:lib/* example/rdb2rdf/ExportTest.java
```

**Note**: Replace colon `:` with semi-colon `;` for Windows system.

### Step 5: Run the examples

* The first example is to test the "SPARQL Query Answer" feature. We have prepared some SPARQL tests inside the example file about employees profile (e.g., names, salary, department, etc.). The result of the test will display the SPARQL query along with the total number of returned data.

```
$ java -cp .:*:jdbc/*:lib/* org.junit.runner.JUnitCore example.queryanswer.QueryAnswerTest
```

* The second example is to test the "RDB2RDF Data Export" feature. The result of this run is four RDF files where each represents different export format (i.e., NTriples, Turtle, XML and JSON-LD).
```
$ java -cp .:*:jdbc/*:lib/* org.junit.runner.JUnitCore example.rdb2rdf.ExportTest
```

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

Need Help?
----------
Please go through [our user guide](https://github.com/obidea/semantika-api/wiki) to understand better the system, or if you have questions, please join the [OBDA Semantika discussion group](https://groups.google.com/forum/#!forum/obda-semantika) and we are ready to help.
