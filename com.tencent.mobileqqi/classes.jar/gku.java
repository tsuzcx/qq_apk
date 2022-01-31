import com.tencent.mobileqq.richstatus.ActionUrlActivity;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class gku
  extends WebChromeClient
{
  private gku(ActionUrlActivity paramActionUrlActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    this.a.setTitle(paramString);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gku
 * JD-Core Version:    0.7.0.1
 */