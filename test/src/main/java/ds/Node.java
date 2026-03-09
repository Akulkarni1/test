package ds;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    int data;
    String stringData;
    Node next;

    public Node(int data, String stringData) {

    this.data = data;
    this.stringData = stringData;
    next=null;
    }
}
