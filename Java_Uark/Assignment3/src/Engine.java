public class Engine 
{
	
	private String description;
	private int mpg;
	private int maxSpeed;
	
	public Engine()
	{
		description = "Generic engine";
		mpg = 0;
		maxSpeed = 0;
	}
	
	public Engine(String description, int mpg, int maxSpeed)
	{
		if (description.length() != 0 && mpg >= 0 && maxSpeed >= 0)
		{
			this.description = description;
			this.mpg = mpg;
			this.maxSpeed = maxSpeed;
		}
		
		if(description.length() == 0)
		{
			description = "Generic engine";
			this.description = "Generic engine";
			this.mpg = mpg;
			this.maxSpeed = maxSpeed;
		}
		
		if (mpg < 0)
		{
			mpg = 0;
			this.description = description;
			this.mpg = 0;
			this.maxSpeed = maxSpeed;
		}
		
		if (maxSpeed < 0)
		{
			maxSpeed = 0;
			this.description = description;
			this.mpg = mpg;
			this.maxSpeed = 0;
		}
	}
	
	public String getDescription ()
	{
		return this.description + " (MPG: " + this.mpg + ", Max speed: " + this.maxSpeed + ")";
	}
	
	public int getMpg ()
	{
		return mpg;
	}
	
	public int getMaxSpeed()
	{
		return maxSpeed;
	}
	
}
