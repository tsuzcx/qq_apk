import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.StringAddition;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class hpk
  extends WebChromeClient
{
  public hpk(WebAppActivity paramWebAppActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (this.a.o == 1) {
      this.a.b.setProgress(paramInt);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    WebAppActivity.a(this.a).setText(StringAddition.a(paramString, 16, true, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hpk
 * JD-Core Version:    0.7.0.1
 */