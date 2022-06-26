package binarytree;

public class BinaryTree {
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public boolean dfs(final Integer value) {
        return dfs(root, value);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private boolean dfs(final Node currentNode, final Integer value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }
        return dfs(currentNode.left, value) || dfs(currentNode.right, value);
    }

    private void preOrder(final Node currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println(currentNode.value);
        preOrder(currentNode.left);
        preOrder(currentNode.right);
    }

    private void inOrder(final Node currentNode) {
        if (currentNode == null) {
            return;
        }

        inOrder(currentNode.left);
        System.out.println(currentNode.value);
        inOrder(currentNode.right);
    }

    private void postOrder(final Node currentNode) {
        if (currentNode == null) {
            return;
        }

        postOrder(currentNode.left);
        postOrder(currentNode.right);
        System.out.println(currentNode.value);
    }
}
