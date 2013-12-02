Employees App
=============

A showcase example of Employees application. More extra features are added in the configuration and
mapping file. The showcase presents two distinct settings:
* Exclude ontology source, and
* Include ontology source.

Configuration Files
===================

* *configuration1.xml* omits the `<ontology-source>` element. The system won't make any deduction or
  inference during its pre-processing. Notice that the strict-parsing option is disabled.

* *configuratoin2.xml* includes the `<ontology-source>` element. The system will add its deductions
  to the end result.

Mapping File
============

The example has eight mappings that highlight the syntax feature of the mapping language:

* **TriplesMap1**
  Simple and most standard use to define the RDB-to-RDF mappings (or shortly, R/R mappings).

* **TriplesMap2**
  The `rr:template` attribute can recognize some standard URI format used by Linked Data projects.
  Some of which that are supported are DBPedia (`+dbpedia`), YAGO (`+yago`) and LastFM (`+lastfm`).

* **TriplesMap3**, **TriplesMap4**
  Users can write a *valid SQL query* for the logical table. However, [some limitations]
  (https://github.com/obidea/semantika-materializer/wiki/2.2-&lt;logical&minus;table&gt;)
  are applied.

* **TriplesMap5**
  Put a comment for describing the mappings using `<comment>...</comment>`

* **TriplesMap6**
  Use multiple lines when writing the comments for readability.

* **TriplesMap7**
  Create a property mapping between two objects.

* **TriplesMap8**
  Use `rr:class` to specifically identify the class type used in the property's domain.

Data Source
===========

The showcase uses Employees-Lite dataset. The data is a subset of [Employees Sample Database](http://dev.mysql.com/doc/employee/en/index.html).
