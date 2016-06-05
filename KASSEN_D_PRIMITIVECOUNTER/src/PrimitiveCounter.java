import java.util.StringTokenizer;
 
public class PrimitiveCounter 
{
	private String[] codeLines;
	private int lineCount;	
	private boolean nested = false;
	/*
	 * Default constructor
	 */
	public PrimitiveCounter(String code)
	{
		codeLines = code.split("\n");
		lineCount = codeLines.length;		
		//Implemented in main, retains new line characters
	}
	
	/*
	 * A function that returns the code as an array of Strings
	 */
	public String[] getCodeLines()
	{
		return codeLines;
	}
	/*
	 * Determines if the code segment is a primitive operation. Examples of 
	 * primitive operations include:
	 * - Evaluating an expression
	 * - Assigning a value to a variable
	 * - Indexing into an array
     * - Calling a method
	 * - Returning from a method
	 * 
	 */
	public int countPrimitive(String line)
	{		
		int count = 0;
		int totalCount = 0;
		StringTokenizer ST = new StringTokenizer(line," ");
		if(!ST.hasMoreTokens())
		{
			return -1;
		}
		else
		{
			while(ST.hasMoreTokens())
			{
				String token = ST.nextToken();
				
				if(token.contains(">") || token.contains("<") || token.contains("==") || token.contains(">=") || token.contains("<="))	//Evaluating Expression	
				{
					count = 1;
					totalCount += count;
				}
				else if(token.contains("="))			//Assigning Value
				{
					count = 1;
					totalCount += count;
				}
				else if(token.contains("[") && token.contains("]"))		//Indexing Array
				{
					count = 1;
					totalCount += count;
				}
				else if(token.contains(".") && token.contains("(") && token.contains(")"))				// TODO Calling Method
				{
					count = 1;
					totalCount += count;
				}
				else if(token.contains("return"))		//Returning from Method
				{
					count = 1;
					totalCount += count;
				}
				else if(token.contains("for") || token.contains("while") || token.contains("if"))		//Returning from Method
				{
					count = 100;
					count+=1;
					totalCount += count;
					/*--count;	//if count neg- represent as 'n'
					return count;*/
				}
			}
		}
		return totalCount;
	}
	
	/*
	 * A function that recursively calculates the primitive count for the total code lines given
	 * You can make the assumption that loops are defined to have a runtime of n 
	 */	
	public String calculatePrimitiveCount(String[] codeLines, String currentPrimitiveCount, int index)
	{		
		
		//int nLines = codeLines.length;
		int nPOps = 0;	//n Primitive Operations
		String containsLoop = "";
		String result = "";
		
		if(index == codeLines.length)
		{
			return currentPrimitiveCount + containsLoop;	//containsLoop is initialized to ""
		}
		else //if(index < codeLines.length)
		{
			nPOps = countPrimitive(codeLines[index]);
			if(nPOps > 100)
			{
				containsLoop = "n";
				nPOps = nPOps - 100;
			}
			
			currentPrimitiveCount = Integer.toString(nPOps);
			
			return (index+1) + ": " + currentPrimitiveCount + containsLoop + "\n" + calculatePrimitiveCount(codeLines, currentPrimitiveCount, index + 1);
		}
	}
	
	/*
	 * A function that calculates the Big Oh notation of the code stored
	 * You only have to cater for constant, linear and quadratic functions
	 */	
	public String getBigOh(String[] codeLines)
	{
		
		String notation = "";
		int runtime = 0;
		for(int i = 0; i <= codeLines.length; i++)
		{
			if(calculatePrimitiveCount(codeLines, "", i).contains("n"))
			{
				notation = "\n O(n)";
			}
			else //if() no 'n'
			{
				notation = "\n n";
			}
			
		}
		
		return notation + "\n" + "Total Running Time: " + runtime + "ms" ;
		
	}
	
	/*
	 * Overridden toString that displays the code with line numbers (starting at 1) 
	 */
	public String toString()
	{
		String temp = "";
		for (int i=0; i< lineCount; i++)
		{
			temp += (i+1) + ": " + codeLines[i] + "\n";
		}
		return temp;
	}
}
