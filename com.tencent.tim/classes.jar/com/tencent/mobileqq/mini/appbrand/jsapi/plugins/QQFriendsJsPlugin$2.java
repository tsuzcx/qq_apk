package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class QQFriendsJsPlugin$2
  implements MiniAppCmdInterface
{
  QQFriendsJsPlugin$2(String paramString1, Context paramContext, String paramString2, QQFriendsJsPlugin.IAddFriendCallBack paramIAddFriendCallBack) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      int i = paramJSONObject.optInt("authState", -1);
      paramJSONObject = paramJSONObject.optString("settingItem", "");
      if ((i != 1) || (!"setting.addFriend".equals(paramJSONObject))) {}
    }
    String str;
    do
    {
      do
      {
        try
        {
          AddFriendLogicActivity.aKF = this.val$openId;
          paramJSONObject = AddFriendLogicActivity.a(this.val$context, 3, this.val$openId, this.val$appId, 3024, Integer.parseInt(this.val$appId), null, null, null, "", null);
          this.val$context.startActivity(paramJSONObject);
          if (this.val$addFriendCallBack != null) {
            this.val$addFriendCallBack.onAddFriendCallBack("addFriend", true, null);
          }
          return;
        }
        catch (NumberFormatException paramJSONObject)
        {
          for (;;)
          {
            QLog.d("QQFriendsJsPlugin", 2, " doAddFriend() exception e = " + paramJSONObject);
          }
        }
      } while (this.val$addFriendCallBack == null);
      QLog.e("QQFriendsJsPlugin", 1, "getSettingByOpenId failed");
      this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "auth deny");
      return;
      str = "getUserSettingByOpenId failed!";
      if (paramJSONObject != null) {
        str = paramJSONObject.optString("errMsg", "");
      }
    } while (this.val$addFriendCallBack == null);
    QLog.e("QQFriendsJsPlugin", 1, "getUserSetting failed");
    this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */