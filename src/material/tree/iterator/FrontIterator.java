package material.tree.iterator;

import material.tree.Position;
import material.tree.Tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class FrontIterator<E> implements Iterator<Position<E>> {

    private final Queue<Position<E>> nodeQueue;
    private final Tree<E> tree;

    public FrontIterator(Tree<E> tree, Position<E> start) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        nodeQueue.add(start);
    }

    public FrontIterator(Tree<E> tree) {
        nodeQueue = new ArrayDeque<>();
        this.tree = tree;
        nodeQueue.add(tree.root());
    }

    @Override
    public boolean hasNext() {
        return (nodeQueue.size() != 0);
    }

    @Override
    public Position<E> next() {
        Position<E> aux = nodeQueue.remove();
        while (!tree.isLeaf(aux)) {
            for (Position<E> node : tree.children(aux)) {
                nodeQueue.add(node);
            }
            aux = nodeQueue.remove();
        }
        return aux;
    }


}
