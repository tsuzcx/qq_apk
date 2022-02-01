import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.UpgradeTipsDialog;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class duk
  extends WebViewClient
{
  public duk(UpgradeTipsDialog paramUpgradeTipsDialog) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onPageFinished: " + paramString);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onPageStarted: " + paramString);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "onReceivedError: " + paramInt + ", " + paramString1);
    }
    ReportController.b(UpgradeTipsDialog.a(this.a), "CliOper", "", "", "Update_tips", "Upd_fail", 0, paramInt, "", "", "", "");
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {}
    while (UpgradeTipsDialog.a(this.a).a(paramWebView, paramString)) {
      return true;
    }
    this.a.a.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     duk
 * JD-Core Version:    0.7.0.1
 */