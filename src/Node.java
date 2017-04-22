public class Node < T extends Comparable<T> >{
    private T key;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private NodeColor nodeColor;


    public Node(T key, Node parent) {
        this.setKey(key);
        this.setParent(parent);
        setNodeColor(NodeColor.RED);
    }

    public Boolean isLeftChild() {
        if (this.parent != null)
            return this.parent.leftChild == this;
        else
            return false;
    }
    public Boolean isRightChild() {
        if (this.parent != null)
            return this.parent.rightChild == this;
        else
            return false;
    }

    public Node getSibling() {
        if (this.isLeftChild()) {
            return this.parent.rightChild;
        } else if (this.isRightChild()) {
            return this.parent.leftChild;
        } else
            return null;
    }
    public Node getAunt() {
        if (parent != null)
            return this.parent.getSibling();
        else
            return null;
    }
    public Node getGrandParent() {
        return this.parent.parent;
    }
    public Boolean isRed(){
        return nodeColor == NodeColor.RED;
    }
    public Boolean isBlack(){
        return nodeColor == NodeColor.BLACK;
    }


    public Node add(T key) {
        Node node = new Node(key, null);
        if (key.compareTo(this.getKey()) < 0) {
            if (leftChild == null) {
                setLeftChild(node);
                return node;
//                return true;
            } else {
                return leftChild.add(key);
            }
        } else if (key.compareTo(this.getKey()) > 0) {
            if (rightChild == null) {
                setRightChild(node);
                return node;
//                return true;
            } else {
                return rightChild.add(key);
            }
        }
        return null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node node) {
        leftChild = node;
        if (node != null)
            leftChild.parent = this;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node node) {
        rightChild = node;
        if (node != null)
            rightChild.parent = this;
    }

    public NodeColor getNodeColor() {
        return nodeColor;
    }

    public void setNodeColor(NodeColor nodeColor) {
        this.nodeColor = nodeColor;
    }

    public enum NodeColor {
        RED, BLACK
    }

}