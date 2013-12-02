Employees App
=============

A showcase in Employees application test. More extra features are added in the configuration and
mapping file. The showcase presents two test cases in which we compare the materialization
results to illustrate Semantika inference capability.

Both test cases use the same mapping source and table data. However, the configuration files are
slightly different:

* *configuration1.xml* omits the `<ontology-source>` element. The system won't make any inference 
  during its input processing. Notice the `strict-parsing` option is disabled.

* *configuratoin2.xml* includes the `<ontology-source>` element. The inclusion enables system to 
  make inference which add extra triples to the end result.

Mapping File
============

Each test case has eight mappings that highlight the syntax feature of the mapping language:

* **TriplesMap1**
  
  Simple and most standard use to define the RDB-to-RDF mappings (or shortly, R/R mappings).

* **TriplesMap2**
  
  The `rr:template` attribute can recognize some standard URI format used by Linked Data projects.
  Some of which that are supported are DBPedia (`+dbpedia`), YAGO (`+yago`) and LastFM (`+lastfm`).

* **TriplesMap3**, **TriplesMap4**
  
  Users can write a *valid SQL query* for the logical table. Please note [some limitations]
  (https://github.com/obidea/semantika-materializer/wiki/2.2-&lt;logical&minus;table&gt;)
  that may applied.

* **TriplesMap5**
  
  Put comments for describing the mapping using `<comment>...</comment>`

* **TriplesMap6**
  
  Use multiple lines when writing the comments for readability.

* **TriplesMap7**
  
  Create a mapping for describing objects relationship. In OWL, it's called *object property*.

* **TriplesMap8**
  
  Use `rr:class` to specifically identify the class type used in the property.

Data Source
===========

The showcase uses Employees-Lite dataset. The data is a subset of [Employees Sample Database](http://dev.mysql.com/doc/employee/en/index.html).
