package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class SettingCloneUtil
{
  private static final String KEY_FILE = "set_sp";
  private static final String KEY_FILE_MULTI_PROCESS = "set_sp_mp";
  private static final HashSet MULTIPROCESS_KEYS;
  private static Object locker = new Object();
  private static volatile boolean mHasInit = false;
  private static final HashMap mapKv = new HashMap();
  private static final HashMap tmpMapKv = new HashMap();
  
  static
  {
    MULTIPROCESS_KEYS = new HashSet(6);
    MULTIPROCESS_KEYS.add("qqsetting_screenshot_key");
    MULTIPROCESS_KEYS.add("qqsetting_notify_blncontrol_key");
    MULTIPROCESS_KEYS.add("qqsetting_lock_screen_whenexit_key");
    MULTIPROCESS_KEYS.add("qqsetting_avcall_notify_key");
    MULTIPROCESS_KEYS.add("qqsetting_qrlogin_set_mute");
    MULTIPROCESS_KEYS.add("qqsetting_locale_id");
    MULTIPROCESS_KEYS.add("new_msg_notification_key");
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
        if (MULTIPROCESS_KEYS.contains(paramString1)) {
          getSharedPreferences().edit().putBoolean(paramString1, bool).commit();
        }
        return bool;
        if (paramString1 != null) {
          mapKv.put(paramString1, paramString2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("set_sp", 2, "key is new, key=" + paramString1 + " v=" + paramString2 + " tag=" + paramString3);
        }
        try
        {
          bool = Boolean.parseBoolean(paramString2);
        }
        catch (Exception paramString2)
        {
          bool = false;
        }
      }
      paramString1 = finally;
      throw paramString1;
    }
    catch (Exception paramString2)
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
    String str1 = null;
    synchronized (locker)
    {
      if (mapKv.containsKey(paramString)) {
        str1 = (String)mapKv.get(paramString);
      }
      String str2 = str1;
      if (str1 == null)
      {
        str2 = str1;
        if (tmpMapKv.containsKey(paramString)) {
          str2 = (String)tmpMapKv.get(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "get k=" + paramString + " v=" + str2);
      }
      return str2;
    }
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    return SharedPreferencesProxyManager.getInstance().getProxy("set_sp_mp", 4);
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
  
  public static boolean put(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("set_sp", 2, "put k=" + paramString1 + " v=" + paramString2);
    }
    synchronized (locker)
    {
      String str = (String)mapKv.get(paramString1);
      if ((str != null) && (str.equals(paramString2))) {
        return false;
      }
      mapKv.put(paramString1, paramString2);
      return true;
    }
  }
  
  /* Error */
  private static String readFromFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 29	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mHasInit	Z
    //   3: ifne +317 -> 320
    //   6: aload_0
    //   7: invokestatic 171	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isKeyFileExists	(Landroid/content/Context;)Z
    //   10: ifeq +310 -> 320
    //   13: new 245	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_0
    //   18: ldc 8
    //   20: invokevirtual 179	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   23: invokespecial 247	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_0
    //   29: new 181	java/util/Properties
    //   32: dup
    //   33: invokespecial 182	java/util/Properties:<init>	()V
    //   36: astore_3
    //   37: aload_2
    //   38: astore_0
    //   39: aload_3
    //   40: aload_2
    //   41: invokevirtual 186	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   44: aload_2
    //   45: astore_0
    //   46: aload_1
    //   47: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +191 -> 241
    //   53: aload_2
    //   54: astore_0
    //   55: aload_3
    //   56: invokevirtual 251	java/util/Properties:keySet	()Ljava/util/Set;
    //   59: invokeinterface 257 1 0
    //   64: astore_1
    //   65: aload_2
    //   66: astore_0
    //   67: aload_1
    //   68: invokeinterface 262 1 0
    //   73: ifeq +135 -> 208
    //   76: aload_2
    //   77: astore_0
    //   78: aload_1
    //   79: invokeinterface 266 1 0
    //   84: astore 4
    //   86: aload_2
    //   87: astore_0
    //   88: aload 4
    //   90: instanceof 75
    //   93: ifeq -28 -> 65
    //   96: aload_2
    //   97: astore_0
    //   98: aload 4
    //   100: checkcast 75	java/lang/String
    //   103: astore 4
    //   105: aload_2
    //   106: astore_0
    //   107: aload_3
    //   108: aload 4
    //   110: invokevirtual 269	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 5
    //   115: aload_2
    //   116: astore_0
    //   117: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +43 -> 163
    //   123: aload_2
    //   124: astore_0
    //   125: ldc 8
    //   127: iconst_2
    //   128: new 83	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 271
    //   138: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 4
    //   143: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 273
    //   149: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 5
    //   154: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: aload_2
    //   164: astore_0
    //   165: getstatic 59	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mapKv	Ljava/util/HashMap;
    //   168: aload 4
    //   170: aload 5
    //   172: invokevirtual 134	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -111 -> 65
    //   179: astore_0
    //   180: aload_2
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload_1
    //   185: astore_0
    //   186: ldc 8
    //   188: iconst_1
    //   189: ldc_w 275
    //   192: aload_2
    //   193: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 280	java/io/BufferedInputStream:close	()V
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_1
    //   207: areturn
    //   208: aload_2
    //   209: astore_0
    //   210: iconst_1
    //   211: putstatic 29	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:mHasInit	Z
    //   214: aconst_null
    //   215: astore_0
    //   216: aload_0
    //   217: astore_1
    //   218: aload_2
    //   219: ifnull -13 -> 206
    //   222: aload_2
    //   223: invokevirtual 280	java/io/BufferedInputStream:close	()V
    //   226: aload_0
    //   227: areturn
    //   228: astore_1
    //   229: ldc 8
    //   231: iconst_1
    //   232: ldc_w 275
    //   235: aload_1
    //   236: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: aload_0
    //   240: areturn
    //   241: aload_2
    //   242: astore_0
    //   243: aload_3
    //   244: aload_1
    //   245: invokevirtual 189	java/util/Properties:containsKey	(Ljava/lang/Object;)Z
    //   248: ifeq +67 -> 315
    //   251: aload_2
    //   252: astore_0
    //   253: aload_3
    //   254: aload_1
    //   255: invokevirtual 269	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_1
    //   259: aload_1
    //   260: astore_0
    //   261: goto -45 -> 216
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_0
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 280	java/io/BufferedInputStream:close	()V
    //   275: aload_1
    //   276: athrow
    //   277: astore_0
    //   278: ldc 8
    //   280: iconst_1
    //   281: ldc_w 275
    //   284: aload_0
    //   285: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: goto -13 -> 275
    //   291: astore_0
    //   292: ldc 8
    //   294: iconst_1
    //   295: ldc_w 275
    //   298: aload_0
    //   299: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: goto -98 -> 204
    //   305: astore_1
    //   306: goto -39 -> 267
    //   309: astore_2
    //   310: aconst_null
    //   311: astore_1
    //   312: goto -128 -> 184
    //   315: aconst_null
    //   316: astore_0
    //   317: goto -101 -> 216
    //   320: aconst_null
    //   321: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramContext	Context
    //   0	322	1	paramString	String
    //   26	226	2	localObject1	Object
    //   309	1	2	localThrowable	Throwable
    //   36	218	3	localProperties	Properties
    //   84	85	4	localObject2	Object
    //   113	58	5	str	String
    // Exception table:
    //   from	to	target	type
    //   29	37	179	java/lang/Throwable
    //   39	44	179	java/lang/Throwable
    //   46	53	179	java/lang/Throwable
    //   55	65	179	java/lang/Throwable
    //   67	76	179	java/lang/Throwable
    //   78	86	179	java/lang/Throwable
    //   88	96	179	java/lang/Throwable
    //   98	105	179	java/lang/Throwable
    //   107	115	179	java/lang/Throwable
    //   117	123	179	java/lang/Throwable
    //   125	163	179	java/lang/Throwable
    //   165	176	179	java/lang/Throwable
    //   210	214	179	java/lang/Throwable
    //   243	251	179	java/lang/Throwable
    //   253	259	179	java/lang/Throwable
    //   222	226	228	java/lang/Throwable
    //   13	27	264	finally
    //   271	275	277	java/lang/Throwable
    //   200	204	291	java/lang/Throwable
    //   29	37	305	finally
    //   39	44	305	finally
    //   46	53	305	finally
    //   55	65	305	finally
    //   67	76	305	finally
    //   78	86	305	finally
    //   88	96	305	finally
    //   98	105	305	finally
    //   107	115	305	finally
    //   117	123	305	finally
    //   125	163	305	finally
    //   165	176	305	finally
    //   186	196	305	finally
    //   210	214	305	finally
    //   243	251	305	finally
    //   253	259	305	finally
    //   13	27	309	java/lang/Throwable
  }
  
  public static String readValue(Context paramContext, String paramString1, String arg2, String paramString3, String paramString4)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "read String. ctx is null.defV=" + paramString4);
      }
      return paramString4;
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (paramString1 = paramString3 + paramString1;; paramString1 = paramString3) {
      for (;;)
      {
        if ((MULTIPROCESS_KEYS.contains(paramString3)) && (getSharedPreferences().contains(paramString1))) {
          return getSharedPreferences().getString(paramString1, paramString4);
        }
        ??? = get(paramString1);
        if (??? != null)
        {
          if (MULTIPROCESS_KEYS.contains(paramString1)) {
            getSharedPreferences().edit().putString(paramString1, ???).commit();
          }
          return ???;
        }
        if (paramString1 == null) {
          break;
        }
        synchronized (locker)
        {
          readFromFile(paramContext, null);
          paramContext = get(paramString1);
          if (paramContext == null) {
            break;
          }
          if (MULTIPROCESS_KEYS.contains(paramString1)) {
            getSharedPreferences().edit().putString(paramString1, paramContext).commit();
          }
          return paramContext;
        }
      }
    }
  }
  
  public static boolean readValue(Context paramContext, String arg1, String paramString2, String arg3, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "read boolean. ctx is null.defV=" + paramBoolean);
      }
      return paramBoolean;
    }
    if ((??? != null) && (???.length() > 0)) {}
    for (String str = ??? + ???;; str = ???)
    {
      if ((MULTIPROCESS_KEYS.contains(???)) && (getSharedPreferences().contains(str))) {
        return getSharedPreferences().getBoolean(str, paramBoolean);
      }
      ??? = get(str);
      if (??? != null)
      {
        if (Boolean.parseBoolean(???)) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          if (MULTIPROCESS_KEYS.contains(str)) {
            getSharedPreferences().edit().putBoolean(str, paramBoolean).commit();
          }
          return paramBoolean;
        }
      }
      if (str != null) {
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
              if (MULTIPROCESS_KEYS.contains(str)) {
                getSharedPreferences().edit().putBoolean(str, paramBoolean).commit();
              }
              return paramBoolean;
            }
          }
          paramBoolean = false;
        }
      }
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
      ??? = PreferenceManager.getDefaultSharedPreferences(paramContext);
      paramContext = paramString2;
      if (??? != null)
      {
        paramContext = paramString2;
        if (???.length() > 0) {
          paramContext = paramString2 + ???;
        }
      }
      if (!???.contains(paramContext)) {
        synchronized (locker)
        {
          tmpMapKv.put(paramContext, Boolean.toString(paramBoolean));
          return paramBoolean;
        }
      }
      paramBoolean = ???.getBoolean(paramContext, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "read boolean. sp ok, k=" + paramContext + " v=" + paramBoolean);
      }
      return firstInit(str, Boolean.toString(paramBoolean), "sp");
    }
  }
  
  public static int readValueForInt(Context paramContext, String paramString1, String paramString2, String arg3, int paramInt)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "read int.ctx is null.defV=" + paramInt);
      }
      return paramInt;
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (String str = ??? + paramString1;; str = ???)
    {
      if ((MULTIPROCESS_KEYS.contains(???)) && (getSharedPreferences().contains(str))) {
        return getSharedPreferences().getInt(str, paramInt);
      }
      ??? = get(str);
      int i;
      if (??? != null) {
        try
        {
          i = Integer.parseInt(???);
          if (MULTIPROCESS_KEYS.contains(str)) {
            getSharedPreferences().edit().putInt(str, i).commit();
          }
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
          break label304;
        }
      }
      try
      {
        i = Integer.parseInt(???);
        if (MULTIPROCESS_KEYS.contains(str)) {
          getSharedPreferences().edit().putInt(str, i).commit();
        }
        return i;
      }
      catch (NumberFormatException ???)
      {
        if (!QLog.isColorLevel()) {
          break label304;
        }
        QLog.d("set_sp", 2, "read int.parse int exception =" + String.valueOf(???));
      }
      paramContext = finally;
      throw paramContext;
      label304:
      if (TextUtils.isEmpty(paramString2)) {
        break;
      }
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
  }
  
  private static Properties updateProperties()
  {
    Properties localProperties = new Properties();
    if (mapKv != null)
    {
      Iterator localIterator = mapKv.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localProperties.setProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localProperties;
  }
  
  public static void writeValue(Context paramContext, String paramString1, String arg2, String paramString3, String paramString4)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "write string. ctx is null");
      }
      return;
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (paramString1 = paramString3 + paramString1;; paramString1 = paramString3)
    {
      if (MULTIPROCESS_KEYS.contains(paramString3))
      {
        getSharedPreferences().edit().putString(paramString1, paramString4).commit();
        return;
      }
      synchronized (locker)
      {
        if (!put(paramString1, paramString4)) {
          return;
        }
      }
      paramString3 = updateProperties();
      try
      {
        paramString3.store(paramContext.openFileOutput("set_sp", 0), null);
        if (QLog.isColorLevel()) {
          QLog.d("set_sp", 2, "write string. write file ok.k=" + paramString1 + " v=" + paramString4);
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("set_sp", 2, "write string.01write exception:" + String.valueOf(paramContext));
          }
          paramContext.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("set_sp", 2, "write string.01write unknown exception");
          }
        }
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("set_sp", 2, "write string.01write unknown exception");
      }
      return;
    }
  }
  
  public static void writeValue(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = null;
    FileOutputStream localFileOutputStream = null;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "write boolean. ctx is null");
      }
      return;
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (String str = paramString3 + paramString1;; str = paramString3)
    {
      if (MULTIPROCESS_KEYS.contains(paramString3))
      {
        getSharedPreferences().edit().putBoolean(str, paramBoolean).commit();
        return;
      }
      synchronized (locker)
      {
        if (!put(str, Boolean.toString(paramBoolean))) {
          return;
        }
      }
      Properties localProperties = updateProperties();
      paramString3 = localFileOutputStream;
      try
      {
        localFileOutputStream = paramContext.openFileOutput("set_sp", 0);
        paramString3 = localFileOutputStream;
        localObject1 = localFileOutputStream;
        localProperties.store(localFileOutputStream, null);
        paramString3 = localFileOutputStream;
        localObject1 = localFileOutputStream;
        if (QLog.isColorLevel())
        {
          paramString3 = localFileOutputStream;
          localObject1 = localFileOutputStream;
          QLog.d("set_sp", 2, "write boolean. write file ok.k=" + str + " v=" + paramBoolean);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label331:
          localObject1 = paramString3;
          if (QLog.isColorLevel())
          {
            localObject1 = paramString3;
            QLog.d("set_sp", 2, "write boolean.01write exception:" + String.valueOf(localThrowable));
          }
          localObject1 = paramString3;
          localThrowable.printStackTrace();
          try
          {
            if (!TextUtils.isEmpty(paramString2))
            {
              localObject1 = paramString2;
              if (paramString1 != null)
              {
                localObject1 = paramString2;
                if (paramString1.length() > 0) {
                  localObject1 = paramString2 + paramString1;
                }
              }
              paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
              if (paramContext.contains((String)localObject1))
              {
                paramContext = paramContext.edit();
                paramContext.remove((String)localObject1);
                paramContext.commit();
                if (QLog.isColorLevel()) {
                  QLog.d("set_sp", 2, "remove sp ok.k=" + (String)localObject1);
                }
              }
            }
            if (paramString3 != null) {
              paramString3.close();
            }
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("set_sp", 2, "02write exception:" + String.valueOf(paramContext));
            }
            paramContext.printStackTrace();
          }
        }
      }
      finally
      {
        try
        {
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString3 = paramString2;
            if (paramString1 != null)
            {
              paramString3 = paramString2;
              if (paramString1.length() > 0) {
                paramString3 = paramString2 + paramString1;
              }
            }
            paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
            if (paramContext.contains(paramString3))
            {
              paramContext = paramContext.edit();
              paramContext.remove(paramString3);
              paramContext.commit();
              if (QLog.isColorLevel()) {
                QLog.d("set_sp", 2, "remove sp ok.k=" + paramString3);
              }
            }
          }
          if (localObject1 != null) {
            ((FileOutputStream)localObject1).close();
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("set_sp", 2, "02write exception:" + String.valueOf(paramContext));
          }
          paramContext.printStackTrace();
          continue;
        }
      }
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString2;
          if (paramString1 != null)
          {
            paramString3 = paramString2;
            if (paramString1.length() > 0) {
              paramString3 = paramString2 + paramString1;
            }
          }
          paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
          if (paramContext.contains(paramString3))
          {
            paramContext = paramContext.edit();
            paramContext.remove(paramString3);
            paramContext.commit();
            if (QLog.isColorLevel()) {
              QLog.d("set_sp", 2, "remove sp ok.k=" + paramString3);
            }
          }
        }
        if (localFileOutputStream != null) {
          localFileOutputStream.close();
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("set_sp", 2, "02write exception:" + String.valueOf(paramContext));
        paramContext.printStackTrace();
        break label331;
      }
      return;
    }
  }
  
  public static void writeValueForInt(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Object localObject1 = null;
    FileOutputStream localFileOutputStream = null;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("set_sp", 2, "write int. ctx is null");
      }
      return;
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {}
    for (String str = paramString3 + paramString1;; str = paramString3)
    {
      if (MULTIPROCESS_KEYS.contains(paramString3))
      {
        getSharedPreferences().edit().putInt(str, paramInt).commit();
        return;
      }
      synchronized (locker)
      {
        if (!put(str, Integer.toString(paramInt))) {
          return;
        }
      }
      Properties localProperties = updateProperties();
      paramString3 = localFileOutputStream;
      try
      {
        localFileOutputStream = paramContext.openFileOutput("set_sp", 0);
        paramString3 = localFileOutputStream;
        localObject1 = localFileOutputStream;
        localProperties.store(localFileOutputStream, null);
        paramString3 = localFileOutputStream;
        localObject1 = localFileOutputStream;
        if (QLog.isColorLevel())
        {
          paramString3 = localFileOutputStream;
          localObject1 = localFileOutputStream;
          QLog.d("set_sp", 2, "write int. refresh properties ok.k=" + str + " v=" + paramInt);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label331:
          localObject1 = paramString3;
          if (QLog.isColorLevel())
          {
            localObject1 = paramString3;
            QLog.d("set_sp", 2, "write int. 01write exception:" + String.valueOf(localThrowable));
          }
          localObject1 = paramString3;
          localThrowable.printStackTrace();
          try
          {
            if (!TextUtils.isEmpty(paramString2))
            {
              localObject1 = paramString2;
              if (paramString1 != null)
              {
                localObject1 = paramString2;
                if (paramString1.length() > 0) {
                  localObject1 = paramString2 + paramString1;
                }
              }
              paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
              if (paramContext.contains((String)localObject1))
              {
                paramContext = paramContext.edit();
                paramContext.remove((String)localObject1);
                paramContext.commit();
                if (QLog.isColorLevel()) {
                  QLog.d("set_sp", 2, "remove sp ok.k=" + (String)localObject1);
                }
              }
            }
            if (paramString3 != null) {
              paramString3.close();
            }
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("set_sp", 2, "write int. 02write exception:" + String.valueOf(paramContext));
            }
            paramContext.printStackTrace();
          }
        }
      }
      finally
      {
        try
        {
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString3 = paramString2;
            if (paramString1 != null)
            {
              paramString3 = paramString2;
              if (paramString1.length() > 0) {
                paramString3 = paramString2 + paramString1;
              }
            }
            paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
            if (paramContext.contains(paramString3))
            {
              paramContext = paramContext.edit();
              paramContext.remove(paramString3);
              paramContext.commit();
              if (QLog.isColorLevel()) {
                QLog.d("set_sp", 2, "remove sp ok.k=" + paramString3);
              }
            }
          }
          if (localObject1 != null) {
            ((FileOutputStream)localObject1).close();
          }
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("set_sp", 2, "write int. 02write exception:" + String.valueOf(paramContext));
          }
          paramContext.printStackTrace();
          continue;
        }
      }
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString2;
          if (paramString1 != null)
          {
            paramString3 = paramString2;
            if (paramString1.length() > 0) {
              paramString3 = paramString2 + paramString1;
            }
          }
          paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
          if (paramContext.contains(paramString3))
          {
            paramContext = paramContext.edit();
            paramContext.remove(paramString3);
            paramContext.commit();
            if (QLog.isColorLevel()) {
              QLog.d("set_sp", 2, "remove sp ok.k=" + paramString3);
            }
          }
        }
        if (localFileOutputStream != null) {
          localFileOutputStream.close();
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("set_sp", 2, "write int. 02write exception:" + String.valueOf(paramContext));
        paramContext.printStackTrace();
        break label331;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.SettingCloneUtil
 * JD-Core Version:    0.7.0.1
 */