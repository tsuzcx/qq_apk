import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONObject;

public class arct
{
  private final arcd c;
  public String czA;
  
  public arct(arcd paramarcd)
  {
    this.c = paramarcd;
  }
  
  public void callSwitchChannelJs(int paramInt)
  {
    TouchWebView localTouchWebView = this.c.a();
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    if ((localTouchWebView != null) && (!TextUtils.isEmpty(this.czA)))
    {
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
    }
    try
    {
      localJSONObject1.put("code", 0);
      localJSONObject1.put("message", "ok");
      localJSONObject2.put("subIndex", paramInt);
      localJSONObject1.put("data", localJSONObject2);
      localTouchWebView.callJs(WebViewPlugin.toJsScript(this.czA, localJSONObject1, null));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void dq(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.czA = paramString;
      }
      return;
    }
    this.czA = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arct
 * JD-Core Version:    0.7.0.1
 */