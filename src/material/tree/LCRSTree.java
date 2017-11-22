package material.tree;
import material.tree.iterator.BFSIteratorFactory;
import material.tree.iterator.TreeIteratorFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * A linked class for a tree where nodes have an arbitrary number of children.
 *
 * @param <E> the elements stored in the tree
 * @author Raul Cabido, Abraham Duarte, Jose Velez, Jesús Sánchez-Oro
 */
public class LCRSTree<E> implements Tree<E> {
    private TreeNode<E> root;
    private int size;
    public LCRSTree() {
        root = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean isInternal(Position<E> v) throws IllegalStateException {
        return !isLeaf(v);
    }
    @Override
    public boolean isLeaf(Position<E> p) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        return (node.getFirstChildren() == null);
    }
    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        return (this.root == node);
    }
    @Override
    public Position<E> root() throws IllegalStateException {
        if(root == null) {
            throw new IllegalStateException("The tree is empty");
        }
        return root;
    }
    @Override
    public Position<E> parent(Position<E> p) throws IndexOutOfBoundsException, IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        Position<E> parentPos = node.getParent();
        if(parentPos == null) {
            throw new IndexOutOfBoundsException("The node has not parent");
        }
        return parentPos;
    }
    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        List children = new ArrayList();
        if(!this.isLeaf(node)) {
            children.add(node.getFirstChildren());
            while(node.getBrother() != null) {
                children.add(node.getBrother());
                node = node.getBrother();
            }
        }
        return children;
    }
    public E replace(Position<E> p, E e) throws IllegalStateException {
        TreeNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }
    @Override
    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        size = 1;
        root= new TreeNode<E>(e,this,null,null,null);
        return root;
    }
    public void swapElements(Position<E> p1, Position<E> p2) throws IllegalStateException {
        TreeNode<E> node1 = checkPosition(p1);
        TreeNode<E> node2 = checkPosition(p2);
        E temp = p2.getElement();
        node2.setElement(p1.getElement());
        node1.setElement(temp);
        
    }
    private TreeNode<E> checkPosition(Position<E> p) throws IllegalStateException {
        if (p == null || !(p instanceof TreeNode)) {
            throw new IllegalStateException("The position is invalid");
        }
        TreeNode<E> aux = (TreeNode<E>) p;
    
        if (aux.getMyTree() != this) {
            throw new IllegalStateException("The node is not from this tree");
        }
        return aux;
        
    }
    public Position<E> add(E element, Position<E> p) {
        TreeNode<E> parent=checkPosition(p);
        TreeNode<E> newNode = new  TreeNode<E>(element,this,parent,null,null);
        if (parent.getFirstChildren()==null){
            parent.setFirstChildren(newNode);

        }
        else{
        ArrayList<TreeNode<E>> childrenList= new ArrayList<TreeNode<E>>((Collection<? extends TreeNode<E>>) children(p)) ;
        TreeNode<E> ultimoHermano= null;
        for(TreeNode nodo:childrenList
            ) {
            if (nodo.getBrother()==null){ ultimoHermano= nodo;
            }
        }
        ultimoHermano.setBrother(newNode);
        }
        size++;
        return newNode;
    }
    public void remove(Position<E> p) throws IllegalStateException {
        TreeNode<E> node=checkPosition(p);
        if (isRoot(p)){
            this.root=null;
            this.size=0;
        }
        else{
            TreeNode<E> nodeParent= node.getParent();
            if (nodeParent.getFirstChildren()==node){
                nodeParent.setFirstChildren(node.getBrother());
            }
            else{
                ArrayList<TreeNode<E>> childrenList= new ArrayList<TreeNode<E>>((Collection<? extends TreeNode<E>>) children(p)) ;
                TreeNode<E> hermano= null;
                for(TreeNode nodo:childrenList
                        ) {
                    if (nodo.getBrother()==node){ hermano= nodo;
                    }
                }
               hermano.setBrother(node.getBrother());
            }
   
        }
    
        node.setMyTree(null);
        
        
        
    }
    public void setIterator(TreeIteratorFactory<E> iteratorFactory) {
        throw new UnsupportedOperationException(
                "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException(
                "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class TreeNode<T> implements Position<T> {
        private T element;
        private LCRSTree myTree;
        private TreeNode<T> parent;
        private TreeNode<T> firstChildren;
        private TreeNode<T> brother;
        public TreeNode(T element, LCRSTree myTree, TreeNode<T> parent, TreeNode<T> firstChildren,
                        TreeNode<T> brother) {
            this.element = element;
            this.myTree = myTree;
            this.parent = parent;
            this.firstChildren = firstChildren;
            this.brother = brother;
        }
        @Override
        public T getElement() {
            return element;
        }
        public void setElement(T element) {
            this.element = element;
        }
        public TreeNode<T> getParent() {
            return parent;
        }
        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }
        public TreeNode<T> getFirstChildren() {
            return firstChildren;
        }
        public void setFirstChildren(TreeNode<T> firstChildren) {
            this.firstChildren = firstChildren;
        }
        public TreeNode<T> getBrother() {
            return brother;
        }
        public void setBrother(TreeNode<T> brother) {
            this.brother = brother;
        }
        public LCRSTree getMyTree() {
            return myTree;
        }
        public void setMyTree(LCRSTree myTree) {
            this.myTree = myTree;
        }
    }
}