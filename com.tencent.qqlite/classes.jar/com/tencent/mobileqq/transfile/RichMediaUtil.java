package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import ehl;
import ehm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.ServerConfigManager.ConfigType;

public class RichMediaUtil
{
  public static final int a = 60000;
  public static final long a = 600000L;
  public static String a;
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Random jdField_a_of_type_JavaUtilRandom;
  private static boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "T", "U", "L" };
  public static final int b = 30000;
  private static final String jdField_b_of_type_JavaLangString = "RichMediaUtil";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final int c = 10000;
  private static String[] c;
  private static int jdField_d_of_type_Int;
  private static String[] jdField_d_of_type_ArrayOfJavaLangString;
  private static String[] e;
  private static String[] f;
  
  static
  {
    b = new String[] { "c2c", "grp", "dis" };
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_JavaUtilRandom = new Random();
    jdField_d_of_type_Int = -1;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 65537: 
    default: 
      return 65537;
    case 1: 
      return 1;
    }
    return 131075;
  }
  
  public static ServerAddr a(String paramString)
  {
    if (!Pattern.compile("https?://(\\d{1,3}\\.){3}\\d{1,3}(:\\d{1,5})?[/\\?].*").matcher(paramString).matches()) {
      return null;
    }
    ServerAddr localServerAddr = new ServerAddr();
    paramString = paramString.split("[/\\?]")[2].split(":");
    localServerAddr.jdField_a_of_type_JavaLangString = paramString[0];
    if (paramString.length == 2)
    {
      localServerAddr.b = Integer.valueOf(paramString[1]).intValue();
      return localServerAddr;
    }
    localServerAddr.b = 80;
    return localServerAddr;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 47	com/tencent/mobileqq/transfile/RichMediaUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 47	com/tencent/mobileqq/transfile/RichMediaUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: ldc 116
    //   20: putstatic 47	com/tencent/mobileqq/transfile/RichMediaUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokestatic 122	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   26: invokevirtual 128	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: invokestatic 122	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   32: invokevirtual 131	android/content/Context:getPackageName	()Ljava/lang/String;
    //   35: iconst_0
    //   36: invokevirtual 137	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   39: astore_0
    //   40: new 139	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   47: aload_0
    //   48: getfield 145	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   51: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 151
    //   56: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 154	android/content/pm/PackageInfo:versionCode	I
    //   63: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: putstatic 47	com/tencent/mobileqq/transfile/RichMediaUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: getstatic 47	com/tencent/mobileqq/transfile/RichMediaUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: astore_0
    //   76: goto -63 -> 13
    //   79: astore_0
    //   80: ldc 116
    //   82: putstatic 47	com/tencent/mobileqq/transfile/RichMediaUtil:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_0
    //   86: invokevirtual 163	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	64	0	localObject1	Object
    //   79	7	0	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   92	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	72	79	android/content/pm/PackageManager$NameNotFoundException
    //   3	13	92	finally
    //   18	23	92	finally
    //   23	72	92	finally
    //   72	76	92	finally
    //   80	89	92	finally
  }
  
  public static String a(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return "dw";
    case 1: 
      return "up";
    }
    return "fw";
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      Matcher localMatcher = Pattern.compile("http://([^/\\s]*)/").matcher(paramString);
      str = paramString;
      if (localMatcher.find()) {
        str = localMatcher.group(0);
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString2 != null)
      {
        str = paramString1;
        if (paramString2.length() > 0) {
          str = paramString1.replaceFirst("http://[^/\\s]*/", paramString2);
        }
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("Q.richmedia.");
    localStringBuilder.append(paramString4).append(".");
    localStringBuilder.append(paramString1).append(".");
    localStringBuilder.append(paramString2).append(".");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  private static ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = b;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str1 = arrayOfString1[i];
      String[] arrayOfString2 = jdField_a_of_type_ArrayOfJavaLangString;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString2[j];
        localArrayList.add(a(str1, "pic", paramString, str2));
        localArrayList.add(a(str1, "raw", paramString, str2));
        localArrayList.add(a(str1, "thu", paramString, str2));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(int paramInt)
  {
    a("image_sending", paramInt, a(), 10000, 600000L);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a("T", b(paramInt1), paramBoolean, c(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    a("U", b(paramInt1), paramBoolean, c(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void a(String paramString, int paramInt1, String[] paramArrayOfString, int paramInt2, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        return;
      }
      if ((paramInt2 < 2) || (jdField_a_of_type_JavaUtilRandom.nextInt(paramInt2) == 1) || (b())) {
        synchronized (jdField_a_of_type_JavaUtilHashMap)
        {
          jdField_a_of_type_Boolean = true;
          if ((QLog.isColorLevel()) || (jdField_a_of_type_Boolean)) {
            QLog.d("RichMediaUtil", 2, "activeReport start : " + paramString);
          }
          jdField_a_of_type_JavaUtilHashMap.put(paramString, new ehm(paramInt1, paramArrayOfString));
          QLog.startColorLog(paramArrayOfString);
          paramString = new ehl(paramString);
          new Timer().schedule(paramString, paramLong);
          return;
        }
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean)
    {
      paramString4 = "up";
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(" \tver:");
      localStringBuilder.append(a());
      if ("T".equals(paramString1))
      {
        localStringBuilder.append(" \ttid:");
        localStringBuilder.append(Thread.currentThread().getId());
      }
      paramString1 = a(paramString2, paramString3, paramString4, paramString1);
      if (paramThrowable == null) {
        break label150;
      }
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    label150:
    while ((!QLog.isColorLevel()) && (!jdField_a_of_type_Boolean))
    {
      return;
      paramString4 = "dw";
      break;
    }
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
      {
        if ((QLog.isColorLevel()) || (jdField_a_of_type_Boolean)) {
          QLog.d("RichMediaUtil", 2, "activeReport stop : " + paramString1 + ", " + paramBoolean);
        }
        paramString1 = (ehm)jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
        if (paramString1 != null) {
          QLog.endColorLog(paramString1.jdField_a_of_type_ArrayOfJavaLangString, paramString1.jdField_a_of_type_Int, paramBoolean, paramString2);
        }
        if (jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
          jdField_a_of_type_Boolean = false;
        }
      }
      return;
    }
  }
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a("T", paramString1, paramBoolean, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "image_sending";
    }
    a("image_sending", paramBoolean, str);
  }
  
  public static final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static String[] a()
  {
    if (c != null) {
      return c;
    }
    ArrayList localArrayList = a("up");
    c = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return c;
  }
  
  public static String b(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return "c2c";
    case 1: 
      return "grp";
    }
    return "dis";
  }
  
  private static ArrayList b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = b;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString1[i];
      String[] arrayOfString2 = jdField_a_of_type_ArrayOfJavaLangString;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        localArrayList.add(a(str, "ptt", paramString, arrayOfString2[j]));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void b(int paramInt)
  {
    a("image_receive", paramInt, b(), 10000, 600000L);
  }
  
  public static void b(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a("U", b(paramInt1), paramBoolean, c(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void b(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    b("L", b(paramInt1), paramBoolean, c(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean)
    {
      paramString4 = "up";
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(" \tver:");
      localStringBuilder.append(a());
      if ("T".equals(paramString1))
      {
        localStringBuilder.append(" \ttid:");
        localStringBuilder.append(Thread.currentThread().getId());
      }
      paramString1 = a(paramString2, paramString3, paramString4, paramString1);
      if (paramThrowable == null) {
        break label150;
      }
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    label150:
    while ((!QLog.isColorLevel()) && (!jdField_a_of_type_Boolean))
    {
      return;
      paramString4 = "dw";
      break;
    }
    QLog.e(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "image_receive";
    }
    a("image_receive", paramBoolean, str);
  }
  
  private static boolean b()
  {
    if (jdField_d_of_type_Int == -1)
    {
      String str = QQUtils.a(ServerConfigManager.ConfigType.app, "active_log_upload");
      if ((str == null) || (!str.equals("1"))) {
        break label44;
      }
    }
    label44:
    for (jdField_d_of_type_Int = 1; jdField_d_of_type_Int == 1; jdField_d_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  public static String[] b()
  {
    if (jdField_d_of_type_ArrayOfJavaLangString != null) {
      return jdField_d_of_type_ArrayOfJavaLangString;
    }
    ArrayList localArrayList = a("dw");
    jdField_d_of_type_ArrayOfJavaLangString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return jdField_d_of_type_ArrayOfJavaLangString;
  }
  
  public static String c(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 65537: 
      return "thu";
    case 1: 
      return "pic";
    case 65538: 
      return "emo";
    case 131075: 
      return "raw";
    case 2: 
      return "ptt";
    case 0: 
      return "fil";
    case 131078: 
      return "msg";
    case 131076: 
      return "url";
    }
    return "shortvideo";
  }
  
  public static void c(int paramInt)
  {
    a("ptt_recv", paramInt, c(), 10000, 600000L);
  }
  
  public static void c(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    a("L", b(paramInt1), paramBoolean, c(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void c(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "ptt_recv";
    }
    a("ptt_recv", paramBoolean, str);
  }
  
  public static String[] c()
  {
    if (f != null) {
      return f;
    }
    ArrayList localArrayList = b("dw");
    f = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return f;
  }
  
  public static String[] d()
  {
    if (e != null) {
      return e;
    }
    ArrayList localArrayList = a("up");
    localArrayList.addAll(a("dw"));
    e = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaUtil
 * JD-Core Version:    0.7.0.1
 */