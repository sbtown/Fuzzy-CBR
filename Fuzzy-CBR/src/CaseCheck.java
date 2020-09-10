import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CaseCheck {


	
	Map<Integer, Double> map = new HashMap<Integer,Double>();
	
	
	public void loadSpecific(String user, String clumpThinkness, String uniformityOfCellSize, String uniformityOfCellShape, String MarginalAdhesion, String singleEpithelialCellSize, String bareNuclei, String blandChromatin, String normalNucleoli, String mitoses) {
		
	  
	
	//Weights
		
		double weightA = 0.222;
		double weightB = 0.222;
		double weightC = 0.111;
		double weightD = 0.111;
		double weightE = 0.111;
		double weightF = 0.099;
		double weightG = 0.099;
		double weightH = 0.015;
		double weightI = 0.010;


		
		
		
		try {
		File file = new File("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");  
		FileInputStream fis = new FileInputStream(file);   
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     
		DataFormatter df = new DataFormatter();
		
		for(int i = 1; i < sheet.getLastRowNum(); i++){
		
			int User = Integer.parseInt(df.formatCellValue(sheet.getRow(i).getCell(0)));
			double userClass = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(10)));
			
			double ctUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(1)));
			double ctData = Double.parseDouble(clumpThinkness);
			double ctResult = compareSets(ctUser,ctData,weightA);
			
			double uSizeUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(2)));
			double uSizeData = Double.parseDouble(uniformityOfCellSize);
			double uSizeResult = compareSets(uSizeUser,uSizeData,weightB);
		
			
			
			double uShapeUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(3)));
			double uShapeData = Double.parseDouble(uniformityOfCellShape);
			double uShapeResult = compareSets(uShapeUser,uShapeData,weightC);

			
			double maUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(4)));
			double maData = Double.parseDouble(MarginalAdhesion);
			double maResult = compareSets(maUser,maData,weightD);
			

			
			double sSizeUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(5)));
			double sSizeData = Double.parseDouble(singleEpithelialCellSize);
			double sSizeResult = compareSets(sSizeUser,sSizeData,weightE);
			
			

			
			double bnUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(6)));
			double bnData = Double.parseDouble(bareNuclei);
			double bnResult = compareSets(bnUser,bnData,weightF);
		
			
			
			double bcUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(7)));
			double bcData = Double.parseDouble(blandChromatin);
			double bcResult = compareSets(bcUser,bcData,weightG);
			
			
			
			double nnUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(8)));
			double nnData = Double.parseDouble(normalNucleoli);
			double nnResult = compareSets(nnUser,nnData,weightH);
			
		
			
			double mUser = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(9)));
			double mData = Double.parseDouble(mitoses);
			double mResult = compareSets(mUser,mData,weightI);
	
			
			
			double Result = (ctResult + uSizeResult  + uShapeResult + maResult + sSizeResult + bnResult + bcResult + nnResult + mResult)/ 10;

			map.put(User, Result);
		}
		
		 
		//Sorts
		  Map<Integer, Double> hm1 = sortByValue(map); 	  

		  String message = "";
		  int userN = 0;
		  double res = 0;
		  
	        // print the sorted hashmap 
	        for (Map.Entry<Integer, Double> en : hm1.entrySet()) {   
	        	
	            message = "User = " + en.getKey() + ", Accuracy = " + en.getValue(); 
	            userN = en.getKey();     
	            res = en.getValue();
	            
	

	        } 
	        getUser(userN,user, res, clumpThinkness, uniformityOfCellSize, uniformityOfCellShape,  MarginalAdhesion,  singleEpithelialCellSize,  bareNuclei,  blandChromatin,  normalNucleoli,  mitoses);
	        	

	      //Load values For testing
	      Set<Integer> keys = hm1.keySet();
	      
	      Integer[] keysArray = keys.toArray(new Integer[keys.size()]);

	      
	      for(int i=keysArray.length-1; i<keysArray.length;i++) {
	      //    System.out.println(hm1.get(keysArray[i]));
	        
	      }
	      for(int i=keysArray.length-3; i<keysArray.length;i++) {
	      //    System.out.println(hm1.get(keysArray[i]));
	      }
	      for(int i=keysArray.length-5; i<keysArray.length;i++) {
	    //    System.out.println(hm1.get(keysArray[i]));
	      }
		}
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
	} 
	
	
	public double compareSets(double userData, double databaseData, double weight) {
		double result;
		
		if (userData == databaseData) {
			result = 1 + weight;
			return result;
		}
		else if( userData - databaseData > 0) {
			result = 1 - (((userData - databaseData) / 10) + weight);
			return result;
		}
		else {
			result = 1 - (((databaseData - userData) / 10) + weight);
			return result;
		}
		
	}

	
	
	
	//Gets whether result is benign or malignant
	public void getUser(int comparedUser,String newUser, double result, String clumpThinkness, String uniformityOfCellSize, String uniformityOfCellShape, String MarginalAdhesion, String singleEpithelialCellSize, String bareNuclei, String blandChromatin, String normalNucleoli, String mitoses) {
		
		String message = "";		
		try {
			
			String CodeNumber = Integer.toString(comparedUser);
			File file = new File("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");  
			FileInputStream fis = new FileInputStream(file); 
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0); 
			User temp = new User();
		        for (Row row : sheet) { // For each Row.
		              Cell cell = row.getCell(0); // Get the Cell at the Index / Column you want.
		              if(cell.getStringCellValue().equalsIgnoreCase(CodeNumber)) {
		              
		            	 Cell Recomendation = cell.getRow().getCell(10);
		            	 
		            	String a = (Recomendation).toString();
		            	String benign = "2";
		            	String malignant = "4";
		            	
		            	
		            	if((a).equals(benign)) {
		            	 message = ("Related User: "+ comparedUser +" \nAccurracy: "+ result +"\nBenign (" + a + ")");
		           
		            	}
		            	else if((a).equals(malignant)) {
		            		 message = ("Related User: "+ comparedUser +" \nAccurracy: "+ result +"\nMalignant (" + a + ")");
		    
		            	}
		            	else {
		            		message = ("Error");
		            	}
	
		            	 myGUI.responseText(message);
		            	 
		          	 
		            	 
		            	 int dialogButton = JOptionPane.YES_NO_OPTION;
		            	 int dialogResult = JOptionPane.showConfirmDialog (null, "Diagnosis Agreement","Result",dialogButton);
		            	 if(dialogResult == JOptionPane.YES_OPTION){
		            		 WriteExcel we = new WriteExcel();
		            		 we.saveSpecific(newUser, clumpThinkness, uniformityOfCellSize, uniformityOfCellShape,  MarginalAdhesion,  singleEpithelialCellSize,  bareNuclei,  blandChromatin,  normalNucleoli,  mitoses, a);
		            	 }
		            	 if(dialogResult == JOptionPane.NO_OPTION){
		            		 if((a).equals(benign)) {
		            			 a = "4";
		            			 WriteExcel we = new WriteExcel();
				 		         we.saveSpecific(newUser, clumpThinkness, uniformityOfCellSize, uniformityOfCellShape,  MarginalAdhesion,  singleEpithelialCellSize,  bareNuclei,  blandChromatin,  normalNucleoli,  mitoses, a);
				 		       
		            		 }
		            			else if((a).equals(malignant)) {
		            				a = "2";
		            				 WriteExcel we = new WriteExcel();
					 		         we.saveSpecific(newUser, clumpThinkness, uniformityOfCellSize, uniformityOfCellShape,  MarginalAdhesion,  singleEpithelialCellSize,  bareNuclei,  blandChromatin,  normalNucleoli,  mitoses, a);
					 		       
		            			}
		            		 
		            		 
			            	 }
		            	 
		            	
		            	  }
		            	
		              }
		            
		         }
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
		
	}
	
	
	
	
	
	//Sorts Results in order of accuracy to input
	  public static HashMap<Integer, Double> sortByValue(Map<Integer, Double> map2) 
	    { 
	        // Create a list from elements of HashMap 
	        List<Map.Entry<Integer, Double> > list = 
	               new LinkedList<Map.Entry<Integer, Double> >(map2.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Double> >() { 
	            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) 
	            { 
	            	
	            	//change this back later 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }); 
	          
	        // put data from sorted list to hashmap  
	        HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>(); 
	        for (Map.Entry<Integer, Double> aa : list) { 
	            temp.put(aa.getKey(), aa.getValue()); 
	        } 

	        return temp; 
	    } 
	
	
	
	}
	  




	  
	  



