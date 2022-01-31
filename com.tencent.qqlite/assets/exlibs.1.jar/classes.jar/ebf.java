import com.tencent.mobileqq.richstatus.ActionUrlActivity;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class ebf
  extends WebChromeClient
{
  private ebf(ActionUrlActivity paramActionUrlActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.setTitle(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebf
 * JD-Core Version:    0.7.0.1
 */