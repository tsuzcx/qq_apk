import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.b;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoyj
  extends VasWebviewJsPlugin
{
  public static String TAG = "TroopUpgradePlugin";
  protected AppInterface mApp;
  protected Context mContext;
  
  public aoyj()
  {
    this.mPluginNameSpace = "Troop";
  }
  
  public long getPluginBusiness()
  {
    return 2147614720L;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ("Troop".equals(paramString2)) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      if (paramJsBridgeListener == null) {
        return false;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
        paramJsBridgeListener = null;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      int i;
      do
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = null;
        }
        if (!"updateMaxMemberNum".equals(paramString3)) {
          break;
        }
        paramString1 = paramJsBridgeListener.optString("groupId", "");
        i = paramJsBridgeListener.optInt("type", 0);
      } while ((TextUtils.isEmpty(paramString1)) || (i == 0));
      paramJsBridgeListener = new Bundle();
      paramJsBridgeListener.putString("groupId", paramString1);
      paramJsBridgeListener.putInt("type", i);
      sendRemoteReq(affz.a("notifyTroopUpgradeSuccess", "", this.mOnRemoteResp.key, paramJsBridgeListener), true, false);
    }
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mContext = this.mRuntime.getActivity();
    this.mApp = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyj
 * JD-Core Version:    0.7.0.1
 */