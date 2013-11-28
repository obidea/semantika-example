package example.h2;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.obidea.semantika.app.ApplicationFactory;
import com.obidea.semantika.app.ApplicationManager;
import com.obidea.semantika.exception.ConfigurationException;
import com.obidea.semantika.materializer.MaterializationException;
import com.obidea.semantika.materializer.MaterializerEngine;

public class RdfMaterializerTest
{
   /**
    * This example shows how to materialize RDB rows into RDF data in NTriples format.
    */
   @Test
   public void testNTriplesMaterializer() throws ConfigurationException, MaterializationException, IOException
   {
      // Create an application manager using the given configuration resource.
      ApplicationManager manager = new ApplicationFactory()
            .configure("example/h2/configuration.xml")
            .createApplicationManager();
      
      // Obtain the materializer engine from the manager and set the format to NTriples.
      MaterializerEngine materializer = manager.createMaterializerEngine().useNTriples();
      
      // Specify the output location where the results are going to be stored.
      File fout = File.createTempFile("employees", ".n3", new File("/tmp"));
      
      // Mark the start and end of the materialization process.
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   /**
    * This example shows how to materialize RDB rows into RDF data in Turtle format.
    */
   @Test
   public void testTurtleMaterializer() throws ConfigurationException, MaterializationException, IOException
   {
      // Create an application manager using the given configuration resource.
      ApplicationManager manager = new ApplicationFactory()
            .configure("example/h2/configuration.xml")
            .createApplicationManager();
      
      // Obtain the materializer engine from the manager and set the format to Turtle.
      MaterializerEngine materializer = manager.createMaterializerEngine().useTurtle();
      
      // Mark the start and end of the materialization process.
      File fout = File.createTempFile("employees", ".ttl", new File("/tmp"));
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   /**
    * This example shows how to materialize RDB rows into RDF data in RDF/XML format.
    */
   @Test
   public void testRdfXmlMaterializer() throws ConfigurationException, MaterializationException, IOException
   {
      // Create an application manager using the given configuration resource.
      ApplicationManager manager = new ApplicationFactory()
            .configure("example/h2/configuration.xml")
            .createApplicationManager();
      
      // Obtain the materializer engine from the manager and set the format to RDF/XML.
      MaterializerEngine materializer = manager.createMaterializerEngine().useRdfXml();
      
      // Mark the start and end of the materialization process.
      File fout = File.createTempFile("employees", ".xml", new File("/tmp"));
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   /**
    * This example shows how to materialize RDB rows into RDF data in RDF/JSON-LD format.
    */
   @Test
   public void testRdfJsonMaterializer() throws ConfigurationException, MaterializationException, IOException
   {
      // Create an application manager using the given configuration resource.
      ApplicationManager manager = new ApplicationFactory()
            .configure("example/h2/configuration.xml")
            .createApplicationManager();
      
      // Obtain the materializer engine from the manager and set the format to RDF/JSON.
      MaterializerEngine materializer = manager.createMaterializerEngine().useRdfJson();
      
      // Mark the start and end of the materialization process.
      File fout = File.createTempFile("employees", ".jsonld", new File("/tmp"));
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }
}
