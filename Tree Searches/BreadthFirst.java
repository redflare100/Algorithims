import java.util.*; // Using imported queue and linkedlist. may implement one using my own later
public class BreadthFirst {
    void BreadthFirstSearch(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>(); // A queue can be used for BFS, DFS uses a stack
        queue.add(node);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current != null){
                System.out.print(current.value + ", ");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        System.out.println();
    }
}
