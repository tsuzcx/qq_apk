package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class SubAccountAssistantForward
{
  public static final String a = "sub.account.unbind";
  public static final String b = "sub.account.switchAccount";
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubaccountUgActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1980);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubAccountBindActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessageDelayed(1990, paramLong);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramString = SubAccountAssistantManager.a();
    boolean bool = false;
    String str = paramString.a(paramQQAppInterface);
    if (!TextUtils.isEmpty(str)) {
      bool = paramString.a(paramQQAppInterface, str);
    }
    if (bool)
    {
      paramContext.startActivity(new Intent(paramContext, SubAccountMessageActivity.class));
      return;
    }
    paramContext.startActivity(new Intent(paramContext, SubaccountUgActivity.class));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubAccountBindActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1981);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubAccountBindActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessageDelayed(2001, paramLong);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubLoginActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1982);
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(LoginPhoneNumActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.sendEmptyMessage(2014);
  }
  
  public static void e(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubAccountSettingActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1985);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountAssistantForward
 * JD-Core Version:    0.7.0.1
 */