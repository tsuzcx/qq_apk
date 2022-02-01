package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
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
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXMediaMessage.a;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.token.aay;
import com.tencent.token.aaz;
import com.tencent.token.qg;
import com.tencent.token.qh.a;
import com.tencent.token.qi;
import com.tencent.token.so;
import com.tencent.token.ui.base.TitleOptionMenu;
import com.tencent.token.ui.base.TitleOptionMenu.a;
import com.tencent.token.xv;
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
    public final void onClick(View paramAnonymousView)
    {
      EmbedWebBaseActivity.this.finish();
    }
  };
  private View.OnClickListener mBrowserListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
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
    public final boolean onJsPrompt(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, JsPromptResult paramAnonymousJsPromptResult)
    {
      try
      {
        xv.a("onJsPrompt message=".concat(String.valueOf(paramAnonymousString2)));
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
    
    public final void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {}
    
    public final void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString)
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
    public final void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
    {
      aay.a(EmbedWebBaseActivity.this, paramAnonymousString1);
    }
  };
  public boolean mDynamicTitle;
  String mPageStartUrl;
  private View.OnClickListener mRightTitleButtonClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      xv.a("BaseActivityonItemClicked");
      if (EmbedWebBaseActivity.this.mTitleMenu.getVisibility() == 0)
      {
        EmbedWebBaseActivity.this.mTitleMenu.b();
        return;
      }
      EmbedWebBaseActivity.this.mTitleMenu.setOnItemClickedListener(new TitleOptionMenu.a()
      {
        public final void a(int paramAnonymous2Int)
        {
          xv.a("BaseActivityonItemClicked");
          Object localObject;
          qh.a locala;
          switch (paramAnonymous2Int)
          {
          default: 
            return;
          case 1: 
            if (EmbedWebBaseActivity.this.mWeChatApi.a())
            {
              if (EmbedWebBaseActivity.this.mWeChatApi.b() >= 553779201)
              {
                so.a().a(System.currentTimeMillis(), 74);
                localObject = new WXWebpageObject();
                ((WXWebpageObject)localObject).webpageUrl = EmbedWebBaseActivity.this.shareurl;
                localObject = new WXMediaMessage((WXMediaMessage.a)localObject);
                ((WXMediaMessage)localObject).title = EmbedWebBaseActivity.this.sharetitle;
                ((WXMediaMessage)localObject).description = EmbedWebBaseActivity.this.getResources().getString(2131493601);
                ((WXMediaMessage)localObject).setThumbImage(aaz.a(EmbedWebBaseActivity.this.getResources(), 2131100207));
                locala = new qh.a();
                locala.a = String.valueOf(System.currentTimeMillis());
                locala.b = ((WXMediaMessage)localObject);
                locala.c = 1;
                EmbedWebBaseActivity.this.mWeChatApi.a(locala);
                return;
              }
              EmbedWebBaseActivity.this.showToast(EmbedWebBaseActivity.this.getString(2131493597));
              return;
            }
            EmbedWebBaseActivity.this.showWechatBindDialog();
            return;
          }
          if (EmbedWebBaseActivity.this.mWeChatApi.a())
          {
            if (EmbedWebBaseActivity.this.mWeChatApi.b() >= 553779201)
            {
              so.a().a(System.currentTimeMillis(), 74);
              localObject = new WXWebpageObject();
              ((WXWebpageObject)localObject).webpageUrl = EmbedWebBaseActivity.this.shareurl;
              localObject = new WXMediaMessage((WXMediaMessage.a)localObject);
              ((WXMediaMessage)localObject).title = EmbedWebBaseActivity.this.sharetitle;
              ((WXMediaMessage)localObject).description = EmbedWebBaseActivity.this.getResources().getString(2131493601);
              ((WXMediaMessage)localObject).setThumbImage(aaz.a(EmbedWebBaseActivity.this.getResources(), 2131100207));
              locala = new qh.a();
              locala.a = String.valueOf(System.currentTimeMillis());
              locala.b = ((WXMediaMessage)localObject);
              locala.c = 0;
              EmbedWebBaseActivity.this.mWeChatApi.a(locala);
              return;
            }
            EmbedWebBaseActivity.this.showToast(EmbedWebBaseActivity.this.getString(2131493597));
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
    public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
  };
  protected qg mWeChatApi;
  public WebView mWebView;
  private final WebViewClient mWebviewClient = new WebViewClient()
  {
    public final void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      xv.c("onPageFinished");
      if (EmbedWebBaseActivity.this.mWebView.canGoBack()) {
        EmbedWebBaseActivity.this.closetext.setVisibility(0);
      } else {
        EmbedWebBaseActivity.this.closetext.setVisibility(4);
      }
      if ((paramAnonymousWebView != null) && (paramAnonymousWebView.getTitle() != null) && (paramAnonymousWebView.getTitle().length() > 0) && (EmbedWebBaseActivity.this.mDynamicTitle)) {
        EmbedWebBaseActivity.this.setTitle(paramAnonymousWebView.getTitle());
      }
    }
    
    public final void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
      EmbedWebBaseActivity.this.mPageStartUrl = paramAnonymousString;
    }
    
    public final void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError) {}
    
    public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      paramAnonymousWebView = new StringBuilder("url");
      paramAnonymousWebView.append(paramAnonymousString);
      paramAnonymousWebView.append(",override=");
      xv.a(paramAnonymousWebView.toString());
      return EmbedWebBaseActivity.this.overrideUrlLoading(paramAnonymousString);
    }
  };
  public String sharetitle;
  public String shareurl;
  
  private void initUI()
  {
    this.backtext = ((TextView)findViewById(2131165296));
    TextView localTextView = this.backtext;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    ((RelativeLayout)findViewById(2131165295)).setOnClickListener(this.mBrowserListener);
    this.closetext = ((TextView)findViewById(2131165397));
    this.closetext.setOnClickListener(this.mBrowserCloseListener);
  }
  
  private void initWebView()
  {
    this.mWebView = ((WebView)findViewById(2131166325));
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
  }
  
  private void sendBindUinSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:".concat(String.valueOf(paramString1))));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      xv.b(paramString1.toString());
    }
  }
  
  private void showWechatBindDialog()
  {
    showUserDialog(2131492987, getString(2131493588), 2131493443, 2131493411, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
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
          xv.b(paramAnonymousDialogInterface.toString());
        }
      }
    }, null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      setContentView(2131296517);
      initWebView();
      initUI();
      int i = Build.VERSION.SDK_INT;
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
        StringBuilder localStringBuilder = new StringBuilder("removeJavascriptInterface error: ");
        localStringBuilder.append(paramBundle.getMessage());
        xv.c(localStringBuilder.toString());
      }
      setRightTitleImage(2131100171, this.mRightTitleButtonClickListener);
      this.mTitleMenu = getDialogMenu();
      if (this.mTitleMenu != null) {
        this.mTitleMenu.setDisplayMode(5);
      }
      if (this.mRightOptionLayout != null) {
        this.mRightOptionLayout.setVisibility(8);
      }
      this.mWeChatApi = qi.a(this, "wx58837a82c2e0ed15");
      this.mWeChatApi.a("wx58837a82c2e0ed15");
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
  }
  
  public boolean overrideUrlLoading(final String paramString)
  {
    if (paramString.startsWith("sms:"))
    {
      xv.b("url".concat(String.valueOf(paramString)));
      sendBindUinSmsBySMSAPP(paramString.substring(4), "");
      return true;
    }
    if ((!paramString.startsWith("wtloginmqq://ptlogin/qlogin?p=http")) && (!paramString.startsWith("weixin://"))) {
      return false;
    }
    showUserDialog(0, "即将离开QQ安全中心，打开其他应用", "取消", "允许", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        aay.a(EmbedWebBaseActivity.this, paramString);
      }
    });
    return true;
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