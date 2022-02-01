import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aijm
  extends WebViewPlugin
{
  private String mCallback;
  private Context mContext;
  
  public aijm()
  {
    this.mPluginNameSpace = "medalwall";
  }
  
  private void Lu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        this.mCallback = new JSONObject(paramString).optString("callback");
        Lw(this.mCallback);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("MedalApi", 2, "shareMsg error: " + paramString.toString());
  }
  
  private void Lv(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        this.mCallback = new JSONObject(paramString).optString("callback");
        startActivityForResult(new Intent(this.mContext, PermisionPrivacyActivity.class), (byte)100);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("MedalApi", 2, "shareMsg error: " + paramString.toString());
  }
  
  private void Lw(String paramString)
  {
    String str = this.mRuntime.a().getCurrentAccountUin();
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + str, 4).getBoolean("medal_switch_disable", false);
    if (!TextUtils.isEmpty(paramString)) {
      if (!bool) {
        break label74;
      }
    }
    label74:
    for (str = "{\"isOn\":0}";; str = "{\"isOn\":1}")
    {
      callJs(paramString, new String[] { str });
      return;
    }
  }
  
  private void clearRedPoint()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "clearRedPoint from web!");
    }
    aeai.a().bUo();
  }
  
  private Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("medalwall".equals(paramString2))
    {
      if ((paramJsBridgeListener != null) && (paramJsBridgeListener.cXk)) {}
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (!"getMedalSwitch".equals(paramString3)) {
        break label54;
      }
      Lu(paramVarArgs[0]);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label54:
      if ("jumpToMedalSettings".equals(paramString3)) {
        Lv(paramVarArgs[0]);
      } else if ("clearRedPoint".equals(paramString3)) {
        clearRedPoint();
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 100) {
      Lw(this.mCallback);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mContext = getCurrentContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijm
 * JD-Core Version:    0.7.0.1
 */