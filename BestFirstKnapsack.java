import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstKnapsack {
	PriorityQueue<Node> q;
	Knapsack s;
	
	public BestFirstKnapsack(Knapsack sack) {
		this.q = new PriorityQueue<Node>();
		this.s = sack;
	}
	
	public Node makeKnapSack()
	{
		ArrayList<Item> itemInKnapsack = s.items;
		int numItems=itemInKnapsack.size();
		int maxWeight = s.maxWeight;
		int maxProfit = 0;
		Node v= new Node(0,0,0,new ArrayList<Item>());
		Node u;
    	v.setBound(v.getBound(this.s));
		Node maxProfitNode = v;
		q.add(v);
		while(!(q.isEmpty()))
		{
			ArrayList<Item> parentList = new ArrayList<Item>();
			Node tempNode = q.peek();
			q.remove();
			if(tempNode.bound > maxProfit)
			{
				parentList.addAll(tempNode.items);
				u = new Node(tempNode.level+1,tempNode.weight + itemInKnapsack.get(tempNode.level+1).weight , tempNode.profit + itemInKnapsack.get(tempNode.level+1).profit, parentList);
				u.setBound(u.getBound(this.s));  	
				u.items.add(itemInKnapsack.get(u.level));
				if(u.weight <= maxWeight && u.profit > maxProfit)
				{
					maxProfit = u.profit;
					maxProfitNode = u;
				}
				if(u.bound > maxProfit && u.level < numItems-1)
				{
					q.add(u);
				}
				tempNode.level++;
				tempNode.setBound(tempNode.getBound(this.s));
				if(tempNode.bound > maxProfit && u.level < numItems-1) {
					q.add(tempNode);
				}
			}
		}
		return maxProfitNode;
	}
}

