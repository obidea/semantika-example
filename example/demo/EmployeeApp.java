package example.demo;

import java.io.*;

import com.obidea.semantika.app.Environment;
import com.obidea.semantika.app.ApplicationFactory;
import com.obidea.semantika.app.ApplicationManager;
import com.obidea.semantika.queryanswer.IQueryEngine;
import com.obidea.semantika.queryanswer.result.IQueryResult;

public class EmployeeApp
{
   private static IQueryEngine mQueryEngine;
   
   public static void main(String[] args) throws Exception
   {
      sysenv();
      initialize();
      start();
      try {
         String queryString = readUserInput();
         executeQuery(queryString);
      }
      finally {
         stop();
      }
   }
   
   private static void sysenv()
   {
      if (System.getProperty("h2.implicitRelativePath") == null) {
         /*
          * Keep compatibility with H2 1.3
          *prevent http://www.h2database.com/javadoc/org/h2/api/ErrorCode.html#c90011
          */
         System.setProperty("h2.implicitRelativePath", "true");
      }
   }

   private static void initialize() throws Exception
   {
      ApplicationManager appManager = new ApplicationFactory()
         .setName("empdb-app")
         .addProperty(Environment.CONNECTION_URL, "jdbc:h2:tcp://localhost/data/empdb")
         .addProperty(Environment.CONNECTION_DRIVER, "org.h2.Driver")
         .addProperty(Environment.CONNECTION_USERNAME, "sa")
         .addProperty(Environment.CONNECTION_PASSWORD, "")
         .setOntologySource("model/empdb.owl")
         .addMappingSource("model/empdb.mod.xml")
         .createApplicationManager();
      
      // Create the query engine
      mQueryEngine = appManager.createQueryEngine();
   }
   
   private static void start() throws Exception
   {
      mQueryEngine.start();
   }
   
   private static void stop() throws Exception
   {
      mQueryEngine.stop();
   }
   
   private static void executeQuery(String queryString) throws Exception
   {
      IQueryResult result = mQueryEngine.evaluate(queryString);
      printResult(result);
   }

   private static String readUserInput() throws Exception
   {
      System.out.println(); // space a bit
      System.out.println("Please type your query (use a period '.' sign to finish typing):");
      
      StringBuilder userQuery = new StringBuilder();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      while (true) { 
         String str = br.readLine();
         if (str.equals(".")) {
            break;
         }
         userQuery.append(str).append("\n");
      }
      return userQuery.toString().trim();
   }
   
   private static void printResult(IQueryResult result)
   {
      int counter = 0;
      while (result.next()) {
         counter++;
         System.out.println(result.getValueArray().toString());
      }
      System.out.println(counter + " row(s) returned");
   }
}
