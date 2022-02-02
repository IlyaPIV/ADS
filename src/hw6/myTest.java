package hw6;


import lesson6.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class myTest {

    static List<TreeImpl<Integer>> treesList = new ArrayList<>();

    public static void main(String[] args) {
        initArrayOfTrees();
        checkTheTrees();
    }

    private static void initArrayOfTrees(){
        for (int i = 0; i < 20; i++) {
            treesList.add(initSingleTree());
        }
    }

    private static TreeImpl<Integer> initSingleTree(){
        TreeImpl<Integer> tree = new TreeImpl<>();
        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
            boolean isAvaliable = false;
            int newVar = 0;
            while (!isAvaliable) {
                newVar = rnd.nextInt(50)-25;
                if (!tree.contains(newVar)) {
                    tree.add(newVar);
                    isAvaliable = true;
                }
            }
            if (tree.treesDepth()==5) {
                tree.remove(newVar);
                break;
            }
        }
//        System.out.println("===================== TREE IS READY =====================\n");
//        tree.display();

        return tree;
    }

    private static void checkTheTrees(){
        int countBalanced = 0;
        int count = 0;
        for (TreeImpl<Integer> singleTree:
             treesList) {
            count++;
            System.out.printf("================================= TREE #%d =================================\n",count);
            singleTree.display();
            if (singleTree.checkBalance()) {
                System.out.println(">>> TREE IS BALANCED");
                countBalanced++;
            }
        }
        System.out.printf("Из %d деревьев %d являются сбалансированными\n",treesList.size(),countBalanced);
    }
}
