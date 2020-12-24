package ne;

class BinaryTree  
{ 
    Node root; 
    
   
    void printkdistanceNodeDown(Node node, int k)  
    { 
        // Base Case 
        if (node == null || k < 0) 
            return; 
   
        if (k == 0)  
        { 
            System.out.print(node.data); 
            System.out.println(""); 
            return; 
        } 
   
        printkdistanceNodeDown(node.left, k - 1); 
        printkdistanceNodeDown(node.right, k - 1); 
    } 
   
   
    int printkdistanceNode(Node node, Node target, int k)  
    { 
        
        if (node == null) 
            return -1; 
   
       
        if (node == target)  
        { 
            printkdistanceNodeDown(node, k); 
            return 0; 
        } 
   
   
        int dl = printkdistanceNode(node.left, target, k); 
   
        if (dl != -1)  
        { 
          
     
            if (dl + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            } 
               
            // Else go to right subtree and print all k-dl-2 distant nodes 
            // Note that the right child is 2 edges away from left child 
            else
                printkdistanceNodeDown(node.right, k - dl - 2); 
   
            // Add 1 to the distance and return value for parent calls 
            return 1 + dl; 
        } 
   
        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE 
        // Note that we reach here only when node was not found in left  
        // subtree 
        int dr = printkdistanceNode(node.right, target, k); 
        if (dr != -1)  
        { 
            if (dr + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }  
            else 
                printkdistanceNodeDown(node.left, k - dr - 2); 
            return 1 + dr; 
        } 
   
        // If target was neither present in left nor in right subtree 
        return -1; 
    } 
   
    // Driver program to test the above functions 
    public static void main(String args[])  
    { 
        BinaryTree tree = new BinaryTree(); 
   
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        Node target = tree.root.left.right; 
        tree.printkdistanceNode(tree.root, target, 2); 
    } 
} 