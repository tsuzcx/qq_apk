import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebViewClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.voip.VoipGoogleWalletPayActivity;
import com.tencent.mobileqq.activity.voip.VoipTencentPayActivity;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dhg
  extends CustomWebViewClient
{
  public dhg(QQBrowserActivity paramQQBrowserActivity, WebViewPluginEngine paramWebViewPluginEngine)
  {
    super(paramWebViewPluginEngine);
  }
  
  private void a(WebView paramWebView)
  {
    if (QQBrowserActivity.c(this.a))
    {
      b(paramWebView);
      return;
    }
    boolean bool = paramWebView.canGoBack();
    this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(bool);
    this.a.c.setEnabled(paramWebView.canGoForward());
  }
  
  private void b(WebView paramWebView)
  {
    this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.a.c.setEnabled(false);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (paramWebView == this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView)
    {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      if (!QQBrowserActivity.b(this.a)) {
        this.a.e.setEnabled(true);
      }
      a(paramWebView);
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowser", 2, "onPageFinished() url = " + paramString);
    }
    this.a.b(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    String str;
    if (QQBrowserActivity.a(this.a))
    {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramBitmap = null;
      if (!TextUtils.isEmpty(paramString)) {
        paramBitmap = Uri.parse(paramString);
      }
      if ((!paramString.startsWith("http://mp.imqq.com/user/charge")) || (!TextUtils.isEmpty(paramBitmap.getQueryParameter("wallet")))) {
        break label228;
      }
      str = paramString + "&wallet=google";
      paramWebView.loadUrl(str);
    }
    for (;;)
    {
      if ((paramBitmap != null) && (("gamecenter.qq.com".equals(paramBitmap.getHost())) || ((paramBitmap.isHierarchical()) && ("simple".equals(paramBitmap.getQueryParameter("style"))))))
      {
        this.a.a(false);
        QQBrowserActivity.c(this.a).setVisibility(8);
        this.a.k = true;
      }
      b(paramWebView);
      this.a.jdField_b_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("QQBrowser", 2, "onPageStarted() url = " + str);
      }
      this.a.a(paramWebView, str);
      return;
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break;
      label228:
      str = paramString;
      if (paramBitmap != null)
      {
        str = paramString;
        if (paramString.startsWith("http://mp.imqq.com/user"))
        {
          str = paramString;
          if (TextUtils.isEmpty(paramBitmap.getQueryParameter("lan")))
          {
            paramWebView.loadUrl(paramString);
            str = paramString;
          }
        }
      }
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.a(paramWebView, paramInt, paramString1, paramString2);
    a(paramWebView);
    this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.e("QQBrowser", 2, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + paramString2);
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject2 = paramString;
    Object localObject1;
    if (paramString != null) {
      if (!paramString.startsWith("http://"))
      {
        localObject2 = paramString;
        if (!paramString.startsWith("https://")) {}
      }
      else
      {
        localObject1 = "en";
      }
    }
    String str;
    switch (LocaleUtil.a(BaseApplicationImpl.getContext()))
    {
    default: 
      if (paramString.matches("^[^#]*\\?.*(#.*)?"))
      {
        str = "&";
        label97:
        Object localObject3 = Pattern.compile("(#.*)?$").matcher(paramString);
        localObject2 = paramString;
        if (((Matcher)localObject3).find())
        {
          localObject3 = ((Matcher)localObject3).group(1);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject2 = paramString.replaceAll("(#.*)?$", str + "lan=" + (String)localObject1 + (String)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQBrowser", 2, "shouldOverrideUrlLoading " + (String)localObject2);
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (this.a.I.startsWith("http://mp.imqq.com/"))
        {
          if (((String)localObject2).startsWith("qqipay://googlewallet"))
          {
            paramWebView = Uri.parse((String)localObject2);
            paramString = new Intent(this.a, VoipGoogleWalletPayActivity.class);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("productid", paramWebView.getQueryParameter("productid"));
            ((Bundle)localObject1).putString("price", paramWebView.getQueryParameter("price"));
            paramString.putExtra("VoipGooglePayActivityParam", (Bundle)localObject1);
            this.a.startActivity(paramString);
            return true;
            localObject1 = "en";
            break;
            localObject1 = "ja";
            break;
            localObject1 = "ko";
            break;
            localObject1 = "de";
            break;
            localObject1 = "fr";
            break;
            localObject1 = "es";
            break;
            localObject1 = "tw";
            break;
            localObject1 = "cn";
            break;
            str = "?";
            break label97;
          }
          if (((String)localObject2).startsWith("qqipay://tencentpay"))
          {
            paramWebView = Uri.parse((String)localObject2);
            paramString = new Intent(this.a, VoipTencentPayActivity.class);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("payItem", paramWebView.getQueryParameter("payItem"));
            ((Bundle)localObject1).putString("goodsmeta", paramWebView.getQueryParameter("goodsmeta"));
            ((Bundle)localObject1).putString("goodsurl", paramWebView.getQueryParameter("goodsurl"));
            paramString.putExtra("VoipTencentPayActivityParam", (Bundle)localObject1);
            this.a.startActivity(paramString);
            return true;
          }
        }
      }
      catch (RuntimeException paramWebView)
      {
        paramString = paramWebView.toString();
        localObject1 = paramWebView.getStackTrace();
        paramWebView = paramString;
        if (localObject1.length > 0) {
          paramWebView = paramString + " at " + localObject1[0].toString();
        }
        Toast.makeText(BaseApplicationImpl.getContext(), paramWebView, 1).show();
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        return false;
      }
      if ((!super.shouldOverrideUrlLoading(paramWebView, (String)localObject2)) && (!this.a.a(paramWebView, (String)localObject2)))
      {
        b(paramWebView);
        if ((((String)localObject2).startsWith("file://")) || (((String)localObject2).startsWith("data:")) || (((String)localObject2).startsWith("http://")) || (((String)localObject2).startsWith("https://")))
        {
          QQBrowserActivity.a(this.a);
          if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://"))) {
            break label759;
          }
          this.a.I = ((String)localObject2);
          break label759;
        }
        paramString = Uri.parse((String)localObject2);
        localObject1 = paramString.getScheme();
        if ((System.currentTimeMillis() - this.a.d < 1000L) || (this.a.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), (String)localObject1).booleanValue()))
        {
          paramWebView = new Intent("android.intent.action.VIEW", paramString);
          paramWebView.addFlags(268435456);
          try
          {
            QQBrowserActivity.a(this.a, paramWebView);
            return true;
          }
          catch (ActivityNotFoundException paramWebView) {}
        }
      }
    }
    label759:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhg
 * JD-Core Version:    0.7.0.1
 */