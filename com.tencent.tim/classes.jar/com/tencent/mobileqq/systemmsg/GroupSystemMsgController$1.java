package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anze;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class GroupSystemMsgController$1
  implements Runnable
{
  public GroupSystemMsgController$1(anze paramanze, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.val$app.getApp().getSharedPreferences(this.val$app.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt("unread_Group_system_msg", this.aIU).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController.1
 * JD-Core Version:    0.7.0.1
 */