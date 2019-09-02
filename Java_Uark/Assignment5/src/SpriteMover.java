import java.io.IOException;

public class SpriteMover implements Runnable 
{

   
	Model model;
	View view;
	
	SpriteMover(Model model, View view) throws IOException
	{
		this.model = model;
		this.view = view;
	}

	@Override
	public void run() 
	{
		
		while(true)
		{
			model.updateScene(1000, 700);
			view.repaint();
			
			try
			{
				Thread.sleep(2);
			} 
			catch (InterruptedException e){ }
		}

	

	}
}
