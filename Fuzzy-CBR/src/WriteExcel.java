import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	//Saves without result
	public void saveSpecific(String CodeNumber, String cT, String uSize, String uShape, String mA, String sSize, String bN, String bC, String nN, String m) {
		try { 
			 
			File file = new File("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");  
			
			FileInputStream fis = new FileInputStream(file); 
			XSSFWorkbook wb = new XSSFWorkbook(fis);  
			XSSFSheet sheet = wb.getSheetAt(0);		
			
			String [][] userData = {
	               {CodeNumber, cT, uSize, uShape, mA, sSize, bN, bC, nN, m}
	            };
			
			 int rowCount = sheet.getLastRowNum();
			   
	            for (String[] userExcel : userData) {
	                Row row = sheet.createRow(++rowCount);
	 
	                int columnCount = 0;
	                 
	                Cell cell = row.createCell(columnCount);
	                for (Object field : userExcel) {
	                  cell = row.createCell(columnCount++);
	                    if (field instanceof String) {
	                        cell.setCellValue((String) field);
	                    } else if (field instanceof Double) {
	                        cell.setCellValue((Double) field);
	                    } else if (field instanceof Integer) {
	                    	cell.setCellValue((Integer) field);
	                    }
	                }
	            }
	 
	            System.out.println("Saved");
	            fis.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");
	            wb.write(outputStream);
	            wb.close();
	            outputStream.close();
	             
	        } catch (IOException e) {
				e.printStackTrace();
			
	        }
		}
	//Saves with result 
	public void saveSpecific(String CodeNumber, String cT, String uSize, String uShape, String mA, String sSize, String bN, String bC, String nN, String m, String result) {
		try { 
			 
			File file = new File("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");  
			
			FileInputStream fis = new FileInputStream(file); 
			XSSFWorkbook wb = new XSSFWorkbook(fis);  
			XSSFSheet sheet = wb.getSheetAt(0);		
			
			String [][] userData = {
	               {CodeNumber, cT, uSize, uShape, mA, sSize, bN, bC, nN, m, result}
	            };
			
			 int rowCount = sheet.getLastRowNum();
			   
	            for (String[] userExcel : userData) {
	                Row row = sheet.createRow(++rowCount);
	 
	                int columnCount = 0;
	                 
	                Cell cell = row.createCell(columnCount);
	                for (Object field : userExcel) {
	                  cell = row.createCell(columnCount++);
	                    if (field instanceof String) {
	                        cell.setCellValue((String) field);
	                    } else if (field instanceof Double) {
	                        cell.setCellValue((Double) field);
	                    } else if (field instanceof Integer) {
	                    	cell.setCellValue((Integer) field);
	                    }  
	                }
	            }
	 

	            myGUI.responseText("Saved");
	            fis.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");
	            wb.write(outputStream);
	            wb.close();
	            outputStream.close();
	             
	        } catch (IOException e) {
	        	  myGUI.responseText("Unable to save");

	        }
		}
}
