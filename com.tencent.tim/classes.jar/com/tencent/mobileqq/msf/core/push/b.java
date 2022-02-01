package com.tencent.mobileqq.msf.core.push;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class b
{
  private static final String a = "NewMsgNotificationManager";
  
  static boolean a(Context paramContext)
  {
    boolean bool = QQNotificationManager.getInstance().areNotificationsEnabled(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "checkSystemNotificationEnabled: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    boolean bool = SettingCloneUtil.readValue(paramContext, paramString, null, "new_msg_notification_key", true);
    if (QLog.isColorLevel()) {
      QLog.d("NewMsgNotificationManager", 2, new Object[] { "globalSwitchOn: invoked. ", " enable: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
      return a(paramContext, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.b
 * JD-Core Version:    0.7.0.1
 */