package com.tencent.token.core.push;

import android.os.Handler;

class g
  implements Runnable
{
  g(b paramb, Handler paramHandler) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   4: invokestatic 31	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
    //   7: ifnonnull +11 -> 18
    //   10: aload_0
    //   11: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   14: invokevirtual 34	com/tencent/token/core/push/b:d	()V
    //   17: return
    //   18: aload_0
    //   19: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   22: aconst_null
    //   23: putfield 37	com/tencent/token/core/push/b:d	[B
    //   26: aload_0
    //   27: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   30: invokestatic 31	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
    //   33: invokevirtual 43	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   36: astore 6
    //   38: aload_0
    //   39: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   42: invokestatic 31	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
    //   45: invokevirtual 47	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   48: astore 5
    //   50: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   53: lstore_3
    //   54: lload_3
    //   55: aload_0
    //   56: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   59: invokestatic 57	com/tencent/token/core/push/b:j	(Lcom/tencent/token/core/push/b;)J
    //   62: lsub
    //   63: aload_0
    //   64: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   67: invokestatic 61	com/tencent/token/core/push/b:k	(Lcom/tencent/token/core/push/b;)I
    //   70: i2l
    //   71: lcmp
    //   72: iflt +48 -> 120
    //   75: new 63	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   82: ldc 66
    //   84: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: lload_3
    //   88: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 82	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   101: lload_3
    //   102: invokestatic 85	com/tencent/token/core/push/b:b	(Lcom/tencent/token/core/push/b;J)J
    //   105: pop2
    //   106: aload 6
    //   108: iconst_0
    //   109: invokestatic 90	com/tencent/token/core/push/i:a	(B)[B
    //   112: invokevirtual 96	java/io/OutputStream:write	([B)V
    //   115: aload 6
    //   117: invokevirtual 99	java/io/OutputStream:flush	()V
    //   120: aload 5
    //   122: invokevirtual 105	java/io/InputStream:available	()I
    //   125: ifle +16 -> 141
    //   128: aload_0
    //   129: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   132: aload 5
    //   134: iconst_0
    //   135: invokestatic 108	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;Ljava/io/InputStream;Z)I
    //   138: ifne -121 -> 17
    //   141: aload_0
    //   142: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   145: getfield 37	com/tencent/token/core/push/b:d	[B
    //   148: ifnull -131 -> 17
    //   151: new 63	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   158: ldc 110
    //   160: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   167: getfield 37	com/tencent/token/core/push/b:d	[B
    //   170: arraylength
    //   171: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 82	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   180: new 115	com/tencent/token/core/push/m
    //   183: dup
    //   184: invokespecial 116	com/tencent/token/core/push/m:<init>	()V
    //   187: astore 5
    //   189: aload 5
    //   191: aload_0
    //   192: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   195: getfield 37	com/tencent/token/core/push/b:d	[B
    //   198: iconst_0
    //   199: invokestatic 121	com/tencent/token/dg:c	([BI)J
    //   202: putfield 124	com/tencent/token/core/push/m:a	J
    //   205: aload_0
    //   206: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   209: getfield 37	com/tencent/token/core/push/b:d	[B
    //   212: bipush 8
    //   214: invokestatic 127	com/tencent/token/dg:a	([BI)S
    //   217: istore_1
    //   218: aload 5
    //   220: iload_1
    //   221: newarray byte
    //   223: putfield 129	com/tencent/token/core/push/m:b	[B
    //   226: aload_0
    //   227: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   230: getfield 37	com/tencent/token/core/push/b:d	[B
    //   233: bipush 10
    //   235: aload 5
    //   237: getfield 129	com/tencent/token/core/push/m:b	[B
    //   240: iload_1
    //   241: invokestatic 132	com/tencent/token/dg:b	([BI[BI)V
    //   244: iload_1
    //   245: bipush 10
    //   247: iadd
    //   248: istore_1
    //   249: aload 5
    //   251: aload_0
    //   252: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   255: getfield 37	com/tencent/token/core/push/b:d	[B
    //   258: iload_1
    //   259: invokestatic 134	com/tencent/token/dg:b	([BI)J
    //   262: putfield 136	com/tencent/token/core/push/m:c	J
    //   265: iload_1
    //   266: iconst_4
    //   267: iadd
    //   268: istore_1
    //   269: aload 5
    //   271: aload_0
    //   272: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   275: getfield 37	com/tencent/token/core/push/b:d	[B
    //   278: iload_1
    //   279: baload
    //   280: putfield 139	com/tencent/token/core/push/m:d	B
    //   283: iload_1
    //   284: iconst_1
    //   285: iadd
    //   286: istore_1
    //   287: aload 5
    //   289: aload_0
    //   290: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   293: getfield 37	com/tencent/token/core/push/b:d	[B
    //   296: iload_1
    //   297: baload
    //   298: putfield 142	com/tencent/token/core/push/m:e	B
    //   301: iload_1
    //   302: iconst_1
    //   303: iadd
    //   304: istore_1
    //   305: aload 5
    //   307: aload_0
    //   308: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   311: getfield 37	com/tencent/token/core/push/b:d	[B
    //   314: iload_1
    //   315: invokestatic 134	com/tencent/token/dg:b	([BI)J
    //   318: putfield 145	com/tencent/token/core/push/m:f	J
    //   321: iload_1
    //   322: iconst_4
    //   323: iadd
    //   324: istore_2
    //   325: aload_0
    //   326: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   329: getfield 37	com/tencent/token/core/push/b:d	[B
    //   332: iload_2
    //   333: invokestatic 127	com/tencent/token/dg:a	([BI)S
    //   336: istore_1
    //   337: iload_2
    //   338: iconst_2
    //   339: iadd
    //   340: istore_2
    //   341: aload 5
    //   343: iload_1
    //   344: newarray byte
    //   346: putfield 148	com/tencent/token/core/push/m:g	[B
    //   349: aload_0
    //   350: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   353: getfield 37	com/tencent/token/core/push/b:d	[B
    //   356: iload_2
    //   357: aload 5
    //   359: getfield 148	com/tencent/token/core/push/m:g	[B
    //   362: iload_1
    //   363: invokestatic 132	com/tencent/token/dg:b	([BI[BI)V
    //   366: iload_2
    //   367: iload_1
    //   368: iadd
    //   369: istore_1
    //   370: aload_0
    //   371: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   374: getfield 37	com/tencent/token/core/push/b:d	[B
    //   377: iload_1
    //   378: invokestatic 127	com/tencent/token/dg:a	([BI)S
    //   381: istore_2
    //   382: aload 5
    //   384: iload_2
    //   385: newarray byte
    //   387: putfield 151	com/tencent/token/core/push/m:h	[B
    //   390: aload_0
    //   391: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   394: getfield 37	com/tencent/token/core/push/b:d	[B
    //   397: iload_1
    //   398: iconst_2
    //   399: iadd
    //   400: aload 5
    //   402: getfield 151	com/tencent/token/core/push/m:h	[B
    //   405: iload_2
    //   406: invokestatic 132	com/tencent/token/dg:b	([BI[BI)V
    //   409: new 63	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   416: ldc 153
    //   418: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 5
    //   423: getfield 145	com/tencent/token/core/push/m:f	J
    //   426: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   429: ldc 155
    //   431: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 5
    //   436: getfield 136	com/tencent/token/core/push/m:c	J
    //   439: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   442: ldc 157
    //   444: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: new 159	java/lang/String
    //   450: dup
    //   451: aload 5
    //   453: getfield 129	com/tencent/token/core/push/m:b	[B
    //   456: invokespecial 161	java/lang/String:<init>	([B)V
    //   459: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc 163
    //   464: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 5
    //   469: getfield 139	com/tencent/token/core/push/m:d	B
    //   472: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   475: ldc 165
    //   477: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 5
    //   482: getfield 142	com/tencent/token/core/push/m:e	B
    //   485: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: ldc 167
    //   490: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: new 159	java/lang/String
    //   496: dup
    //   497: aload 5
    //   499: getfield 148	com/tencent/token/core/push/m:g	[B
    //   502: invokespecial 161	java/lang/String:<init>	([B)V
    //   505: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc 169
    //   510: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: new 159	java/lang/String
    //   516: dup
    //   517: aload 5
    //   519: getfield 151	com/tencent/token/core/push/m:h	[B
    //   522: invokespecial 161	java/lang/String:<init>	([B)V
    //   525: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 82	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   534: iconst_0
    //   535: iconst_0
    //   536: ldc 171
    //   538: invokestatic 174	com/tencent/token/core/push/i:a	(ISLjava/lang/String;)[B
    //   541: astore 7
    //   543: aload 6
    //   545: aload 7
    //   547: invokevirtual 96	java/io/OutputStream:write	([B)V
    //   550: aload 6
    //   552: invokevirtual 99	java/io/OutputStream:flush	()V
    //   555: aload_0
    //   556: getfield 16	com/tencent/token/core/push/g:a	Landroid/os/Handler;
    //   559: ifnull -542 -> 17
    //   562: new 176	android/os/Message
    //   565: dup
    //   566: invokespecial 177	android/os/Message:<init>	()V
    //   569: astore 6
    //   571: aload 6
    //   573: sipush 4014
    //   576: putfield 181	android/os/Message:what	I
    //   579: aload 6
    //   581: aload 5
    //   583: putfield 185	android/os/Message:obj	Ljava/lang/Object;
    //   586: aload_0
    //   587: getfield 16	com/tencent/token/core/push/g:a	Landroid/os/Handler;
    //   590: aload 6
    //   592: invokevirtual 191	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   595: pop
    //   596: return
    //   597: astore 5
    //   599: aload 5
    //   601: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   604: new 63	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   611: ldc 196
    //   613: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 5
    //   618: invokevirtual 197	java/io/IOException:toString	()Ljava/lang/String;
    //   621: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 199	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   630: aload_0
    //   631: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   634: invokevirtual 34	com/tencent/token/core/push/b:d	()V
    //   637: return
    //   638: astore 6
    //   640: aload 6
    //   642: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   645: goto -90 -> 555
    //   648: astore 5
    //   650: aload 5
    //   652: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   655: new 63	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   662: ldc 202
    //   664: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 5
    //   669: invokevirtual 203	java/lang/Exception:toString	()Ljava/lang/String;
    //   672: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 199	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   681: aload_0
    //   682: getfield 14	com/tencent/token/core/push/g:b	Lcom/tencent/token/core/push/b;
    //   685: invokevirtual 34	com/tencent/token/core/push/b:d	()V
    //   688: return
    //   689: astore 6
    //   691: aload 6
    //   693: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   696: goto -141 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	g
    //   217	183	1	i	int
    //   324	82	2	j	int
    //   53	49	3	l	long
    //   48	534	5	localObject1	Object
    //   597	20	5	localIOException1	java.io.IOException
    //   648	20	5	localException1	java.lang.Exception
    //   36	555	6	localObject2	Object
    //   638	3	6	localIOException2	java.io.IOException
    //   689	3	6	localException2	java.lang.Exception
    //   541	5	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	120	597	java/io/IOException
    //   120	141	597	java/io/IOException
    //   141	244	597	java/io/IOException
    //   249	265	597	java/io/IOException
    //   269	283	597	java/io/IOException
    //   287	301	597	java/io/IOException
    //   305	321	597	java/io/IOException
    //   325	337	597	java/io/IOException
    //   341	366	597	java/io/IOException
    //   370	543	597	java/io/IOException
    //   555	596	597	java/io/IOException
    //   640	645	597	java/io/IOException
    //   691	696	597	java/io/IOException
    //   543	555	638	java/io/IOException
    //   26	120	648	java/lang/Exception
    //   120	141	648	java/lang/Exception
    //   141	244	648	java/lang/Exception
    //   249	265	648	java/lang/Exception
    //   269	283	648	java/lang/Exception
    //   287	301	648	java/lang/Exception
    //   305	321	648	java/lang/Exception
    //   325	337	648	java/lang/Exception
    //   341	366	648	java/lang/Exception
    //   370	543	648	java/lang/Exception
    //   555	596	648	java/lang/Exception
    //   640	645	648	java/lang/Exception
    //   691	696	648	java/lang/Exception
    //   543	555	689	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.g
 * JD-Core Version:    0.7.0.1
 */