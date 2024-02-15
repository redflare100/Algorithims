public class GenericQueue<T>{
    GenericLinkedList<T> queue;
    GenericQueue(){
        this.queue = new GenericLinkedList<>();
    }

    GenericNode<T> pop(){ //removes the head and returns it to the caller
    GenericNode<T> poppedHead = this.queue.head;
    this.queue.removeIndex(0);
        return poppedHead;
    }

    void push(T data){
        this.queue.insert(data);
    }

    void clear(){
        this.queue.head = null;
    }
}
