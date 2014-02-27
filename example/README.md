## Example Database

All examples use `empdb` database that you can [download here](https://github.com/obidea/semantika-api/releases/download/v1.1/h2-semantika_24-02-2014.zip).
The database is a modified work from the original [Employees DB from MySQL site](http://dev.mysql.com/doc/employee/en/employees-introduction.html). It
contains dummy data about company workers stored in 6 separate tables.


### Installation

The `empdb` database is available in H2 engine. To use the database, download the zip and unpack it:

```
$ cd path/to/h2-semantika/
$ ./h2.sh
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
