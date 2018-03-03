package hw1;
import java.util.LinkedList;
import java.util.ListIterator;


public class KingsList { 
	
	LinkedList<Integer> list;
	int executeIndex;
	
	public KingsList(int size, int index) {
		list = new LinkedList<Integer>();
		circularize(size);
		executeIndex = index;
	}
	
	public LinkedList<Integer> getList(){
		return list;
	}
	
	public int executeIndex() {
		return executeIndex;
	}
	
	public void circularize(int size) {
		for (int i = 1; i <= size; i++ )
			list.add(i);
		list.add(-1);	// sentinel
	}
	
	public int eliminate() {
		int count = 0;
		ListIterator<Integer> iter = list.listIterator(0);
		Integer node = iter.next();
		while(list.peek() != -1) {
			//if only one prisoner, he lives
//			if (node == list.peek() && list.peekLast() == -1)
//				return node;
			//kill every kth node, renew counter after a kill
			if (count++ == executeIndex) {
				iter.remove();
				count = 0;
			}
			//move the iterator to the next node
			node = iter.next();
			//make list cyclical by going back to head if at tail
			if (node.equals(list.peekLast()))
				node = list.getFirst();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		if (args.length == 2){
			int size = Integer.parseInt(args[0]);
			int index = Integer.parseInt(args[1]);
			KingsList list = new KingsList(size, index);
			System.out.println(list.eliminate());
		}
		else
			System.out.println("Please enter size of prisoners list and index at which to kill");


	}
}