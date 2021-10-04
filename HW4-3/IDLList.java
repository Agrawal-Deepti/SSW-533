import java.util.ArrayList;

public class IDLList<E> {
	
	//Double linked lists variables
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;
	
	//Create empty double linked list
	public IDLList() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList<Node<E>>();
		
	}
	
	//add elem into double linked list at specified index
	public boolean add(int index, E elem) {
		
		if (index < 0) {
			
			return false;
			
		}
		
		Node<E> node = new Node(elem);
		if (indices.size() == 0) {
			
			add(elem);
			
		}else if(indices.size() == index) {
			
			append(elem);
			
		}else if(index == 0) {
			
			add(elem);
			
		}
		
		else {
	
			node.next = indices.get(index);
			node.prev = indices.get(index).prev;
					
			indices.get(index).prev.next = node;
			indices.get(index).prev = node;
			indices.add(index, node);
				
			}
		
		return true;
		
	}
	
	//add elem to head of double linked list
	public boolean add(E elem) {
		
		Node<E> node = new Node(elem);
		node.prev = null;
		
		if (indices.size() == 0) {
			
			indices.add(node);
			head = node;
			tail = node;
			node.next = null;
			
		}else {
		
			
			node.next = head;
			head.prev = node;
			head = node;
		
			indices.add(0, node);
		}
		
		return true;
		
	}
	
	//add elem to tail of double linked list
	public boolean append(E elem) {
		
		Node<E> node = new Node(elem);
		if (indices.size() == 0) {
			
			add(elem);
			
		}else {
		
			tail.next = node;
			node.prev = tail;
			node.next = null;
			tail = node;
			indices.add(indices.size(), node);
			
		}
		
		return true;
	}
	
	//returns element at specified index
	public E get(int index) {
		
		return indices.get(index).data;
		
	}
	
	//returns head data or null if there is no head
	public E getHead() {
		
		if (head != null) {
			
			return head.data;
			
		}
		
		return null;
		
	}
	
	//returns tail data or null if there is no tail
	public E getLast() {
		
		if (tail != null) {
			
			return tail.data;
		
		}
		
		return null;
		
	}
	
	//returns size of indices
	public int size() {
		
		return indices.size();
		
	}
	
	
	//removes the element at the head and returns it
	public E remove() {
		
		if (head == null){
			return null;
		}
		
		Node<E> node = head;
		
		if (indices.size() >= 2) {
			
			indices.get(1).prev = null;
			indices.remove(0);
			head = indices.get(0);
			
		}else {
		
			indices.remove(0);
			head = null;
			
		}
		
		return node.data;
		
	}
	
	//removes and returns element at the tail.
	public E removeLast() {
		
		if (tail == null) {
			
			return null;
		
		}
		
		Node<E> node = tail;
		indices.get(indices.size() - 2).next = null;
		tail = indices.get(indices.size() - 2);
		indices.remove(indices.size()-1);
		return node.data;
		
	}
	
	//removes and returns the element at the specified index
	public E removeAt(int index) {
		
		if (index < 0 || index >= indices.size()) {
					
			return null;
			
		}
				
		Node<E> node = indices.get(index);
		if (index == 0) {
					
			remove();
					
		}else if(index == indices.size() - 1) {
					
			removeLast();
					
		}else {
			
			indices.get(index).prev.next = indices.get(index).next;
			indices.get(index).next.prev = indices.get(index).prev;
			indices.remove(index);
							
							
						
			}
		
		return node.data;
		
	}
	
	public boolean remove(E elem) {
		
		for (int i = 0; i < indices.size(); i++) {
			
			if (indices.get(i).data == elem) {
				
				removeAt(i);
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//returns a string representation of the list
	public String toString() {
		
		String str = "";
		for (int i = 0; i < indices.size();i++) {
			
			str += indices.get(i).data;
			
			if (i != indices.size()-1) {
				
				str += ", ";
				
			}
			
		}
		
		return str;
	}
	
	//Node class
	public class Node<E>{
		
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E elem) {
			
			this.data = elem;
		}
		
		public Node(E elem, Node<E> prev, Node<E> next) {
			
			this.data = elem;
			this.next = next;
			this.prev = prev;
			
		}
		
	}

	
}
