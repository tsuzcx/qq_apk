import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arac
  implements MiniMsgUser.IMiniMsgActionCallback
{
  public arac(WebViewFragment paramWebViewFragment) {}
  
  public void o(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      paramString = "javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + localJSONObject.toString() + ");";
      this.this$0.j.callJs(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("WebLog_WebViewFragment", 1, paramString, new Object[0]);
    }
  }
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onFromMiniAIOToAIO ");
    }
    o("fromMiniAIOToAIO", new JSONObject());
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "onGoToConversation ");
      }
      o("returnMsgList", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WebLog_WebViewFragment", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (this.this$0.mMiniMsgUser == null) {
      return;
    }
    WebViewFragment localWebViewFragment = this.this$0;
    Object localObject1 = localWebViewFragment.cyS;
    if (TextUtils.isEmpty(localWebViewFragment.cyS)) {
      localObject1 = localWebViewFragment.j.getTitle();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!"‎".equals(localObject1)) {}
    }
    else
    {
      localObject2 = acfp.m(2131716907);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    Object localObject2 = this.this$0.mMiniMsgUser.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = localWebViewFragment.a((Bundle)localObject1);
    arcp.dW(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      o("entryClicked", new JSONObject());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WebLog_WebViewFragment", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arac
 * JD-Core Version:    0.7.0.1
 */