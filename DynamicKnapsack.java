/*import java.util.ArrayList;

public class DynamicKnapsack 
{
	public Knapsack s;
	
    public DynamicKnapsack(Knapsack s)
    {   
    	this.s = s;
    }
    
    public Knapsack makeKnapSack()
    {
    	ArrayList<Item> items = s.items;
    	s.items = new ArrayList<Item>();
    	int[][] array = new int[items.size()][s.maxWeight+1];
    	int[][] itemsToKeep = new int[items.size()][s.maxWeight+1];
    	
    	array[0][0] = 0;
    	for(int a = 0; a < s.maxWeight; a++) {
    		array[0][a] = 0;
    	}
    	for(int i = 1; i < array.length; i++)
    	{
    		for(int j = 1; j < array[i].length; j++)
    		{
    			if(items.get(i).weight <= j && items.get(i).profit + array[i-1][j-items.get(i).weight] >= array[i-1][j])
    			{
    				array[i][j] = (items.get(i).profit + array[i-1][j-items.get(i).weight]);
    				itemsToKeep[i][j] = 1;
    			}
    			else {
    				array[i][j] = array[i-1][j];
    				itemsToKeep[i][j] = 0;
    			}
    		}
    	}
    	int weight = s.maxWeight;
    	int counter = 0;
    	for(int i = items.size()-1; i >= 0 ; i--) {
    		if(itemsToKeep[i][weight] == 1) 
    		{
    			s.items.add(items.get(i));
    			weight-=items.get(i).weight;
    			counter += items.get(i).weight;
    		}
    	}
    	s.setProfit(array[items.size()-1][s.maxWeight]);
    	return s;
    }
}*/

import java.util.ArrayList;

public class DynamicKnapsack 
{
	public Knapsack s;
	
    public DynamicKnapsack(Knapsack s)
    {   
    	this.s = s;
    }
    
    public Knapsack makeKnapSack()
    {
    	ArrayList<Item> items = s.items;
    	s.items = new ArrayList<Item>();
        
    	int[][] array = new int[items.size()][s.maxWeight+1];
    	int[][] itemsToKeep = new int[items.size()][s.maxWeight+1];
    	
    	array[0][0] = 0;
    	for(int a = 0; a < s.maxWeight; a++) {
    		array[0][a] = 0;
    	}
    	for(int i = 1; i < array.length; i++)
    	{
    		for(int j = 1; j < array[i].length; j++)
    		{
    			if(items.get(i).weight <= j && items.get(i).profit + array[i-1][j-items.get(i).weight] >= array[i-1][j])
    			{
    				array[i][j] = (items.get(i).profit + array[i-1][j-items.get(i).weight]);
    				itemsToKeep[i][j] = 1;
    			}
    			else {
    				array[i][j] = array[i-1][j];
    				itemsToKeep[i][j] = 0;
    			}
    		}
    	}
    	int weight = s.maxWeight;
    	int counter = 0;
    	for(int i = items.size()-1; i >= 0 ; i--) {
    		if(itemsToKeep[i][weight] == 1) 
    		{
    			s.items.add(items.get(i));
    			weight-=items.get(i).weight;
    			counter += items.get(i).weight;
    		}
    	}
    	s.setProfit(array[items.size()-1][s.maxWeight]);
    	return s;
    }
}