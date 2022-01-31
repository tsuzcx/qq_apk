import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

public class gos
  implements CrashHandleListener
{
  public gos(StatisticCollector paramStatisticCollector) {}
  
  public byte[] getCrashExtraData()
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage()
  {
    // Byte code:
    //   0: new 24	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: invokestatic 29	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/lang/String;
    //   12: astore 5
    //   14: invokestatic 34	mqq/app/AppRuntime:showInfo	()Ljava/lang/String;
    //   17: astore 6
    //   19: new 24	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   26: ldc 36
    //   28: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: astore 7
    //   33: getstatic 45	com/tencent/mobileqq/app/BaseActivity:a	Lcom/tencent/mobileqq/app/BaseActivity;
    //   36: ifnonnull +97 -> 133
    //   39: ldc 47
    //   41: astore_3
    //   42: aload 7
    //   44: aload_3
    //   45: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 49
    //   50: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_3
    //   57: new 24	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   64: astore 7
    //   66: aload_0
    //   67: getfield 12	gos:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   70: invokestatic 55	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   73: invokevirtual 61	java/util/Stack:size	()I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_5
    //   79: invokestatic 67	java/lang/Math:min	(II)I
    //   82: istore_1
    //   83: iload_1
    //   84: ifle +59 -> 143
    //   87: aload_0
    //   88: getfield 12	gos:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   91: invokestatic 55	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   94: invokevirtual 71	java/util/Stack:pop	()Ljava/lang/Object;
    //   97: checkcast 73	java/lang/String
    //   100: astore 8
    //   102: aload 7
    //   104: invokevirtual 76	java/lang/StringBuilder:length	()I
    //   107: ifle +11 -> 118
    //   110: aload 7
    //   112: ldc 78
    //   114: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 7
    //   120: aload 8
    //   122: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: iload_1
    //   127: iconst_1
    //   128: isub
    //   129: istore_1
    //   130: goto -47 -> 83
    //   133: getstatic 45	com/tencent/mobileqq/app/BaseActivity:a	Lcom/tencent/mobileqq/app/BaseActivity;
    //   136: invokevirtual 79	java/lang/Object:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: goto -98 -> 42
    //   143: aload_0
    //   144: getfield 12	gos:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   147: invokestatic 55	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   150: invokevirtual 82	java/util/Stack:clear	()V
    //   153: aload 4
    //   155: new 24	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   162: aload 5
    //   164: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 49
    //   169: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 4
    //   181: new 24	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   188: aload 6
    //   190: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 49
    //   195: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 4
    //   207: aload_3
    //   208: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 4
    //   214: new 24	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   221: ldc 84
    //   223: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: iload_2
    //   227: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: ldc 89
    //   232: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 4
    //   244: new 24	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   251: aload 7
    //   253: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: ldc 49
    //   258: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: aload_0
    //   271: getfield 12	gos:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   274: invokestatic 95	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/HashMap;
    //   277: invokevirtual 98	java/util/HashMap:toString	()Ljava/lang/String;
    //   280: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_0
    //   285: getfield 12	gos:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   288: invokestatic 101	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   291: invokevirtual 104	java/util/LinkedList:size	()I
    //   294: ifle +29 -> 323
    //   297: aload 4
    //   299: aload_0
    //   300: getfield 12	gos:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   303: invokestatic 101	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   306: invokevirtual 107	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   309: checkcast 109	got
    //   312: invokevirtual 110	got:toString	()Ljava/lang/String;
    //   315: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: goto -35 -> 284
    //   322: astore_3
    //   323: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +32 -> 358
    //   329: ldc 118
    //   331: iconst_2
    //   332: new 24	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   339: ldc 120
    //   341: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 4
    //   346: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: invokestatic 129	com/tencent/smtt/sdk/WebView:getQQBrowserVersion	()I
    //   361: istore_1
    //   362: invokestatic 132	com/tencent/smtt/sdk/WebView:getQQBrowserCoreVersion	()I
    //   365: istore_2
    //   366: iload_1
    //   367: ifne +17 -> 384
    //   370: aload 4
    //   372: ldc 134
    //   374: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 4
    //   380: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: areturn
    //   384: aload 4
    //   386: new 24	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   393: ldc 136
    //   395: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: iload_1
    //   399: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: ldc 138
    //   404: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload_2
    //   408: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: goto -40 -> 378
    //   421: astore_3
    //   422: goto -44 -> 378
    //   425: astore_3
    //   426: goto -142 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	gos
    //   82	317	1	i	int
    //   76	332	2	j	int
    //   41	167	3	str1	String
    //   322	1	3	localThrowable1	Throwable
    //   421	1	3	localThrowable2	Throwable
    //   425	1	3	localThrowable3	Throwable
    //   7	378	4	localStringBuilder1	java.lang.StringBuilder
    //   12	151	5	str2	String
    //   17	172	6	str3	String
    //   31	221	7	localStringBuilder2	java.lang.StringBuilder
    //   100	21	8	str4	String
    // Exception table:
    //   from	to	target	type
    //   284	319	322	java/lang/Throwable
    //   358	366	421	java/lang/Throwable
    //   370	378	421	java/lang/Throwable
    //   384	418	421	java/lang/Throwable
    //   9	39	425	java/lang/Throwable
    //   42	83	425	java/lang/Throwable
    //   87	118	425	java/lang/Throwable
    //   118	126	425	java/lang/Throwable
    //   133	140	425	java/lang/Throwable
    //   143	284	425	java/lang/Throwable
  }
  
  public boolean onCrashFinished(Thread paramThread, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "onCrashFinished ... throwable:" + paramThrowable.getMessage());
    }
    return true;
  }
  
  public void onCrashHappen(Thread paramThread, Throwable paramThrowable) {}
  
  public void onNativeCrash(int paramInt1, int paramInt2, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gos
 * JD-Core Version:    0.7.0.1
 */