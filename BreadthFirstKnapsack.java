import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstKnapsack {

	int maxProfit;
	Knapsack s;
	
	public BreadthFirstKnapsack(Knapsack s)
    {   
    	this.s = s;
    }
	
    public Node makeKnapSack()
    {
    	ArrayList<Item> itemInKnapsack = s.items;
    	maxProfit = 0;
    	int numItems=itemInKnapsack.size();
    	int maxWeight = s.maxWeight;
    	Queue<Node> q = new LinkedList();
    	Node v= new Node(0,0,0,new ArrayList<Item>());
    	Node u;
    	v.setBound(v.getBound(this.s));
    	Node maxProfitNode = v;
    	q.offer(v);
    	while(!(q.isEmpty()))
    	{
    		ArrayList<Item> parentList = new ArrayList<Item>();
    		Node tempNode = q.remove();
    		parentList.addAll(tempNode.items);
    		u = new Node(tempNode.level+1,tempNode.weight + itemInKnapsack.get(tempNode.level+1).weight , tempNode.profit + itemInKnapsack.get(tempNode.level+1).profit, new ArrayList<Item>());
    		u.items.addAll(parentList);
    		u.setBound(u.getBound(this.s)); 
    		u.items.add(itemInKnapsack.get(u.level));
    		if(u.weight <= maxWeight && u.profit >= maxProfit)
    		{
    			maxProfit = u.profit;
    			maxProfitNode = new Node(u.level, u.weight, u.profit, u.items);
    		}
    		if(u.bound >= maxProfit && u.level < numItems-1)
    		{
    			q.offer(u);
    		}
    		Node child = new Node(tempNode.level +1,tempNode.weight, tempNode.profit,new ArrayList<Item>());
    		child.items.addAll(parentList);
    		if(child.getBound(this.s) > maxProfit && child.level < numItems-1) 
    			q.offer(child);
    	}
    	return maxProfitNode;
    }
}

