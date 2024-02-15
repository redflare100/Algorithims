public class LinkedList {
    Node head;

    static class Node{
        int data; //The Information store in this node
        Node next; // The next node

        Node(int integer){ // A Constructor for Nodes
            data = integer;
            next = null; //next automatically set to null
        }
    }

    public void insert(int data){
        Node new_node = new Node(data); // Create a new node with the data given

        if(this.head == null){ // If the Linked List is empty, add to the head
            this.head = new_node;
            return;
        }
        //Find the first null node
        Node current = this.head; //The node we will traverse the LL with

        while(current.next != null){ //So long as the current node has data, continue
            current = current.next; //How to iterate through
        }

        current.next = new_node; // Setting new_node to the end
        return;
    }

    //Removes a specific index from LL. Head node is 0 index
    public void removeIndex(int index){
        Node current = this.head; // The node we are currently at.
        Node previous = null; //The node before current, used eventually when we reach index
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
    public boolean removeValue(int data){
        Node current = this.head; // The node we are currently at.
        Node previous = null; //The node before current, used eventually when we reach index
        boolean found = false; // changes if the value is found

        if(current == null){
            return found; //Linked List is empty, no need to check.
        }

        if(current.data == data){
            this.head = current.next;
            current.next = null;
            found = true;
        }

        while(current != null){ //While we haven't reach the end of the linked list, continue.
            if(current.data == data){
                previous.next = current.next;
                current.next = null;
                current = previous;
                found = true;
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
        Node current = this.head; //The node we will traverse the LL with

        while(current != null){ //So long as the current node has data, continue
            System.out.println("Node " + count + ": " + current.data); //prints the data and index
            current = current.next; //How to iterate through
            count++;
        }
    }
}
