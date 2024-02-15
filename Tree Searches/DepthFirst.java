import java.util.*; // Using imported stack. may implement one using my own later
public class DepthFirst {
    void DepthFirstSearch(TreeNode node){
        Stack<TreeNode> stack = new Stack<>(); // A stack can be used for BFS, DFS uses a stack
        stack.add(node);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current != null){
                System.out.print(current.value + ", ");
                stack.add(current.left);
                stack.add(current.right);
            }
        }
        System.out.println();
    }
}
