import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class tlc
  extends WebViewClient
{
  public tlc(PreloadWebService paramPreloadWebService) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tlc
 * JD-Core Version:    0.7.0.1
 */