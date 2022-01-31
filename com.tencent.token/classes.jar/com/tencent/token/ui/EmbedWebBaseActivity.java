package com.tencent.token.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.utils.w;
import java.lang.reflect.Method;

public abstract class EmbedWebBaseActivity
  extends BaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  protected boolean alsoShowMenu;
  protected TextView backtext;
  protected TextView closetext;
  private View.OnClickListener mBrowserCloseListener = new eh(this);
  private View.OnClickListener mBrowserListener = new eg(this);
  private final WebChromeClient mChromeClient = new ed(this);
  private DownloadListener mDownloadlistener = new ef(this);
  public boolean mDynamicTitle;
  private View.OnClickListener mRightTitleButtonClickListener = new dz(this);
  protected TitleOptionMenu mTitleMenu;
  private final View.OnTouchListener mTouchListener = new ee(this);
  protected IWXAPI mWeChatApi;
  public WebView mWebView;
  private final WebViewClient mWebviewClient = new ec(this);
  public String sharetitle;
  public String shareurl;
  
  private void initUI()
  {
    this.backtext = ((TextView)findViewById(2131559305));
    if (this.backtext != null) {
      this.backtext.setVisibility(0);
    }
    ((RelativeLayout)findViewById(2131559304)).setOnClickListener(this.mBrowserListener);
    this.closetext = ((TextView)findViewById(2131559306));
    this.closetext.setOnClickListener(this.mBrowserCloseListener);
  }
  
  private void initWebView()
  {
    this.mWebView = ((WebView)findViewById(2131559463));
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
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setSupportMultipleWindows(true);
  }
  
  private void sendBindUinSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      h.b(paramString1.toString());
    }
  }
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131230843, getString(2131231435), 2131231294, 2131231265, new eb(this), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      setContentView(2130968822);
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
          h.c("removeJavascriptInterface error: " + paramBundle.getMessage());
        }
      }
      setRightTitleImage(2130838013, this.mRightTitleButtonClickListener);
      this.mTitleMenu = getDialogMenu();
      if (this.mTitleMenu != null) {
        this.mTitleMenu.setDisplayMode(5);
      }
      if (this.mRightOptionLayout != null) {
        this.mRightOptionLayout.setVisibility(8);
      }
      this.mWeChatApi = WXAPIFactory.createWXAPI(this, "wx68451b483ebd18ce", false);
      this.mWeChatApi.registerApp("wx68451b483ebd18ce");
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
  }
  
  public boolean overrideUrlLoading(String paramString)
  {
    if (paramString.startsWith("sms:"))
    {
      h.b("url" + paramString);
      sendBindUinSmsBySMSAPP(paramString.substring(4), "");
      return true;
    }
    if (paramString.startsWith("wtloginmqq://ptlogin/qlogin?p=http"))
    {
      w.a(this, paramString);
      return true;
    }
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