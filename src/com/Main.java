package com;

import com.tree.BTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew2212
 */
public class Main {

    public static final int NUM = 29;

    public static void main(String[] args) throws InterruptedException {

        BTree<Integer, String> bTree = new BTree<Integer, String>();

         fillManual(bTree);
//        fillByThreads(bTree);

        bTree.forEach();
        bTree.findNode(2);

        System.out.println("There should be BreakPoint for debug");
    }

    @SuppressWarnings("unused")
    public static void fillManual(BTree<Integer, String> bTree) {
        int[] keys = {5, 9, 2, 7, 11, 4, 1, 5};
        for (int i = 0; i < keys.length; i++) {
            bTree.add(keys[i], "v_" + i);
        }
    }

    @SuppressWarnings("unused")
    public static void fillByThreads(BTree<Integer, String> bTree) throws InterruptedException {

        bTree.add(NUM / 2, "nodeRoot");
        List<FeederThread> threads = new ArrayList<FeederThread>();
        FeederThread thread;

        for (int i = 0; i < NUM; i++) {
            thread = new FeederThread(bTree, "v_" + i);
            thread.setName("FeederThread_" + i);
            threads.add(thread);
        }

        for (FeederThread t : threads) {
            t.start();
        }

        for (FeederThread t : threads) {
            t.join();
        }
    }
}

class FeederThread extends Thread {

    private BTree<Integer, String> bTree;
    private String value;

    public FeederThread(BTree<Integer, String> bTree, String value) {
        this.bTree = bTree;
        this.value = value;
    }

    @Override
    public void run() {
        bTree.add((int) (Math.random() * Main.NUM), value);
    }

}
