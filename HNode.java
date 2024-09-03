package application;

public class HNode<T extends Comparable<T>> {
	private T value;
	private char flag;
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public char getFlag() {
		return flag;
	}
	public void setFlag(char flag) {
		this.flag = flag;
	}
	public HNode(T value) {
		super();
		this.value = value;
		flag = 'E';
	}

	public boolean isFull() {
		return flag == 'F';
	}
	public HNode() {
		super();
		flag = 'E';
	}
	
	@Override
	public String toString() {
		return value + " ";
	}
	
	
	
	
	
	
	
	

}
