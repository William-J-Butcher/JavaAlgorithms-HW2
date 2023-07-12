class Node {
    private Node pre;
    private Node next;
    private final int data;
    public Node(int data) {
        this.data = data;
    }
    public void append(Node node) {
        if (this.next == null) {
            this.next = node;
            node.pre = this;
        }
        else {
            this.next.append(node);
        }
    }

    public Node getPre() {
        return pre;
    }
    public void setPre(Node pre) {
        this.pre = pre;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public int getData() {
        return data;
    }
}

class NodeList {
    Node head;
    Node last;

    public String toString() {
        Node curr = head;
        StringBuilder sBuilder = new StringBuilder();
        while (curr != null) {
            sBuilder.append(curr.getData()).append(curr.hasNext() ? "->" : "");
            curr = curr.getNext();
        }
        return sBuilder.toString();
    }

    public String reverse() {
        Node curr = head;
        Node newHead = null;
        Node newLast = null;
        while (curr != null) {
            Node pre = curr.getPre();
            Node next = curr.getNext();
            if (pre == null) newLast = curr; // Предыдущий узел пуст, как новый хвостовой узел
            if (next == null) newHead = curr; // Следующий узел пуст, как новый головной узел
            curr.setNext (pre); // Следующий узел текущего узла используется как предыдущий узел текущего узла
            curr.setPre (next); // Предыдущий узел текущего узла является следующим узлом текущего узла
            curr = curr.getPre (); // Продолжаем обработку следующего узла исходного узла связанного списка
        }
        head = newHead; // Устанавливаем головной узел
        last = newLast; // Устанавливаем конечный узел
        return this.toString();
    }
}
class TestNode {

    public static void main(String[] args) {
        NodeList list = new NodeList();
        for (int i = 0; i < 15; i++) {
            int r = (int)(Math.random() * 100);
            Node node = new Node(r);
            if (i == 0) {
                list.head = node; // головной узел
            } else {
                list.head.append(node);
            }
            list.last = node; // хвостовой узел
        }

        System.out.println ("\nДвусвязный список из 15 элементов:");
        System.out.println(list);
        System.out.println ("\nРазворот двусвязного списока из 15 элементов:");
        System.out.println(list.reverse());

    }
}


