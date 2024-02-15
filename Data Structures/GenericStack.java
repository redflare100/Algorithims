//Using the GenericLinkedList.java I created a LIFO Stack and FIFO Queue
public class GenericStack<T>{
    GenericLinkedList<T> stack;

    GenericStack(){
        this.stack = new GenericLinkedList<>(); //A stack is simply a linked list that pulls the tail
    }

    GenericNode<T> pop(){
        GenericNode<T> current = this.stack.head;
        while(current.next != null){
            current = current.next;
        }

        this.stack.removeIndex(this.stack.size - 1);
        return current;
    }

    void push(T data){
        this.stack.insert(data);
    }

    void clear(){
        this.stack.head = null;
    }
}
