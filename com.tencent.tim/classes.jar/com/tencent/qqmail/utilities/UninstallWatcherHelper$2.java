package com.tencent.qqmail.utilities;

final class UninstallWatcherHelper$2
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 18	java/io/File
    //   9: dup
    //   10: invokestatic 24	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   13: invokevirtual 28	com/tencent/qqmail/utilities/log/LogPathManager:getWatchdogRefreshExistTimePath	()Ljava/lang/String;
    //   16: invokespecial 31	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 8
    //   21: aload 8
    //   23: invokevirtual 35	java/io/File:exists	()Z
    //   26: ifne +4 -> 30
    //   29: return
    //   30: new 37	java/io/BufferedReader
    //   33: dup
    //   34: new 39	java/io/FileReader
    //   37: dup
    //   38: aload 8
    //   40: invokespecial 42	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   43: invokespecial 45	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 4
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: invokevirtual 48	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +198 -> 258
    //   63: aload 4
    //   65: astore_3
    //   66: aload 5
    //   68: ldc 50
    //   70: invokevirtual 56	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq -25 -> 48
    //   76: aload 4
    //   78: astore_3
    //   79: aload 5
    //   81: ldc 58
    //   83: invokevirtual 62	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   86: astore 5
    //   88: aload 4
    //   90: astore_3
    //   91: aload 5
    //   93: arraylength
    //   94: iconst_2
    //   95: if_icmpne -47 -> 48
    //   98: aload 4
    //   100: astore_3
    //   101: aload 5
    //   103: iconst_1
    //   104: aaload
    //   105: invokestatic 68	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   108: invokevirtual 72	java/lang/Long:longValue	()J
    //   111: lstore_1
    //   112: aload 4
    //   114: astore_3
    //   115: iconst_1
    //   116: newarray double
    //   118: dup
    //   119: iconst_0
    //   120: lload_1
    //   121: l2d
    //   122: ldc2_w 73
    //   125: ddiv
    //   126: ldc2_w 73
    //   129: ddiv
    //   130: ldc2_w 75
    //   133: dmul
    //   134: invokestatic 82	java/lang/Math:round	(D)J
    //   137: l2d
    //   138: ldc2_w 75
    //   141: ddiv
    //   142: dastore
    //   143: invokestatic 88	moai/oss/KvHelper:watchdogExistTime	([D)V
    //   146: aload 4
    //   148: astore_3
    //   149: iconst_3
    //   150: ldc 90
    //   152: new 92	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   159: ldc 95
    //   161: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: lload_1
    //   165: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   168: ldc 104
    //   170: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   179: goto -131 -> 48
    //   182: astore 5
    //   184: aload 4
    //   186: astore_3
    //   187: iconst_5
    //   188: ldc 90
    //   190: new 92	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   197: ldc 115
    //   199: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 5
    //   204: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 121	java/io/BufferedReader:close	()V
    //   226: aload 7
    //   228: astore_3
    //   229: new 123	java/io/PrintWriter
    //   232: dup
    //   233: aload 8
    //   235: invokespecial 124	java/io/PrintWriter:<init>	(Ljava/io/File;)V
    //   238: astore 4
    //   240: aload 4
    //   242: ldc 126
    //   244: invokevirtual 129	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   247: aload 4
    //   249: ifnull -220 -> 29
    //   252: aload 4
    //   254: invokevirtual 130	java/io/PrintWriter:close	()V
    //   257: return
    //   258: aload 4
    //   260: astore_3
    //   261: aload 4
    //   263: invokevirtual 121	java/io/BufferedReader:close	()V
    //   266: aload 4
    //   268: ifnull -42 -> 226
    //   271: aload 4
    //   273: invokevirtual 121	java/io/BufferedReader:close	()V
    //   276: goto -50 -> 226
    //   279: astore_3
    //   280: goto -54 -> 226
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 121	java/io/BufferedReader:close	()V
    //   295: aload 4
    //   297: athrow
    //   298: astore 5
    //   300: aload 6
    //   302: astore 4
    //   304: aload 4
    //   306: astore_3
    //   307: iconst_5
    //   308: ldc 90
    //   310: new 92	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   317: ldc 115
    //   319: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 5
    //   324: invokevirtual 131	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   327: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   336: aload 4
    //   338: ifnull -309 -> 29
    //   341: aload 4
    //   343: invokevirtual 130	java/io/PrintWriter:close	()V
    //   346: return
    //   347: astore 5
    //   349: aload_3
    //   350: astore 4
    //   352: aload 5
    //   354: astore_3
    //   355: aload 4
    //   357: ifnull +8 -> 365
    //   360: aload 4
    //   362: invokevirtual 130	java/io/PrintWriter:close	()V
    //   365: aload_3
    //   366: athrow
    //   367: astore_3
    //   368: goto -142 -> 226
    //   371: astore_3
    //   372: goto -77 -> 295
    //   375: astore_3
    //   376: goto -21 -> 355
    //   379: astore 5
    //   381: goto -77 -> 304
    //   384: astore 4
    //   386: goto -99 -> 287
    //   389: astore 5
    //   391: aconst_null
    //   392: astore 4
    //   394: goto -210 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	2
    //   111	54	1	l	long
    //   50	211	3	localObject1	Object
    //   279	1	3	localIOException1	java.io.IOException
    //   286	80	3	localObject2	Object
    //   367	1	3	localIOException2	java.io.IOException
    //   371	1	3	localIOException3	java.io.IOException
    //   375	1	3	localObject3	Object
    //   46	226	4	localObject4	Object
    //   283	13	4	localObject5	Object
    //   302	59	4	localObject6	Object
    //   384	1	4	localObject7	Object
    //   392	1	4	localObject8	Object
    //   56	46	5	localObject9	Object
    //   182	21	5	localIOException4	java.io.IOException
    //   298	25	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   347	6	5	localObject10	Object
    //   379	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   389	1	5	localIOException5	java.io.IOException
    //   4	297	6	localObject11	Object
    //   1	226	7	localObject12	Object
    //   19	215	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   51	58	182	java/io/IOException
    //   66	76	182	java/io/IOException
    //   79	88	182	java/io/IOException
    //   91	98	182	java/io/IOException
    //   101	112	182	java/io/IOException
    //   115	146	182	java/io/IOException
    //   149	179	182	java/io/IOException
    //   261	266	182	java/io/IOException
    //   271	276	279	java/io/IOException
    //   30	48	283	finally
    //   229	240	298	java/io/FileNotFoundException
    //   229	240	347	finally
    //   307	336	347	finally
    //   221	226	367	java/io/IOException
    //   291	295	371	java/io/IOException
    //   240	247	375	finally
    //   240	247	379	java/io/FileNotFoundException
    //   51	58	384	finally
    //   66	76	384	finally
    //   79	88	384	finally
    //   91	98	384	finally
    //   101	112	384	finally
    //   115	146	384	finally
    //   149	179	384	finally
    //   187	216	384	finally
    //   261	266	384	finally
    //   30	48	389	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.UninstallWatcherHelper.2
 * JD-Core Version:    0.7.0.1
 */