//Because node is now generic it can't be held in LL itself
class GenericNode<T>{
    T data; //The Information store in this node
    GenericNode<T> next; // The next node

    GenericNode(T data){ // A Constructor for Nodes
        this.data = data;
        this.next = null; //next automatically set to null
    }
}

class GenericLinkedList<T>{
    GenericNode<T> head;
    int size;

    //Because it is now generic, a constructor for LL is necessary
    GenericLinkedList() { 
        this.head = null; 
        this.size = 0;
    }

    public void insert(T data){
        this.size++;
        GenericNode<T> new_node = new GenericNode<>(data); // Create a new node with the data given

        if(this.head == null){ // If the Linked List is empty, add to the head
            this.head = new_node;
            return;
        }
        //Find the first null node
        GenericNode<T> current = this.head; //The node we will traverse the LL with

        while(current.next != null){ //So long as the current node has data, continue
            current = current.next; //How to iterate through
        }

        current.next = new_node; // Setting new_node to the end
        return;
    }

    //Removes a specific index from LL. Head GenericNode is 0 index
    public void removeIndex(int index){
        this.size--;
        GenericNode<T> current = this.head; // The node we are currently at.
        GenericNode<T> previous = null; //The node before current, used eventually when we reach index
        int count = 0;
        if(index == 0){
            this.head = current.next;
            current.next = null;
            return;
        }

        while(count < index || current == null){ //While we haven't reached index OR we reach the end of the linked list, continue.
            previous = current; // Set previous to what the current node is
            current = current.next; // Set current to its next node
            count++; //Increment the count
        }

        previous.next = current.next; //Sets whatever previous is to what currents next is.
        current.next = null; //Removes any connection from current and the LL
    }

    //Removes a value from the LL completely. Even if there are multiple
    public boolean removeValue(T data){
        GenericNode<T> current = this.head; // The node we are currently at.
        GenericNode<T> previous = null; //The node before current, used eventually when we reach index
        boolean found = false; // changes if the value is found

        if(current == null){
            return found; //Linked List is empty, no need to check.
        }

        if(current.data == data){
            this.head = current.next;
            current.next = null;
            found = true;
            this.size--;
        }

        while(current != null){ //While we haven't reach the end of the linked list, continue.
            if(current.data == data){
                previous.next = current.next;
                current.next = null;
                current = previous;
                found = true;
                this.size--;
            }
            else{
                previous = current; // Set previous to what the current node is
                current = current.next; // Set current to its next node
            }
        }

        return found; //could not find the data in the linked list
    }

    public void printList(){
        //uses the same principle as cycling through insert, but in addition also prints the data found

        //Find the first null node
        int count = 0; // the index of a node
        GenericNode<T> current = this.head; //The node we will traverse the LL with

        while(current != null){ //So long as the current node has data, continue
            System.out.println("Node " + count + ": " + current.data); //prints the data and index
            current = current.next; //How to iterate through
            count++;
        }
    }
}
