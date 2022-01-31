package oicq.wlogin_sdk.quicklogin;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class QuikLoginJSInterface
{
  Activity a;
  
  public QuikLoginJSInterface(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  @JavascriptInterface
  public void ptAlertCallBack(String paramString)
  {
    new AlertDialog.Builder(this.a).setTitle("登录提示").setMessage(paramString).setPositiveButton("确定", null).show();
  }
  
  @JavascriptInterface
  public void ptloginCallBack(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (paramString3 != null)
    {
      str = paramString3;
      if (true == paramString3.equals("undefined")) {
        str = "";
      }
    }
    paramString3 = new Intent();
    paramString3.putExtra("uin", paramString1);
    paramString3.putExtra("sig", paramString2);
    paramString3.putExtra("input", str);
    paramString3.putExtra("isRetFromWeb", true);
    this.a.setResult(-1, paramString3);
    this.a.finish();
    if ((QuickLoginWebViewLoader.finishAnimEnter != 0) || (QuickLoginWebViewLoader.finishAnimExit != 0)) {
      this.a.overridePendingTransition(QuickLoginWebViewLoader.finishAnimEnter, QuickLoginWebViewLoader.finishAnimExit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.QuikLoginJSInterface
 * JD-Core Version:    0.7.0.1
 */