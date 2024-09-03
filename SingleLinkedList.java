package application;

public class SingleLinkedList<T extends Comparable<T>> {
	private SingleNode<T> head;
	private SingleNode<T> tail;

	public boolean insert(T data) {
		if (this.findNode(data) != null)
			return false;
		SingleNode<T> node = new SingleNode<>(data);
		if (head == null) {
			head = tail = node;
		} else {
			SingleNode<T> prev = null;
			SingleNode<T> curr = head;
			if (head == null) {
				head = node;
				tail = head;
			} else {
				for (; (curr != null)
						&& (node.getData().compareTo(curr.getData()) > 0); prev = curr, curr = curr.getNext())
					;
				if (prev == null) {
					node.setNext(head);
					head = node;
				} else if (curr == null) {
					node.setNext(curr);
					prev.setNext(node);
					tail = node;
				} else {
					prev.setNext(node);
					node.setNext(curr);
				}
			}
		}
		return true;
	}

	public void delete(T data) {
		if (tail == null)
			return;
		if (data.equals(tail.getData())) {
			this.removeTail();
			return;
		} else {
			if (head != null) {
				SingleNode<T> prev = null, curr = head;
				for (; curr != null && !curr.getData().equals(data); prev = curr, curr = curr.getNext())
					;
				if (curr != null && curr.getData().compareTo(data) == 0) {
					if (head == curr) {
						head = curr.getNext();
						if(head==null) tail=null;
					}
					else if (curr.getNext() == null) {
						tail = prev;
						tail.setNext(null);
					}
					else
						prev.setNext(curr.getNext());

				}

			}
		}
	}

	public boolean update(T oldData, T newData) {
		if (this.findNode(oldData) == null || (this.findNode(newData) != null && !newData.equals(oldData)))
			return false;
		SingleNode<T> currMar = this.findNode(oldData);
		this.delete(currMar.getData());
		currMar.setData(newData);
		SingleNode<T> prev = null;
		SingleNode<T> curr = head;
		if (head == null) {
			head = currMar;
			tail = head;
		} else {
			for (; (curr != null)
					&& (currMar.getData().compareTo(curr.getData()) > 0); prev = curr, curr = curr.getNext())
				;
			if (prev == null) {
				currMar.setNext(head);
				head = currMar;
			} else if (curr == null) {
				currMar.setNext(curr);
				prev.setNext(currMar);
				tail = currMar;
			} else {
				prev.setNext(currMar);
				currMar.setNext(curr);
			}

		}

		return true;
	}

	public SingleNode<T> findNode(T data) {
		SingleNode<T> curr = head;
		while (curr != null) {
			if (curr.getData().equals(data)) {
				return curr;
			}
			curr = curr.getNext();
		}
		return null;
	}

	public SingleNode<T> findNodePrev(T data) {
		SingleNode<T> curr = head;
		while (curr != null) {
			if (curr.getNext().getData().equals(data)) {
				return curr;
			}
			curr = curr.getNext();
		}
		return null;
	}

	public SingleNode<T> getHead() {
		return head;
	}

	public void setHead(SingleNode<T> head) {
		this.head = head;
	}

	public SingleNode<T> getTail() {
		return tail;
	}

	public void setTail(SingleNode<T> tail) {
		this.tail = tail;
	}

	public SingleNode<T> removeTail() {
		if (head == tail) {
			SingleNode<T> del = head;
			head = null;
			tail = null;
			return del;
		}
		SingleNode<T> curr = head;
		while (curr.getNext().getNext() != null) {
			curr = curr.getNext();
		}
		SingleNode<T> del = curr.getNext();
		curr.setNext(null);
		return del;
	}
	
	

}

