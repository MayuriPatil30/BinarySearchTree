package com.bridgelabz;

public class BinarySearchTree {
    INode root;
    BinarySearchTree() {
        root = null;
    }
    static class INode {
        int item;
        INode left, right;
        public INode(int key) {
            item = key;
            left = right = null;
        }
    }
    public void insert(INode node, int value) {
        if (value < node.item) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.item);
                node.left = new INode(value);
            }
        } else if (value > node.item) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.item);
                node.right = new INode(value);
            }
        }
    }
    public void traverseInOrder(INode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.item);
            traverseInOrder(node.right);
        }
    }

    public static void search(INode root, int key){
        INode node = root;
        INode parent = null;
        while (node != null && node.item != key){
            parent = node;
            if (key < node.item){
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        if (node == null){
            System.out.println("key is not found!");
            return;
        }
        if (parent == null){
            System.out.println("The node with key" + key + "is root node");
        }else if(key < parent.item){
            System.out.println(+ key + " is in the left side of the tree ");
        }else{
            System.out.println(+ key + " is in the right side of the tree ");
        }
    }

    public static void main(String[] args) {
            //create object of tree
            BinarySearchTree tree = new BinarySearchTree();
            //create nodes of the tree
        System.out.println("Binary tree :");
        System.out.println("....................................");
        INode root = new INode(56);
        tree.insert(root, 30);
        tree.insert(root, 70);
        tree.insert(root, 22);
        tree.insert(root, 40);
        tree.insert(root, 11);
        tree.insert(root, 3);
        tree.insert(root, 16);
        tree.insert(root, 70);
        tree.insert(root, 60);
        tree.insert(root, 95);
        tree.insert(root, 65);
        tree.insert(root, 63);
        tree.insert(root, 67);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(tree.root);
        System.out.println("........................................");
        System.out.println("Searching key in tree :");
        search(root, 63);
        }
    } 