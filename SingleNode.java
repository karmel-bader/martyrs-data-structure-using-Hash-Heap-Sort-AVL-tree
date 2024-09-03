package application;



public class SingleNode<T extends Comparable<T>> {
	private T data;
	private SingleNode<T> next;
	
	
	public SingleNode(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public SingleNode<T> getNext() {
		return next;
	}
	public void setNext(SingleNode<T> next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return data + " ";
	}
	
	

}

