package src.com.esuor.binary;

public class BinaryTree {

	Node root;
	
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		setUpNode(btree);
		
		System.out.println("Nodes in Order");
		btree.getNodesInOrder(btree.root);
		
		System.out.println("\r\nPreOrder Nodes");
		btree.preOrderTree(btree.root);
		
		System.out.println("\r\nPost Order Nodes");
		btree.postOrderTree(btree.root);
		
		System.out.println("\r\nFind Nodes");
		System.out.println(btree.findNode(35));
	}
	
	private static BinaryTree setUpNode(BinaryTree btree){
	    btree.addNode(50, "Boss");
		btree.addNode(40, "Software VP");
		btree.addNode(60, "Sales VP");
		btree.addNode(35, "Software Manager");
		btree.addNode(45, "Release Manager");
		btree.addNode(55, "Sales Manager");
		btree.addNode(65, "Marketing Manager");
		return btree;
	}
	
	private Node findNode(int key) {
		Node focusNode = root;
		
		while (focusNode.key != key) {
			if (key < focusNode.key){
				focusNode = focusNode.leftChild;
			}
			else {
				focusNode = focusNode.rightChild;
			}
			
			if (focusNode == null) {
				return null;
			}
		}
		return focusNode;
	}

	public void getNodesInOrder(Node focusNode){
		if (focusNode != null){
			getNodesInOrder(focusNode.leftChild);
			System.out.println(focusNode);
			getNodesInOrder(focusNode.rightChild);
		}
	}
	
	public void preOrderTree(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrderTree(focusNode.leftChild);
			preOrderTree(focusNode.rightChild);
		}
	}
	
	public void postOrderTree(Node focusNode){
		if(focusNode != null){
			postOrderTree(focusNode.leftChild);
			postOrderTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		
		if (root == null) {
			root = newNode;
		}
		else {
			Node focusNode = root;
			Node parent;
			
			while (true){
				parent = focusNode;
				
				if(key<focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					focusNode = focusNode.rightChild;
					if (focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

}
