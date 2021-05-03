package application;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;


public class EmbeddedWebView extends StackPane{
	
	final private WebView webView;


    private String url;

    public EmbeddedWebView() {
        webView = new WebView();
        getChildren().add(webView);
    }




    public String getUrl() {
        return url;
    }

    /**
     * Loads content into the WebView from a given url.
     * The allowed url types are http, https and file.
     *
     * Additionally, content can be loaded from a classpath resource.
     * To be loaded from the classpath, the url must start with a / character
     * and specify the full resource path to the html
     * (i.e., relative resource path specifiers are not allowed).
     *
     * @param url the location of the html document to be loaded.
     */
    public void setUrl(String url) {
        if ( url == null || ! (url.startsWith("/") || url.startsWith("http:") || url.startsWith("https:") || url.startsWith("file:"))) {
            throw new IllegalArgumentException("url must start with one of http: file: https: or /");
        }

        this.url = url;

        if (url.startsWith("/")) {
            webView.getEngine().load(
                    EmbeddedWebView.class.getResource(url).toExternalForm()
            );
        } else {
            webView.getEngine().load(
                    url
            );
        }
    }

}
