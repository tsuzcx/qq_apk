package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.qphone.base.util.QLog;
import eeo;
import mqq.app.NewIntent;

public class ReportController
{
  protected static ReportController a;
  static final String a = "ReportController";
  protected static boolean a = false;
  public static final String b = "P_CliOper";
  public static final String c = "CliOper";
  @Deprecated
  public static final String d = "on_off";
  public static final String e = "CliStatus";
  public static final String f = "Pb_account_lifeservice";
  public static final String g = "Grp_tribe";
  public static final String h = "BizTechReport";
  private static final String i = "com.tencent.mobileqq.statistics.ReportControllerImpl";
  private static final String j = "${uin_unknown}";
  private static final String k = "${count_unknown}";
  
  /* Error */
  public static ReportController a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: getstatic 52	com/tencent/mobileqq/statistics/ReportController:jdField_a_of_type_Boolean	Z
    //   3: ifne +62 -> 65
    //   6: ldc 9
    //   8: monitorenter
    //   9: getstatic 52	com/tencent/mobileqq/statistics/ReportController:jdField_a_of_type_Boolean	Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +48 -> 62
    //   17: aload_0
    //   18: invokevirtual 57	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   21: invokevirtual 63	com/tencent/qphone/base/util/BaseApplication:getClassLoader	()Ljava/lang/ClassLoader;
    //   24: ldc 36
    //   26: invokevirtual 69	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   29: iconst_1
    //   30: anewarray 71	java/lang/Class
    //   33: dup
    //   34: iconst_0
    //   35: ldc 54
    //   37: aastore
    //   38: invokevirtual 75	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   41: iconst_1
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_0
    //   48: aastore
    //   49: invokevirtual 81	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 2	com/tencent/mobileqq/statistics/ReportController
    //   55: putstatic 83	com/tencent/mobileqq/statistics/ReportController:jdField_a_of_type_ComTencentMobileqqStatisticsReportController	Lcom/tencent/mobileqq/statistics/ReportController;
    //   58: iconst_1
    //   59: putstatic 52	com/tencent/mobileqq/statistics/ReportController:jdField_a_of_type_Boolean	Z
    //   62: ldc 9
    //   64: monitorexit
    //   65: getstatic 83	com/tencent/mobileqq/statistics/ReportController:jdField_a_of_type_ComTencentMobileqqStatisticsReportController	Lcom/tencent/mobileqq/statistics/ReportController;
    //   68: areturn
    //   69: astore_0
    //   70: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +12 -> 85
    //   76: ldc 9
    //   78: iconst_2
    //   79: ldc 91
    //   81: aload_0
    //   82: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   85: new 2	com/tencent/mobileqq/statistics/ReportController
    //   88: dup
    //   89: invokespecial 95	com/tencent/mobileqq/statistics/ReportController:<init>	()V
    //   92: putstatic 83	com/tencent/mobileqq/statistics/ReportController:jdField_a_of_type_ComTencentMobileqqStatisticsReportController	Lcom/tencent/mobileqq/statistics/ReportController;
    //   95: goto -33 -> 62
    //   98: astore_0
    //   99: ldc 9
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramQQAppInterface	QQAppInterface
    //   12	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	62	69	java/lang/Exception
    //   9	13	98	finally
    //   17	62	98	finally
    //   62	65	98	finally
    //   70	85	98	finally
    //   85	95	98	finally
    //   99	102	98	finally
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localStringBuilder.append(paramString1).append('|');
    }
    localStringBuilder.append(paramString2).append('|');
    localStringBuilder.append(paramString3).append('|');
    localStringBuilder.append(paramString4).append('|');
    localStringBuilder.append(paramString5).append('|');
    localStringBuilder.append(paramInt1).append('|');
    localStringBuilder.append("${count_unknown}").append('|');
    localStringBuilder.append(paramInt2).append('|');
    localStringBuilder.append(paramString6).append('|');
    localStringBuilder.append(paramString7).append('|');
    localStringBuilder.append(paramString8).append('|');
    localStringBuilder.append(paramString9).append('|');
    return localStringBuilder.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "stopReportLooper");
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    Object localObject = paramString2;
    if (paramString2.contains("${uin_unknown}")) {
      localObject = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
    }
    paramString2 = ((String)localObject).replace("${count_unknown}", Integer.toString(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "ReportRuntime: " + paramString1 + ", " + paramString2);
    }
    localObject = new NewIntent(paramQQAppInterface.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", paramString1);
    ((NewIntent)localObject).putExtra("content", paramString2);
    ((NewIntent)localObject).setWithouLogin(true);
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 == null) || (paramString4 == null) || (paramString5 == null)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.a, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt3);
      paramString2.putExtra("is_runtime", 1);
      BaseApplicationImpl.a().sendBroadcast(paramString2);
      return;
    }
    a(paramQQAppInterface, paramString1, a(paramString2, paramQQAppInterface.a(), paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, 1, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void a(PluginRuntime paramPluginRuntime)
  {
    paramPluginRuntime.setClickEventReportor(new eeo());
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportController", 2, "startReportLooper");
    }
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      if (paramBoolean) {
        break label36;
      }
    }
    label36:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.a(paramBoolean);
      return true;
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramString2 != null)
    {
      ReportController localReportController = a(paramQQAppInterface);
      if (localReportController != null)
      {
        String str = paramString2;
        if (paramString2.contains("${uin_unknown}")) {
          str = paramString2.replace("${uin_unknown}", paramQQAppInterface.a());
        }
        localReportController.a(paramString1, str, paramInt);
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if ((paramString2 == null) || (paramString4 == null) || (paramString5 == null)) {
      return;
    }
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(paramString2, "${uin_unknown}", paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9);
      paramString2 = new Intent();
      paramString2.setClassName(BaseApplicationImpl.a, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString2.putExtra("reporting_tag", paramString1);
      paramString2.putExtra("reporting_detail", paramQQAppInterface);
      paramString2.putExtra("reporting_count", paramInt2);
      paramString2.putExtra("is_runtime", 0);
      BaseApplicationImpl.a().sendBroadcast(paramString2);
      return;
    }
    b(paramQQAppInterface, paramString1, a(paramString2, paramQQAppInterface.a(), paramString3, paramString4, paramString5, paramInt1, paramInt3, paramString6, paramString7, paramString8, paramString9), paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, 1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  protected void a() {}
  
  protected void a(String paramString1, String paramString2, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportController
 * JD-Core Version:    0.7.0.1
 */