import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity.WebViewClientImpl.1;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.sonic.sdk.SonicSession;
import java.util.HashMap;
import java.util.Map;

public class xjr
  extends WebViewClient
{
  private ArrayMap<String, Object> a;
  
  private xjr(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  protected WebResourceResponse a(WebView paramWebView, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramString.startsWith("mqqpa://resourceid/")) {
      localObject1 = sfk.a(paramString);
    }
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      return localObject1;
      localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    } while (localWebViewPluginEngine == null);
    Object localObject2;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("https://jsbridge/"))
      {
        paramWebView = paramString.replace("https://jsbridge/", "jsbridge://");
        localObject2 = paramWebView;
        if (QLog.isColorLevel())
        {
          QLog.d("WebLog_WebViewBase", 2, "doInterceptRequest: jsapi request with http(s), url = " + paramWebView);
          localObject2 = paramWebView;
        }
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).startsWith("jsbridge:"))) {
        break label251;
      }
      this.b.b.post(new AbsBaseWebViewActivity.WebViewClientImpl.1(this, localWebViewPluginEngine, (String)localObject2));
      localObject1 = new WebResourceResponse("text/html", "utf-8", null);
      paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = new HashMap();
      }
      paramWebView.put("cache-control", "must-revalidate，no-store");
      ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
      return localObject1;
      paramWebView = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      paramWebView = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("WebLog_WebViewBase", 2, "doInterceptRequest: default request, url = " + paramString);
        localObject2 = paramString;
      }
    }
    for (;;)
    {
      try
      {
        label251:
        if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
        {
          paramWebView = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.getSession().onClientRequestResource((String)localObject2);
          if (!(paramWebView instanceof WebResourceResponse)) {
            break label402;
          }
          paramWebView = (WebResourceResponse)paramWebView;
        }
      }
      catch (Exception paramString)
      {
        label328:
        paramWebView = localObject3;
        label339:
        QLog.e("WebLog_WebViewBase", 1, "shouldInterceptRequest:resource intercept by sonic error -> " + paramString.getMessage());
        continue;
      }
      for (;;)
      {
        try
        {
          QLog.i("WebLog_WebViewBase", 1, "doInterceptRequest: resource intercept by sonic.");
          localObject1 = paramWebView;
          if (paramWebView != null) {
            break;
          }
        }
        catch (Exception paramString)
        {
          break label339;
          break label328;
        }
        try
        {
          paramString = localWebViewPluginEngine.a((String)localObject2, 8L);
          if (!(paramString instanceof WebResourceResponse)) {
            continue;
          }
          paramString = (WebResourceResponse)paramString;
          paramWebView = paramString;
          return paramWebView;
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_WebViewBase", 1, new Object[] { "shouldInterceptRequest error:!", paramString.getMessage() });
          return paramWebView;
        }
      }
      paramWebView = null;
      continue;
      label402:
      paramWebView = null;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    QLog.i("WebLog_WebViewBase", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    this.b.jdField_a_of_type_Bcfo.a(paramString, paramInt);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((!this.b.c) && (!this.b.isFinishing()))
    {
      QLog.d("WebLog_WebViewBase", 1, "onPageFinished:" + paramString);
      super.onPageFinished(paramWebView, paramString);
      this.b.b(paramWebView, paramString);
      if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.getSession().onClientPageFinished(paramString);
      }
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(paramString, 8589934594L, null);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.b.c) && (this.b.jdField_a_of_type_Nkb != null))
      {
        paramString = paramWebView.getTitle();
        this.b.jdField_a_of_type_Nkb.onReceivedTitle(paramWebView, paramString);
      }
      acsz.b(this.b.getIntent());
      return;
    }
    QLog.e("WebLog_WebViewBase", 1, "call onPageFinished after destroy.");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.b.c) && (!this.b.isFinishing()))
    {
      QLog.d("WebLog_WebViewBase", 1, "onPageStarted:" + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.b.a(paramWebView, paramString, paramBitmap);
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(paramString, 8589934593L, null);
      }
      this.b.b(paramWebView, paramString, paramBitmap);
      return;
    }
    QLog.e("WebLog_WebViewBase", 1, "call onPageStarted after destroy.");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((!this.b.c) && (!this.b.isFinishing()))
    {
      QLog.e("WebLog_WebViewBase", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
      this.b.a(paramWebView, paramInt, paramString1, paramString2);
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString2, 8589934595L, paramInt);
      }
      return;
    }
    QLog.e("WebLog_WebViewBase", 1, "call onReceivedError after destroy.");
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((!this.b.c) && (!this.b.isFinishing()))
    {
      if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
      {
        QLog.e("WebLog_WebViewBase", 1, "onReceivedHttpError:" + paramWebResourceRequest.getUrl() + "Occur error, resp code=" + paramWebResourceResponse.getStatusCode());
        String str = paramWebView.getUrl();
        if ((str != null) && (mvs.a().a(str)))
        {
          paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
          if (paramWebView != null)
          {
            if (this.a == null) {
              this.a = new ArrayMap(4);
            }
            this.a.put("requestData", paramWebResourceRequest);
            this.a.put("responseData", paramWebResourceResponse);
            this.a.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
            paramWebView.a(str, 64L, this.a);
          }
        }
      }
      return;
    }
    QLog.e("WebLog_WebViewBase", 1, "call onReceivedHttpError after destroy.");
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((!this.b.c) && (!this.b.isFinishing()))
    {
      SslCertificate localSslCertificate = paramSslError.getCertificate();
      String str = paramWebView.getUrl();
      paramSslError = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
      if (localSslCertificate == null) {}
      for (paramWebView = "null";; paramWebView = localSslCertificate.toString())
      {
        QLog.e("WebLog_WebViewBase", 1, paramWebView + ", pageUrl=" + nau.b(str, new String[0]));
        paramSslErrorHandler.cancel();
        return;
      }
    }
    QLog.e("WebLog_WebViewBase", 1, "call onReceivedSslError after destroy.");
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.b.c) || (this.b.isFinishing()))
    {
      QLog.e("WebLog_WebViewBase", 1, "call shouldOverrideUrlLoading after destroy.");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "shouldOverrideUrlLoading:" + nau.b(paramString, new String[0]));
    }
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("https://jsbridge/")) {
        break label137;
      }
      str = paramString.replace("https://jsbridge/", "jsbridge://");
    }
    for (;;)
    {
      acsz.b(this.b.getIntent(), str);
      if ((!TextUtils.isEmpty(str)) && (!"about:blank;".equals(str)) && (!"about:blank".equals(str))) {
        break;
      }
      return true;
      label137:
      str = paramString;
      if (paramString.startsWith("http://jsbridge/")) {
        str = paramString.replace("http://jsbridge/", "jsbridge://");
      }
    }
    paramString = bcgq.b(str);
    nau.a("urlInterceptManager");
    Object localObject;
    if ((("http".equals(paramString)) || ("data".equals(paramString))) && ((this.b.getActivity() instanceof QQBrowserActivity)))
    {
      localObject = ((QQBrowserActivity)this.b.getActivity()).b();
      if ((localObject != null) && (((WebViewFragment)localObject).a != null) && (((WebViewFragment)localObject).a.a != null))
      {
        localObject = ((WebViewFragment)localObject).a.a.a(str);
        if (localObject != null)
        {
          paramWebView = new Intent(this.b.getActivity(), JumpActivity.class);
          paramWebView.setData(Uri.parse((String)localObject));
          paramWebView.putExtra("from", "webview");
          this.b.startActivity(paramWebView);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("WebLog_WebViewBase", 2, "URLInterceptManager = null");
      }
    }
    nau.b("urlInterceptManager");
    if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.addContextLog(nau.b(str, new String[0]));
    }
    try
    {
      if (("http".equals(paramString)) || ("https".equals(paramString)))
      {
        localObject = paramWebView.getHitTestResult();
        if ((localObject != null) && (((WebView.HitTestResult)localObject).getType() == 0))
        {
          QLog.i("WebLog_WebViewBase", 1, "shouldOverrideUrlLoading detect 302, url: " + str);
          this.b.d = str;
          SwiftBrowserCookieMonster.d();
          this.b.jdField_a_of_type_Bcfo.e(str);
        }
      }
      localObject = ((CustomWebView)paramWebView).getPluginEngine();
      if ((localObject != null) && (((WebViewPluginEngine)localObject).a(str))) {
        return true;
      }
      if (this.b.a(paramWebView, str)) {
        return true;
      }
      if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
      {
        if ((localObject != null) && (((WebViewPluginEngine)localObject).a(str, 16L, null))) {
          return true;
        }
      }
      else
      {
        paramString = Uri.parse(str);
        str = paramString.getScheme();
        if ((this.b.isResume()) && ((System.currentTimeMillis() - this.b.e < 1000L) || (this.b.jdField_a_of_type_Mvs.a(paramWebView.getUrl(), str).booleanValue())))
        {
          paramWebView = new Intent("android.intent.action.VIEW", paramString);
          paramWebView.addFlags(268435456);
        }
      }
      label646:
      return false;
    }
    catch (RuntimeException paramWebView)
    {
      try
      {
        this.b.startActivity(paramWebView);
        return true;
        paramWebView = paramWebView;
        paramString = QLog.getStackTraceString(paramWebView);
        if (paramString.length() > 255) {}
        for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
        {
          axqy.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
          QLog.e("WebLog_WebViewBase", 1, paramString);
          break;
        }
      }
      catch (ActivityNotFoundException paramWebView)
      {
        break label646;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xjr
 * JD-Core Version:    0.7.0.1
 */