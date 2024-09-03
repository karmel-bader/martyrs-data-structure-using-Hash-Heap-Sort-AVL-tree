package application;

public class Hash<T extends Comparable<T>> {
	private HNode[] hash = new HNode[11];
	private int size = 11;
	private int counter = 0;

	public Hash() {
		this.initialization();
	}

	private void initialization() {
		for (int i = 0; i < hash.length; i++) {
			hash[i] = new HNode<T>();
		}
	}

	private int hash(T data) {
		int h = Math.abs(data.hashCode());
		int j = 1, index = h % size;
		while(hash[index].isFull() && !hash[index].getValue().equals(data)) {
			index = Math.abs((h + (j * j)) % size);
			j++;
		}
		return index;
	}

	private void rehash(int newSize) {
		HNode<T>[] oldHash = hash;
		hash = new HNode[newSize];
		this.initialization();
		size = newSize;
		for (int i = 0; i < oldHash.length; i++) {
			if (oldHash[i].getFlag() == 'F') {
				int index = hash(oldHash[i].getValue()); // get the new index
				hash[index] = oldHash[i];
				
			}
		}
	}

	public boolean insert(T value) {
		int j = this.hash(value);
		if (hash[j].getFlag() != 'F') {
			hash[j] = new HNode<T>(value);
			hash[j].setFlag('F');
			counter++;
			if (counter >= size / 2) {
				rehash(getNextPrime(2 * size));
			}
			return true;
		}
		return false;
	}

	private int getNextPrime(int x) {
		while (true) {
			if (isPrime(x)) {
				break;
			}
			x++;
		}
		return x;
	}

	private boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 0; i < n; i++) {
			if (n % 2 == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public void traverse(){
        for(int i=0; i<size; i++){
            if(hash[i].getFlag()=='F') {
                System.out.print(i + " " +hash[i].getValue());
                ((Date)hash[i].getValue()).getAvlTree().traversalInOrder();
                System.out.println();
            }
        }
    }
	
	public HNode<T> search(T data) {
		int index = this.hash(data);
		if(hash[index].getFlag() == 'F') {
			return hash[index];
		}else
			return null;
	}
	
	
	public HNode<T> delete(T data){
		int index = this.hash(data);
		if(hash[index].getFlag() == 'F') {
			hash[index].setFlag('D');
			return hash[index];
		}
		
		return null;
	}
	
	public boolean update(T oldData, T newData) {
		int oldIndex = this.hash(oldData);
		int newIndex = this.hash(newData);
		if(oldIndex ==  newIndex) {
			return true;
		}
		if(hash[oldIndex].getFlag() == 'F') {
			hash[oldIndex].setFlag('D');
			if(hash[newIndex].getFlag() == 'E' || hash[newIndex].getFlag() == 'D') {
				hash[oldIndex].setValue(newData);
				hash[newIndex] = hash[oldIndex];
				hash[newIndex].setFlag('F');
				hash[oldIndex] = new HNode<T>(); // make the flag of old data equal E 
				return true;
			}else {
				this.insertAfterUpdate(((Date)hash[oldIndex].getValue()).getAvlTree().getRoot(), ((Date)hash[newIndex].getValue()).getAvlTree());
				return true;
			}
		}
		return false;
	}
	
	
	private void insertAfterUpdate(TNode<Martyr> node, AVL<Martyr> avlTree) {
		if(node == null) return;
		insertAfterUpdate(node.getLeft(),avlTree);
		avlTree.insert(node.getData());
		insertAfterUpdate(node.getRight(),avlTree);
	}

	public HNode[] getHash() {
		return hash;
	}

	public void setHash(HNode[] hash) {
		this.hash = hash;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	
	
}







