public class MyLinkedList{

    private class Node{
        Object data;
        Node next;

        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object element){
        Node newnode = new Node(element);

        if(head == null){
            head = newnode;
        }
        else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newnode;
        }
        size += 1;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for(int i = 0; i < index;i += 1){
            current = current.next;
        }
        return (int)current.data;
    }

    public Object remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removed;
        if(index == 0){
            removed = head.data;
            head = head.next;
        }
        else{
            Node current = head;
            for(int i = 0; i < index - 1; i += 1){
                current = current.next;
            }
            removed = current.next.data;
            current.next = current.next.next;
        }
        size -= 1;
        return removed;
    }

    public int size(){
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while(current != null){
            sb.append(current.data);
            if(current.next != null){
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);       

        list.remove(1);
        System.out.println(list);        

        System.out.println(list.get(0)); 
        System.out.println(list.size()); 
    }
}

