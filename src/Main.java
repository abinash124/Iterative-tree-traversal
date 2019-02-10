import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


//Iterative way for tree traversals
//In order
//Pre order
//Post order

public
class Main {

    public static
    ArrayList<Integer> inOrderTraversal(TreeNode root){;

        ArrayList<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();


        if(root == null){
            return inOrder;
        }

        while(root!=null || !nodes.isEmpty()){
            while(root != null){
                nodes.push(root);
                root = root.left;
            }

            //retrieve top node and store its right child
            root = nodes.pop();
            //Store in linked list
            inOrder.add(root.val);

            //go to right child
            root = root.right;
        }

        return inOrder;

    }


    public static
    ArrayList<Integer> preOrderTraversal(TreeNode root){
        ArrayList<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();

        if(root == null){
            return preOrder;
        }

        nodes.push(root);
        while(!nodes.isEmpty()){
            root = nodes.pop();
            preOrder.add(root.val);

            if(root.left!=null){
                nodes.push(root.left);
            }

            if (root.right != null){
                nodes.push(root.right);
            }


        }

        return preOrder;
    }


    public static
    ArrayList<Integer> postOrderTraversal(TreeNode root){
        ArrayList<Integer> postOrder = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        if(root == null){
            return postOrder;
        }

        s1.push(root);


        while(!s1.isEmpty()){
            TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left!=null){
                s1.push(temp.left);
            }

            if (temp.right != null){
                s1.push(temp.right);
            }

        }


        while(!s2.isEmpty()){
            postOrder.add(s2.pop().val);

        }


        return postOrder;

    }



    public static
    void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> inOrder, preOrder, postOrder;
        preOrder = preOrderTraversal(root);
        postOrder = postOrderTraversal(root);
        inOrder = inOrderTraversal(root);
        System.out.println("Pre-order: "+preOrder);
        System.out.println("In-order: "+inOrder);
        System.out.println("Post-order: "+postOrder);

        postOrderTraversal(root);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }
}
