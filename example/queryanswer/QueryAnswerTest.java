package example.queryanswer;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;

import com.obidea.semantika.app.ApplicationFactory;
import com.obidea.semantika.app.ApplicationManager;
import com.obidea.semantika.queryanswer.IQueryEngine;
import com.obidea.semantika.queryanswer.result.IQueryResult;
import com.obidea.semantika.util.LogUtils;

public class QueryAnswerTest
{
   private static final String CONFIG_FILE = "example/queryanswer/application.cfg.xml"; //$NON-NLS-1$

   private static IQueryEngine mQueryEngine;

   private static final Logger LOG = LogUtils.createLogger("semantika.test"); //$NON-NLS-1$

   @BeforeClass
   public static void setUp() throws Exception
   {
      ApplicationManager appManager = new ApplicationFactory().configure(CONFIG_FILE).createApplicationManager();
      mQueryEngine = appManager.createQueryEngine();
      mQueryEngine.start();
   }

   @AfterClass
   public static void close() throws Exception
   {
      mQueryEngine.stop();
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
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 5048);
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
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 19450);
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
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 1);
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
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 188);
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
            "     :lastName ?lname; \n" +
            "     :salaryAmount ?staffSalary . \n" +
            "  FILTER ( ?staffSalary > ?bossSalary && ?x != ?y ) }"; //$NON-NLS-1$
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 362);
   }

   @Test
   public void testQuery6() throws Exception
   {
      /* 
       * Query 6: Show all senior female employees that have salary at least 120K.
       * Hire date is optional (can be NULL).
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname ?salary ?hiredate \n" +
            "WHERE\n" +
            "{ ?staff :firstName ?fname; \n" +
            "         :lastName ?lname; \n" +
            "         :birthDate ?birthdate; \n" +
            "         :gender \"F\"; \n" +
            "         :salaryAmount ?salary . \n" +
            "  OPTIONAL { ?staff :hireDate ?hiredate }\n" +
            "  FILTER ( ?salary > 120000 && ?birthdate < '1952-12-31' ) }"; //$NON-NLS-1$
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 13);
   }

   @Test
   public void testQuery7() throws Exception
   {
      /* 
       * Query 7: Show all senior employees that have a clear hiring date.
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname ?hiredate \n" +
            "WHERE\n" +
            "{ ?staff :firstName ?fname; \n" +
            "         :lastName ?lname; \n" +
            "         :birthDate ?birthdate . \n" +
            "  OPTIONAL { ?staff :hireDate ?hiredate }\n" +
            "  FILTER (BOUND(?hiredate) && ?birthdate < '1952-12-31') }"; //$NON-NLS-1$
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 2292);
   }

   @Test
   public void testQuery8() throws Exception
   {
      /* 
       * Query 8: Show all senior employees that have an unclear hiring date (i.e., the data has lost)
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname ?hiredate \n" +
            "WHERE\n" +
            "{ ?staff :firstName ?fname; \n" +
            "         :lastName ?lname; \n" +
            "         :birthDate ?birthdate . \n" +
            "  OPTIONAL { ?staff :hireDate ?hiredate }\n" +
            "  FILTER (!BOUND(?hiredate) && ?birthdate < '1952-12-31') }"; //$NON-NLS-1$
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 1294);
   }

   @Test
   public void testQuery9() throws Exception
   {
      /* 
       * Query 9: Show all male junior employees that has ending words in their first name "hong".
       */
      final String sparql = 
            "PREFIX :   <http://obidea.com/ex/ontology/empdb#>\n" +
            "SELECT ?fname ?lname ?hiredate \n" +
            "WHERE\n" +
            "{ ?staff :firstName ?fname; \n" +
            "         :lastName ?lname; \n" +
            "         :gender \"M\"; \n" +
            "         :hireDate ?hiredate . \n" +
            "  FILTER (REGEX(?fname, 'hong$', 'i') && ?hiredate >= '1996-01-01') }"; //$NON-NLS-1$
      
      IQueryResult result = mQueryEngine.evaluate(sparql);
      printQuery(sparql);
      assertTotalRow(result, 16);
   }

   private void printQuery(String sparql)
   {
      LOG.info("\n" + sparql); //$NON-NLS-1$
   }

   private void assertTotalRow(IQueryResult result, int expectedNumber) throws SQLException
   {
      int counter = 0;
      while (result.next()) {
         counter++;
         LOG.debug(result.getValueList().toString());
      }
      LOG.info("{} row(s) returned\n", counter);
      assertEquals(expectedNumber, counter);
   }
}
