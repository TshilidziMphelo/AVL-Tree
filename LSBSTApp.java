
/**
 * @author Tshilidzi
 * 26/02/2020
 * reads in data from the file and then creates a BST of the data
 */
import java.io.*;
import java.util.Scanner;

public class LSBSTApp extends BinaryTree {
    int i; // our counter for the comparisons
    private Scanner input;

    public LSBSTApp() {
        // acts as a constructor and it also reads in the data into the binary search
        // tree
        try {
            input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened");
            System.out.println(0);
        }
        while (input.hasNext()) {
            String line = input.nextLine();
            int space = line.indexOf(" ");
            String period = line.substring(0, space);
            String area = line.substring(space, line.length());
            this.insert(new LoadShedding(period, area));
            // System.out.println("out");
        }
    }

    /**
     * returns this current binary search tree
     * 
     * @return this binary search tree
     */
    public LSBSTApp getBST() {

        return this;
    }

    /**
     * gives you the node of a certain period using the find method
     * 
     * @param stage String the stage of loadshedding
     * @param date  String the date at which it is going to occur
     * @param time  String the time at whic it is going to start
     */
    public BinaryTreeNode printAreas(String stage, String day, String time) {
        String period = stage + "_" + day + "_" + time;
        LoadShedding load = new LoadShedding(period, null);
        // System.out.println(this.getBST().count());
        return this.getBST().find(load);
    }

    /**
     * prints out the entire binary search tree inorder
     *
     */
    public void printAllAreas() {
        this.getBST().inOrder();
    }

    /**
     * returns the count of the number of comparisons
     * 
     * @return size of count
     */
    public int getCount() {
        return i;
    }

    public void insert(LoadShedding d) {
        if (root == null)
            root = new BinaryTreeNode(d, null, null);
        else
            insert(d, root);
    }

    public void insert(LoadShedding d, BinaryTreeNode node) {
        if (d.compareTo(node.data) <= 0) {
            if (node.left == null)
                node.left = new BinaryTreeNode(d, null, null);
            else
                insert(d, node.left);
        } else {
            if (node.right == null)
                node.right = new BinaryTreeNode(d, null, null);
            else
                insert(d, node.right);
        }
    }

    public BinaryTreeNode find(LoadShedding d) {
        if (root == null)
            return null;
        else
            return find(d, root);
    }

    public BinaryTreeNode find(LoadShedding d, BinaryTreeNode node) {
        if (d.compareTo(node.data) == 0) {
            i++;
            return node;
        } else if (d.compareTo(node.data) < 0) {
            i++;
            return (node.left == null) ? null : find(d, node.left);
        } else {
            i++;
            return (node.right == null) ? null : find(d, node.right);
        }
    }

    public void delete(LoadShedding d) {
        root = delete(d, root);
    }

    public BinaryTreeNode delete(LoadShedding d, BinaryTreeNode node) {
        if (node == null)
            return null;
        if (d.compareTo(node.data) < 0)
            node.left = delete(d, node.left);
        else if (d.compareTo(node.data) > 0)
            node.right = delete(d, node.right);
        else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = removeMin(node.right);
        } else {
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }

    public BinaryTreeNode findMin(BinaryTreeNode node) {
        if (node != null)
            while (node.left != null)
                node = node.left;
        return node;
    }

    public BinaryTreeNode removeMin(BinaryTreeNode node) {
        if (node == null)
            return null;
        else if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else
            return node.right;
    }
}
