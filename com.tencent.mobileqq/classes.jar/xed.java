import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class xed
  extends VasWebviewJsPlugin
{
  public xed()
  {
    this.mPluginNameSpace = "robotsummary";
  }
  
  private boolean a(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return false;
    }
    paramVarArgs = paramVarArgs[0];
    try
    {
      Object localObject = new JSONObject(paramVarArgs);
      paramVarArgs = ((JSONObject)localObject).optString("gc");
      String str1 = ((JSONObject)localObject).optString("robotUin");
      String str2 = ((JSONObject)localObject).optString("robotName");
      localObject = ((JSONObject)localObject).optString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("robotuin", str1);
      localBundle.putString("troopuin", paramVarArgs);
      localBundle.putString("robotname", str2);
      paramVarArgs = anah.a("ipc_cmd_share_robot_card", (String)localObject, this.mOnRemoteResp.key, localBundle);
      anfc.a().a(paramVarArgs);
      return true;
    }
    catch (JSONException paramVarArgs) {}
    return false;
  }
  
  private boolean b(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return false;
    }
    paramVarArgs = paramVarArgs[0];
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramVarArgs);
        if (localObject != null)
        {
          str6 = ((JSONObject)localObject).optString("oninfoUrl");
          str5 = ((JSONObject)localObject).optString("oninfoTitle");
          str4 = ((JSONObject)localObject).optString("offinfoUrl");
          str3 = ((JSONObject)localObject).optString("offinfoTitle");
          str1 = ((JSONObject)localObject).optString("gc");
          str2 = ((JSONObject)localObject).optString("robotUin");
          paramVarArgs = ((JSONObject)localObject).optString("robotName");
          i = ((JSONObject)localObject).optInt("isRobotBuddy");
          localObject = ((JSONObject)localObject).optString("callback");
          Bundle localBundle = new Bundle();
          localBundle.putString("onurl", str6);
          localBundle.putString("ontitle", str5);
          localBundle.putString("offtitle", str3);
          localBundle.putString("offurl", str4);
          localBundle.putString("robotuin", str2);
          localBundle.putString("troopuin", str1);
          localBundle.putString("robotname", paramVarArgs);
          localBundle.putInt("isrobotbuddy", i);
          paramVarArgs = anah.a("ipc_cmd_invoke_robot_function", (String)localObject, this.mOnRemoteResp.key, localBundle);
          anfc.a().a(paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramVarArgs)
      {
        return false;
      }
      String str6 = "";
      String str5 = "";
      String str4 = "";
      String str3 = "";
      String str2 = "";
      String str1 = "";
      paramVarArgs = "";
      int i = 1;
    }
  }
  
  private boolean c(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return false;
    }
    paramVarArgs = paramVarArgs[0];
    try
    {
      Object localObject = new JSONObject(paramVarArgs);
      paramVarArgs = ((JSONObject)localObject).optString("gc");
      String str1 = ((JSONObject)localObject).optString("robotUin");
      String str2 = ((JSONObject)localObject).optString("robotName");
      boolean bool = ((JSONObject)localObject).optBoolean("isAdd");
      localObject = ((JSONObject)localObject).optString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("robotuin", str1);
      localBundle.putString("troopuin", paramVarArgs);
      localBundle.putString("robotname", str2);
      localBundle.putBoolean("isadd", Boolean.valueOf(bool).booleanValue());
      paramVarArgs = anah.a("ipc_cmd_robot_member_change_function", (String)localObject, this.mOnRemoteResp.key, localBundle);
      anfc.a().a(paramVarArgs);
      return true;
    }
    catch (JSONException paramVarArgs)
    {
      QLog.e("TroopRobotPlugin", 2, "handleJsRequest exception notifyRobotMmeberChange" + paramVarArgs.getMessage());
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"robotsummary".equals(paramString2)) {}
    do
    {
      return false;
      if ("sharecard".equals(paramString3)) {
        return a(paramVarArgs);
      }
      if ("executecommand".equals(paramString3)) {
        return b(paramVarArgs);
      }
    } while (!"memberchange".equals(paramString3));
    return c(paramVarArgs);
  }
  
  public void onResponse(Bundle paramBundle)
  {
    super.onResponse(paramBundle);
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotPlugin", 2, "robot plugin onResponse is null");
      }
    }
    Object localObject1;
    int i;
    Activity localActivity;
    Object localObject2;
    String str1;
    String str2;
    String str3;
    String str4;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramBundle.getInt("respkey") == this.mOnRemoteResp.key) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("TroopRobotPlugin", 2, "robot plugin onResponse key not match");
          return;
          localObject1 = paramBundle.getString("cmd");
          if (!"ipc_cmd_share_robot_card".equals(localObject1)) {
            break;
          }
          i = paramBundle.getBundle("response").getInt("result");
          if (QLog.isColorLevel()) {
            QLog.d("TroopRobotPlugin", 2, "robot plugin is robot:" + i);
          }
        } while (i != 1);
        localObject1 = this.mRuntime.a();
        paramBundle = paramBundle.getBundle("request");
        azgu.a(null, (Activity)localObject1, null, paramBundle.getString("robotuin"), paramBundle.getString("robotname"), 21);
        return;
      } while (!"ipc_cmd_invoke_robot_function".equals(localObject1));
      localObject1 = paramBundle.getBundle("response").getString("result");
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotPlugin", 2, "strResult:" + (String)localObject1);
      }
      localActivity = this.mRuntime.a();
      localObject2 = paramBundle.getBundle("request");
      i = ((Bundle)localObject2).getInt("isrobotbuddy");
      paramBundle = ((Bundle)localObject2).getString("onurl");
      str1 = ((Bundle)localObject2).getString("ontitle");
      str2 = ((Bundle)localObject2).getString("offtitle");
      str3 = ((Bundle)localObject2).getString("offurl");
      str4 = ((Bundle)localObject2).getString("robotuin");
      String str5 = ((Bundle)localObject2).getString("troopuin");
      localObject2 = ((Bundle)localObject2).getString("robotname");
      if (i == 1)
      {
        azgu.a(localActivity, str5, (String)localObject1, str4, (String)localObject2, paramBundle, str1, str3, str2, i);
        return;
      }
    } while (i != 0);
    azgu.a(localActivity, (String)localObject1, null, str4, (String)localObject2, paramBundle, str1, str3, str2, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xed
 * JD-Core Version:    0.7.0.1
 */