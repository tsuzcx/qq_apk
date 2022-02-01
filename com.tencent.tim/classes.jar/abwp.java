import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class abwp
{
  private static boolean bGa;
  private static long ke;
  private static long totalTime;
  
  public static abwi c()
    throws IllegalArgumentException
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return new abwi.a().a(1).a(((QQAppInterface)localAppRuntime).getCurrentAccountUin()).a();
    }
    throw new IllegalArgumentException("config should init in PROCESS_QQ");
  }
  
  private static Map<String, Integer> g(Context paramContext)
  {
    HashMap localHashMap = new HashMap(9);
    if (paramContext != null) {
      try
      {
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        if (paramContext != null)
        {
          paramContext = paramContext.getProcessMemoryInfo(new int[] { Process.myPid() });
          if ((paramContext != null) && (paramContext.length > 0))
          {
            paramContext = paramContext[0];
            if (paramContext != null)
            {
              if (Build.VERSION.SDK_INT >= 23)
              {
                localHashMap.put("summary.total-pss", Integer.valueOf(Integer.parseInt((String)paramContext.getMemoryStats().get("summary.total-pss"))));
                return localHashMap;
              }
              localHashMap.put("summary.total-pss", Integer.valueOf(paramContext.getTotalPss()));
              return localHashMap;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("TraceReport", 1, paramContext, new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static int getMemoryInfo()
  {
    try
    {
      Map localMap = g(BaseApplicationImpl.context);
      if (localMap == null) {
        break label58;
      }
      i = ((Integer)localMap.get("summary.total-pss")).intValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TraceReport", 1, localException, new Object[0]);
        int i = 0;
        continue;
        label58:
        i = 0;
      }
    }
    if (i > 0) {}
    for (;;)
    {
      return i / 1024;
      i = 0;
    }
  }
  
  /* Error */
  public static int jM()
  {
    // Byte code:
    //   0: getstatic 146	abwp:bGa	Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: fconst_0
    //   9: fstore_1
    //   10: fconst_0
    //   11: fstore_0
    //   12: new 148	java/io/BufferedReader
    //   15: dup
    //   16: new 150	java/io/InputStreamReader
    //   19: dup
    //   20: new 152	java/io/FileInputStream
    //   23: dup
    //   24: ldc 154
    //   26: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   32: sipush 1000
    //   35: invokespecial 161	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   38: astore 8
    //   40: aload 8
    //   42: astore 7
    //   44: fload_1
    //   45: fstore_0
    //   46: aload 8
    //   48: invokevirtual 164	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 9
    //   53: aload 9
    //   55: ifnonnull +32 -> 87
    //   58: aload 8
    //   60: ifnull +8 -> 68
    //   63: aload 8
    //   65: invokevirtual 167	java/io/BufferedReader:close	()V
    //   68: iconst_0
    //   69: ireturn
    //   70: astore 7
    //   72: ldc 121
    //   74: iconst_1
    //   75: aload 7
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   84: goto -16 -> 68
    //   87: aload 8
    //   89: astore 7
    //   91: fload_1
    //   92: fstore_0
    //   93: aload 9
    //   95: ldc 169
    //   97: invokevirtual 173	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   100: astore 9
    //   102: aload 8
    //   104: astore 7
    //   106: fload_1
    //   107: fstore_0
    //   108: aload 9
    //   110: iconst_2
    //   111: aaload
    //   112: invokestatic 179	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   115: aload 9
    //   117: iconst_3
    //   118: aaload
    //   119: invokestatic 179	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   122: ladd
    //   123: aload 9
    //   125: iconst_4
    //   126: aaload
    //   127: invokestatic 179	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   130: ladd
    //   131: lstore_3
    //   132: aload 8
    //   134: astore 7
    //   136: fload_1
    //   137: fstore_0
    //   138: aload 9
    //   140: iconst_5
    //   141: aaload
    //   142: invokestatic 179	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   145: lstore 5
    //   147: aload 8
    //   149: astore 7
    //   151: fload_1
    //   152: fstore_0
    //   153: lload_3
    //   154: getstatic 181	abwp:totalTime	J
    //   157: lsub
    //   158: l2f
    //   159: fstore_2
    //   160: aload 8
    //   162: astore 7
    //   164: fload_1
    //   165: fstore_0
    //   166: lload_3
    //   167: getstatic 181	abwp:totalTime	J
    //   170: lsub
    //   171: lload 5
    //   173: ladd
    //   174: getstatic 183	abwp:ke	J
    //   177: lsub
    //   178: l2f
    //   179: fstore_1
    //   180: aload 8
    //   182: astore 7
    //   184: fload_1
    //   185: fstore_0
    //   186: fload_2
    //   187: ldc 184
    //   189: fmul
    //   190: fload_1
    //   191: fdiv
    //   192: fstore_1
    //   193: aload 8
    //   195: astore 7
    //   197: fload_1
    //   198: fstore_0
    //   199: lload_3
    //   200: putstatic 181	abwp:totalTime	J
    //   203: aload 8
    //   205: astore 7
    //   207: fload_1
    //   208: fstore_0
    //   209: lload 5
    //   211: putstatic 183	abwp:ke	J
    //   214: fload_1
    //   215: fstore_2
    //   216: aload 8
    //   218: ifnull +10 -> 228
    //   221: aload 8
    //   223: invokevirtual 167	java/io/BufferedReader:close	()V
    //   226: fload_1
    //   227: fstore_2
    //   228: fload_2
    //   229: invokestatic 190	java/lang/Math:round	(F)I
    //   232: ireturn
    //   233: astore 7
    //   235: ldc 121
    //   237: iconst_1
    //   238: aload 7
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   247: fload_1
    //   248: fstore_2
    //   249: goto -21 -> 228
    //   252: astore 7
    //   254: aconst_null
    //   255: astore 8
    //   257: aload 8
    //   259: astore 7
    //   261: iconst_1
    //   262: putstatic 146	abwp:bGa	Z
    //   265: fload_0
    //   266: fstore_2
    //   267: aload 8
    //   269: ifnull -41 -> 228
    //   272: aload 8
    //   274: invokevirtual 167	java/io/BufferedReader:close	()V
    //   277: fload_0
    //   278: fstore_2
    //   279: goto -51 -> 228
    //   282: astore 7
    //   284: ldc 121
    //   286: iconst_1
    //   287: aload 7
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   296: fload_0
    //   297: fstore_2
    //   298: goto -70 -> 228
    //   301: astore 8
    //   303: aconst_null
    //   304: astore 7
    //   306: aload 7
    //   308: ifnull +8 -> 316
    //   311: aload 7
    //   313: invokevirtual 167	java/io/BufferedReader:close	()V
    //   316: aload 8
    //   318: athrow
    //   319: astore 7
    //   321: ldc 121
    //   323: iconst_1
    //   324: aload 7
    //   326: iconst_0
    //   327: anewarray 4	java/lang/Object
    //   330: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   333: goto -17 -> 316
    //   336: astore 8
    //   338: goto -32 -> 306
    //   341: astore 7
    //   343: goto -86 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	286	0	f1	float
    //   9	239	1	f2	float
    //   159	139	2	f3	float
    //   131	69	3	l1	long
    //   145	65	5	l2	long
    //   42	1	7	localBufferedReader1	java.io.BufferedReader
    //   70	6	7	localException1	Exception
    //   89	117	7	localBufferedReader2	java.io.BufferedReader
    //   233	6	7	localException2	Exception
    //   252	1	7	localIOException1	java.io.IOException
    //   259	1	7	localBufferedReader3	java.io.BufferedReader
    //   282	6	7	localException3	Exception
    //   304	8	7	localObject1	Object
    //   319	6	7	localException4	Exception
    //   341	1	7	localIOException2	java.io.IOException
    //   38	235	8	localBufferedReader4	java.io.BufferedReader
    //   301	16	8	localObject2	Object
    //   336	1	8	localObject3	Object
    //   51	88	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   63	68	70	java/lang/Exception
    //   221	226	233	java/lang/Exception
    //   12	40	252	java/io/IOException
    //   272	277	282	java/lang/Exception
    //   12	40	301	finally
    //   311	316	319	java/lang/Exception
    //   46	53	336	finally
    //   93	102	336	finally
    //   108	132	336	finally
    //   138	147	336	finally
    //   153	160	336	finally
    //   166	180	336	finally
    //   186	193	336	finally
    //   199	203	336	finally
    //   209	214	336	finally
    //   261	265	336	finally
    //   46	53	341	java/io/IOException
    //   93	102	341	java/io/IOException
    //   108	132	341	java/io/IOException
    //   138	147	341	java/io/IOException
    //   153	160	341	java/io/IOException
    //   166	180	341	java/io/IOException
    //   186	193	341	java/io/IOException
    //   199	203	341	java/io/IOException
    //   209	214	341	java/io/IOException
  }
  
  public static int zW()
  {
    return (int)((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L);
  }
  
  public static int zX()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abwp
 * JD-Core Version:    0.7.0.1
 */