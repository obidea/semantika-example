package example.rdb2rdf;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import com.obidea.semantika.app.ApplicationFactory;
import com.obidea.semantika.app.ApplicationManager;
import com.obidea.semantika.exception.ConfigurationException;
import com.obidea.semantika.materializer.IMaterializerEngine;

public class ExportTest
{
   private static final String CONFIGURATION_PATH = "example/rdb2rdf/configuration.xml"; //$NON-NLS-1$

   private static ApplicationManager mAppManager;

   @BeforeClass
   public static void setUp() throws ConfigurationException
   {
      mAppManager = new ApplicationFactory().configure(CONFIGURATION_PATH).createApplicationManager();
   }

   @Test
   public void testExportNTriples() throws Exception
   {
      // Get the materializer engine from the manager and set the output format to NTriples.
      IMaterializerEngine materializer = mAppManager.createMaterializerEngine().useNTriples();
      
      // Specify the output location.
      File fout = new File("output.n3"); //$NON-NLS-1$
      
      // Flag the start and end of the export process.
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   @Test
   public void testExportTurtle() throws Exception
   {
      // Get the materializer engine from the manager and set the output format to Turtle.
      IMaterializerEngine materializer = mAppManager.createMaterializerEngine().useTurtle();
      
      // Specify the output location.
      File fout = new File("output.ttl"); //$NON-NLS-1$

      // Flag the start and end of the export process.
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   @Test
   public void testExportXml() throws Exception
   {
      // Get the materializer engine from the manager and set the output format to RDF/XML.
      IMaterializerEngine materializer = mAppManager.createMaterializerEngine().useRdfXml();
      
      // Specify the output location.
      File fout = new File("output.xml"); //$NON-NLS-1$

      // Flag the start and end of the export process.
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }

   @Test
   public void testExportJson() throws Exception
   {
      // Get the materializer engine from the manager and set the format to RDF/JSON.
      IMaterializerEngine materializer = mAppManager.createMaterializerEngine().useRdfJson();
      
      // Specify the output location.
      File fout = new File("output.json"); //$NON-NLS-1$

      // Flag the start and end of the export process.
      materializer.start();
      materializer.materialize(fout);
      materializer.stop();
   }
}
