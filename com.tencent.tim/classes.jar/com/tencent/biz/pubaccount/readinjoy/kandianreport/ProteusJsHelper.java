package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ProteusJsHelper
{
  private static final String TAG = "kandianreport.ProteusJsHelper";
  private static Map<String, JSContext> jsContextMap = new HashMap();
  
  public static void createJsContext(String paramString1, String paramString2)
  {
    try
    {
      createJsContextAsync(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private static void createJsContextAsync(String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new ProteusJsHelper.2(paramString1, paramString2));
  }
  
  private static void createJsContextIfSoLoaded(String paramString1, String paramString2)
  {
    if (!KandianReportSoLoader.isSoFiledLoad())
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "so not loaded, now load");
      KandianReportSoLoader.loadSoFiles(new ProteusJsHelper.3(paramString1, paramString2));
      return;
    }
    createJsContextWhileSoLoaded(paramString1, paramString2);
  }
  
  private static void createJsContextWhileSoLoaded(String paramString1, String paramString2)
  {
    JSContext localJSContext = new JSContext();
    StringBuffer localStringBuffer = new StringBuffer();
    localJSContext.evaluteStringWithException(paramString1, localStringBuffer);
    if (!TextUtils.isEmpty(localStringBuffer))
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "create js context failed id: " + paramString2 + " exception: " + localStringBuffer);
      return;
    }
    jsContextMap.put(paramString2, localJSContext);
    QLog.d("kandianreport.ProteusJsHelper", 1, "create js context success: " + paramString2);
  }
  
  /* Error */
  public static Object evaluateJs(String paramString1, String paramString2, String paramString3, @android.support.annotation.NonNull StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   6: lstore 4
    //   8: ldc 8
    //   10: iconst_1
    //   11: ldc 127
    //   13: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: getstatic 20	com/tencent/biz/pubaccount/readinjoy/kandianreport/ProteusJsHelper:jsContextMap	Ljava/util/Map;
    //   19: aload_0
    //   20: invokeinterface 131 2 0
    //   25: checkcast 74	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext
    //   28: astore_0
    //   29: ldc 8
    //   31: iconst_1
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 133
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   46: lload 4
    //   48: lsub
    //   49: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: ifnull +152 -> 209
    //   60: new 90	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   67: aload_1
    //   68: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 144
    //   73: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_2
    //   77: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 146
    //   82: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_2
    //   89: aload_0
    //   90: aload_2
    //   91: aload_3
    //   92: invokevirtual 82	com/tencent/biz/pubaccount/readinjoy/featurecompute/JSContext:evaluteStringWithException	(Ljava/lang/String;Ljava/lang/StringBuffer;)Ljava/lang/Object;
    //   95: astore_0
    //   96: ldc 8
    //   98: iconst_1
    //   99: iconst_2
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc 148
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   113: lload 4
    //   115: lsub
    //   116: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   119: aastore
    //   120: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   123: aload_3
    //   124: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +39 -> 166
    //   130: ldc 8
    //   132: iconst_1
    //   133: new 90	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   140: ldc 150
    //   142: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_2
    //   146: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 99
    //   151: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aconst_null
    //   165: astore_0
    //   166: ldc 2
    //   168: monitorexit
    //   169: aload_0
    //   170: areturn
    //   171: astore_0
    //   172: ldc 8
    //   174: iconst_1
    //   175: new 90	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   182: ldc 150
    //   184: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_1
    //   188: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc 99
    //   193: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: invokevirtual 153	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aconst_null
    //   210: astore_0
    //   211: goto -45 -> 166
    //   214: astore_0
    //   215: ldc 2
    //   217: monitorexit
    //   218: aload_0
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString1	String
    //   0	220	1	paramString2	String
    //   0	220	2	paramString3	String
    //   0	220	3	paramStringBuffer	StringBuffer
    //   6	108	4	l	long
    // Exception table:
    //   from	to	target	type
    //   60	123	171	java/lang/Throwable
    //   123	164	171	java/lang/Throwable
    //   3	56	214	finally
    //   60	123	214	finally
    //   123	164	214	finally
    //   172	209	214	finally
  }
  
  public static boolean isContextExist(String paramString)
  {
    return jsContextMap.get(paramString) != null;
  }
  
  public static boolean preLoadSo()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!KandianReportSoLoader.checkSoFileIsReady())
      {
        bool1 = bool2;
        KandianReportSoLoader.downLoadSoFiles(new ProteusJsHelper.1());
        return false;
      }
      bool1 = bool2;
      bool2 = KandianReportSoLoader.isSoFiledLoad();
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        KandianReportSoLoader.loadSoFiles();
        return bool2;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ProteusJsHelper", 2, "preLoadSo, t = ", localThrowable);
    }
    return bool1;
  }
  
  public static void prepare()
  {
    try
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "prepare to load.");
      KandianReportSoLoader.loadSoFiles();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("kandianreport.ProteusJsHelper", 1, "prepare error, t = ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper
 * JD-Core Version:    0.7.0.1
 */