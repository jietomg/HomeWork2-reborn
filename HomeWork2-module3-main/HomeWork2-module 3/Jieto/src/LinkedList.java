public class LinkedList {
    private Node head;
    private int size;

    public static void main(String[] args) {
        LinkedList test  = new LinkedList();
        test.add("Мухомор");
        test.add("Камень");
        test.add("Дерево");
        test.add("Стас");
        test.add(142);
        test.add(257);
        test.delete(3);
        System.out.println(test.size);
    }
    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
            size++;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(new Node(data));
        size++;
    }

    public void insert(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(data);

        if (head == null || index == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        size--;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public int size() {
        return size;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}