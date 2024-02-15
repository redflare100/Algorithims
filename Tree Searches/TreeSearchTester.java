public class TreeSearchTester {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(7);
        tree.add(3);
        tree.add(9);
        tree.add(4);
        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(8);
        tree.add(10);

        System.out.println("Root: " + tree.root.value);
        tree.printTree();
        System.out.println("=====Breadth First Tree Printer=====");

        BreadthFirst bfs = new BreadthFirst();
        bfs.BreadthFirstSearch(tree.root);

        System.out.println("=====Depth First Tree Printer=====");

        DepthFirst dfs = new DepthFirst();
        dfs.DepthFirstSearch(tree.root);
    }
}
