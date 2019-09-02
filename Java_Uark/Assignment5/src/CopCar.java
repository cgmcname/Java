import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car 
{
	
	private static int RCxratio;
	private static int RCyratio;
	
	static int saveheight;
	static int savewidth;
	
	boolean xtrue = false;
	boolean ytrue = false;
		
	int choice = 0;
	
	Random rand = new Random();
	Random rand2 = new Random(); 
	
	static Engine copEngine = new Engine("", 30, 100);
	
	
	
	CopCar()
	{
		
		super("CopCar", 5000, copEngine, "cop-car.jpg");
		
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
	
	/*public void update(Graphics g) 
	{
         
		this.drive(20, RCxratio, RCyratio);
		super.update(g);
		
	}*/
	
	 public void updateState(int height, int width)
	 {
		
		 saveheight =  this.getX();
		 savewidth =  this.getY();
		 if (this.getX() < 0 || this.getX() > 1000)
		 {
			 if (xtrue == true)
			 {
				 xtrue = false;
			 }
			 else if (xtrue == false)
			 {
				 xtrue = true;
			 }
		 }
		 
		 if (this.getY() < 0 || this.getY() > 700)
		 {
			 if (ytrue == true)
			 {
				 ytrue = false;
			 }
			 else if (ytrue == false)
			 {
				 ytrue = true;
			 }
		 }
		 
		 if (xtrue == false && ytrue == false) 
		 {
			 this.drive(2, RCxratio, RCyratio); 
		 }
		 
		 if (xtrue == true && ytrue == true)
		 {
			 this.drive(2, RCxratio * -1, RCyratio * -1);
		 }
		 
		 if (xtrue == true)
		 {
			 this.drive(2, RCxratio * -1, RCyratio ); 
		 }
		 
		 if (ytrue == true)
		 {
			 this.drive(2, RCxratio , RCyratio * -1 ); 
		 }
			 
		
		
		 
	 }
	 
	 public void updateImage(Graphics g)
	 {
		 super.updateImage(g);
	 }

}
