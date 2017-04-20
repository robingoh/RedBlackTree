/**
 * Created by robg on 4/17/17.
 */
public class RedBlackTree < T extends Comparable<T> > {
    private Node root;

    public Node lookup(T key) {
        Node current = root;
        while (current.getKey() != key) {
            if (key.compareTo((T) current.getKey()) < 0)
                current = current.getLeftChild();
            else
                current = current.getRightChild();
            if (current == null)
                return null;
        }
        return current;
    }
    public void insert(T key) {
        if (root == null) {
            root = new Node(key, null);
            fixTree(root);
        } else {
            fixTree(root.add(key));
        }
    }
    public void leftRotate(Node x) {
        Node y = x.getRightChild();
        Node B = y.getLeftChild();
        x.setRightChild(B);
        y.setLeftChild(x);
    }
    public void rightRotate(Node y) {
        Node x = y.getLeftChild();
        Node B = x.getRightChild();
        y.setLeftChild(B);
        x.setRightChild(y);
    }
    public void fixTree(Node current) {
        if (current == root) {
            current.setNodeColor(Node.NodeColor.BLACK);
            return;
        }
        if (current.getParent().isBlack()) {
            return;
        }
        if (current.isRed() && current.getParent().isRed()) {
            Node parent = current.getParent();
            Node grandParent = current.getGrandParent();
            Node aunt = current.getAunt();
            if (aunt == null || aunt.isBlack()) {

                if (current.isRightChild() && parent.isLeftChild()) {
                    leftRotate(parent);
                    fixTree(parent);
                } else if (current.isLeftChild() && parent.isRightChild()) {
                    rightRotate(parent);
                    fixTree(parent);
                } else if (current.isLeftChild() && parent.isLeftChild()) {
                    parent.setNodeColor(Node.NodeColor.BLACK);
                    grandParent.setNodeColor(Node.NodeColor.RED);
                    rightRotate(grandParent);
                    return;
                } else if (current.isRightChild() && parent.isRightChild()) {
                    parent.setNodeColor(Node.NodeColor.BLACK);
                    grandParent.setNodeColor(Node.NodeColor.RED);
                    leftRotate(grandParent);
                    return;
                }
            } else if (aunt.isRed()) {
                parent.setNodeColor(Node.NodeColor.BLACK);
                aunt.setNodeColor(Node.NodeColor.BLACK);
                grandParent.setNodeColor(Node.NodeColor.RED);
                fixTree(grandParent);
            }
        }
    }




    public void preOrderVisit(Visitor v) {
        preOrderVisit(root, v);
    }


    private static void preOrderVisit(Node node, Visitor visitor) {
        if (node == null)
            return;
        visitor.visit(node);
        preOrderVisit(node.getLeftChild(), visitor);
        preOrderVisit(node.getRightChild(), visitor);
    }
}
