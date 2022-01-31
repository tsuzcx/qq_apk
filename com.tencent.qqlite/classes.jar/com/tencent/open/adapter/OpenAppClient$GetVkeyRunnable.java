package com.tencent.open.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import mqq.app.AppRuntime;

public class OpenAppClient$GetVkeyRunnable
  implements Runnable
{
  protected int a;
  protected Activity a;
  protected String a;
  protected AppRuntime a;
  
  public OpenAppClient$GetVkeyRunnable(Activity paramActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public OpenAppClient$GetVkeyRunnable(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    String str1 = null;
    if (!APNUtil.d(CommonDataAdapter.a().a())) {}
    while (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    String str2;
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface))
    {
      str2 = ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a();
      str1 = ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).d();
    }
    for (;;)
    {
      if ((str2 != null) && (!str2.equals(String.valueOf(CommonDataAdapter.a().a())))) {
        CommonDataAdapter.a().a(Long.valueOf(str2).longValue());
      }
      if (!TextUtils.isEmpty(str1))
      {
        LogUtility.b(OpenAppClient.jdField_a_of_type_JavaLangString, "Get vkey success");
        CommonDataAdapter.a().a(str1);
      }
      OpenAppClient.jdField_a_of_type_Boolean = false;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        AppClient.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, str2, str1);
        return;
        if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof BrowserAppInterface))
        {
          str2 = ((BrowserAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getAccount();
          str1 = ((BrowserAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).b();
        }
        break;
      case 2: 
        AppClient.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, str2, str1);
        return;
        str2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient.GetVkeyRunnable
 * JD-Core Version:    0.7.0.1
 */