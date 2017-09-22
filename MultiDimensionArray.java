package com.divisiblity.rajat;

public class MultiDimensionArray  
{

	public static Long getValue(int... indexOfDimension) {
        //...
		Long value= null;
		for(int i=0;i<indexOfDimension.length;i++)
		{
			
		}
		
        return value;
    }
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
   
    	int len = lengthOfDeminsion.length;
    	int[] ele = new int[len]; // all zeroes
    	int last = len-2;
    	Long sum = null;
    	do
    	{
    	    for (ele[len-1] = 0; ele[len-1] < lengthOfDeminsion[len-1]; ele[len-1]++)
    	    {
    	        sum += getValue(ele);
    	    }
    	    while (last >= 0 && ++ele[last] == lengthOfDeminsion[last])
    	    {
    	    	ele[last--] = 0;
    	    }
    	    if (last >= 0) last = len-2;
    	}
    	while (last >= 0);
    	
    	
   // Time complexity: O(n) 
   // Space complexity:O(n) 
    return sum;
    }
}

