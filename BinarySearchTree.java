/**
 * @author Tshilidzi
 * 
 * reads in data from the file and then creates a BST of the data
 */
import java.io.*;
import java.util.Scanner;

public class BinarySearchTree extends BinaryTree 
{
   int i; // our counter for the comparisons
   int[] counts;
   private Scanner input;

   /**
    * This Constructor creates the AVL tree and takes the info from the file and
    * reads it into the tree
    */
   public BinarySearchTree() {
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
      }

   }

   /**
    * Constructor that takes in an integer to represent the number that
    * should be read into the BSTExp.
    * 
    * @param i The number of binary tree nodes to be created.
    */
   public BinarySearchTree(int i) {
      try {
         input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
      } catch (FileNotFoundException e) {
         System.out.println("File could not be found.");
         System.out.println(0);
      }
      for (int t = 0; t < i; t++) {
         String line = input.nextLine();
         int space = line.indexOf(" ");
         String period = line.substring(0, space);
         String area = line.substring(space, line.length());
         this.insert(new LoadShedding(period, area));
      }
   }

   /**
    * This method returns an array that contains the number of comparisons
    * done for each binary tree node in the tree.
    */
   public int[] testTree() {
      try {
         input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
      } catch (FileNotFoundException e) {
         System.out.println("File could not be found.");
         System.out.println(0);
      }
      counts = new int[this.getSize()];
      for (int i = 0; i < this.getSize(); i++) {
         String line = input.nextLine();
         int space = line.indexOf(" ");
         String period = line.substring(0, space);
         String area = line.substring(space, line.length());
         this.find(new LoadShedding(period, area));
         counts[i] = this.getCount();
      }
      int[] newCount = new int[this.getSize()];
      for (int i = 0; i < this.getSize(); i++) {
         newCount[i] = counts[i];
      }
      counts = null;
      return newCount;
   }

   /**
    * Returns the smallest number of a given array of integers.
    * 
    * @param i Takes in an array of integers.
    */
   public int bestCase(int[] i) {
      int minimum = i[0];
      for (int t = 0; t < i.length; t++) {
         if (i[t] < minimum) {
            minimum = i[t];
         }
      }
      return minimum;
   }

   /**
    * Returns the largest number of a given array of integers.
    * 
    * @param i Takes in an array of integers.
    */
   public int worstCase(int[] i) {
      int maximum = i[0];
      for (int t = 1; t < i.length; t++) {
         if (i[t] > maximum) {
            maximum = i[t];
         }
      }
      return maximum;
   }

   /**
    * Returns the average number in an array of given integers.
    * 
    * @param i Takes in an array of integers.
    */
   public int aveCase(int[] i) {
      int total = 0;
      for (int t = 0; t < i.length; t++) {
         total += i[t];
      }
      return total / i.length;
   }

   /**
    * Returns the Area of a given period.
    * 
    * @param stage the level of the LoadShedding object.
    * @param day   the date at which it is going to occur
    * @param time  the start time.
    */
   public String printAreas(String stage, String day, String time) {
      String period = stage + "_" + day + "_" + time;
      LoadShedding load = new LoadShedding(period, null);
      BinaryTreeNode nod = find(load);
      if (nod == null) {
         return "Period does not exist!!!";
      }
      return nod.getArea();
   }

   public String printAreas() {
      return "Period does not exist!!!";
   }

   /**
    * Prints out the entire binary search tree inorder
    */
   public void printAllAreas() {
      this.inOrder();
   }

   /**
    * Returns the count of the number of comparisons
    * 
    * @return size of count
    */
   public int getCount() {
      int t = i;
      i = 0;
      return t;
   }

   /**
    * Inserts the given LoadShedding object in the AVL tree.
    * 
    * @param d the node we going to add.
    */
   public void insert(LoadShedding d) {
      if (root == null)
         root = new BinaryTreeNode(d, null, null);
      else
         insert(d, root);
   }

   /**
    * Uses the given LoadShedding object to create a new node and then adds
    * the node into the AVL tree.
    * 
    * @param d    given LoadShedding object.
    * @param node insertion point.
    */
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

   /**
    * Searches for the node with matching LoadShedding object.
    * 
    * @param d the given LoadShedding object.
    */
   public BinaryTreeNode find(LoadShedding d) {
      if (root == null)
         return null;
      else
         return find(d, root);
   }

   /**
    * Searches for the node with matching LoadShedding object from the given node.
    * 
    * @param d    the given LoadShedding object.
    * @param node the node to start searching.
    */
   public BinaryTreeNode find(LoadShedding d, BinaryTreeNode node) {
      if (d.compareTo(node.data) == 0) {
         i++;
         return node;
      } else if (node.getLeft() == null & node.getRight() == null) {
         return null;
      } else if (d.compareTo(node.data) < 0) {
         i++;
         if (node.getLeft() == null) {
            return null;
         }
         return find(d, node.left);
      } else {
         i++;
         if (node.getRight() == null) {
            return null;
         }
         return find(d, node.right);
      }
   }

   /**
    * Removes the node with matching LoadShedding object.
    * 
    * @param d given LoadShedding object.
    */
   public void delete(LoadShedding d) {
      root = delete(d, root);
   }

   /**
    * Searches for the node with matching LoadShedding object and deletes it.
    * 
    * @param d    given LoadShedding object.
    * @param node point to start searching.
    */
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
      } else if (node.left != null)
         node = node.left;
      else
         node = node.right;
      return node;
   }

   /**
    * Finds the minimum from the given node.
    * 
    * @param node point to start searching.
    */
   public BinaryTreeNode findMin(BinaryTreeNode node) {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }

   /**
    * Removes the minimum node.
    * 
    * @param node to start searching.
    */
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
