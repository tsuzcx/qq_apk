import android.graphics.Bitmap;
import android.net.Uri;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class aoce
  extends aocc.b
{
  aoce(aocc paramaocc)
  {
    super(paramaocc);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return doInterceptRequest(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoce
 * JD-Core Version:    0.7.0.1
 */