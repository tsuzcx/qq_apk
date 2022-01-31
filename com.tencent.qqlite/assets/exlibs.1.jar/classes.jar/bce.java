import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity.NativeChromeClient;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class bce
  extends CustomWebViewClient
{
  public bce(QQBrowserActivity paramQQBrowserActivity, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
  }
  
  private void a(WebView paramWebView)
  {
    if (QQBrowserActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity))
    {
      b(paramWebView);
      return;
    }
    boolean bool = paramWebView.canGoBack();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_b_of_type_AndroidWidgetImageView.setEnabled(bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_c_of_type_AndroidWidgetImageView.setEnabled(paramWebView.canGoForward());
  }
  
  private void b(WebView paramWebView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    String str1;
    Object localObject;
    int k;
    String str2;
    StringBuilder localStringBuilder;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.n) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.k))
    {
      str1 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
        str1 = "use bid " + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
      }
      k = (int)(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d);
      localObject = NetworkUtil.b(paramWebView.getContext()) + "";
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.V;
      localStringBuilder = new StringBuilder().append("");
      if (!QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label438;
      }
      i = 1;
      if (!QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label443;
      }
    }
    label438:
    label443:
    for (int j = 1;; j = 0)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url", 0, 1, k, (String)localObject, str2, str1, j + (i << 1));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.n = false;
      super.onPageFinished(paramWebView, paramString);
      if (paramWebView == this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizPubaccountCustomWebView)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
        if (!QQBrowserActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
        }
        a(paramWebView);
      }
      if ((QQBrowserActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) && (!QQBrowserActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)))
      {
        QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, true);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, Util.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.K, new String[0]), "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b(paramWebView, paramString);
      if ((Build.VERSION.SDK_INT >= 19) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.k))
      {
        paramString = paramWebView.getTitle();
        QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).onReceivedTitle(paramWebView, paramString);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    int i;
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.l) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.m) && (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.k))
    {
      String str1 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
        str1 = "use bid " + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d = System.currentTimeMillis();
      int k = (int)(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_c_of_type_Long);
      Object localObject = NetworkUtil.b(paramWebView.getContext()) + "";
      String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.V;
      StringBuilder localStringBuilder = new StringBuilder().append("");
      if (QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity))
      {
        i = 1;
        if (!QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
          break label405;
        }
        j = 1;
        label231:
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_load_url", 0, 1, k, (String)localObject, str2, str1, j + (i << 1));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.m = false;
      }
    }
    else
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (!QQBrowserActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label411;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    for (;;)
    {
      paramBitmap = null;
      if (!TextUtils.isEmpty(paramString)) {
        paramBitmap = Uri.parse(paramString);
      }
      if ((paramBitmap != null) && (paramBitmap.isHierarchical()) && ("simple".equals(paramBitmap.getQueryParameter("style"))))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(false);
        QQBrowserActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.j = true;
      }
      b(paramWebView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramWebView, paramString);
      return;
      i = 0;
      break;
      label405:
      j = 0;
      break label231;
      label411:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramWebView, paramInt, paramString1, paramString2);
    a(paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.e("QQBrowser", 2, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + Util.b(paramString2, new String[0]));
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    int j;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.l)
    {
      paramString1 = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null))
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(OfflinePlugin.class);
        if ((paramString2 != null) && ((paramString2 instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)paramString2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
        paramString1 = "use bid " + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a();
      }
      j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.d);
      paramWebView = NetworkUtil.b(paramWebView.getContext()) + "";
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.V;
      localStringBuilder = new StringBuilder().append("");
      if (!QQBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label329;
      }
      paramInt = 1;
      if (!QQBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)) {
        break label334;
      }
    }
    label329:
    label334:
    for (int i = 1;; i = 0)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url_error", 0, 1, j, paramWebView, paramString2, paramString1, i + (paramInt << 1));
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "shouldOverrideUrlLoading " + Util.b(paramString, new String[0]));
    }
    if (("".equals(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {
      return true;
    }
    for (;;)
    {
      try
      {
        if ((super.shouldOverrideUrlLoading(paramWebView, paramString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a(paramWebView, paramString))) {
          break;
        }
        b(paramWebView);
        if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
          if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.K = paramString;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine == null) {
            break label429;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.K, 14, null)) {
            break;
          }
          break label429;
        }
        localObject = Uri.parse(paramString);
        String str = ((Uri)localObject).getScheme();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isResume()) && ((System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_e_of_type_Long < 1000L) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), str).booleanValue())))
        {
          paramWebView = new Intent("android.intent.action.VIEW", (Uri)localObject);
          paramWebView.addFlags(268435456);
          if (!paramString.startsWith("mqqapi://tenpay/pay?")) {
            continue;
          }
          paramWebView.putExtra("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
          try
          {
            QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, paramWebView);
            return true;
          }
          catch (ActivityNotFoundException paramWebView) {}
        }
      }
      catch (RuntimeException paramWebView)
      {
        paramString = paramWebView.toString();
        Object localObject = paramWebView.getStackTrace();
        paramWebView = paramString;
        if (localObject.length <= 0) {
          continue;
        }
        paramWebView = paramString + " at " + localObject[0].toString();
        Toast.makeText(BaseApplicationImpl.getContext(), paramWebView, 1).show();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        continue;
      }
      return false;
      if (paramString.startsWith("mqqwpa://im")) {
        paramWebView.putExtra("from", "webview");
      }
    }
    label429:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bce
 * JD-Core Version:    0.7.0.1
 */