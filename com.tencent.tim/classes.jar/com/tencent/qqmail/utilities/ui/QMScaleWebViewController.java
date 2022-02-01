package com.tencent.qqmail.utilities.ui;

import Override;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebView.HitTestResult;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.InlineImage.delaystream.DelayCidInputStream;
import com.tencent.qqmail.InlineImage.delaystream.DelayHttpInputStream;
import com.tencent.qqmail.InlineImage.fetcher.InlineImagePathHelper;
import com.tencent.qqmail.InlineImage.timing.ReadMailTimer;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.activity.webviewexplorer.InlineImageSaver;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.loader.MailContentLoader;
import com.tencent.qqmail.model.mail.loader.MailContentLoaderCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.TitleBarWebView2;
import com.tencent.qqmail.view.TitleBarWebView2.OnScrollListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"NewApi"})
public class QMScaleWebViewController
{
  private static final String TAG = "QMScaleWebViewCtrlr";
  private static final int WEBVIEW_CACHE_MAXSIZE = 8388608;
  private static final String WEBVIEW_ENCODING = "utf-8";
  private static final String WEBVIEW_MIME_TYPE = "text/html";
  private boolean isDeath = false;
  private Activity mActivity;
  private ViewGroup mContainer;
  private final ConcurrentHashMap<String, String> mImagePathInfo = new ConcurrentHashMap(16, 0.9F, 1);
  private boolean mIsHTMLLoaded = false;
  private boolean mIsScale = false;
  private Boolean mIsWebViewEmpty = Boolean.valueOf(true);
  private MailContentLoaderCallback mLoadCallback;
  private MailContentLoader mLoader;
  private TitleBarWebView2.OnScrollListener mOnScrollListener;
  private float mPageWidth;
  private ViewGroup mTitleBar;
  private ViewGroup mToolBar;
  private ITranslateCallBack mTranslateCallBack;
  private TitleBarWebView2 mWebView;
  private Mail mail;
  private Object primaryClipChangedListener = null;
  
  static
  {
    if (!QMScaleWebViewController.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public QMScaleWebViewController(Activity paramActivity, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.primaryClipChangedListener = new QMScaleWebViewController.3(this);
    }
    this.mLoadCallback = new QMScaleWebViewController.7(this);
    this.mOnScrollListener = null;
    assert (paramActivity != null);
    assert (paramViewGroup1 != null);
    this.mActivity = paramActivity;
    this.mContainer = paramViewGroup1;
    this.mTitleBar = paramViewGroup2;
    this.mToolBar = paramViewGroup3;
  }
  
  private boolean qqmailDomainResource(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.contains("mail.qq.com/cgi-bin")) && (!paramString.contains("exmail.qq.com/cgi-bin"))) {
      return false;
    }
    return true;
  }
  
  public void clear()
  {
    if (this.mWebView != null) {
      this.mWebView.loadUrl("about:blank");
    }
    TitleBarWebView2 localTitleBarWebView2 = this.mWebView;
    this.mWebView = null;
    if (localTitleBarWebView2 != null)
    {
      QMLog.log(2, "QMScaleWebViewCtrlr", "toolbar clear:" + this.mToolBar);
      if (this.mToolBar != null) {
        this.mToolBar.setVisibility(8);
      }
      if (localTitleBarWebView2.getSettings() == null) {}
    }
    try
    {
      localTitleBarWebView2.getSettings().setJavaScriptEnabled(false);
      localTitleBarWebView2.loadDataWithBaseURL(null, "", "text/html", "utf-8", "");
      localTitleBarWebView2.setEmbeddedTitleBarCompat(null);
      localTitleBarWebView2.setEmbeddedToolBarCompat(null);
      localTitleBarWebView2.setWebViewClient(null);
      localTitleBarWebView2.setOnClickListener(null);
      localTitleBarWebView2.setOnLongClickListener(null);
      localTitleBarWebView2.setOnTouchListener(null);
      localTitleBarWebView2.removeAllViews();
      localTitleBarWebView2.clearHistory();
      localTitleBarWebView2.setVisibility(8);
      localTitleBarWebView2.postDelayed(new QMScaleWebViewController.4(this, localTitleBarWebView2), ViewConfiguration.getZoomControlsTimeout() + 1000L);
      this.mImagePathInfo.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMScaleWebViewCtrlr", "setJavaScriptEnabled fail:" + localException.toString());
      }
    }
  }
  
  public void clearHtml()
  {
    if (this.mWebView != null)
    {
      Log.v("QMScaleWebView", "clearhtml");
      this.mIsWebViewEmpty = Boolean.valueOf(true);
      clearResourceLoader();
      this.mImagePathInfo.clear();
      this.mIsHTMLLoaded = false;
      if (this.mWebView.getSettings() != null) {
        this.mWebView.getSettings().setJavaScriptEnabled(false);
      }
      this.mWebView.stopLoading();
      this.mWebView.clearView();
      this.mWebView.loadUrl("about:blank");
    }
  }
  
  public void clearResourceLoader()
  {
    if (this.mLoader != null)
    {
      this.mLoader.destroy();
      this.mLoader = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void destroy()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      CommUtils.removePrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)this.primaryClipChangedListener);
      this.primaryClipChangedListener = null;
    }
    clear();
    this.mActivity = null;
    this.mContainer = null;
    this.mTitleBar = null;
    this.mToolBar = null;
    clearResourceLoader();
  }
  
  public void downloadResource()
  {
    if (this.mLoader != null) {
      this.mLoader.start();
    }
  }
  
  public void execJs(String paramString)
  {
    Threads.runOnMainThread(new QMScaleWebViewController.6(this, paramString));
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public float getPageWidth()
  {
    return this.mPageWidth;
  }
  
  public MailContentLoader getResourceLoader()
  {
    return this.mLoader;
  }
  
  public String[] getScaleInfo(long paramLong)
  {
    String[] arrayOfString = QMMailManager.sharedInstance().readMailContentScale(paramLong);
    if (arrayOfString == null) {}
    String str;
    do
    {
      return null;
      str = arrayOfString[0];
    } while (str == "");
    if (!"1".equals(str))
    {
      QMMailManager.sharedInstance().saveMailContentScale(paramLong, "", "", "", "");
      return null;
    }
    return arrayOfString;
  }
  
  public int getScrollY()
  {
    if (this.mWebView == null) {
      return 0;
    }
    return this.mWebView.getScrollY();
  }
  
  public TitleBarWebView2 getWebView()
  {
    return this.mWebView;
  }
  
  public void hideScrollbar()
  {
    if (this.mWebView != null)
    {
      this.mWebView.setVerticalScrollBarEnabled(false);
      this.mWebView.setHorizontalScrollBarEnabled(false);
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
  public void init()
  {
    clear();
    this.mWebView = TitleBarWebView2.getInstance(this.mActivity);
    if (this.mTitleBar != null) {
      this.mWebView.setEmbeddedTitleBarCompat(this.mTitleBar);
    }
    QMLog.log(4, "QMScaleWebViewCtrlr", "toolbar init:" + this.mToolBar);
    if (this.mToolBar != null) {
      this.mWebView.setEmbeddedToolBarCompat(this.mToolBar);
    }
    this.mWebView.requestFocus(130);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.mWebView.setScaleDensity(((DisplayMetrics)localObject).scaledDensity);
    this.mPageWidth = (((DisplayMetrics)localObject).widthPixels / ((DisplayMetrics)localObject).scaledDensity);
    this.mWebView.setVerticalScrollBarEnabled(false);
    this.mWebView.setHorizontalScrollBarEnabled(false);
    localObject = this.mWebView.getSettings();
    ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
    ((WebSettings)localObject).setLoadsImagesAutomatically(false);
    ((WebSettings)localObject).setSupportZoom(false);
    ((WebSettings)localObject).setBuiltInZoomControls(false);
    ((WebSettings)localObject).setDefaultTextEncodingName("utf-8");
    ((WebSettings)localObject).setUseWideViewPort(true);
    ((WebSettings)localObject).setCacheMode(2);
    ((WebSettings)localObject).setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    this.mContainer.addView(this.mWebView);
    this.mWebView.setOnClickListener(new QMScaleWebViewController.1(this));
    this.mWebView.setOnScrollChanged(this.mOnScrollListener);
    this.mWebView.setOnTouchListener(new QMScaleWebViewController.2(this));
    if (Build.VERSION.SDK_INT >= 11) {
      CommUtils.addPrimaryClipChangedListener((ClipboardManager.OnPrimaryClipChangedListener)this.primaryClipChangedListener);
    }
  }
  
  public Boolean isBigContent(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 8000)) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public boolean isDeath()
  {
    return this.isDeath;
  }
  
  public boolean isHTMLLoaded()
  {
    return this.mIsHTMLLoaded;
  }
  
  public boolean isScale()
  {
    return this.mIsScale;
  }
  
  public boolean isWebViewTitleVisible()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mWebView != null)
    {
      bool1 = bool2;
      if (this.mWebView.getVisibleTitleHeightCompat() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void loadHTML(String paramString1, String paramString2)
  {
    if ((this.mWebView != null) && (this.mWebView.getSettings() != null))
    {
      QMLog.log(4, "QMScaleWebViewCtrlr", "loadHTML");
      setDeath(true);
    }
    try
    {
      this.mWebView.getSettings().setJavaScriptEnabled(true);
      this.mIsWebViewEmpty = Boolean.valueOf(false);
      this.mIsHTMLLoaded = true;
      QMLog.log(4, "QMScaleWebViewCtrlr", "Begin load mail");
      this.mWebView.clearCache(false);
      InlineImagePathHelper.url_path_map.clear();
      this.mWebView.loadDataWithBaseURL(paramString1, paramString2, "text/html", "utf-8", null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, "QMScaleWebViewCtrlr", "webview enable js failed", localException);
      }
    }
  }
  
  public String parseScaleInfo(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    if (paramString.equals("scale")) {
      paramArrayOfString = paramArrayOfString[1];
    }
    for (;;)
    {
      if (paramArrayOfString != null)
      {
        paramString = paramArrayOfString;
        if (!paramArrayOfString.equals("")) {}
      }
      else
      {
        paramString = null;
      }
      return paramString;
      if (paramString.equals("contentWidth")) {
        paramArrayOfString = paramArrayOfString[2];
      } else if (paramString.equals("content")) {
        paramArrayOfString = paramArrayOfString[3];
      } else {
        paramArrayOfString = null;
      }
    }
  }
  
  public String reFormatHtml(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replaceAll("(?i)<table([> ])", "<div class='qmTableArea'>$0").replaceAll("(?i)<\\/table>", "</table></div>");
  }
  
  public void reflow()
  {
    execJs("reflowAndRepaint();");
  }
  
  public void resetIsScale()
  {
    this.mIsScale = false;
  }
  
  public void setDeath(boolean paramBoolean)
  {
    this.isDeath = paramBoolean;
  }
  
  public void setJavascriptInterface(QMScaleWebViewJavascriptInterface paramQMScaleWebViewJavascriptInterface)
  {
    TitleBarWebView2 localTitleBarWebView2 = this.mWebView;
    if (localTitleBarWebView2 == null) {
      return;
    }
    localTitleBarWebView2.addJavascriptInterface(paramQMScaleWebViewJavascriptInterface, "App");
  }
  
  public void setMail(Mail paramMail)
  {
    this.mail = paramMail;
  }
  
  public void setOnLongClickListener(QMScaleWebViewLongClickSaverListener paramQMScaleWebViewLongClickSaverListener)
  {
    this.mWebView.setOnLongClickListener(paramQMScaleWebViewLongClickSaverListener);
  }
  
  public void setOnScrollChanged(TitleBarWebView2.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
    if (this.mWebView != null) {
      this.mWebView.setOnScrollChanged(paramOnScrollListener);
    }
  }
  
  public void setResourceLoader(MailContentLoader paramMailContentLoader)
  {
    clearResourceLoader();
    this.mLoader = paramMailContentLoader;
    this.mLoader.setCallback(this.mLoadCallback);
  }
  
  public void setTitleBar(ViewGroup paramViewGroup)
  {
    this.mTitleBar = paramViewGroup;
    if (this.mWebView != null) {
      this.mWebView.setEmbeddedTitleBarCompat(this.mTitleBar);
    }
  }
  
  public void setToolBar(ViewGroup paramViewGroup)
  {
    this.mToolBar = paramViewGroup;
    QMLog.log(4, "QMScaleWebViewCtrlr", "toolbar setToolBar:" + this.mToolBar);
    if (this.mWebView != null) {
      this.mWebView.setEmbeddedToolBarCompat(this.mToolBar);
    }
  }
  
  public void setTranslateCallBack(ITranslateCallBack paramITranslateCallBack)
  {
    this.mTranslateCallBack = paramITranslateCallBack;
  }
  
  public void setWebViewClient(QMScaleWebViewClient paramQMScaleWebViewClient)
  {
    TitleBarWebView2 localTitleBarWebView2 = this.mWebView;
    if (localTitleBarWebView2 == null) {
      return;
    }
    localTitleBarWebView2.setWebViewClient(paramQMScaleWebViewClient);
    if ((paramQMScaleWebViewClient != null) && (Build.VERSION.SDK_INT >= 11))
    {
      localTitleBarWebView2.setWebChromeClient(new QMScaleWebViewController.5(this));
      return;
    }
    localTitleBarWebView2.setWebChromeClient(null);
  }
  
  public void smoothScrollYTo(int paramInt)
  {
    if (this.mWebView != null) {
      this.mWebView.smoothScrollTo(this.mWebView.getScrollX(), paramInt, -1);
    }
  }
  
  public class QMScaleWebViewClient
    extends BaseSafeWebViewClient
  {
    public QMScaleWebViewClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      Log.v("QMScaleWebView", "onPageFinished url=" + paramString);
      if ((paramWebView != null) && (paramWebView.getSettings() != null)) {
        paramWebView.getSettings().setLoadsImagesAutomatically(true);
      }
      ReadMailTimer.updateLastTime();
      QMLog.log(4, "QMScaleWebViewCtrlr", "Finish load mail");
      super.onSafePageFinished(paramWebView, paramString);
    }
    
    public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      Log.v("QMScaleWebView", "onSafePageStarted url=" + paramString);
      super.onSafePageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      QMLog.log(5, "QMScaleWebViewCtrlr", "onSafeReceivedError description = " + paramString1 + " failingUrl =" + paramString2);
      super.onSafeReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    @TargetApi(21)
    public WebResourceResponse shouldSafeInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      if ((VersionUtils.hasLolipop()) && (paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null))
      {
        if ((paramWebResourceRequest.getUrl().getHost() != null) && (!paramWebResourceRequest.getUrl().getHost().endsWith("qq.com"))) {
          return null;
        }
        if ((paramWebResourceRequest.getRequestHeaders() != null) && (!QMScaleWebViewController.this.qqmailDomainResource(paramWebResourceRequest.getUrl().toString())))
        {
          String str = (String)paramWebResourceRequest.getRequestHeaders().get("Accept");
          Log.i("QMScaleWebViewCtrlr", "Intercept acceptType " + str + " url = " + paramWebResourceRequest.getUrl());
          if ((!TextUtils.isEmpty(str)) && (!str.startsWith("image"))) {
            return null;
          }
        }
      }
      return super.shouldSafeInterceptRequest(paramWebView, paramWebResourceRequest);
    }
    
    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldSafeInterceptRequest(WebView paramWebView, String paramString)
    {
      Log.i("QMScaleWebViewCtrlr", "shouldSafeInterceptRequest " + paramString);
      if (paramString.startsWith("http"))
      {
        int j = -1;
        int i = j;
        if (QMScaleWebViewController.this.mail != null)
        {
          i = j;
          if (QMScaleWebViewController.this.mail.getInformation() != null) {
            i = QMScaleWebViewController.this.mail.getInformation().getAccountId();
          }
        }
        return new WebResourceResponse("", "utf-8", new DelayHttpInputStream(paramString, i));
      }
      if (paramString.startsWith("cid")) {
        return new WebResourceResponse("", "utf-8", new DelayCidInputStream(paramString, QMScaleWebViewController.this.mail));
      }
      return null;
    }
    
    public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (QMScaleWebViewController.this.mActivity == null) {
        return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
      }
      return false;
    }
  }
  
  public abstract class QMScaleWebViewJavascriptInterface
    extends com.tencent.qqmail.view.JavascriptInterface
  {
    public static final String SCALE_VERSION = "1";
    
    public QMScaleWebViewJavascriptInterface() {}
    
    @android.webkit.JavascriptInterface
    public void finish(String paramString)
    {
      Threads.runOnMainThread(new QMScaleWebViewController.QMScaleWebViewJavascriptInterface.3(this));
      Log.v("QMScaleWebView", "Javascript call finish modifyContent=" + paramString);
      if ((paramString != null) && (!paramString.equals("")) && (QMScaleWebViewController.this.mTranslateCallBack != null) && (!QMScaleWebViewController.this.mTranslateCallBack.isInTranslateMode()))
      {
        long l = getScaleInfoId();
        if (l != 0L)
        {
          Log.v("QMScaleWebView", "Javascript saveMailContentScale id=" + l);
          QMMailManager.sharedInstance().saveMailContentScale(l, "1", null, null, paramString);
        }
      }
    }
    
    @android.webkit.JavascriptInterface
    public void getButtonClicked(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
    
    @android.webkit.JavascriptInterface
    public String getImageCachePath(String paramString)
    {
      MailContentLoader localMailContentLoader = QMScaleWebViewController.this.mLoader;
      if ((!QMScaleWebViewController.this.mIsWebViewEmpty.booleanValue()) && (paramString != null) && (localMailContentLoader != null))
      {
        if (paramString == null) {
          return "";
        }
        String[] arrayOfString = paramString.split("#;#");
        StringBuilder localStringBuilder1 = new StringBuilder();
        int i = 1;
        if (i < arrayOfString.length)
        {
          String str = localMailContentLoader.getCacheImagePath(arrayOfString[i]);
          if (!"".equals(str))
          {
            StringBuilder localStringBuilder2 = new StringBuilder().append("ImageCache exist:");
            if (!TextUtils.isEmpty(arrayOfString[i]))
            {
              paramString = arrayOfString[i];
              label111:
              QMLog.log(4, "QMScaleWebViewCtrlr", paramString + " ; " + str);
              paramString = ImageUtil.checkPathSuffix(str);
              localStringBuilder1.append("#;#");
              if (!paramString.startsWith("file://")) {
                break label179;
              }
              localStringBuilder1.append(paramString);
            }
          }
          for (;;)
          {
            i += 2;
            break;
            paramString = "null";
            break label111;
            label179:
            localStringBuilder1.append("file://").append(paramString);
            continue;
            localStringBuilder1.append("#;#");
            QMLog.log(4, "QMScaleWebViewCtrlr", "ImageCache not exist:" + arrayOfString[(i - 1)] + " -> " + arrayOfString[i]);
            QMScaleWebViewController.this.mImagePathInfo.put(arrayOfString[(i - 1)], arrayOfString[i]);
          }
        }
        return localStringBuilder1.toString();
      }
      return "break";
    }
    
    @android.webkit.JavascriptInterface
    public void getMailContentHtml(String paramString) {}
    
    @android.webkit.JavascriptInterface
    public void getPlainText(String paramString) {}
    
    /* Error */
    @android.webkit.JavascriptInterface
    public float getScale()
    {
      // Byte code:
      //   0: iconst_1
      //   1: newarray float
      //   3: astore_2
      //   4: aload_2
      //   5: iconst_0
      //   6: ldc 176
      //   8: fastore
      //   9: new 178	com/tencent/qqmail/utilities/ui/QMScaleWebViewController$QMScaleWebViewJavascriptInterface$1
      //   12: dup
      //   13: aload_0
      //   14: aload_2
      //   15: invokespecial 181	com/tencent/qqmail/utilities/ui/QMScaleWebViewController$QMScaleWebViewJavascriptInterface$1:<init>	(Lcom/tencent/qqmail/utilities/ui/QMScaleWebViewController$QMScaleWebViewJavascriptInterface;[F)V
      //   18: invokestatic 35	com/tencent/qqmail/utilities/thread/Threads:runOnMainThread	(Ljava/lang/Runnable;)V
      //   21: aload_2
      //   22: monitorenter
      //   23: aload_2
      //   24: iconst_0
      //   25: faload
      //   26: ldc 176
      //   28: fcmpg
      //   29: ifge +11 -> 40
      //   32: aload_2
      //   33: iconst_0
      //   34: faload
      //   35: fstore_1
      //   36: aload_2
      //   37: monitorexit
      //   38: fload_1
      //   39: freturn
      //   40: aload_2
      //   41: iconst_0
      //   42: fconst_0
      //   43: fastore
      //   44: aload_2
      //   45: ldc2_w 182
      //   48: invokevirtual 189	java/lang/Object:wait	(J)V
      //   51: aload_2
      //   52: iconst_0
      //   53: faload
      //   54: fstore_1
      //   55: aload_2
      //   56: monitorexit
      //   57: fload_1
      //   58: freturn
      //   59: astore_3
      //   60: aload_2
      //   61: monitorexit
      //   62: aload_3
      //   63: athrow
      //   64: astore_3
      //   65: goto -14 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	QMScaleWebViewJavascriptInterface
      //   35	23	1	f	float
      //   3	58	2	arrayOfFloat	float[]
      //   59	4	3	localObject	Object
      //   64	1	3	localInterruptedException	java.lang.InterruptedException
      // Exception table:
      //   from	to	target	type
      //   36	38	59	finally
      //   44	51	59	finally
      //   55	57	59	finally
      //   60	62	59	finally
      //   44	51	64	java/lang/InterruptedException
    }
    
    @android.webkit.JavascriptInterface
    public long getScaleInfoId()
    {
      return 0L;
    }
    
    @android.webkit.JavascriptInterface
    public int getTitleBarHeight()
    {
      if (QMScaleWebViewController.this.mWebView != null) {
        return QMScaleWebViewController.this.mWebView.getWebViewTitleBarHeight();
      }
      return 0;
    }
    
    @android.webkit.JavascriptInterface
    public void hideLoadingTip() {}
    
    @android.webkit.JavascriptInterface
    public void isContainAudio(boolean paramBoolean) {}
    
    @android.webkit.JavascriptInterface
    public void playAudio(String paramString1, String paramString2, String paramString3) {}
    
    @android.webkit.JavascriptInterface
    public void resetContentHeight()
    {
      QMScaleWebViewController.this.setDeath(false);
      StringBuilder localStringBuilder = new StringBuilder().append("resetContentHeight: ");
      if (QMScaleWebViewController.this.mWebView != null) {}
      for (Integer localInteger = Integer.valueOf(QMScaleWebViewController.this.mWebView.hashCode());; localInteger = null)
      {
        Log.d("QMScaleWebView", localInteger);
        QMLog.log(4, "QMScaleWebViewCtrlr", "resetContentHeight");
        Threads.runOnMainThread(new QMScaleWebViewController.QMScaleWebViewJavascriptInterface.2(this));
        return;
      }
    }
    
    @android.webkit.JavascriptInterface
    public void saveScale(float paramFloat, long paramLong)
    {
      long l = getScaleInfoId();
      if (l != 0L) {
        QMMailManager.sharedInstance().saveMailContentScale(l, "1", String.valueOf(paramFloat), String.valueOf(paramLong), null);
      }
    }
    
    @android.webkit.JavascriptInterface
    public void selectionRange(int paramInt)
    {
      Threads.runOnMainThread(new QMScaleWebViewController.QMScaleWebViewJavascriptInterface.5(this, paramInt));
    }
    
    @android.webkit.JavascriptInterface
    public void setLoadsImagesAutomatically() {}
    
    @android.webkit.JavascriptInterface
    public void setRealContentHeight(float paramFloat)
    {
      if (QMScaleWebViewController.this.mWebView != null) {
        QMScaleWebViewController.this.mWebView.setRealContentHeight(paramFloat);
      }
    }
    
    @android.webkit.JavascriptInterface
    public void showToolBar()
    {
      Threads.runOnMainThread(new QMScaleWebViewController.QMScaleWebViewJavascriptInterface.4(this));
    }
  }
  
  public class QMScaleWebViewLongClickSaverListener
    implements View.OnLongClickListener
  {
    public QMScaleWebViewLongClickSaverListener() {}
    
    public boolean onLongClick(View paramView)
    {
      try
      {
        Object localObject = ((TitleBarWebView2)paramView).getHitTestResult();
        if ((localObject != null) && (((WebView.HitTestResult)localObject).getExtra() != null) && (QMScaleWebViewController.this.mActivity != null))
        {
          int i = ((WebView.HitTestResult)localObject).getType();
          if ((i == 5) || (i == 8))
          {
            localObject = ((WebView.HitTestResult)localObject).getExtra();
            String str;
            if (((String)localObject).startsWith("file://"))
            {
              str = ((String)localObject).replace("file://", "");
              i = str.indexOf("?");
              localObject = str;
              if (i <= 0) {}
            }
            for (localObject = str.substring(0, i);; localObject = InlineImagePathHelper.get((String)localObject))
            {
              QMLog.log(4, "QMScaleWebViewCtrlr", "Save-inline-longclick savepath: " + (String)localObject);
              OneStepUtils.dragImageByOneStep(paramView, (String)localObject);
              new InlineImageSaver((String)localObject, InlineImagePathHelper.url_path_map, QMScaleWebViewController.this.mActivity, new QMScaleWebViewController.QMScaleWebViewLongClickSaverListener.1(this)).show();
              return false;
            }
          }
        }
        return false;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController
 * JD-Core Version:    0.7.0.1
 */