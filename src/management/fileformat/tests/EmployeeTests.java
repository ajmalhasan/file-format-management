package management.fileformat.tests;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.TestCase;

import management.fileformat.bo.EmployeesBo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTests extends TestCase{
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
			EmployeesBo employeesBo =    (EmployeesBo) appContext.getBean("employeesBo");
			dataList =   employeesBo.findAll();
			assertNotNull(dataList);
			assertTrue(dataList.size()>0);
	}
	 
	 @Test
		public void  testFindByTitle() {
				EmployeesBo employeesBo =    (EmployeesBo) appContext.getBean("employeesBo");
				dataList =   employeesBo.findByTitle("Engineer");
				assertNotNull(dataList);
				assertTrue(dataList.size()>0);
		} 
	 
	 @Test
		public void  testFindByDepartment() {
				EmployeesBo employeesBo =    (EmployeesBo) appContext.getBean("employeesBo");
				dataList =   employeesBo.findByDepartment("d001");
				assertNotNull(dataList);
				assertTrue(dataList.size()>0);
		} 

}
