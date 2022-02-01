import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.2;
import com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.3;
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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class arar
{
  aqzw jdField_a_of_type_Aqzw;
  SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  AppInterface appInterface;
  public long aum;
  jxx b;
  Intent intent;
  TouchWebView j;
  
  public arar(AppInterface paramAppInterface, aqzw paramaqzw, Intent paramIntent, Context paramContext, boolean paramBoolean)
  {
    this.j = a(paramContext, paramBoolean);
    this.appInterface = paramAppInterface;
    this.jdField_a_of_type_Aqzw = paramaqzw;
    this.intent = paramIntent;
    a(this.j, paramAppInterface, paramIntent);
  }
  
  public arar(AppInterface paramAppInterface, aqzw paramaqzw, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    this.appInterface = paramAppInterface;
    this.jdField_a_of_type_Aqzw = paramaqzw;
    this.intent = paramIntent;
    this.j = paramTouchWebView;
    if (this.j != null) {
      a(this.j, paramAppInterface, paramIntent);
    }
  }
  
  private void d(TouchWebView paramTouchWebView)
  {
    aras localaras = new aras(this);
    paramTouchWebView.setWebChromeClient(localaras);
    this.b = localaras;
  }
  
  public TouchWebView a()
  {
    return this.j;
  }
  
  public TouchWebView a(Context paramContext, boolean paramBoolean)
  {
    jqo.le("Web_qqbrowser_init_only_webview");
    long l = System.currentTimeMillis();
    DisplayMetrics localDisplayMetrics;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      paramContext = SwiftReuseTouchWebView.a(paramContext);
      localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams != null) {
        break label88;
      }
      localLayoutParams = new ViewGroup.LayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    }
    for (;;)
    {
      paramContext.setLayoutParams(localLayoutParams);
      this.aum = (System.currentTimeMillis() - l);
      return paramContext;
      paramContext = new TouchWebView(paramContext);
      break;
      label88:
      localLayoutParams.width = localDisplayMetrics.widthPixels;
      localLayoutParams.height = localDisplayMetrics.heightPixels;
    }
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppInterface paramAppInterface, Intent paramIntent)
  {
    long l1 = this.aum;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + l1);
    }
    paramTouchWebView.setIntent(paramIntent);
    jqo.lf("Web_qqbrowser_init_only_webview");
    long l2 = System.currentTimeMillis();
    e(paramTouchWebView);
    d(paramTouchWebView);
    long l3 = System.currentTimeMillis();
    paramTouchWebView.setScrollBarStyle(0);
    jqo.le("Web_AdjustSettings");
    WebSettings localWebSettings = paramTouchWebView.getSettings();
    jqo.le("Web_SetUserAgent");
    Object localObject = localWebSettings.getUserAgentString();
    String str1 = a(this.jdField_a_of_type_Aqzw);
    boolean bool;
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      localWebSettings.setUserAgentString(arcp.b((String)localObject, str1, bool));
      jqo.lf("Web_SetUserAgent");
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localObject = paramAppInterface.getApplication().getPackageManager();
      int i = 0;
      try
      {
        if (!((PackageManager)localObject).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = ((PackageManager)localObject).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {
            break label579;
          }
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        label212:
        label220:
        String str2;
        long l4;
        break label212;
      }
      if (i == 0)
      {
        bool = true;
        localWebSettings.setDisplayZoomControls(bool);
        localWebSettings.setPluginsEnabled(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        str2 = MobileQQ.getMobileQQ().getQQProcessName();
        str1 = "";
        localObject = str1;
        if (str2 != null)
        {
          i = str2.lastIndexOf(':');
          localObject = str1;
          if (i > -1) {
            localObject = "_" + str2.substring(i + 1);
          }
        }
        localWebSettings.setDatabasePath(paramAppInterface.getApplication().getApplicationContext().getDir("database" + (String)localObject, 0).getPath());
        localWebSettings.setAppCachePath(paramAppInterface.getApplication().getApplicationContext().getDir("appcache" + (String)localObject, 0).getPath());
        localWebSettings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 21) {
          localWebSettings.setMixedContentMode(0);
        }
        l4 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11) {
          paramTouchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
      }
      try
      {
        paramTouchWebView.requestFocus();
        label459:
        paramTouchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(paramAppInterface.getApplication().getApplicationContext());
        if (paramTouchWebView.getX5WebViewExtension() != null)
        {
          paramTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new arar.a(paramTouchWebView, this.jdField_a_of_type_Aqzw));
          wis.b(paramIntent, "use_x5", "1");
          label514:
          jqo.lf("Web_AdjustSettings");
          if (arbz.cYa) {
            break label604;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(arbz.cYa), " cost:", Long.valueOf(arcn.a.avr) });
          }
          return paramTouchWebView;
          bool = false;
          break;
          label579:
          i = 0;
          break label212;
          bool = false;
          break label220;
          wis.b(paramIntent, "use_x5", "2");
          break label514;
          label604:
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
        break label459;
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
    return this.b;
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
        for (;;)
        {
          this.j.stopLoading();
          label77:
          this.j.loadUrlOriginal("about:blank");
          this.j.clearView();
          this.j.destroy();
          this.j = null;
          if (this.b != null)
          {
            this.b.aBe();
            this.b = null;
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
          }
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
    for (Object localObject = new arat(this);; localObject = new arau(this))
    {
      paramTouchWebView.setWebViewClient((WebViewClient)localObject);
      return;
    }
  }
  
  protected boolean isFinish()
  {
    return false;
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
    
    public void onFakeLoginRecognised(Bundle paramBundle)
    {
      super.onFakeLoginRecognised(paramBundle);
      boolean bool1;
      String str2;
      boolean bool2;
      boolean bool3;
      StringBuilder localStringBuilder;
      try
      {
        localObject = (ArrayList)paramBundle.get("recognised-text");
        bool1 = paramBundle.getBoolean("virtual-keyboard", false);
        str2 = paramBundle.getString("normal-input-value-change");
        bool2 = paramBundle.getBoolean("password-start-input", false);
        bool3 = paramBundle.getBoolean("password-input-show", false);
        localStringBuilder = new StringBuilder(128);
        if (localObject != null)
        {
          paramBundle = ((ArrayList)localObject).iterator();
          while (paramBundle.hasNext())
          {
            localStringBuilder.append((String)paramBundle.next()).append(",");
            continue;
            return;
          }
        }
      }
      catch (Throwable paramBundle)
      {
        QLog.e("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised ", paramBundle);
      }
      paramBundle = "";
      String str1 = "";
      if (arar.this.j != null)
      {
        paramBundle = arar.this.j.getOriginalUrl();
        str1 = arar.this.j.getUrl();
        arbz.a(paramBundle, str1, localStringBuilder.toString(), str2, bool2, bool3, bool1);
      }
      String str3;
      if (((localObject != null) && (((ArrayList)localObject).size() > 0)) || (bool1) || (!TextUtils.isEmpty(str2)))
      {
        str3 = arar.this.appInterface.getCurrentAccountUin();
        if (arar.this.j == null) {
          break label321;
        }
      }
      label321:
      for (Object localObject = arar.this.j.getTitle();; localObject = "")
      {
        arbz.U(paramBundle, str1, (String)localObject, str3);
        localStringBuilder.append(" hasVirtualKB:").append(bool1);
        localStringBuilder.append(" inputText:").append(str2);
        localStringBuilder.append(" passwdTyped:").append(bool2);
        localStringBuilder.append(" showPasswdInput:").append(bool3);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "onFakeLoginRecognised ", localStringBuilder.toString() });
        return;
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      return this.i.onInterceptTouchEvent(paramMotionEvent, paramView);
    }
    
    public Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
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
    
    WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (TextUtils.isEmpty(paramString1)) {}
      WebViewPluginEngine localWebViewPluginEngine;
      do
      {
        return localObject1;
        if (paramString1.startsWith("mqqpa://resourceid/")) {
          return obw.a(paramString1);
        }
        localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
      } while (localWebViewPluginEngine == null);
      String str;
      if (paramString1.startsWith("https://jsbridge/"))
      {
        str = paramString1.replace("https://jsbridge/", "jsbridge://");
        if (QLog.isColorLevel())
        {
          if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
            break label231;
          }
          QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str.substring(0, 512));
        }
      }
      for (;;)
      {
        if ((arar.this.j != null) && (paramString2.equalsIgnoreCase("post")) && (paramBoolean)) {
          ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.2(this, localWebViewPluginEngine, str));
        }
        if ((!str.startsWith("jsbridge:")) || (arar.this.j == null)) {
          break label257;
        }
        ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.3(this, localWebViewPluginEngine, str));
        return arcp.b();
        str = paramString1;
        if (!paramString1.startsWith("http://jsbridge/")) {
          break;
        }
        str = paramString1.replace("http://jsbridge/", "jsbridge://");
        break;
        label231:
        QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str);
      }
      for (;;)
      {
        try
        {
          label257:
          if (arar.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
          {
            paramWebView = arar.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.requestResource(str);
            if (!(paramWebView instanceof WebResourceResponse)) {
              break label412;
            }
            paramWebView = (WebResourceResponse)paramWebView;
          }
        }
        catch (Exception paramString1)
        {
          label332:
          paramWebView = localObject2;
          label343:
          QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest:intercept by sonic error -> " + paramString1.getMessage());
          continue;
        }
        for (;;)
        {
          try
          {
            QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
            localObject1 = paramWebView;
            if (paramWebView != null) {
              break;
            }
          }
          catch (Exception paramString1)
          {
            break label343;
            break label332;
          }
          try
          {
            paramString1 = localWebViewPluginEngine.handleEvent(str, 8L);
            if (!(paramString1 instanceof WebResourceResponse)) {
              continue;
            }
            paramString1 = (WebResourceResponse)paramString1;
            paramWebView = paramString1;
            return paramWebView;
          }
          catch (Exception paramString1)
          {
            QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + paramString1.getMessage());
            return paramWebView;
          }
        }
        paramWebView = null;
        continue;
        label412:
        paramWebView = null;
      }
    }
    
    WebResourceResponse doInterceptRequest(WebView paramWebView, String paramString)
    {
      return a(paramWebView, paramString, "", false);
    }
    
    public void onDetectedBlankScreen(String paramString, int paramInt)
    {
      QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
      if (arar.this.jdField_a_of_type_Aqzw != null) {
        arar.this.jdField_a_of_type_Aqzw.onDetectedBlankScreen(paramString, paramInt);
      }
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if ((arar.this.isFinish()) || (arar.this.j == null)) {
        return;
      }
      QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + paramString);
      super.onPageFinished(paramWebView, paramString);
      if (arar.this.jdField_a_of_type_Aqzw != null) {
        arar.this.jdField_a_of_type_Aqzw.onPageFinished(paramWebView, paramString);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.handleEvent(paramString, 8589934594L, null);
      }
      if (arar.this.j.getX5WebViewExtension() != null) {}
      try
      {
        paramWebView = new Bundle();
        paramWebView.putString("input-box-num", "");
        paramString = new arav(this);
        arar.this.j.getX5WebViewExtension().getFakeLoginStatus(paramWebView, paramString);
        wis.ck(arar.this.intent);
        return;
      }
      catch (Throwable paramWebView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised e:", paramWebView);
          }
        }
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      if ((arar.this.isFinish()) || (arar.this.j == null)) {}
      for (;;)
      {
        return;
        QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + paramString);
        super.onPageStarted(paramWebView, paramString, paramBitmap);
        if (arar.this.jdField_a_of_type_Aqzw != null)
        {
          arar.this.jdField_a_of_type_Aqzw.onPageStarted(paramWebView, paramString, paramBitmap);
          arar.this.jdField_a_of_type_Aqzw.b(paramWebView, paramString, paramBitmap);
        }
        paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
        if (paramWebView != null) {
          paramWebView.handleEvent(paramString, 8589934593L, null);
        }
        try
        {
          if (arar.this.j.getX5WebViewExtension() != null)
          {
            paramWebView = new Bundle();
            paramWebView.putStringArrayList("recognised-text", arca.ec());
            arar.this.j.getX5WebViewExtension().setFakeLoginParams(paramWebView);
            if (QLog.isColorLevel())
            {
              QLog.d("WebLog_WebViewWrapper", 2, "initWebviewExtension success");
              return;
            }
          }
        }
        catch (Throwable paramWebView) {}
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if ((arar.this.isFinish()) || (arar.this.j == null)) {}
      do
      {
        return;
        QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
        if (arar.this.jdField_a_of_type_Aqzw != null) {
          arar.this.jdField_a_of_type_Aqzw.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
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
      if ((arar.this.isFinish()) || (arar.this.j == null)) {
        return;
      }
      Object localObject = paramSslError.getCertificate();
      String str = paramWebView.getUrl();
      StringBuilder localStringBuilder = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((SslCertificate)localObject).toString())
      {
        QLog.e("WebLog_WebViewWrapper", 1, (String)localObject + ", pageUrl=" + jqo.filterKeyForLog(str, new String[0]));
        if (arar.this.jdField_a_of_type_Aqzw != null) {
          arar.this.jdField_a_of_type_Aqzw.a(paramWebView, paramSslError);
        }
        paramSslErrorHandler.cancel();
        return;
      }
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((arar.this.j == null) || (arar.this.isFinish()))
      {
        QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
        return true;
      }
      if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString)))
      {
        QLog.e("WebLog_WebViewWrapper", 1, new Object[] { new StringBuilder("shouldOverrideUrlLoading fail , url=[").append(paramString).append("].") });
        return true;
      }
      String str;
      if (paramString.startsWith("https://jsbridge/"))
      {
        str = paramString.replace("https://jsbridge/", "jsbridge://");
        if (QLog.isColorLevel())
        {
          if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
            break label261;
          }
          QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + str.substring(0, 512));
        }
      }
      for (;;)
      {
        wis.p(arar.this.intent, str);
        paramString = arcp.getSchemeFromUrl(str);
        if ((arar.this.jdField_a_of_type_Aqzw == null) || (!arar.this.jdField_a_of_type_Aqzw.c(arar.this.j, str))) {
          break label298;
        }
        QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
        return true;
        str = paramString;
        if (!paramString.startsWith("http://jsbridge/")) {
          break;
        }
        str = paramString.replace("http://jsbridge/", "jsbridge://");
        break;
        label261:
        QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + jqo.filterKeyForLog(str, new String[0]));
      }
      label298:
      if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        CustomWebView.addContextLog(jqo.filterKeyForLog(str, new String[0]));
      }
      try
      {
        WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.handleEvent(str, 1024L, null)))
        {
          QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
          return true;
        }
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.shouldOverrideUrlRequest(str))) {
          return true;
        }
        if ((arar.this.jdField_a_of_type_Aqzw != null) && (arar.this.jdField_a_of_type_Aqzw.shouldOverrideUrlLoading(paramWebView, str))) {
          return true;
        }
        if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
        {
          if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.handleEvent(str, 16L, null))) {
            return true;
          }
        }
        else if (arar.this.jdField_a_of_type_Aqzw != null)
        {
          boolean bool = arar.this.jdField_a_of_type_Aqzw.a(arar.this.j, str);
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
 * Qualified Name:     arar
 * JD-Core Version:    0.7.0.1
 */