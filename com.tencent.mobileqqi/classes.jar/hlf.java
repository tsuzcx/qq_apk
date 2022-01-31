import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class hlf
  extends WebViewClient
{
  public hlf(WebAppActivity paramWebAppActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    LogUtility.c("WebAppActivity", "onPageFinished " + paramString);
    paramWebView.getSettings().setBlockNetworkImage(false);
    super.onPageFinished(paramWebView, paramString);
    if (this.a.o == 1)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(this.a.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack());
      this.a.b.setEnabled(this.a.jdField_a_of_type_ComTencentSmttSdkWebView.canGoForward());
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    LogUtility.c("WebAppActivity", "onPageStarted " + paramString);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView.getSettings().setBlockNetworkImage(true);
    if (this.a.o == 1)
    {
      this.a.c.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      paramString = "javascript:window.agentData = {};agentData.currentVersion='" + CommonDataAdapter.a().b() + "';" + "agentData.platform='" + CommonDataAdapter.a().g() + "';" + "agentData.uin='" + CommonDataAdapter.a().a() + "';" + "agentData.agentVersion='" + CommonDataAdapter.a().d() + "';" + "agentData.supportInterfaces=" + "['q_picUpload.picUpload']" + ";" + ";void(0);";
      LogUtility.b("opensdk", "newJs = " + paramString);
      paramWebView.loadUrl(paramString);
      return;
      this.a.c.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    LogUtility.e("WebAppActivity", "url " + paramString2 + "load fail, error=" + paramString1);
  }
  
  @TargetApi(8)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    LogUtility.c("WebAppActivity", "shouldOverrideUrlLoading " + paramString);
    try
    {
      boolean bool = this.a.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge.a(paramWebView, paramString);
      if (!bool) {
        break label45;
      }
    }
    catch (Exception localException)
    {
      label45:
      while ((paramString.equals("about:blank;")) || (paramString.equals("about:blank"))) {
        if (Build.VERSION.SDK_INT >= 11) {
          return false;
        }
      }
      if (Build.VERSION.SDK_INT <= 7) {
        break label91;
      }
      paramWebView.loadUrl(paramString, WebAppActivity.jdField_a_of_type_JavaUtilMap);
      return true;
      label91:
      paramWebView.loadUrl(paramString);
    }
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hlf
 * JD-Core Version:    0.7.0.1
 */