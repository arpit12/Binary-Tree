Binary-Tree
===========
A binary tree is made of nodes, where each node contains a "left" pointer, a "right" pointer, and a data element.
The "root" pointer points to the topmost node in the tree. The left and right pointers recursively point 
to smaller "subtrees" on either side. A null pointer represents a binary tree with no elements -- the empty tree.
The formal recursive definition is: a binary tree is either empty (represented by a null pointer), or is 
made of a single node, where the left and right pointers (recursive definition ahead) each point to a binary tree. 
 
 
 

A "binary search tree" (BST) or "ordered binary tree" is a type of binary tree where the nodes are arranged 
in order: for each node, all elements in its left subtree are less-or-equal to the node (<=), and all the elements 
in its right subtree are greater than the node (>). The tree shown above is a binary search tree -- the "root" node 
is a 5, and its left subtree nodes (1, 3, 4) are <= 5, and its right subtree nodes (6, 9) are > 5. Recursively, each 
of the subtrees must also obey the binary search tree constraint: in the (1, 3, 4) subtree, the 3 is the root, the 
1 <= 3 and 4 > 3. Watch out for the exact wording in the problems -- a "binary search tree" is different from a 
"binary tree".

The nodes at the bottom edge of the tree have empty subtrees and are called "leaf" nodes (1, 4, 6) while the
others are "internal" nodes (3, 5, 9).
 
