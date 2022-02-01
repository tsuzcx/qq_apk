import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;

class amnl
  extends jyk
{
  amnl(amnk paramamnk, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.b.onPageFinished(paramWebView, paramString);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    this.b.onPageStarted(paramWebView, paramString, paramBitmap);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Log.d("KDSearchResultBuilder", "shouldOverrideUrlLoading: setWebViewClient");
    if (this.b.shouldOverrideUrlLoading(paramWebView, paramString)) {
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnl
 * JD-Core Version:    0.7.0.1
 */