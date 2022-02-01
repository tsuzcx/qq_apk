package com.tencent.mobileqq.systemmsg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anze;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class GroupSystemMsgController$3
  implements Runnable
{
  public GroupSystemMsgController$3(anze paramanze, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.val$app.getApp().getSharedPreferences(this.val$app.getCurrentAccountUin(), 0);
    if ((localSharedPreferences != null) && (!localSharedPreferences.getString("group_display", "").equals(this.ciD))) {
      localSharedPreferences.edit().putString("group_display", this.ciD).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.systemmsg.GroupSystemMsgController.3
 * JD-Core Version:    0.7.0.1
 */