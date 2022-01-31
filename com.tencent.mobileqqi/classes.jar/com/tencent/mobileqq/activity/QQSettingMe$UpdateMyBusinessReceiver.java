package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.PrintStream;

public class QQSettingMe$UpdateMyBusinessReceiver
  extends BroadcastReceiver
{
  public static final String a = "aciont_up_my_bus";
  private QQSettingMe a;
  
  public QQSettingMe$UpdateMyBusinessReceiver(QQSettingMe paramQQSettingMe)
  {
    this.a = paramQQSettingMe;
  }
  
  public static void a(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("aciont_up_my_bus"));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("aciont_up_my_bus".equals(paramIntent.getAction()))
    {
      System.out.println("UpdateMyBusinessReceiver receive a aciont_up_my_bus");
      this.a.p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.UpdateMyBusinessReceiver
 * JD-Core Version:    0.7.0.1
 */