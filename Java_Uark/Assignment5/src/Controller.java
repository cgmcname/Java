
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.updateImage(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) 
		{
			// Gets here is left mouse button was clicked
			model.makeS(e.getX(), e.getY());
			view.repaint();
		} 
		else if (SwingUtilities.isRightMouseButton(e))  
		{
			// Gets here if right mouse button was clicked
			 model.updateScene(1000, 700);
			 view.repaint();
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    
    @Override
	public void keyPressed(KeyEvent e) 
    {
    	RobberCar checksprite;
    	checksprite = new RobberCar();
		
    	int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_N)
		{
			
			System.out.println("# jailed: " + checksprite.getJailed() );
			System.out.println("# escaped: " + checksprite.getEscaped());
		}
		if (keyCode == KeyEvent.VK_R)
		{
			model.initialize();
			view.repaint();
		}
		if (keyCode == KeyEvent.VK_S)
		{
			
			SpriteMover movin = null; 
			Thread t1;
			
			try {
				movin = new SpriteMover(model, view);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
			t1 = new Thread(movin);
			
			t1.start();
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
		/*int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_0)
		{
			System.out.println("hello world");
			//model.makeS(300, 300);
			//view.repaint();
		}
		else
		{
			System.out.println("keycode is: " + keyCode);
		}*/
	}
    
   
    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }

	
}



