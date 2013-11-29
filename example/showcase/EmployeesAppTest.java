package example.showcase;

import java.io.File;

import org.junit.Test;

import com.obidea.semantika.app.ApplicationFactory;
import com.obidea.semantika.app.ApplicationManager;
import com.obidea.semantika.materializer.MaterializerEngine;

public class EmployeesAppTest
{
   /**
    * This example shows RDB-to-RDF materialization without including an
    * ontology resource. Notice later the difference between the two results
    * produced in this example show-case.
    */
   @Test
   public void testMaterializeExcludeOntology() throws Exception
   {
      ApplicationManager manager = new ApplicationFactory()
            .configure("example/showcase/configuration1.xml")
            .createApplicationManager();
      
      MaterializerEngine materializer = manager.createMaterializerEngine().useNTriples();
      File fout = File.createTempFile("employees", ".n3", new File("/tmp"));
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   /**
    * This example shows RDB-to-RDF materialization *with* including an ontology
    * resource. Notice later the difference between the two results produced in
    * this example show-case.
    */
   @Test
   public void testMaterializeIncludeOntology() throws Exception
   {
      ApplicationManager manager = new ApplicationFactory()
            .configure("example/showcase/configuration2.xml")
            .createApplicationManager();
      
      MaterializerEngine materializer = manager.createMaterializerEngine().useNTriples();
      File fout = File.createTempFile("employees", ".n3", new File("/tmp"));
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }
}
