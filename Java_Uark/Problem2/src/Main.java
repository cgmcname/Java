import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; 

class Main {
	
	static int lineNum = 0;
	static int feildNum = 0;
	static int m = 0 ;
	static int n = 0 ;
	static char[][] mineFieldIn;
	static char[][] mineFieldOut; 
	static String [] minePlacement;
	static String [] minePlacementOut;
	static char [] minePass;
	
	
	

	public static void main(String[] args) 
	{
		
		Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point 
		

	}
	
	void Begin()
	{
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer idata;
		  
		String input = " ";
		
		try {
			input = new String(stdin.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
		idata = new StringTokenizer(input);
		  
		int a = 2, b = 2;

	    a = Integer.parseInt (idata.nextToken());
	    b = Integer.parseInt (idata.nextToken());
	    		
	    mineFieldIn = new char[a][b];
	    
	    minePass = new char [b];
	    minePlacement = new String [100];
	    minePlacementOut = new String [100];
	    
	    while (a != 0 && b != 0)
	    {
	        if (feildNum > 0)
	        {
	        	String input2 = "";
				
	        	try {
					input2 = new String(stdin.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	    	    StringTokenizer idata2;
	    	    

	    	    idata2 = new StringTokenizer(input2);
	    	       
	    	    a = Integer.parseInt (idata2.nextToken());
	    	    b = Integer.parseInt (idata2.nextToken());
	        }
	    	
	        if (a != 0 && b != 0)
	        {
	    	
	        	for(int i = 0; i < a; i++)
	        	{
	        		try {
						minePlacement[i] = stdin.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	
	        	}
	    	
	        	feildNum++;
	        	
	        	mineFieldIn = new char[a][b];
	        	
	        	for(int i = 0; i < a; i++)
	        	{
	        		minePass = minePlacement[i].toCharArray();
	        		mineFieldIn[i] = minePass;
	        	}
	        
	        
	        	buildFeild(a, b);
	        
	        	minePlacementOut[lineNum] = "Field #" + feildNum + ":";
	        	lineNum++;
	        	
	        	for(int i = 0; i < a; i++)
	        	{
	        		minePass = mineFieldOut[i];
	        		String test = new String(minePass);
	        		minePlacementOut[lineNum] = test;
	        		lineNum++;		
	        	} 
	    	
	        		minePlacementOut[lineNum]= " ";
	        		lineNum++;
	        }	
	    }   
	    
	    
	    
	    for (int i = 0; i < lineNum; i++ )
	    {
	    	System.out.print(minePlacementOut[i]);
	    	System.out.print("\n");
	    }
	        

	}
	

	
	static void buildFeild(int a, int b)
	 {
	        n = a;
			m = b;	
			mineFieldOut = new char[a][b];
			
			for(int y = 0; y < n; y ++) 
			{
				for(int x = 0; x < m; x ++) 
				{
					mineFieldOut[y][x] = minesNear(y, x);
	        
				}
	      
			}
	
	
	 }
	
	  
	 static char minesNear(int y, int x) 
	  {
		   	int mines = 0;
		    char value = '0';
		   
		    mines = mines + checkForMines(y - 1, x - 1);  // NW
		    
		    mines = mines + checkForMines(y - 1, x);      // N
		    
		    mines = mines + checkForMines(y - 1, x + 1);  // NE
		    
		    mines = mines + checkForMines(y, x - 1);      // W
		    
		    mines = mines + checkForMines(y, x + 1);      // E
		    
		    mines = mines + checkForMines(y + 1, x - 1);  // SW
		    
		    mines = mines + checkForMines(y + 1, x);      // S
		    
		    mines = mines + checkForMines(y + 1, x + 1);  // SE
		    
		    
		    if(mines > 0 && mineFieldIn[y][x] != '*') 
		    {
		    	
		    	value = Character.forDigit(mines, 10);
		    	return value;
		    }
		    if (mineFieldIn[y][x] == '*')
		    {
		    	  value = '*';
			      return value;
		    }
			 	
		    	return value;
		  }
	
	  static int checkForMines(int y, int x) 
	  {
		  
		    if(y >= 0 && y < n && x >= 0 && x < m && mineFieldIn[y][x] == '*') 
		    {
		      return 1;
		    } 
		    else 
		    {
		      return 0;
		    }
	  
	  }

}
