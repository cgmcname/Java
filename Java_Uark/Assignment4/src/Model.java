import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
    	
    	sprite = new CopCar( );
    	spriteL.add(sprite);
    	
    	choice = rand2.nextInt(10);
		
		if ( choice % 2 == 0 )
		{
			sprite.setX(rand.nextInt(5)); 
		}
		else
		{
			int save;
			save = rand.nextInt(5);
			save = save - (save*2);
			sprite.setX(save); 
		}
		
		choice = rand2.nextInt(10);
		
		if ( choice % 2 == 0 )
		{
			sprite.setY(rand.nextInt(5));
		}
		else
		{
			int save;
			save = rand.nextInt(5);
			save = save - (save*2);
			sprite.setY(save);
		}
      
    	
        alternate++;
		
    }

    public void update(Graphics g) 
    {
    	for (int i = 0; i < spriteL.size(); i++)
    	{
    		sprite = spriteL.get(i);
    		sprite.update(g);
    	}
    }
    
    public void reupdate() 
    {
    	for (int i = 0; i < spriteL.size(); i++)
    	{
    		
    		sprite = spriteL.get(i);
    		carSprite = (Car) sprite;
    		carSprite.fillUp();
    		
    	}
    }
    
    public void makeS (int x, int y)
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
			carSprite.setX(x);
        	carSprite.setY(y);
        }
    	
    	alternate++;
    }
}
