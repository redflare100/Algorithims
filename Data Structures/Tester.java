import java.util.*;
public class Tester<T>{
    //Tester main method
    public static void main(String[]args){

        //Consistent dataset for all non-generic Data Structures to make inserting and removing easier
        int[] dataset = {1,2,3,4,5,6,7,8,99999999, 10, 10};

        //A dataset for generic type data structures. Contains a mixture of various things to make it interesting
        List<Object> genericDataset = new ArrayList<>();
        genericDataset.add("String");
        genericDataset.add("Hello World!");
        genericDataset.add(3.14);
        genericDataset.add(true);

        //Create a single node and print the data
        System.out.println("===== Linked List Testing =====");
        LinkedList list = new LinkedList();

        System.out.println("----- Testing insert() -----");
        for(int data : dataset){
            list.insert(data);

            //Adds all of this to generic dataset for more variables
            genericDataset.add(data);
        }
        
        //print out the entire LL
        list.printList();

        System.out.println("----- Testing removeIndex() -----");
        Random rand = new Random();
        int seed = rand.nextInt(dataset.length - 3); //We're not counting nodes 8 or 9 as we want to use them for deletion later
        System.out.println("Removing from Index: " + seed);
        list.removeIndex(seed);
        list.printList();

        System.out.println("----- Testing removeValue() -----");
        System.out.println("Removing Value: 10");
        list.removeValue(10);

        list.printList();

        System.out.println("===== Integer Hash Map Testing =====");
        int mapLength = 5; //easy variable to manipulate size of hashmap
        LinkedListHashMap hashMap = new LinkedListHashMap(mapLength);

        for(int data: dataset){
            int key = rand.nextInt(hashMap.mapLength);
            System.out.println("    Adding " + data + " to hashmap at index " + key);
            hashMap.put(data, key);
        }

        hashMap.printMap();

        System.out.println("===== Generic Hash Map Testing =====");
        GenericLLHashMap<Object> genHashMap = new GenericLLHashMap<>(mapLength);

        for(Object thing: genericDataset){
            System.out.println("    Adding " + thing + " to Generic hashmap at index " + Math.abs(thing.hashCode() % mapLength));
            genHashMap.put(thing);
        }

        genHashMap.printMap();
        
        int randIndex = rand.nextInt(mapLength);
        System.out.println("    Removing Index " + randIndex + " from Generic hashmap");
        genHashMap.deleteKey(randIndex);
        genHashMap.printMap();

        int randVal = rand.nextInt(genericDataset.size());
        System.out.println("    Removing Generic " + genericDataset.get(randVal) + " from Generic Hashmap");
        genHashMap.deleteVal(genericDataset.get(randVal));
        genHashMap.printMap();        

        System.out.println("===== Generic Stack/Queue Testing =====");        
        GenericQueue<Object> queue = new GenericQueue<>();
        GenericStack<Object> stack = new GenericStack<>();

        for(Object item: genericDataset){
            queue.push(item);
            stack.push(item);
        }

        System.out.println("---Stack---");
        for(int j = 0; j < genericDataset.size(); j++){
            System.out.println("Node " + j + ": " + stack.pop().data);
        }

        System.out.println("---Queue---");
        for(int j = 0; j < genericDataset.size(); j++){
            System.out.println("Node " + j + ": " + queue.pop().data);
        }
    }
}
