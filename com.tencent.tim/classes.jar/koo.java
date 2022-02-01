import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class koo
  extends tmt
{
  koo(koj paramkoj, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d(koj.access$300(), 2, "loadForm onPageFinished url:" + paramString + ", costTime:" + (SystemClock.currentThreadTimeMillis() - koj.b(this.this$0)));
      QLog.d(koj.access$300(), 2, "onPageFinished: TOTAL costTime=" + (SystemClock.currentThreadTimeMillis() - koj.c(this.this$0)));
    }
    if (koj.a(this.this$0) != null) {
      koj.a(this.this$0).enterStatus((byte)2);
    }
    if (koj.a(this.this$0) != null) {
      koj.a(this.this$0).setVisibility(8);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(koj.access$300(), 2, "onReceivedError:" + paramInt + "，" + paramString1 + ", " + paramString2);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(koj.access$300(), 2, "shouldOverrideUrlLoading url:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    Object localObject = ((CustomWebView)paramWebView).getPluginEngine();
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      if ((localObject != null) && (((WebViewPluginEngine)localObject).handleEvent(paramString, 16L, null))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    paramString = Uri.parse(paramString);
    localObject = paramString.getScheme();
    if (jml.a().a(paramWebView.getUrl(), (String)localObject).booleanValue())
    {
      paramWebView = new Intent("android.intent.action.VIEW", paramString);
      paramWebView.addFlags(268435456);
    }
    try
    {
      this.mContext.startActivity(paramWebView);
      return false;
    }
    catch (ActivityNotFoundException paramWebView)
    {
      for (;;)
      {
        Log.e("AbsWebView", paramWebView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koo
 * JD-Core Version:    0.7.0.1
 */