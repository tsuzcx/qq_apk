package com.tencent.qqmail.activity.webviewexplorer;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.WebviewUtilities;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PopupMenuAdapter;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.view.ProgressHandler;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;

public class BasicWebViewExplorer
  extends BaseActivityEx
{
  protected static final String ARG_URL = "arg_url";
  private static final String TAG = "BasicWebViewExplorer";
  protected QMPopupWindow mMoreActionWindow;
  protected ProgressBar mProgressBar;
  protected ProgressHandler mProgressBarHandler;
  protected QMTopBar topBar;
  protected String url;
  protected QMWebView webView;
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), BasicWebViewExplorer.class);
    localIntent.putExtra("arg_url", paramString);
    return localIntent;
  }
  
  public void initDataSource()
  {
    this.mProgressBarHandler = new ProgressHandler(this.mProgressBar);
    this.url = getIntent().getStringExtra("arg_url");
  }
  
  public void initDom()
  {
    initTopBar();
    initWebView();
  }
  
  protected void initTopBar()
  {
    this.topBar.setCenterOnclickListener(new BasicWebViewExplorer.1(this));
    this.topBar.setButtonLeftIcon(2130841088);
    this.topBar.setButtonLeftOnclickListener(new BasicWebViewExplorer.2(this));
    this.topBar.setButtonRightIcon(2130841095);
    this.topBar.getButtonRight().setOnClickListener(new BasicWebViewExplorer.3(this));
    this.topBar.setTitle("");
  }
  
  public void initUI()
  {
    setContentView(2131563338);
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.webView = ((QMWebView)findViewById(2131382171));
    this.mProgressBar = ((ProgressBar)findViewById(2131373700));
  }
  
  protected void initWebView()
  {
    WebviewUtilities.initWebViewSetting(this.webView);
    WebviewUtilities.setCookies(this.url, WebviewUtilities.getCookies(this.url));
    this.webView.setWebChromeClient(new BasicWebChromeClient());
    this.webView.setWebViewClient(new BasicWebViewClient());
    this.webView.setDownloadListener(new WebViewDownloadListener(this));
    this.webView.requestFocus(130);
    this.webView.loadUrl(this.url);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mMoreActionWindow != null) {
      this.mMoreActionWindow.dismiss();
    }
  }
  
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
  
  protected void showMoreDialogPopup(View paramView)
  {
    paramView = new BasicWebViewExplorer.4(this, this, paramView, new PopupMenuAdapter(this, QMPopupWindow.praseShareMenuItem(2131886080, this)));
    paramView.showDown();
    this.mMoreActionWindow = paramView;
  }
  
  protected void updateTopBarTitle(String paramString)
  {
    if ((paramString != null) && (this.topBar != null)) {
      this.topBar.setTitle(paramString);
    }
  }
  
  public class BasicWebChromeClient
    extends WebChromeClient
  {
    protected BasicWebChromeClient() {}
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      QMLog.log(4, "BasicWebViewExplorer", "onConsoleMessage : " + paramConsoleMessage.message());
      return super.onConsoleMessage(paramConsoleMessage);
    }
    
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
      if (paramInt > BasicWebViewExplorer.this.mProgressBarHandler.getDstProgressIndex()) {
        BasicWebViewExplorer.this.mProgressBarHandler.postProgressHandler(0, paramInt, 100);
      }
    }
  }
  
  public class BasicWebViewClient
    extends BaseSafeWebViewClient
  {
    protected BasicWebViewClient() {}
    
    @Override
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      JsInjector.getInstance().onPageStarted(paramWebView);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onSafePageFinished(WebView paramWebView, String paramString)
    {
      super.onSafePageFinished(paramWebView, paramString);
      QMLog.log(4, "BasicWebViewExplorer", "onPageFinished " + paramString);
      BasicWebViewExplorer.this.mProgressBarHandler.postProgressHandler(1, 100, 0);
      BasicWebViewExplorer.this.updateTopBarTitle(BasicWebViewExplorer.this.webView.getTitle());
    }
    
    public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onSafePageStarted(paramWebView, paramString, paramBitmap);
      QMLog.log(4, "BasicWebViewExplorer", "onPageStarted " + paramString);
      if (BasicWebViewExplorer.this.mProgressBarHandler.getDstProgressIndex() == 0) {
        BasicWebViewExplorer.this.mProgressBarHandler.postProgressHandler(0, 30, 500);
      }
    }
    
    public void onSafeReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onSafeReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      QMLog.log(4, "BasicWebViewExplorer", "shouldOverrideUrlLoading " + paramString);
      return super.shouldSafeOverrideUrlLoading(paramWebView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.BasicWebViewExplorer
 * JD-Core Version:    0.7.0.1
 */