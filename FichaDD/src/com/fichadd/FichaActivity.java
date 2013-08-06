package com.fichadd;



import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
 
public class FichaActivity extends Activity {

	protected FrameLayout webViewPlaceholder;
	protected WebView webView;
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_ficha);
	    
	    // Initialize the UI
	    initUI();
	  }
	  protected void initUI()
	  {
		
	    // Retrieve UI elements
	    webViewPlaceholder = ((FrameLayout)findViewById(R.id.webViewPlaceholder));
	    
	    // Initialize the WebView if necessary
	    if (webView == null)
	    {
	      // Create the webview
	    	
	      webView = new WebView(this);
	      webView.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		  Log.i("DEBUG","Aqui2");
		  webView.getSettings().setSupportZoom(true);
		  webView.getSettings().setBuiltInZoomControls(true);
		  webView.setScrollbarFadingEnabled(true);
		  webView.getSettings().setLoadsImagesAutomatically(true);
	      
	      
	      
	      // Load the URLs inside the WebView, not in the external web browser
	      webView.setWebViewClient(new ClientWeb());
	      webView.getSettings().setJavaScriptEnabled(true);
	 
	      // Load a page
	      webView.loadUrl("http://www.fichadd.site90.com");
	    }
	 
	    // Attach the WebView to its placeholder
	    webViewPlaceholder.addView(webView);
	  }
	
	@Override
	  protected void onSaveInstanceState(Bundle outState)
	  {
	    super.onSaveInstanceState(outState);
	 
	    // Save the state of the WebView
	    webView.saveState(outState);
	  }
	   
	  @Override
	  protected void onRestoreInstanceState(Bundle savedInstanceState)
	  {
	    super.onRestoreInstanceState(savedInstanceState);
	 
	    // Restore the state of the WebView
	    webView.restoreState(savedInstanceState);
	  }
	
	public class ClientWeb extends WebViewClient{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
		
	}
	 @Override
	  public void onConfigurationChanged(Configuration newConfig)
	  {
	    if (webView != null)
	    {
	      // Remove the WebView from the old placeholder
	      webViewPlaceholder.removeView(webView);
	    }
	 
	    super.onConfigurationChanged(newConfig);
	     
	    // Load the layout resource for the new configuration
	    setContentView(R.layout.activity_ficha);
	 
	    // Reinitialize the UI
	    initUI();
	  }
	 
}