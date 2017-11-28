package material.tree.iterator;

import material.tree.Position;
import material.tree.Tree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class PreOrderIterator<E> implements Iterator<Position<E>>{


    private final ArrayDeque<Position<E>> nodeQueue;
    private Stack<Position<E>> pilaAuxiliar;
    private final Tree<E> tree;

    public PreOrderIterator(Tree<E> tree, Position<E> start) {
        nodeQueue = new ArrayDeque<>();
        pilaAuxiliar=new Stack<>();
        this.tree = tree;
        nodeQueue.add(start);
    }

    public PreOrderIterator(Tree<E> tree) {
        nodeQueue = new ArrayDeque<>();
        pilaAuxiliar=new Stack<>();
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
        for (Position<E> node : tree.children(aux)) {
            pilaAuxiliar.push(node);

        }
while (!pilaAuxiliar.isEmpty()){
            nodeQueue.addFirst(pilaAuxiliar.pop());
}


        return aux;
    }
}
