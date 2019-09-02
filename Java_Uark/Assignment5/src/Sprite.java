import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle; 

class Sprite
{
	private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;

	public  Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g)
	{
       
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	
	public void updateState(int height, int width)
	{
		
	}
	
	public boolean overlaps(Sprite s)
	{
		Rectangle bounds = new Rectangle(this.getX(), this.getY(), 60, 60); 
		Rectangle bounds2 = new Rectangle(s.getX(), s.getY(), 60, 60);
		
		
		if (bounds.contains(bounds2) || bounds.intersects(bounds2))
		{
			return true;
		}
		else if (bounds2.contains(bounds) || bounds2.intersects(bounds))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}