public class MyArrayList{
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }

    public void add(Object element){
        if(size == data.length){
            resize();
        }
        data[size] = element;
        size++;
    }

    private void resize(){
        Object[] newData = new Object[data.length * 2];
        for(int i = 0; i < data.length; i += 1){
            newData[i] = data[i];
        }
        data = newData;
    }

    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    public Object remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object removed = data[index];
        for(int i = index; i < size - 1; i += 1){
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
        return removed;
    }

    public int size(){
        return size;
    }

    public boolean contains(Object element){
        for(int i = 0; i < size; i += 1){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

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

