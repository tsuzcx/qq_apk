import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

public class eeu
  implements CrashHandleListener
{
  public eeu(StatisticCollector paramStatisticCollector) {}
  
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
    //   9: aload 4
    //   11: new 24	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   18: ldc 27
    //   20: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 36	com/tencent/common/app/BaseApplicationImpl:a	Ljava/lang/String;
    //   26: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: new 24	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   45: ldc 41
    //   47: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: getstatic 44	com/tencent/common/app/BaseApplicationImpl:b	Ljava/lang/String;
    //   53: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: new 24	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   72: ldc 46
    //   74: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: getstatic 49	com/tencent/common/app/BaseApplicationImpl:c	Ljava/lang/String;
    //   80: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 4
    //   92: new 24	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   99: ldc 51
    //   101: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: getstatic 56	com/tencent/mobileqq/startup/director/StartupDirector:c	I
    //   107: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: ldc 61
    //   121: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: invokestatic 65	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/lang/String;
    //   128: astore 5
    //   130: invokestatic 70	mqq/app/AppRuntime:showInfo	()Ljava/lang/String;
    //   133: astore 6
    //   135: new 24	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   142: ldc 72
    //   144: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: astore 7
    //   149: getstatic 78	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   152: ifnonnull +97 -> 249
    //   155: ldc 80
    //   157: astore_3
    //   158: aload 7
    //   160: aload_3
    //   161: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc 61
    //   166: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore_3
    //   173: new 24	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   180: astore 7
    //   182: aload_0
    //   183: getfield 12	eeu:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   186: invokestatic 83	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   189: invokevirtual 89	java/util/Stack:size	()I
    //   192: istore_2
    //   193: iload_2
    //   194: iconst_5
    //   195: invokestatic 95	java/lang/Math:min	(II)I
    //   198: istore_1
    //   199: iload_1
    //   200: ifle +59 -> 259
    //   203: aload_0
    //   204: getfield 12	eeu:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   207: invokestatic 83	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   210: invokevirtual 99	java/util/Stack:pop	()Ljava/lang/Object;
    //   213: checkcast 101	java/lang/String
    //   216: astore 8
    //   218: aload 7
    //   220: invokevirtual 104	java/lang/StringBuilder:length	()I
    //   223: ifle +11 -> 234
    //   226: aload 7
    //   228: ldc 106
    //   230: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 7
    //   236: aload 8
    //   238: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: iload_1
    //   243: iconst_1
    //   244: isub
    //   245: istore_1
    //   246: goto -47 -> 199
    //   249: getstatic 78	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   252: invokevirtual 107	java/lang/Object:toString	()Ljava/lang/String;
    //   255: astore_3
    //   256: goto -98 -> 158
    //   259: aload_0
    //   260: getfield 12	eeu:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   263: invokestatic 83	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   266: invokevirtual 110	java/util/Stack:clear	()V
    //   269: aload 4
    //   271: new 24	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   278: aload 5
    //   280: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 61
    //   285: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 4
    //   297: new 24	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   304: aload 6
    //   306: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 61
    //   311: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 4
    //   323: aload_3
    //   324: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 4
    //   330: new 24	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   337: ldc 112
    //   339: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: iload_2
    //   343: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: ldc 114
    //   348: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 4
    //   360: new 24	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   367: aload 7
    //   369: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   372: ldc 61
    //   374: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 4
    //   386: ldc 119
    //   388: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 4
    //   394: aload_0
    //   395: getfield 12	eeu:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   398: invokestatic 122	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/HashMap;
    //   401: invokevirtual 125	java/util/HashMap:toString	()Ljava/lang/String;
    //   404: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 4
    //   410: ldc 61
    //   412: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 4
    //   418: ldc 61
    //   420: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_0
    //   425: getfield 12	eeu:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   428: invokestatic 128	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   431: invokevirtual 131	java/util/LinkedList:size	()I
    //   434: ifle +29 -> 463
    //   437: aload 4
    //   439: aload_0
    //   440: getfield 12	eeu:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   443: invokestatic 128	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   446: invokevirtual 134	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   449: checkcast 136	eev
    //   452: invokevirtual 137	eev:toString	()Ljava/lang/String;
    //   455: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: goto -35 -> 424
    //   462: astore_3
    //   463: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +32 -> 498
    //   469: ldc 145
    //   471: iconst_2
    //   472: new 24	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   479: ldc 147
    //   481: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 4
    //   486: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: invokestatic 156	com/tencent/smtt/sdk/WebView:getQQBrowserVersion	()I
    //   501: istore_1
    //   502: invokestatic 159	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   505: invokestatic 163	com/tencent/smtt/sdk/WebView:getQQBrowserCoreVersion	(Landroid/content/Context;)I
    //   508: istore_2
    //   509: iload_1
    //   510: ifne +17 -> 527
    //   513: aload 4
    //   515: ldc 165
    //   517: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 4
    //   523: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: areturn
    //   527: aload 4
    //   529: new 24	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   536: ldc 167
    //   538: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: iload_1
    //   542: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: ldc 169
    //   547: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: iload_2
    //   551: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: goto -40 -> 521
    //   564: astore_3
    //   565: goto -44 -> 521
    //   568: astore_3
    //   569: goto -145 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	eeu
    //   198	344	1	i	int
    //   192	359	2	j	int
    //   157	167	3	str1	String
    //   462	1	3	localThrowable1	Throwable
    //   564	1	3	localThrowable2	Throwable
    //   568	1	3	localThrowable3	Throwable
    //   7	521	4	localStringBuilder1	java.lang.StringBuilder
    //   128	151	5	str2	String
    //   133	172	6	str3	String
    //   147	221	7	localStringBuilder2	java.lang.StringBuilder
    //   216	21	8	str4	String
    // Exception table:
    //   from	to	target	type
    //   424	459	462	java/lang/Throwable
    //   498	509	564	java/lang/Throwable
    //   513	521	564	java/lang/Throwable
    //   527	561	564	java/lang/Throwable
    //   9	155	568	java/lang/Throwable
    //   158	199	568	java/lang/Throwable
    //   203	234	568	java/lang/Throwable
    //   234	242	568	java/lang/Throwable
    //   249	256	568	java/lang/Throwable
    //   259	424	568	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eeu
 * JD-Core Version:    0.7.0.1
 */