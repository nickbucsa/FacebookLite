public class Stack {
    private int size;
    private int top; //master index for our array
    private String[] stack;
    
    public Stack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
		reset();
    }
    
	public int getSize() {
        return size;
    }
    
	public boolean isEmpty() {
        return (top == -1);
    }
    
	public boolean isFull() {
        return (top == size - 1);
    }
    
	public void push(String item) {
        if(isFull()) {
            Util.print("The stack is full");
        }
        else {
            stack[++top] = item;
        }
    }
    
	public String pop() {
        if(isEmpty()){
			//Util.print("The stack is empty");
            return "";
        }
        else {
            return stack[top--];
        }
    }
    
	public void reset() {
        Util.reset(stack);
        top = -1;
    }
    
	public void print() {
		Util.print(stack, top);
    }
}