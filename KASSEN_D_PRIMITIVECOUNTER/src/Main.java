
import java.io.*;
import java.util.Scanner;

public class Main
{
	/*
	 * Default Constructor
	 */
	public Main(String path)
	{	
		String code = readCodeFromFile(path);
		PrimitiveCounter pc = new PrimitiveCounter(code);
		System.out.println(pc);
		System.out.println(pc.calculatePrimitiveCount(pc.getCodeLines(),"",0));
		System.out.println(pc.getBigOh(pc.getCodeLines()));
	}
	
	/*
	 * A function that reads from a text file and returns the whole file as a String
	 * @param: path of the file
	 */
	public String readCodeFromFile(String path)
	{
		String code = "";
		File f = new File(path);
		try 
		{
			Scanner s = new Scanner(f);
			while(s.hasNextLine())
			{
				code+=s.nextLine()+"\n";
			}
			s.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return code;
	}

	/*
	 * Main method, which instantiates the Main class, measures how long the instantiation takes
	 * and displays it to the console in milliseconds	 
	 */
	public static void main(String[] args) 
	{
		// TODO change 'KASSEN_D.../...' to the path of the fule you want to test
		Main arrayMax = new Main("/KASSEN_D_PrimitiveCounter/src/arrayMax.txt");
		System.currentTimeMillis();
		Main arraySum = new Main("/KASSEN_D_PrimitiveCounter/src/arraySum.txt");
		//TODO display time taken to instantiate class
	}
}
