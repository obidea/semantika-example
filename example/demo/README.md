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
$ javac -cp .:*:lib/* example/demo/EmployeeApp.java
```

Run the Code
------------

Run the `java` command from the root directory.

```
$ java -cp .:*:lib/*:jdbc/* example.demo.EmployeeApp
```

Troubleshooting
---------------

* If you're in Windows environment then replace the colon sign `:` with a semi-colon `;` in the `javac` and `java` commands.