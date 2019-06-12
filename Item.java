public class Item implements Comparable<Item>
{
	public int number;
	public int profit;
	public int weight;
	public String itemName;
	
	public Item(int no, String item, int p, int w)
	{
		number = no;
		profit = p;
		weight = w;
		itemName = item;
	}
	
	public Item makeCopy()
	{
		Item i = new Item(number,new String(itemName),profit,weight);
		return i;
	}
	
	public int compareTo(Item i) {
		float ratio = (float)this.profit/this.weight;
		float secondRatio = (float)i.profit/i.weight;
		if(ratio > secondRatio) {
			return -1;
		}
		else if(ratio < secondRatio) {
			return 1;
		}
		return 0;
	}
	
	public String toString()
	{
		return itemName + " (Priority: " + profit + ", Weight: " + weight + ")";
	}
}

