package ds;

public class NodeList {
    Node head;
    Node tail;
    int count;
    public NodeList() {
        head = null;
        tail = null;
        count =0;
    }
    public void addAtFront(int data,String stringData) {
        Node temp = head;
        Node newNode = new Node(data, stringData);
        newNode.next = temp;
        head = newNode;
        count++;
    }
    public void addAtBack(int data,String stringData) {
        Node node = new Node(data, stringData);
        Node temp = tail;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        tail = node;
        count++;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void print() {
        Node temp = head;
        while (isEmpty()) {
            System.out.print(temp.data + " "+" "+temp.stringData);
            temp = temp.next;
        }
    }
}
