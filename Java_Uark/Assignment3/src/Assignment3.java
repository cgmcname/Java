import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Assignment3 
{

	public static void main(String[] args) 
	{
		
		
		
		String CarD, FuelD, EngineD, MPGD, maxSD, message, legD, distanceD, xD, yD;
		
		int Fuelint, MPGint, maxSpeedint, legInt;
		
		int [] numDistance;
		
		double milesDriven = 0.0;
		double totalMilesDriven = 0.0;
		
		double [] numX;
		double [] numY;
		
		int [] DrivePanelx;
		int [] DrivePanely;
		
		CarD = JOptionPane.showInputDialog(null, "Please enter the car's desciption", "Car desciption", JOptionPane.QUESTION_MESSAGE);
		
		FuelD = JOptionPane.showInputDialog(null, "Please enter the fuel tank capacity", "Fuel tank capacity", JOptionPane.QUESTION_MESSAGE);
		Fuelint =  parse(FuelD);
		
		while (Fuelint <= 0)
		{
			FuelD = JOptionPane.showInputDialog(null, "Please enter the fuel tank capacity", "Fuel tank capacity", JOptionPane.QUESTION_MESSAGE);
			Fuelint =  parse(FuelD);
		}
		
		EngineD = JOptionPane.showInputDialog(null, "Please enter the engine description", "Engine desciption", JOptionPane.QUESTION_MESSAGE);
		
		MPGD = JOptionPane.showInputDialog(null, "Please enter the miles per gallon", "Miles per gallon", JOptionPane.QUESTION_MESSAGE);
		MPGint = parse(MPGD);
		
		while (MPGint <= 0)
		{
			MPGD = JOptionPane.showInputDialog(null, "Please enter the miles per gallon", "Miles per gallon", JOptionPane.QUESTION_MESSAGE);
			MPGint = parse(MPGD);
		}
		
		maxSD = JOptionPane.showInputDialog(null, "Please enter the max speed", "Max Speed", JOptionPane.QUESTION_MESSAGE);
		maxSpeedint = parse(maxSD);
		
		while (maxSpeedint <= 0)
		{
			maxSD = JOptionPane.showInputDialog(null, "Please enter the max speed", "Max Speed", JOptionPane.QUESTION_MESSAGE);
			maxSpeedint = parse(maxSD);
		}
		
		
		Engine engineEngine = new Engine(EngineD, MPGint, maxSpeedint);
		Car carCar = new Car (CarD, Fuelint, engineEngine );
		
		message = carCar.getDescription();
		
		JOptionPane.showMessageDialog(null, message,"Overall info", JOptionPane.INFORMATION_MESSAGE);
		
		legD = JOptionPane.showInputDialog(null, "Please enter the number of legs on the trip", "Trip legs", JOptionPane.QUESTION_MESSAGE);
		legInt = parse(legD);
		
		while (legInt <= 0)
		{
			legD = JOptionPane.showInputDialog(null, "Please enter the number of legs on the trip", "Trip legs", JOptionPane.QUESTION_MESSAGE);
			legInt = parse(legD);
		}
		
		numDistance = new int [legInt];
		numX = new double [legInt];
		numY = new double [legInt];
		DrivePanelx = new int [legInt];
		DrivePanely = new int [legInt];
		
		for (int i = 0; i < legInt; i++)
		{
			distanceD = JOptionPane.showInputDialog(null, "Please enter the distance for leg " + (i + 1), "Distance", JOptionPane.QUESTION_MESSAGE);
			numDistance[i] = parse(distanceD);
			
			while (numDistance[i] <= 0)
			{
				distanceD = JOptionPane.showInputDialog(null, "Please enter the distance for leg " + (i + 1), "Distance", JOptionPane.QUESTION_MESSAGE);
				numDistance[i] = parse(distanceD);
			}
			
			xD = JOptionPane.showInputDialog(null, "Please enter the x ratio for leg " + (i + 1) , "x Ratio", JOptionPane.QUESTION_MESSAGE);
			numX[i] = parseD(xD);
			yD = JOptionPane.showInputDialog(null, "Please enter the y ratio for leg " + (i + 1), "y Ratio", JOptionPane.QUESTION_MESSAGE);
			numY[i] = parseD(yD);
		}
		
		carCar.fillUp();
		
		DrivePanel panel = new DrivePanel();
		
		for (int i = 0; i < legInt; i++)
		{
			
			milesDriven = carCar.drive(numDistance[i], numX[i], numY[i]);
			totalMilesDriven = totalMilesDriven + milesDriven;
			System.out.printf("Car3 drove %.2f miles\n", milesDriven);
			System.out.println("Car3: " + carCar.getDescription());
			DrivePanelx[i] = carCar.getX();
			DrivePanely[i] = carCar.getY();
		}
		
		panel.setX(DrivePanelx);
		panel.setY(DrivePanely);
		
		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		application.add(panel);
		application.setSize(600, 600);
		application.setVisible(true);
	}
	
	public static Integer parse(String input) 
	{
		  try 
		  {
		    return Integer.parseInt(input);
		  } 
		  catch (NumberFormatException e) 
		  {
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting ","Exit", JOptionPane.INFORMATION_MESSAGE); 
			System.exit(0);
		    return 0;
		  }
	}
	
	public static Double parseD(String input) 
	{
		  try 
		  {
		    return Double.parseDouble(input);
		  } 
		  catch (NumberFormatException e) 
		  {
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting ","Exit", JOptionPane.INFORMATION_MESSAGE); 
			System.exit(0);
		    return 0.0;
		  }
	}

}
