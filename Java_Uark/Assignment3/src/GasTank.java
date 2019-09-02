
public class GasTank 
{
	
	private int capacity;
	private double level;
	
	public GasTank (int capacity)
	{
		if (capacity >= 0)
		{
			this.capacity = capacity;
		}
		else
		{
			this.capacity = 0;
		}
		
		this.level = 0.00;
	}
	
	public int getCapacity ()
	{
		return capacity;
	}
	
	public double getLevel()
	{
		return level;
	}
	
	public void setLevel (double levelIn)
	{
		if (levelIn >= 0 && levelIn <= this.capacity)
		{
			this.level = levelIn;
		}
		else if (!(levelIn >= 0)) 
		{
			this.level = 0.0;
		}
		else if (levelIn > this.capacity)
		{
			this.level = this.capacity;
		}
	}

}
