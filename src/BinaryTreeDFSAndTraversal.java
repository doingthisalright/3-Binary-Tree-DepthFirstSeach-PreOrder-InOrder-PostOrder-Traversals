import binarytree.BinaryTree;
import binarytree.Node;
import utils.BinaryTreeViewPrinter;

/*
     1
   /   \
  2     3
 /     / \
4      5  6
        \
         7
*/
public class BinaryTreeDFSAndTraversal {
    public static void main(final String[] args) {
        final Node one = new Node(1);
        final Node two = new Node(2);
        final Node three = new Node(3);
        final Node four = new Node(4);
        final Node five = new Node(5);
        final Node six = new Node(6);
        final Node seven = new Node(7);

        one.left = two;
        one.right = three;

        two.left = four;

        three.left = five;
        three.right = six;

        five.right = seven;

        final BinaryTree binaryTree = new BinaryTree(one);

        System.out.println("Using Tree:");
        new BinaryTreeViewPrinter().printNode(binaryTree.root);

        System.out.println("---------------");
        System.out.println("Depth First Search:");
        System.out.print("5 found in tree? ");
        System.out.println(binaryTree.dfs(5));
        System.out.print("-5 found in tree? ");
        System.out.println(binaryTree.dfs(-5));
        System.out.println("---------------");

        System.out.println("Pre Order Traversal:");
        binaryTree.preOrder();
        System.out.println("---------------");
        System.out.println("In Order Traversal:");
        binaryTree.inOrder();
        System.out.println("---------------");
        System.out.println("Post Order Traversal:");
        binaryTree.postOrder();
        System.out.println("---------------");
    }
}
