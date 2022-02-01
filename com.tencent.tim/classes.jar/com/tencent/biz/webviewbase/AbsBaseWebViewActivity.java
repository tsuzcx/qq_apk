package com.tencent.biz.webviewbase;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqqu;
import aqzl;
import aran;
import araz;
import araz.d;
import araz.e;
import arbs;
import arbz;
import arcb;
import arcd;
import arcd.a;
import arcn;
import arcp;
import ardk;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import jml;
import jpu;
import jqg;
import jqo;
import jxx;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import obw;
import org.json.JSONObject;
import ssl;
import ssm;
import ssn;
import sso;
import ssp;
import wis;

public abstract class AbsBaseWebViewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, aran, araz.d, araz.e
{
  public static final HashSet<String> ap = new HashSet();
  public long Dr = 5L;
  public long Ds;
  protected String GY;
  public aqzl a;
  public final araz a;
  protected final arbs a;
  public final arbz a;
  public final arcd.a a;
  public final arcd a;
  protected SonicClientImpl a;
  protected JsBridgeListener a;
  protected boolean aMT;
  public boolean aMU;
  private boolean aMV;
  private boolean aMW;
  private boolean aMX;
  public jml authConfig;
  protected boolean avR;
  public FrameLayout customContainer;
  public TouchWebView g;
  public long gK = 4L;
  protected long iJ;
  public boolean isDestroyed;
  public volatile AppInterface mApp;
  public jxx mChromeClient;
  public jpu mFileChooserHelper;
  protected final Handler mHandler = new Handler(Looper.getMainLooper());
  protected volatile WebViewPluginEngine mPluginEngine;
  public String mRedirect302Url = "";
  private WebViewClient mWebViewClient;
  private ImageView oM;
  protected final Object sInitEngineLock = new Object();
  public String uin;
  protected volatile boolean zT;
  
  static
  {
    ap.add("Meizu_M040");
    ap.add("YuLong_Coolpad8720Q");
    ap.add("YuLong_Coolpad 7269");
    ap.add("samsung_SM-G9006W");
  }
  
  public AbsBaseWebViewActivity()
  {
    this.jdField_a_of_type_Araz = a();
    this.jdField_a_of_type_Arcd = ((arcd)this.jdField_a_of_type_Araz.q(2));
    this.jdField_a_of_type_Arcd$a = this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a;
    this.jdField_a_of_type_Arbs = ((arbs)this.jdField_a_of_type_Araz.q(-1));
    this.jdField_a_of_type_Arbz = ((arbz)this.jdField_a_of_type_Araz.q(-2));
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewBase", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  private void bAF()
  {
    if (!this.zT)
    {
      this.zT = true;
      String str = getIntent().getStringExtra("url");
      if (ardk.rX(str)) {
        ThreadManager.postImmediately(new AbsBaseWebViewActivity.7(this, str), null, false);
      }
    }
  }
  
  private void initPluginEngine()
  {
    if (this.mPluginEngine != null) {
      return;
    }
    if ((this.mPluginEngine == null) && (WebViewPluginEngine.e != null))
    {
      this.mPluginEngine = WebViewPluginEngine.e;
      WebViewPluginEngine.e = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, this);
      return;
    }
    ThreadManager.postImmediately(new AbsBaseWebViewActivity.5(this), null, false);
  }
  
  private void tC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "initSonicSession url = :" + paramString);
    }
    Object localObject = new SonicSessionConfig.Builder();
    ((SonicSessionConfig.Builder)localObject).setSessionMode(1);
    SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
    if (localSonicEngine != null)
    {
      localObject = localSonicEngine.createSession(paramString, ((SonicSessionConfig.Builder)localObject).build());
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
        ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      }
    }
    else
    {
      return;
    }
    QLog.d("WebLog_WebViewBase", 1, "initSonicSession sonicSession = null, url = " + paramString);
  }
  
  protected boolean Nk()
  {
    if (this.g != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.cXk))
      {
        this.g.callJs4OpenApi(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.GY))
      {
        this.g.callJs(this.GY, new String[] { "" });
        return true;
      }
    }
    return false;
  }
  
  public araz a()
  {
    return new araz(this, 127, null);
  }
  
  public final TouchWebView a(ViewGroup paramViewGroup)
  {
    jqo.le("Web_qqbrowser_init_only_webview");
    Object localObject2 = getIntent();
    long l = System.currentTimeMillis();
    Object localObject1;
    if (0L != (this.Ds & 0x40)) {
      localObject1 = SwiftReuseTouchWebView.a(this);
    }
    for (;;)
    {
      Object localObject3;
      boolean bool;
      label64:
      label236:
      WebSettings localWebSettings;
      if ((localObject1 instanceof SwiftReuseTouchWebView))
      {
        localObject3 = this.jdField_a_of_type_Arbz;
        if (1 == ((SwiftReuseTouchWebView)localObject1).flag)
        {
          bool = true;
          ((arbz)localObject3).cXY = bool;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("webviewinit", 2, "TouchWebView cost = " + (System.currentTimeMillis() - l));
        }
        ((TouchWebView)localObject1).setIntent((Intent)localObject2);
        jqo.lf("Web_qqbrowser_init_only_webview");
        if ((this.mApp == null) && (QLog.isColorLevel())) {
          QLog.w("WebLog_WebViewBase", 2, "Caution! AppRuntime is null!");
        }
        this.mPluginEngine.e((CustomWebView)localObject1);
        ((TouchWebView)localObject1).setPluginEngine(this.mPluginEngine);
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView((CustomWebView)localObject1);
        }
        System.currentTimeMillis();
        if (this.mChromeClient == null) {
          this.mChromeClient = new ssl(this);
        }
        ((TouchWebView)localObject1).setWebChromeClient(this.mChromeClient);
        if (this.mWebViewClient == null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label740;
          }
          this.mWebViewClient = new ssm(this);
        }
        ((TouchWebView)localObject1).setWebViewClient(this.mWebViewClient);
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        jqo.le("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        jqo.le("Web_SetUserAgent");
        localObject2 = localWebSettings.getUserAgentString();
        localObject3 = getUAMark();
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label755;
        }
        bool = true;
        label294:
        localWebSettings.setUserAgentString(arcp.b((String)localObject2, (String)localObject3, bool));
        jqo.lf("Web_SetUserAgent");
        localWebSettings.setSavePassword(false);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localObject2 = getPackageManager();
      }
      try
      {
        if (!((PackageManager)localObject2).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = ((PackageManager)localObject2).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {}
        }
        else
        {
          i = 1;
          label386:
          if (i != 0) {
            break label773;
          }
          bool = true;
          label393:
          localWebSettings.setDisplayZoomControls(bool);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str = MobileQQ.getMobileQQ().getQQProcessName();
          localObject3 = "";
          localObject2 = localObject3;
          if (str != null)
          {
            i = str.lastIndexOf(':');
            localObject2 = localObject3;
            if (i > -1) {
              localObject2 = "_" + str.substring(i + 1);
            }
          }
          localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + (String)localObject2, 0).getPath());
          localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + (String)localObject2, 0).getPath());
          localWebSettings.setMediaPlaybackRequiresUserGesture(false);
          if (Build.VERSION.SDK_INT >= 11) {
            ((TouchWebView)localObject1).removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          int i;
          ((TouchWebView)localObject1).requestFocus();
          label605:
          ((TouchWebView)localObject1).setFocusableInTouchMode(true);
          ((TouchWebView)localObject1).setDownloadListener(new sso(this, (TouchWebView)localObject1));
          CookieSyncManager.createInstance(getApplicationContext());
          if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
          {
            this.aMX = true;
            ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new a((TouchWebView)localObject1));
            wis.b(getIntent(), "use_x5", "1");
          }
          for (;;)
          {
            ((TouchWebView)localObject1).getView().setOnTouchListener(this);
            if (this.avR) {
              ((TouchWebView)localObject1).setMask(true);
            }
            jqo.lf("Web_AdjustSettings");
            if (paramViewGroup != null) {
              paramViewGroup.addView((View)localObject1);
            }
            return localObject1;
            localObject1 = new TouchWebView(this);
            break;
            bool = false;
            break label64;
            label740:
            this.mWebViewClient = new ssn(this);
            break label236;
            label755:
            bool = false;
            break label294;
            i = 0;
            break label386;
            localRuntimeException = localRuntimeException;
            i = 0;
            break label386;
            label773:
            bool = false;
            break label393;
            wis.b(getIntent(), "use_x5", "2");
          }
        }
        catch (Exception localException)
        {
          break label605;
        }
      }
    }
  }
  
  public WebViewFragment a()
  {
    return null;
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    startActivity(paramIntent);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    int i;
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.cXk))
    {
      i = 1;
      if (!paramBoolean) {
        break label70;
      }
      this.jdField_a_of_type_Arcd$a.cYo = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.oM != null) {
        this.oM.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label70:
      if (paramInt1 == 0)
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          this.rightViewText.setText(paramString2);
          this.rightViewText.setVisibility(0);
          this.rightViewText.bringToFront();
          this.rightViewImg.setImageResource(0);
          this.rightViewImg.setBackgroundColor(0);
          this.rightViewImg.setVisibility(8);
        }
        if (paramString3 != null)
        {
          paramInt1 = 0;
          if (paramString3.length() <= 0) {}
        }
        try
        {
          paramInt1 = Color.parseColor(paramString3);
          this.rightViewImg.setBackgroundColor(paramInt1);
          if ((paramString1 != null) && (i == 0))
          {
            this.rightViewImg.setOnClickListener(this);
            this.rightViewText.setOnClickListener(this);
            this.GY = paramString1.trim();
            if ((this.jdField_a_of_type_Arcd$a.ce == null) || (!this.jdField_a_of_type_Arcd$a.ce.has("txtclr"))) {
              continue;
            }
            paramString2 = this.jdField_a_of_type_Arcd$a.ce.optString("txtclr", "");
            if (TextUtils.isEmpty(paramString2)) {
              continue;
            }
            paramString1 = paramString2;
            if (!paramString2.startsWith("#")) {
              paramString1 = "#" + paramString2;
            }
            try
            {
              paramInt1 = Color.parseColor(paramString1);
              paramString1 = jqg.d(this.rightViewImg.getDrawable(), paramInt1);
              if (paramString1 != null) {
                this.rightViewImg.setImageDrawable(paramString1);
              }
              this.rightViewText.setTextColor(paramInt1);
              return;
            }
            catch (Exception paramString1)
            {
              QLog.e("WebLog_WebViewBase", 1, paramString1, new Object[0]);
              return;
            }
          }
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramInt1 = 0;
            continue;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
            this.GY = null;
          }
        }
      }
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    paramString3 = this.jdField_a_of_type_Arcd$a;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label380:
      paramString3.cYo = paramBoolean;
      switch (paramInt1)
      {
      case 6: 
      default: 
        this.rightViewImg.setVisibility(8);
        label457:
        if (paramInt2 != 0)
        {
          if (this.oM == null)
          {
            this.oM = new ImageView(this);
            paramString3 = (RelativeLayout)findViewById(2131377502);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131369594);
            localLayoutParams.addRule(6, 2131369594);
            localLayoutParams.setMargins(0, 0, 0, 0);
            this.oM.setLayoutParams(localLayoutParams);
            paramString3.addView(this.oM);
          }
          this.oM.setVisibility(0);
          switch (paramInt2)
          {
          default: 
            this.oM.setVisibility(8);
            label589:
            if (!TextUtils.isEmpty(paramString2)) {
              this.rightViewImg.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.rightViewImg.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.aMV = false;
      this.aMW = false;
      break;
      paramBoolean = false;
      break label380;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130844670, 2130844670);
      this.rightViewImg.setContentDescription(getResources().getString(2131693963));
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130844669, 2130844669);
      this.rightViewImg.setContentDescription(getResources().getString(2131693962));
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130840667, 2130840663);
      this.rightViewImg.setContentDescription(getResources().getString(2131693964));
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130839618, 2130839608);
      this.rightViewImg.setContentDescription(getResources().getString(2131693966));
      break label457;
      this.rightViewImg.setImageResource(2130844714);
      this.rightViewImg.setContentDescription(getResources().getString(2131693968));
      ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130843364, 2130843367);
      this.rightViewImg.setContentDescription(getResources().getString(2131721053));
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130851141, 2130851145);
      this.rightViewImg.setContentDescription(getResources().getString(2131721053));
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130838993, 2130838993);
      this.rightViewImg.setContentDescription(getResources().getString(2131693965));
      break label457;
      this.jdField_a_of_type_Arcd.a(this.rightViewImg, false, 2130851313, 2130851313);
      this.rightViewImg.setContentDescription(getResources().getString(2131693965));
      break label457;
      this.oM.setImageResource(2130844492);
      break label589;
      if (this.oM == null) {
        break label589;
      }
      this.oM.setVisibility(8);
      break label589;
      if ((paramString1 != null) && (i == 0))
      {
        this.rightViewImg.setOnClickListener(this);
        this.rightViewText.setOnClickListener(this);
        this.GY = paramString1.trim();
      }
      else
      {
        this.GY = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  public araz b()
  {
    return this.jdField_a_of_type_Araz;
  }
  
  public final TouchWebView b(ViewGroup paramViewGroup)
  {
    if (this.g != null) {
      return this.g;
    }
    this.g = a(paramViewGroup);
    return this.g;
  }
  
  public WebView b()
  {
    throw new UnsupportedOperationException("must override this method getHostWebView()!");
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public final void bAE()
  {
    if ((this.mPluginEngine == null) && (WebViewPluginEngine.e != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsBaseWebViewActivity", 2, "-->web engine and plugin initialized at process preload!");
      }
      this.mPluginEngine = WebViewPluginEngine.e;
      WebViewPluginEngine.e = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, this);
      this.mPluginEngine.preCreatePlugin();
    }
    while (this.mPluginEngine != null) {
      return;
    }
    synchronized (this.sInitEngineLock)
    {
      if (this.mPluginEngine == null)
      {
        this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, this, null, null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, this);
      }
      return;
    }
  }
  
  public boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.g != null)
    {
      this.g.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.g.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.handleEvent(this.g.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    if (dispatchPluginEvent(8589934600L, (Map)localObject)) {}
    label478:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            int i = paramInt1 >> 8 & 0xFF;
            if (i <= 0) {
              break;
            }
            if (this.g != null)
            {
              localObject = this.g.getPluginEngine();
              if (localObject != null)
              {
                if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (((WebViewPluginEngine)localObject).b("card") == null)) {
                  ((WebViewPluginEngine)localObject).aa(new String[] { "card" });
                }
                localObject = ((WebViewPluginEngine)localObject).a(i, true);
                if (localObject != null)
                {
                  ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(paramInt1 & 0xFF), paramInt2);
                  return;
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
          return;
          if ((this.mFileChooserHelper == null) || (!this.mFileChooserHelper.doOnActivityResult(paramInt1, paramInt2, paramIntent))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebLog_WebViewBase", 2, "Activity result handled by FileChooserHelper.");
        return;
        if ((paramInt2 != -1) || (this.g == null)) {
          break;
        }
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramIntent == null);
      localObject = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      this.g.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
      for (;;)
      {
        try
        {
          if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
            break label478;
          }
          this.aMT = bool;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WebLog_WebViewBase", 2, "onActivityResult: mPayActionSucc=" + this.aMT);
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewBase", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
        return;
        bool = false;
      }
    } while (paramInt2 != 4660);
    setResult(4660);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "doOnCreate");
    }
    super.doOnCreate(paramBundle);
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof AppInterface)) {
      this.mApp = ((AppInterface)paramBundle);
    }
    if (!VipWebViewReportLog.isInited()) {
      VipWebViewReportLog.a(this, this.mApp);
    }
    QQBrowserActivity.bJl += 1;
    this.avR = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setTheme(2131755342);
    this.authConfig = jml.a();
    WebAccelerateHelper.isWebViewCache = true;
    QLog.d("WebLog_WebViewBase", 1, "doOnCreate, WebAccelerateHelper.isWebViewCache = true");
    paramBundle = this.jdField_a_of_type_Arbz;
    this.isDestroyed = false;
    paramBundle.isDestroyed = false;
    this.uin = this.mApp.getAccount();
    bAF();
    bAE();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onDestroy");
    }
    QQBrowserActivity.bJl -= 1;
    Object localObject = this.jdField_a_of_type_Arbz;
    this.isDestroyed = true;
    ((arbz)localObject).isDestroyed = true;
    if (this.mChromeClient != null) {
      this.mChromeClient.aBe();
    }
    if (this.g != null)
    {
      localObject = this.g.getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).onDestroy();
      }
      if (this.g.getParent() == null) {}
    }
    try
    {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.g.stopLoading();
          label113:
          this.g.loadUrlOriginal("about:blank");
          this.g.clearView();
          this.g.destroy();
          this.g = null;
          this.mApp = null;
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewBase", 2, "remove webview error");
          }
        }
      }
      catch (Exception localException2)
      {
        break label113;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      dispatchPluginEvent(8589934607L, null);
      continue;
      dispatchPluginEvent(8589934608L, null);
      continue;
      dispatchPluginEvent(8589934609L, null);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i = -1;
    int j = 0;
    int k;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      k = paramIntent.getIntExtra("requestCode", -1);
      int m = k >> 8 & 0xFF;
      if (m > 0) {
        if (this.g != null)
        {
          localObject = this.g.getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(m, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label257;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(k & 0xFF), i);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
      }
      this.uin = this.mApp.getAccount();
      if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
      {
        i = j;
        if (this.g != null)
        {
          localObject = this.g.getPluginEngine();
          i = j;
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(120, true);
            i = j;
            if (localObject != null)
            {
              i = j;
              if ((localObject instanceof BuscardJsPlugin))
              {
                ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          BuscardHelper.a(this.uin, getActivity(), paramIntent);
        }
      }
      localObject = new HashMap();
      ((Map)localObject).put("intent", paramIntent);
      dispatchPluginEvent(128L, (Map)localObject);
      return;
      label257:
      i = 0;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onPause");
    }
    if (this.g != null) {
      this.g.onPause();
    }
    if ((this.mChromeClient != null) && (this.aMU)) {
      this.mChromeClient.onHideCustomView();
    }
    dispatchPluginEvent(8589934597L, null);
    String str = BridgeHelper.a(getActivity(), this.uin).getConfig("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(getActivity());
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onResume");
    }
    if (this.g != null) {
      this.g.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", this.uin);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
    dispatchPluginEvent(2L, null);
    localObject = BridgeHelper.a(getActivity(), this.uin).getConfig("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(getActivity());
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((this.gK & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewBase", 2, "close on hide by wv param");
      }
      finish();
    }
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130771990);
    }
  }
  
  public Activity getHostActivity()
  {
    return this;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  protected String getUAMark()
  {
    return null;
  }
  
  public void init(Intent paramIntent)
  {
    super.init(paramIntent);
    if (this.vg != null) {
      this.vg.setOnTouchListener(new ssp(this));
    }
    removeWebViewLayerType();
    this.jdField_a_of_type_Aqzl.leftView = this.leftView;
    this.jdField_a_of_type_Aqzl.centerView = this.centerView;
    this.jdField_a_of_type_Aqzl.rightViewText = this.rightViewText;
    this.jdField_a_of_type_Aqzl.rightViewImg = this.rightViewImg;
    this.jdField_a_of_type_Aqzl.aK = this.vg;
  }
  
  public boolean onBackEvent()
  {
    if ((this.mChromeClient != null) && (this.aMU)) {
      this.mChromeClient.onHideCustomView();
    }
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.clearHistory();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.destroy();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("target", Integer.valueOf(3));
      } while (dispatchPluginEvent(8589934601L, (Map)localObject));
      if (((this.gK & 0x4) != 0L) || (this.g == null) || (!this.g.canGoBack())) {
        break;
      }
      this.g.stopLoading();
      this.g.goBack();
      localWebViewPluginEngine = this.g.getPluginEngine();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.handleEvent(this.g.getUrl(), 8589934610L, (Map)localObject);
    return true;
    Object localObject = (InputMethodManager)getSystemService("input_method");
    if ((localObject != null) && (getCurrentFocus() != null)) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    if ((this.mChromeClient != null) && (this.aMU))
    {
      this.mChromeClient.onHideCustomView();
      return true;
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.rightViewImg) || (paramView == this.rightHighLView) || (paramView == this.rightViewText)) {
      Nk();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bAF();
    arcn.a().ehs();
    String str = arcp.e(getIntent());
    WebAccelerateHelper.getInstance().preGetKey(str, getIntent(), this.mApp);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
    this.jdField_a_of_type_Arcd.ehg();
    this.jdField_a_of_type_Aqzl = this.jdField_a_of_type_Arcd.jdField_a_of_type_Aqzl;
    boolean bool = WebAccelerateHelper.isWebViewCache;
    tC(str);
    ThreadManager.getFileThreadHandler().post(new AbsBaseWebViewActivity.6(this, bool));
    super.onCreate(paramBundle);
    QLog.i("WebLog_WebViewBase", 1, "onCreate cache:" + bool);
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if (this.mApp != null)
    {
      if ((!bool) && (!VipWebViewReportLog.isInited())) {
        VipWebViewReportLog.a(this, this.mApp);
      }
      initPluginEngine();
    }
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!ap.contains(paramBundle))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
  }
  
  protected void onPageFinished(WebView paramWebView, String paramString) {}
  
  protected void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onPostThemeChanged()
  {
    if (this.mApp != null)
    {
      this.avR = ThemeUtil.isInNightMode(this.mApp);
      dispatchPluginEvent(8589934604L, null);
    }
    if ((this.mSystemBarComp != null) && (!this.jdField_a_of_type_Arcd$a.cYs))
    {
      int i = getResources().getColor(2131167361);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  protected void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.iJ = System.currentTimeMillis();
    }
    return false;
  }
  
  protected void onUrlChange(String paramString1, String paramString2) {}
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewBase", 2, "pluginStartActivityForResult not handled");
      }
      return i;
    }
    startActivityForResult(paramIntent, i);
    return i;
  }
  
  protected boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean showPreview()
  {
    setImmersiveStatus();
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.init();
    }
    overridePendingTransition(0, 0);
    setContentViewNoTitle(2131558795);
    ((TextView)findViewById(2131371994)).setText(2131693323);
    return true;
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return a(paramWebViewPlugin, paramByte);
  }
  
  final class a
    extends ProxyWebViewClientExtension
  {
    private final TouchWebView i;
    private ArrayMap<String, Object> mCoreDumpData;
    
    public a(TouchWebView paramTouchWebView)
    {
      this.i = paramTouchWebView;
    }
    
    private void a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
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
      arcb localarcb = (arcb)AbsBaseWebViewActivity.this.a.q(16);
      if (localarcb != null) {
        return localarcb.a(paramString, paramBundle);
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
      QLog.i("WebLog_WebViewBase", 1, "now prefetchResource is hit: " + paramBoolean);
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
      SwiftBrowserCookieMonster.egU();
      AbsBaseWebViewActivity.this.onUrlChange(paramString1, paramString2);
    }
    
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      return this.i.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    }
  }
  
  public class b
    extends WebViewClient
  {
    private ArrayMap<String, Object> mCoreDumpData;
    
    private b() {}
    
    protected WebResourceResponse doInterceptRequest(WebView paramWebView, String paramString)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      if (paramString.startsWith("mqqpa://resourceid/")) {
        localObject1 = obw.a(paramString);
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
        AbsBaseWebViewActivity.this.mHandler.post(new AbsBaseWebViewActivity.WebViewClientImpl.1(this, localWebViewPluginEngine, (String)localObject2));
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
          if (AbsBaseWebViewActivity.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
          {
            paramWebView = AbsBaseWebViewActivity.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.getSession().onClientRequestResource((String)localObject2);
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
            paramString = localWebViewPluginEngine.handleEvent((String)localObject2, 8L);
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
      AbsBaseWebViewActivity.this.jdField_a_of_type_Arbz.onDetectedBlankScreen(paramString, paramInt);
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      if ((!AbsBaseWebViewActivity.this.isDestroyed) && (!AbsBaseWebViewActivity.this.isFinishing()))
      {
        QLog.d("WebLog_WebViewBase", 1, "onPageFinished:" + paramString);
        super.onPageFinished(paramWebView, paramString);
        AbsBaseWebViewActivity.this.onPageFinished(paramWebView, paramString);
        if (AbsBaseWebViewActivity.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
          AbsBaseWebViewActivity.this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.getSession().onClientPageFinished(paramString);
        }
        WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
        if (localWebViewPluginEngine != null) {
          localWebViewPluginEngine.handleEvent(paramString, 8589934594L, null);
        }
        if ((Build.VERSION.SDK_INT >= 19) && (!AbsBaseWebViewActivity.this.isDestroyed) && (AbsBaseWebViewActivity.this.mChromeClient != null))
        {
          paramString = paramWebView.getTitle();
          AbsBaseWebViewActivity.this.mChromeClient.onReceivedTitle(paramWebView, paramString);
        }
        wis.ck(AbsBaseWebViewActivity.this.getIntent());
        return;
      }
      QLog.e("WebLog_WebViewBase", 1, "call onPageFinished after destroy.");
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      if ((!AbsBaseWebViewActivity.this.isDestroyed) && (!AbsBaseWebViewActivity.this.isFinishing()))
      {
        QLog.d("WebLog_WebViewBase", 1, "onPageStarted:" + paramString);
        super.onPageStarted(paramWebView, paramString, paramBitmap);
        AbsBaseWebViewActivity.this.onPageStarted(paramWebView, paramString, paramBitmap);
        WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
        if (localWebViewPluginEngine != null) {
          localWebViewPluginEngine.handleEvent(paramString, 8589934593L, null);
        }
        AbsBaseWebViewActivity.this.b(paramWebView, paramString, paramBitmap);
        return;
      }
      QLog.e("WebLog_WebViewBase", 1, "call onPageStarted after destroy.");
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      if ((!AbsBaseWebViewActivity.this.isDestroyed) && (!AbsBaseWebViewActivity.this.isFinishing()))
      {
        QLog.e("WebLog_WebViewBase", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
        AbsBaseWebViewActivity.this.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
        paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
        if (paramWebView != null) {
          paramWebView.c(paramString2, 8589934595L, paramInt);
        }
        return;
      }
      QLog.e("WebLog_WebViewBase", 1, "call onReceivedError after destroy.");
    }
    
    public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      if ((!AbsBaseWebViewActivity.this.isDestroyed) && (!AbsBaseWebViewActivity.this.isFinishing()))
      {
        if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
        {
          QLog.e("WebLog_WebViewBase", 1, "onReceivedHttpError:" + paramWebResourceRequest.getUrl() + "Occur error, resp code=" + paramWebResourceResponse.getStatusCode());
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
            }
          }
        }
        return;
      }
      QLog.e("WebLog_WebViewBase", 1, "call onReceivedHttpError after destroy.");
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if ((!AbsBaseWebViewActivity.this.isDestroyed) && (!AbsBaseWebViewActivity.this.isFinishing()))
      {
        SslCertificate localSslCertificate = paramSslError.getCertificate();
        String str = paramWebView.getUrl();
        paramSslError = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
        if (localSslCertificate == null) {}
        for (paramWebView = "null";; paramWebView = localSslCertificate.toString())
        {
          QLog.e("WebLog_WebViewBase", 1, paramWebView + ", pageUrl=" + jqo.filterKeyForLog(str, new String[0]));
          paramSslErrorHandler.cancel();
          return;
        }
      }
      QLog.e("WebLog_WebViewBase", 1, "call onReceivedSslError after destroy.");
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((AbsBaseWebViewActivity.this.isDestroyed) || (AbsBaseWebViewActivity.this.isFinishing()))
      {
        QLog.e("WebLog_WebViewBase", 1, "call shouldOverrideUrlLoading after destroy.");
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewBase", 2, "shouldOverrideUrlLoading:" + jqo.filterKeyForLog(paramString, new String[0]));
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
        wis.p(AbsBaseWebViewActivity.this.getIntent(), str);
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
      paramString = arcp.getSchemeFromUrl(str);
      jqo.le("urlInterceptManager");
      Object localObject;
      if ((("http".equals(paramString)) || ("data".equals(paramString))) && ((AbsBaseWebViewActivity.this.getActivity() instanceof QQBrowserActivity)))
      {
        localObject = ((QQBrowserActivity)AbsBaseWebViewActivity.this.getActivity()).c();
        if ((localObject != null) && (((WebViewFragment)localObject).browserApp != null) && (((WebViewFragment)localObject).browserApp.a != null))
        {
          localObject = ((WebViewFragment)localObject).browserApp.a.pR(str);
          if (localObject != null)
          {
            paramWebView = new Intent(AbsBaseWebViewActivity.this.getActivity(), JumpActivity.class);
            paramWebView.setData(Uri.parse((String)localObject));
            paramWebView.putExtra("from", "webview");
            AbsBaseWebViewActivity.this.startActivity(paramWebView);
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("WebLog_WebViewBase", 2, "URLInterceptManager = null");
        }
      }
      jqo.lf("urlInterceptManager");
      if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
        CustomWebView.addContextLog(jqo.filterKeyForLog(str, new String[0]));
      }
      try
      {
        if (("http".equals(paramString)) || ("https".equals(paramString)))
        {
          localObject = paramWebView.getHitTestResult();
          if ((localObject != null) && (((WebView.HitTestResult)localObject).getType() == 0))
          {
            QLog.i("WebLog_WebViewBase", 1, "shouldOverrideUrlLoading detect 302, url: " + str);
            AbsBaseWebViewActivity.this.mRedirect302Url = str;
            SwiftBrowserCookieMonster.egU();
            AbsBaseWebViewActivity.this.jdField_a_of_type_Arbz.Wi(str);
          }
        }
        localObject = ((CustomWebView)paramWebView).getPluginEngine();
        if ((localObject != null) && (((WebViewPluginEngine)localObject).shouldOverrideUrlRequest(str))) {
          return true;
        }
        if (AbsBaseWebViewActivity.this.shouldOverrideUrlLoading(paramWebView, str)) {
          return true;
        }
        if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
        {
          if ((localObject != null) && (((WebViewPluginEngine)localObject).handleEvent(str, 16L, null))) {
            return true;
          }
        }
        else
        {
          paramString = Uri.parse(str);
          str = paramString.getScheme();
          if ((AbsBaseWebViewActivity.this.isResume()) && ((System.currentTimeMillis() - AbsBaseWebViewActivity.this.iJ < 1000L) || (AbsBaseWebViewActivity.this.authConfig.a(paramWebView.getUrl(), str).booleanValue())))
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
          AbsBaseWebViewActivity.this.startActivity(paramWebView);
          return true;
          paramWebView = paramWebView;
          paramString = QLog.getStackTraceString(paramWebView);
          if (paramString.length() > 255) {}
          for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
          {
            anot.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity
 * JD-Core Version:    0.7.0.1
 */