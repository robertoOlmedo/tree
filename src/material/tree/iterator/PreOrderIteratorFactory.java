package material.tree.iterator;
import material.tree.Position;
import material.tree.Tree;

import java.util.Iterator;

public class PreOrderIteratorFactory<E> implements  TreeIteratorFactory <E> {
    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree) {
        return new PreOrderIterator<>(tree);
    }
    @Override
    public Iterator<Position<E>> createIterator(Tree<E> tree, Position<E> pos) {
        return new PreOrderIterator<>(tree,pos);
    }
}
