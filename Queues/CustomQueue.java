
public class CustomQueue {

    public static void main(String[] args) {
        DynamicQueueImplemenation queue = new DynamicQueueImplemenation(2);
        try {
            queue.insert(1);
            queue.insert(2);
            queue.insert(3);
            queue.insert(4);
            queue.insert(5);
            queue.insert(6);
            queue.insert(7);
            queue.insert(8);
            queue.insert(9);
            queue.insert(10);
            queue.insert(11);
            queue.insert(12);
            queue.insert(13);
            queue.insert(14);
            queue.insert(15);
            queue.insert(16);
            queue.insert(17);
            queue.insert(18);
            queue.insert(19);
            queue.insert(20);
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());
            System.out.println(queue.remove());

        } catch (QueueExpection ex) {
            System.out.println("EXCEPTTION CAUGHT -> " + ex);
        }
    }
}

class CustomQueueImpletation {

    private final static int DEFAULT_SIZE = 10;
    int arr[];
    int end = 0;

    public CustomQueueImpletation(int size) {
        this.arr = new int[size];
    }

    public CustomQueueImpletation() {
        this(DEFAULT_SIZE);
    }

    public boolean insert(int value) throws QueueExpection {
        if (isFull()) {
            throw new QueueExpection("Cannot insert as queue is full");
        }
        this.arr[this.end++] = value;
        return true;
    }

    public int remove() throws QueueExpection {
        if (isEmpty()) {
            throw new QueueExpection("Cannot remove as queue is empty");
        }
        int firstElement = arr[0];
        for (int i = 1; i < end; i++) {
            arr[i - 1] = arr[i];
        }
        arr[--end] = 0;
        return firstElement;
    }

    public boolean isFull() {
        return this.arr.length == this.end;
    }

    public boolean isEmpty() {
        return end == 0;
    }
}

class DynamicQueueImplemenation extends CustomQueueImpletation {

    public DynamicQueueImplemenation(int size) {
        super(size);
    }

    public DynamicQueueImplemenation() {
        super();
    }

    @Override
    public boolean insert(int value) throws QueueExpection {
        if (super.isFull()) {
            int[] temp = new int[super.arr.length * 2];
            System.arraycopy(super.arr, 0, temp, 0, super.end);
            super.arr = temp;
        }
        super.insert(value);
        return true;
    }
}

class QueueExpection extends Exception {

    public QueueExpection(String messgae) {
        super(messgae);
    }
}
