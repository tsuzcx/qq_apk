package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.TitleOptionMenu;
import java.lang.reflect.Method;

public abstract class EmbedWebBaseActivity
  extends BaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  protected boolean alsoShowMenu;
  private boolean backevent;
  protected TextView backtext;
  protected TextView closetext;
  private boolean firstload = true;
  private ImageView iamgeView;
  private View.OnClickListener mBrowserCloseListener = new dm(this);
  private View.OnClickListener mBrowserListener = new dl(this);
  private final WebChromeClient mChromeClient = new di(this);
  private DownloadListener mDownloadlistener = new dk(this);
  boolean mIsRefreshing;
  private View.OnClickListener mRightTitleButtonClickListener = new dd(this);
  protected TitleOptionMenu mTitleMenu;
  private final View.OnTouchListener mTouchListener = new dj(this);
  protected IWXAPI mWeChatApi;
  public WebView mWebView;
  private final WebViewClient mWebviewClient = new dg(this);
  private FrameLayout root;
  public String sharetitle;
  public String shareurl;
  private String sig;
  
  private Bitmap captureWebView(WebView paramWebView)
  {
    paramWebView = paramWebView.capturePicture();
    if ((paramWebView == null) || (paramWebView.getWidth() <= 0) || (paramWebView.getHeight() <= 0)) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramWebView.getWidth(), paramWebView.getHeight(), Bitmap.Config.ARGB_8888);
    paramWebView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  private void initUI()
  {
    this.backtext = ((TextView)findViewById(2131297146));
    if (this.backtext != null) {
      this.backtext.setVisibility(0);
    }
    ((RelativeLayout)findViewById(2131297145)).setOnClickListener(this.mBrowserListener);
    this.closetext = ((TextView)findViewById(2131297147));
    this.closetext.setOnClickListener(this.mBrowserCloseListener);
  }
  
  private void initWebView()
  {
    this.root = ((FrameLayout)findViewById(2131296415));
    this.mWebView = ((WebView)findViewById(2131297302));
    this.mWebView.setWebViewClient(this.mWebviewClient);
    this.mWebView.setWebChromeClient(this.mChromeClient);
    this.mWebView.setOnTouchListener(this.mTouchListener);
    this.mWebView.setDownloadListener(this.mDownloadlistener);
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setUserAgentString("android");
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setNeedInitialFocus(false);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setSupportZoom(false);
  }
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131361808, getString(2131362386), 2131361812, 2131361813, new df(this), null);
  }
  
  private void startAnim(WebView paramWebView)
  {
    if (this.iamgeView == null)
    {
      this.iamgeView = new ImageView(this);
      paramWebView.setDrawingCacheEnabled(true);
      localObject = captureWebView(paramWebView);
      if (localObject != null) {
        this.iamgeView.setImageBitmap((Bitmap)localObject);
      }
      this.iamgeView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      this.root.addView(this.iamgeView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.backevent)
    {
      localObject = AnimationUtils.loadAnimation(this, 2130837973);
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setDetachWallpaper(true);
      this.iamgeView.setAnimation((Animation)localObject);
      ((Animation)localObject).setAnimationListener(new dh(this));
      if (!this.backevent) {
        break label180;
      }
    }
    label180:
    for (Object localObject = AnimationUtils.loadAnimation(this, 2130837971);; localObject = AnimationUtils.loadAnimation(this, 2130837970))
    {
      ((Animation)localObject).setFillAfter(true);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setDetachWallpaper(true);
      paramWebView.setAnimation((Animation)localObject);
      this.backevent = false;
      return;
      localObject = AnimationUtils.loadAnimation(this, 2130837972);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903257);
    initWebView();
    initUI();
    try
    {
      paramBundle = this.mWebView.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
      if (paramBundle != null) {
        paramBundle.invoke(this.mWebView, new Object[] { "searchBoxJavaBridge_" });
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        e.c("removeJavascriptInterface error: " + paramBundle.getMessage());
      }
    }
    setRightTitleImage(2130837953, this.mRightTitleButtonClickListener);
    this.mTitleMenu = getDialogMenu();
    if (this.mTitleMenu != null) {
      this.mTitleMenu.a(5);
    }
    if (this.mRightOptionLayout != null) {
      this.mRightOptionLayout.setVisibility(8);
    }
    this.mWeChatApi = WXAPIFactory.createWXAPI(this, "wx68451b483ebd18ce", false);
    this.mWeChatApi.registerApp("wx68451b483ebd18ce");
  }
  
  public boolean overrideUrlLoading(String paramString)
  {
    return false;
  }
  
  public void setBackTextColor(int paramInt)
  {
    if (this.backtext != null) {
      this.backtext.setTextColor(paramInt);
    }
    if (this.closetext != null) {
      this.closetext.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EmbedWebBaseActivity
 * JD-Core Version:    0.7.0.1
 */