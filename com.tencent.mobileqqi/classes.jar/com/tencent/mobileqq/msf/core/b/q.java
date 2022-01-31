package com.tencent.mobileqq.msf.core.b;

class q
  extends Thread
{
  q(i parami) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokevirtual 25	java/lang/String:getBytes	()[B
    //   5: astore 4
    //   7: new 27	java/net/URL
    //   10: dup
    //   11: ldc 29
    //   13: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: astore 5
    //   18: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   21: pop2
    //   22: aload 5
    //   24: invokevirtual 42	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 44	java/net/HttpURLConnection
    //   30: astore_3
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 48	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   36: aload_3
    //   37: ldc 50
    //   39: invokevirtual 53	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   42: aload_3
    //   43: sipush 10000
    //   46: invokevirtual 57	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   49: aload_3
    //   50: sipush 10000
    //   53: invokevirtual 60	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   56: aload_3
    //   57: invokevirtual 64	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   60: aload 4
    //   62: invokevirtual 70	java/io/OutputStream:write	([B)V
    //   65: aload_3
    //   66: invokevirtual 64	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   69: invokevirtual 73	java/io/OutputStream:flush	()V
    //   72: aload_3
    //   73: invokevirtual 64	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   76: invokevirtual 76	java/io/OutputStream:close	()V
    //   79: new 78	java/io/BufferedInputStream
    //   82: dup
    //   83: aload_3
    //   84: invokevirtual 82	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   87: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: pop
    //   91: aload 5
    //   93: invokevirtual 89	java/net/URL:getHost	()Ljava/lang/String;
    //   96: aload_3
    //   97: invokevirtual 93	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   100: invokevirtual 89	java/net/URL:getHost	()Ljava/lang/String;
    //   103: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifne +221 -> 327
    //   109: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   112: ifeq +31 -> 143
    //   115: ldc 105
    //   117: iconst_4
    //   118: new 107	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   125: ldc 110
    //   127: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 93	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   134: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   146: lstore_1
    //   147: aload_0
    //   148: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   151: getfield 130	com/tencent/mobileqq/msf/core/b/i:v	J
    //   154: lconst_0
    //   155: lcmp
    //   156: ifne +50 -> 206
    //   159: aload_0
    //   160: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   163: lload_1
    //   164: putfield 130	com/tencent/mobileqq/msf/core/b/i:v	J
    //   167: new 132	com/tencent/mobileqq/msf/core/b/r
    //   170: dup
    //   171: aload_0
    //   172: invokespecial 135	com/tencent/mobileqq/msf/core/b/r:<init>	(Lcom/tencent/mobileqq/msf/core/b/q;)V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc 137
    //   181: invokevirtual 140	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   184: aload 4
    //   186: invokevirtual 143	java/lang/Thread:start	()V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   197: aload_0
    //   198: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   201: aconst_null
    //   202: putfield 150	com/tencent/mobileqq/msf/core/b/i:x	Ljava/lang/Thread;
    //   205: return
    //   206: lload_1
    //   207: aload_0
    //   208: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   211: getfield 130	com/tencent/mobileqq/msf/core/b/i:v	J
    //   214: lsub
    //   215: ldc2_w 151
    //   218: lcmp
    //   219: iflt +91 -> 310
    //   222: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   225: ifeq +11 -> 236
    //   228: ldc 105
    //   230: iconst_4
    //   231: ldc 154
    //   233: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: new 156	com/tencent/qphone/base/remote/FromServiceMsg
    //   239: dup
    //   240: getstatic 162	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   243: invokevirtual 168	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   246: invokestatic 171	com/tencent/mobileqq/msf/core/MsfCore:getNextSeq	()I
    //   249: ldc 173
    //   251: ldc 175
    //   253: invokespecial 178	com/tencent/qphone/base/remote/FromServiceMsg:<init>	(IILjava/lang/String;Ljava/lang/String;)V
    //   256: astore 4
    //   258: aload 4
    //   260: invokevirtual 181	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   263: aload 4
    //   265: getstatic 187	com/tencent/mobileqq/msf/sdk/MsfCommand:onNetNeedSignon	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   268: invokevirtual 191	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   271: aload 4
    //   273: ldc 193
    //   275: aload_3
    //   276: invokevirtual 93	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   279: invokevirtual 194	java/net/URL:toString	()Ljava/lang/String;
    //   282: invokevirtual 198	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: ldc 200
    //   288: aload 4
    //   290: invokestatic 206	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   293: getstatic 162	com/tencent/mobileqq/msf/core/NetConnInfoCenterImpl:msfCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   296: aconst_null
    //   297: aload 4
    //   299: invokevirtual 210	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   302: aload_0
    //   303: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   306: lconst_0
    //   307: putfield 130	com/tencent/mobileqq/msf/core/b/i:v	J
    //   310: aload_3
    //   311: ifnull +7 -> 318
    //   314: aload_3
    //   315: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   318: aload_0
    //   319: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   322: aconst_null
    //   323: putfield 150	com/tencent/mobileqq/msf/core/b/i:x	Ljava/lang/Thread;
    //   326: return
    //   327: aload_0
    //   328: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   331: lconst_0
    //   332: putfield 130	com/tencent/mobileqq/msf/core/b/i:v	J
    //   335: goto -25 -> 310
    //   338: astore 4
    //   340: invokestatic 103	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   343: ifeq +31 -> 374
    //   346: ldc 105
    //   348: iconst_4
    //   349: new 107	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   356: ldc 212
    //   358: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 4
    //   363: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: aload 4
    //   371: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: aload_3
    //   375: ifnull +7 -> 382
    //   378: aload_3
    //   379: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   382: aload_0
    //   383: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   386: aconst_null
    //   387: putfield 150	com/tencent/mobileqq/msf/core/b/i:x	Ljava/lang/Thread;
    //   390: return
    //   391: astore 4
    //   393: aconst_null
    //   394: astore_3
    //   395: aload_3
    //   396: ifnull +7 -> 403
    //   399: aload_3
    //   400: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   403: aload_0
    //   404: getfield 10	com/tencent/mobileqq/msf/core/b/q:a	Lcom/tencent/mobileqq/msf/core/b/i;
    //   407: aconst_null
    //   408: putfield 150	com/tencent/mobileqq/msf/core/b/i:x	Ljava/lang/Thread;
    //   411: aload 4
    //   413: athrow
    //   414: astore 4
    //   416: goto -21 -> 395
    //   419: astore 4
    //   421: goto -26 -> 395
    //   424: astore 4
    //   426: aconst_null
    //   427: astore_3
    //   428: goto -88 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	q
    //   146	61	1	l	long
    //   30	398	3	localHttpURLConnection	java.net.HttpURLConnection
    //   5	293	4	localObject1	java.lang.Object
    //   338	32	4	localThrowable1	java.lang.Throwable
    //   391	21	4	localObject2	java.lang.Object
    //   414	1	4	localObject3	java.lang.Object
    //   419	1	4	localObject4	java.lang.Object
    //   424	1	4	localThrowable2	java.lang.Throwable
    //   16	76	5	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   31	143	338	java/lang/Throwable
    //   143	189	338	java/lang/Throwable
    //   206	236	338	java/lang/Throwable
    //   236	310	338	java/lang/Throwable
    //   327	335	338	java/lang/Throwable
    //   7	31	391	finally
    //   31	143	414	finally
    //   143	189	414	finally
    //   206	236	414	finally
    //   236	310	414	finally
    //   327	335	414	finally
    //   340	374	419	finally
    //   7	31	424	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.q
 * JD-Core Version:    0.7.0.1
 */