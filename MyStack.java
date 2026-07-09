class MyStack{

    private MyLinkedList list;

    public MyStack(){
        list = new MyLinkedList();
    }

    public void push(Object element){
        list.addFirst(element);
    }

    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(0);
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return list.get(0);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.peek()); // c
        System.out.println(stack.pop());  // c
        System.out.println(stack.pop());  // b
        System.out.println(stack.size()); // 1
    }


}