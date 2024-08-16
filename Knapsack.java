/*
	PrintSubSets.java
*/
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.io.File;

public class Knapsack
{
	
	public static void main( String[] args )
	{	
		final int SETLEN = 16;
	
		int[] set = new int[SETLEN];	// 5 elements produces 2^5 subsets ( 32 subsets ) // , 79, 80, 32, 43, 54, 65, 76, 87, 98, 27 
		int target = 0; // 13, 24, 57

		try{
			if (args.length < 1)
			{
				System.out.println("\nusage: C: \\> java Knapsack <input filename> \n");
				System.exit(0);
			}
			File file = new File(args[0]);
			Scanner infile = new Scanner(file);
			
			for (int i = 0; i<16; i++)
				if (infile.hasNextInt())
					set[i] = infile.nextInt();
				if (infile.hasNext()) target = infile.nextInt();
		}catch (Exception e){}

		for ( int i=0 ; i<(Math.pow(2, set.length)) - 1; ++i)
		{	
			int total = 0;
			String bitmap = toBitString( i, set.length );
			String subset = "";
			for ( int bindx=0 ; bindx<set.length ; ++bindx )
				if ( bitmap.charAt(bindx)=='1' )
				{
					total = total + set[bindx];
					subset = subset + set[bindx] + " ";
				}	
				else
					System.out.print(""); 
			if (total == target)
			{
				System.out.println(subset);
			}
		}

	} // END MAIN

	// i.e number 31 converted to a width of 5 bits = "11111"
	//     nuumber 7 converted to a width of 5 bits = "00111"
	static String toBitString( int number, int width )
	{
		String bitstring = "";
		while (number > 0)
		{	if (number % 2 == 0)
				bitstring = "0" + bitstring;
			else
				bitstring = "1" + bitstring;
			number /= 2 ;
		}
		while ( bitstring.length() < width )
				bitstring = "0" + bitstring;
		return bitstring;
	}
} // END CLASS