import java.util.Random;


public class HW5 {
	
	final static int SIZE = 1009;
	static int Table1[] = new int[SIZE];
	static int Table2[] = new int[SIZE];
	static int Table3[] = new int[SIZE];
	static int probe;
	static int totalProbe;
	
	static int HashL(int[]T, int k)
	{
		int j;
		int index = 0;
		//System.out.print(T.length);
		while (index < T.length)
		{
			j = Linear(k, index);
			
			if (T[j] == 0)
			{
				T[j] = k;
				
				return j;
			}
			else
			{
				index++;
				
			}
		}
		
		return 0;
	}
	
	static int HashLP(int[]T, int k)
	{
		int j;
		int index = 0;
		
		while (index < T.length)
		{
			j = Linear(k, index);
			
			if (T[j] == 0)
			{
				T[j] = k;
				totalProbe += probe;
				probe = 0;
				return j;
			}
			else
			{
				index++;
				probe++;
			}
		}
		
		return 0;
	}
	
	static int Linear(int k, int i)
	{
		int result;
		result = (k + i) % SIZE;
		return result;
	}
	
	static int HashQ(int[]T, int k)
	{
		int j;
		int index = 0;
		//System.out.print(T.length);
		while (index < T.length)
		{
			j = Quad(k, index);
			
			if (T[j] == 0)
			{
				T[j] = k;
				
				return j;
			}
			else
			{
				index++;
				
			}
		}
		
		return 0;
	}
	
	static int HashQP(int[]T, int k)
	{
		int j;
		int index = 0;
		//System.out.print(T.length);
		while (index < T.length)
		{
			j = Quad(k, index);
			
			if (T[j] == 0)
			{
				T[j] = k;
				totalProbe += probe;
				probe = 0;
				return j;
			}
			else
			{
				index++;
				probe++;
			}
		}
		
		return 0;
	}
	
	static int Quad(int k, int i)
	{
		int result;
		result = (k + (i * 1) +(3*(i*i))) % SIZE;
		return result;
	}
	
	static int HashD(int[]T, int k)
	{
		int j;
		int index = 0;
		//System.out.print(T.length);
		while (index < T.length)
		{
			j = Double(k, index);
			
			if (T[j] == 0)
			{
				T[j] = k;
				
				return j;
			}
			else
			{
				index++;
				
			}
		}
		
		return 0;
	}
	
	static int HashDP(int[]T, int k)
	{
		int j;
		int index = 0;
		//System.out.print(T.length);
		while (index < T.length)
		{
			j = Double(k, index);
			
			if (T[j] == 0)
			{
				T[j] = k;
				totalProbe += probe;
				probe = 0;
				return j;
			}
			else
			{
				index++;
				probe++;
			}
		}
		
		return 0;
	}
	
	static int Double(int k, int i)
	{
		int result;
		result = (k + (i * (k % (SIZE - 1)))) % SIZE;
		return result;
	}

	public static void main(String[] args) 
	{
		
		int j;
		
		// Linear set 900
		for(int i = 0; i < 900; i++)
		{
			int k = (int) (Math.random() * 65536);
			
			j = HashL(Table1,k);
			Table1[j] = k;
			
			
		}
		
		// Linear add 50 elements and count probes
		for(int i = 0; i < 50; i++)
		{
			int k = (int) (Math.random() * 65536);
			
			j = HashLP(Table1,k);
			Table1[j] = k;
			
			
		}
		
		
		System.out.print("Total number of probes for the last 50 elements (Linear) " + totalProbe);	
		System.out.print("\n");
		
		totalProbe = 0;
		
		// Quad set 900
				for(int i = 0; i < 900; i++)
				{
					int k = (int) (Math.random() * 65536);
					
					j = HashQ(Table2,k);
					Table2[j] = k;
					
					
				}
				
				// Quad add 50 elements and count probes
				for(int i = 0; i < 50; i++)
				{
					int k = (int) (Math.random() * 65536);
					
					j = HashQP(Table2,k);
					Table2[j] = k;
					
					
				}
				
				
				
				System.out.print("Total number of probes for the last 50 elements (Quadratic) " + totalProbe);	
				System.out.print("\n");
				
				totalProbe = 0;
				
				for(int i = 0; i < 900; i++)
				{
					int k = (int) (Math.random() * 65536);
					
					j = HashQ(Table3,k);
					Table3[j] = k;
					
					
				}
				
				// Quad add 50 elements and count probes
				for(int i = 0; i < 50; i++)
				{
					int k = (int) (Math.random() * 65536);
					
					j = HashQP(Table3,k);
					Table3[j] = k;
					
					
				}
				
		
				System.out.print("Total number of probes for the last 50 elements (Double hashing) " + totalProbe);	
				System.out.print("\n");
	}

}
