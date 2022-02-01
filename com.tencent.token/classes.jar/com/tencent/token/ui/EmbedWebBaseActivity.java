package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.bv;
import com.tencent.token.global.g;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.TitleOptionMenu.a;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import java.lang.reflect.Method;

public abstract class EmbedWebBaseActivity
  extends BaseActivity
{
  private static final int TIMELINE_SUPPORTED_VERSION = 553779201;
  protected boolean alsoShowMenu;
  protected TextView backtext;
  protected TextView closetext;
  private View.OnClickListener mBrowserCloseListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      EmbedWebBaseActivity.this.finish();
    }
  };
  private View.OnClickListener mBrowserListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (EmbedWebBaseActivity.this.mWebView.canGoBack())
      {
        EmbedWebBaseActivity.this.mWebView.goBack();
        return;
      }
      EmbedWebBaseActivity.this.finish();
    }
  };
  private final WebChromeClient mChromeClient = new WebChromeClient()
  {
    public boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
    {
      try
      {
        paramAnonymousWebView = new StringBuilder();
        paramAnonymousWebView.append("onJsPrompt message=");
        paramAnonymousWebView.append(paramAnonymousString2);
        g.a(paramAnonymousWebView.toString());
        if ((EmbedWebBaseActivity.this.shareurl != null) && (EmbedWebBaseActivity.this.shareurl.contains("mobile_reset_psw_uv_verify")))
        {
          paramAnonymousWebView = new Intent();
          paramAnonymousWebView.putExtra("sppkey", paramAnonymousString2);
          EmbedWebBaseActivity.this.setResult(-1, paramAnonymousWebView);
          EmbedWebBaseActivity.this.finish();
        }
      }
      catch (Exception paramAnonymousWebView)
      {
        paramAnonymousWebView.printStackTrace();
      }
      paramAnonymousJsPromptResult.cancel();
      return true;
    }
    
    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {}
    
    public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      if ((paramAnonymousWebView.getUrl() != null) && (paramAnonymousWebView.getUrl().contains("sec_headline_content")))
      {
        EmbedWebBaseActivity localEmbedWebBaseActivity = EmbedWebBaseActivity.this;
        localEmbedWebBaseActivity.sharetitle = paramAnonymousString;
        localEmbedWebBaseActivity.shareurl = paramAnonymousWebView.getUrl();
        EmbedWebBaseActivity.this.mRightOptionLayout.setVisibility(0);
        return;
      }
      EmbedWebBaseActivity.this.shareurl = paramAnonymousWebView.getUrl();
      if (!EmbedWebBaseActivity.this.alsoShowMenu) {
        EmbedWebBaseActivity.this.mRightOptionLayout.setVisibility(8);
      }
    }
  };
  private DownloadListener mDownloadlistener = new DownloadListener()
  {
    public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
    {
      l.a(EmbedWebBaseActivity.this, paramAnonymousString1);
    }
  };
  public boolean mDynamicTitle;
  private View.OnClickListener mRightTitleButtonClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      g.a("BaseActivityonItemClicked");
      if (EmbedWebBaseActivity.this.mTitleMenu.getVisibility() == 0)
      {
        EmbedWebBaseActivity.this.mTitleMenu.b();
        return;
      }
      EmbedWebBaseActivity.this.mTitleMenu.setOnItemClickedListener(new TitleOptionMenu.a()
      {
        public void a(int paramAnonymous2Int)
        {
          g.a("BaseActivityonItemClicked");
          Object localObject;
          SendMessageToWX.Req localReq;
          switch (paramAnonymous2Int)
          {
          default: 
            return;
          case 1: 
            if (EmbedWebBaseActivity.this.mWeChatApi.isWXAppInstalled())
            {
              if (EmbedWebBaseActivity.this.mWeChatApi.getWXAppSupportAPI() >= 553779201)
              {
                bv.a().a(System.currentTimeMillis(), 74);
                localObject = new WXWebpageObject();
                ((WXWebpageObject)localObject).webpageUrl = EmbedWebBaseActivity.this.shareurl;
                localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
                ((WXMediaMessage)localObject).title = EmbedWebBaseActivity.this.sharetitle;
                ((WXMediaMessage)localObject).description = EmbedWebBaseActivity.this.getResources().getString(2131493592);
                ((WXMediaMessage)localObject).setThumbImage(m.a(EmbedWebBaseActivity.this.getResources(), 2131100198));
                localReq = new SendMessageToWX.Req();
                localReq.transaction = String.valueOf(System.currentTimeMillis());
                localReq.message = ((WXMediaMessage)localObject);
                localReq.scene = 1;
                EmbedWebBaseActivity.this.mWeChatApi.sendReq(localReq);
                return;
              }
              EmbedWebBaseActivity.this.showToast(EmbedWebBaseActivity.this.getString(2131493588));
              return;
            }
            EmbedWebBaseActivity.this.showWechatBindDialog();
            return;
          }
          if (EmbedWebBaseActivity.this.mWeChatApi.isWXAppInstalled())
          {
            if (EmbedWebBaseActivity.this.mWeChatApi.getWXAppSupportAPI() >= 553779201)
            {
              bv.a().a(System.currentTimeMillis(), 74);
              localObject = new WXWebpageObject();
              ((WXWebpageObject)localObject).webpageUrl = EmbedWebBaseActivity.this.shareurl;
              localObject = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject);
              ((WXMediaMessage)localObject).title = EmbedWebBaseActivity.this.sharetitle;
              ((WXMediaMessage)localObject).description = EmbedWebBaseActivity.this.getResources().getString(2131493592);
              ((WXMediaMessage)localObject).setThumbImage(m.a(EmbedWebBaseActivity.this.getResources(), 2131100198));
              localReq = new SendMessageToWX.Req();
              localReq.transaction = String.valueOf(System.currentTimeMillis());
              localReq.message = ((WXMediaMessage)localObject);
              localReq.scene = 0;
              EmbedWebBaseActivity.this.mWeChatApi.sendReq(localReq);
              return;
            }
            EmbedWebBaseActivity.this.showToast(EmbedWebBaseActivity.this.getString(2131493588));
            return;
          }
          EmbedWebBaseActivity.this.showWechatBindDialog();
        }
      });
      EmbedWebBaseActivity.this.mTitleMenu.a();
    }
  };
  protected TitleOptionMenu mTitleMenu;
  private final View.OnTouchListener mTouchListener = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
  };
  protected IWXAPI mWeChatApi;
  public WebView mWebView;
  private final WebViewClient mWebviewClient = new WebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      g.c("onPageFinished");
      if (EmbedWebBaseActivity.this.mWebView.canGoBack()) {
        EmbedWebBaseActivity.this.closetext.setVisibility(0);
      } else {
        EmbedWebBaseActivity.this.closetext.setVisibility(4);
      }
      if ((paramAnonymousWebView != null) && (paramAnonymousWebView.getTitle() != null) && (paramAnonymousWebView.getTitle().length() > 0) && (EmbedWebBaseActivity.this.mDynamicTitle)) {
        EmbedWebBaseActivity.this.setTitle(paramAnonymousWebView.getTitle());
      }
    }
    
    public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap) {}
    
    public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError) {}
    
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      paramAnonymousWebView = new StringBuilder();
      paramAnonymousWebView.append("url");
      paramAnonymousWebView.append(paramAnonymousString);
      paramAnonymousWebView.append(",override=");
      g.a(paramAnonymousWebView.toString());
      return EmbedWebBaseActivity.this.overrideUrlLoading(paramAnonymousString);
    }
  };
  public String sharetitle;
  public String shareurl;
  
  private void initUI()
  {
    this.backtext = ((TextView)findViewById(2131165289));
    TextView localTextView = this.backtext;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    ((RelativeLayout)findViewById(2131165288)).setOnClickListener(this.mBrowserListener);
    this.closetext = ((TextView)findViewById(2131165383));
    this.closetext.setOnClickListener(this.mBrowserCloseListener);
  }
  
  private void initWebView()
  {
    this.mWebView = ((WebView)findViewById(2131166270));
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramString1);
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString()));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      g.b(paramString1.toString());
    }
  }
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131492986, getString(2131493579), 2131493437, 2131493408, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        try
        {
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.mm"));
          EmbedWebBaseActivity.this.startActivity(paramAnonymousDialogInterface);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          paramAnonymousDialogInterface.printStackTrace();
          g.b(paramAnonymousDialogInterface.toString());
        }
      }
    }, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      setContentView(2131296503);
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
        paramBundle.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeJavascriptInterface error: ");
        localStringBuilder.append(paramBundle.getMessage());
        g.c(localStringBuilder.toString());
      }
      setRightTitleImage(2131100162, this.mRightTitleButtonClickListener);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url");
      localStringBuilder.append(paramString);
      g.b(localStringBuilder.toString());
      sendBindUinSmsBySMSAPP(paramString.substring(4), "");
      return true;
    }
    if (paramString.startsWith("wtloginmqq://ptlogin/qlogin?p=http"))
    {
      l.a(this, paramString);
      return true;
    }
    return false;
  }
  
  public void setBackTextColor(int paramInt)
  {
    TextView localTextView = this.backtext;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    localTextView = this.closetext;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EmbedWebBaseActivity
 * JD-Core Version:    0.7.0.1
 */