package com.tencent.biz.troop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"InlinedApi"})
public class TroopMemberApiPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  public static final String a = "changeAnonymousNick";
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String b;
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mRuntime.a().getApplication();
    QQToast.a(MobileQQ.getContext(), 2131364509, 0).a();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if ("changeAnonymousNick".equals(paramBundle.getString("method")))
    {
      boolean bool = paramBundle.getBoolean("result");
      callJs(this.b, new String[] { "{result : " + bool + "}" });
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("anonymousReport".equals(paramString3))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if ("anonymousNickChanged".equals(paramString3)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("troopUin");
        long l = paramJsBridgeListener.optLong("bubbleId");
        int i = paramJsBridgeListener.optInt("headId");
        paramString2 = paramJsBridgeListener.optString("nickName");
        int j = paramJsBridgeListener.optInt("expireTime");
        this.b = paramJsBridgeListener.optString("callback");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "TroopMemberApiPlugin, anonymousNickChanged, json : " + paramJsBridgeListener);
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, l, i, paramString2, j, this);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "TroopMemberApiPlugin, anonymousNickChanged, JSONException :" + paramJsBridgeListener);
        }
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin
 * JD-Core Version:    0.7.0.1
 */