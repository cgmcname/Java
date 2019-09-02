//import java.awt.List;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner; 


public class Test {

	public static void main(String[] args) 
	{
		

		

	}

}

public List<int[]> getThem() 
{
	  List<int[]> list1 = new ArrayList<int[]>();
	  for (int[] x : theList)
	    if (x[0] == 4)
	      list1.add(x);
	  return list1;
};



/*

What this thing does:
Create a new list of arrays of ints. (??)
For the arrays in a second list of arrays of ints, 
if the int at index zero of that second list is 0,
add that entry in the list to the first list.
Return the first list. 

We are building a List object of arrays that begin with the number 4.


- The original program was not recognizing List as a generic type and not allowing it to be called with the argument type.
Solution: Some research into Java showed us that there was another List type in java.util.List that was generic.
Using that import fixed the problem.

- getThem is not helpful, rename to something that actually makes sense to what the function does. 

- Include list theList in the arguments of the function, or else we won't have it to work with.  (??)
- Alternative: Build this as a method in a class that operates on a private variable theList (or whatever we call it)

- Give theList a better name.

- Give list1 a name that actually tells what it is we want to return.

- None of the loops are correct by syntax. Include { and } in appropriate places.



*/