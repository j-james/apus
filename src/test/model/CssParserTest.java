package model;

import model.css.CssParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CssParserTest {

    @Test
    void testIdiomaticCss() {
        var idiomaticCss = "body {    background-color: #f0f0f2;    margin: 0;  padding: 0;    font-family: -apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\",    \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;}div {    width: 600px;    margin: 5em auto;    padding: 2em;    background-color: #fdfdff;    border-radius: 0.5em;    box-shadow: 2px 3px 7px 2px rgba(0,0,0,0.02);}a:link, a:visited {    color: #38488f;    text-decoration: none;}@media (max - width : 700px) {    div {        margin: 0 auto;        width: auto;    }}";
        CssParser parser = new CssParser();
        System.out.println(parser.parseCSS(idiomaticCss));
    }
}
