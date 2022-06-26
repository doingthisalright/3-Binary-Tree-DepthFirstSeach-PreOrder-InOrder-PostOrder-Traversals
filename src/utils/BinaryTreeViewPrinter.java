package utils;

import binarytree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
         2
        / \
       /   \
      /     \
     /       \
     7       5
    / \     / \
   /   \   /   \
   2   6   3   6
  / \ / \ / \ / \
  5 8 4 5 8 4 5 8

       1
      / \
     /   \
    /     \
   /       \
   2       3
  / \
 /   \
 4   5
/
6
 */

// Taken from https://stackoverflow.com/a/4973083
public class BinaryTreeViewPrinter {
    public void printNode(final Node root) {
        int maxLevel = BinaryTreeViewPrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(final List<Node> currentLevelNodes, final int level, final int maxLevel) {
        if (currentLevelNodes.isEmpty() || BinaryTreeViewPrinter.isAllElementsNull(currentLevelNodes)) {
            return;
        }

        int distanceFromFloor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(distanceFromFloor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (distanceFromFloor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (distanceFromFloor + 1)) - 1;

        BinaryTreeViewPrinter.printWhitespaces(firstSpaces);

        final List<Node> newNodes = new ArrayList<>();
        for (final Node node : currentLevelNodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreeViewPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (final Node currentLevelNode : currentLevelNodes) {
                BinaryTreeViewPrinter.printWhitespaces(firstSpaces - i);
                if (currentLevelNode == null) {
                    BinaryTreeViewPrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (currentLevelNode.left != null) {
                    System.out.print("/");
                } else {
                    BinaryTreeViewPrinter.printWhitespaces(1);
                }

                BinaryTreeViewPrinter.printWhitespaces(i + i - 1);

                if (currentLevelNode.right != null) {
                    System.out.print("\\");
                } else {
                    BinaryTreeViewPrinter.printWhitespaces(1);
                }

                BinaryTreeViewPrinter.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static int maxLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(BinaryTreeViewPrinter.maxLevel(node.left), BinaryTreeViewPrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (final Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }
}
