
import static org.junit.Assert.*;

import org.junit.Test;


public class RBTTester {

    @Test
    public void test() {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert("D");
        redBlackTree.insert("B");
        redBlackTree.insert("A");
        redBlackTree.insert("C");
        redBlackTree.insert("F");
        redBlackTree.insert("E");
        redBlackTree.insert("H");
        redBlackTree.insert("G");
        redBlackTree.insert("I");
        redBlackTree.insert("J");
        assertEquals("DBACFEHGIJ", makeString(redBlackTree));
        String str = "Color: 1, Key:D Parent: \n" +
                "Color: 1, Key:B Parent: D\n" +
                "Color: 1, Key:A Parent: B\n"+
                "Color: 1, Key:C Parent: B\n"+
                "Color: 1, Key:F Parent: D\n"+
                "Color: 1, Key:E Parent: F\n"+
                "Color: 0, Key:H Parent: F\n"+
                "Color: 1, Key:G Parent: H\n"+
                "Color: 1, Key:I Parent: H\n"+
                "Color: 0, Key:J Parent: I\n";
        assertEquals(str, makeStringDetails(redBlackTree));

    }

    public static String makeString(RedBlackTree t) {
        class MyVisitor implements Visitor {
            String result = "";
            public void visit(Node n) {
                result = result + n.getKey();
            }
        }
        MyVisitor v = new MyVisitor();
        t.preOrderVisit(v);
        System.out.println(v.result);
        return v.result;
    }

    public static String makeStringDetails(RedBlackTree t) {{
        class MyVisitor implements Visitor {
            String result = "";
            public void visit(Node node) {
                if(!(node.getKey()).equals("")) {
                    result = result + "Color: " + node.getNodeColor().ordinal()
                            + ", Key:" + node.getKey()
                            + " Parent: ";
                    if (node.getParent() != null)
                        result += node.getParent().getKey();
                    result += "\n";
                }
            }
        }
        MyVisitor v = new MyVisitor();
        t.preOrderVisit(v);
        return v.result;
    }
    }
}