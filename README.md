Semantika Code Examples
=======================

This repository contains some working examples to help programming with Semantika API.

Installation
------------

#### Step 1: Download Semantika

[Download the latest distribution package](https://github.com/obidea/semantika-core/releases) and unpack it into your local directory.

```
$ unzip semantika-dist-<version>.zip
```

#### Step 2: Download the source code

We're going to use some Git commands to get the example source code. Don't worry if you are not familiar with Git, just make sure your computer [has it installed](http://git-scm.com/downloads).

Follow the commands below to append the example files into your local Semantika distribution folder. We have them tested using Git 1.8.x:

```
$ cd semantika-dist-<version>
$ git init
$ git remote add origin https://github.com/obidea/semantika-example.git
$ git fetch origin master
$ git reset --hard FETCH_HEAD
```

#### Step 3: Run the sample database

Check in the Semantika directory a folder named `empdb/`. This folder contains a sample Employee data in H2 database. To run the database:

```
$ cd empdb
$ ./h2.sh
```

#### Step 4: Run the examples

Follow the instructions for each example code: [queryanswer](https://github.com/obidea/semantika-example/tree/master/example/junit/queryanswer), [rdb2rdf](https://github.com/obidea/semantika-example/tree/master/example/junit/rdb2rdf) and [emp-app](https://github.com/obidea/semantika-example/tree/master/example/demo).


Code Examples
-------------

#### Query Answering

[Source code for query answering](https://github.com/obidea/semantika-example/blob/master/example/junit/queryanswer/QueryAnswerTest.java) shows you how we setup the `ApplicationManager` and then getting the `QueryEngine` to start the SPARQL query answering service. It contains 9 sample queries to show you what are the SPARQL features that are currently supported by Semantika.

#### RDB2RDF Export

[Source code for RDB2RDF export](https://github.com/obidea/semantika-example/blob/master/example/junit/rdb2rdf/ExportTest.java) shows you how we setup the `ApplicationManager` and then getting the `MaterializerEngine` to start data export service. The code gives you 4 format flavours: NTriples, Turtle, RDF/XML and RDF/JSON.

#### Progammatic Configuration

[Source code EmployeeApp](https://github.com/obidea/semantika-example/blob/master/example/demo/EmployeeApp.java) shows you how to setup the `ApplicationManager` using programmatic configuration. This is a simple query answer application where you can type freely any SPARQL query to be evaluated against the underlying database.

What to Learn?
--------------

These examples demonstrate how Semantika can seamlessly connect to a relational database and answers SPARQL queries based on the semantic mapping model provided by users. There are three main parts that you need to learn:

1. The mapping model. Take a look inside the `model/` folder and study how mapping modelling works. Find out more about the syntax [here](https://github.com/obidea/semantika-core/wiki/2.-Basic-RDB-RDF-Mapping) and [here](http://www.w3.org/TR/r2rml/).
2. The `application.cfg.xml` file. The configuration file is the place where you glue everything together (i.e., connection settings, domain model resources and mapping model resources). Find out the parameters [here](https://github.com/obidea/semantika-core/wiki/1.-Semantika-Configuration).
3. The Java code. This is your application code! Check the `example/` folder and study the source code.


Looking for the Source Code?
----------------------------

[The Semantika API source code is distributed under Apache License 2.0 and it is available here.](https://github.com/obidea/semantika-core)

Need Help?
----------
Please go through [our user guide](https://github.com/obidea/semantika-core/wiki) to read some specification details about the system, or if you have any questions, please post them to [OBDA Semantika discussion group](https://groups.google.com/forum/#!forum/obda-semantika) and we are ready to give you a hand.
