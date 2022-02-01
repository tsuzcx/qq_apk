package cooperation.qqfav.widget;

import java.io.InputStream;

class QfavJumpActivity$3
  implements Runnable
{
  QfavJumpActivity$3(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 8
    //   15: new 35	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:val$path	Ljava/lang/String;
    //   23: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 42	java/io/File:exists	()Z
    //   33: ifne +81 -> 114
    //   36: aload 14
    //   38: invokevirtual 45	java/io/File:createNewFile	()Z
    //   41: ifne +73 -> 114
    //   44: aload_0
    //   45: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   48: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 57	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   71: iconst_0
    //   72: invokestatic 71	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:b	Ljava/io/InputStream;
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
    //   119: getfield 20	cooperation/qqfav/widget/QfavJumpActivity$3:val$path	Ljava/lang/String;
    //   122: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   125: astore 11
    //   127: aload 13
    //   129: astore 9
    //   131: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: sipush 8192
    //   137: invokevirtual 89	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   140: astore 10
    //   142: lconst_0
    //   143: lstore 6
    //   145: lconst_0
    //   146: lstore_2
    //   147: aload 10
    //   149: astore 8
    //   151: aload 10
    //   153: astore 9
    //   155: aload_0
    //   156: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:b	Ljava/io/InputStream;
    //   159: aload 10
    //   161: invokevirtual 93	java/io/InputStream:read	([B)I
    //   164: istore_1
    //   165: iload_1
    //   166: iconst_m1
    //   167: if_icmpeq +129 -> 296
    //   170: aload 10
    //   172: astore 8
    //   174: aload 10
    //   176: astore 9
    //   178: aload_0
    //   179: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   182: invokestatic 96	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   185: ifeq +111 -> 296
    //   188: lload_2
    //   189: iload_1
    //   190: i2l
    //   191: ladd
    //   192: lstore 4
    //   194: aload 10
    //   196: astore 8
    //   198: aload 10
    //   200: astore 9
    //   202: aload 11
    //   204: aload 10
    //   206: iconst_0
    //   207: iload_1
    //   208: invokevirtual 100	java/io/FileOutputStream:write	([BII)V
    //   211: lload 4
    //   213: lstore_2
    //   214: aload 10
    //   216: astore 8
    //   218: aload 10
    //   220: astore 9
    //   222: lload 4
    //   224: lload 6
    //   226: lsub
    //   227: l2d
    //   228: aload_0
    //   229: getfield 24	cooperation/qqfav/widget/QfavJumpActivity$3:val$fileSize	J
    //   232: l2d
    //   233: ddiv
    //   234: ldc2_w 101
    //   237: dcmpl
    //   238: ifle -91 -> 147
    //   241: aload 10
    //   243: astore 8
    //   245: aload 10
    //   247: astore 9
    //   249: aload_0
    //   250: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   253: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   256: aload_0
    //   257: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   260: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   263: iconst_3
    //   264: lload 4
    //   266: l2d
    //   267: aload_0
    //   268: getfield 24	cooperation/qqfav/widget/QfavJumpActivity$3:val$fileSize	J
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
    //   302: aload 10
    //   304: astore 8
    //   306: aload 10
    //   308: astore 9
    //   310: aload_0
    //   311: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   314: ldc 113
    //   316: invokevirtual 117	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   319: putstatic 120	cooperation/qqfav/widget/QfavJumpActivity:msg	Ljava/lang/String;
    //   322: aload 10
    //   324: astore 8
    //   326: aload 10
    //   328: astore 9
    //   330: aload_0
    //   331: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   334: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   337: iconst_1
    //   338: invokevirtual 57	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   341: pop
    //   342: aload 10
    //   344: astore 8
    //   346: aload 10
    //   348: astore 9
    //   350: aload_0
    //   351: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   354: invokestatic 96	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   357: ifeq +107 -> 464
    //   360: aload 10
    //   362: astore 8
    //   364: aload 10
    //   366: astore 9
    //   368: aload_0
    //   369: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   372: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   375: aload_0
    //   376: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   379: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   382: iconst_3
    //   383: bipush 100
    //   385: iconst_0
    //   386: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   389: invokevirtual 112	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   392: pop
    //   393: aload 10
    //   395: astore 8
    //   397: aload 10
    //   399: astore 9
    //   401: aload_0
    //   402: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   405: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   408: iconst_2
    //   409: ldc2_w 121
    //   412: invokevirtual 126	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   415: pop
    //   416: aload 10
    //   418: ifnull +11 -> 429
    //   421: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   424: aload 10
    //   426: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   429: aload_0
    //   430: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   433: iconst_0
    //   434: invokestatic 71	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   437: pop
    //   438: aload_0
    //   439: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:b	Ljava/io/InputStream;
    //   442: invokevirtual 76	java/io/InputStream:close	()V
    //   445: aload 11
    //   447: ifnull -352 -> 95
    //   450: aload 11
    //   452: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   455: return
    //   456: astore 8
    //   458: aload 8
    //   460: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   463: return
    //   464: aload 10
    //   466: astore 8
    //   468: aload 10
    //   470: astore 9
    //   472: aload 11
    //   474: invokestatic 133	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   477: aload 10
    //   479: astore 8
    //   481: aload 10
    //   483: astore 9
    //   485: aload 14
    //   487: invokevirtual 136	java/io/File:delete	()Z
    //   490: pop
    //   491: goto -75 -> 416
    //   494: astore 12
    //   496: aload 11
    //   498: astore 10
    //   500: aload 8
    //   502: astore 9
    //   504: aload 12
    //   506: astore 8
    //   508: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +13 -> 524
    //   514: ldc 143
    //   516: iconst_2
    //   517: ldc 145
    //   519: aload 8
    //   521: invokestatic 149	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   524: aload_0
    //   525: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   528: getfield 51	cooperation/qqfav/widget/QfavJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   531: iconst_1
    //   532: invokevirtual 57	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   535: pop
    //   536: aload 9
    //   538: ifnull +11 -> 549
    //   541: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   544: aload 9
    //   546: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   549: aload_0
    //   550: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   553: iconst_0
    //   554: invokestatic 71	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   557: pop
    //   558: aload_0
    //   559: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:b	Ljava/io/InputStream;
    //   562: invokevirtual 76	java/io/InputStream:close	()V
    //   565: aload 10
    //   567: ifnull -472 -> 95
    //   570: aload 10
    //   572: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   575: return
    //   576: astore 8
    //   578: aload 8
    //   580: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   583: return
    //   584: astore 8
    //   586: aload 8
    //   588: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   591: goto -146 -> 445
    //   594: astore 8
    //   596: aload 8
    //   598: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   601: goto -36 -> 565
    //   604: astore 8
    //   606: aconst_null
    //   607: astore 9
    //   609: aload 10
    //   611: ifnull +11 -> 622
    //   614: invokestatic 63	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   617: aload 10
    //   619: invokevirtual 67	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   622: aload_0
    //   623: getfield 18	cooperation/qqfav/widget/QfavJumpActivity$3:this$0	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   626: iconst_0
    //   627: invokestatic 71	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   630: pop
    //   631: aload_0
    //   632: getfield 22	cooperation/qqfav/widget/QfavJumpActivity$3:b	Ljava/io/InputStream;
    //   635: invokevirtual 76	java/io/InputStream:close	()V
    //   638: aload 9
    //   640: ifnull +8 -> 648
    //   643: aload 9
    //   645: invokevirtual 127	java/io/FileOutputStream:close	()V
    //   648: aload 8
    //   650: athrow
    //   651: astore 10
    //   653: aload 10
    //   655: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   658: goto -20 -> 638
    //   661: astore 9
    //   663: aload 9
    //   665: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   668: goto -20 -> 648
    //   671: astore 8
    //   673: aload 9
    //   675: astore 10
    //   677: aload 11
    //   679: astore 9
    //   681: goto -72 -> 609
    //   684: astore 8
    //   686: aload 10
    //   688: astore 11
    //   690: aload 9
    //   692: astore 10
    //   694: aload 11
    //   696: astore 9
    //   698: goto -89 -> 609
    //   701: astore 8
    //   703: aload 12
    //   705: astore 10
    //   707: goto -199 -> 508
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	this	3
    //   164	44	1	i	int
    //   146	151	2	l1	long
    //   192	99	4	l2	long
    //   143	146	6	l3	long
    //   13	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   149	247	8	localObject2	Object
    //   456	3	8	localIOException3	java.io.IOException
    //   466	54	8	localObject3	Object
    //   576	3	8	localIOException4	java.io.IOException
    //   584	3	8	localIOException5	java.io.IOException
    //   594	3	8	localIOException6	java.io.IOException
    //   604	45	8	localObject4	Object
    //   671	1	8	localObject5	Object
    //   684	1	8	localObject6	Object
    //   701	1	8	localException1	java.lang.Exception
    //   4	640	9	localObject7	Object
    //   661	13	9	localIOException7	java.io.IOException
    //   679	18	9	localObject8	Object
    //   7	611	10	localObject9	Object
    //   651	3	10	localIOException8	java.io.IOException
    //   675	31	10	localObject10	Object
    //   125	570	11	localObject11	Object
    //   1	1	12	localObject12	Object
    //   494	210	12	localException2	java.lang.Exception
    //   10	118	13	localObject13	Object
    //   26	460	14	localFile	java.io.File
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
    //   570	575	576	java/io/IOException
    //   438	445	584	java/io/IOException
    //   558	565	594	java/io/IOException
    //   15	56	604	finally
    //   114	127	604	finally
    //   631	638	651	java/io/IOException
    //   643	648	661	java/io/IOException
    //   131	142	671	finally
    //   155	165	671	finally
    //   178	188	671	finally
    //   202	211	671	finally
    //   222	241	671	finally
    //   249	286	671	finally
    //   310	322	671	finally
    //   330	342	671	finally
    //   350	360	671	finally
    //   368	393	671	finally
    //   401	416	671	finally
    //   472	477	671	finally
    //   485	491	671	finally
    //   508	524	684	finally
    //   524	536	684	finally
    //   15	56	701	java/lang/Exception
    //   114	127	701	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */