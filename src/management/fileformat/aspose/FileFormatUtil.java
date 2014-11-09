package management.fileformat.aspose;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import management.fileformat.utils.Constants;

import org.springframework.stereotype.Service;

import com.aspose.cells.BorderType;
import com.aspose.cells.CellBorderType;
import com.aspose.cells.Cells;
import com.aspose.cells.Color;
import com.aspose.cells.Font;
import com.aspose.cells.ImageFormat;
import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.Row;
import com.aspose.cells.SheetRender;
import com.aspose.cells.Style;
import com.aspose.cells.StyleFlag;
import com.aspose.cells.TextAlignmentType;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;


@Service("fileFormatUtil")
public class FileFormatUtil {
	
	static List<String> fileList;
 
   static {
	fileList = new ArrayList<String>();
    }
 
	
	public  static String generateExcel(Map<Integer, ArrayList> listMap,ArrayList headerDatList, Integer format, String appPath) throws Exception {
		
		String filePath = "";
        //Instantiating a Workbook object
        Workbook workbook = new Workbook();

        //Adding a new worksheet to the Workbook object
        WorksheetCollection worksheets = workbook.getWorksheets();

        int sheetIndex = worksheets.add();
        Worksheet worksheet = worksheets.get(sheetIndex);
      
        worksheet.getCells().importArrayList(headerDatList,0,0,false);
        
        //Importing the contents of ArrayList to 1st row and first column vertically
        int rowIndex=1, columnIndex=0;
        boolean isVertical = true;
        for(int count=0; count<listMap.size();count++) {
        	worksheet.getCells().importArrayList(listMap.get(count),rowIndex,columnIndex,isVertical);
        	columnIndex++;
        }

        //Setting the name of the newly added worksheet
        worksheet.setName("My Worksheet");

        
        if(format == -1) {
			      //Create an object for ImageOptions
			      ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();
			      //Set the image type
			      imgOptions.setImageFormat(ImageFormat.getPng());
			      //Get the first worksheet.
			      Worksheet sheet = workbook.getWorksheets().get(1);
			
			      //Create a SheetRender object for the target sheet
			      SheetRender sr = new SheetRender(sheet, imgOptions);
			      //for (int j = 0; j < sr.getPageCount(); j++)
			      //{
			          //Generate an image for the worksheet
			          sr.toImage(0, appPath+Constants.FILE_PATH+"Report-Image.png");
			      //}
			        // generateFileList(appPath+Constants.FILE_PATH+"Report-Image.png", appPath+Constants.FILE_PATH+"Report-Image.zip") ;
			      return appPath+Constants.FILE_PATH+"Report-Image.png";
        }
        
        Cells cells = worksheet.getCells();

        //Accessing the newly added Style to the Excel object
        Style style = workbook.createStyle();

        //Setting the vertical alignment of the text in the cell
        style.setVerticalAlignment(TextAlignmentType.CENTER);

        //Setting the horizontal alignment of the text in the cell
        style.setHorizontalAlignment(TextAlignmentType.CENTER);

        //Setting the font color of the text in the cell
        Font font = style.getFont();
        font.setColor(Color.getGreen());

        //Shrinking the text to fit in the cell
        style.setShrinkToFit(true);

        //Setting the bottom border of the cell
        style.setBorder(BorderType.BOTTOM_BORDER, CellBorderType.MEDIUM, Color.getRed());

        //Creating StyleFlag
        StyleFlag styleFlag = new StyleFlag();
        styleFlag.setHorizontalAlignment(true);
        styleFlag.setVerticalAlignment(true);
        styleFlag.setShrinkToFit(true);
        styleFlag.setBottomBorder(true);
        styleFlag.setFontColor(true);

        //Accessing a row from the Rows collection
        Row row = cells.getRows().get(0);

        //Assigning the Style object to the Style property of the row
        row.applyStyle(style, styleFlag);
        
        
        try {
        		workbook.save(appPath+Constants.FILE_PATH  + "Employee-Report"+getExtension(format), format);
        		filePath = Constants.FILE_PATH  + "Employee-Report"+getExtension(format);
        		
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
        return filePath;
	}
	
	public static Map<Integer, ArrayList> buildPropertiesList(List<Object[]> list) {
		
		
		ArrayList<ArrayList<String>> propertiesList = new ArrayList<ArrayList<String>>();
		
		Map<Integer, ArrayList> listMap = new HashMap<Integer, ArrayList>();
	    for(int count=0;count<list.get(0).length;count++) {
	    	listMap.put(count, new ArrayList());
	    }
	    
	    Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] row = (Object[])iterator.next();
		    
		    for(int count=0;count<row.length;count++) {
		    	listMap.get(count).add(row[count]);
		    	
		    }
		}
		return listMap;
		
	}

	public static ArrayList<String> buildHeaderList(String... strings) {
		ArrayList<String> headerDatList = new ArrayList<String>();
		for(int count=0;count<strings.length; count++) {
			headerDatList.add(strings[count]);
		}
		
		return headerDatList;
	}
	
	public static String getExtension(Integer formatInt) {
		String format = "";
		switch(formatInt) {
			case 0: format = Constants.EXCEL_EXT;  break;
			case 12: format = Constants.HTML_EXT;  break;
			case 13: format = Constants.PDF_EXT;  break;
		}
		
		return format;
		
	}
	
	public static void processDownload(HttpServletRequest request, HttpServletResponse response, String filePath)  throws IOException  {
		//String filePath = "/WEB-INF/classes/data/book.out.xls";
  	  final int BUFFER_SIZE = 4096;
  	 
      // get absolute path of the application
      ServletContext context = request.getSession().getServletContext();
      String appPath = context.getRealPath("");

      // construct the complete absolute path of the file
      String fullPath = appPath + filePath;      
      File downloadFile = new File(fullPath);
      FileInputStream inputStream = new FileInputStream(downloadFile);
       
      // get MIME type of the file
      String mimeType = context.getMimeType(fullPath);
      if (mimeType == null) {
          // set to binary type if MIME mapping not found
          mimeType = "application/octet-stream";
      }
      System.out.println("MIME type: " + mimeType);

      // set content attributes for the response
      response.setContentType(mimeType);
      response.setContentLength((int) downloadFile.length());

      // set headers for the response
      String headerKey = "Content-Disposition";
      String headerValue = String.format("attachment; filename=\"%s\"",
              downloadFile.getName());
      response.setHeader(headerKey, headerValue);

      // get output stream of the response
      OutputStream outStream = response.getOutputStream();

      byte[] buffer = new byte[BUFFER_SIZE];
      int bytesRead = -1;

      // write bytes read from the input stream into the output stream
      while ((bytesRead = inputStream.read(buffer)) != -1) {
          outStream.write(buffer, 0, bytesRead);
      }

      inputStream.close();
      outStream.close();
	}
	
	
 
    /**
     * Traverse a directory and get all files,
     * and add the file into fileList  
     * @param node file or directory
     */
    public static void generateFileList(String filePath, String zipFilePath){
 
    	byte[] buffer = new byte[1024];
    	 
    	try{
 
    		FileOutputStream fos = new FileOutputStream(zipFilePath);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		ZipEntry ze= new ZipEntry("spy.log");
    		zos.putNextEntry(ze);
    		FileInputStream in = new FileInputStream(filePath);
 
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zos.write(buffer, 0, len);
    		}
 
    		in.close();
    		zos.closeEntry();
 
    		//remember close it
    		zos.close();
 
    		System.out.println("Done");
 
    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
 
    }
 
}
