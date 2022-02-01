import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter.1;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ahlw
{
  private static Map<String, Long> kU = new HashMap();
  
  static
  {
    adtz localadtz = new adtz();
    localadtz.scene = "OpenShare";
    localadtz.bvz = "KEY_STAGE_1_TOTAL";
    localadtz.bvA = "KEY_STAGE_2_TOTAL";
    localadtz.timeOut = 30000L;
    localadtz.ce = new ForwardStatisticsReporter.1();
    adty.a("OpenShare", localadtz);
    localadtz = new adtz();
    localadtz.scene = "OpenLogin";
    localadtz.bvz = "KEY_LOGIN_STAGE_1_TOTAL";
    localadtz.bvA = "KEY_AUTHORITY_TOTAL";
    localadtz.timeOut = 30000L;
    localadtz.ce = new ForwardStatisticsReporter.2();
    adty.a("OpenLogin", localadtz);
  }
  
  public static void Kj(String paramString)
  {
    try
    {
      long l = System.currentTimeMillis();
      kU.put(paramString, Long.valueOf(l));
      adty.ag(paramString, l);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void N(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      a(paramString1, paramString2, null, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(String paramString, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    String str = ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin();
    QLog.d("ForwardStatisticsReporter", 1, new Object[] { "reportSaveImage key=", paramString, ",duration=", Long.valueOf(paramLong), ", uin=", artw.qx(str) });
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(str, paramString, paramBoolean, paramLong, 0L, paramHashMap, "", false);
    adty.a(paramString, true, paramLong, paramHashMap);
  }
  
  public static void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramBundle.getInt("code")));
    localHashMap.put("param_error_ret", Integer.toString(paramBundle.getInt("ret")));
    report(paramString, localHashMap, paramBoolean);
  }
  
  public static void a(String paramString, asav paramasav)
  {
    try
    {
      a(paramString, paramasav, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString, asav paramasav, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramasav == null) {}
    for (paramasav = "";; paramasav = paramasav.uin)
    {
      a(paramString, paramasav, paramHashMap, paramBoolean);
      return;
    }
  }
  
  public static void a(String paramString, asav paramasav, boolean paramBoolean)
  {
    try
    {
      a(paramString, paramasav, null, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (Long)kU.get(paramString1);
        if (localObject == null)
        {
          QLog.e("ForwardStatisticsReporter", 1, new Object[] { "report invalid key =", paramString1 });
          return;
        }
        kU.remove(paramString1);
        paramLong -= ((Long)localObject).longValue();
        if ((paramHashMap == null) || (paramHashMap.isEmpty()))
        {
          QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", artw.qx(paramString2) });
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(paramString2, paramString1, paramBoolean, paramLong, 0L, paramHashMap, "", false);
          adty.a(paramString1, paramBoolean, paramLong, paramHashMap);
          if (!"KEY_STAGE_2_TOTAL".equals(paramString1)) {
            continue;
          }
          kU.clear();
          continue;
        }
        localObject = new StringBuilder();
      }
      finally {}
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue()).append(" ");
      }
      QLog.d("ForwardStatisticsReporter", 1, new Object[] { paramString1, "=", Long.valueOf(paramLong), ", uin=", artw.qx(paramString2), ", params[", ((StringBuilder)localObject).toString(), "]" });
    }
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      a(paramString1, paramString2, System.currentTimeMillis(), paramHashMap, paramBoolean);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static void ao(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 100	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: invokevirtual 104	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   9: checkcast 106	com/tencent/common/app/AppInterface
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +33 -> 47
    //   17: ldc 112
    //   19: iconst_1
    //   20: new 222	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 269
    //   30: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_0
    //   34: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: ldc 2
    //   45: monitorexit
    //   46: return
    //   47: aload_3
    //   48: invokevirtual 110	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   51: astore_3
    //   52: ldc 112
    //   54: iconst_1
    //   55: iconst_5
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc 211
    //   67: aastore
    //   68: dup
    //   69: iconst_2
    //   70: lload_1
    //   71: invokestatic 78	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: aastore
    //   75: dup
    //   76: iconst_3
    //   77: ldc 118
    //   79: aastore
    //   80: dup
    //   81: iconst_4
    //   82: aload_3
    //   83: invokestatic 124	artw:qx	(Ljava/lang/String;)Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: invokestatic 134	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   93: invokestatic 139	anpc:a	(Landroid/content/Context;)Lanpc;
    //   96: aload_3
    //   97: aload_0
    //   98: iconst_1
    //   99: lload_1
    //   100: lconst_0
    //   101: aconst_null
    //   102: ldc 141
    //   104: iconst_0
    //   105: invokevirtual 145	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   108: aload_0
    //   109: iconst_1
    //   110: lload_1
    //   111: aconst_null
    //   112: invokestatic 148	adty:a	(Ljava/lang/String;ZJLjava/util/HashMap;)V
    //   115: goto -72 -> 43
    //   118: astore_0
    //   119: ldc 2
    //   121: monitorexit
    //   122: aload_0
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   0	124	1	paramLong	long
    //   12	85	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	118	finally
    //   17	43	118	finally
    //   47	115	118	finally
  }
  
  public static void init()
  {
    try
    {
      kU.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void report(String paramString)
  {
    try
    {
      x(paramString, true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void report(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    try
    {
      a(paramString, ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), paramHashMap, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void x(String paramString, boolean paramBoolean)
  {
    try
    {
      N(paramString, ((AppInterface)BaseApplicationImpl.sApplication.getRuntime()).getCurrentAccountUin(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlw
 * JD-Core Version:    0.7.0.1
 */