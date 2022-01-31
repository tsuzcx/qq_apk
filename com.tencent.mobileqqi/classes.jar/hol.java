import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppViewBaseActivity;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.js.OpenJsBridge;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class hol
  extends WebViewClient
{
  AppViewBaseActivity a = null;
  
  public hol(AppViewBaseActivity paramAppViewBaseActivity1, AppViewBaseActivity paramAppViewBaseActivity2)
  {
    this.a = paramAppViewBaseActivity2;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    try
    {
      this.a.d = System.currentTimeMillis();
      LogUtility.b("LaunchTime", "APP_" + this.a.l + "_onPageFinished：" + this.a.d);
      LogUtility.b("LaunchTime", "App_" + this.a.l + "_interval_(onPageFinished-onPageStarted):" + (this.a.d - this.b.c));
      if (paramWebView != null)
      {
        super.onPageFinished(paramWebView, paramString);
        if ((this.a != null) && (!this.a.isFinishing())) {
          this.a.b(paramWebView, paramString);
        }
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (this.a != null)
    {
      this.a.c = System.currentTimeMillis();
      LogUtility.b("LaunchTime", "APP_" + this.a.l + "_onPageStarted：" + this.a.c);
      LogUtility.b("LaunchTime", "App_" + this.a.l + "_interval_(onPageStarted-onCreate):" + (this.a.c - this.a.b));
      paramBitmap = "javascript:window.agentData = {};agentData.currentVersion='" + CommonDataAdapter.a().b() + "';" + "agentData.platform='" + CommonDataAdapter.a().g() + "';" + "agentData.uin='" + CommonDataAdapter.a().a() + "';" + "agentData.agentVersion='" + CommonDataAdapter.a().d() + "';" + "agentData.display='" + MobileInfoUtil.e() + "';" + "agentData.mobileInfo='" + MobileInfoUtil.i() + "';" + "agentData.pageParams='" + this.a.d() + "';" + "agentData.imgRoot='" + Common.b() + ImageCache.b + "';" + "agentData.isFirstEnter='" + this.b.h + "';" + "void(0);";
      LogUtility.b("opensdk", "agentData_js=" + paramBitmap);
      paramWebView.loadUrl(paramBitmap);
    }
    try
    {
      if ((this.a != null) && (!this.a.isFinishing())) {
        this.a.a(paramWebView, paramString);
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    try
    {
      if ((this.a != null) && (!this.a.isFinishing())) {
        this.a.a(paramWebView, paramInt, paramString1, paramString2);
      }
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    LogUtility.b("opensdk", ">>should url:" + paramString);
    try
    {
      if ((this.a == null) || (this.a.isFinishing())) {
        break label62;
      }
      boolean bool = this.a.a.a(paramWebView, paramString);
      if (!bool) {
        break label62;
      }
    }
    catch (Exception localException)
    {
      label62:
      do
      {
        do
        {
          while ((paramString.equals("about:blank;")) || (paramString.equals("about:blank")))
          {
            if (QLog.isColorLevel()) {
              LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading about:blank; " + paramString);
            }
            if (Build.VERSION.SDK_INT >= 11) {
              return false;
            }
          }
          if (!paramString.startsWith("tmast")) {
            break;
          }
          if (QLog.isColorLevel()) {
            LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading tmast; " + paramString);
          }
          try
          {
            paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
            this.b.startActivity(paramWebView);
            return true;
          }
          catch (Exception paramWebView) {}
        } while (!QLog.isColorLevel());
        LogUtility.b("AppViewBaseActivity", "shouldOverrideUrlLoading tmast;error: " + paramWebView.getMessage());
        return true;
      } while (this.a.a(paramWebView, paramString));
    }
    return true;
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hol
 * JD-Core Version:    0.7.0.1
 */