package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {

	public Node crawl(String url, int maxDepth) {
		List<String> visited = new ArrayList<>();
		Node result = search(url, maxDepth, 0, visited);
		return result;
	}

	private Node search(String url, int maxDepth, int currentDepth, List<String> visited) {

		try {
			Connection connection = Jsoup.connect(url);

			Node node = new Node(url);
			node.setDepth(currentDepth);
			List<Node> childLinks = new ArrayList<>();

			Document doc = connection.get();
			
			node.setTitle(doc.title());
			
			if (connection.response().statusCode() == 200 && currentDepth < maxDepth) {

				doc.select("a[href]").forEach(child -> {

					String nextLink = child.attr("abs:href");

					if (!visited.contains(nextLink)) {
						visited.add(nextLink);
						childLinks.add(search(nextLink, maxDepth, currentDepth + 1, visited));
					}
				});

			}
			node.setReachables(childLinks);
			return node;

		} catch (IOException e) {
			System.out.println("Error occured : " + e.getLocalizedMessage());
			return null;
		}
	}
}
