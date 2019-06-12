import java.util.ArrayList;

public class Node implements Comparable<Node>
{
	public int level;
	public ArrayList<Item> items;
	public float bound;
	public int profit;
	public int weight;
	
	public Node(int level, int weight, int profit, ArrayList<Item> items)
	{	
		this.profit = profit;
		this.weight = weight;
		this.level=level;
		this.items = items;
	}
	
	public Node(int level,int weight, int profit, ArrayList<Item> items, float Bound) {
		this(level,weight, profit,items);
		this.bound = Bound;
	}
	
	public int compareTo(Node n) {
		if(this.bound > n.bound)
			return 1;
		else if(this.bound < n.bound)
			return -1;
		return 0;
	}
	
	public void setBound(float b) {
		this.bound = b;
	}
	
	public Item getCurrentItem()
	{
		return this.items.get(this.level);
	}
	
	public String toString()
	{
		String s = "Level: " + this.level + "Priority: " + this.profit + "Weight: " + this.weight + "Bound: " + this.bound;
		return s;
	}
	
	public float getBound(Knapsack s) 
	{
		int j;
		int k;
		int totalWeight;
		float result;
		int maxWeight = s.maxWeight;
		ArrayList<Item> itemInKnapsack = s.items;
		if(this.level < 0)
			this.level = 0;
		
		if(this.weight >= maxWeight) {
			return 0;
		}

		else
		{
			result = this.profit;
			j=this.level+1;
			totalWeight = this.weight;
			while( j<itemInKnapsack.size() && ((totalWeight + itemInKnapsack.get(j).weight)<=maxWeight))
			{
				totalWeight += itemInKnapsack.get(j).weight;
				result += itemInKnapsack.get(j).profit;
				j++;
			}
			k=j;
			if(k<itemInKnapsack.size())
				result+=(maxWeight-totalWeight)*itemInKnapsack.get(k).profit/itemInKnapsack.get(k).weight;
			return result;
		}
	}
}

