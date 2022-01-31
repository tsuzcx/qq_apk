package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.component.cache.CacheManager;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenAppClient
{
  protected static int a = 0;
  public static final String a;
  protected static boolean a = false;
  protected static int b = 0;
  public static final String b = "schemaurl";
  protected static final int c = 0;
  public static final String c = "uin";
  protected static final int d = 1;
  public static final String d = "vkey";
  protected static final int e = 2;
  protected static String e = null;
  protected static final int f = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = OpenAppClient.class.getName();
    jdField_a_of_type_Int = 7;
    b = 11;
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      Object localObject;
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        str2 = paramBundle.getString("schemaurl");
        localObject = paramBundle.getString("uin");
        String str1 = paramBundle.getString("vkey");
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).equals("0")) {}
        }
        else
        {
          paramBundle = String.valueOf(CommonDataAdapter.a().a());
        }
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = CommonDataAdapter.a().a();
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ThreadManager.b(new OpenAppClient.GetVkeyRunnable(paramActivity, 1, str2));
          continue;
        }
        jdField_a_of_type_Boolean = false;
      }
      finally {}
      AppClient.a(paramActivity, str2, paramBundle, (String)localObject);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "onPcPushMsgForground " + paramString);
    if (APNUtil.c(paramContext)) {
      a(paramContext, Common.a(paramString));
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    CacheManager.a(CommonDataAdapter.a().a());
    Object localObject = "";
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label60;
      }
      localObject = ((QQAppInterface)paramAppInterface).getAccount();
      ((QQAppInterface)paramAppInterface).d();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      label60:
      try
      {
        CommonDataAdapter.a().a(Long.valueOf((String)localObject).longValue());
        return;
      }
      catch (Exception paramAppInterface) {}
      if ((paramAppInterface instanceof BrowserAppInterface))
      {
        String str = ((BrowserAppInterface)paramAppInterface).getAccount();
        localObject = str;
        if (TextUtils.isEmpty(e))
        {
          ThreadManager.a(new OpenAppClient.GetVkeyRunnable(paramAppInterface, 0, ""));
          localObject = str;
        }
      }
    }
  }
  
  /* Error */
  protected static boolean a(Context paramContext, java.util.HashMap paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 172	java/util/HashMap:size	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ldc 174
    //   16: invokevirtual 178	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 55	java/lang/String
    //   22: invokestatic 184	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: iload_2
    //   27: iconst_1
    //   28: if_icmpne +68 -> 96
    //   31: aload_1
    //   32: ldc 186
    //   34: invokevirtual 178	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 55	java/lang/String
    //   40: invokestatic 191	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)Z
    //   43: istore_3
    //   44: iload_3
    //   45: ifeq +20 -> 65
    //   48: iconst_0
    //   49: ireturn
    //   50: astore_0
    //   51: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: ldc 193
    //   56: aload_0
    //   57: invokestatic 196	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: iconst_m1
    //   61: istore_2
    //   62: goto -36 -> 26
    //   65: iconst_1
    //   66: ireturn
    //   67: astore_0
    //   68: new 97	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   75: ldc 198
    //   77: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_1
    //   88: getstatic 32	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_1
    //   92: aload_0
    //   93: invokestatic 203	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: iconst_0
    //   97: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramHashMap	java.util.HashMap
    //   25	37	2	i	int
    //   43	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	26	50	java/lang/NumberFormatException
    //   31	44	67	java/lang/Exception
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        str2 = paramBundle.getString("schemaurl");
        str1 = paramBundle.getString("uin");
        paramBundle = paramBundle.getString("vkey");
        if (TextUtils.isEmpty(str2))
        {
          jdField_a_of_type_Boolean = false;
          continue;
        }
        try
        {
          str2 = new URL(str2).getQuery();
          if (!TextUtils.isEmpty(paramBundle)) {
            break label112;
          }
          ThreadManager.a(new OpenAppClient.GetVkeyRunnable(paramActivity, 2, str2));
        }
        catch (MalformedURLException paramActivity)
        {
          paramActivity.printStackTrace();
          jdField_a_of_type_Boolean = false;
        }
      }
      finally {}
      continue;
      label112:
      jdField_a_of_type_Boolean = false;
      AppClient.b(paramActivity, str2, str1, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient
 * JD-Core Version:    0.7.0.1
 */