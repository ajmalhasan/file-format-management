package management.fileformat.tests;

import java.util.List;

import management.fileformat.bo.DepartmentsBo;
import management.fileformat.bo.EmployeesBo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class DepartmentTests extends TestCase{
	 ApplicationContext appContext;
	 List<Object[]> dataList=null;
	 @Before
	    public void setUp() {
		 appContext = 
		  	  new ClassPathXmlApplicationContext("resources/config/BeanLocations.xml");
	    }
	 
	 @After
	    public void tearDown() {
		 appContext = null;
		 dataList=null;
	    }
	 @Test
	public void  testFindAll() {
		 	DepartmentsBo departmentsBo =    (DepartmentsBo) appContext.getBean("departmentsBo");
			dataList =   departmentsBo.findAll();
			assertNotNull(dataList);
			assertTrue(dataList.size()>0);
	}
	 
	

}
