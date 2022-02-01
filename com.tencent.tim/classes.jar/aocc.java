import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.teamwork.WebViewWrapperForDoc.WebViewClientImpl.1;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class aocc
{
  aqzw jdField_a_of_type_Aqzw;
  SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  Activity activity;
  AppInterface appInterface;
  private agjj.a jdField_b_of_type_Agjj$a;
  jxx jdField_b_of_type_Jxx;
  public boolean cLd;
  Intent intent;
  TouchWebView j;
  
  public aocc(AppInterface paramAppInterface, Activity paramActivity, aqzw paramaqzw, Intent paramIntent, boolean paramBoolean)
  {
    this.appInterface = paramAppInterface;
    this.activity = paramActivity;
    this.jdField_a_of_type_Aqzw = paramaqzw;
    this.intent = paramIntent;
    this.j = a(paramAppInterface, paramActivity, paramIntent, paramBoolean);
  }
  
  private void d(TouchWebView paramTouchWebView)
  {
    aocd localaocd = new aocd(this);
    paramTouchWebView.setWebChromeClient(localaocd);
    this.jdField_b_of_type_Jxx = localaocd;
  }
  
  public TouchWebView a()
  {
    return this.j;
  }
  
  public TouchWebView a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    jqo.le("Web_qqbrowser_init_only_webview");
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject2;
    if (aoca.a(paramActivity, paramIntent.getStringExtra("url")))
    {
      localObject2 = aoca.a(paramActivity);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.cLd = true;
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {
      if (paramBoolean) {
        localObject1 = SwiftReuseTouchWebView.a(paramActivity);
      }
    }
    for (;;)
    {
      Object localObject3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      localObject2 = ((TouchWebView)localObject1).getLayoutParams();
      label108:
      long l2;
      long l3;
      WebSettings localWebSettings;
      label224:
      String str1;
      label266:
      label326:
      int i;
      if (localObject2 == null)
      {
        localObject2 = new ViewGroup.LayoutParams(((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
        ((TouchWebView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        l1 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + l1);
        }
        ((TouchWebView)localObject1).setIntent(paramIntent);
        jqo.lf("Web_qqbrowser_init_only_webview");
        l2 = System.currentTimeMillis();
        e((TouchWebView)localObject1);
        d((TouchWebView)localObject1);
        l3 = System.currentTimeMillis();
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        jqo.le("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        jqo.le("Web_SetUserAgent");
        if (!aeuk.a().ahY()) {
          break label884;
        }
        localObject2 = " _tdocFlag/1";
        localObject3 = new StringBuilder().append("tendocpreload get UA");
        str1 = localWebSettings.getUserAgentString();
        String str2 = a(this.jdField_a_of_type_Aqzw);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label892;
        }
        paramBoolean = true;
        QLog.i("WebLog_WebViewWrapper", 1, arcp.b(str1, str2, paramBoolean));
        localObject3 = new StringBuilder();
        str1 = localWebSettings.getUserAgentString();
        str2 = a(this.jdField_a_of_type_Aqzw);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label898;
        }
        paramBoolean = true;
        localWebSettings.setUserAgentString(arcp.b(str1, str2, paramBoolean) + (String)localObject2);
        jqo.lf("Web_SetUserAgent");
        localWebSettings.setSavePassword(false);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localObject2 = paramAppInterface.getApplication().getPackageManager();
        i = 0;
      }
      label788:
      label929:
      try
      {
        if (!((PackageManager)localObject2).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          paramBoolean = ((PackageManager)localObject2).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!paramBoolean) {
            break label904;
          }
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        label437:
        label445:
        long l4;
        label686:
        label884:
        label892:
        break label437;
      }
      if (i == 0)
      {
        paramBoolean = true;
        localWebSettings.setDisplayZoomControls(paramBoolean);
        localWebSettings.setPluginsEnabled(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        str1 = MobileQQ.getMobileQQ().getQQProcessName();
        localObject3 = "";
        localObject2 = localObject3;
        if (str1 != null)
        {
          i = str1.lastIndexOf(':');
          localObject2 = localObject3;
          if (i > -1) {
            localObject2 = "_" + str1.substring(i + 1);
          }
        }
        localWebSettings.setDatabasePath(paramAppInterface.getApplication().getApplicationContext().getDir("database" + (String)localObject2, 0).getPath());
        localWebSettings.setAppCachePath(paramAppInterface.getApplication().getApplicationContext().getDir("appcache" + (String)localObject2, 0).getPath());
        localWebSettings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 21) {
          localWebSettings.setMixedContentMode(0);
        }
        l4 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11) {
          ((TouchWebView)localObject1).removeJavascriptInterface("searchBoxJavaBridge_");
        }
      }
      try
      {
        ((TouchWebView)localObject1).requestFocus();
        paramBoolean = paramIntent.getBooleanExtra("fromArkAppDownload", false);
        ((TouchWebView)localObject1).setFocusableInTouchMode(true);
        this.jdField_b_of_type_Agjj$a = new agjj.a(paramAppInterface, paramActivity, (TouchWebView)localObject1);
        this.jdField_b_of_type_Agjj$a.Ja(paramBoolean);
        ((TouchWebView)localObject1).setDownloadListener(this.jdField_b_of_type_Agjj$a);
        CookieSyncManager.createInstance(paramAppInterface.getApplication().getApplicationContext());
        if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
        {
          ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new aocc.a((TouchWebView)localObject1, this.jdField_a_of_type_Aqzw));
          wis.b(paramIntent, "use_x5", "1");
          jqo.lf("Web_AdjustSettings");
          if (arbz.cYa) {
            break label929;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(arbz.cYa), " cost:", Long.valueOf(arcn.a.avr) });
          }
          return localObject1;
          localObject1 = new TouchWebView(paramActivity);
          break;
          ((ViewGroup.LayoutParams)localObject2).width = ((DisplayMetrics)localObject3).widthPixels;
          ((ViewGroup.LayoutParams)localObject2).height = ((DisplayMetrics)localObject3).heightPixels;
          break label108;
          localObject2 = "";
          break label224;
          paramBoolean = false;
          break label266;
          label898:
          paramBoolean = false;
          break label326;
          label904:
          i = 0;
          break label437;
          paramBoolean = false;
          break label445;
          wis.b(paramIntent, "use_x5", "2");
          break label788;
          paramAppInterface = new HashMap(5);
          paramAppInterface.put("createWebview", String.valueOf(l1));
          paramAppInterface.put("initWebClient", String.valueOf(l3 - l2));
          paramAppInterface.put("setWebSetting", String.valueOf(l4 - l2));
          paramAppInterface.put("coreInit", String.valueOf(arcn.a.avr));
          paramAppInterface.put("coldStart", String.valueOf(arbz.aeo));
          anpc.a(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actWebviewInit", true, 0L, 0L, paramAppInterface, null);
        }
      }
      catch (Exception localException)
      {
        break label686;
      }
    }
  }
  
  String a(aqzw paramaqzw)
  {
    if (paramaqzw != null) {
      return paramaqzw.getUAMark();
    }
    return null;
  }
  
  public jxx a()
  {
    return this.jdField_b_of_type_Jxx;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aqzw != null) {
      this.jdField_a_of_type_Aqzw = null;
    }
    if (this.j != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.j.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.onDestroy();
      }
      this.j.setPluginEngine(null);
      if (this.j.getParent() == null) {}
    }
    try
    {
      ((ViewGroup)this.j.getParent()).removeView(this.j);
    }
    catch (Exception localException1)
    {
      try
      {
        this.j.stopLoading();
        label77:
        if (this.cLd) {
          aocb.a().c(this.j);
        }
        for (;;)
        {
          this.j = null;
          if (this.jdField_b_of_type_Jxx != null)
          {
            this.jdField_b_of_type_Jxx.aBe();
            this.jdField_b_of_type_Jxx = null;
          }
          return;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
          break;
          this.j.loadUrlOriginal("about:blank");
          this.j.clearView();
          this.j.destroy();
        }
      }
      catch (Exception localException2)
      {
        break label77;
      }
    }
  }
  
  void e(TouchWebView paramTouchWebView)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = new aoce(this);; localObject = new aocf(this))
    {
      paramTouchWebView.setWebViewClient((WebViewClient)localObject);
      return;
    }
  }
  
  public void setSonicClient(SonicClientImpl paramSonicClientImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = paramSonicClientImpl;
    QLog.i("WebLog_WebViewWrapper", 1, "setSonicClient sonicClient = " + paramSonicClientImpl);
  }
  
  final class a
    extends ProxyWebViewClientExtension
  {
    aqzw a;
    final TouchWebView i;
    ArrayMap<String, Object> mCoreDumpData;
    
    public a(TouchWebView paramTouchWebView, aqzw paramaqzw)
    {
      this.i = paramTouchWebView;
      this.a = paramaqzw;
    }
    
    void a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.i.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        if (this.mCoreDumpData == null) {
          this.mCoreDumpData = new ArrayMap(4);
        }
        this.mCoreDumpData.put("performanceData", paramObject1);
        this.mCoreDumpData.put("requestData", paramObject2);
        this.mCoreDumpData.put("responseData", paramObject3);
        this.mCoreDumpData.put("errorCode", paramObject4);
        localWebViewPluginEngine.handleEvent(this.i.getUrl(), 64L, this.mCoreDumpData);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("WebCoreDump", 2, "No JS plugin engine to web core dump");
    }
    
    public void computeScroll(View paramView)
    {
      this.i.computeScroll(paramView);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      return this.i.dispatchTouchEvent(paramMotionEvent, paramView);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      return this.i.onInterceptTouchEvent(paramMotionEvent, paramView);
    }
    
    public Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      QLog.d("WebLog_WebViewWrapper", 1, "onMiscCallBack for one args: " + paramString);
      if (this.a != null) {
        return this.a.a(paramString, paramBundle);
      }
      return null;
    }
    
    public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if ((paramString.equalsIgnoreCase("onReportResourceInfo")) || (paramString.equalsIgnoreCase("onResourcesPerformance"))) {
        a(paramObject1, paramObject2, paramObject3, paramObject4);
      }
      return null;
    }
    
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
    {
      this.i.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    }
    
    public void onPrefetchResourceHit(boolean paramBoolean)
    {
      QLog.i("WebLog_WebViewWrapper", 1, "now prefetchResource is hit: " + paramBoolean);
    }
    
    public void onPreloadCallback(int paramInt, String paramString)
    {
      if (this.a != null) {
        this.a.ec(paramInt, paramString);
      }
    }
    
    public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
    {
      a(null, paramWebResourceRequest, paramWebResourceResponse, Integer.valueOf(paramInt));
    }
    
    public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
    {
      this.i.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      return this.i.onTouchEvent(paramMotionEvent, paramView);
    }
    
    public void onUrlChange(String paramString1, String paramString2)
    {
      
      if (this.a != null) {
        this.a.onUrlChange(paramString1, paramString2);
      }
    }
    
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      return this.i.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    }
  }
  
  public class b
    extends WebViewClient
  {
    ArrayMap<String, Object> mCoreDumpData;
    
    b() {}
    
    WebResourceResponse doInterceptRequest(WebView paramWebView, String paramString)
    {
      Object localObject3 = null;
      Object localObject2 = null;
      if (TextUtils.isEmpty(paramString)) {}
      WebViewPluginEngine localWebViewPluginEngine;
      do
      {
        return localObject2;
        if (paramString.startsWith("mqqpa://resourceid/")) {
          return obw.a(paramString);
        }
        localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
      } while (localWebViewPluginEngine == null);
      Object localObject1;
      if (paramString.startsWith("https://jsbridge/"))
      {
        localObject1 = paramString.replace("https://jsbridge/", "jsbridge://");
        if (QLog.isColorLevel())
        {
          if ((!((String)localObject1).startsWith("jsbridge://")) || (((String)localObject1).length() <= 512)) {
            break label235;
          }
          QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + ((String)localObject1).substring(0, 512));
        }
      }
      for (;;)
      {
        if ((!((String)localObject1).startsWith("jsbridge:")) || (aocc.this.j == null)) {
          break label260;
        }
        ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapperForDoc.WebViewClientImpl.1(this, localWebViewPluginEngine, (String)localObject1));
        localObject1 = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
        paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
        paramWebView = paramString;
        if (paramString == null) {
          paramWebView = new HashMap();
        }
        paramWebView.put("cache-control", "must-revalidate，no-store");
        ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
        return localObject1;
        localObject1 = paramString;
        if (!paramString.startsWith("http://jsbridge/")) {
          break;
        }
        localObject1 = paramString.replace("http://jsbridge/", "jsbridge://");
        break;
        label235:
        QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + (String)localObject1);
      }
      for (;;)
      {
        try
        {
          label260:
          if (aocc.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
          {
            paramWebView = aocc.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.requestResource((String)localObject1);
            if (!(paramWebView instanceof WebResourceResponse)) {
              break label413;
            }
            paramWebView = (WebResourceResponse)paramWebView;
          }
        }
        catch (Exception paramString)
        {
          label333:
          paramWebView = localObject3;
          label344:
          QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest:intercept by sonic error -> " + paramString.getMessage());
          continue;
        }
        for (;;)
        {
          try
          {
            QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
            localObject2 = paramWebView;
            if (paramWebView != null) {
              break;
            }
          }
          catch (Exception paramString)
          {
            break label344;
            break label333;
          }
          try
          {
            paramString = localWebViewPluginEngine.handleEvent((String)localObject1, 8L);
            if (!(paramString instanceof WebResourceResponse)) {
              continue;
            }
            paramString = (WebResourceResponse)paramString;
            paramWebView = paramString;
            return paramWebView;
          }
          catch (Exception paramString)
          {
            QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + paramString.getMessage());
            return paramWebView;
          }
        }
        paramWebView = null;
        continue;
        label413:
        paramWebView = null;
      }
    }
    
    public void onDetectedBlankScreen(String paramString, int paramInt)
    {
      QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
      if (aocc.this.jdField_a_of_type_Aqzw != null) {
        aocc.this.jdField_a_of_type_Aqzw.onDetectedBlankScreen(paramString, paramInt);
      }
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if ((aocc.this.activity.isFinishing()) || (aocc.this.j == null)) {
        return;
      }
      QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + paramString);
      super.onPageFinished(paramWebView, paramString);
      if (aocc.this.jdField_a_of_type_Aqzw != null) {
        aocc.this.jdField_a_of_type_Aqzw.onPageFinished(paramWebView, paramString);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.handleEvent(paramString, 8589934594L, null);
      }
      wis.ck(aocc.this.intent);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      if ((aocc.this.activity.isFinishing()) || (aocc.this.j == null)) {}
      do
      {
        return;
        QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + paramString);
        super.onPageStarted(paramWebView, paramString, paramBitmap);
        if (aocc.this.jdField_a_of_type_Aqzw != null)
        {
          aocc.this.jdField_a_of_type_Aqzw.onPageStarted(paramWebView, paramString, paramBitmap);
          aocc.this.jdField_a_of_type_Aqzw.b(paramWebView, paramString, paramBitmap);
        }
        paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      } while (paramWebView == null);
      paramWebView.handleEvent(paramString, 8589934593L, null);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if ((aocc.this.activity.isFinishing()) || (aocc.this.j == null)) {}
      do
      {
        return;
        QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
        if (aocc.this.jdField_a_of_type_Aqzw != null) {
          aocc.this.jdField_a_of_type_Aqzw.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        }
        paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      } while (paramWebView == null);
      paramWebView.c(paramString2, 8589934595L, paramInt);
    }
    
    public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
      {
        QLog.e("WebLog_WebViewWrapper", 1, "onReceivedHttpError:" + paramWebResourceRequest.getUrl() + "Occur error, resp code=" + paramWebResourceResponse.getStatusCode());
        String str = paramWebView.getUrl();
        if ((str != null) && (jml.a().cQ(str)))
        {
          paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
          if (paramWebView != null)
          {
            if (this.mCoreDumpData == null) {
              this.mCoreDumpData = new ArrayMap(4);
            }
            this.mCoreDumpData.put("requestData", paramWebResourceRequest);
            this.mCoreDumpData.put("responseData", paramWebResourceResponse);
            this.mCoreDumpData.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
            paramWebView.handleEvent(str, 64L, this.mCoreDumpData);
            paramWebView.handleEvent(str, 8589934612L, this.mCoreDumpData);
          }
        }
      }
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if ((aocc.this.activity.isFinishing()) || (aocc.this.j == null)) {
        return;
      }
      Object localObject = paramSslError.getCertificate();
      String str = paramWebView.getUrl();
      StringBuilder localStringBuilder = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((SslCertificate)localObject).toString())
      {
        QLog.e("WebLog_WebViewWrapper", 1, (String)localObject + ", pageUrl=" + jqo.filterKeyForLog(str, new String[0]));
        if (aocc.this.jdField_a_of_type_Aqzw != null) {
          aocc.this.jdField_a_of_type_Aqzw.a(paramWebView, paramSslError);
        }
        paramSslErrorHandler.cancel();
        return;
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((aocc.this.j == null) || (aocc.this.activity.isFinishing()))
      {
        QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
        return true;
      }
      if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString)))
      {
        QLog.e("WebLog_WebViewWrapper", 1, new Object[] { new StringBuilder("shouldOverrideUrlLoading fail , url=[").append(paramString).append("].") });
        return true;
      }
      Object localObject = aeuk.a();
      if ((paramString.startsWith("mqqapi:")) && (paramString.contains("getTcntDocData")) && (((aeuj)localObject).ahY()))
      {
        paramWebView = Uri.parse(paramString).getQueryParameter("id");
        aocb.b(paramWebView, aocc.this.j);
        if ((aocc.this.jdField_a_of_type_Aqzw instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)) {
          aocb.b(paramWebView, aocc.this.j);
        }
        for (;;)
        {
          return true;
          aocb.a().c(aocc.this.a());
        }
      }
      if (paramString.startsWith("https://jsbridge/"))
      {
        localObject = paramString.replace("https://jsbridge/", "jsbridge://");
        if (QLog.isColorLevel())
        {
          if ((!((String)localObject).startsWith("jsbridge://")) || (((String)localObject).length() <= 512)) {
            break label361;
          }
          QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + ((String)localObject).substring(0, 512));
        }
      }
      for (;;)
      {
        wis.p(aocc.this.intent, (String)localObject);
        paramString = arcp.getSchemeFromUrl((String)localObject);
        if ((aocc.this.jdField_a_of_type_Aqzw == null) || (!aocc.this.jdField_a_of_type_Aqzw.c(aocc.this.j, (String)localObject))) {
          break label398;
        }
        QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
        return true;
        localObject = paramString;
        if (!paramString.startsWith("http://jsbridge/")) {
          break;
        }
        localObject = paramString.replace("http://jsbridge/", "jsbridge://");
        break;
        label361:
        QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + jqo.filterKeyForLog((String)localObject, new String[0]));
      }
      label398:
      if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!((String)localObject).contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        CustomWebView.addContextLog(jqo.filterKeyForLog((String)localObject, new String[0]));
      }
      try
      {
        WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.handleEvent((String)localObject, 1024L, null)))
        {
          QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
          return true;
        }
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.shouldOverrideUrlRequest((String)localObject))) {
          return true;
        }
        if ((aocc.this.jdField_a_of_type_Aqzw != null) && (aocc.this.jdField_a_of_type_Aqzw.shouldOverrideUrlLoading(paramWebView, (String)localObject))) {
          return true;
        }
        if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
        {
          if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.handleEvent((String)localObject, 16L, null))) {
            return true;
          }
        }
        else if (aocc.this.jdField_a_of_type_Aqzw != null)
        {
          boolean bool = aocc.this.jdField_a_of_type_Aqzw.a(aocc.this.j, (String)localObject);
          if (bool) {
            return true;
          }
        }
      }
      catch (RuntimeException paramWebView)
      {
        paramString = QLog.getStackTraceString(paramWebView);
        if (paramString.length() > 255) {}
        for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
        {
          anot.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
          QLog.e("WebLog_WebViewWrapper", 1, paramString);
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocc
 * JD-Core Version:    0.7.0.1
 */