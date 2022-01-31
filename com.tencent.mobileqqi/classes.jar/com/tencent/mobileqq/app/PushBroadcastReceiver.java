package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class PushBroadcastReceiver
  extends QQBroadcastReceiver
{
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.notify.qc.background")) {
      paramQQAppInterface.a(BaseApplication.getContext());
    }
    do
    {
      do
      {
        return;
        if (paramIntent.getAction().equals("tencent.notify.friend.message"))
        {
          paramQQAppInterface.a().b(false);
          return;
        }
      } while (paramIntent.getAction().equals("tencent.notify.troop.message"));
      if (paramIntent.getAction().equals("tencent.notify.background"))
      {
        String str = paramIntent.getStringExtra("classname");
        Object localObject = null;
        paramIntent = localObject;
        if (str != null) {}
        try
        {
          paramIntent = Class.forName(str);
          paramQQAppInterface.a(BaseApplication.getContext(), paramIntent);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          for (;;)
          {
            paramIntent = localObject;
            if (QLog.isColorLevel())
            {
              QLog.d("processIntent", 2, localClassNotFoundException.getMessage());
              paramIntent = localObject;
            }
          }
        }
      }
      if (paramIntent.getAction().equals("tencent.notify.foreground"))
      {
        paramQQAppInterface.i();
        return;
      }
      if (paramIntent.getAction().equals("com.tencent.mobileqq.PCONLINE_CLICK_NOTIFICATION"))
      {
        ((MessageHandler)paramQQAppInterface.a(0)).a(BaseApplication.getContext(), paramIntent);
        return;
      }
    } while (!paramIntent.getAction().equals("tencent.notify.friend.status"));
    ((FriendListHandler)paramQQAppInterface.a(1)).a((ArrayList)paramIntent.getSerializableExtra("reqBatchFStatus"));
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getExtras().getString("selfuin") != null) || ((paramAppRuntime != null) && ((paramAppRuntime instanceof QQAppInterface)))) {
      a((QQAppInterface)paramAppRuntime, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PushBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */