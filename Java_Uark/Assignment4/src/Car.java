import java.awt.Graphics;

public class Car extends Sprite
{
	
	private String carDescription;
	 //private int x_coordinate;
	//private int y_coordinate;
	
	String  carjpgName;
	
	GasTank carGasTank;
	Engine carEngine;
	
	
	Car (String carDescription, int maxFuel, Engine carEngine, String carjpgName)
	{
		super(carjpgName);
		
		if (carDescription.length() == 0)
		{
			this.carDescription = "Generic car";
		}
		else
		{
			this.carDescription = carDescription;
		}
		
		this.carEngine = carEngine;
		
		this.carGasTank = new GasTank(maxFuel);
		
		if (carEngine == null)
		{
			this.carEngine = new Engine("", 0, 0);
		}
		
	}
	
	
	
	public String getDescription()
	{
		String point2 = String.format("%.2f", carGasTank.getLevel());
		
		return carDescription  + " (" + carEngine.getDescription()   + " , fuel ; " 
				+ point2 + "/" + carGasTank.getCapacity() + " , location: (" 
				+ this.getX() + "," + this.getY() + ")"; 
	}
	
	/*public int getX()
	{
		return x_coordinate;
	}
	
	public int getY()
	{
		return y_coordinate;
	}*/
	
	public double getFuelLevel()
	{
		double FuelLevel = carGasTank.getLevel();
		return FuelLevel;
	}
	
	public int getMPG()
	{
		int MPG = carEngine.getMpg();
		return MPG;
	}
	
	public void fillUp()
	{
		int fill = carGasTank.getCapacity();
		carGasTank.setLevel(fill);
	}
	
	public int getMaxSpeed()
	{
		int MaxSpeed = carEngine.getMaxSpeed();
		return MaxSpeed;
	}
	
	
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		
		double save = getFuelLevel() * getMPG();
		
		carGasTank.setLevel((double)getFuelLevel() -  ((double)distance/(double)getMPG()));
		
		if (getFuelLevel() <= 0)
		{
			distance = (int) save ;
			System.out.print("Ran out of gas after driving ");
			System.out.format("%.2f", save); 
			System.out.println(" miles.");
		}
		
		int save_x;
		int save_y;
		
		double xandy;
		xandy = Math.atan(yRatio/xRatio);

		save_x = (int) ((Math.cos(xandy)* distance));
		save_y = (int) ((Math.sin(xandy)* distance));
		
	
		if (xRatio < 0 )
		{
			if (save_x > 0 )
			{
				save_x =  save_x * -1;
			}
		}
		
		if (yRatio < 0)
		{
			if (save_y > 0)
			{
				save_y =  save_y * -1;
			}
		}
		
		if (xRatio > 0 )
		{
			if (save_x < 0 )
			{
				save_x =  save_x * -1;
			}
		}
		
		if (yRatio > 0)
		{
			if (save_y < 0)
			{
				save_y =  save_y * -1;
			}
		}
		
		
		this.setX(save_x + this.getX());
		this.setY(save_y + this.getY());
		
		double dis = distance;
		
		return dis;
		
	}
	
	public void update(Graphics g) {
        
		super.update(g);
		
	}

}
