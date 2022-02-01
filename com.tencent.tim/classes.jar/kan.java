import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.smtt.sdk.WebView;

public class kan
  implements DialogInterface.OnClickListener
{
  public kan(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0.mRuntime.getWebView();
    if (paramDialogInterface == null) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        paramDialogInterface.loadUrl("javascript:" + this.VB);
        return;
      }
    } while (paramInt != 1);
    paramDialogInterface.loadUrl("javascript:" + this.VC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kan
 * JD-Core Version:    0.7.0.1
 */