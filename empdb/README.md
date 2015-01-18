EMPDB-Lite Database
-------------------

This is the sample database used to run all the example code. This database is a modified work from the original Employees DB from
MySQL site ([link](http://dev.mysql.com/doc/employee/en/employees-introduction.html)). It contains dummy data about company workers
stored in 6 tables.

### Installation

The `empdb` database is available in H2 engine. To run the database:
```
$ cd path/to/empdb
$ ./h2.sh
```

The database engine will start immediately and a localhost page will appear in your default browser. Connect to the database by using the configuration below.

```
Driver class: org.h2.Driver
JDBC URL: jdbc:h2:tcp://localhost/data/empdb
User Name: sa
Password: (blank)
```

### Database Structure

The following diagram provides an overview of the structure of the `empdb` database.

![](https://raw.github.com/obidea/semantika-example/master/empdb/empdb.erd.png)


### Change Log

* **17-01-2015**: Update the H2 engine to version 1.4.185 (2015-01-16).

* **24-02-2014**: Update column with `NULL` value with command as follows (1294 rows were affected).
  ```
UPDATE empdb.employees SET hire_date = NULL WHERE birth_date < "1952-06-01"
```

* **22-11-2013**: Modify the data schema from the original by removing column `from_date` and `to_date`. I also trimmed the number
of employees by only saving employee ID from 10001 to 60000, giving a end total of 50,000 rows of employees data.
