package model;

import model.html.ElementNode;
import model.html.HtmlParser;
import model.util.Node;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HtmlParserTest {

    String idiomaticHtml = "<!DOCTYPE html><html><head></head><body><p>Hello,  world!</p></body></html>";
    String brokenHtml = "<html><foo><bar></bar><ba";
    String trailingTextHtml = "<html><foo><bar></bar>ba";

    @Test
    void testIdiomaticHtml() {
        String[] idiomaticHtmlArray = {"<!DOCTYPE html>","<html>","<head>","</head>","<body>","<p>","Hello,world!","</p>","</body>","</html>"};
        HtmlParser parser = new HtmlParser();
        displayHtmlTree(parser.parseHtml(idiomaticHtml));
//        assertEquals(HtmlParser.parseHtmlLL(idiomaticHtml), Arrays.asList(idiomaticHtmlArray));
    }

    @Test
    void testBrokenHtml() {
        String[] brokenHtmlArray = {"<html>","<foo>","<bar>","</bar>","<ba>"};
        HtmlParser parser = new HtmlParser();
        displayHtmlTree(parser.parseHtml(brokenHtml));
//        assertEquals(HtmlParser.parseHtmlLL(brokenHtml), Arrays.asList(brokenHtmlArray));
    }

    @Test
    void testTrailingTextHtml() {
        String[] trailingTextHtmlArray = {"<html>","<foo>","<bar>","</bar>","ba"};
        HtmlParser parser = new HtmlParser();
        displayHtmlTree(parser.parseHtml(trailingTextHtml));
//        assertEquals(HtmlParser.parseHtmlLL(trailingTextHtml), Arrays.asList(trailingTextHtmlArray));
    }

    /**
     * Simple helper function for debugging.
     * EFFECTS: prints a representation of the tree to the console for debugging purposes
     */
    private void displayHtmlTree(ArrayList<Node> tree) {
        for (Node node : tree) {
            if (node instanceof ElementNode) {
                System.out.print(((ElementNode) node).getTag() + ": ");
                for (Node n : ((ElementNode) node).getChildren()) {
                    System.out.print(n.getData() + " ");
                }
                System.out.println();
                displayHtmlTree(((ElementNode) node).getChildren());
            } else {
                System.out.println("Text: " + node.getData());
            }
        }
    }
}
