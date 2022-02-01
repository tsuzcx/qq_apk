package com.tencent.android.tpush;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class a
{
  static final String a = XGPushProvider.AUTH_PRIX;
  private static ReentrantLock b = new ReentrantLock();
  private static Map<String, String> c = new HashMap();
  
  public static String a(String paramString)
  {
    return paramString + a;
  }
  
  /* Error */
  public static Map<String, android.content.pm.ProviderInfo> a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 29	java/util/HashMap
    //   6: dup
    //   7: invokespecial 30	java/util/HashMap:<init>	()V
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 54	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aconst_null
    //   16: iconst_0
    //   17: iconst_0
    //   18: invokevirtual 60	android/content/pm/PackageManager:queryContentProviders	(Ljava/lang/String;II)Ljava/util/List;
    //   21: invokeinterface 66 1 0
    //   26: astore_0
    //   27: aload_0
    //   28: invokeinterface 72 1 0
    //   33: ifeq +120 -> 153
    //   36: aload_0
    //   37: invokeinterface 76 1 0
    //   42: checkcast 78	android/content/pm/ProviderInfo
    //   45: astore_2
    //   46: aload_2
    //   47: getfield 81	android/content/pm/ProviderInfo:name	Ljava/lang/String;
    //   50: ldc 15
    //   52: invokevirtual 86	java/lang/Class:getName	()Ljava/lang/String;
    //   55: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifeq -31 -> 27
    //   61: aload_2
    //   62: getfield 95	android/content/pm/ProviderInfo:authority	Ljava/lang/String;
    //   65: aload_2
    //   66: getfield 98	android/content/pm/ProviderInfo:packageName	Ljava/lang/String;
    //   69: invokestatic 100	com/tencent/android/tpush/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifeq -48 -> 27
    //   78: aload_1
    //   79: aload_2
    //   80: getfield 98	android/content/pm/ProviderInfo:packageName	Ljava/lang/String;
    //   83: aload_2
    //   84: invokeinterface 106 3 0
    //   89: pop
    //   90: ldc 108
    //   92: new 36	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   99: ldc 110
    //   101: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: getfield 95	android/content/pm/ProviderInfo:authority	Ljava/lang/String;
    //   108: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 112
    //   113: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_2
    //   117: getfield 98	android/content/pm/ProviderInfo:packageName	Ljava/lang/String;
    //   120: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 112
    //   125: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: getfield 81	android/content/pm/ProviderInfo:name	Ljava/lang/String;
    //   132: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 118	com/tencent/android/tpush/logging/TLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: goto -114 -> 27
    //   144: astore_0
    //   145: ldc 108
    //   147: ldc 120
    //   149: aload_0
    //   150: invokestatic 124	com/tencent/android/tpush/logging/TLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_1
    //   157: areturn
    //   158: astore_0
    //   159: ldc 2
    //   161: monitorexit
    //   162: aload_0
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	Context
    //   10	147	1	localHashMap	HashMap
    //   45	84	2	localProviderInfo	android.content.pm.ProviderInfo
    // Exception table:
    //   from	to	target	type
    //   11	27	144	java/lang/Throwable
    //   27	141	144	java/lang/Throwable
    //   3	11	158	finally
    //   11	27	158	finally
    //   27	141	158	finally
    //   145	153	158	finally
  }
  
  public static boolean a(Context paramContext, String paramString, Intent paramIntent)
  {
    return a(paramContext, paramString, paramIntent.toURI());
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("key", paramString2);
      ProviderMessage.insert(paramContext, Uri.parse("content://" + paramString1 + XGPushProvider.AUTH_PRIX + "/" + TypeStr.msg.getStr()), localContentValues);
      return true;
    }
    catch (Throwable paramString1)
    {
      TLogger.e("ProviderUtils", "sendMsgByPkgName", paramString1);
      ServiceStat.reportErrCode(paramContext, -104, "sendMsgByPkgName err:" + Util.getThrowableToString(paramString1), 0L, "inner");
    }
    return false;
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      ProviderMessage.getType(paramContext, Uri.parse("content://" + paramContext.getPackageName() + XGPushProvider.AUTH_PRIX + "/" + TypeStr.hearbeat.getStr()));
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ProviderUtils", "heartbeat Provider error", paramContext);
    }
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = Uri.parse("content://" + paramString1 + XGPushProvider.AUTH_PRIX + "/" + TypeStr.feedback.getStr());
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("feedback", Rijndael.encrypt(paramString2));
    try
    {
      ProviderMessage.update(paramContext, paramString1, localContentValues, null, null);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("ProviderUtils", "error : ", paramContext);
    }
  }
  
  public static Map<Long, RegisterEntity> c(Context paramContext)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramContext = CacheManager.getCurrentAppRegisterEntity(paramContext);
    if (paramContext != null) {
      localConcurrentHashMap.put(Long.valueOf(paramContext.accessId), paramContext);
    }
    return localConcurrentHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.a
 * JD-Core Version:    0.7.0.1
 */