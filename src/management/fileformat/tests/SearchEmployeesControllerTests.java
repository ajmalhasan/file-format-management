package management.fileformat.tests;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import junit.framework.TestCase;
import management.fileformat.controller.SearchEmployeesController;


public class SearchEmployeesControllerTests extends TestCase {
	
	public void testHandleRequestView() throws Exception{		
        SearchEmployeesController controller = new SearchEmployeesController();
        assertEquals("index", controller.showSearchPage(new ModelMap()));
    }
}
