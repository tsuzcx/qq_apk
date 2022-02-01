import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.util.QZLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awgs
  extends awfr
{
  public static String PKG_NAME = "Qzone";
  
  private void f(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = paramWebViewPlugin.mRuntime.getActivity();
    } while ((localActivity == null) || (localActivity.isFinishing()));
    paramWebViewPlugin = "";
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]).optString("text", "");
      paramWebViewPlugin = paramArrayOfString;
    }
    catch (JSONException paramArrayOfString)
    {
      for (;;)
      {
        QZLog.e("QzoneUserHomePageJsPlugin", "handleSetMessageBoardGate: parse json data error", paramArrayOfString);
      }
    }
    paramArrayOfString = new Intent("QzoneUserHome.ACTION_openKapuHostMsg");
    paramArrayOfString.putExtra("text", paramWebViewPlugin);
    localActivity.sendBroadcast(paramArrayOfString);
    QZLog.i("QzoneUserHomePageJsPlugin", 2, "handleSetKapuHostMessage: sendBroadcast,text:" + paramWebViewPlugin);
  }
  
  private boolean y(WebViewPlugin paramWebViewPlugin, String[] paramArrayOfString)
  {
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    Activity localActivity = paramWebViewPlugin.mRuntime.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramWebViewPlugin = new JSONObject(paramArrayOfString[0]);
        i = paramWebViewPlugin.optInt("open_msg_board", 0);
        if (i == 0) {
          bool = false;
        }
      }
      catch (JSONException paramWebViewPlugin) {}
      try
      {
        i = paramWebViewPlugin.optInt("update_msg_board", 1);
        paramWebViewPlugin = new Intent("QzoneUserHome.ACTION_openMsgBoard");
        paramWebViewPlugin.putExtra("openMsgBoard", bool);
        paramWebViewPlugin.putExtra("updateMsgBoard", i);
        localActivity.sendBroadcast(paramWebViewPlugin);
        QZLog.i("QzoneUserHomePageJsPlugin", 2, "handleSetMessageBoardGate: sendBroadcast,isOpenMsgBoard:" + bool + " ,updateType：" + i);
        return true;
      }
      catch (JSONException paramWebViewPlugin)
      {
        break label149;
      }
      bool = true;
      continue;
      label149:
      QZLog.e("QzoneUserHomePageJsPlugin", "handleSetMessageBoardGate: parse json data error", paramWebViewPlugin);
      int i = 1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals(PKG_NAME)) || (this.f == null) || (this.f.mRuntime == null)) {
      return false;
    }
    if (awen.cPF.equalsIgnoreCase(paramString3))
    {
      y(this.f, paramVarArgs);
      return true;
    }
    if (awen.cPG.equalsIgnoreCase(paramString3))
    {
      f(this.f, paramVarArgs);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgs
 * JD-Core Version:    0.7.0.1
 */