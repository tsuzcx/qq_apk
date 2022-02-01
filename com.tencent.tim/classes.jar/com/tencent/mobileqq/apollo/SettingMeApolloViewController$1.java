package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class SettingMeApolloViewController$1
  implements Runnable
{
  SettingMeApolloViewController$1(SettingMeApolloViewController paramSettingMeApolloViewController) {}
  
  public void run()
  {
    Object localObject = (QQSettingMe)SettingMeApolloViewController.a(this.this$0).get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).getApp();
    } while (localObject == null);
    boolean bool = ApolloGameUtil.Z((QQAppInterface)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "[updateCmshowStatus] isApolloUser=", Boolean.valueOf(bool) });
    }
    if (bool) {
      this.this$0.cCm();
    }
    this.this$0.cCn();
    this.this$0.cCo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController.1
 * JD-Core Version:    0.7.0.1
 */