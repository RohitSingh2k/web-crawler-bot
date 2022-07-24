package main;

import java.util.List;

public class Node {

	private String value;
	private int depth;
	private String title;
	List<Node> reachables;

	// Parameterized constructor.
	Node(String name) {
		this.value = name;
	}

	/* Getters and Setters goes here */

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public List<Node> getReachables() {
		return reachables;
	}

	public void setReachables(List<Node> reachables) {
		this.reachables = reachables;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", depth=" + depth + ",\n title=" + title + "]";
	}

	public void print() {
		recursivePrint(this);
	}

	private void recursivePrint(Node node) {
		System.out.println(node);
		node.getReachables().forEach((child) -> {
			recursivePrint(child);
		});
	}
}
