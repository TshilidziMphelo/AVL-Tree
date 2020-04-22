/**
 * Our AVLTree that extends BinaryTree.
 * @author Tshilidzi Mphelo
 * @version 1.0 
 */
import java.io.*;
import java.util.Scanner;

public class AVLTree extends BinaryTree{
   int count;
   int[] counts;
   private Scanner input;
   /**
    * This Constructor creates the AVL tree and takes the info from the file and reads it into the tree
    */
   public AVLTree(){
        try{
            input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
            }
        catch(FileNotFoundException e){
            System.out.println("File could not be opened");
            System.out.println(0);
            }
        while(input.hasNext()){
            String line = input.nextLine();
            int space = line.indexOf(" ");
            String period = line.substring(0,space);
            String area = line.substring(space,line.length());
            this.insert(new LoadShedding(period, area));
            }

       }
   /**
	 * Constructor that takes in an integer to represent the number that
	 * should be read into the AVLTreeExp.
	 * @param i The number of binary tree nodes to be created.
	 */
	public AVLTree(int i){
		try{
			input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("File could not be found.");
			System.out.println(0);
		}
		for(int t = 0;t < i; t++){
			String line = input.nextLine();
			int space = line.indexOf(" ");
			String period = line.substring(0,space);
			String area = line.substring(space,line.length());
			this.insert(new LoadShedding(period,area));
		}
	}
	/**
	 * This method returns an array that contains the number of comparisons
	 * done for each binary tree node in the tree.
	 */
	public int[] testTree(){
		try{
			input = new Scanner(new FileInputStream("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("File could not be found.");
			System.out.println(0);
		}
		counts = new int[this.getSize()];
		for(int i = 0;i < this.getSize();i++){
			String line = input.nextLine();
			int space = line.indexOf(" ");
			String period = line.substring(0,space);
			String area = line.substring(space,line.length());
			this.find(new LoadShedding(period,area));
			counts[i] = this.getCount();
		}
		int[] newCount = new int[this.getSize()];
		for(int i = 0;i < this.getSize();i++){
			newCount[i] = counts[i];
		}
		counts = null;
		return newCount;
	}
	/**
	 * Returns the smallest number of a given array of integers.
	 * @param i Takes in an array of integers.
	 */
	public int bestCase(int[] i){
		int minimum = i[0];
		for(int t = 0;t < i.length; t++){
			if(i[t] < minimum){minimum = i[t];}
		}
		return minimum;
	}
	/**
	 * Returns the largest number of a given array of integers.
	 * @param i Takes in an array of integers.
	 */
	public int worstCase(int[] i){
		int maximum = i[0];
		for(int t = 1;t < i.length;t++){
			if(i[t] > maximum){maximum = i[t];}
		}
		return maximum;
	}
	/**
	 * Returns the average number in an array of given integers.
	 * @param i Takes in an array of integers.
	 */
	public int aveCase(int[] i){
		int total = 0;
		for(int t = 0;t < i.length;t++){total+=i[t];}
		return total/i.length;
	}
   /**
    * Prints out the whole AVL tree .
    */
   public void printAllAreas(){
       this.inOrder();
       }
   /**
    * Returns the node of a given period.
    * @param stage the level of the LoadShedding object.
    * @param day the date at which it is going to occur
    * @param time the start time.
    */
   public String printAreas(String stage,String day,String time) {
       String period = stage+"_"+day+"_"+time;
       LoadShedding load = new LoadShedding(period,null);
       BinaryTreeNode nod = find(load);
       if (nod == null){return "Period does not exist!!!"; }
       return nod.getArea();
       }
   /**
    * Returns for Period doesn't exist for an empty constructor
    */
   public String printAreas(){return "Period does not exist!!!";}
   /**
    * Returns the count of the number of searches done.
    */
   public int getCount(){
	  int t = count;
	  count = 0;
      return t;
      }
   /**
    * Returns the height of the tree from the given node.
    * @param node height is going to be calculated from.
    */
   public int height ( BinaryTreeNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   /**
    * Returns the balance factor of the given node.
    * @param node the whose balance factor is to be calculated.
    */
   public int balanceFactor ( BinaryTreeNode node )
   {
      return height (node.right) - height (node.left);
   }
   /**
    * Fixes the height of the node if it changes have been made.
    * @param node the node to be fixed.
    */
   public void fixHeight ( BinaryTreeNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   /**
    * Right tree rotation
    * @param p node from which rotation is going to take place.
    */
   public BinaryTreeNode rotateRight ( BinaryTreeNode p )
   {
      BinaryTreeNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   /**
    * Left tree rotation
    * @param q node from which rotation is giong to start.
    */
   public BinaryTreeNode rotateLeft ( BinaryTreeNode q )
   {
      BinaryTreeNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   /**
    * Balances the subtree from the given node
    * @param p node from which balancing will start.
    */
   public BinaryTreeNode balance ( BinaryTreeNode p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   /**
    * Inserts the given LoadShedding object in the AVL tree.
    * @param d the node we going to add.
    */
   public void insert ( LoadShedding d )
   {
      root = insert (d, root);
   }
   /**
    * Uses the given LoadShedding object to create a new node and then adds
    * the node into the AVL tree.
    * @param d given LoadShedding object.
    * @param node insertion point.
    */
   public BinaryTreeNode insert ( LoadShedding d, BinaryTreeNode node )
   {
      if (node == null)
         return new BinaryTreeNode (d, null, null);
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   /**
    * Removes the node with matching LoadShedding object.
    * @param d given LoadShedding object.
    */
   public void delete ( LoadShedding d )
   {
      root = delete (d, root);
   }   
   /**
    * Searches for the node with matching LoadShedding object and deletes it.
    * @param d given LoadShedding object.
    * @param node point to start searching.
    */
   public BinaryTreeNode delete ( LoadShedding d, BinaryTreeNode node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode q = node.left;
         BinaryTreeNode r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   /**
    * Finds the minimum from the given node.
    * @param node point to start searching.
    */
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }
   /**
    * Removes the minimum node.
    * @param node to start searching.
    */
   public BinaryTreeNode removeMin ( BinaryTreeNode node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }
   /**
    * Searches for the node with matching LoadShedding object.
    * @param d the given LoadShedding object.
    */
   public BinaryTreeNode find ( LoadShedding d )
   {
      if (root == null){
         count ++;
         return null;
         }
      else
         return find (d, root);
   }
   /**
    * Searches for the node with matching LoadShedding object from the given node.
    * @param d the given LoadShedding object.
    * @param node the node to start searching.
    */
   public BinaryTreeNode find ( LoadShedding d, BinaryTreeNode node )
   {
      if (d.compareTo (node.data) == 0){
         count++;
         return node;
         }
      else if (node.getLeft() == null & node.getRight() == null) {return null; }
      else if (d.compareTo (node.data) < 0){
         count++;
         if (node.getLeft() == null){return null; }
         return find (d, node.left);
         }
      else{
         count++;
         if (node.getRight() == null){return null; }
         return find (d, node.right);
         }
   }
   /**
    * Prints out the whole tree.
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   /**
    * Prints out the tree from the given node.
    * @param node the node to start printing.
    * @param level the level to print.
    */
   public void treeOrder ( BinaryTreeNode node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }

}