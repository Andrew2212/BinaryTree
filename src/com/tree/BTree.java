package com.tree;

/**
 * * Created with IntelliJ IDEA.
 * User: Andrew2212<br/>
 * <p/>
 * http://habrahabr.ru/post/65617/
 * http://www.sql.ru/forum/511649/binarnoe-derevo
 * http://www.ivan-nikolov.com/ru/article/12/algorithms-and-data-structures-binary-trees
 */
public class BTree<T1 extends Comparable<T1>, T2> {

    private Node<T1, T2> nodeRoot;

    //============Traversal Methods=========================

    public void forEach() {

        print("BTree::forEach()");
        traverseTree(nodeRoot);
    }

    private void traverseTree(Node nodeCurrent) {

        if (nodeCurrent == null) return;

        processNode(nodeCurrent);
        traverseTree(nodeCurrent.getLeft());
        traverseTree(nodeCurrent.getRight());
    }

    private void processNode(Node nodeCurrent) {
        System.out.println("BTree::processNode()::nodeCurrent = " + nodeCurrent);
    }
    //====================================================

    public void add(T1 key, T2 value) {

        if (nodeRoot == null) {
            nodeRoot = new Node<T1, T2>(key, value);
            print("BTree::addNextNode()::nodeRoot = new Node(key, value)::" + nodeRoot);
            return;
        }

        nodeRoot.addNextNode(key, value);
    }

    /**
     * @param key T1
     * @return Node with same key
     */
    public Node findNode(T1 key) {

        Node<T1, T2> nodeCurrent = nodeRoot;

        while (nodeCurrent != null) {
            int compare = key.compareTo(nodeCurrent.getKey());
            if (compare == 0) {
                print("BTree::findNode()::node = " + nodeCurrent);
                return nodeCurrent;
            }
            if (compare < 0) {
                nodeCurrent = nodeCurrent.getLeft();
            }
            if (compare > 0) {
                nodeCurrent = nodeCurrent.getRight();
            }
        }
        print("BTree::findNode()::node = " + nodeCurrent);
        return null;
    }


    //    =========Utils Methods================
    @SuppressWarnings("all")
    private void print(String msg) {

//        boolean isAllowed = false;
        boolean isAllowed = true;

        if (isAllowed) {
            System.out.println(msg);
        }

    }
}
