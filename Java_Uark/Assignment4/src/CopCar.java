import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car 
{
	
	private static int RCxratio;
	private static int RCyratio;
	
	int choice = 0;
	
	Random rand = new Random();
	Random rand2 = new Random(); 
	
	static Engine copEngine = new Engine("", 30, 100);
	
	
	
	CopCar()
	{
		
		super("CopCar", 30, copEngine, "cop-car.jpg");
		
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
         
		this.drive(20, RCxratio, RCyratio);
		super.update(g);
		
	}

}
