import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car 
{
	private int RCxratio;
	private int RCyratio;
	
	int choice = 0;
	
	Random rand = new Random();
	Random rand2 = new Random(); 
	
	static Engine robberEngine = new Engine("", 20, 200);
	
	
	
	RobberCar()
	{
		
		super("", 20, robberEngine, "red-car.jpg");
		
		this.fillUp();
		
		choice = rand2.nextInt(10);
		
		if ( choice % 2 == 0 )
		{
			RCxratio = rand.nextInt(5);
		}
		else
		{
			int save;
			save = rand.nextInt(5);
			RCxratio = save - (save*2);
		}
		
		choice = rand2.nextInt(10);
		
		if ( choice % 2 == 0 )
		{
			RCyratio = rand.nextInt(5);
		}
		else
		{
			int save;
			save = rand.nextInt(5);
			RCyratio = save - (save*2);
		}
		
	}
	
	public void update(Graphics g) 
	{
        
		this.drive(40, RCxratio, RCyratio);
		super.update(g);
		
	}

}