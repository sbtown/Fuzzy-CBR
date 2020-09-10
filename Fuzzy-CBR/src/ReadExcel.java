import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ReadExcel {

	
	
	public User loadSpecific(String CodeNumber) {
		try {
			File file = new File("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");  
			FileInputStream fis = new FileInputStream(file); 
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0); 
			User temp = new User();
			// For each Row
		        for (Row row : sheet) { 
		        	// Get the Cell at the Index 
		              Cell cell = row.getCell(0); 
		              //If user ID is in excel doc, input data to Cell
		              if(cell.getStringCellValue().equalsIgnoreCase(CodeNumber)) {
		            		Cell clumpThinkness = cell.getRow().getCell(1);
		            		Cell uniformityOfCellSize = cell.getRow().getCell(2);
		            		Cell uniformityOfCellShape = cell.getRow().getCell(3);
		            		Cell MarginalAdhesion = cell.getRow().getCell(4);
		            		Cell singleEpithelialCellSize = cell.getRow().getCell(5);
		            		Cell bareNuclei = cell.getRow().getCell(6);
		            		Cell blandChromatin = cell.getRow().getCell(7);
		           		    Cell normalNucleoli = cell.getRow().getCell(8);
		            		Cell mitoses = cell.getRow().getCell(9);
		            	  
		            		//Add data to temp user 
		            		 temp.clumpThinkness = Double.parseDouble(clumpThinkness.toString());
		            	     temp.uniformityOfCellSize = Double.parseDouble(uniformityOfCellSize.toString());
		                	 temp.uniformityOfCellShape = Double.parseDouble(uniformityOfCellShape.toString());
		                	 temp.MarginalAdhesion = Double.parseDouble(MarginalAdhesion.toString());
		                	 temp.singleEpithelialCellSize = Double.parseDouble(singleEpithelialCellSize.toString());
		                	 temp.bareNuclei = Double.parseDouble(bareNuclei.toString());
		                	 temp.blandChromatin = Double.parseDouble(blandChromatin.toString());
		                	 temp.normalNucleoli = Double.parseDouble(normalNucleoli.toString());
		                	 temp.mitoses = Double.parseDouble(mitoses.toString());
		            	     
		            	     
		     
		                  }
		              }
		    	return temp;
			
		} catch (IOException e) {
			e.printStackTrace();
			 System.out.println("Error");
			return null;
		}
	}
}


