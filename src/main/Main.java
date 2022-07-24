package main;

public class Main {

	public static void main(String[] args) {

		final String URL = args[0];

		Crawler crawler = new Crawler();
		Node node = crawler.crawl(URL, Integer.valueOf(args[1]));

		if (null != node) {
			node.print();
		}
	}
}
