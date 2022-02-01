import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class jqw
  extends WebViewPlugin
{
  protected Activity mActivity;
  
  public jqw()
  {
    this.mPluginNameSpace = "eqq";
  }
  
  private void li(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("uin");
      localObject = ((JSONObject)localObject).getString("name");
      Intent localIntent = wja.a(new Intent(this.mActivity, ChatActivity.class), null);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uintype", 1024);
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("aio_msg_source", 999);
      this.mActivity.startActivity(localIntent);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"eqq".equals(paramString2)) {}
    do
    {
      return false;
      if ("showEQQ".equals(paramString3))
      {
        if (paramVarArgs.length > 0) {
          lh(paramVarArgs[0]);
        }
        return true;
      }
    } while ((!"showEQQAio".equals(paramString3)) || (paramVarArgs.length != 1));
    li(paramVarArgs[0]);
    return false;
  }
  
  protected void lh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getString("uin");
        jqs.a(this.mActivity, null, paramString, false, -1, true, -1);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("EqqWebviewPlugin", 2, "showEqq json error!");
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqw
 * JD-Core Version:    0.7.0.1
 */