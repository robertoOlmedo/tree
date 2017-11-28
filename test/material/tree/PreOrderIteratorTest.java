package material.tree.iterator;
import material.tree.LCRSTree;
import material.tree.LinkedTree;
import material.tree.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class PreOrderIteratorTest
{
    @Test
    public void comprobarLinkendTree(){
        List<Integer> listaComparacion= new ArrayList<>(Arrays.asList(1,2,4,9,5,3,6,7,10,8));
        List<Integer> listaResultadoRecorrido= new ArrayList<>();
        LinkedTree<Integer> t = new LinkedTree<>();
        Position<Integer> a = t.addRoot(1);
        Position<Integer> b = t.add(2, a);
        Position<Integer> c = t.add(3, a);
        Position<Integer> d = t.add(4, b);
        Position<Integer> e = t.add(5, b);
        Position<Integer> f = t.add(6, c);
        Position<Integer> g = t.add(7, c);
        Position<Integer> h = t.add(8, c);
        Position<Integer> i = t.add(9, d);
        Position<Integer> j = t.add(10, g);
        Iterator<Position<Integer>> iterator = new PreOrderIterator<Integer>(t);
        while (iterator.hasNext()) {
            Position<Integer> node = iterator.next();
            listaResultadoRecorrido.add(node.getElement());
        }
        assertArrayEquals(listaResultadoRecorrido.toArray(), listaComparacion.toArray());
        listaComparacion.clear();
        listaComparacion.add(3);
        listaComparacion.add(6);
        listaComparacion.add(7);
        listaComparacion.add(10);
        listaComparacion.add(8);
        listaResultadoRecorrido.clear();
        Iterator<Position<Integer>> interatorSubArbol = new PreOrderIterator<Integer>(t,c);
        while (interatorSubArbol.hasNext()) {
            Position<Integer> node = interatorSubArbol.next();
            listaResultadoRecorrido.add(node.getElement());
        }
        assertArrayEquals(listaResultadoRecorrido.toArray(), listaComparacion.toArray());
    }
    
    @Test
    public void comprobarLCRSTree(){
        List<Integer> listaComparacion= new ArrayList<>(Arrays.asList(1,2,4,9,5,3,6,7,10,8));
        List<Integer> listaResultadoRecorrido= new ArrayList<>();
        LCRSTree<Integer> t = new LCRSTree<>();
        Position<Integer> a = t.addRoot(1);
        Position<Integer> b = t.add(2, a);
        Position<Integer> c = t.add(3, a);
        Position<Integer> d = t.add(4, b);
        Position<Integer> e = t.add(5, b);
        Position<Integer> f = t.add(6, c);
        Position<Integer> g = t.add(7, c);
        Position<Integer> h = t.add(8, c);
        Position<Integer> i = t.add(9, d);
        Position<Integer> j = t.add(10, g);
        Iterator<Position<Integer>> iterator = new PreOrderIterator<Integer>(t);
        while (iterator.hasNext()) {
            Position<Integer> node = iterator.next();
            listaResultadoRecorrido.add(node.getElement());
        }
        assertArrayEquals(listaResultadoRecorrido.toArray(), listaComparacion.toArray());
        listaComparacion.clear();
        listaComparacion.add(3);
        listaComparacion.add(6);
        listaComparacion.add(7);
        listaComparacion.add(10);
        listaComparacion.add(8);
        listaResultadoRecorrido.clear();
        Iterator<Position<Integer>> interatorSubArbol = new PreOrderIterator<Integer>(t,c);
        while (interatorSubArbol.hasNext()) {
            Position<Integer> node = interatorSubArbol.next();
            listaResultadoRecorrido.add(node.getElement());
        }
        assertArrayEquals(listaResultadoRecorrido.toArray(), listaComparacion.toArray());
    }
    
}