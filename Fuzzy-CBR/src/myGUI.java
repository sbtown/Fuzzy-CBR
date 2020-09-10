import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.border.BevelBorder;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTextArea;


/*
 * Reference: 
 * 
 * Source code used as a starting point for the GUI and developed upon
 * https://github.com/jacknorris752/CBR_Loan_Calculator
 * 
 * 
 * */


public class myGUI extends JFrame {
	private JTextField userID;
	private JTextField clumpThinkness;
	private JTextField uniformityOfCellSize;
	private JTextField uniformityOfCellShape;
	private JTextField MarginalAdhesion;
	private JTextField singleEpithelialCellSize;
	private JTextField bareNuclei;
	private JTextField blandChromatin;
	private JTextField normalNucleoli;
	private JTextField mitoses;
	private static JTextArea responseTextA;


//User Interface
public myGUI() {
	
	setMinimumSize(new Dimension(500, 700));
	myGUI();
}

public void myGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Fuzzy Diagnosis");
	getContentPane().setBackground(Color.YELLOW);
	getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
	
	
	JPanel panel = new JPanel();
	getContentPane().add(panel);
	panel.setLayout(new GridLayout(2, 1, 0, 0));
	
	
	JPanel Inputpanel = new JPanel();
	panel.add(Inputpanel);
	Inputpanel.setBackground(new Color(153, 204, 255));
	Inputpanel.setLayout(new GridLayout(10, 1, 5, 1));
	
	
	JPanel nameGroup = new JPanel();
	FlowLayout flowLayout = (FlowLayout) nameGroup.getLayout();
	flowLayout.setAlignment(FlowLayout.LEFT);
	nameGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(nameGroup);
	
	JLabel nameLabel = new JLabel("User ID");
	nameGroup.add(nameLabel);
	
	userID = new JTextField();
	nameGroup.add(userID);
	userID.setColumns(10);
	
	
	
	
	
	// Clump Thickness Textbox and label

	JPanel ctGroup = new JPanel();
	FlowLayout flowLayout_1 = (FlowLayout) ctGroup.getLayout();
	flowLayout_1.setAlignment(FlowLayout.LEFT);
	ctGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(ctGroup);
	
	JLabel ctLabel = new JLabel("Clump Thinkness");
	ctGroup.add(ctLabel);
	
	clumpThinkness = new JTextField();
	clumpThinkness.setColumns(10);
	ctGroup.add(clumpThinkness);
	
	
	// uniformity Of Cell Size Textbox and label	

	JPanel cellSizeGroup = new JPanel();
	FlowLayout flowLayout_2 = (FlowLayout) cellSizeGroup.getLayout();
	flowLayout_2.setAlignment(FlowLayout.LEFT);
	cellSizeGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(cellSizeGroup);
	
	JLabel cellSizeLabel = new JLabel("Uniformity Of Cell Size");
	cellSizeGroup.add(cellSizeLabel);
	
	uniformityOfCellSize = new JTextField();
	uniformityOfCellSize.setColumns(10);
	cellSizeGroup.add(uniformityOfCellSize);
	
	
	
	// uniformity Of Cell Shape Textbox and label	
	
	
	JPanel uniformityOfCellShapeGroup = new JPanel();
	FlowLayout flowLayout_3 = (FlowLayout) uniformityOfCellShapeGroup.getLayout();
	flowLayout_3.setAlignment(FlowLayout.LEFT);
	uniformityOfCellShapeGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(uniformityOfCellShapeGroup);
	
	JLabel CellShapeLabel = new JLabel("Uniformity Of Cell Shape");
	uniformityOfCellShapeGroup.add(CellShapeLabel);
	
	uniformityOfCellShape = new JTextField();
	uniformityOfCellShape.setToolTipText("How many months have you worked at your current job? 0 if unemployed");
	uniformityOfCellShape.setColumns(10);
	uniformityOfCellShapeGroup.add(uniformityOfCellShape);
	
	
	// Marginal Adhesion Textbox and label	
	
	JPanel MarginalAdhesionGroup = new JPanel();
	FlowLayout flowLayout_4 = (FlowLayout) MarginalAdhesionGroup.getLayout();
	flowLayout_4.setAlignment(FlowLayout.LEFT);
	MarginalAdhesionGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(MarginalAdhesionGroup);
	
	JLabel MarginalAdhesionLabel = new JLabel("Marginal Adhesion");
	MarginalAdhesionGroup.add(MarginalAdhesionLabel);
	
	MarginalAdhesion = new JTextField();
	MarginalAdhesion.setToolTipText("Total yearly expenses");
	MarginalAdhesion.setColumns(10);
	MarginalAdhesionGroup.add(MarginalAdhesion);
	
	
	
	

	// single Epithelial Cell Size Textbox and label	
	
	
	JPanel singleEpithelialCellSizeGroup = new JPanel();
	FlowLayout flowLayout_5 = (FlowLayout) singleEpithelialCellSizeGroup.getLayout();
	flowLayout_5.setAlignment(FlowLayout.LEFT);
	singleEpithelialCellSizeGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(singleEpithelialCellSizeGroup);
	
	
	JLabel singleEpithelialCellSizeLabel = new JLabel("Single Epithelial Cell Size");
	singleEpithelialCellSizeGroup.add(singleEpithelialCellSizeLabel);
	
	singleEpithelialCellSize = new JTextField();
	singleEpithelialCellSizeGroup.add(singleEpithelialCellSize);
	singleEpithelialCellSize.setColumns(10);

	
	
	
	// single bare Nuclei Cell Size Textbox and label	

	
	JPanel bareNucleiGroup = new JPanel();
	FlowLayout flowLayout_6 = (FlowLayout) bareNucleiGroup.getLayout();
	flowLayout_6.setAlignment(FlowLayout.LEFT);
	bareNucleiGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(bareNucleiGroup);
	
	JLabel bareNucleiLabel = new JLabel("Bare Nuclei");
	bareNucleiGroup.add(bareNucleiLabel);
	
	bareNuclei = new JTextField();
	bareNucleiGroup.add(bareNuclei);
	bareNuclei.setColumns(10);

	
	// 	bland Chromatin Textbox and label	
	
	
	
	JPanel blandChromatinGroup = new JPanel();
	FlowLayout flowLayout_7 = (FlowLayout) blandChromatinGroup.getLayout();
	flowLayout_7.setAlignment(FlowLayout.LEFT);
	blandChromatinGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(blandChromatinGroup);
	
	JLabel blandChromatinLabel = new JLabel("Bland Chromatin");
	blandChromatinGroup.add(blandChromatinLabel);
	
	blandChromatin = new JTextField();
	blandChromatinGroup.add(blandChromatin);
	blandChromatin.setColumns(10);

	// normal Nucleoli Group Textbox and label	

	
	JPanel normalNucleoliGroup = new JPanel();
	FlowLayout flowLayout_8 = (FlowLayout) normalNucleoliGroup.getLayout();
	flowLayout_8.setAlignment(FlowLayout.LEFT);
	normalNucleoliGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(normalNucleoliGroup);
	
	JLabel normalNucleoliLabel = new JLabel("Normal Nucleoli");
	normalNucleoliGroup.add(normalNucleoliLabel);
	
	normalNucleoli = new JTextField();
	normalNucleoliGroup.add(normalNucleoli);
	normalNucleoli.setColumns(10);
	
	// mitoses Textbox and label	

	
	JPanel mitosesGroup = new JPanel();
	FlowLayout flowLayout_9 = (FlowLayout) mitosesGroup.getLayout();
	flowLayout_9.setAlignment(FlowLayout.LEFT);
	mitosesGroup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Inputpanel.add(mitosesGroup);
	
	JLabel mitosesLabel = new JLabel("Mitoses");
	mitosesGroup.add(mitosesLabel);
	
	mitoses = new JTextField();
	mitosesGroup.add(mitoses);
	mitoses.setColumns(10);
	
	
	
	
	
	JPanel Responsepanel = new JPanel();
	panel.add(Responsepanel);
	Responsepanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	Responsepanel.setLayout(new GridLayout(0, 1, 0, 0));
	
	responseTextA = new JTextArea();
	responseTextA.setEditable(false);
	Responsepanel.add(responseTextA);
	
	JPanel Buttonpanel = new JPanel();
	Buttonpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	getContentPane().add(Buttonpanel);
	
	
	
JButton fuzzyButton = new JButton("Fuzzy Check Solutions");
	
fuzzyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			InputCheck ic = new InputCheck();
			
			// Sets inputs to a String
				String user = userID.getText();
				String cT = clumpThinkness.getText();
				String uSize = uniformityOfCellSize.getText();
				String uShape = uniformityOfCellShape.getText();
				String mA = MarginalAdhesion.getText();
				String sSize = singleEpithelialCellSize.getText();
				String bN = bareNuclei.getText();	
				String bC = blandChromatin.getText();
				String nN = normalNucleoli.getText();
				String m = mitoses.getText();
							
				//Checks if inputs are valid
										
				if((ic.checkEntry(cT) == true) && (ic.checkEntry(uSize) == true)) {
						if((ic.checkEntry(uShape)== true) && (ic.checkEntry(mA) == true)) {
							if((ic.checkEntry(sSize) == true) && (ic.checkEntry(bN) == true)){
										if((ic.checkEntry(bC) == true) && (ic.checkEntry(nN) == true)) {
												if(ic.checkEntry(m) == true) {
						
					FuzzyCaseChecker fcc = new FuzzyCaseChecker();
					fcc.userFuzzyInput(user, cT, uSize, uShape, mA, sSize, bN, bC, nN, m);
					}
				}
			}
		}
	}
		else {
				myGUI.responseText("Inputs must be low, medium or high ");
			}	
				
			
				
		}
		});
		
		Buttonpanel.add(fuzzyButton);
	
	
	//creating check button
	JButton checkButton = new JButton("CBR Check Solutions");
	checkButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//check the person
			User current = new User();
			
			
			current.clumpThinkness = Double.parseDouble(clumpThinkness.getText());
			String cT = Double.toString(current.clumpThinkness);
			
			current.uniformityOfCellSize = Double.parseDouble(uniformityOfCellSize.getText());
			String uSize = Double.toString(current.clumpThinkness);
			
			current.uniformityOfCellShape = Double.parseDouble(uniformityOfCellShape.getText());
			String uShape = Double.toString(current.uniformityOfCellShape);
			
			current.MarginalAdhesion = Double.parseDouble(MarginalAdhesion.getText());
			String mA = Double.toString(current.MarginalAdhesion);
			
			current.singleEpithelialCellSize = Double.parseDouble(singleEpithelialCellSize.getText());
			String sSize = Double.toString(current.singleEpithelialCellSize);
			
			current.bareNuclei = Double.parseDouble(bareNuclei.getText());			
			String bN = Double.toString(current.bareNuclei);
			
			current.blandChromatin = Double.parseDouble(blandChromatin.getText());
			String bC = Double.toString(current.blandChromatin);
			
			current.normalNucleoli = Double.parseDouble(normalNucleoli.getText());
			String nN = Double.toString(current.normalNucleoli);
			
			current.mitoses = Double.parseDouble(mitoses.getText());
			String m = Double.toString(current.mitoses);
		
			
			
	//		This is for case checker
			CaseCheck cs = new CaseCheck();
		
			cs.loadSpecific(userID.getText(), cT, uSize, uShape, mA, sSize, bN, bC, nN, m);
			  Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		}
	});
	Buttonpanel.setLayout(new GridLayout(5, 1, 0, 0));
	Buttonpanel.add(checkButton);
	
	//creating save button
	JButton saveButton = new JButton("Save Case");
	
	saveButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

			//if no then throw errors to field at bottom
			User current = new User();
			current.userID = Integer.parseInt(userID.getText());
			String uID = Integer.toString(current.userID);
			
			current.clumpThinkness = Double.parseDouble(clumpThinkness.getText());
			String cT = Double.toString(current.clumpThinkness);
			
			current.uniformityOfCellSize = Double.parseDouble(uniformityOfCellSize.getText());
			String uSize = Double.toString(current.uniformityOfCellSize);
			
			current.uniformityOfCellShape = Double.parseDouble(uniformityOfCellShape.getText());
			String uShape = Double.toString(current.uniformityOfCellShape);
			
			current.MarginalAdhesion = Double.parseDouble(MarginalAdhesion.getText());
			String mA = Double.toString(current.MarginalAdhesion);
			
			current.singleEpithelialCellSize = Double.parseDouble(singleEpithelialCellSize.getText());
			String sSize = Double.toString(current.singleEpithelialCellSize);
			
			current.bareNuclei = Double.parseDouble(bareNuclei.getText());			
			String bN = Double.toString(current.bareNuclei);
			
			current.blandChromatin = Double.parseDouble(blandChromatin.getText());
			String bC = Double.toString(current.blandChromatin);
			
			current.normalNucleoli = Double.parseDouble(normalNucleoli.getText());
			String nN = Double.toString(current.normalNucleoli);
			
			current.mitoses = Double.parseDouble(mitoses.getText());
			String m = Double.toString(current.mitoses);
	    //  WriteExcel Class;
	      WriteExcel rw = new WriteExcel();
			rw.saveSpecific( uID , cT, uSize, uShape, mA, sSize , bN, bC, nN, m );
			
		}
	});
	
	Buttonpanel.add(saveButton);
	
	JButton loadButton = new JButton("Load Case By User ID");
	loadButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//Loads specific case
			ReadExcel rw = new ReadExcel();
			User temp = new User();
			temp = rw.loadSpecific(userID.getText());
			
			//set all fields to loaded persons details AND clear others
			
			clumpThinkness.setText(String.valueOf(temp.clumpThinkness));
			uniformityOfCellSize.setText(String.valueOf(temp.uniformityOfCellSize));
			uniformityOfCellShape.setText(String.valueOf(temp.uniformityOfCellShape));
			MarginalAdhesion.setText(String.valueOf(temp.MarginalAdhesion));
			singleEpithelialCellSize.setText(String.valueOf(temp.singleEpithelialCellSize));
			bareNuclei.setText(String.valueOf(temp.bareNuclei));
			blandChromatin.setText(String.valueOf(temp.blandChromatin));
			normalNucleoli.setText(String.valueOf(temp.normalNucleoli));
			mitoses.setText(String.valueOf(temp.mitoses));

		}
	});
	loadButton.setToolTipText("Will load case based on name field");
	Buttonpanel.add(loadButton);
	
	JButton Clear = new JButton("Clear All");
	Clear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//clears all
			userID.setText("");
			clumpThinkness.setText("");
			uniformityOfCellSize.setText("");
			uniformityOfCellShape.setText("");
			MarginalAdhesion.setText("");
			singleEpithelialCellSize.setText("");
			bareNuclei.setText("");
			blandChromatin.setText("");
			normalNucleoli.setText("");
			mitoses.setText("");
			responseTextA.setText("");	
			

			
		}
	});
	Clear.setToolTipText("Clears The Screen");
	Buttonpanel.add(Clear);
}


private class SwingAction extends AbstractAction {
	public SwingAction() {
		putValue(NAME, "SwingAction");
		putValue(SHORT_DESCRIPTION, "Some short description");
	}
	public void actionPerformed(ActionEvent e) {
	}
}

//updates the response text field
public static void responseText(String text) {
	responseTextA.setText(text);
}


//Checks the fuzzy inputs
public class InputCheck{

	public boolean checkEntry(String input) {
	
	if(input.equals("low") || input.equals("low-med") ||input.equals("medium") || input.equals("high-med")|| input.equals("high")) {
	return true;
	}
	else {
		System.out.print(input);
		return false;
	}
	}
	
	
//Changes user inputs to fuzzy alternative 
	public String fuzzyUp(String input) {
		if(input.equals("1") || input.equals("2")) {
			return input = "low";
		}else if(input.equals("3") || input.equals("4")) {
			return input = "low-med";
		}else if(input.equals("5") || input.equals("6")) {
			return input = "medium";
		}else if(input.equals("7") || input.equals("8")) {
			return input = "high-med";
		}else if(input.equals("9") || input.equals("10")) {
			return input = "high";
		}else 
			return input = " ";
		
		
	}
	
	
	
	}





}