// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode
{
   LoadShedding data;  //a LoadShedding objecting is going to be our data
   BinaryTreeNode  left;  //left child of the parent node
   BinaryTreeNode  right;  //right child of the parent node
   /**
    * constructor for the binary tree node
    * @param d this is going to be the data of the node
    * @param l this is the left child of this node
    * @param r this is the right child of this node
    */
   public BinaryTreeNode ( LoadShedding d,  BinaryTreeNode l,BinaryTreeNode r )
   {
	   //constructor for the binary tree node
      data = d;
      left = l;
      right = r;
   }
   /**
    * returns the period of the node from the LoadShedding object
    */
   public String getPeriod() {
	   //return the period of the node from the LoadShedding object
      return data.getPeriod();
      } 
   BinaryTreeNode getLeft () { return left; }
   BinaryTreeNode getRight () { return right; }
   /**
    * returns a string of the loadshedding data
    */
   public String toString(){
	   //returns a string of the loadshedding data
      return data.toString();
   }
   
}
