package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import java.lang.reflect.Method;

public final class kq
{
  private a a;
  private Context b;
  private String c;
  private WebView d;
  private String e;
  private int f;
  private final WebChromeClient g = new WebChromeClient()
  {
    public final void onCloseWindow(WebView paramAnonymousWebView)
    {
      super.onCloseWindow(paramAnonymousWebView);
    }
    
    public final boolean onCreateWindow(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage)
    {
      try
      {
        paramAnonymousWebView = new WebView(paramAnonymousWebView.getContext());
        try
        {
          if (Build.VERSION.SDK_INT >= 11)
          {
            paramAnonymousWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            paramAnonymousWebView.removeJavascriptInterface("accessibility");
            paramAnonymousWebView.removeJavascriptInterface("accessibilityTraversal");
          }
          else
          {
            Method localMethod = paramAnonymousWebView.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
            if (localMethod != null)
            {
              localMethod.invoke(paramAnonymousWebView, new Object[] { "searchBoxJavaBridge_" });
              localMethod.invoke(paramAnonymousWebView, new Object[] { "accessibility" });
              localMethod.invoke(paramAnonymousWebView, new Object[] { "accessibilityTraversal" });
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        paramAnonymousWebView.setWebViewClient(new WebViewClient()
        {
          public final boolean shouldOverrideUrlLoading(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            try
            {
              paramAnonymous2String = new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymous2String));
              paramAnonymous2String.addFlags(268435456);
              paramAnonymous2WebView.getContext().startActivity(paramAnonymous2String);
              return true;
            }
            catch (Exception paramAnonymous2WebView)
            {
              paramAnonymous2WebView.printStackTrace();
            }
            return true;
          }
        });
        ((WebView.WebViewTransport)paramAnonymousMessage.obj).setWebView(paramAnonymousWebView);
        paramAnonymousMessage.sendToTarget();
        return true;
      }
      catch (Exception paramAnonymousWebView)
      {
        paramAnonymousWebView.printStackTrace();
      }
      return true;
    }
    
    public final void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {}
    
    public final void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString) {}
  };
  private final WebViewClient h = new WebViewClient()
  {
    public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
    {
      Uri localUri = paramAnonymousWebResourceRequest.getUrl();
      if (localUri.getScheme().equals("tcwebscheme"))
      {
        kq.a(kq.this, localUri);
        return true;
      }
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      Uri localUri = Uri.parse(paramAnonymousString);
      if (localUri.getScheme().equals("tcwebscheme"))
      {
        kq.a(kq.this, localUri);
        return true;
      }
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
    }
  };
  
  public kq(Context paramContext, a parama, String paramString1, WebView paramWebView, String paramString2)
  {
    this.b = paramContext;
    this.a = parama;
    this.c = paramString1;
    this.d = paramWebView;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      this.e = paramString2;
    } else {
      this.e = "";
    }
    this.f = 140;
    if ((this.b != null) && (this.a != null))
    {
      this.d.getSettings().setDefaultTextEncodingName("UTF-8");
      this.d.setWebChromeClient(this.g);
      this.d.setWebViewClient(this.h);
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          this.d.removeJavascriptInterface("searchBoxJavaBridge_");
          this.d.removeJavascriptInterface("accessibility");
          this.d.removeJavascriptInterface("accessibilityTraversal");
        }
        else
        {
          paramContext = this.d.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
          if (paramContext != null)
          {
            paramContext.invoke(this.d, new Object[] { "searchBoxJavaBridge_" });
            paramContext.invoke(this.d, new Object[] { "accessibility" });
            paramContext.invoke(this.d, new Object[] { "accessibilityTraversal" });
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = this.d.getSettings();
      try
      {
        paramContext.setJavaScriptEnabled(true);
        paramContext.setJavaScriptCanOpenWindowsAutomatically(true);
        paramContext.setSupportMultipleWindows(true);
        paramContext.setNeedInitialFocus(false);
        parama = new StringBuilder();
        parama.append(paramContext.getUserAgentString());
        parama.append(" TCSDK/1.0.2");
        paramContext.setUserAgentString(parama.toString());
        paramContext.setAllowFileAccess(true);
        paramContext.setAppCacheEnabled(true);
        paramContext.setDomStorageEnabled(true);
        paramContext.setDatabaseEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().setAcceptThirdPartyCookies(this.d, true);
        }
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
      }
      paramContext.setBuiltInZoomControls(false);
      paramContext.setSupportZoom(false);
      if ((Build.VERSION.SDK_INT >= 19) && (a(this.b))) {
        try
        {
          WebView.setWebContentsDebuggingEnabled(true);
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext = new StringBuilder("file:///android_asset/tcaptcha_webview.html?appid=");
      paramContext.append(this.c);
      paramContext.append("&width=");
      paramContext.append(this.f);
      paramContext.append("&height=");
      paramContext.append(this.f);
      paramContext.append("&map=");
      paramContext.append(this.e);
      paramContext = paramContext.toString();
      this.d.loadUrl(paramContext);
    }
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      return (i & 0x2) != 0;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public final void a()
  {
    this.a = null;
    this.b = null;
    this.d = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kq
 * JD-Core Version:    0.7.0.1
 */