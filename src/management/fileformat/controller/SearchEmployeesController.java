package management.fileformat.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.fileformat.aspose.FileFormatUtil;
import management.fileformat.bo.DepartmentsBo;
import management.fileformat.bo.EmployeesBo;
import management.fileformat.bo.TitlesBo;
import management.fileformat.pojos.Departments;
import management.fileformat.utils.Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class SearchEmployeesController   {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String showSearchPage(ModelMap model) {
		ApplicationContext appContext = 
	    	  new ClassPathXmlApplicationContext("resources/config/BeanLocations.xml");
	    	 model.addAttribute("showDownload", false);

	      return "index";
	   }
	
	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	   public String searchEmployee(ModelMap model,
			   HttpServletRequest request,@RequestParam String radgroup, @RequestParam String title, @RequestParam String department, @RequestParam Integer format) {
		ApplicationContext appContext = 
	    	  new ClassPathXmlApplicationContext("resources/config/BeanLocations.xml");
		
		String filePath="", appPath;
		List<Object[]> dataList=null;
		ArrayList headerDatList=null;
		ServletContext context = request.getSession().getServletContext();
        appPath = context.getRealPath("");
		if(radgroup.equals("searchEmployees")) {
			EmployeesBo employeesBo =    (EmployeesBo) appContext.getBean("employeesBo");
			dataList =   employeesBo.findAll();
			headerDatList = new ArrayList();
			headerDatList.add("Emp NO");
			headerDatList.add("First Name");
			headerDatList.add("Last Name");
			headerDatList.add("Gender");
			
			
		}else if(radgroup.equals("searchDepartment")) {
			DepartmentsBo departmentsBo =    (DepartmentsBo) appContext.getBean("departmentsBo");
			dataList =   departmentsBo.findAll();
			headerDatList = new ArrayList();
			headerDatList.add("Dept NO");
			headerDatList.add("Name");
			
		}else if(radgroup.equals("searchByTitle")) {
			EmployeesBo employeesBo =    (EmployeesBo) appContext.getBean("employeesBo");
			dataList =   employeesBo.findByTitle(title);
			
			headerDatList = new ArrayList();
			headerDatList.add("Emp No");
			headerDatList.add("First Name");
			headerDatList.add("Last Name");
			headerDatList.add("Gender");
			headerDatList.add("Title");
			
		}else if(radgroup.equals("searchByDepartment")) {
			EmployeesBo employeesBo =    (EmployeesBo) appContext.getBean("employeesBo");
			dataList =   employeesBo.findByDepartment(department);
			
			headerDatList = new ArrayList();
			headerDatList.add("Emp No");
			headerDatList.add("First Name");
			headerDatList.add("Last Name");
			headerDatList.add("Gender");
		}
			
			try {
				filePath = FileFormatUtil.generateExcel(FileFormatUtil.buildPropertiesList(dataList),headerDatList, format, appPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			model.addAttribute("filePath", filePath);
			model.addAttribute("showDownload", true);
		 	return "index";
	   }
	
	
	    @RequestMapping(value = "/download", method = RequestMethod.GET)
	    public void doDownload(ModelMap model,HttpServletRequest request,
	            HttpServletResponse response,  @RequestParam String filePath) {
	    	try {
				FileFormatUtil.processDownload(request, response, filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }


}
