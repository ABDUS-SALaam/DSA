
public class CustomStack {

    public static void main(String[] args) {
        DynamicStackImplementation stack = new DynamicStackImplementation(5);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            stack.push(7);
            System.out.println(stack.pop());
            System.out.println(stack.pop());

            System.out.println(stack.pop());

            System.out.println(stack.pop());

            System.out.println(stack.pop());

            System.out.println(stack.pop());

            System.out.println(stack.pop());
            System.out.println(stack.pop());

        } catch (StackExpection ex) {
            System.out.println("Error occured -> " + ex);
        }
    }
}

class CustomStackImplementation {

    public int[] arr;
    private final static int DEFAULT_SIZE = 10;
    int ptr = 0;

    CustomStackImplementation() {
        this(DEFAULT_SIZE);
    }

    CustomStackImplementation(int size) {
        this.arr = new int[size];
    }

    public boolean push(int value) throws StackExpection {
        if (isFull()) {
            throw new StackExpection("Cannot push as stack is full");
        }
        this.arr[this.ptr++] = value;
        return true;
    }

    public boolean isFull() {
        return this.arr.length <= this.ptr;
    }

    public int pop() throws StackExpection {
        if (this.ptr == 0) {
            throw new StackExpection("Cannot pop from an empty stack");
        }
        return this.arr[--this.ptr];
    }

}

class DynamicStackImplementation extends CustomStackImplementation {

    DynamicStackImplementation(int size) {
        super(size);
    }

    DynamicStackImplementation() {
        super();
    }

    @Override
    public boolean push(int value) throws StackExpection {
        if (this.isFull()) {
            int[] temp = new int[super.arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, super.arr.length);
            super.arr = temp;
        }
        return super.push(value);
    }

}

class StackExpection extends Exception {

    public StackExpection(String messgae) {
        super(messgae);
    }
}
