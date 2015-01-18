README
======

Compile the Code
----------------

Make sure you have the [Java SDK 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) in your local system.

```
$ javac -version
javac 1.7.0_45
```

Run the `javac` command from the root directory.

```
$ pwd
path/to/semantika-dist-<version>
$ javac -cp .:*:lib/* example/junit/rdb2rdf/ExportTest.java
```

Run the Code
------------

Run the `java` command from the root directory.

```
$ java -cp .:*:jdbc/*:lib/* org.junit.runner.JUnitCore example.junit.rdb2rdf.ExportTest
```

Troubleshooting
---------------

* Ignore these warning lines when runnning the examples. These messages come from the [R2RML parser](https://github.com/johardi/jr2rml-parser) and have no harm.

```
Could not find DatatypeHandler : org.openrdf.rio.datatypes.xmlschema
Could not find DatatypeHandler : org.openrdf.rio.datatypes.rdf
Could not find DatatypeHandler : org.openrdf.rio.datatypes.dbpedia
Could not find DatatypeHandler : org.openrdf.rio.datatypes.virtuosogeometry
Could not find DatatypeHandler : org.openrdf.rio.datatypes.geosparql
Could not find LanguageHandler : org.openrdf.rio.languages.RFC3066
```

* If you're in Windows environment then replace the colon sign `:` with a semi-colon `;` in the `javac` and `java` commands.