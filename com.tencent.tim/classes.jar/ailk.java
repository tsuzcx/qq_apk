import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ailk
  implements MiniMsgUser.IMiniMsgActionCallback
{
  public ailk(UiApiPlugin paramUiApiPlugin) {}
  
  public void onFromMiniAIOToAIO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "onFromMiniAIOToAIO ");
    }
    JSONObject localJSONObject = new JSONObject();
    this.this$0.o("fromMiniAIOToAIO", localJSONObject);
  }
  
  public void onGoToConversation()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "onGoToConversation ");
      }
      JSONObject localJSONObject = new JSONObject();
      this.this$0.o("returnMsgList", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    WebViewFragment localWebViewFragment = this.this$0.mRuntime.b();
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
      localObject2 = acfp.m(2131716192);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("banner_wording", (String)localObject2);
    Object localObject2 = this.this$0.mMiniMsgUser.getParam();
    ((MiniMsgUserParam)localObject2).backConversationIntent = localWebViewFragment.a((Bundle)localObject1);
    arcp.dW(((MiniMsgUserParam)localObject2).backConversationIntent);
    try
    {
      localObject1 = new JSONObject();
      this.this$0.o("entryClicked", (JSONObject)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ailk
 * JD-Core Version:    0.7.0.1
 */