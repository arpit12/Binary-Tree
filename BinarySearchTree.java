// aarppit make program more better..

public class BinarySearchTree {
 
    /**
     * Root node of the binary search tree.
     */
    private Node root;
 
    /**
     * Internal static class for storing the nodes.
     */
    private static class Node {
    	Node parent;
        Node left;
        Node right;
        int data;
 
        Node( int data ) {
            this.data = data;
        }
 
        
        public String toString( ) {  // no use of this method in this program 
            return "" + data;
        }
    }
 
    /**
     * Inserts a new node that has the specified data. The insert starts from
     * the root of the tree and goes all the way down until it finds a spot to
     * place the new node.
     */
    public void insert( int data ) {
        root = insert( root, data );
    }
 
    /**
     * Inserts a new node that has the specified data. The insert starts from
     * the specified node of the tree and goes all the way down until it finds 
     * a spot to place the new node.
     */
    public Node insert( Node node, int data ) {
        if( node == null ) {
            // Found a spot to insert new node.
            node = new Node( data );
        } else if( data < node.data ) {
            // Insert in left subtree
            node.left = insert( node.left, data );
            node.left.parent = node;
        } else {
            // Insert right subtree.
            node.right = insert( node.right, data );
            node.right.parent = node;
        }
        // Done!
        return node;
    }
 
    /**
     * Helper method for the binary search tree delete operation. It used for
     * swapping the nodes, while keeping the structure of the binary search tree.
     * Refer to page 296 of Introduction to Algorithms (3rd Edition) by Cormen 
     * et. al. for further details.
     */
    private void swap( Node a, Node b ) {
 
    	if( a.parent == null ) {
    		root = b;
    	} else if( a == a.parent.left ) {
    		a.parent.left = b;
    	} else {
    		a.parent.right = b;
    	}
 
    	if( b != null ) {
    		b.parent = a.parent;
    	}
    }
 
    /**
     * Deletes the node containing the specified data. The search for the node
     * to be deleted starts from the root node.
     */
    public void delete( int data ) {
        delete( root, data );
    }
 
    /**
     * Deletes the node containing the specified data. The search for the node
     * to be deleted starts from the specified node. Refer to page 298 of
     * Introduction to Algorithms (3rd Edition) by Cormen et. al. for further
     * details.
     */
    public void delete( Node node, int data ) {
		// Can't find the node we want to delete.
    	if( node == null ) {
    		return;
    	}
    	// We've found the node we want to delete.
    	else if ( data == node.data) {
    		// Check if it has a left subtree. If it deson't then just replace
    		// the node we want to delete with its right subtree.
            if( node.left == null ) {
                swap( node, node.right ); 
            } 
            // Check if it has a right subtree. If it doesn't then just replace
            // the node we want to delete with its left subtree.
            else if( node.right == null ) {
                swap( node, node.left );
            } 
            // Since it has both a left and right subtree, then traverse to the
            // left-most child of the right subtree (i.e. the smallest node in the
            // right subtree). Once found, exchange the data values between the node
            // and the node that we want to delete.
            else {
                Node minNode = node.right;
 
                while( minNode.left != null ) {
                    minNode = minNode.left;
                }
 
                if( minNode.parent != node ) {
                	swap( minNode, minNode.right );
                	minNode.right = node.right;
                	minNode.right.parent = minNode;
                }
 
                swap( node, minNode );
                minNode.left = node.left;
                minNode.left.parent = minNode;
            }
        } 
    	// Continue searching in the left subtree.
    	else if( data < node.data) {
            delete( node.left, data );
        } 
    	// Continue searching in the right subtree.
    	else {
            delete( node.right, data );
        }
    }
 
    /** 
     * Returns a boolean true if it finds the specified data in the tree, or false
     * otherwise. The search starts from the root node of the tree.
     */
    public boolean lookup( int data ) {
        return lookup( root, data );
    }
 
    /** 
     * Returns a boolean true if it finds the specified data in the tree, or false
     * otherwise. The search starts from the specified node of the tree. Thus, you
     * can either search the whole tree or a subtree.
     */
    public boolean lookup( Node node, int data ) {
        if( node == null ) {
            // Can't find it.
            return false;
        } else if( data == node.data) {
            // Found it.
            return true;
        } else if( data < node.data) {
            // Search left subtree.
            return lookup( node.left, data );
        } else {
            // Search right subtree.
            return lookup( node.right, data );
        }
    }
 
 
		 public int countLeaves() 
		 {
			return countLeaves(root);
		 }

 
 
	 public int countLeaves(Node node) {
             // Return the number of leaves in the tree to which node points.
          if (node == null)
             return 0;
          else if (node.left == null && node.right == null)
             return 1;  // Node is a leaf.
          else
             return countLeaves(node.left) + countLeaves(node.right);
      } 
 
 
 
 
 
    /**
     * Returns the size of the tree via an in-order traversal, starting from 
     * the root node.
     */
    public int size( ) {
        return size( root );
    }
 
    /**
     * Returns the size of the tree via an in-order traversal, starting from 
     * the specified node.
     */
    public int size( Node node ) {
        if( node == null ) {
            // We've reached the bottom.
            return 0;
        }
 
        int leftSize = size( node.left );
        int rightSize = size( node.right );
  
        // Add 1 to account for the size of the current node.
        return leftSize +rightSize+ 1;
    }
 
    /**
     * Returns the max root-to-leaf depth of the tree.
     */
    public int maxDepth( ) {
        return maxDepth( root );
    }
 
    /**
     * Returns the max node-to-leaf depth of the tree.
     */
    public int maxDepth( Node node ) {
        if( node == null ) {
            // We've reached the bottom.
            return 0;
        }
 
        int leftDepth = maxDepth( node.left );
        int rightDepth = maxDepth( node.right );
 
        // Add 1 to the largest depth, to account for the depth of the current node.
        return leftDepth < rightDepth ? rightDepth + 1 : leftDepth + 1;
    }
 
    /**
     * Returns the min value starting from the root node.
     */
    public int minValue( ) {
        return minValue( root );
    }
 
    /**
     * Returns the min value starting from the specified node.
     */
    public int minValue( Node node ) {
        // Traverse to the left-most child, as it has the min value.
        Node cursor = node;
        while( cursor.left != null ) {
            cursor = cursor.left;
        }
        // Return the value of the left-most child.
        return cursor.data;
    }
 
    /**
     * Returns the max value starting from the root node.
     */
    public int maxValue( ) {
        return maxValue( root );
    }
 
    /**
     * Returns the max value starting from the specified node.
     */
    public int maxValue( Node node ) {
        // Traverse to the right-most child, as it has the max value.
        Node cursor = node;
        while( cursor.right != null ) {
            cursor = cursor.right;
        }
        // Return the value of the right-most child.
        return cursor.data;
    }
 
    /**
     * Traverses the tree in a pre-order approach, starting from the root node.
     */
    public void preorderTraversal( ) {
        preorderTraversal( root );
    }
 
    /**
     * Traverses the tree in a pre-order approach, starting from the specified node.
     */
    public void preorderTraversal( Node node ) {
        if( node != null ) {
            System.out.print( node.data + " " );
            preorderTraversal( node.left );
            preorderTraversal( node.right );            
        }
    }
 
    /**
     * Traverses the tree in a in-order approach, starting from the root node.
     */
    public void inorderTraversal( ) {
        inorderTraversal( root );
    }
 
    /**
     * Traverses the tree in a in-order approach, starting from the specified node.
     */
    private void inorderTraversal( Node node ) {
        if( node != null ) {
            inorderTraversal( node.left );
            System.out.print( node.data + " " );
            inorderTraversal( node.right );
        }
    }
 
    /**
     * Traverses the tree in a post-order approach, starting from the root node.
     */
    public void postorderTraversal( ) {
        postorderTraversal( root );
    }
 
    /**
     * Traverses the tree in a post-order approach, starting from the specified node.
     */     
    public void postorderTraversal( Node node ) {
        if( node != null ) {
        	postorderTraversal( node.left );
        	postorderTraversal( node.right );
            System.out.print( node.data + " " );
        }
    }
 
    /**
     * Test Method
     */
    public static void main( String[ ] args ) {
 
        BinarySearchTree bst = new BinarySearchTree( );
        int[ ] input = new int[ ] { 15,6,18,3,7,17,20,2,4,13,9 };
 
        for( int i : input ) {
            bst.insert( i );
        }
 
        System.out.println( "Preorder Traversal:" );
        bst.preorderTraversal( );
		
        System.out.println( "\nInorder Traversal:" );
        bst.inorderTraversal( );
		
		
		 System.out.println( "\n Size(Elements) of the tree is:"+bst.size() );
		 System.out.println( " Height of tree is :" +bst.maxDepth() );
		 
		 System.out.println( "Min Value in the tree is :" +bst.minValue() );
		 System.out.println( " Max Value in the tree is  :" +bst.maxValue() );

 		 System.out.println( " Lookup(node present in tree )  :" +bst.lookup(70) );
 		 System.out.println( " Lookup(node present in tree )  :" +bst.lookup(13) );
		 
		  
		 
		int leafCount = bst.countLeaves();
		System.out.println("Number of leaves:      " + leafCount);

        System.out.println( "\nPostorder Traversal:" );
        bst.postorderTraversal( );
        bst.delete( 3 );
        bst.delete( 7 );
        bst.delete( 20 );
  
        System.out.println( "\n \nPreorder Traversal:" );
        bst.preorderTraversal( );
 
        System.out.println( "\nInorder Traversal:" );
        bst.inorderTraversal( );
		
		 System.out.println( "\n Size(Elements) in the tree are :"+bst.size() );
		 System.out.println( " Height of tree is :" +bst.maxDepth() );
		 
		 
		 System.out.println( "Min Value in the tree is :" +bst.minValue() );
		 System.out.println( " Max Value in the tree is  :" +bst.maxValue() );

		
		int leafCoun = bst.countLeaves();
		System.out.println("Number of leaves:      " + leafCoun);
 
        System.out.println( "\nPostorder Traversal:" );
        bst.postorderTraversal( );
		
		
    }
}


