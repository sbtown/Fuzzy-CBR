import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FuzzyCaseChecker {

	Map<Integer, Double> map = new HashMap<Integer,Double>();
	
	public void loadSpecific(String user, double clumpThinkness, double uniformityOfCellSize, double uniformityOfCellShape, double MarginalAdhesion, double singleEpithelialCellSize, double bareNuclei, double blandChromatin, double normalNucleoli, double mitoses){


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
	
		
		/*
		 * TESTED WEIGHTS
		double weightA = 0.122;
		double weightB = 0.122;
		double weightC = 0.111;
		double weightD = 0.111;
		double weightE = 0.011;
		double weightF = 0.099;
		double weightG = 0.099;
		double weightH = 0.115;
		double weightI = 0.210;

		*/	

		
		
		try {
		File file = new File("/Users/samtown/Desktop/Fuzzy-CBR/WCBreastCancer.xlsx");  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve ob
		DataFormatter df = new DataFormatter();
		
		
		for(int i = 1; i < sheet.getLastRowNum(); i++){
			int User = Integer.parseInt(df.formatCellValue(sheet.getRow(i).getCell(0)));
			
			double ctData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(1)));
			double ctFuzzy = dataAlter(ctData);
			double ctResult = compareFuzzySets(clumpThinkness,ctFuzzy, weightA);

			double uSizeData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(2)));
			double uSizeFuzzy = dataAlter(uSizeData);
			double uSizeResult = compareFuzzySets(uniformityOfCellSize,uSizeFuzzy,weightB);
			
			double uShapeData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(3)));
			double uShapeFuzzy = dataAlter(uShapeData);
			double uShapeResult = compareFuzzySets(uniformityOfCellShape,uShapeFuzzy,weightC);
			
			
			double maData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(4)));
			double maFuzzy = dataAlter(maData);
			double maResult = compareFuzzySets(MarginalAdhesion,maFuzzy,weightD);
			
			
			double sSizeData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(5)));
			double sSizeFuzzy = dataAlter(sSizeData);
			double sSizeResult = compareFuzzySets(singleEpithelialCellSize,sSizeFuzzy,weightE);
			
			
			double bnData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(6)));
			double bnFuzzy = dataAlter(bnData);
			double bnResult = compareFuzzySets(bareNuclei,bnFuzzy,weightF);
			
			
			double bcData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(7)));
			double bcFuzzy = dataAlter(bcData);
			double bcResult = compareFuzzySets(blandChromatin,bcFuzzy,weightG);
			
			
			double nnData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(8)));
			double nnFuzzy = dataAlter(nnData);
			double nnResult = compareFuzzySets(normalNucleoli,nnFuzzy,weightH);
			
		
			double mData = Double.parseDouble(df.formatCellValue(sheet.getRow(i).getCell(9)));
			double mFuzzy = dataAlter(mData);
			double mResult = compareFuzzySets(mitoses,mFuzzy,weightI);
			
			

			
			double result = (ctResult + uSizeResult + uShapeResult + maResult + sSizeResult + bnResult + bcResult + nnResult + mResult) /10;
	
			
			
			
			map.put(User, result);
			

		      
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
	
		      String ct = Double.toString(fuzzySet(clumpThinkness));
		      String cSize = Double.toString(fuzzySet(uniformityOfCellSize));
		      String cShape = Double.toString(fuzzySet(uniformityOfCellShape));
		      String ma = Double.toString(fuzzySet(MarginalAdhesion));
		      String sSize = Double.toString(fuzzySet(singleEpithelialCellSize));	
		      String bn = Double.toString(fuzzySet(bareNuclei));
		      String bc = Double.toString(fuzzySet(blandChromatin));
		      String nn = Double.toString(fuzzySet(normalNucleoli));
		      String m = Double.toString(fuzzySet(mitoses));

	        
	      getUser(userN,user, res, ct, cSize, cShape, ma, sSize,bn,bc,nn,m);

	      
	      
	      //Load values, Used for testing
	      
	      Set<Integer> keys = hm1.keySet();
	      
	      Integer[] keysArray = keys.toArray(new Integer[keys.size()]);

	      
	      for(int i=keysArray.length-1; i<keysArray.length;i++) {
	//          System.out.println(hm1.get(keysArray[i]));
	        
	      }
	      for(int i=keysArray.length-3; i<keysArray.length;i++) {
	//          System.out.println(hm1.get(keysArray[i]));
	      }
	      for(int i=keysArray.length-5; i<keysArray.length;i++) {
	 //         System.out.println(hm1.get(keysArray[i]));
	      }
		}
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	    

}



public void getUser(int comparedUser,String newUser, double result, String cT, String cSize, String cShape, String mA, String sSize, String bN, String bC, String nN, String m) {
		
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
		            	 message = ("Related User: "+ comparedUser +" \nAccuracy: "+ result +"\nBenign (" + a + ")");
		        
		            	}
		            	else if((a).equals(malignant)) {
		            		 message = ("Related User: "+ comparedUser +" \nAccuracy: "+ result +"\nMalignant (" + a + ")");
		      
		            	}
		            	else {
		            		message = ("Error");
		            	}
	
		            	 myGUI.responseText(message);
		            	 
		            	
		            	 
		            	 int dialogButton = JOptionPane.YES_NO_OPTION;
		            	 int dialogResult = JOptionPane.showConfirmDialog (null, "Diagnosis Agreement","Result",dialogButton);
		            	 if(dialogResult == JOptionPane.YES_OPTION){
		            		 WriteExcel we = new WriteExcel();
		            		 we.saveSpecific(newUser, cT,  cSize,  cShape,  mA,  sSize,  bN,  bC,  nN,  m, a);	            	 }
		            	 if(dialogResult == JOptionPane.NO_OPTION){
		            		 if((a).equals(benign)) {
		            			 a = "4";
		            			 WriteExcel we = new WriteExcel();
		            			 we.saveSpecific(newUser, cT,  cSize,  cShape,  mA,  sSize,  bN,  bC,  nN,  m, a);	     
		            		 }
		            			else if((a).equals(malignant)) {
		            				a = "2";
		            				 WriteExcel we = new WriteExcel();
		            				 we.saveSpecific(newUser, cT,  cSize,  cShape,  mA,  sSize,  bN,  bC,  nN,  m, a);	    
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
	
	

public void userFuzzyInput(String user, String clumpThinkness, String uniformityOfCellSize, String uniformityOfCellShape, String MarginalAdhesion, String singleEpithelialCellSize, String bareNuclei, String blandChromatin, String normalNucleoli, String mitoses) {
	

	double ctFuzzy = fuzzyAlter(clumpThinkness);
	double uSizeFuzzy = fuzzyAlter(uniformityOfCellSize);
	double uShape = fuzzyAlter(uniformityOfCellShape);
	double maFuzzy = fuzzyAlter(MarginalAdhesion);
	double sSize = fuzzyAlter(singleEpithelialCellSize);
	double bnFuzzy = fuzzyAlter(bareNuclei);
	double bcFuzzy = fuzzyAlter(blandChromatin);
	double nnFuzzy = fuzzyAlter(normalNucleoli);
	double mFuzzy = fuzzyAlter(mitoses);

	loadSpecific(user, ctFuzzy,uSizeFuzzy,uShape,maFuzzy,sSize,bnFuzzy,bcFuzzy,nnFuzzy,mFuzzy);
	
	
	
	// call load specifiy methid 
}

public double compareFuzzySets(double userData, double databaseData,double weight) {
	double result;
	
	if (userData == databaseData) {
		result = 1;
		return result + weight;
	}
	else if( userData - databaseData > 0) {
		result = 1 - ((userData - databaseData));
		return result + weight;
	}
	else {
		result = 1 - ((databaseData - userData));
		return result + weight;
	}
	
}


//Gets inputs and sets a fuzzy value
public double fuzzyAlter(String fuzzyData) {
	double fuzzyOutput = 0.0;
	
	if(fuzzyData.equals("low")) {
		return fuzzyOutput= 0.1;
	}
	else if(fuzzyData.equals("low-med")) {
		return fuzzyOutput= 0.3;
	}
	else if(fuzzyData.equals("medium")) {
		return fuzzyOutput= 0.5;
	}
	else if(fuzzyData.equals("high-med")) {
		return fuzzyOutput= 0.7;
	}
	else if(fuzzyData.equals("high")) {
		return fuzzyOutput= 0.9;
	}
	else {
		return fuzzyOutput;
	}
	
}

// Sets fuzzy values to store in the database 
public double fuzzySet(double fuzzyInput) {
	double fuzzyOutput = 0.0;
	
	if(fuzzyInput == 0.1) {
		return fuzzyOutput= 1;
	}
	else if(fuzzyInput == 0.3) {
		return fuzzyOutput= 3;
	}
	else if(fuzzyInput == 0.5) {
		return fuzzyOutput= 0.5;
	}
	else if(fuzzyInput == 0.7) {
		return fuzzyOutput= 0.7;
	}
	else if(fuzzyInput == 0.9) {
		return fuzzyOutput= 9;
	}
	else {
		return fuzzyOutput;
	}
	
}



//Sets database values to fuzzy amount 
public double dataAlter(double data) {
	if(data >=1 && data <= 2) {
		data = 0.1;
		return data;
	}
	else if(data >=3 && data <= 4) {
		data = 0.3;
		return data;
	}
	else if(data >=5 && data <= 6) {
		data = 0.5;
		return data;
	}
	else if(data >=7 && data <= 8) {
		data = 0.7;
		return data;
	}
	else if(data >=8 && data <= 10) {
		data = 0.9;
		return data;
	}
	else 
		return 0.0;
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
		
		  
		 
	
	