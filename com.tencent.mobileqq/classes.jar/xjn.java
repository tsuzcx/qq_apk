import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

public class xjn
  extends xjr
{
  public xjn(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    super(paramAbsBaseWebViewActivity, null);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */