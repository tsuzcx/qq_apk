package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.sdk.stat.HttpUtils;
import com.tencent.smtt.utils.ReflectionUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class WebView
  extends FrameLayout
{
  public static final int NIGHT_MODE_ALPHA = 128;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static int X5Version = 0;
  private static boolean mIsDayMode = true;
  private static Paint mNightModePaint = null;
  private boolean isX5Core = false;
  private Context mContext = null;
  private boolean mIsReported = false;
  int mPv = 0;
  ImageView mSplashLogo;
  private SystemWebView mSysWebView;
  private WebSettings mWebSettings = null;
  private IX5WebViewBase mX5WebView;
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramContext == null) {
      throw new IllegalArgumentException("Invalid context argument");
    }
    init(paramContext);
    this.mContext = paramContext;
    if (this.isX5Core)
    {
      this.mX5WebView = SDKEngine.getInstance(true).wizard().createSDKWebview(paramContext);
      if ((this.mX5WebView == null) || (this.mX5WebView.getView() == null))
      {
        this.mX5WebView = null;
        this.isX5Core = false;
        QbSdk.forceSysWebView(true);
        init(paramContext);
        this.mSysWebView = new SystemWebView(paramContext);
        this.mSysWebView.setFocusableInTouchMode(true);
        addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
      }
      do
      {
        return;
        this.mX5WebView.getView().setFocusableInTouchMode(true);
        addView(this.mX5WebView.getView(), new FrameLayout.LayoutParams(-1, -1));
        showSplashLogo();
        this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, null, this.isX5Core));
        this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(SDKEngine.getInstance(false).wizard())
        {
          public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
            WebView.this.onScrollChanged(paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
          }
        });
      } while (X5Version != 0);
      X5Version = this.mX5WebView.getX5WebViewExtension().getQQBrowserVersion();
      return;
    }
    this.mSysWebView = new SystemWebView(paramContext);
    this.mSysWebView.setFocusableInTouchMode(true);
    addView(this.mSysWebView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if ((SDKEngine.getInstance(false) == null) || (!SDKEngine.getInstance(false).isX5Core())) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if ((SDKEngine.getInstance(false) == null) || (!SDKEngine.getInstance(false).isX5Core())) {
      ReflectionUtils.invokeStatic("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!SDKEngine.getInstance(false).isX5Core()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: invokestatic 109	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   7: ifnull +26 -> 33
    //   10: iconst_0
    //   11: invokestatic 109	com/tencent/smtt/sdk/SDKEngine:getInstance	(Z)Lcom/tencent/smtt/sdk/SDKEngine;
    //   14: invokevirtual 203	com/tencent/smtt/sdk/SDKEngine:isX5Core	()Z
    //   17: ifne +16 -> 33
    //   20: ldc 205
    //   22: ldc 224
    //   24: invokestatic 212	com/tencent/smtt/utils/ReflectionUtils:invokeStatic	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: aconst_null
    //   34: astore_0
    //   35: goto -7 -> 28
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	8	0	localObject1	Object
    //   38	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	28	38	finally
  }
  
  public static int getQQBrowserCoreVersion()
  {
    return SDKEngine.getQQBrowserCoreVersion();
  }
  
  public static int getQQBrowserVersion()
  {
    return X5Version;
  }
  
  private void init(Context paramContext)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(true);
    localSDKEngine.init(paramContext);
    this.isX5Core = localSDKEngine.isX5Core();
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = mIsDayMode;
        if (paramBoolean == bool) {
          return;
        }
        mIsDayMode = paramBoolean;
        if (mNightModePaint == null)
        {
          mNightModePaint = new Paint();
          mNightModePaint.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (mNightModePaint.getAlpha() == 128) {
            continue;
          }
          mNightModePaint.setAlpha(128);
          continue;
        }
        if (mNightModePaint.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      mNightModePaint.setAlpha(255);
    }
  }
  
  private void showSplashLogo()
  {
    try
    {
      Object localObject2 = getContext().createPackageContext("com.tencent.mtt", 2);
      int i = ((Context)localObject2).getResources().getIdentifier("thrdcall_window_bg_normal", "drawable", "com.tencent.mtt");
      Object localObject1 = null;
      try
      {
        localObject2 = BitmapFactory.decodeResource(((Context)localObject2).getResources(), i, null);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      if (localObject1 != null)
      {
        this.mSplashLogo = new ImageView(getContext());
        this.mSplashLogo.setImageBitmap((Bitmap)localObject1);
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).gravity = 17;
        addView(this.mSplashLogo, (ViewGroup.LayoutParams)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.mX5WebView.addJavascriptInterface(paramObject, paramString);
  }
  
  public boolean canGoBack()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBack();
    }
    return this.mX5WebView.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoBackOrForward(paramInt);
    }
    return this.mX5WebView.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.canGoForward();
    }
    return this.mX5WebView.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.isX5Core)
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomIn");
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return this.mX5WebView.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.isX5Core)
    {
      Object localObject;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "canZoomOut");
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
      return ((Boolean)localObject).booleanValue();
    }
    return this.mX5WebView.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.mX5WebView.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearCache(paramBoolean);
      return;
    }
    this.mX5WebView.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearFormData();
      return;
    }
    this.mX5WebView.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearHistory();
      return;
    }
    this.mX5WebView.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearMatches();
      return;
    }
    this.mX5WebView.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.clearSslPreferences();
      return;
    }
    this.mX5WebView.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "clearView");
      return;
    }
    this.mX5WebView.clearView();
  }
  
  public void computeScroll()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.computeScroll();
      return;
    }
    this.mX5WebView.computeScroll();
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.isX5Core) {
      return WebBackForwardList.wrap(this.mX5WebView.copyBackForwardList());
    }
    return WebBackForwardList.wrap(this.mSysWebView.copyBackForwardList());
  }
  
  public void destroy()
  {
    Object localObject4;
    Object localObject1;
    if (!this.mIsReported)
    {
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua");
          localObject1 = localBundle.getString("lc");
        }
      }
      HttpUtils.doReport(this.mContext, (String)localObject4, (String)???, (String)localObject1, this.mPv, this.isX5Core);
      this.mIsReported = true;
    }
    if (!this.isX5Core) {}
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.mSysWebView });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          int i = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i);
        }
      }
    }
    catch (Exception localException2)
    {
      label272:
      break label272;
    }
    this.mSysWebView.destroy();
    try
    {
      ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
      ((Field)???).setAccessible(true);
      localObject1 = (ComponentCallbacks)((Field)???).get(null);
      if (localObject1 != null)
      {
        ((Field)???).set(null, null);
        ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
        ((Field)???).setAccessible(true);
        ??? = ((Field)???).get(null);
        if (??? != null)
        {
          synchronized ((List)???)
          {
            ((List)???).remove(localObject1);
            return;
          }
          this.mX5WebView.destroy();
        }
      }
    }
    catch (Exception localException1)
    {
      return;
    }
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.documentHasImages(paramMessage);
      return;
    }
    this.mX5WebView.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.mX5WebView.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.isX5Core)
    {
      paramString = ReflectionUtils.invokeInstance(this.mSysWebView, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.mX5WebView.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mSysWebView.findAllAsync(paramString);
      }
      return;
    }
    this.mX5WebView.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.mX5WebView.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.findNext(paramBoolean);
      return;
    }
    this.mX5WebView.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.mX5WebView.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "freeMemory");
      return;
    }
    this.mX5WebView.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getCertificate();
    }
    return this.mX5WebView.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getContentHeight();
    }
    return this.mX5WebView.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getFavicon();
    }
    return this.mX5WebView.getFavicon();
  }
  
  public HitTestResult getHitTestResult()
  {
    if (!this.isX5Core) {
      return new HitTestResult(this.mSysWebView.getHitTestResult());
    }
    return new HitTestResult(this.mX5WebView.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.mX5WebView.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getOriginalUrl();
    }
    return this.mX5WebView.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getProgress();
    }
    return this.mX5WebView.getProgress();
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getScale");
      if (localObject == null) {}
      for (localObject = null;; localObject = (Float)localObject) {
        return ((Float)localObject).floatValue();
      }
    }
    return this.mX5WebView.getScale();
  }
  
  public WebSettings getSettings()
  {
    if (this.mWebSettings != null) {
      return this.mWebSettings;
    }
    if (this.isX5Core)
    {
      localWebSettings = new WebSettings(this.mX5WebView.getSettings());
      this.mWebSettings = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.mSysWebView.getSettings());
    this.mWebSettings = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getSettingsExtension();
  }
  
  android.webkit.WebView getSysWebView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return null;
  }
  
  public String getTitle()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getTitle();
    }
    return this.mX5WebView.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.getUrl();
    }
    return this.mX5WebView.getUrl();
  }
  
  public View getView()
  {
    if (!this.isX5Core) {
      return this.mSysWebView;
    }
    return this.mX5WebView.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.isX5Core)
    {
      Object localObject = ReflectionUtils.invokeInstance(this.mSysWebView, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.mX5WebView.getVisibleTitleHeight();
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollX();
    }
    return this.mSysWebView.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.isX5Core) {
      return this.mX5WebView.getView().getScrollY();
    }
    return this.mSysWebView.getScrollY();
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  IX5WebViewBase getX5WebView()
  {
    return this.mX5WebView;
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.isX5Core) {
      return null;
    }
    return this.mX5WebView.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.isX5Core) {
      return (View)ReflectionUtils.invokeInstance(this.mSysWebView, "getZoomControls");
    }
    return this.mX5WebView.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBack();
      return;
    }
    this.mX5WebView.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goBackOrForward(paramInt);
      return;
    }
    this.mX5WebView.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.goForward();
      return;
    }
    this.mX5WebView.goForward();
  }
  
  public void hideSplashLogo()
  {
    if ((this.mSplashLogo != null) && (this.mSplashLogo.getVisibility() == 0))
    {
      this.mSplashLogo.setVisibility(8);
      this.mSplashLogo = null;
    }
  }
  
  public void invokeZoomPicker()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.invokeZoomPicker();
      return;
    }
    this.mX5WebView.invokeZoomPicker();
  }
  
  @TargetApi(11)
  public boolean isPrivateBrowsingEnable()
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        return this.mSysWebView.isPrivateBrowsingEnabled();
      }
      return false;
    }
    return this.mX5WebView.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.mX5WebView.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.mX5WebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.loadUrl(paramString);
      return;
    }
    this.mX5WebView.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 8) {
        this.mSysWebView.loadUrl(paramString, paramMap);
      }
      return;
    }
    this.mX5WebView.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    if (!this.mIsReported)
    {
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.isX5Core)
      {
        Bundle localBundle = this.mX5WebView.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua");
          str1 = localBundle.getString("lc");
        }
      }
      HttpUtils.doReport(this.mContext, str3, str2, str1, this.mPv, this.isX5Core);
      this.mIsReported = true;
    }
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onPause");
      return;
    }
    this.mX5WebView.onPause();
  }
  
  public void onResume()
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "onResume");
      return;
    }
    this.mX5WebView.onResume();
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.overlayHorizontalScrollbar();
    }
    return this.mX5WebView.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.isX5Core) {
      return this.mX5WebView.overlayVerticalScrollbar();
    }
    return this.mSysWebView.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageDown(paramBoolean);
    }
    return this.mX5WebView.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.isX5Core) {
      return this.mSysWebView.pageUp(paramBoolean);
    }
    return this.mX5WebView.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.pauseTimers();
      return;
    }
    this.mX5WebView.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.mX5WebView.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.reload();
      return;
    }
    this.mX5WebView.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.removeJavascriptInterface(paramString);
      return;
    }
    this.mX5WebView.removeJavascriptInterface(paramString);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.isX5Core)
    {
      localObject1 = this.mX5WebView.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.mSysWebView;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.mSysWebView;
    }
    return ((SystemWebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestFocusNodeHref(paramMessage);
      return;
    }
    this.mX5WebView.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.requestImageRef(paramMessage);
      return;
    }
    this.mX5WebView.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.restoreState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.resumeTimers();
      return;
    }
    this.mX5WebView.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.mX5WebView.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.isX5Core)
    {
      paramBundle = ReflectionUtils.invokeInstance(this.mSysWebView, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.mX5WebView.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.isX5Core) {
      return WebBackForwardList.wrap(this.mSysWebView.saveState(paramBundle));
    }
    return WebBackForwardList.wrap(this.mX5WebView.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.mSysWebView.saveWebArchive(paramString);
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.mSysWebView.saveWebArchive(paramString, paramBoolean, paramValueCallback);
      }
      return;
    }
    this.mX5WebView.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.isX5Core) {
      this.mSysWebView.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.mX5WebView.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setCertificate(paramSslCertificate);
      return;
    }
    this.mX5WebView.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.isX5Core) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
        }
      });
      return;
    }
    this.mX5WebView.setDownloadListener(new DownLoadListenerAdapter(this, paramDownloadListener, this.isX5Core));
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.mSysWebView.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          }
        });
      }
      return;
    }
    this.mX5WebView.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.mX5WebView.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setInitialScale(paramInt);
      return;
    }
    this.mX5WebView.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      ReflectionUtils.invokeInstance(this.mSysWebView, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.mX5WebView.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  @TargetApi(3)
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.mSysWebView.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.mX5WebView.setNetworkAvailable(paramBoolean);
  }
  
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    if (!this.isX5Core)
    {
      if (paramPictureListener == null)
      {
        this.mSysWebView.setPictureListener(null);
        return;
      }
      this.mSysWebView.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          WebView.this.setSysWebView(paramAnonymousWebView);
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        }
      });
      return;
    }
    if (paramPictureListener == null)
    {
      this.mX5WebView.setPictureListener(null);
      return;
    }
    this.mX5WebView.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        WebView.this.setX5WebView(paramAnonymousIX5WebViewBase);
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.isX5Core)
    {
      this.mX5WebView.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.mSysWebView.setScrollBarStyle(paramInt);
  }
  
  void setSysWebView(android.webkit.WebView paramWebView)
  {
    if (!this.isX5Core) {}
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.mX5WebView.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    SystemWebView localSystemWebView = null;
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebChromeClient == null) {}
      for (paramWebChromeClient = localSystemWebView;; paramWebChromeClient = new SmttWebChromeClient(SDKEngine.getInstance(true).wizard(), this, paramWebChromeClient))
      {
        localIX5WebViewBase.setWebChromeClient(paramWebChromeClient);
        return;
      }
    }
    localSystemWebView = this.mSysWebView;
    if (paramWebChromeClient == null) {}
    for (paramWebChromeClient = localIX5WebViewBase;; paramWebChromeClient = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localSystemWebView.setWebChromeClient(paramWebChromeClient);
      return;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    SystemWebView localSystemWebView = null;
    if (this.isX5Core)
    {
      localIX5WebViewBase = this.mX5WebView;
      if (paramWebViewClient == null) {}
      for (paramWebViewClient = localSystemWebView;; paramWebViewClient = new SmttWebViewClient(SDKEngine.getInstance(true).wizard(), this, paramWebViewClient))
      {
        localIX5WebViewBase.setWebViewClient(paramWebViewClient);
        return;
      }
    }
    localSystemWebView = this.mSysWebView;
    if (paramWebViewClient == null) {}
    for (paramWebViewClient = localIX5WebViewBase;; paramWebViewClient = new SystemWebViewClient(this, paramWebViewClient))
    {
      localSystemWebView.setWebViewClient(paramWebViewClient);
      return;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.isX5Core) {
      return;
    }
    this.mX5WebView.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  void setX5WebView(IX5WebViewBase paramIX5WebViewBase)
  {
    this.mX5WebView = paramIX5WebViewBase;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.isX5Core)
    {
      this.mSysWebView.stopLoading();
      return;
    }
    this.mX5WebView.stopLoading();
  }
  
  public boolean zoomIn()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomIn();
    }
    return this.mX5WebView.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.isX5Core) {
      return this.mSysWebView.zoomOut();
    }
    return this.mX5WebView.zoomOut();
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult mHitTestResultImpl;
    private android.webkit.WebView.HitTestResult mSysHitTestResult = null;
    
    public HitTestResult()
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = null;
      this.mSysHitTestResult = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.mHitTestResultImpl = paramHitTestResult;
      this.mSysHitTestResult = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.mHitTestResultImpl != null) {
        str = this.mHitTestResultImpl.getExtra();
      }
      while (this.mSysHitTestResult == null) {
        return str;
      }
      return this.mSysHitTestResult.getExtra();
    }
    
    public int getType()
    {
      int i = 0;
      if (this.mHitTestResultImpl != null) {
        i = this.mHitTestResultImpl.getType();
      }
      while (this.mSysHitTestResult == null) {
        return i;
      }
      return this.mSysHitTestResult.getType();
    }
    
    public void setExtra(String paramString)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setExtra(paramString);
      }
    }
    
    public void setType(int paramInt)
    {
      if (this.mHitTestResultImpl != null) {
        this.mHitTestResultImpl.setType(paramInt);
      }
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  private class SystemWebView
    extends android.webkit.WebView
  {
    public SystemWebView(Context paramContext)
    {
      super();
      CookieSyncManager.createInstance(WebView.this.mContext).startSync();
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
        return;
      }
      catch (Exception this$1) {}
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.mIsDayMode) && (WebView.mNightModePaint != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.mNightModePaint);
          paramCanvas.restore();
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.this.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
  }
  
  public class WebViewTransport
  {
    private WebView mWebview;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.mWebview;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.mWebview = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */