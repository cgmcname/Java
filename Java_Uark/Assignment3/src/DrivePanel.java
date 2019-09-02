import java.awt.Graphics;
import javax.swing.JPanel;

public class DrivePanel extends JPanel
{
	private int [] pass_x;
	private int [] pass_y;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//int width = getWidth();
		int height = getHeight();
		
		
		g.drawLine(0, height,(int) pass_x[0], height-(int)pass_y[0]);
		g.drawString("(" + pass_x[0] + "," + pass_y[0] + ")", pass_x[0] + 10, height-(int)pass_y[0]);
		
		for (int i = 1; i < pass_x.length; i++)
		{
		g.drawLine(pass_x[i-1], height-(int)pass_y[i-1],(int) pass_x[i], height-(int)pass_y[i]);
		g.drawString("(" + pass_x[i] + "," + pass_y[i] + ")", pass_x[i] + 10, height-(int)pass_y[i]);
		}
	}
	
	public void setX(int [] x )
	{
		pass_x = new int [x.length];
		
		for (int i = 0; i < x.length; i++)
		{
			pass_x[i] = x[i]; 
		}
	}
	
	public void setY(int [] y)
	{
		pass_y = new int [y.length];
		
		for (int i = 0; i < y.length; i++)
		{
		pass_y[i] = y[i]; 
		}
	}
	
	
	
}
