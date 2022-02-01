import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class wqy
  extends aqyg
  implements aran, araz.d, ardm.k, ardm.o
{
  protected svi a;
  private wqw b;
  
  public wqy(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
    this.mWebview = new TouchWebView(paramContext);
    buildBaseWebView(this.mInterface);
    this.b = new wqw(paramActivity, this.mWebview);
  }
  
  public void QK() {}
  
  public void Qq()
  {
    this.b.a(a());
  }
  
  public WebViewFragment a()
  {
    return null;
  }
  
  protected svi a()
  {
    if (this.a == null)
    {
      this.a = new svi(this.mInterface, this.mInActivity);
      this.a.a(this);
    }
    return this.a;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return a().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public TouchWebView b(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.addView(this.mWebview);
    }
    return this.mWebview;
  }
  
  public WebView b()
  {
    return this.mWebview;
  }
  
  public svi b()
  {
    return a();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.add(new ardn());
      paramArrayList.add(new ConfessPlugin());
      paramArrayList.add(new UiApiPlugin());
      paramArrayList.add(new aiju());
      paramArrayList.add(new svn());
      paramArrayList.add(new kbw());
    }
  }
  
  public boolean bw(String paramString)
  {
    return a().bw(paramString);
  }
  
  public void ff(boolean paramBoolean) {}
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.mWebview != null)
      {
        if (TextUtils.isEmpty(this.mWebview.getUrl())) {
          break label46;
        }
        str1 = this.mWebview.getUrl();
      }
    }
    return str1;
    label46:
    return this.mInActivity.getIntent().getStringExtra("url");
  }
  
  public Activity getHostActivity()
  {
    return this.mInActivity;
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebview;
  }
  
  public void loadUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mWebview.loadUrl(this.mUrl);
  }
  
  public boolean mc()
  {
    return false;
  }
  
  public void onDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    paramByte = switchRequestCode(paramWebViewPlugin, (byte)1);
    if (paramByte == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "pluginStartActivityForResult not handled");
      }
    }
    while (this.mInActivity == null) {
      return paramByte;
    }
    this.mInActivity.startActivityForResult(paramIntent, 15001);
    return paramByte;
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.getWebView();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsWebView", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqy
 * JD-Core Version:    0.7.0.1
 */