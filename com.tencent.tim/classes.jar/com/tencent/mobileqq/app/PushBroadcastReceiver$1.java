package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PushBroadcastReceiver$1
  implements Runnable
{
  PushBroadcastReceiver$1(PushBroadcastReceiver paramPushBroadcastReceiver, Intent paramIntent, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.val$intent.getStringExtra("classname");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null) {}
    try
    {
      localObject1 = Class.forName(str);
      this.val$app.a(BaseApplication.getContext(), (Class)localObject1);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("processIntent", 2, localClassNotFoundException.getMessage());
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PushBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */