import java.io.*;
import java.util.*;

class Main {


	static int cycleLength = 0;
	
	
	static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

	static int parseNumRange(int num1, int num2)
	{
		
		int save = 0;
		int temp = 0;
		int min;
		int max;
		int Cmax = 0;
		
		if (num1 < num2) 
		{ 
			min=num1; 
			max=num2; 
		} 
		else 
		{ 
			min=num2; 
			max=num1; 
		}
		
		
			while (min <= max)
			{
				cycleLength = 1;
				save = min;
				
				while (save != 1)
				{ 
					
					
					if (save % 2 == 0)
					{
						save = evenOp(save);
						
					}
					else 
					{
						save = oddOp(save);
						
					}
				}
				
				min = min + 1;
				temp = cycleLength;
				
				cycleLength = 0;
					
					if (temp > Cmax)
					{
						Cmax = temp;
						
					}
				
			}
			
			return Cmax;
	}
	
	static int evenOp(int Op)
	{
		cycleLength = cycleLength + 1;
		Op = Op/2;
		
		return Op;
	}
	
	static int oddOp(int Op)
	{
		cycleLength = cycleLength + 1;
		Op = (Op*3) + 1;
		
		return Op;
	}
	
	
	public static void main(String[] args) 
	{
		Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
		
	}
	
	void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, cyclemax;

        while ((input = Main.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          a = Integer.parseInt (idata.nextToken());
          b = Integer.parseInt (idata.nextToken());
          cyclemax = parseNumRange(a, b);
		  
          
          System.out.println (a + " " + b + " " + cyclemax);
        }
    }
	

}


