/**
 * Experiment for the AVLTree.
 * @author Tshilidzi Mphelo
 * @version 2.0 
 */
import java.io.*;
import java.util.Scanner;

public class AVLTreeExp{
	public static void main(String[] args){
		System.out.println("Experiment for our AVLTree.");
		
		AVLTree one = new AVLTree(296);
		int[] a = one.testTree();
		System.out.println("1.Best Case: "+one.bestCase(a));
		System.out.println("  Average Case: "+one.aveCase(a));
		System.out.println("  Worst Case: "+one.worstCase(a));
		System.out.println("");
		
		AVLTree two = new AVLTree(593);
		int[] b = two.testTree();
		System.out.println("2.Best Case: "+two.bestCase(b));
		System.out.println("  Average Case: "+two.aveCase(b));
		System.out.println("  Worst Case: "+two.worstCase(b));
		System.out.println("");
		
		AVLTree thr = new AVLTree(890);
		int[] c = thr.testTree();
		System.out.println("3.Best Case: "+thr.bestCase(c));
		System.out.println("  Average Case: "+thr.aveCase(c));
		System.out.println("  Worst Case: "+thr.worstCase(c));
		System.out.println("");
		
		AVLTree fou = new AVLTree(1187);
		int[] d = fou.testTree();
		System.out.println("4.Best Case: "+fou.bestCase(d));
		System.out.println("  Average Case: "+fou.aveCase(d));
		System.out.println("  Worst Case: "+fou.worstCase(d));
		System.out.println("");
		
		AVLTree fiv = new AVLTree(1484);
	    int[] e = fiv.testTree();
	    System.out.println("5.Best Case: "+fiv.bestCase(e));
		System.out.println("  Average Case: "+fiv.aveCase(e));
		System.out.println("  Worst Case: "+fiv.worstCase(e));
		System.out.println("");
		
		AVLTree six = new AVLTree(1781);
		int[] f =  six.testTree();
		System.out.println("6.Best Case: "+six.bestCase(f));
		System.out.println("  Average Case: "+six.aveCase(f));
		System.out.println("  Worst Case: "+six.worstCase(f));
		System.out.println("");
		
		AVLTree sev = new AVLTree(2078);
		int[] g = sev.testTree();
		System.out.println("7.Best Case: "+sev.bestCase(g));
		System.out.println("  Average Case: "+sev.aveCase(g));
		System.out.println("  Worst Case: "+sev.worstCase(g));
		System.out.println("");
		
		AVLTree eig = new AVLTree(2375);
		int[] h = eig.testTree();
		System.out.println("8.Best Case: "+eig.bestCase(h));
		System.out.println("  Average Case: "+eig.aveCase(h));
		System.out.println("  Worst Case: "+eig.worstCase(h));
		System.out.println("");
		
		AVLTree nin = new AVLTree(2672);
		int[] i = nin.testTree();
		System.out.println("9.Best Case: "+nin.bestCase(i));
		System.out.println("  Average Case: "+nin.aveCase(i));
		System.out.println("  Worst Case: "+nin.worstCase(i));
		System.out.println("");
		
		AVLTree ten = new AVLTree(2976);
		int[] j = ten.testTree();
		System.out.println("10.Best Case: "+ten.bestCase(j));
		System.out.println("  Average Case: "+ten.aveCase(j));
		System.out.println("  Worst Case: "+ten.worstCase(j));
	}
}