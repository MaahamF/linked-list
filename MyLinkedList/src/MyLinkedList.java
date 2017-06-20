import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
	private Node dummy;
	private Node last;
	public MyLinkedList() {
		dummy = new Node(null, null);
		last = dummy;
	}
	public Iterator<E> iterator() {
		return new MyIterator();
	}
	/**
	 * Adds a value to the end of the linked list
	 * @param value to be added to the end of the list
	 */
	public void addBack(E value) {
		if(value == null)
			throw new IllegalArgumentException("Error: parameter can't be null");
		Node addition = new Node(value, null);
		last.next = addition;
		last = addition;
	}
	/**
	 * Adds a value to the beginning of the linked list
	 * @param value to be added to the beginning of the list
	 */
	public void addFront(E value) {
		if(value == null)
			throw new IllegalArgumentException("Error: parameter can't be null");
		Node addition = new Node(value, dummy.next);
		dummy.next = addition;
		if (dummy == last)
			last = addition;
	}
	/**
	 * Removes first occurrence of value from the linked list
	 * @param value to be removed
	 * @return true if value was in list and false if value is not in list
	 */
	public boolean remove(E value) {
		if(value == null)
			throw new IllegalArgumentException("Error: parameter can't be null");
		Node previous = dummy;
		Node current = dummy.next;
		while(current != null) {
			if(current.value.equals(value)) {
				previous.next = current.next;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	/**
	 * Removes all occurrences of value from the linked list
	 * @param value to be removed
	 * @return true if value was in list and false if value is not in list
	 */
	public boolean removeAll(E value) {
		if(value == null)
			throw new IllegalArgumentException("Error: parameter can't be null");
		Node previous = dummy;
		Node current = dummy.next;
		boolean itemRemoved = false;
		while(current != null) {
			if(current.value.equals(value)) {
				previous.next = current.next;
				itemRemoved = true;
			}
			else
				previous = current;
			current = current.next;
		}
		return itemRemoved;
	}
	/**
	 * Creates String representation of list
	 * @return String representation
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder("[");
		Node current = dummy.next;
		while(current != null) {
			builder.append(current.value);
			builder.append(", ");
			current = current.next;
		}
		builder.append("]");
		return builder.toString();
	}
	private class Node {
		public E value;
		public Node next;
		public Node(E v, Node n) {
			value = v;
			next = n;
		}
	}
	private class MyIterator implements Iterator<E> {
		private Node current = dummy;
		public boolean hasNext() {
			return current.next != null;
		}
		public E next() {
			current = current.next;
			return current.value;
		}
	}
	
}

