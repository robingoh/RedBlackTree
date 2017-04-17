/**
 * Created by robg on 4/17/17.
 */
public class RedBlackTree {
    public void insert(String d) {
    }

      public static interface Visitor
      {
      	/**
         This method is called at each node.
         @param n the visited node
      	 */
      	void visit(Node n);
      }


     public void preOrderVisit(Visitor v)
      {
      	preOrderVisit(root, v);
      }


     private static void preOrderVisit(Node n, Visitor v)
      {
      	if (n == null) return;
      	v.visit(n);
      	preOrderVisit(n.left, v);
      	preOrderVisit(n.right, v);
      }
}
