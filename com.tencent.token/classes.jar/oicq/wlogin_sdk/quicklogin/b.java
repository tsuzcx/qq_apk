package oicq.wlogin_sdk.quicklogin;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

final class b
  extends WebChromeClient
{
  b(QuikLoginJSInterface paramQuikLoginJSInterface) {}
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    paramJsPromptResult.cancel();
    try
    {
      paramString3 = new JSONObject(paramString2);
      paramWebView = paramString3.getString("uin");
      paramString1 = paramString3.getString("sig");
      paramString3 = paramString3.optString("input");
      this.a.ptloginCallBack(paramWebView, paramString1, paramString3);
    }
    catch (Exception paramWebView)
    {
      label54:
      break label54;
    }
    util.LOGI("onJsPrompt failed message ".concat(String.valueOf(paramString2)), "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.b
 * JD-Core Version:    0.7.0.1
 */