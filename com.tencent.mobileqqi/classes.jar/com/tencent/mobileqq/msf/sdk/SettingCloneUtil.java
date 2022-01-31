package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class SettingCloneUtil
{
  private static final String KEY_FILE = "set_sp";
  private static final String QQSETTING_SCREENSHOT_KEY = "qqsetting_screenshot_key";
  private static Object locker = new Object();
  private static boolean mHasInit = false;
  private static final HashMap mapKv = new HashMap();
  
  public static void clearAllSetting()
  {
    mHasInit = false;
    mapKv.clear();
  }
  
  public static boolean firstInit(String paramString1, String paramString2, String paramString3)
  {
    synchronized (locker)
    {
      if (mapKv.containsKey(paramString1))
      {
        paramString2 = (String)mapKv.get(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("set_sp", 2, "containsKey is true, key=" + paramString1 + " v=" + paramString2 + " tag=" + paramString3);
        }
      }
    }
    try
    {
      bool = Boolean.parseBoolean(paramString2);
      for (;;)
      {
        return bool;
        if ((paramString1 != null) && (!paramString1.equals("qqsetting_screenshot_key"))) {
          mapKv.put(paramString1, paramString2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("set_sp", 2, "key is new, key=" + paramString1 + " v=" + paramString2 + " tag=" + paramString3);
        }
        try
        {
          bool = Boolean.parseBoolean(paramString2);
        }
        catch (Exception paramString1)
        {
          bool = false;
        }
      }
      paramString1 = finally;
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public static int firstInitForInt(String paramString1, String paramString2, String paramString3)
  {
    synchronized (locker)
    {
      if (mapKv.containsKey(paramString1))
      {
        paramString2 = (String)mapKv.get(paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("set_sp", 2, "containsKey is true, key=" + paramString1 + " v=" + paramString2 + " tag=" + paramString3);
        }
      }
    }
    try
    {
      i = Integer.parseInt(paramString2);
      for (;;)
      {
        return i;
        mapKv.put(paramString1, paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("set_sp", 2, "key is new, key=" + paramString1 + " v=" + paramString2 + " tag=" + paramString3);
        }
        try
        {
          i = Integer.parseInt(paramString2);
        }
        catch (Exception paramString1)
        {
          i = -1;
        }
      }
      paramString1 = finally;
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
  
  public static String get(String paramString)
  {
    String str = null;
    synchronized (locker)
    {
      if (mapKv.containsKey(paramString)) {
        str = (String)mapKv.get(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "get k=" + paramString + " v=" + str);
      }
      return str;
    }
  }
  
  public static boolean isContainValue(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramContext == null)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("set_sp", 2, "isContainValue().ctx is null.");
        bool1 = bool2;
      }
    }
    FileInputStream localFileInputStream2;
    for (;;)
    {
      return bool1;
      String str = paramString3;
      if (paramString1 != null)
      {
        str = paramString3;
        if (paramString1.length() > 0) {
          str = paramString3 + paramString1;
        }
      }
      Properties localProperties;
      FileInputStream localFileInputStream1;
      if (isKeyFileExists(paramContext))
      {
        localProperties = null;
        localFileInputStream2 = null;
        localFileInputStream1 = localFileInputStream2;
        paramString3 = localProperties;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          localFileInputStream1 = localFileInputStream2;
          paramString3 = localProperties;
          QLog.d("set_sp", 2, "isContainValue().load key_file ing...");
        }
        localFileInputStream1 = localFileInputStream2;
        paramString3 = localProperties;
        localFileInputStream2 = paramContext.openFileInput("set_sp");
        localFileInputStream1 = localFileInputStream2;
        paramString3 = localFileInputStream2;
        localProperties = new Properties();
        localFileInputStream1 = localFileInputStream2;
        paramString3 = localFileInputStream2;
        localProperties.load(localFileInputStream2);
        localFileInputStream1 = localFileInputStream2;
        paramString3 = localFileInputStream2;
        if (QLog.isColorLevel())
        {
          localFileInputStream1 = localFileInputStream2;
          paramString3 = localFileInputStream2;
          QLog.d("set_sp", 2, "isContainValue().load key_file ok");
        }
        localFileInputStream1 = localFileInputStream2;
        paramString3 = localFileInputStream2;
        bool1 = localProperties.containsKey(str);
        if (bool1)
        {
          bool1 = true;
          if (localFileInputStream2 == null) {
            continue;
          }
          try
          {
            localFileInputStream2.close();
            return true;
          }
          catch (Throwable paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("set_sp", 2, "isContainValue().read finally. exception:" + String.valueOf(paramContext));
            }
            paramContext.printStackTrace();
            return true;
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        paramString3 = localFileInputStream1;
        if (QLog.isColorLevel())
        {
          paramString3 = localFileInputStream1;
          QLog.d("set_sp", 2, "isContainValue().read exception:" + String.valueOf(localThrowable3));
        }
        paramString3 = localFileInputStream1;
        localThrowable3.printStackTrace();
        if (localFileInputStream1 == null) {}
      }
      finally
      {
        try
        {
          localFileInputStream1.close();
          bool1 = bool2;
          if (TextUtils.isEmpty(paramString2)) {
            continue;
          }
          paramString3 = PreferenceManager.getDefaultSharedPreferences(paramContext);
          paramContext = paramString2;
          if (paramString1 != null)
          {
            paramContext = paramString2;
            if (paramString1.length() > 0) {
              paramContext = paramString2 + paramString1;
            }
          }
          bool2 = paramString3.contains(paramContext);
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("set_sp", 2, "isContainValue().read sp ok, ret =" + bool2);
          return bool2;
        }
        catch (Throwable localThrowable1)
        {
          paramString3 = localThrowable1;
          if (!QLog.isColorLevel()) {
            break label515;
          }
          QLog.d("set_sp", 2, "isContainValue().read finally. exception:" + String.valueOf(localThrowable1));
          paramString3 = localThrowable1;
        }
        paramContext = finally;
        if (paramString3 != null) {}
        try
        {
          paramString3.close();
          throw paramContext;
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("set_sp", 2, "isContainValue().read finally. exception:" + String.valueOf(paramString1));
            }
            paramString1.printStackTrace();
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        label515:
        paramString3.printStackTrace();
        break;
        if (localFileInputStream2 == null) {
          break;
        }
        try
        {
          localFileInputStream2.close();
        }
        catch (Throwable localThrowable2)
        {
          paramString3 = localThrowable2;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("set_sp", 2, "isContainValue().read finally. exception:" + String.valueOf(localThrowable2));
        paramString3 = localThrowable2;
      }
    }
  }
  
  private static boolean isKeyFileExists(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getFileStreamPath("set_sp") != null)
      {
        bool1 = bool2;
        if (paramContext.getFileStreamPath("set_sp").exists()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("set_sp", 2, "file exist:" + bool1);
    }
    return bool1;
  }
  
  public static void put(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("set_sp", 2, "put k=" + paramString1 + " v=" + paramString2);
    }
    synchronized (locker)
    {
      mapKv.put(paramString1, paramString2);
      return;
    }
  }
  
  /* Error */
  private static String readFromFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mHasInit	Z
    //   3: ifeq +10 -> 13
    //   6: aload_1
    //   7: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +504 -> 514
    //   13: aload_0
    //   14: invokestatic 117	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isKeyFileExists	(Landroid/content/Context;)Z
    //   17: ifeq +497 -> 514
    //   20: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +11 -> 34
    //   26: ldc 8
    //   28: iconst_2
    //   29: ldc 191
    //   31: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: ldc 8
    //   37: invokevirtual 125	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_0
    //   43: new 127	java/util/Properties
    //   46: dup
    //   47: invokespecial 128	java/util/Properties:<init>	()V
    //   50: astore_3
    //   51: aload_2
    //   52: astore_0
    //   53: aload_3
    //   54: aload_2
    //   55: invokevirtual 132	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   58: aload_2
    //   59: astore_0
    //   60: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq +13 -> 76
    //   66: aload_2
    //   67: astore_0
    //   68: ldc 8
    //   70: iconst_2
    //   71: ldc 193
    //   73: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_2
    //   77: astore_0
    //   78: aload_1
    //   79: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifeq +298 -> 380
    //   85: aload_2
    //   86: astore_0
    //   87: aload_3
    //   88: invokevirtual 197	java/util/Properties:keySet	()Ljava/util/Set;
    //   91: invokeinterface 203 1 0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: aload_1
    //   100: invokeinterface 208 1 0
    //   105: ifeq +214 -> 319
    //   108: aload_2
    //   109: astore_0
    //   110: aload_1
    //   111: invokeinterface 212 1 0
    //   116: astore 4
    //   118: aload_2
    //   119: astore_0
    //   120: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +31 -> 154
    //   126: aload_2
    //   127: astore_0
    //   128: ldc 8
    //   130: iconst_2
    //   131: new 58	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   138: ldc 214
    //   140: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 4
    //   145: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_2
    //   155: astore_0
    //   156: aload 4
    //   158: instanceof 50
    //   161: ifeq -64 -> 97
    //   164: aload_2
    //   165: astore_0
    //   166: aload 4
    //   168: checkcast 50	java/lang/String
    //   171: astore 4
    //   173: aload_2
    //   174: astore_0
    //   175: aload_3
    //   176: aload 4
    //   178: invokevirtual 220	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 5
    //   183: aload_2
    //   184: astore_0
    //   185: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +41 -> 229
    //   191: aload_2
    //   192: astore_0
    //   193: ldc 8
    //   195: iconst_2
    //   196: new 58	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   203: ldc 222
    //   205: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 4
    //   210: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 224
    //   215: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 5
    //   220: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload 4
    //   231: ifnull -134 -> 97
    //   234: aload_2
    //   235: astore_0
    //   236: aload 4
    //   238: ldc 11
    //   240: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   243: ifne -146 -> 97
    //   246: aload_2
    //   247: astore_0
    //   248: getstatic 31	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mapKv	Ljava/util/HashMap;
    //   251: aload 4
    //   253: aload 5
    //   255: invokevirtual 90	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: pop
    //   259: goto -162 -> 97
    //   262: astore_1
    //   263: aload_2
    //   264: astore_0
    //   265: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +33 -> 301
    //   271: aload_2
    //   272: astore_0
    //   273: ldc 8
    //   275: iconst_2
    //   276: new 58	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   283: ldc 226
    //   285: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_1
    //   289: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   292: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_2
    //   302: astore_0
    //   303: aload_1
    //   304: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
    //   307: aload_2
    //   308: ifnull +7 -> 315
    //   311: aload_2
    //   312: invokevirtual 140	java/io/FileInputStream:close	()V
    //   315: aconst_null
    //   316: astore_1
    //   317: aload_1
    //   318: areturn
    //   319: aload_2
    //   320: astore_0
    //   321: iconst_1
    //   322: putstatic 26	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mHasInit	Z
    //   325: aconst_null
    //   326: astore_0
    //   327: aload_0
    //   328: astore_1
    //   329: aload_2
    //   330: ifnull -13 -> 317
    //   333: aload_2
    //   334: invokevirtual 140	java/io/FileInputStream:close	()V
    //   337: aload_0
    //   338: areturn
    //   339: astore_1
    //   340: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +31 -> 374
    //   346: ldc 8
    //   348: iconst_2
    //   349: new 58	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   356: ldc 228
    //   358: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_1
    //   362: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload_1
    //   375: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
    //   378: aload_0
    //   379: areturn
    //   380: aload_2
    //   381: astore_0
    //   382: aload_3
    //   383: aload_1
    //   384: invokevirtual 135	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   387: ifeq +122 -> 509
    //   390: aload_2
    //   391: astore_0
    //   392: aload_3
    //   393: aload_1
    //   394: invokevirtual 220	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   397: astore_1
    //   398: aload_1
    //   399: astore_0
    //   400: goto -73 -> 327
    //   403: astore_0
    //   404: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +31 -> 438
    //   410: ldc 8
    //   412: iconst_2
    //   413: new 58	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   420: ldc 228
    //   422: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   429: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload_0
    //   439: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
    //   442: aconst_null
    //   443: areturn
    //   444: astore_1
    //   445: aconst_null
    //   446: astore_0
    //   447: aload_0
    //   448: ifnull +7 -> 455
    //   451: aload_0
    //   452: invokevirtual 140	java/io/FileInputStream:close	()V
    //   455: aload_1
    //   456: athrow
    //   457: astore_0
    //   458: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq +31 -> 492
    //   464: ldc 8
    //   466: iconst_2
    //   467: new 58	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   474: ldc 228
    //   476: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   483: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload_0
    //   493: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
    //   496: goto -41 -> 455
    //   499: astore_1
    //   500: goto -53 -> 447
    //   503: astore_1
    //   504: aconst_null
    //   505: astore_2
    //   506: goto -243 -> 263
    //   509: aconst_null
    //   510: astore_0
    //   511: goto -184 -> 327
    //   514: aconst_null
    //   515: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	paramContext	Context
    //   0	516	1	paramString	String
    //   40	466	2	localFileInputStream	FileInputStream
    //   50	343	3	localProperties	Properties
    //   116	136	4	localObject	Object
    //   181	73	5	str	String
    // Exception table:
    //   from	to	target	type
    //   43	51	262	java/lang/Throwable
    //   53	58	262	java/lang/Throwable
    //   60	66	262	java/lang/Throwable
    //   68	76	262	java/lang/Throwable
    //   78	85	262	java/lang/Throwable
    //   87	97	262	java/lang/Throwable
    //   99	108	262	java/lang/Throwable
    //   110	118	262	java/lang/Throwable
    //   120	126	262	java/lang/Throwable
    //   128	154	262	java/lang/Throwable
    //   156	164	262	java/lang/Throwable
    //   166	173	262	java/lang/Throwable
    //   175	183	262	java/lang/Throwable
    //   185	191	262	java/lang/Throwable
    //   193	229	262	java/lang/Throwable
    //   236	246	262	java/lang/Throwable
    //   248	259	262	java/lang/Throwable
    //   321	325	262	java/lang/Throwable
    //   382	390	262	java/lang/Throwable
    //   392	398	262	java/lang/Throwable
    //   333	337	339	java/lang/Throwable
    //   311	315	403	java/lang/Throwable
    //   20	34	444	finally
    //   34	41	444	finally
    //   451	455	457	java/lang/Throwable
    //   43	51	499	finally
    //   53	58	499	finally
    //   60	66	499	finally
    //   68	76	499	finally
    //   78	85	499	finally
    //   87	97	499	finally
    //   99	108	499	finally
    //   110	118	499	finally
    //   120	126	499	finally
    //   128	154	499	finally
    //   156	164	499	finally
    //   166	173	499	finally
    //   175	183	499	finally
    //   185	191	499	finally
    //   193	229	499	finally
    //   236	246	499	finally
    //   248	259	499	finally
    //   265	271	499	finally
    //   273	301	499	finally
    //   303	307	499	finally
    //   321	325	499	finally
    //   382	390	499	finally
    //   392	398	499	finally
    //   20	34	503	java/lang/Throwable
    //   34	41	503	java/lang/Throwable
  }
  
  public static boolean readValue(Context paramContext, String paramString1, String paramString2, String arg3, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "read boolean. ctx is null.defV=" + paramBoolean);
      }
    }
    String str;
    do
    {
      do
      {
        return paramBoolean;
        str = ???;
        if (paramString1 != null)
        {
          str = ???;
          if (paramString1.length() > 0) {
            str = ??? + paramString1;
          }
        }
        ??? = get(str);
        if (??? != null)
        {
          if (Boolean.parseBoolean(???)) {}
          for (paramBoolean = bool1;; paramBoolean = false) {
            return paramBoolean;
          }
        }
        if ((str != null) && (!str.equals("qqsetting_screenshot_key"))) {
          for (;;)
          {
            synchronized (locker)
            {
              readFromFile(paramContext, null);
              ??? = get(str);
              if (??? == null) {
                break;
              }
              if (Boolean.parseBoolean(???))
              {
                paramBoolean = bool2;
                return paramBoolean;
              }
            }
            paramBoolean = false;
          }
        }
        paramContext = readFromFile(paramContext, str);
      } while (TextUtils.isEmpty(paramContext));
      return Boolean.parseBoolean(paramContext);
    } while (TextUtils.isEmpty(paramString2));
    ??? = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (paramString1 != null)
    {
      paramContext = paramString2;
      if (paramString1.length() > 0) {
        paramContext = paramString2 + paramString1;
      }
    }
    paramBoolean = ???.getBoolean(paramContext, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("set_sp", 2, "read boolean. sp ok, k=" + paramContext + " v=" + paramBoolean);
    }
    return firstInit(str, Boolean.toString(paramBoolean), "sp");
  }
  
  public static int readValueForInt(Context paramContext, String paramString1, String paramString2, String arg3, int paramInt)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "read int.ctx is null.defV=" + paramInt);
      }
    }
    String str;
    do
    {
      return paramInt;
      str = ???;
      if (paramString1 != null)
      {
        str = ???;
        if (paramString1.length() > 0) {
          str = ??? + paramString1;
        }
      }
      ??? = get(str);
      int i;
      if (??? != null) {
        try
        {
          i = Integer.parseInt(???);
          return i;
        }
        catch (Exception ???)
        {
          if (QLog.isColorLevel()) {
            QLog.d("set_sp", 2, "read int.parse int exception =" + String.valueOf(???));
          }
        }
      }
      synchronized (locker)
      {
        readFromFile(paramContext, null);
        ??? = get(str);
        if (??? == null) {
          continue;
        }
      }
      try
      {
        i = Integer.parseInt(???);
        return i;
      }
      catch (NumberFormatException ???)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("set_sp", 2, "read int.parse int exception =" + String.valueOf(???));
      }
      paramContext = finally;
      throw paramContext;
    } while (TextUtils.isEmpty(paramString2));
    ??? = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (paramString1 != null)
    {
      paramContext = paramString2;
      if (paramString1.length() > 0) {
        paramContext = paramString2 + paramString1;
      }
    }
    paramInt = ???.getInt(paramContext, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("set_sp", 2, "read int.read sp ok, k=" + paramContext + " v=" + paramInt);
    }
    return firstInitForInt(str, Integer.toString(paramInt), "sp");
  }
  
  /* Error */
  public static void writeValue(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 8
    //   12: aload_0
    //   13: ifnonnull +19 -> 32
    //   16: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +12 -> 31
    //   22: ldc 8
    //   24: iconst_2
    //   25: ldc_w 275
    //   28: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: return
    //   32: aload_3
    //   33: astore 9
    //   35: aload_1
    //   36: ifnull +33 -> 69
    //   39: aload_3
    //   40: astore 9
    //   42: aload_1
    //   43: invokevirtual 113	java/lang/String:length	()I
    //   46: ifle +23 -> 69
    //   49: new 58	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   56: aload_3
    //   57: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 9
    //   69: getstatic 24	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:locker	Ljava/lang/Object;
    //   72: astore 12
    //   74: aload 12
    //   76: monitorenter
    //   77: aload 9
    //   79: iload 4
    //   81: invokestatic 245	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   84: invokestatic 277	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: new 127	java/util/Properties
    //   90: dup
    //   91: invokespecial 128	java/util/Properties:<init>	()V
    //   94: astore 13
    //   96: aload_0
    //   97: invokestatic 117	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isKeyFileExists	(Landroid/content/Context;)Z
    //   100: ifeq +821 -> 921
    //   103: aload_0
    //   104: ldc 8
    //   106: invokevirtual 125	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   109: astore 6
    //   111: aload 10
    //   113: astore 5
    //   115: aload 6
    //   117: astore_3
    //   118: aload 11
    //   120: astore 8
    //   122: aload 6
    //   124: astore 7
    //   126: aload 13
    //   128: aload 6
    //   130: invokevirtual 132	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   133: aload 10
    //   135: astore 5
    //   137: aload 6
    //   139: astore_3
    //   140: aload 11
    //   142: astore 8
    //   144: aload 6
    //   146: astore 7
    //   148: aload 6
    //   150: invokevirtual 140	java/io/FileInputStream:close	()V
    //   153: aload 10
    //   155: astore 5
    //   157: aload 6
    //   159: astore_3
    //   160: aload 11
    //   162: astore 8
    //   164: aload 6
    //   166: astore 7
    //   168: aload 13
    //   170: aload 9
    //   172: iload 4
    //   174: invokestatic 245	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   177: invokevirtual 281	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 10
    //   183: astore 5
    //   185: aload 6
    //   187: astore_3
    //   188: aload 11
    //   190: astore 8
    //   192: aload 6
    //   194: astore 7
    //   196: aload_0
    //   197: ldc 8
    //   199: iconst_0
    //   200: invokevirtual 285	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   203: astore 10
    //   205: aload 10
    //   207: astore 5
    //   209: aload 6
    //   211: astore_3
    //   212: aload 10
    //   214: astore 8
    //   216: aload 6
    //   218: astore 7
    //   220: aload 13
    //   222: aload 10
    //   224: aconst_null
    //   225: invokevirtual 289	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   228: aload 10
    //   230: astore 5
    //   232: aload 6
    //   234: astore_3
    //   235: aload 10
    //   237: astore 8
    //   239: aload 6
    //   241: astore 7
    //   243: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +55 -> 301
    //   249: aload 10
    //   251: astore 5
    //   253: aload 6
    //   255: astore_3
    //   256: aload 10
    //   258: astore 8
    //   260: aload 6
    //   262: astore 7
    //   264: ldc 8
    //   266: iconst_2
    //   267: new 58	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 291
    //   277: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 9
    //   282: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc 67
    //   287: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload 4
    //   292: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   295: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_2
    //   302: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +106 -> 411
    //   308: aload_2
    //   309: astore_3
    //   310: aload_1
    //   311: ifnull +31 -> 342
    //   314: aload_2
    //   315: astore_3
    //   316: aload_1
    //   317: invokevirtual 113	java/lang/String:length	()I
    //   320: ifle +22 -> 342
    //   323: new 58	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   330: aload_2
    //   331: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_1
    //   335: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: astore_3
    //   342: aload_0
    //   343: invokestatic 163	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   346: astore_0
    //   347: aload_0
    //   348: aload_3
    //   349: invokeinterface 168 2 0
    //   354: ifeq +57 -> 411
    //   357: aload_0
    //   358: invokeinterface 295 1 0
    //   363: astore_0
    //   364: aload_0
    //   365: aload_3
    //   366: invokeinterface 301 2 0
    //   371: pop
    //   372: aload_0
    //   373: invokeinterface 304 1 0
    //   378: pop
    //   379: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +29 -> 411
    //   385: ldc 8
    //   387: iconst_2
    //   388: new 58	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 306
    //   398: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_3
    //   402: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 6
    //   413: ifnull +8 -> 421
    //   416: aload 6
    //   418: invokevirtual 140	java/io/FileInputStream:close	()V
    //   421: aload 10
    //   423: ifnull +8 -> 431
    //   426: aload 10
    //   428: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   431: aload 12
    //   433: monitorexit
    //   434: return
    //   435: astore_0
    //   436: aload 12
    //   438: monitorexit
    //   439: aload_0
    //   440: athrow
    //   441: astore 6
    //   443: aconst_null
    //   444: astore 7
    //   446: aload 8
    //   448: astore 5
    //   450: aload 7
    //   452: astore_3
    //   453: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +40 -> 496
    //   459: aload 8
    //   461: astore 5
    //   463: aload 7
    //   465: astore_3
    //   466: ldc 8
    //   468: iconst_2
    //   469: new 58	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 311
    //   479: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 6
    //   484: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   487: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 8
    //   498: astore 5
    //   500: aload 7
    //   502: astore_3
    //   503: aload 6
    //   505: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
    //   508: aload_2
    //   509: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: ifne +106 -> 618
    //   515: aload_2
    //   516: astore_3
    //   517: aload_1
    //   518: ifnull +31 -> 549
    //   521: aload_2
    //   522: astore_3
    //   523: aload_1
    //   524: invokevirtual 113	java/lang/String:length	()I
    //   527: ifle +22 -> 549
    //   530: new 58	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   537: aload_2
    //   538: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_1
    //   542: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: astore_3
    //   549: aload_0
    //   550: invokestatic 163	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   553: astore_0
    //   554: aload_0
    //   555: aload_3
    //   556: invokeinterface 168 2 0
    //   561: ifeq +57 -> 618
    //   564: aload_0
    //   565: invokeinterface 295 1 0
    //   570: astore_0
    //   571: aload_0
    //   572: aload_3
    //   573: invokeinterface 301 2 0
    //   578: pop
    //   579: aload_0
    //   580: invokeinterface 304 1 0
    //   585: pop
    //   586: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq +29 -> 618
    //   592: ldc 8
    //   594: iconst_2
    //   595: new 58	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 306
    //   605: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload_3
    //   609: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload 7
    //   620: ifnull +8 -> 628
    //   623: aload 7
    //   625: invokevirtual 140	java/io/FileInputStream:close	()V
    //   628: aload 8
    //   630: ifnull -199 -> 431
    //   633: aload 8
    //   635: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   638: goto -207 -> 431
    //   641: astore_0
    //   642: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +32 -> 677
    //   648: ldc 8
    //   650: iconst_2
    //   651: new 58	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 313
    //   661: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload_0
    //   665: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   668: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_0
    //   678: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   681: goto -250 -> 431
    //   684: astore 6
    //   686: aconst_null
    //   687: astore_3
    //   688: aload_2
    //   689: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   692: ifne +112 -> 804
    //   695: aload_2
    //   696: astore 7
    //   698: aload_1
    //   699: ifnull +33 -> 732
    //   702: aload_2
    //   703: astore 7
    //   705: aload_1
    //   706: invokevirtual 113	java/lang/String:length	()I
    //   709: ifle +23 -> 732
    //   712: new 58	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   719: aload_2
    //   720: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload_1
    //   724: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: astore 7
    //   732: aload_0
    //   733: invokestatic 163	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   736: astore_0
    //   737: aload_0
    //   738: aload 7
    //   740: invokeinterface 168 2 0
    //   745: ifeq +59 -> 804
    //   748: aload_0
    //   749: invokeinterface 295 1 0
    //   754: astore_0
    //   755: aload_0
    //   756: aload 7
    //   758: invokeinterface 301 2 0
    //   763: pop
    //   764: aload_0
    //   765: invokeinterface 304 1 0
    //   770: pop
    //   771: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +30 -> 804
    //   777: ldc 8
    //   779: iconst_2
    //   780: new 58	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 306
    //   790: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 7
    //   795: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   804: aload_3
    //   805: ifnull +7 -> 812
    //   808: aload_3
    //   809: invokevirtual 140	java/io/FileInputStream:close	()V
    //   812: aload 5
    //   814: ifnull +8 -> 822
    //   817: aload 5
    //   819: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   822: aload 6
    //   824: athrow
    //   825: astore_0
    //   826: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   829: ifeq +32 -> 861
    //   832: ldc 8
    //   834: iconst_2
    //   835: new 58	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 313
    //   845: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_0
    //   849: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   852: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: aload_0
    //   862: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   865: goto -43 -> 822
    //   868: astore_0
    //   869: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   872: ifeq +32 -> 904
    //   875: ldc 8
    //   877: iconst_2
    //   878: new 58	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   885: ldc_w 313
    //   888: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: aload_0
    //   892: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   895: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_0
    //   905: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   908: goto -477 -> 431
    //   911: astore 6
    //   913: goto -225 -> 688
    //   916: astore 6
    //   918: goto -472 -> 446
    //   921: aconst_null
    //   922: astore 6
    //   924: goto -771 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	927	0	paramContext	Context
    //   0	927	1	paramString1	String
    //   0	927	2	paramString2	String
    //   0	927	3	paramString3	String
    //   0	927	4	paramBoolean	boolean
    //   1	817	5	localObject1	Object
    //   109	308	6	localFileInputStream	FileInputStream
    //   441	63	6	localThrowable1	Throwable
    //   684	139	6	localObject2	Object
    //   911	1	6	localObject3	Object
    //   916	1	6	localThrowable2	Throwable
    //   922	1	6	localObject4	Object
    //   124	670	7	localObject5	Object
    //   10	624	8	localObject6	Object
    //   33	248	9	str	String
    //   4	423	10	localFileOutputStream	java.io.FileOutputStream
    //   7	182	11	localObject7	Object
    //   72	365	12	localObject8	Object
    //   94	127	13	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   77	96	435	finally
    //   301	308	435	finally
    //   316	342	435	finally
    //   342	411	435	finally
    //   416	421	435	finally
    //   426	431	435	finally
    //   431	434	435	finally
    //   436	439	435	finally
    //   508	515	435	finally
    //   523	549	435	finally
    //   549	618	435	finally
    //   623	628	435	finally
    //   633	638	435	finally
    //   642	677	435	finally
    //   677	681	435	finally
    //   688	695	435	finally
    //   705	732	435	finally
    //   732	804	435	finally
    //   808	812	435	finally
    //   817	822	435	finally
    //   822	825	435	finally
    //   826	861	435	finally
    //   861	865	435	finally
    //   869	904	435	finally
    //   904	908	435	finally
    //   96	111	441	java/lang/Throwable
    //   508	515	641	java/lang/Exception
    //   523	549	641	java/lang/Exception
    //   549	618	641	java/lang/Exception
    //   623	628	641	java/lang/Exception
    //   633	638	641	java/lang/Exception
    //   96	111	684	finally
    //   688	695	825	java/lang/Exception
    //   705	732	825	java/lang/Exception
    //   732	804	825	java/lang/Exception
    //   808	812	825	java/lang/Exception
    //   817	822	825	java/lang/Exception
    //   301	308	868	java/lang/Exception
    //   316	342	868	java/lang/Exception
    //   342	411	868	java/lang/Exception
    //   416	421	868	java/lang/Exception
    //   426	431	868	java/lang/Exception
    //   126	133	911	finally
    //   148	153	911	finally
    //   168	181	911	finally
    //   196	205	911	finally
    //   220	228	911	finally
    //   243	249	911	finally
    //   264	301	911	finally
    //   453	459	911	finally
    //   466	496	911	finally
    //   503	508	911	finally
    //   126	133	916	java/lang/Throwable
    //   148	153	916	java/lang/Throwable
    //   168	181	916	java/lang/Throwable
    //   196	205	916	java/lang/Throwable
    //   220	228	916	java/lang/Throwable
    //   243	249	916	java/lang/Throwable
    //   264	301	916	java/lang/Throwable
  }
  
  /* Error */
  public static void writeValueForInt(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 8
    //   12: aload_0
    //   13: ifnonnull +19 -> 32
    //   16: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +12 -> 31
    //   22: ldc 8
    //   24: iconst_2
    //   25: ldc_w 318
    //   28: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: return
    //   32: aload_3
    //   33: astore 9
    //   35: aload_1
    //   36: ifnull +33 -> 69
    //   39: aload_3
    //   40: astore 9
    //   42: aload_1
    //   43: invokevirtual 113	java/lang/String:length	()I
    //   46: ifle +23 -> 69
    //   49: new 58	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   56: aload_3
    //   57: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 9
    //   69: getstatic 24	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:locker	Ljava/lang/Object;
    //   72: astore 12
    //   74: aload 12
    //   76: monitorenter
    //   77: aload 9
    //   79: iload 4
    //   81: invokestatic 269	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   84: invokestatic 277	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: new 127	java/util/Properties
    //   90: dup
    //   91: invokespecial 128	java/util/Properties:<init>	()V
    //   94: astore 13
    //   96: aload_0
    //   97: invokestatic 117	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isKeyFileExists	(Landroid/content/Context;)Z
    //   100: ifeq +821 -> 921
    //   103: aload_0
    //   104: ldc 8
    //   106: invokevirtual 125	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   109: astore 6
    //   111: aload 10
    //   113: astore 5
    //   115: aload 6
    //   117: astore_3
    //   118: aload 11
    //   120: astore 8
    //   122: aload 6
    //   124: astore 7
    //   126: aload 13
    //   128: aload 6
    //   130: invokevirtual 132	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   133: aload 10
    //   135: astore 5
    //   137: aload 6
    //   139: astore_3
    //   140: aload 11
    //   142: astore 8
    //   144: aload 6
    //   146: astore 7
    //   148: aload 6
    //   150: invokevirtual 140	java/io/FileInputStream:close	()V
    //   153: aload 10
    //   155: astore 5
    //   157: aload 6
    //   159: astore_3
    //   160: aload 11
    //   162: astore 8
    //   164: aload 6
    //   166: astore 7
    //   168: aload 13
    //   170: aload 9
    //   172: iload 4
    //   174: invokestatic 269	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   177: invokevirtual 281	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 10
    //   183: astore 5
    //   185: aload 6
    //   187: astore_3
    //   188: aload 11
    //   190: astore 8
    //   192: aload 6
    //   194: astore 7
    //   196: aload_0
    //   197: ldc 8
    //   199: iconst_0
    //   200: invokevirtual 285	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   203: astore 10
    //   205: aload 10
    //   207: astore 5
    //   209: aload 6
    //   211: astore_3
    //   212: aload 10
    //   214: astore 8
    //   216: aload 6
    //   218: astore 7
    //   220: aload 13
    //   222: aload 10
    //   224: aconst_null
    //   225: invokevirtual 289	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   228: aload 10
    //   230: astore 5
    //   232: aload 6
    //   234: astore_3
    //   235: aload 10
    //   237: astore 8
    //   239: aload 6
    //   241: astore 7
    //   243: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +55 -> 301
    //   249: aload 10
    //   251: astore 5
    //   253: aload 6
    //   255: astore_3
    //   256: aload 10
    //   258: astore 8
    //   260: aload 6
    //   262: astore 7
    //   264: ldc 8
    //   266: iconst_2
    //   267: new 58	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 320
    //   277: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 9
    //   282: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc 67
    //   287: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload 4
    //   292: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_2
    //   302: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +106 -> 411
    //   308: aload_2
    //   309: astore_3
    //   310: aload_1
    //   311: ifnull +31 -> 342
    //   314: aload_2
    //   315: astore_3
    //   316: aload_1
    //   317: invokevirtual 113	java/lang/String:length	()I
    //   320: ifle +22 -> 342
    //   323: new 58	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   330: aload_2
    //   331: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_1
    //   335: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: astore_3
    //   342: aload_0
    //   343: invokestatic 163	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   346: astore_0
    //   347: aload_0
    //   348: aload_3
    //   349: invokeinterface 168 2 0
    //   354: ifeq +57 -> 411
    //   357: aload_0
    //   358: invokeinterface 295 1 0
    //   363: astore_0
    //   364: aload_0
    //   365: aload_3
    //   366: invokeinterface 301 2 0
    //   371: pop
    //   372: aload_0
    //   373: invokeinterface 304 1 0
    //   378: pop
    //   379: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +29 -> 411
    //   385: ldc 8
    //   387: iconst_2
    //   388: new 58	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 306
    //   398: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_3
    //   402: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 6
    //   413: ifnull +8 -> 421
    //   416: aload 6
    //   418: invokevirtual 140	java/io/FileInputStream:close	()V
    //   421: aload 10
    //   423: ifnull +8 -> 431
    //   426: aload 10
    //   428: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   431: aload 12
    //   433: monitorexit
    //   434: return
    //   435: astore_0
    //   436: aload 12
    //   438: monitorexit
    //   439: aload_0
    //   440: athrow
    //   441: astore 6
    //   443: aconst_null
    //   444: astore 7
    //   446: aload 8
    //   448: astore 5
    //   450: aload 7
    //   452: astore_3
    //   453: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +40 -> 496
    //   459: aload 8
    //   461: astore 5
    //   463: aload 7
    //   465: astore_3
    //   466: ldc 8
    //   468: iconst_2
    //   469: new 58	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 322
    //   479: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 6
    //   484: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   487: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 8
    //   498: astore 5
    //   500: aload 7
    //   502: astore_3
    //   503: aload 6
    //   505: invokevirtual 149	java/lang/Throwable:printStackTrace	()V
    //   508: aload_2
    //   509: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: ifne +106 -> 618
    //   515: aload_2
    //   516: astore_3
    //   517: aload_1
    //   518: ifnull +31 -> 549
    //   521: aload_2
    //   522: astore_3
    //   523: aload_1
    //   524: invokevirtual 113	java/lang/String:length	()I
    //   527: ifle +22 -> 549
    //   530: new 58	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   537: aload_2
    //   538: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_1
    //   542: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: astore_3
    //   549: aload_0
    //   550: invokestatic 163	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   553: astore_0
    //   554: aload_0
    //   555: aload_3
    //   556: invokeinterface 168 2 0
    //   561: ifeq +57 -> 618
    //   564: aload_0
    //   565: invokeinterface 295 1 0
    //   570: astore_0
    //   571: aload_0
    //   572: aload_3
    //   573: invokeinterface 301 2 0
    //   578: pop
    //   579: aload_0
    //   580: invokeinterface 304 1 0
    //   585: pop
    //   586: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   589: ifeq +29 -> 618
    //   592: ldc 8
    //   594: iconst_2
    //   595: new 58	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 306
    //   605: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload_3
    //   609: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload 7
    //   620: ifnull +8 -> 628
    //   623: aload 7
    //   625: invokevirtual 140	java/io/FileInputStream:close	()V
    //   628: aload 8
    //   630: ifnull -199 -> 431
    //   633: aload 8
    //   635: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   638: goto -207 -> 431
    //   641: astore_0
    //   642: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +32 -> 677
    //   648: ldc 8
    //   650: iconst_2
    //   651: new 58	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 324
    //   661: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload_0
    //   665: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   668: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_0
    //   678: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   681: goto -250 -> 431
    //   684: astore 6
    //   686: aconst_null
    //   687: astore_3
    //   688: aload_2
    //   689: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   692: ifne +112 -> 804
    //   695: aload_2
    //   696: astore 7
    //   698: aload_1
    //   699: ifnull +33 -> 732
    //   702: aload_2
    //   703: astore 7
    //   705: aload_1
    //   706: invokevirtual 113	java/lang/String:length	()I
    //   709: ifle +23 -> 732
    //   712: new 58	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   719: aload_2
    //   720: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload_1
    //   724: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: astore 7
    //   732: aload_0
    //   733: invokestatic 163	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   736: astore_0
    //   737: aload_0
    //   738: aload 7
    //   740: invokeinterface 168 2 0
    //   745: ifeq +59 -> 804
    //   748: aload_0
    //   749: invokeinterface 295 1 0
    //   754: astore_0
    //   755: aload_0
    //   756: aload 7
    //   758: invokeinterface 301 2 0
    //   763: pop
    //   764: aload_0
    //   765: invokeinterface 304 1 0
    //   770: pop
    //   771: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +30 -> 804
    //   777: ldc 8
    //   779: iconst_2
    //   780: new 58	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 306
    //   790: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 7
    //   795: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   804: aload_3
    //   805: ifnull +7 -> 812
    //   808: aload_3
    //   809: invokevirtual 140	java/io/FileInputStream:close	()V
    //   812: aload 5
    //   814: ifnull +8 -> 822
    //   817: aload 5
    //   819: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   822: aload 6
    //   824: athrow
    //   825: astore_0
    //   826: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   829: ifeq +32 -> 861
    //   832: ldc 8
    //   834: iconst_2
    //   835: new 58	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 324
    //   845: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload_0
    //   849: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   852: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   858: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   861: aload_0
    //   862: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   865: goto -43 -> 822
    //   868: astore_0
    //   869: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   872: ifeq +32 -> 904
    //   875: ldc 8
    //   877: iconst_2
    //   878: new 58	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   885: ldc_w 324
    //   888: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: aload_0
    //   892: invokestatic 146	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   895: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_0
    //   905: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   908: goto -477 -> 431
    //   911: astore 6
    //   913: goto -225 -> 688
    //   916: astore 6
    //   918: goto -472 -> 446
    //   921: aconst_null
    //   922: astore 6
    //   924: goto -771 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	927	0	paramContext	Context
    //   0	927	1	paramString1	String
    //   0	927	2	paramString2	String
    //   0	927	3	paramString3	String
    //   0	927	4	paramInt	int
    //   1	817	5	localObject1	Object
    //   109	308	6	localFileInputStream	FileInputStream
    //   441	63	6	localThrowable1	Throwable
    //   684	139	6	localObject2	Object
    //   911	1	6	localObject3	Object
    //   916	1	6	localThrowable2	Throwable
    //   922	1	6	localObject4	Object
    //   124	670	7	localObject5	Object
    //   10	624	8	localObject6	Object
    //   33	248	9	str	String
    //   4	423	10	localFileOutputStream	java.io.FileOutputStream
    //   7	182	11	localObject7	Object
    //   72	365	12	localObject8	Object
    //   94	127	13	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   77	96	435	finally
    //   301	308	435	finally
    //   316	342	435	finally
    //   342	411	435	finally
    //   416	421	435	finally
    //   426	431	435	finally
    //   431	434	435	finally
    //   436	439	435	finally
    //   508	515	435	finally
    //   523	549	435	finally
    //   549	618	435	finally
    //   623	628	435	finally
    //   633	638	435	finally
    //   642	677	435	finally
    //   677	681	435	finally
    //   688	695	435	finally
    //   705	732	435	finally
    //   732	804	435	finally
    //   808	812	435	finally
    //   817	822	435	finally
    //   822	825	435	finally
    //   826	861	435	finally
    //   861	865	435	finally
    //   869	904	435	finally
    //   904	908	435	finally
    //   96	111	441	java/lang/Throwable
    //   508	515	641	java/lang/Exception
    //   523	549	641	java/lang/Exception
    //   549	618	641	java/lang/Exception
    //   623	628	641	java/lang/Exception
    //   633	638	641	java/lang/Exception
    //   96	111	684	finally
    //   688	695	825	java/lang/Exception
    //   705	732	825	java/lang/Exception
    //   732	804	825	java/lang/Exception
    //   808	812	825	java/lang/Exception
    //   817	822	825	java/lang/Exception
    //   301	308	868	java/lang/Exception
    //   316	342	868	java/lang/Exception
    //   342	411	868	java/lang/Exception
    //   416	421	868	java/lang/Exception
    //   426	431	868	java/lang/Exception
    //   126	133	911	finally
    //   148	153	911	finally
    //   168	181	911	finally
    //   196	205	911	finally
    //   220	228	911	finally
    //   243	249	911	finally
    //   264	301	911	finally
    //   453	459	911	finally
    //   466	496	911	finally
    //   503	508	911	finally
    //   126	133	916	java/lang/Throwable
    //   148	153	916	java/lang/Throwable
    //   168	181	916	java/lang/Throwable
    //   196	205	916	java/lang/Throwable
    //   220	228	916	java/lang/Throwable
    //   243	249	916	java/lang/Throwable
    //   264	301	916	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.SettingCloneUtil
 * JD-Core Version:    0.7.0.1
 */