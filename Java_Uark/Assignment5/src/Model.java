import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

class Model
{
	ArrayList<Sprite> spriteL = new ArrayList<Sprite>();
    private Sprite sprite;
    private Car carSprite;
    
    static int alternate = 0;
    
    Random rand = new Random();
	Random rand2 = new Random();
	
	int choice = 0;
	

    Model() throws IOException 
    {
    	
    	sprite = new Bank( );
    	spriteL.add(sprite);
    	
    	alternate++;
		
    }
    
    public synchronized void initialize()
    {
    	RobberCar checksprite;
    	checksprite = new RobberCar();
    	checksprite.setEscaped();
    	checksprite.setJailed();
    	
    	spriteL.clear();
    	
    	sprite = new Bank( );
    	spriteL.add(sprite);
    	
    }

    public synchronized void updateImage(Graphics g) 
    {
    	for (int i = 0; i < spriteL.size(); i++)
    	{
    		sprite = spriteL.get(i);
    		sprite.updateImage(g);
    	}
    }
    
    /*public void reupdate() 
    {
    	for (int i = 0; i < spriteL.size(); i++)
    	{
    		
    		sprite = spriteL.get(i);
    		carSprite = (Car) sprite;
    		carSprite.fillUp();
    		
    	}
    }*/
    
    public synchronized void  updateScene(int height, int width)
    {
    	Iterator<Sprite> it = spriteL.iterator();
    	
    	for (int i = 0; i < spriteL.size(); i++)
    	{
    		
    		
    		sprite = it.next();
    		
    		//sprite = spriteL.get(i);
    		//carSprite = (Car) sprite;
    		//carSprite = (Car) sprite;
    	
    		//carSprite.updateState(1000, 700);
    		
    		if (sprite instanceof RobberCar)
    		{
    			int j = 1;
    			while ( j < spriteL.size())
    			{
    				if((sprite.overlaps(spriteL.get(j)) == true) && spriteL.get(j) instanceof CopCar)
    				{
    					((RobberCar)sprite).captured();
    				}
    					
    			
    				j++;
    			}
    			
    			if (((RobberCar) sprite).hasEscaped())
    			{
    				it.remove();
    				System.out.println("I'm Free");
    			}
    		}
    		
    		
    		
    		
    		sprite.updateState(1000, 700 );
    	}
    	
    	/*while (it.hasNext())
    	{
    		sprite = it.next();
    		if (sprite instanceof RobberCar)
    		{
    			System.out.println("Test yo");
    			if (((RobberCar) sprite).hasEscaped())
    			{
    				it.remove();
    				System.out.println("I'm Free");
    			}
    		}
    	}*/
		
    	
    
    }
    
    public synchronized void makeS (int x, int y)
    {
    	
    	
    	if ( alternate % 2 == 0 )
        {
    		carSprite = new CopCar( );
        	spriteL.add(carSprite);
        	carSprite.setX(x);
        	carSprite.setY(y);
        }
        else
        {
        	carSprite = new RobberCar( );
			spriteL.add(carSprite);
			carSprite.setX(300);
        	carSprite.setY(300);
        }
    	
    	alternate++;
    }
}
