package example.queryanswer;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.obidea.semantika.app.ApplicationFactory;
import com.obidea.semantika.app.ApplicationManager;
import com.obidea.semantika.queryanswer.IQueryEngine;
import com.obidea.semantika.queryanswer.result.IQueryResult;

public class QueryAnswerTest
{
   private static final String CONFIG_FILE = "example/queryanswer/configuration.xml";

   private static IQueryEngine mQueryEngine;

   private static final Logger LOG = LoggerFactory.getLogger("semantika.test"); //$NON-NLS-1$

   @BeforeClass
   public static void setUp() throws Exception
   {
      ApplicationManager appManager = new ApplicationFactory().configure(CONFIG_FILE).createApplicationManager();
      mQueryEngine = appManager.createQueryEngine();
   }

   @Test
   public void testQuery1() throws Exception
   {
      /*
       * Query 1: Show profile info for all Engineers.
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?x ?fname ?lname ?birthdate ?gender ?hiredate \n" +
            "WHERE\n" +
            "{ ?x a :Engineer .\n" +
            "  ?x :firstName ?fname;\n" +
            "     :lastName ?lname;\n" +
            "     :birthDate ?birthdate;\n" +
            "     :gender ?gender;\n" +
            "     :hireDate ?hiredate . }"; //$NON-NLS-1$
      
      mQueryEngine.start();
      IQueryResult result = mQueryEngine.evaluate(sparql);
      assertTotalRow(result, 5185);
      mQueryEngine.stop();
   }

   @Test
   public void testQuery2() throws Exception
   {
      /*
       * Query 2: Show profile info for all Operational staffs (i.e.,. Senior Staff, Staff and Tech Leader).
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?x ?fname ?lname ?birthdate ?gender ?hiredate \n" +
            "WHERE\n" +
            "{ ?x a :Operational .\n" +
            "  ?x :firstName ?fname;\n" +
            "     :lastName ?lname;\n" +
            "     :birthDate ?birthdate;\n" +
            "     :gender ?gender;\n" +
            "     :hireDate ?hiredate . }"; //$NON-NLS-1$
      
      mQueryEngine.start();
      IQueryResult result = mQueryEngine.evaluate(sparql);
      assertTotalRow(result, 19951);
      mQueryEngine.stop();
   }

   @Test
   public void testQuery3() throws Exception
   {
      /* 
       * Query 3: Show the full name of the manager in the Development department.
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname \n" +
            "WHERE\n" +
            "{ ?x :leads ?y .\n" +
            "  ?y :deptName \"Development\" .\n" +
            "  ?x :firstName ?fname .\n" +
            "  ?x :lastName ?lname . }"; //$NON-NLS-1$
      
      mQueryEngine.start();
      IQueryResult result = mQueryEngine.evaluate(sparql);
      assertTotalRow(result, 1);
      mQueryEngine.stop();
   }

   @Test
   public void testQuery4() throws Exception
   {
      /* 
       * Query 4: Show all Finance employees that were hired later than January 1, 1995
       * and has salary more than 50K.
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname ?hiredate ?salary \n" +
            "WHERE\n" +
            "{ ?x :memberOf ?y .\n" +
            "  ?y :deptName \"Finance\" .\n" +
            "  ?x :firstName ?fname; \n" +
            "     :lastName ?lname; \n" + //$NON-NLS-1$
            "     :hireDate ?hiredate; \n" + //$NON-NLS-1$
            "     :salaryAmount ?salary . \n" + //$NON-NLS-1$
            "  FILTER ( ?hiredate > '1995-01-01' && ?salary > 50000) }"; //$NON-NLS-1$
      
      mQueryEngine.start();
      IQueryResult result = mQueryEngine.evaluate(sparql);
      assertTotalRow(result, 195);
      mQueryEngine.stop();
   }

   @Test
   public void testQuery5() throws Exception
   {
      /* 
       * Query 5: Show all Sales employees that have salary more than their boss.
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname \n" +
            "WHERE\n" +
            "{ ?x :leads ?d .\n" +
            "  ?y :memberOf ?d .\n" +
            "  ?d :deptName \"Sales\" .\n" +
            "  ?x :salaryAmount ?bossSalary .\n" +
            "  ?y :firstName ?fname; \n" +
            "     :lastName ?lname; \n" + //$NON-NLS-1$
            "     :salaryAmount ?staffSalary . \n" + //$NON-NLS-1$
            "  FILTER ( ?staffSalary > ?bossSalary ) }"; //$NON-NLS-1$
      
      mQueryEngine.start();
      IQueryResult result = mQueryEngine.evaluate(sparql);
      assertTotalRow(result, 362);
      mQueryEngine.stop();
   }

   private void assertTotalRow(IQueryResult result, int expectedNumber) throws SQLException
   {
      int counter = 0;
      while (result.next()) {
         counter++;
         LOG.debug(result.getValueList().toString());
      }
      LOG.info("{} row(s) returned\n", counter);
      assertEquals(counter, expectedNumber);
   }
}
