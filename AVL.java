package application;

public class AVL<T extends Comparable<T>> {
	private TNode<T> root;
	
	
	
	
	public void insert(T data){
        root = insert(root, data);
    }
    public TNode<T> insert(TNode<T> node, T data){
        if(node==null) return new TNode<T>(data);
        if(((Martyr)data).compareTo((Martyr)node.getData())<0) node.setLeft(insert(node.getLeft(), data));
        else if(((Martyr)data).compareTo((Martyr)node.getData())>0) node.setRight(insert(node.getRight(), data));
        else return node;
        updateHeight(node);
        int bf = balance(node);
        if(bf>1){
            if(balance(node.getLeft())>=0) return rotateRight(node);
            else{
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }
        else if(bf<-1){
            if(balance(node.getRight())<=0) {
                return rotateLeft(node);
            }
            else{
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        else return node;
    }
    
    
    public void updateHeight(TNode<T> node){
        if(node==null) return;
        node.setHeight(height(node)-1);
    }
    
  
	public TNode<T> find(T data) {
		return find(data, root);
	}

	public TNode<T> find(T data, TNode<T> node) {
		if (node != null) {
			int comp = node.getData().compareTo(data);
			if (comp == 0)
				return node;
			else if (comp > 0 && node.hasLeft())
				return find(data, node.getLeft());
			else if (comp < 0 && node.hasRight())
				return find(data, node.getRight());
		}
		return null;
	}
	

	
	public void delete(T key) {
		this.root = this.deleteNode(root, key);
	}
	
	public TNode<T> deleteNode(TNode<T> root, T key) {
        if (root == null)
            return root;

        if (key.compareTo(root.getData()) < 0)
            root.setLeft(deleteNode(root.getLeft(), key));

        else if (key.compareTo(root.getData()) > 0)
            root.setRight(deleteNode(root.getRight(), key));

        else
        {

            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                TNode<T> temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else
            {
                TNode<T> temp = minValueNode(root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteNode(root.getRight(), temp.getData()));
            }
        }
        if (root == null)
            return root;

        root.setHeight( Math.max(height(root.getLeft()), height(root.getRight())) + 1);
        int balance = balance(root);
        if (balance > 1 && balance(root.getLeft()) >= 0)
            return rotateRight(root);

        if (balance > 1 && balance(root.getLeft()) < 0)
        {
            root.setLeft(rotateLeft(root.getLeft()));
            return rotateRight(root);
        }

        if (balance < -1 && balance(root.getRight()) <= 0)
            return rotateLeft(root);
        if (balance < -1 && balance(root.getRight()) > 0)
        {
            root.setRight(rotateRight(root.getRight()));
            return rotateLeft(root);
        }

        return root;
    }
    int getHeight(TNode<T> node) {
        if (node == null)
            return 0;

        return node.getHeight();
    }
    
    
    private TNode<T> minValueNode(TNode<T> node) {
        TNode<T> current = node;
        while (current.getLeft() != null)
            current = current.getLeft();

        return current;
    }
	
	public int height(TNode<T> node) {
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.getLeft());
		if (node.hasRight())
			right = height(node.getRight());
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	private int balance(TNode<T> node) {
		return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
	}
	
	private TNode<T> applyRotation(TNode<T> node){
		int balance = this.balance(node);
		if(balance > 1) {
			if(this.balance(node.getLeft()) < 0) {
				node.setLeft(rotateLeft(node.getLeft()));
			}
			return rotateRight(node);
		}
		
		if(balance < -1) {
			if(this.balance(node.getRight()) > 0) {
				node.setRight(rotateRight(node.getRight()));
			}
			return rotateLeft(node);
		}
		
		return node;
	}
	
	
	private TNode<T> rotateRight(TNode<T> node){
		TNode<T> leftNode = node.getLeft();
		TNode<T> centerNode = leftNode.getRight();
		leftNode.setRight(node);
		node.setLeft(centerNode);
		return leftNode;
	}
	
	
	private TNode<T> rotateLeft(TNode<T> node){
		TNode<T> rightNode = node.getRight();
		TNode<T> centerNode = rightNode.getLeft();
		rightNode.setLeft(node);
		node.setRight(centerNode);
		return rightNode;
	}
	
	
	public void traversalInOrder() {
		traversalInOrder(root);
	}

	private void traversalInOrder(TNode<T> node) {
		if (node != null) {
			if (node.getLeft() != null)
				traversalInOrder(node.getLeft());
			System.out.println(node + " ");
			if(node.getRight() != null) {
				traversalInOrder(node.getRight());
			}
		}
	}
	public TNode<T> getRoot() {
		return root;
	}
	public void setRoot(TNode<T> root) {
		this.root = root;
	}
	
	
	
	public void update(T oldData, T newData) {
		this.delete(oldData);
		this.insert(newData);
	}
	

}







