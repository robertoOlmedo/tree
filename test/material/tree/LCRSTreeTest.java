package material.tree;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LCRSTreeTest {
    @Test
    public void size() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        assertEquals(t.size(), 0);
        Position<String> a = t.addRoot("A");
        assertEquals(t.size(), 1);
    }
    @Test
    public void isEmpty() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        assertTrue(t.isEmpty());
    }
    @Test
    public void isInternal() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertTrue(t.isInternal(b));
    
    }
    
    @Test
    public void isLeaf() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertTrue(t.isLeaf(a));
    }
    @Test
    public void isRoot() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertTrue(t.isRoot(a));
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertTrue(t.isRoot(a));
    }
    @Test
    public void root() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertTrue(t.root()==a);
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertTrue(t.root()==a);
    }
    @Test
    public void parent() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertTrue(t.parent(b)==a);
    }
    @Test
    public void children() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        Set<Position<String>> myChildren = new HashSet<>();
        myChildren.add(b);
        myChildren.add(c);
        for (Position<String> node : t.children(a)) {
            assertTrue(myChildren.contains(node));
        }
    }
    @Test
    public void replace() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        Position<String> c = t.add("C", a);
        Position<String> d = t.add("D", b);
        assertEquals(d.getElement(), "D");
        t.replace(d, "nuevo");
        assertEquals(d.getElement(), "nuevo");
    }
    @Test
    public void addRoot() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        assertEquals(a, t.root());
    }
    @Test
    public void swapElements() throws Exception {
        LCRSTree<String> t = new LCRSTree<>();
        Position<String> a = t.addRoot("A");
        Position<String> b = t.add("B", a);
        t.swapElements(a, b);
        assertEquals(b.getElement(), "A");
        assertEquals(a.getElement(), "B");
    
    }
    @Test
    public void add() throws Exception {
    }
    @Test
    public void remove() throws Exception {
    }
    @Test
    public void setIterator() throws Exception {
    }
    @Test
    public void iterator() throws Exception {
    }
}