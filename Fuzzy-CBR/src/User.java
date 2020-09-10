import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User  implements Serializable {

	public int userID;
	public double clumpThinkness;
	public double uniformityOfCellSize;
	public double uniformityOfCellShape;
	public double MarginalAdhesion;
	public double singleEpithelialCellSize;
	public double bareNuclei;
	public double blandChromatin;
	public double normalNucleoli;
	public double mitoses;

	public ObjectOutputStream os;
	
	//constructor
	public User() {
		
	}
	/*
public User(int userID, double clumpThinkness, double uniformityOfCellSize, double uniformityOfCellShape, double MarginalAdhesion, double singleEpithelialCellSize, double bareNuclei, double blandChromatin, double normalNucleoli, double mitoses) {
	int uID = userID;	
	double cT = clumpThinkness;
	double uSize = uniformityOfCellSize;
	double uShape = uniformityOfCellShape;
	double mA = MarginalAdhesion;
	double sSize = singleEpithelialCellSize;
	double bN = bareNuclei;
	double bC = blandChromatin;
	double nN = normalNucleoli;
	double m = mitoses;
	
	}
	*/
	
}
