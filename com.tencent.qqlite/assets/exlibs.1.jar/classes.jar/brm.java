import android.graphics.Bitmap;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.jsbridge.JsBridge;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class brm
  extends WebViewClient
{
  private brm(UpgradeDetailActivity paramUpgradeDetailActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "onPageFinished: " + paramString);
    }
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "onPageStarted: " + paramString);
    }
    if (this.a.a(paramString)) {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentSmttSdkWebView.stopLoading();
      return;
    }
    catch (Exception paramWebView) {}
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    return;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.a(true);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeDetailActivity", 2, "shouldOverrideUrlLoading: " + paramString);
    }
    if ((paramString == null) || ("".equals(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {}
    for (;;)
    {
      return true;
      if ((!UpgradeDetailActivity.a(this.a).a(paramWebView, paramString)) && (!this.a.a(paramString))) {
        this.a.a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     brm
 * JD-Core Version:    0.7.0.1
 */