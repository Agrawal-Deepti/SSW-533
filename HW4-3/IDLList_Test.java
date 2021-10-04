
public class IDLList_Test {

	private static void add_test() {
		
		IDLList ll = new IDLList();
		ll.add(2, 5);
		ll.add(1, 4);
		ll.add(1, 3);
		ll.add(7);
		System.out.println(ll);
		
		
	}
	
	private static void get_remove_test() {
		
		IDLList ll = new IDLList();
		ll.add(2, 5);
		ll.add(1, 4);
		ll.add(1, 3);
		ll.add(7);
		System.out.println("index 2 = " + ll.get(2));
		System.out.println("head = " + ll.getHead());
		System.out.println("tail = " + ll.getLast());
		System.out.println("size = " + ll.size());
		System.out.println("removed head = " + ll.remove());
		System.out.println(ll);
		System.out.println("removed 1 = " + ll.removeAt(1));
		System.out.println(ll);
		System.out.println("removed last = " + ll.removeLast());
		System.out.println(ll);
		System.out.println("head = " + ll.getHead());
		System.out.println("tail = " + ll.getLast());
	}
	
	
	public static void main(String[] args) {
		
		add_test();
		get_remove_test();
		
	}
	
	
}
