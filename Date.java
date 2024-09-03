package application;

import java.util.Objects;

public class Date implements Comparable<Date>{
	private AVL<Martyr> avlTree;
	private String date;

	public Date(String date) {
		super();
		avlTree = new AVL<Martyr>();
		this.date = date;
	}
	
	

	public Date() {
		super();
		avlTree = new AVL<Martyr>();
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public AVL<Martyr> getAvlTree() {
		return avlTree;
	}

	public void setAvlTree(AVL<Martyr> avlTree) {
		this.avlTree = avlTree;
	}

	@Override
	public String toString() {
		return date;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < date.length(); i++) {
			hash = hash + (int)date.charAt(i);
		}
		return hash;
	}

	@Override
	public int compareTo(Date o) {
		return this.date.compareTo(o.getDate());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Date) {
			return this.date.equals(((Date)obj).getDate());
		}
		return false;
	}
	
	private int total(TNode<Martyr> node) {
		if (node == null)
			return 0;
		return 1 + total(node.getLeft()) + total(node.getRight());
	}
	
	public int totalMartyrs() {
		return total(avlTree.getRoot());
	}
	
	private double countAge(TNode<Martyr> node) {
		if(node == null) return 0.0;
		return node.getData().getAge() + countAge(node.getLeft()) + countAge(node.getRight());
	}
	
	public double avgAge() {
		double totalAge = this.countAge(avlTree.getRoot());
		return totalAge/this.totalMartyrs();
	}
	
	
	private int males(TNode<Martyr> node) {
		if(node == null) return 0;
		if(node.getData().getGender().equals("M")) {
			return 1 + males(node.getLeft()) + males(node.getRight());
		}
		
		return males(node.getLeft()) + males(node.getRight());
	}
	
	public int totalMales() {
		return this.males(avlTree.getRoot());
	}
	
	private int females(TNode<Martyr> node) {
		if(node == null) return 0;
		if(node.getData().getGender().equals("F")) {
			return 1 + females(node.getLeft()) + females(node.getRight());
		}
		
		return females(node.getLeft()) + females(node.getRight());
	}
	
	public int totalFemales() {
		return this.females(avlTree.getRoot());
	}
	
	
	
}




