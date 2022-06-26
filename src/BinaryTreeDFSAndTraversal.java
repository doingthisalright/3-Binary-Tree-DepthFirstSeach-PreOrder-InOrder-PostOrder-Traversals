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

        new BinaryTreeViewPrinter().printNode(binaryTree.root);
    }
}
