package com.dataline.activities;

import java.io.InputStream;

class LiteActivity$46
  implements Runnable
{
  LiteActivity$46(LiteActivity paramLiteActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 8
    //   15: new 35	com/tencent/mm/vfs/VFSFile
    //   18: dup
    //   19: aload_0
    //   20: getfield 20	com/dataline/activities/LiteActivity$46:val$path	Ljava/lang/String;
    //   23: invokespecial 38	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 42	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   33: ifne +81 -> 114
    //   36: aload 14
    //   38: invokevirtual 45	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   41: ifne +73 -> 114
    //   44: aload_0
    //   45: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   48: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 57	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   71: iconst_0
    //   72: invokestatic 71	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 22	com/dataline/activities/LiteActivity$46:b	Ljava/io/InputStream;
    //   80: invokevirtual 76	java/io/InputStream:close	()V
    //   83: iconst_0
    //   84: ifeq +11 -> 95
    //   87: new 78	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 79	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: return
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   103: goto -20 -> 83
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: new 84	java/io/FileOutputStream
    //   117: dup
    //   118: aload_0
    //   119: getfield 20	com/dataline/activities/LiteActivity$46:val$path	Ljava/lang/String;
    //   122: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   125: astore 10
    //   127: aload 13
    //   129: astore 9
    //   131: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: sipush 8192
    //   137: invokevirtual 89	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   140: astore 11
    //   142: lconst_0
    //   143: lstore 6
    //   145: lconst_0
    //   146: lstore_2
    //   147: aload 11
    //   149: astore 8
    //   151: aload 11
    //   153: astore 9
    //   155: aload_0
    //   156: getfield 22	com/dataline/activities/LiteActivity$46:b	Ljava/io/InputStream;
    //   159: aload 11
    //   161: invokevirtual 93	java/io/InputStream:read	([B)I
    //   164: istore_1
    //   165: iload_1
    //   166: iconst_m1
    //   167: if_icmpeq +129 -> 296
    //   170: aload 11
    //   172: astore 8
    //   174: aload 11
    //   176: astore 9
    //   178: aload_0
    //   179: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   182: invokestatic 96	com/dataline/activities/LiteActivity:b	(Lcom/dataline/activities/LiteActivity;)Z
    //   185: ifeq +111 -> 296
    //   188: lload_2
    //   189: iload_1
    //   190: i2l
    //   191: ladd
    //   192: lstore 4
    //   194: aload 11
    //   196: astore 8
    //   198: aload 11
    //   200: astore 9
    //   202: aload 10
    //   204: aload 11
    //   206: iconst_0
    //   207: iload_1
    //   208: invokevirtual 100	java/io/FileOutputStream:write	([BII)V
    //   211: lload 4
    //   213: lstore_2
    //   214: aload 11
    //   216: astore 8
    //   218: aload 11
    //   220: astore 9
    //   222: lload 4
    //   224: lload 6
    //   226: lsub
    //   227: l2d
    //   228: aload_0
    //   229: getfield 24	com/dataline/activities/LiteActivity$46:val$fileSize	J
    //   232: l2d
    //   233: ddiv
    //   234: ldc2_w 101
    //   237: dcmpl
    //   238: ifle -91 -> 147
    //   241: aload 11
    //   243: astore 8
    //   245: aload 11
    //   247: astore 9
    //   249: aload_0
    //   250: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   253: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   256: aload_0
    //   257: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   260: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   263: iconst_3
    //   264: lload 4
    //   266: l2d
    //   267: aload_0
    //   268: getfield 24	com/dataline/activities/LiteActivity$46:val$fileSize	J
    //   271: l2d
    //   272: ddiv
    //   273: ldc2_w 103
    //   276: dmul
    //   277: d2i
    //   278: iconst_0
    //   279: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   282: invokevirtual 112	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   285: pop
    //   286: lload 4
    //   288: lstore 6
    //   290: lload 4
    //   292: lstore_2
    //   293: goto -146 -> 147
    //   296: lload_2
    //   297: lconst_0
    //   298: lcmp
    //   299: ifne +43 -> 342
    //   302: aload 11
    //   304: astore 8
    //   306: aload 11
    //   308: astore 9
    //   310: aload_0
    //   311: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   314: ldc 113
    //   316: invokevirtual 117	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   319: putstatic 120	com/dataline/activities/LiteActivity:msg	Ljava/lang/String;
    //   322: aload 11
    //   324: astore 8
    //   326: aload 11
    //   328: astore 9
    //   330: aload_0
    //   331: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   334: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   337: iconst_1
    //   338: invokevirtual 57	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   341: pop
    //   342: aload 11
    //   344: astore 8
    //   346: aload 11
    //   348: astore 9
    //   350: aload_0
    //   351: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   354: invokestatic 96	com/dataline/activities/LiteActivity:b	(Lcom/dataline/activities/LiteActivity;)Z
    //   357: ifeq +107 -> 464
    //   360: aload 11
    //   362: astore 8
    //   364: aload 11
    //   366: astore 9
    //   368: aload_0
    //   369: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   372: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   375: aload_0
    //   376: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   379: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   382: iconst_3
    //   383: bipush 100
    //   385: iconst_0
    //   386: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   389: invokevirtual 112	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   392: pop
    //   393: aload 11
    //   395: astore 8
    //   397: aload 11
    //   399: astore 9
    //   401: aload_0
    //   402: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   405: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   408: iconst_2
    //   409: ldc2_w 121
    //   412: invokevirtual 126	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   415: pop
    //   416: aload 11
    //   418: ifnull +11 -> 429
    //   421: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   424: aload 11
    //   426: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   429: aload_0
    //   430: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   433: iconst_0
    //   434: invokestatic 71	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 22	com/dataline/activities/LiteActivity$46:b	Ljava/io/InputStream;
    //   442: invokevirtual 76	java/io/InputStream:close	()V
    //   445: aload 10
    //   447: ifnull -352 -> 95
    //   450: aload 10
    //   452: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   455: return
    //   456: astore 8
    //   458: aload 8
    //   460: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   463: return
    //   464: aload 11
    //   466: astore 8
    //   468: aload 11
    //   470: astore 9
    //   472: aload 10
    //   474: invokestatic 133	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   477: aload 11
    //   479: astore 8
    //   481: aload 11
    //   483: astore 9
    //   485: aload 14
    //   487: invokevirtual 136	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   490: pop
    //   491: goto -75 -> 416
    //   494: astore 11
    //   496: aload 8
    //   498: astore 9
    //   500: aload 11
    //   502: astore 8
    //   504: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +14 -> 521
    //   510: getstatic 144	com/dataline/activities/LiteActivity:TAG	Ljava/lang/String;
    //   513: iconst_2
    //   514: ldc 146
    //   516: aload 8
    //   518: invokestatic 150	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: aload_0
    //   522: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   525: getfield 51	com/dataline/activities/LiteActivity:uiHandler	Lmqq/os/MqqHandler;
    //   528: iconst_1
    //   529: invokevirtual 57	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   532: pop
    //   533: aload 9
    //   535: ifnull +11 -> 546
    //   538: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   541: aload 9
    //   543: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   546: aload_0
    //   547: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   550: iconst_0
    //   551: invokestatic 71	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   554: pop
    //   555: aload_0
    //   556: getfield 22	com/dataline/activities/LiteActivity$46:b	Ljava/io/InputStream;
    //   559: invokevirtual 76	java/io/InputStream:close	()V
    //   562: aload 10
    //   564: ifnull -469 -> 95
    //   567: aload 10
    //   569: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   572: return
    //   573: astore 8
    //   575: aload 8
    //   577: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   580: return
    //   581: astore 8
    //   583: aload 8
    //   585: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   588: goto -143 -> 445
    //   591: astore 8
    //   593: aload 8
    //   595: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   598: goto -36 -> 562
    //   601: astore 8
    //   603: aconst_null
    //   604: astore 10
    //   606: aload 9
    //   608: ifnull +11 -> 619
    //   611: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   614: aload 9
    //   616: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   619: aload_0
    //   620: getfield 18	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   623: iconst_0
    //   624: invokestatic 71	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   627: pop
    //   628: aload_0
    //   629: getfield 22	com/dataline/activities/LiteActivity$46:b	Ljava/io/InputStream;
    //   632: invokevirtual 76	java/io/InputStream:close	()V
    //   635: aload 10
    //   637: ifnull +8 -> 645
    //   640: aload 10
    //   642: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   645: aload 8
    //   647: athrow
    //   648: astore 9
    //   650: aload 9
    //   652: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   655: goto -20 -> 635
    //   658: astore 9
    //   660: aload 9
    //   662: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   665: goto -20 -> 645
    //   668: astore 8
    //   670: goto -64 -> 606
    //   673: astore 8
    //   675: goto -69 -> 606
    //   678: astore 8
    //   680: aload 12
    //   682: astore 9
    //   684: aload 11
    //   686: astore 10
    //   688: goto -184 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	this	46
    //   164	44	1	i	int
    //   146	151	2	l1	long
    //   192	99	4	l2	long
    //   143	146	6	l3	long
    //   13	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   149	247	8	arrayOfByte1	byte[]
    //   456	3	8	localIOException3	java.io.IOException
    //   466	51	8	localObject2	Object
    //   573	3	8	localIOException4	java.io.IOException
    //   581	3	8	localIOException5	java.io.IOException
    //   591	3	8	localIOException6	java.io.IOException
    //   601	45	8	localObject3	Object
    //   668	1	8	localObject4	Object
    //   673	1	8	localObject5	Object
    //   678	1	8	localException1	java.lang.Exception
    //   7	608	9	localObject6	Object
    //   648	3	9	localIOException7	java.io.IOException
    //   658	3	9	localIOException8	java.io.IOException
    //   682	1	9	localObject7	Object
    //   125	562	10	localObject8	Object
    //   1	481	11	arrayOfByte2	byte[]
    //   494	191	11	localException2	java.lang.Exception
    //   4	677	12	localObject9	Object
    //   10	118	13	localObject10	Object
    //   26	460	14	localVFSFile	com.tencent.mm.vfs.VFSFile
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   450	455	456	java/io/IOException
    //   131	142	494	java/lang/Exception
    //   155	165	494	java/lang/Exception
    //   178	188	494	java/lang/Exception
    //   202	211	494	java/lang/Exception
    //   222	241	494	java/lang/Exception
    //   249	286	494	java/lang/Exception
    //   310	322	494	java/lang/Exception
    //   330	342	494	java/lang/Exception
    //   350	360	494	java/lang/Exception
    //   368	393	494	java/lang/Exception
    //   401	416	494	java/lang/Exception
    //   472	477	494	java/lang/Exception
    //   485	491	494	java/lang/Exception
    //   567	572	573	java/io/IOException
    //   438	445	581	java/io/IOException
    //   555	562	591	java/io/IOException
    //   15	56	601	finally
    //   114	127	601	finally
    //   628	635	648	java/io/IOException
    //   640	645	658	java/io/IOException
    //   131	142	668	finally
    //   155	165	668	finally
    //   178	188	668	finally
    //   202	211	668	finally
    //   222	241	668	finally
    //   249	286	668	finally
    //   310	322	668	finally
    //   330	342	668	finally
    //   350	360	668	finally
    //   368	393	668	finally
    //   401	416	668	finally
    //   472	477	668	finally
    //   485	491	668	finally
    //   504	521	673	finally
    //   521	533	673	finally
    //   15	56	678	java/lang/Exception
    //   114	127	678	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.46
 * JD-Core Version:    0.7.0.1
 */