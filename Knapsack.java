import java.util.ArrayList;

public class Knapsack 
{

	public int maxWeight;
	public int weight;
	public ArrayList<Item> items;
	public int profit;
	
	public Knapsack(int maxWeight)
	{
		this.maxWeight = maxWeight;
		this.items=new ArrayList<Item>();
		this.profit = 0;
	}
	
	public Knapsack(int maxWeight, ArrayList<Item> i)
	{
		this.maxWeight = maxWeight;
		this.items = i;
		this.profit = 0;
	}
	
	public Knapsack(Knapsack k)
	{
		maxWeight = k.maxWeight;
		profit = k.profit;
		weight = k.weight;
		items = copyItems(k.items);
	}
	
	private ArrayList<Item> copyItems(ArrayList<Item> il)
	{
		ArrayList<Item> nl = new ArrayList<Item>();
		for(Item i : il){
			nl.add(i.makeCopy());
		}
		return nl;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
	
	public void calculateProfit() {
		int counter = 0;
		for(Item i: items)
			counter+=i.profit;
		this.profit = counter;
	}
	
	public void calculateWeight() {
		int counter = 0;
		for(Item i: items) 
			counter+=i.weight;
		this.weight = counter;
	}
}

