package com.tencent.captchasdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import org.json.JSONObject;

class g
{
  private l a;
  private Context b;
  private String c;
  private WebView d;
  private String e;
  private int f;
  private final WebChromeClient g = new h(this);
  private final WebViewClient h = new j(this);
  
  public g(Context paramContext, l paraml, String paramString1, WebView paramWebView, String paramString2, int paramInt)
  {
    this.b = paramContext;
    this.a = paraml;
    this.c = paramString1;
    this.d = paramWebView;
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      this.e = paramString2;
      if (paramInt <= 0) {
        break label93;
      }
    }
    label93:
    for (this.f = paramInt;; this.f = 100)
    {
      b();
      return;
      this.e = "";
      break;
    }
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
      if ((this.b != null) && (this.a != null)) {
        this.a.a(-1001, URLDecoder.decode(paramUri.getQueryParameter("msg"), "utf-8"));
      }
      return;
    }
    catch (Exception localException)
    {
      this.a.a(-1001, paramUri.getQueryParameter("msg"));
    }
  }
  
  private void c(Uri paramUri)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.b != null) && (paramUri != null)) {}
    try
    {
      String str2 = paramUri.getQueryParameter("list");
      String str1 = paramUri.getQueryParameter("callback");
      if ((str2 != null) && (paramUri.getQueryParameter("callback") != null) && (Integer.parseInt(str2) > 0))
      {
        int i = Integer.parseInt(str2);
        paramUri = new JSONObject();
        if ((i & 0x1) == 1)
        {
          f.a();
          paramUri.put("cpu_info", f.a);
          paramUri.put("cpu_hardware", f.b);
          paramUri.put("cpu_serial", f.c);
        }
        if ((i & 0x2) == 2) {
          paramUri.put("battery_level", f.a(this.b));
        }
        if ((i & 0x4) == 4)
        {
          paramUri.put("dpi", f.b(this.b));
          paramUri.put("width", f.c(this.b));
          paramUri.put("height", f.d(this.b));
        }
        if ((i & 0x8) == 8) {
          paramUri.put("sensor_flag", f.e(this.b));
        }
        if ((i & 0x10) == 16)
        {
          paramUri.put("network_type", f.a(this.b, 0));
          paramUri.put("network_operator_name", f.a(this.b, 1));
          paramUri.put("network_connection_type", f.a(this.b, 2));
        }
        if ((i & 0x20) == 32)
        {
          paramUri.put("wifi_ssid", f.b(this.b, 0));
          paramUri.put("wifi_bssid", f.b(this.b, 1));
          paramUri.put("wifi_connected", f.f(this.b));
        }
        if ((i & 0x40) == 64)
        {
          paramUri.put("band_version", f.b());
          paramUri.put("osname", f.e());
        }
        if ((i & 0x80) == 128)
        {
          paramUri.put("app_name", f.g(this.b));
          paramUri.put("app_version", f.h(this.b));
        }
        if ((i & 0x100) == 256) {
          paramUri.put("kernel_version", f.f());
        }
        if ((i & 0x200) == 512)
        {
          paramUri.put("is_emulator", f.c());
          paramUri.put("is_root", f.d());
        }
        if (paramUri.length() > 0)
        {
          paramUri.put("platform", "Android");
          paramUri = "javascript:window." + str1 + "(" + paramUri.toString() + ")";
          this.d.evaluateJavascript(paramUri, new k(this));
        }
      }
      return;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
  }
  
  private void d(Uri paramUri)
  {
    if (this.a != null) {
      this.a.a(Integer.parseInt(paramUri.getQueryParameter("width")), Integer.parseInt(paramUri.getQueryParameter("height")));
    }
  }
  
  private void e(Uri paramUri)
  {
    try
    {
      if (this.a != null) {
        this.a.a(URLDecoder.decode(paramUri.getQueryParameter("retJson"), "utf-8"));
      }
      return;
    }
    catch (Exception localException)
    {
      this.a.a(paramUri.getQueryParameter("retJson"));
    }
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
        localObject = this.d.getSettings();
      }
    }
    catch (Exception localException3)
    {
      try
      {
        ((WebSettings)localObject).setJavaScriptEnabled(true);
        ((WebSettings)localObject).setJavaScriptCanOpenWindowsAutomatically(true);
        ((WebSettings)localObject).setSupportMultipleWindows(true);
        ((WebSettings)localObject).setNeedInitialFocus(false);
        ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + " TCSDK/1.0.2");
        ((WebSettings)localObject).setAllowFileAccess(true);
        ((WebSettings)localObject).setAppCacheEnabled(true);
        ((WebSettings)localObject).setDomStorageEnabled(true);
        ((WebSettings)localObject).setDatabaseEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().setAcceptThirdPartyCookies(this.d, true);
        }
        ((WebSettings)localObject).setBuiltInZoomControls(false);
        ((WebSettings)localObject).setSupportZoom(false);
        if ((Build.VERSION.SDK_INT < 19) || (!a(this.b))) {}
      }
      catch (Exception localException3)
      {
        try
        {
          for (;;)
          {
            WebView.setWebContentsDebuggingEnabled(true);
            Object localObject = "file:///android_asset/tcaptcha_webview.html?appid=" + this.c + "&width=" + this.f + "&height=" + this.f + "&map=" + this.e;
            this.d.loadUrl((String)localObject);
            return;
            localObject = this.d.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
            if (localObject != null)
            {
              ((Method)localObject).invoke(this.d, new Object[] { "searchBoxJavaBridge_" });
              ((Method)localObject).invoke(this.d, new Object[] { "accessibility" });
              ((Method)localObject).invoke(this.d, new Object[] { "accessibilityTraversal" });
              continue;
              localException1 = localException1;
              localException1.printStackTrace();
            }
          }
          localException3 = localException3;
          localException3.printStackTrace();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localException2.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.g
 * JD-Core Version:    0.7.0.1
 */