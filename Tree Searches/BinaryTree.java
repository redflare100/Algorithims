public class BinaryTree {
    TreeNode root;

    void printTree(){
        printTreeRecurssion(this.root, 0);
    }

    void printTreeRecurssion(TreeNode node, int level){
        if(node == null) { return; }
    
        printTreeRecurssion(node.right, level + 1);
    
        for(int i = 0; i < level; i++) { System.out.print("    ");}
    
        System.out.println(node.value);
        printTreeRecurssion(node.left, level + 1);
    }

    void add(int value){
        root = insert(root, value);
    }

    TreeNode insert(TreeNode current, int value){
        if(current == null){ return new TreeNode(value); }

        if(value < current.value){ //Value goes to left
            current.left = insert(current.left, value);
        }
        else if(value > current.value){ //Value goes to right
            current.right = insert(current.right, value);
        }
        return current;
    }
}
