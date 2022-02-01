package com.tencent.qqmini.sdk.launcher.dynamic;

class MiniDynamicManager$1
  implements Runnable
{
  MiniDynamicManager$1(MiniDynamicManager paramMiniDynamicManager, MiniDexConfig paramMiniDexConfig, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 32	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: getfield 19	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexConfig	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;
    //   14: getfield 37	com/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig:dexUrl	Ljava/lang/String;
    //   17: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 46	java/net/HttpURLConnection
    //   26: astore_2
    //   27: aload_2
    //   28: sipush 10000
    //   31: invokevirtual 50	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   34: aload_2
    //   35: ldc 52
    //   37: invokevirtual 55	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokevirtual 59	java/net/HttpURLConnection:getResponseCode	()I
    //   44: istore_1
    //   45: iload_1
    //   46: sipush 200
    //   49: if_icmpeq +52 -> 101
    //   52: ldc 61
    //   54: new 63	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   61: ldc 66
    //   63: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 83	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 85	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: iconst_0
    //   89: ifeq +11 -> 100
    //   92: new 85	java/lang/NullPointerException
    //   95: dup
    //   96: invokespecial 86	java/lang/NullPointerException:<init>	()V
    //   99: athrow
    //   100: return
    //   101: aload_2
    //   102: invokevirtual 90	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   105: astore_2
    //   106: new 92	java/io/File
    //   109: dup
    //   110: aload_0
    //   111: getfield 21	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexPath	Ljava/lang/String;
    //   114: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 97	java/io/File:exists	()Z
    //   122: ifeq +8 -> 130
    //   125: aload_3
    //   126: invokevirtual 100	java/io/File:delete	()Z
    //   129: pop
    //   130: aload_3
    //   131: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
    //   134: invokevirtual 97	java/io/File:exists	()Z
    //   137: ifne +11 -> 148
    //   140: aload_3
    //   141: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
    //   144: invokevirtual 107	java/io/File:mkdirs	()Z
    //   147: pop
    //   148: aload_3
    //   149: invokevirtual 110	java/io/File:createNewFile	()Z
    //   152: pop
    //   153: new 112	java/io/FileOutputStream
    //   156: dup
    //   157: aload_3
    //   158: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   161: astore_3
    //   162: sipush 8192
    //   165: newarray byte
    //   167: astore 4
    //   169: aload_2
    //   170: aload 4
    //   172: invokevirtual 121	java/io/InputStream:read	([B)I
    //   175: istore_1
    //   176: iload_1
    //   177: iconst_m1
    //   178: if_icmpeq +51 -> 229
    //   181: aload_3
    //   182: aload 4
    //   184: iconst_0
    //   185: iload_1
    //   186: invokevirtual 127	java/io/OutputStream:write	([BII)V
    //   189: goto -20 -> 169
    //   192: astore 5
    //   194: aload_3
    //   195: astore 4
    //   197: aload 5
    //   199: astore_3
    //   200: ldc 61
    //   202: ldc 129
    //   204: aload_3
    //   205: invokestatic 132	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 135	java/io/InputStream:close	()V
    //   216: aload 4
    //   218: ifnull -118 -> 100
    //   221: aload 4
    //   223: invokevirtual 136	java/io/OutputStream:close	()V
    //   226: return
    //   227: astore_2
    //   228: return
    //   229: ldc 61
    //   231: ldc 138
    //   233: invokestatic 141	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_0
    //   237: getfield 23	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$config	Ljava/lang/String;
    //   240: aload_0
    //   241: getfield 17	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;
    //   244: invokestatic 147	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager:access$000	(Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;)Ljava/lang/String;
    //   247: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +18 -> 268
    //   253: aload_0
    //   254: getfield 17	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:this$0	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;
    //   257: aload_0
    //   258: getfield 23	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$config	Ljava/lang/String;
    //   261: aload_0
    //   262: getfield 19	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager$1:val$dexConfig	Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;
    //   265: invokestatic 157	com/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager:access$100	(Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDynamicManager;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/dynamic/MiniDexConfig;)V
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 135	java/io/InputStream:close	()V
    //   276: aload_3
    //   277: ifnull -177 -> 100
    //   280: aload_3
    //   281: invokevirtual 136	java/io/OutputStream:close	()V
    //   284: return
    //   285: astore_2
    //   286: return
    //   287: astore_3
    //   288: aconst_null
    //   289: astore_2
    //   290: aload 5
    //   292: astore 4
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 135	java/io/InputStream:close	()V
    //   302: aload 4
    //   304: ifnull +8 -> 312
    //   307: aload 4
    //   309: invokevirtual 136	java/io/OutputStream:close	()V
    //   312: aload_3
    //   313: athrow
    //   314: astore_2
    //   315: goto -3 -> 312
    //   318: astore_3
    //   319: aload 5
    //   321: astore 4
    //   323: goto -29 -> 294
    //   326: astore 5
    //   328: aload_3
    //   329: astore 4
    //   331: aload 5
    //   333: astore_3
    //   334: goto -40 -> 294
    //   337: astore_3
    //   338: goto -44 -> 294
    //   341: astore_3
    //   342: aconst_null
    //   343: astore_2
    //   344: goto -144 -> 200
    //   347: astore_3
    //   348: goto -148 -> 200
    //   351: astore_2
    //   352: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	1
    //   44	142	1	i	int
    //   26	187	2	localObject1	Object
    //   227	46	2	localThrowable1	java.lang.Throwable
    //   285	1	2	localThrowable2	java.lang.Throwable
    //   289	10	2	localObject2	Object
    //   314	1	2	localThrowable3	java.lang.Throwable
    //   343	1	2	localObject3	Object
    //   351	1	2	localThrowable4	java.lang.Throwable
    //   117	164	3	localObject4	Object
    //   287	26	3	localObject5	Object
    //   318	11	3	localObject6	Object
    //   333	1	3	localObject7	Object
    //   337	1	3	localObject8	Object
    //   341	1	3	localThrowable5	java.lang.Throwable
    //   347	1	3	localThrowable6	java.lang.Throwable
    //   4	326	4	localObject9	Object
    //   1	1	5	localObject10	Object
    //   192	128	5	localThrowable7	java.lang.Throwable
    //   326	6	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   162	169	192	java/lang/Throwable
    //   169	176	192	java/lang/Throwable
    //   181	189	192	java/lang/Throwable
    //   229	268	192	java/lang/Throwable
    //   212	216	227	java/lang/Throwable
    //   221	226	227	java/lang/Throwable
    //   272	276	285	java/lang/Throwable
    //   280	284	285	java/lang/Throwable
    //   6	45	287	finally
    //   52	76	287	finally
    //   101	106	287	finally
    //   298	302	314	java/lang/Throwable
    //   307	312	314	java/lang/Throwable
    //   106	130	318	finally
    //   130	148	318	finally
    //   148	162	318	finally
    //   162	169	326	finally
    //   169	176	326	finally
    //   181	189	326	finally
    //   229	268	326	finally
    //   200	208	337	finally
    //   6	45	341	java/lang/Throwable
    //   52	76	341	java/lang/Throwable
    //   101	106	341	java/lang/Throwable
    //   106	130	347	java/lang/Throwable
    //   130	148	347	java/lang/Throwable
    //   148	162	347	java/lang/Throwable
    //   80	88	351	java/lang/Throwable
    //   92	100	351	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager.1
 * JD-Core Version:    0.7.0.1
 */