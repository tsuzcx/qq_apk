package com.tencent.captchasdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import org.json.JSONObject;

class d
{
  private a a;
  private Context b;
  private String c;
  private WebView d;
  private String e;
  private int f;
  private final WebChromeClient g = new WebChromeClient()
  {
    public void onCloseWindow(WebView paramAnonymousWebView)
    {
      super.onCloseWindow(paramAnonymousWebView);
    }
    
    public boolean onCreateWindow(WebView paramAnonymousWebView, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, Message paramAnonymousMessage)
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
          public boolean shouldOverrideUrlLoading(WebView paramAnonymous2WebView, String paramAnonymous2String)
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
    
    public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt) {}
    
    public void onReceivedTitle(WebView paramAnonymousWebView, String paramAnonymousString) {}
  };
  private final WebViewClient h = new WebViewClient()
  {
    @RequiresApi(api=21)
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
    {
      Uri localUri = paramAnonymousWebResourceRequest.getUrl();
      if (localUri.getScheme().equals("tcwebscheme"))
      {
        d.a(d.this, localUri);
        return true;
      }
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousWebResourceRequest);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      Uri localUri = Uri.parse(paramAnonymousString);
      if (localUri.getScheme().equals("tcwebscheme"))
      {
        d.a(d.this, localUri);
        return true;
      }
      return super.shouldOverrideUrlLoading(paramAnonymousWebView, paramAnonymousString);
    }
  };
  
  public d(Context paramContext, a parama, String paramString1, WebView paramWebView, String paramString2, int paramInt)
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
    if (paramInt > 0) {
      this.f = paramInt;
    } else {
      this.f = 100;
    }
    b();
  }
  
  private void a(Uri paramUri)
  {
    if (paramUri.getScheme().equals("tcwebscheme"))
    {
      if (paramUri.getAuthority().equals("callback")) {
        e(paramUri);
      }
      if (paramUri.getAuthority().equals("readyCallback")) {
        d(paramUri);
      }
      if (paramUri.getAuthority().equals("collectCallback")) {
        c(paramUri);
      }
      if (paramUri.getAuthority().equals("jserrorCallback")) {
        b(paramUri);
      }
    }
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      if ((i & 0x2) != 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private void b(Uri paramUri)
  {
    if (paramUri != null) {}
    try
    {
      if ((this.b == null) || (this.a == null)) {
        break label60;
      }
      this.a.a(-1001, URLDecoder.decode(paramUri.getQueryParameter("msg"), "utf-8"));
      return;
    }
    catch (Exception localException)
    {
      label42:
      label60:
      break label42;
    }
    this.a.a(-1001, paramUri.getQueryParameter("msg"));
  }
  
  private void c(Uri paramUri)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.b != null) && (paramUri != null)) {
      try
      {
        Object localObject = paramUri.getQueryParameter("list");
        String str = paramUri.getQueryParameter("callback");
        if ((localObject != null) && (paramUri.getQueryParameter("callback") != null) && (Integer.parseInt((String)localObject) > 0))
        {
          int i = Integer.parseInt((String)localObject);
          paramUri = new JSONObject();
          if ((i & 0x1) == 1)
          {
            c.a();
            paramUri.put("cpu_info", c.a);
            paramUri.put("cpu_hardware", c.b);
            paramUri.put("cpu_serial", c.c);
          }
          if ((i & 0x2) == 2) {
            paramUri.put("battery_level", c.a(this.b));
          }
          if ((i & 0x4) == 4)
          {
            paramUri.put("dpi", c.b(this.b));
            paramUri.put("width", c.c(this.b));
            paramUri.put("height", c.d(this.b));
          }
          if ((i & 0x8) == 8) {
            paramUri.put("sensor_flag", c.e(this.b));
          }
          if ((i & 0x10) == 16)
          {
            paramUri.put("network_type", c.a(this.b, 0));
            paramUri.put("network_operator_name", c.a(this.b, 1));
            paramUri.put("network_connection_type", c.a(this.b, 2));
          }
          if ((i & 0x20) == 32)
          {
            paramUri.put("wifi_ssid", c.b(this.b, 0));
            paramUri.put("wifi_bssid", c.b(this.b, 1));
            paramUri.put("wifi_connected", c.f(this.b));
          }
          if ((i & 0x40) == 64)
          {
            paramUri.put("band_version", c.b());
            paramUri.put("osname", c.e());
          }
          if ((i & 0x80) == 128)
          {
            paramUri.put("app_name", c.g(this.b));
            paramUri.put("app_version", c.h(this.b));
          }
          if ((i & 0x100) == 256) {
            paramUri.put("kernel_version", c.f());
          }
          if ((i & 0x200) == 512)
          {
            paramUri.put("is_emulator", c.c());
            paramUri.put("is_root", c.d());
          }
          if (paramUri.length() > 0)
          {
            paramUri.put("platform", "Android");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("javascript:window.");
            ((StringBuilder)localObject).append(str);
            ((StringBuilder)localObject).append("(");
            ((StringBuilder)localObject).append(paramUri.toString());
            ((StringBuilder)localObject).append(")");
            paramUri = ((StringBuilder)localObject).toString();
            this.d.evaluateJavascript(paramUri, new ValueCallback()
            {
              public void a(String paramAnonymousString) {}
            });
            return;
          }
        }
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
    }
  }
  
  private void d(Uri paramUri)
  {
    a locala = this.a;
    if (locala != null) {
      locala.a(Integer.parseInt(paramUri.getQueryParameter("width")), Integer.parseInt(paramUri.getQueryParameter("height")));
    }
  }
  
  private void e(Uri paramUri)
  {
    try
    {
      if (this.a == null) {
        break label45;
      }
      this.a.a(URLDecoder.decode(paramUri.getQueryParameter("retJson"), "utf-8"));
      return;
    }
    catch (Exception localException)
    {
      label29:
      label45:
      break label29;
    }
    this.a.a(paramUri.getQueryParameter("retJson"));
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
    this.d = null;
  }
  
  public void b()
  {
    if (this.b == null)
    {
      Log.e("tcaptcha verify_error", "context is null");
      return;
    }
    if (this.a == null)
    {
      Log.e("tcaptcha verify_error", "listener is null");
      return;
    }
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
        Method localMethod = this.d.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
        if (localMethod != null)
        {
          localMethod.invoke(this.d, new Object[] { "searchBoxJavaBridge_" });
          localMethod.invoke(this.d, new Object[] { "accessibility" });
          localMethod.invoke(this.d, new Object[] { "accessibilityTraversal" });
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    WebSettings localWebSettings = this.d.getSettings();
    try
    {
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
      localWebSettings.setSupportMultipleWindows(true);
      localWebSettings.setNeedInitialFocus(false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localWebSettings.getUserAgentString());
      localStringBuilder.append(" TCSDK/1.0.2");
      localWebSettings.setUserAgentString(localStringBuilder.toString());
      localWebSettings.setAllowFileAccess(true);
      localWebSettings.setAppCacheEnabled(true);
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setDatabaseEnabled(true);
      CookieManager.getInstance().setAcceptCookie(true);
      if (Build.VERSION.SDK_INT >= 21) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.d, true);
      }
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setSupportZoom(false);
    if ((Build.VERSION.SDK_INT >= 19) && (a(this.b))) {
      try
      {
        WebView.setWebContentsDebuggingEnabled(true);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file:///android_asset/tcaptcha_webview.html?appid=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("&width=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("&height=");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("&map=");
    ((StringBuilder)localObject).append(this.e);
    localObject = ((StringBuilder)localObject).toString();
    this.d.loadUrl((String)localObject);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void a(int paramInt, String paramString);
    
    public abstract void a(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.d
 * JD-Core Version:    0.7.0.1
 */