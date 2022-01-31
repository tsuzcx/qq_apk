package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class ReportReceiver
  extends BroadcastReceiver
{
  public static final int a = 0;
  public static final String a = "com.tencent.mobileqq.action.REPORT";
  public static final int b = 1;
  public static final String b = "com.tencent.mobileqq.action.REPORT_RUNTIME";
  static final String c = "reporting_tag";
  static final String d = "reporting_detail";
  static final String e = "reporting_count";
  static final String f = "is_runtime";
  static final String g = "com.tencent.mobileqq.statistics.ReportReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.getAction();
    paramContext = (QQAppInterface)BaseApplicationImpl.a().a();
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        String str1 = paramIntent.getStringExtra("reporting_tag");
        String str2 = paramIntent.getStringExtra("reporting_detail");
        int i = paramIntent.getIntExtra("reporting_count", 1);
        int j = paramIntent.getIntExtra("is_runtime", -1);
        if (j == 0)
        {
          ReportController.b(paramContext, str1, str2, i);
          return;
        }
        if (j == 1)
        {
          ReportController.a(paramContext, str1, str2, i);
          return;
        }
      }
      catch (Exception paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver
 * JD-Core Version:    0.7.0.1
 */