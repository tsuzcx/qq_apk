package com.tencent.qqmail.activity.webviewexplorer;

import Override;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileDefine;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;

public class CardWebViewExplorer
  extends BaseActivityEx
{
  protected static final String ARG_URL = "arg_url";
  public static final String READ_CARD_URL = "qumas.mail.qq.com/cgi-bin/uma_read_card";
  private static final String TAG = "BasicWebViewExplorer";
  protected QMTopBar topBar;
  protected String url;
  protected QMWebView webView;
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CardWebViewExplorer.class);
    localIntent.putExtra("arg_url", paramString);
    return localIntent;
  }
  
  public void initDataSource()
  {
    this.url = getIntent().getStringExtra("arg_url");
  }
  
  public void initDom()
  {
    initTopBar();
    initWebView();
  }
  
  protected void initTopBar()
  {
    this.topBar.setBackgroundColor(0);
    this.topBar.setButtonLeftBack(2130840867);
    this.topBar.setButtonLeftOnclickListener(new CardWebViewExplorer.1(this));
  }
  
  public void initUI()
  {
    setRequestedOrientation(1);
    setContentView(2131558829);
    this.topBar = ((QMTopBar)findViewById(2131380043));
    this.webView = ((QMWebView)findViewById(2131382171));
  }
  
  protected void initWebView()
  {
    WebSettings localWebSettings = this.webView.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setDefaultTextEncodingName("UTF-8");
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setAppCacheMaxSize(8388608L);
    if (FileUtil.hasSdcard()) {
      localWebSettings.setAppCachePath(QMPathManager.sharedInstance().getQQMailCacheDir());
    }
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + " mailapp/" + AppConfig.getCodeVersionName());
    if (Build.VERSION.SDK_INT < 19) {
      localWebSettings.setDatabasePath(FileDefine.INNER_DATA_DIR + "/databases/");
    }
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    QMUIHelper.setZoomControlGone(this.webView);
    this.webView.setWebViewClient(new BaseWebViewClient());
    this.webView.requestFocus(130);
    this.webView.loadUrl(this.url);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.webView != null) && (this.webView.canGoBack()))
    {
      this.webView.goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRelease()
  {
    if (this.webView != null)
    {
      this.webView.stopLoading();
      if (this.webView.getParent() != null) {
        ((ViewGroup)this.webView.getParent()).removeView(this.webView);
      }
      this.webView.destroy();
    }
  }
  
  public void refreshData() {}
  
  public void render() {}
  
  public class BaseWebViewClient
    extends BaseSafeWebViewClient
  {
    protected BaseWebViewClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.CardWebViewExplorer
 * JD-Core Version:    0.7.0.1
 */