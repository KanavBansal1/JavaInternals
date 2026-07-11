public class MyHashMap{

    private class Entry{
        Object key;
        Object value;
        Entry next;

        Entry(Object key,Object value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

        private Entry[] buckets;
        private int size;
        private static final int capacity = 16;

        public MyHashMap(){
            buckets = new Entry[capacity];
            size = 0;
        }

        private int hash(Object key){
            return Math.abs(key.hashCode()) % capacity;
        }

        public void put(Object key,Object value){
            int index = hash(key);
            Entry current = buckets[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            Entry newEntry = new Entry(key, value);
            newEntry.next = buckets[index];
            buckets[index] = newEntry;
            size++;
        } 

        public Object get(Object key){
            int index = hash(key);
            Entry current = buckets[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }

        public Object remove(Object key) {
            int index = hash(key);
            Entry current = buckets[index];
            Entry prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) {
                        buckets[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    return current.value;
                }
                prev = current;
                current = current.next;
            }
            return null;
        }

        public boolean containsKey(Object key) {
            return get(key) != null;
        }

        public int size() {
            return size;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < capacity; i++) {
                Entry current = buckets[i];
                while (current != null) {
                    sb.append(current.key).append("=").append(current.value);
                    if (current.next != null) sb.append(", ");
                    current = current.next;
                }
            }
            sb.append("}");
            return sb.toString();
        }


        public static void main(String[] args) {
            MyHashMap map = new MyHashMap();

            map.put("name", "temp");
            map.put("role", "engineer");
            map.put("lang", "Java");

            System.out.println(map.get("name"));    
            System.out.println(map.get("role"));    
            System.out.println(map.containsKey("lang")); 
            System.out.println(map.containsKey("age"));

            map.put("name", "temp2");           
            System.out.println(map.get("name"));       

            map.remove("role");
            System.out.println(map.get("role"));     
            System.out.println(map.size());     
    }
}