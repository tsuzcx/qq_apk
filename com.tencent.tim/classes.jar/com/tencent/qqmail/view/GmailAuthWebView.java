package com.tencent.qqmail.view;

import Override;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.activity.webviewexplorer.BaseSafeWebViewClient;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProxy;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailAuthWebView
  extends SmoothScrollableWebView
{
  public static final String APPROVAL_CODE_HOST = "https://accounts.google.com/o/oauth2/approval";
  public static final String AUTH_CODE_HOST = "https://accounts.google.com/o/oauth2/auth";
  public static final String AUTH_REDIRECT = "com.tencent.androidqqmail:/oauth2redirect";
  public static final String AUTH_TOKEN_HOST = "https://accounts.google.com/o/oauth2/token";
  public static final String CANNOT_CONNECT_GMAIL_URI = "http://i.mail.qq.com/app/gmail_login_notsupport.html";
  public static final String CLIENT_ID = "146110540336-48ild167qte7b4rf3dlhq90jrj5ajujg.apps.googleusercontent.com";
  private static final long COUNT_DOWN_INTERVAL = 1000L;
  public static final String ID = "146110540336-48ild167qte7b4rf3dlhq90jrj5ajujg";
  private static final long MILLIS_INFUTURE = 25000L;
  private static final int PROGRESS_GONE = 1;
  private static final int PROGRESS_PROCESS = 0;
  public static final String REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
  public static final String SCOPE = "email profile https://mail.google.com https://www.google.com/m8/feeds https://www.googleapis.com/auth/calendar";
  public static final String SERVICE_LOGIN_HOST = "https://accounts.google.com/ServiceLogin";
  public static final String SUCCESS_CODE = "Success code=";
  private static final String TAG = "GmailAuthWebView";
  private String email;
  private boolean isWebviewLoadError = false;
  private AnimationDrawable mAnimationDrawable;
  private Bitmap mBackgroundBitmap;
  private ImageView mBackgroundView;
  private ImageView mLoadingView;
  private ProgressBar mProgressBar;
  private ProgressHandler mProgressBarHandler;
  private QMProxy mProxy;
  private QMTopBar mTopBar;
  private String processCode = null;
  private CountDownTimer timer;
  
  public GmailAuthWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GmailAuthWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap buildBackgroundCache()
  {
    QMLog.log(4, "GmailAuthWebView", "build cache");
    try
    {
      destroyDrawingCache();
      setDrawingCacheEnabled(true);
      buildDrawingCache();
      if (this.mBackgroundBitmap != null) {
        this.mBackgroundBitmap.recycle();
      }
      this.mBackgroundBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      Object localObject = new Canvas(this.mBackgroundBitmap);
      Paint localPaint = new Paint();
      ((Canvas)localObject).drawBitmap(this.mBackgroundBitmap, 0.0F, this.mBackgroundBitmap.getHeight(), localPaint);
      draw((Canvas)localObject);
      setDrawingCacheEnabled(false);
      destroyDrawingCache();
      localObject = this.mBackgroundBitmap;
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "GmailAuthWebView", localException.getMessage());
    }
    return null;
  }
  
  private String getGoogleAuthScope()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = "email profile https://mail.google.com https://www.google.com/m8/feeds https://www.googleapis.com/auth/calendar".split(" ");
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (i == arrayOfString.length - 1) {
        localStringBuilder.append(arrayOfString[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(arrayOfString[i]).append("%20");
      }
    }
    return localStringBuilder.toString();
  }
  
  private String getGoogleAuthUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://accounts.google.com/o/oauth2/auth");
    localStringBuilder.append("?scope=" + getGoogleAuthScope());
    localStringBuilder.append("&response_type=code");
    localStringBuilder.append("&redirect_uri=urn:ietf:wg:oauth:2.0:oob");
    localStringBuilder.append("&client_id=146110540336-48ild167qte7b4rf3dlhq90jrj5ajujg.apps.googleusercontent.com");
    return localStringBuilder.toString();
  }
  
  private Drawable getLoadingBitmap(int paramInt)
  {
    label293:
    for (;;)
    {
      try
      {
        int i = QMUIKit.dpToPx(36);
        Object localObject2 = "QMLoading:" + i + ":" + paramInt + ":" + -8224126;
        Object localObject1 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject2);
        if (localObject1 == null)
        {
          localObject1 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
          ImageDownloadManager.shareInstance().addMemoryCache((String)localObject2, (Bitmap)localObject1);
          int j = i / 12;
          int k = i / 6;
          localObject2 = new Paint();
          ((Paint)localObject2).setAntiAlias(true);
          ((Paint)localObject2).setColor(-8224126);
          ((Paint)localObject2).setStrokeWidth(j);
          ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
          Canvas localCanvas = new Canvas((Bitmap)localObject1);
          localCanvas.rotate(paramInt, i / 2, i / 2);
          localCanvas.translate(i / 2, i / 2);
          paramInt = 0;
          if (paramInt >= 12) {
            break label293;
          }
          localCanvas.rotate(30.0F);
          ((Paint)localObject2).setAlpha((int)((paramInt + 1) * 255 / 12.0F));
          localCanvas.translate(0.0F, -i / 2 + j / 2);
          localCanvas.drawLine(0.0F, 0.0F, 0.0F, k, (Paint)localObject2);
          localCanvas.translate(0.0F, i / 2 - j / 2);
          paramInt += 1;
          continue;
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "GmailAuthWebView", localException.getMessage());
        return null;
      }
    }
  }
  
  private void initData()
  {
    this.mProxy = QMProxyUtil.getGmailHttpProxy();
    this.mProgressBarHandler = new ProgressHandler(null);
  }
  
  private void initWebview()
  {
    WebviewUtilities.clearAllCookie();
    WebSettings localWebSettings = getSettings();
    try
    {
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setDefaultTextEncodingName("GBK");
      localWebSettings.setSaveFormData(false);
      localWebSettings.setSavePassword(false);
      localWebSettings.setUseWideViewPort(true);
      setUserAgent(localWebSettings);
      setInitialScale(1);
      QMProxyUtil.setProxy(this, this.mProxy);
      setWebChromeClient(new GmailWebChromeClient(null));
      setWebViewClient(new ProxyWebViewClient(null));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, "GmailAuthWebView", "setJavaScriptEnabled", localException);
      }
    }
  }
  
  private void setUserAgent(WebSettings paramWebSettings)
  {
    String str = QMSettingManager.sharedInstance().getGmailWebViewUserAgent();
    if (!TextUtils.isEmpty(str))
    {
      paramWebSettings.setUserAgentString(str);
      QMLog.log(4, "GmailAuthWebView", "set user agent:" + paramWebSettings.getUserAgentString());
      return;
    }
    str = paramWebSettings.getUserAgentString();
    Matcher localMatcher1 = Pattern.compile("Version\\/[.0-9]* ").matcher(str);
    Matcher localMatcher2 = Pattern.compile("Chrome\\/[.0-9]* ").matcher(str);
    if (localMatcher1.find()) {
      if (!localMatcher2.find()) {
        break label108;
      }
    }
    label108:
    for (str = localMatcher1.replaceAll("");; str = localMatcher1.replaceAll("Chrome/30.0.0.0"))
    {
      paramWebSettings.setUserAgentString(str);
      break;
    }
  }
  
  private void startTimer()
  {
    if (this.timer != null) {
      this.timer.cancel();
    }
    this.timer = new GmailAuthWebView.1(this, 25000L, 1000L);
    this.timer.start();
  }
  
  private void updateTopbarLoading(boolean paramBoolean)
  {
    if (this.mTopBar != null) {
      this.mTopBar.showLoading(paramBoolean);
    }
  }
  
  private void updateTopbarTitle(String paramString)
  {
    if ((this.mTopBar != null) && (paramString != null) && (!paramString.startsWith("Success code=")) && (!paramString.equals(""))) {
      this.mTopBar.setTitle(paramString);
    }
  }
  
  public void backToLogin()
  {
    initWebview();
    loadGoolgeAuthUrl();
  }
  
  public void init()
  {
    initData();
    initWebview();
  }
  
  public void loadGoolgeAuthUrl()
  {
    loadUrl(getGoogleAuthUrl());
  }
  
  public void release()
  {
    try
    {
      QMProxyUtil.resetProxy(this);
      if (this.mBackgroundBitmap != null)
      {
        this.mBackgroundBitmap.recycle();
        this.mBackgroundBitmap = null;
      }
      if (this.mAnimationDrawable != null)
      {
        this.mAnimationDrawable.stop();
        this.mAnimationDrawable = null;
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "GmailAuthWebView", localException.getMessage());
    }
  }
  
  public void setBackgroundViewImage(ImageView paramImageView)
  {
    this.mBackgroundView = paramImageView;
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setLoadingView(ImageView paramImageView)
  {
    this.mLoadingView = paramImageView;
  }
  
  public void setProgressBar(ProgressBar paramProgressBar)
  {
    this.mProgressBar = paramProgressBar;
  }
  
  public void setTopBar(QMTopBar paramQMTopBar)
  {
    this.mTopBar = paramQMTopBar;
  }
  
  class GmailWebChromeClient
    extends WebChromeClient
  {
    private GmailWebChromeClient() {}
    
    @Override
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
        return true;
      }
      return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
      super.onProgressChanged(paramWebView, paramInt);
      if (paramInt >= GmailAuthWebView.ProgressHandler.access$700(GmailAuthWebView.this.mProgressBarHandler)) {
        GmailAuthWebView.this.mProgressBarHandler.postProgressHandler(0, paramInt, 100);
      }
    }
  }
  
  class ProgressHandler
    extends Handler
  {
    private ObjectAnimator mAnimator;
    private int mDstProgressIndex;
    private int mDuration;
    
    private ProgressHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        this.mDstProgressIndex = paramMessage.arg1;
        this.mDuration = paramMessage.arg2;
        GmailAuthWebView.this.mProgressBar.setVisibility(0);
        if ((this.mAnimator != null) && (this.mAnimator.isRunning())) {
          this.mAnimator.cancel();
        }
        this.mAnimator = ObjectAnimator.ofInt(GmailAuthWebView.this.mProgressBar, "progress", new int[] { this.mDstProgressIndex });
        this.mAnimator.setDuration(this.mDuration);
        this.mAnimator.addListener(new GmailAuthWebView.ProgressHandler.1(this));
        this.mAnimator.start();
        return;
      }
      this.mDstProgressIndex = 0;
      this.mDuration = 0;
      GmailAuthWebView.this.mProgressBar.setProgress(0);
      GmailAuthWebView.this.mProgressBar.setVisibility(8);
      if ((this.mAnimator != null) && (this.mAnimator.isRunning())) {
        this.mAnimator.cancel();
      }
      this.mAnimator = ObjectAnimator.ofInt(GmailAuthWebView.this.mProgressBar, "progress", new int[] { 0 });
      this.mAnimator.setDuration(0L);
      this.mAnimator.removeAllListeners();
    }
    
    public void postProgressHandler(int paramInt1, int paramInt2, int paramInt3)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      GmailAuthWebView.this.mProgressBarHandler.sendMessage(localMessage);
    }
  }
  
  class ProxyWebViewClient
    extends BaseSafeWebViewClient
  {
    private HashSet<String> errorUrlSet = new HashSet();
    
    private ProxyWebViewClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("ssl error ");
      if (paramSslError != null) {}
      for (paramWebView = paramSslError.getUrl();; paramWebView = "")
      {
        QMLog.log(4, "GmailAuthWebView", paramWebView);
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(GmailAuthWebView.this.getContext()).setMessage(2131721841).addAction(2131691246, new GmailAuthWebView.ProxyWebViewClient.4(this))).addAction(2131721842, new GmailAuthWebView.ProxyWebViewClient.3(this, paramSslErrorHandler))).create().show();
        return;
      }
    }
    
    public void onSafeLoadResource(WebView paramWebView, String paramString)
    {
      super.onSafeLoadResource(paramWebView, paramString);
      QMLog.log(4, "GmailAuthWebView", "onLoadResource url: " + paramString);
      if (paramString.startsWith("https://accounts.google.com/o/oauth2/auth")) {
        GmailAuthWebView.this.startTimer();
      }
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      if (GmailAuthWebView.this.timer != null) {
        GmailAuthWebView.this.timer.cancel();
      }
      super.onSafePageFinished(paramWebView, paramString);
      String str = paramWebView.getTitle();
      QMLog.log(4, "GmailAuthWebView", "OnPageFinished, title: " + str + ", url: " + paramString);
      GmailAuthWebView.this.updateTopbarTitle(str);
      GmailAuthWebView.this.mProgressBarHandler.postProgressHandler(1, 100, 0);
      if (paramString.startsWith("https://accounts.google.com/o/oauth2/approval")) {
        if (str.contains("Success code="))
        {
          paramWebView = paramWebView.getTitle().substring(paramWebView.getTitle().indexOf("=") + 1);
          if (!paramWebView.equals(GmailAuthWebView.this.processCode)) {}
        }
      }
      label622:
      do
      {
        do
        {
          return;
          GmailAuthWebView.access$1602(GmailAuthWebView.this, paramWebView);
          LoginManager.shareInstance().getGMailAccessToken(paramWebView);
          GmailAuthWebView.this.updateTopbarTitle(QMApplicationContext.sharedInstance().getString(2131689708));
          GmailAuthWebView.this.updateTopbarLoading(true);
          for (;;)
          {
            if (!this.errorUrlSet.contains(paramString)) {
              break label622;
            }
            this.errorUrlSet.remove(paramString);
            QMLog.log(6, "GmailAuthWebView", "url request error, url:" + paramString);
            if (!paramString.startsWith("https://accounts.google.com/o/oauth2/auth")) {
              break;
            }
            DataCollector.logDetailEvent("DetailEvent_Gmail_Open_Loginpage", 0L, 1L, "open gmail login pase error");
            return;
            QMLog.log(6, "GmailAuthWebView", "get code error");
            GmailAuthWebView.this.backToLogin();
            continue;
            if (paramString.startsWith("https://accounts.google.com/o/oauth2/auth"))
            {
              if (Build.VERSION.SDK_INT < 19) {
                GmailAuthWebView.this.loadUrl("javascript:" + "var ogb = document.getElementById('ogb'); if(ogb){ogb.style.display = 'none';}");
              } else {
                try
                {
                  GmailAuthWebView.this.evaluateJavascript("var ogb = document.getElementById('ogb'); if(ogb){ogb.style.display = 'none';}", new GmailAuthWebView.ProxyWebViewClient.1(this));
                }
                catch (IllegalStateException paramWebView)
                {
                  GmailAuthWebView.this.loadUrl("javascript:" + "var ogb = document.getElementById('ogb'); if(ogb){ogb.style.display = 'none';}");
                }
              }
            }
            else if (paramString.startsWith("https://accounts.google.com/ServiceLogin"))
            {
              if ((GmailAuthWebView.this.mBackgroundView != null) && (GmailAuthWebView.this.mBackgroundView.getVisibility() == 0))
              {
                GmailAuthWebView.this.mBackgroundView.setVisibility(8);
                GmailAuthWebView.this.setVisibility(0);
              }
              if ((GmailAuthWebView.this.mLoadingView != null) && (GmailAuthWebView.this.mLoadingView.getVisibility() == 0))
              {
                GmailAuthWebView.this.mLoadingView.setVisibility(8);
                GmailAuthWebView.this.setVisibility(0);
              }
              if ((GmailAuthWebView.this.email != null) && (!GmailAuthWebView.this.email.equals("")))
              {
                paramWebView = "var email = document.getElementById('Email'); email.value='" + GmailAuthWebView.this.email + "'";
                if (Build.VERSION.SDK_INT < 19) {
                  GmailAuthWebView.this.loadUrl("javascript:" + paramWebView);
                } else {
                  try
                  {
                    GmailAuthWebView.this.evaluateJavascript(paramWebView, new GmailAuthWebView.ProxyWebViewClient.2(this));
                  }
                  catch (IllegalStateException localIllegalStateException)
                  {
                    GmailAuthWebView.this.loadUrl("javascript:" + paramWebView);
                  }
                }
              }
            }
          }
        } while (!paramString.startsWith("https://accounts.google.com/ServiceLogin"));
        DataCollector.logDetailEvent("DetailEvent_Gmail_Open_Accesspage", 0L, 1L, "open access login pase error");
        return;
        QMLog.log(4, "GmailAuthWebView", "url request success, url:" + paramString);
        if (paramString.startsWith("https://accounts.google.com/ServiceLogin"))
        {
          DataCollector.logDetailEvent("DetailEvent_Gmail_Open_Loginpage", 0L, 0L, "open gmail login pase success");
          return;
        }
      } while (!paramString.startsWith("https://accounts.google.com/o/oauth2/auth"));
      DataCollector.logDetailEvent("DetailEvent_Gmail_Open_Accesspage", 0L, 0L, "open gmail access pase success");
    }
    
    public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      int i = 0;
      super.onSafePageStarted(paramWebView, paramString, paramBitmap);
      QMLog.log(4, "GmailAuthWebView", "onPageStarted, title: " + paramWebView.getTitle() + ", url: " + paramString);
      GmailAuthWebView.this.updateTopbarTitle(paramWebView.getTitle());
      if (!GmailAuthWebView.this.isWebviewLoadError) {
        GmailAuthWebView.this.mProgressBarHandler.postProgressHandler(0, 30, 500);
      }
      if ((!StringExtention.isNullOrEmpty(paramString)) && (paramString.startsWith("https://accounts.google.com/o/oauth2/approval")) && (GmailAuthWebView.this.mBackgroundView != null) && (GmailAuthWebView.this.mLoadingView != null))
      {
        paramWebView = GmailAuthWebView.this.buildBackgroundCache();
        if (paramWebView != null)
        {
          GmailAuthWebView.this.mLoadingView.setVisibility(8);
          GmailAuthWebView.this.mBackgroundView.setVisibility(0);
          GmailAuthWebView.this.mBackgroundView.setImageBitmap(paramWebView);
          QMLog.log(4, "GmailAuthWebView", "show snapshot");
          GmailAuthWebView.this.setVisibility(8);
        }
      }
      else
      {
        return;
      }
      GmailAuthWebView.this.mBackgroundView.setVisibility(8);
      GmailAuthWebView.this.mLoadingView.setVisibility(0);
      if (GmailAuthWebView.this.mAnimationDrawable != null) {
        GmailAuthWebView.this.mAnimationDrawable.stop();
      }
      GmailAuthWebView.access$1202(GmailAuthWebView.this, new AnimationDrawable());
      GmailAuthWebView.this.mAnimationDrawable.setOneShot(false);
      while (i < 12)
      {
        GmailAuthWebView.this.mAnimationDrawable.addFrame(GmailAuthWebView.this.getLoadingBitmap(i * 30), 50);
        i += 1;
      }
      if (Build.VERSION.SDK_INT < 16) {
        GmailAuthWebView.this.mLoadingView.setBackgroundDrawable(GmailAuthWebView.this.mAnimationDrawable);
      }
      for (;;)
      {
        GmailAuthWebView.this.mAnimationDrawable.start();
        QMLog.log(4, "GmailAuthWebView", "show loading");
        break;
        GmailAuthWebView.this.mLoadingView.setBackground(GmailAuthWebView.this.mAnimationDrawable);
      }
    }
    
    public void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onSafeReceivedError(paramWebView, paramInt, paramString1, paramString2);
      QMLog.log(4, "GmailAuthWebView", "onReceivedError url: " + paramString2);
      this.errorUrlSet.add(paramString2);
      if (!GmailAuthWebView.this.isWebviewLoadError)
      {
        GmailAuthWebView.this.loadUrl("http://i.mail.qq.com/app/gmail_login_notsupport.html");
        GmailAuthWebView.this.mProgressBarHandler.postProgressHandler(0, 100, 500);
        GmailAuthWebView.access$502(GmailAuthWebView.this, true);
      }
    }
    
    public void onSafeReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
    {
      QMLog.log(4, "GmailAuthWebView", "onReceivedHttpAuthRequest host: " + paramString1 + " realm:" + paramString2);
      if (GmailAuthWebView.this.mProxy != null)
      {
        paramHttpAuthHandler.proceed(GmailAuthWebView.this.mProxy.getProxyUserName(), GmailAuthWebView.this.mProxy.getProxyPassword());
        return;
      }
      QMLog.log(5, "GmailAuthWebView", "qmproxy null");
    }
    
    public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      QMLog.log(4, "GmailAuthWebView", "shouldOverrideUrlLoading url: " + paramString);
      GmailAuthWebView.this.updateTopbarTitle(paramWebView.getTitle());
      return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.GmailAuthWebView
 * JD-Core Version:    0.7.0.1
 */