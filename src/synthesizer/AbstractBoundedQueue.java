package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
	protected int fillCount;
	protected int capacity;
	
	//return capacity
	public int capacity() {
		return capacity;
	}
	
	//return fillCount
	public int fillCount() {
		return fillCount;
	}
	
	public boolean isEmpty() {
		if (this.fillCount == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (this.fillCount == this.capacity) {
			return true;
		}
		return false;
		
	}

	
	public abstract T peek();
	public abstract T dequeue();
	public abstract void enqueue(T x);

}
