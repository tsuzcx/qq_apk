package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class QQFriendsJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "QQFriendsJsPlugin";
  Set<String> eventMap = new HashSet();
  
  public QQFriendsJsPlugin()
  {
    this.eventMap.add("addFriend");
  }
  
  public static void doAddFriend(Context paramContext, String paramString1, String paramString2, IAddFriendCallBack paramIAddFriendCallBack)
  {
    if (paramContext == null)
    {
      QLog.e("QQFriendsJsPlugin", 1, "doAddFriend context is null ?!!");
      return;
    }
    MiniAppCmdUtil.getInstance().getUserSetting(paramString1, paramString2, "setting.addFriend", null, new QQFriendsJsPlugin.2(paramString2, paramContext, paramString1, paramIAddFriendCallBack));
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFriendsJsPlugin", 2, "[handleNativeRequest] event=" + paramString1 + ", jsonParams=" + paramString2 + ", callbackId=" + paramInt);
    }
    if ("addFriend".equals(paramString1)) {}
    try
    {
      paramString2 = new JSONObject(paramString2).optString("openid", "");
      QQFriendsJsPlugin.1 local1 = new QQFriendsJsPlugin.1(this, paramJsRuntime, paramInt);
      doAddFriend(this.jsPluginEngine.getActivityContext(), getAppId(), paramString2, local1);
      return "";
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, null, paramInt);
      }
    }
  }
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
  
  public static abstract interface IAddFriendCallBack
  {
    public abstract void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin
 * JD-Core Version:    0.7.0.1
 */