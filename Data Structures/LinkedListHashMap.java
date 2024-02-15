//A hashmap that uses just LinkedList.java to create a hashmap only works with integers
class LinkedListHashMap{
    int mapLength; // How many linked list to be held in an array
    LinkedList[] table; //An array of linkedLists, each linkedlinked list acts as a bucket, allowing dynamic memory allocation

    LinkedListHashMap(int mapLength){
        this.mapLength = mapLength;
        this.table = new LinkedList[mapLength];
        for(int i = 0; i < mapLength; i++){
            this.table[i] = new LinkedList();
        }
    }

    public void put(int data, int index){
        this.table[index].insert(data);
    }

    //Deletes a specific value from a list by finding its hashcode and using LL removeValue function
    public void deleteVal(int data){
        for(LinkedList LL : this.table){
            LL.removeValue(data);
        }
    }

    //Sets the specific index head to null, clearing out any information that comes after it
    public void deleteKey(int index){
        this.table[index].head = null;
    }
    
    public void printMap(){
        for(int i = 0; i < mapLength; i++){
            System.out.println("---Index: " + i + "---");
            this.table[i].printList();
        }
    }
}

//A hashmap that uses GenericLinkedList.java to create a hashmap, requires hashcode and other functions to work
class GenericLLHashMap<T>{
    int mapLength; // How many linked list to be held in an array
    GenericLinkedList<T>[] table; //An array of linkedLists, each linkedlinked list acts as a bucket, allowing dynamic memory allocation

    @SuppressWarnings("unchecked")
    GenericLLHashMap(int mapLength){
        this.mapLength = mapLength;
        this.table = new GenericLinkedList[mapLength];
        for(int i = 0; i < mapLength; i++){
            this.table[i] = new GenericLinkedList<T>();
        }
    }

    public void put(T data){
        int index = Math.abs(data.hashCode() % this.mapLength); //creates the hashcode for the data then shrinks it to the proper size to fit the array
        this.table[index].insert(data); //uses the generic insert method to add it to the list.
    }
    
    //Deletes a specific value from a list by finding its hashcode and using LL removeValue function
    public void deleteVal(T data){
        for(GenericLinkedList<T> LL : this.table){
            LL.removeValue(data);
        }
    }

    //Sets the specific index head to null, clearing out any information that comes after it
    public void deleteKey(int index){
        this.table[index].head = null;
    }
    
    public void printMap(){
        for(int i = 0; i < mapLength; i++){
            System.out.println("---Index: " + i + "---");
            this.table[i].printList();
        }
    }
}
