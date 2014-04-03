## Run the Examples

The examples above run as JUnit tests. If you are familiar with Eclipse, you can clone and import this project to Eclipse and run the JUnit tests. However in this tutorial, I'm going to show how to run the examples via the command lines.

**Step 1: Prepare the database**

If you haven't done this before [please jump to this page and follow the installation guide](https://github.com/obidea/semantika-api/tree/master/example#empdb-lite-database). Then return to this section later when you have finished. Make sure the H2 server is running.

**Step 2: Get the project**

There are two ways to download the content of this project: (1) Using Git or (2) Download the ZIP.

* Using Git
```
git clone https://github.com/obidea/semantika-api.git
```

* [Download the ZIP](https://github.com/obidea/semantika-api/archive/master.zip) and unzip it.


**Step 3: Compile the tests**

To compile the project you need to have Java SDK 6 or 7 installed in your local system. 

The project consists of two main examples to test the QueryAnswer module and RDB2RDF module. I'm going to show you how to compile both examples respectively. In the project root directory type commands:
```
$ javac -cp .:lib/* example/queryanswer/QueryAnswerTest.java
$ javac -cp .:lib/* example/rdb2rdf/ExportTest.java
```

Or in Windows
```
> javac -cp .;lib\* example\queryanswer\QueryAnswerTest.java
> javac -cp .;lib\* example\rdb2rdf\ExportTest.java
```

**Step 4: Run the tests**

* The first run is to test the QueryAnswer module. The output is the returned number of rows for a given SPARQL query.
```
$ java -cp .:jdbc/h2-1.3.174.jar:lib/* org.junit.runner.JUnitCore example.queryanswer.QueryAnswerTest
```
Or in Windows
```
> java -cp .;jdbc\h2-1.3.174.jar;lib\* org.junit.runner.JUnitCore example.queryanswer.QueryAnswerTest
```

* The second run is to test the QueryMaterialization module. The output is a RDF file for a given export format.
```
$ java -cp .:jdbc/h2-1.3.174.jar:lib/* org.junit.runner.JUnitCore example.rdb2rdf.ExportTest
```
Or in Windows
```
> java -cp .;jdbc\h2-1.3.174.jar;lib\* org.junit.runner.JUnitCore example.rdb2rdf.ExportTest
```

## EMPDB-Lite Database

All examples use `empdb` database that you can [download here](https://github.com/obidea/semantika-api/releases/download/v1.1/h2-semantika_24-02-2014.zip).
The database is a modified work from the original [Employees DB from MySQL site](http://dev.mysql.com/doc/employee/en/employees-introduction.html). It
contains dummy data about company workers stored in 6 separate tables.


### Installation

The `empdb` database is available in H2 engine. To use the database, download the zip and unpack it:

```
$ cd path/to/h2-semantika
$ ./h2.sh
```
Or in Windows
```
> cd path\to\h2-semantika
> h2.bat
```

The database engine will start immediately and a localhost page will appear in your default browser. Connect to the database by using the configuration below.

```
Driver class: org.h2.Driver
JDBC URL: jdbc:h2:tcp://localhost/empdb
User Name: sa
Password: (blank)
```


### Database Structure

The following diagram provides an overview of the structure of the `empdb` database.

![](https://raw.github.com/obidea/semantika-api/master/model/empdb.erd.png)


### Change Log

* **24-02-2014**: Update column with `NULL` value with command as follows (1294 rows were affected).
  ```
UPDATE empdb.employees SET hire_date = NULL WHERE birth_date < "1952-06-01"
```

* **22-11-2013**: Modify the data schema from the original by removing column `from_date` and `to_date`. I also trimmed the number
of employees by only saving employee ID from 10001 to 60000, giving a end total of 50,000 rows of employees data.
