package cooperation.qlink;

import java.io.InputStream;

class QlinkShareJumpActivity$5
  implements Runnable
{
  QlinkShareJumpActivity$5(QlinkShareJumpActivity paramQlinkShareJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   4: ldc 34
    //   6: invokestatic 40	acfp:m	(I)Ljava/lang/String;
    //   9: invokestatic 46	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aconst_null
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 12
    //   25: aconst_null
    //   26: astore 13
    //   28: new 48	java/io/File
    //   31: dup
    //   32: aload_0
    //   33: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:val$path	Ljava/lang/String;
    //   36: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 14
    //   41: aload 14
    //   43: invokevirtual 55	java/io/File:exists	()Z
    //   46: ifne +81 -> 127
    //   49: aload 14
    //   51: invokevirtual 58	java/io/File:createNewFile	()Z
    //   54: ifne +73 -> 127
    //   57: aload_0
    //   58: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   61: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   64: iconst_1
    //   65: invokevirtual 68	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   68: pop
    //   69: iconst_0
    //   70: ifeq +10 -> 80
    //   73: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   76: aconst_null
    //   77: invokevirtual 78	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   80: aload_0
    //   81: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   84: iconst_0
    //   85: invokestatic 81	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:b	Ljava/io/InputStream;
    //   93: invokevirtual 86	java/io/InputStream:close	()V
    //   96: iconst_0
    //   97: ifeq +11 -> 108
    //   100: new 88	java/lang/NullPointerException
    //   103: dup
    //   104: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   107: athrow
    //   108: return
    //   109: astore 8
    //   111: aload 8
    //   113: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   116: goto -20 -> 96
    //   119: astore 8
    //   121: aload 8
    //   123: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   126: return
    //   127: new 94	java/io/FileOutputStream
    //   130: dup
    //   131: aload_0
    //   132: getfield 20	cooperation/qlink/QlinkShareJumpActivity$5:val$path	Ljava/lang/String;
    //   135: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   138: astore 11
    //   140: aload 13
    //   142: astore 8
    //   144: aload 12
    //   146: astore 9
    //   148: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   151: sipush 8192
    //   154: invokevirtual 99	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   157: astore 10
    //   159: lconst_0
    //   160: lstore 6
    //   162: lconst_0
    //   163: lstore_2
    //   164: aload 10
    //   166: astore 8
    //   168: aload 10
    //   170: astore 9
    //   172: aload_0
    //   173: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:b	Ljava/io/InputStream;
    //   176: aload 10
    //   178: invokevirtual 103	java/io/InputStream:read	([B)I
    //   181: istore_1
    //   182: iload_1
    //   183: iconst_m1
    //   184: if_icmpeq +129 -> 313
    //   187: aload 10
    //   189: astore 8
    //   191: aload 10
    //   193: astore 9
    //   195: aload_0
    //   196: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   199: invokestatic 106	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   202: ifeq +111 -> 313
    //   205: lload_2
    //   206: iload_1
    //   207: i2l
    //   208: ladd
    //   209: lstore 4
    //   211: aload 10
    //   213: astore 8
    //   215: aload 10
    //   217: astore 9
    //   219: aload 11
    //   221: aload 10
    //   223: iconst_0
    //   224: iload_1
    //   225: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   228: lload 4
    //   230: lstore_2
    //   231: aload 10
    //   233: astore 8
    //   235: aload 10
    //   237: astore 9
    //   239: lload 4
    //   241: lload 6
    //   243: lsub
    //   244: l2d
    //   245: aload_0
    //   246: getfield 24	cooperation/qlink/QlinkShareJumpActivity$5:val$fileSize	J
    //   249: l2d
    //   250: ddiv
    //   251: ldc2_w 111
    //   254: dcmpl
    //   255: ifle -91 -> 164
    //   258: aload 10
    //   260: astore 8
    //   262: aload 10
    //   264: astore 9
    //   266: aload_0
    //   267: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   270: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   273: aload_0
    //   274: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   277: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   280: iconst_3
    //   281: lload 4
    //   283: l2d
    //   284: aload_0
    //   285: getfield 24	cooperation/qlink/QlinkShareJumpActivity$5:val$fileSize	J
    //   288: l2d
    //   289: ddiv
    //   290: ldc2_w 113
    //   293: dmul
    //   294: d2i
    //   295: iconst_0
    //   296: invokevirtual 118	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   299: invokevirtual 122	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   302: pop
    //   303: lload 4
    //   305: lstore 6
    //   307: lload 4
    //   309: lstore_2
    //   310: goto -146 -> 164
    //   313: lload_2
    //   314: lconst_0
    //   315: lcmp
    //   316: ifne +23 -> 339
    //   319: aload 10
    //   321: astore 8
    //   323: aload 10
    //   325: astore 9
    //   327: aload_0
    //   328: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   331: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   334: iconst_1
    //   335: invokevirtual 68	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   338: pop
    //   339: aload 10
    //   341: astore 8
    //   343: aload 10
    //   345: astore 9
    //   347: aload_0
    //   348: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   351: invokestatic 106	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;)Z
    //   354: ifeq +107 -> 461
    //   357: aload 10
    //   359: astore 8
    //   361: aload 10
    //   363: astore 9
    //   365: aload_0
    //   366: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   369: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   372: aload_0
    //   373: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   376: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   379: iconst_3
    //   380: bipush 100
    //   382: iconst_0
    //   383: invokevirtual 118	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   386: invokevirtual 122	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   389: pop
    //   390: aload 10
    //   392: astore 8
    //   394: aload 10
    //   396: astore 9
    //   398: aload_0
    //   399: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   402: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   405: iconst_2
    //   406: ldc2_w 123
    //   409: invokevirtual 128	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   412: pop
    //   413: aload 10
    //   415: ifnull +11 -> 426
    //   418: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   421: aload 10
    //   423: invokevirtual 78	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   426: aload_0
    //   427: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   430: iconst_0
    //   431: invokestatic 81	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   434: pop
    //   435: aload_0
    //   436: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:b	Ljava/io/InputStream;
    //   439: invokevirtual 86	java/io/InputStream:close	()V
    //   442: aload 11
    //   444: ifnull -336 -> 108
    //   447: aload 11
    //   449: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   452: return
    //   453: astore 8
    //   455: aload 8
    //   457: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   460: return
    //   461: aload 10
    //   463: astore 8
    //   465: aload 10
    //   467: astore 9
    //   469: aload 11
    //   471: invokestatic 135	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   474: aload 10
    //   476: astore 8
    //   478: aload 10
    //   480: astore 9
    //   482: aload 14
    //   484: invokevirtual 138	java/io/File:delete	()Z
    //   487: pop
    //   488: goto -75 -> 413
    //   491: astore 12
    //   493: aload 11
    //   495: astore 10
    //   497: aload 8
    //   499: astore 9
    //   501: aload 12
    //   503: astore 8
    //   505: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +13 -> 521
    //   511: ldc 145
    //   513: iconst_2
    //   514: ldc 147
    //   516: aload 8
    //   518: invokestatic 151	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   521: aload_0
    //   522: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   525: getfield 62	cooperation/qlink/QlinkShareJumpActivity:uiHandler	Lmqq/os/MqqHandler;
    //   528: iconst_1
    //   529: invokevirtual 68	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   532: pop
    //   533: aload 9
    //   535: ifnull +11 -> 546
    //   538: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   541: aload 9
    //   543: invokevirtual 78	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   546: aload_0
    //   547: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   550: iconst_0
    //   551: invokestatic 81	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   554: pop
    //   555: aload_0
    //   556: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:b	Ljava/io/InputStream;
    //   559: invokevirtual 86	java/io/InputStream:close	()V
    //   562: aload 10
    //   564: ifnull -456 -> 108
    //   567: aload 10
    //   569: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   572: return
    //   573: astore 8
    //   575: aload 8
    //   577: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   580: return
    //   581: astore 8
    //   583: aload 8
    //   585: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   588: goto -146 -> 442
    //   591: astore 8
    //   593: aload 8
    //   595: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   598: goto -36 -> 562
    //   601: astore 11
    //   603: aconst_null
    //   604: astore 9
    //   606: aload 8
    //   608: astore 10
    //   610: aload 11
    //   612: astore 8
    //   614: aload 10
    //   616: ifnull +11 -> 627
    //   619: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   622: aload 10
    //   624: invokevirtual 78	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   627: aload_0
    //   628: getfield 18	cooperation/qlink/QlinkShareJumpActivity$5:this$0	Lcooperation/qlink/QlinkShareJumpActivity;
    //   631: iconst_0
    //   632: invokestatic 81	cooperation/qlink/QlinkShareJumpActivity:a	(Lcooperation/qlink/QlinkShareJumpActivity;Z)Z
    //   635: pop
    //   636: aload_0
    //   637: getfield 22	cooperation/qlink/QlinkShareJumpActivity$5:b	Ljava/io/InputStream;
    //   640: invokevirtual 86	java/io/InputStream:close	()V
    //   643: aload 9
    //   645: ifnull +8 -> 653
    //   648: aload 9
    //   650: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   653: aload 8
    //   655: athrow
    //   656: astore 10
    //   658: aload 10
    //   660: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   663: goto -20 -> 643
    //   666: astore 9
    //   668: aload 9
    //   670: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   673: goto -20 -> 653
    //   676: astore 8
    //   678: aload 9
    //   680: astore 10
    //   682: aload 11
    //   684: astore 9
    //   686: goto -72 -> 614
    //   689: astore 8
    //   691: aload 10
    //   693: astore 11
    //   695: aload 9
    //   697: astore 10
    //   699: aload 11
    //   701: astore 9
    //   703: goto -89 -> 614
    //   706: astore 8
    //   708: goto -203 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	this	5
    //   181	44	1	i	int
    //   163	151	2	l1	long
    //   209	99	4	l2	long
    //   160	146	6	l3	long
    //   20	1	8	localObject1	Object
    //   109	3	8	localIOException1	java.io.IOException
    //   119	3	8	localIOException2	java.io.IOException
    //   142	251	8	localObject2	Object
    //   453	3	8	localIOException3	java.io.IOException
    //   463	54	8	localObject3	Object
    //   573	3	8	localIOException4	java.io.IOException
    //   581	3	8	localIOException5	java.io.IOException
    //   591	16	8	localIOException6	java.io.IOException
    //   612	42	8	localObject4	Object
    //   676	1	8	localObject5	Object
    //   689	1	8	localObject6	Object
    //   706	1	8	localException1	java.lang.Exception
    //   17	632	9	localObject7	Object
    //   666	13	9	localIOException7	java.io.IOException
    //   684	18	9	localObject8	Object
    //   14	609	10	localObject9	Object
    //   656	3	10	localIOException8	java.io.IOException
    //   680	18	10	localObject10	Object
    //   138	356	11	localFileOutputStream	java.io.FileOutputStream
    //   601	82	11	localObject11	Object
    //   693	7	11	localObject12	Object
    //   23	122	12	localObject13	Object
    //   491	11	12	localException2	java.lang.Exception
    //   26	115	13	localObject14	Object
    //   39	444	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   89	96	109	java/io/IOException
    //   100	108	119	java/io/IOException
    //   447	452	453	java/io/IOException
    //   148	159	491	java/lang/Exception
    //   172	182	491	java/lang/Exception
    //   195	205	491	java/lang/Exception
    //   219	228	491	java/lang/Exception
    //   239	258	491	java/lang/Exception
    //   266	303	491	java/lang/Exception
    //   327	339	491	java/lang/Exception
    //   347	357	491	java/lang/Exception
    //   365	390	491	java/lang/Exception
    //   398	413	491	java/lang/Exception
    //   469	474	491	java/lang/Exception
    //   482	488	491	java/lang/Exception
    //   567	572	573	java/io/IOException
    //   435	442	581	java/io/IOException
    //   555	562	591	java/io/IOException
    //   28	69	601	finally
    //   127	140	601	finally
    //   636	643	656	java/io/IOException
    //   648	653	666	java/io/IOException
    //   148	159	676	finally
    //   172	182	676	finally
    //   195	205	676	finally
    //   219	228	676	finally
    //   239	258	676	finally
    //   266	303	676	finally
    //   327	339	676	finally
    //   347	357	676	finally
    //   365	390	676	finally
    //   398	413	676	finally
    //   469	474	676	finally
    //   482	488	676	finally
    //   505	521	689	finally
    //   521	533	689	finally
    //   28	69	706	java/lang/Exception
    //   127	140	706	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity.5
 * JD-Core Version:    0.7.0.1
 */