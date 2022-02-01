package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class QQFriendJsPlugin
  extends BaseJsPlugin
{
  public static final String API_ADD_FRIEND = "addFriend";
  public static final String SETTING_ADD_FRIEND = "setting.addFriend";
  private static final String TAG = "QQFriendJsPlugin";
  
  public static void doAddFriend(Context paramContext, String paramString1, String paramString2, IAddFriendCallBack paramIAddFriendCallBack)
  {
    if (paramContext == null)
    {
      QMLog.e("QQFriendJsPlugin", "doAddFriend context is null ?!!");
      return;
    }
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    localChannelProxy.getUserSetting(paramString1, paramString2, "setting.addFriend", null, new QQFriendJsPlugin.1(paramString2, paramString1, localChannelProxy, paramContext, paramIAddFriendCallBack));
  }
  
  @JsEvent({"addFriend"})
  public void addFriend(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("openid", "");
      QQFriendJsPlugin.2 local2 = new QQFriendJsPlugin.2(this, paramRequestEvent);
      doAddFriend(this.mMiniAppContext.getAttachedActivity(), this.mApkgInfo.appId, str, local2);
      return;
    }
    catch (Exception localException)
    {
      paramRequestEvent.fail();
    }
  }
  
  public static abstract interface IAddFriendCallBack
  {
    public abstract void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin
 * JD-Core Version:    0.7.0.1
 */