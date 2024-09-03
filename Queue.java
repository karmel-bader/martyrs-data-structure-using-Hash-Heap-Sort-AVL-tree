package application;

public class Queue<T extends Comparable<T>> {
	SingleLinkedList<T> list = new SingleLinkedList<T>();

	public T getFront() {
		if (list.getHead() == null)
			return null;
		return list.getHead().getData();
	}

	public void enQueue(T data) {
		SingleNode<T> SNode = new SingleNode<>(data);
		if (list.getTail() == null) {
			list.setHead(SNode);
			list.setTail(SNode);
		} else {
			list.getTail().setNext(SNode);
			list.setTail(SNode);
		}
	}

	public T deQueue() {
		SingleNode<T> temp = list.getHead();
		if (isEmpty())
			return null;
		if (list.getHead() == list.getTail()) {
			list.setHead(null);
			list.setTail(null);
		} else {
			list.setHead(list.getHead().getNext());
			temp.setNext(null);
		}
		return temp.getData();
	}

	public boolean isEmpty() {
		return list.getHead() == null;
	}
	
	public void clear() {
		list.setHead(null);
		list.setTail(null);
	}

}

