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
	
	boolean cap = false;
	boolean escape = false;
	
	static int jailed = 0;
	static int escaped = 0;
	
	RobberCar()
	{
		
		super("", 5000, robberEngine, "yeah.jpg");
		
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
        
		this.drive(40, RCxratio, RCyratio);
		super.update(g);
		
	}*/
	
	public void updateState(int height, int width)
	 {
		if (this.cap == true)
		{
			this.drive(0, 0, 0);
		}
		else
		{
			this.drive(4, RCxratio, RCyratio);
		}
		
		if ((this.getX() < 20 || this.getX() > 1000)||(this.getY() < 0 || this.getY() > 700))
		 {
			if (this.escape == false)
			{
				escaped++;
				
			}
				this.escape = true;
				
				
		 }
		 
		
	 }
	 
	 public void updateImage(Graphics g)
	 {
		 super.updateImage(g);
	 }
	 
	 public void captured()
	 {
		this.setImage("what.jpg"); 
		if (this.cap == false)
		{
			jailed++;
			
		}
		this.cap = true;
		
	 }
	 
	 public int getJailed()
	 {
		 return jailed;
	 }
	 
	 public void setEscaped()
	 {
		  escaped = 0;
	 }
	 
	 public void setJailed()
	 {
		 jailed = 0;
	 }
	 
	 public int getEscaped()
	 {
		 return escaped;
	 }
	 
	 public boolean isCaptured()
	 {
		
		if (cap == true)
		{
			
			return true;
		}
		else 
		{
			return false;
		}
	 }
	 
	 public boolean hasEscaped()
	 {
		
		if (escape == true)
		{
			
			return true;
		}
		else 
		{
			return false;
		}
	 }
}