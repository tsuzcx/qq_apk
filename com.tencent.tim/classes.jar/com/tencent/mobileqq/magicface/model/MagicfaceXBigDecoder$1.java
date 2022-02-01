package com.tencent.mobileqq.magicface.model;

import aiyg;

public class MagicfaceXBigDecoder$1
  implements Runnable
{
  public MagicfaceXBigDecoder$1(aiyg paramaiyg) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: lconst_0
    //   3: lstore 5
    //   5: aload_0
    //   6: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   9: getfield 27	aiyg:cmH	Z
    //   12: ifeq +573 -> 585
    //   15: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   18: lstore_3
    //   19: aload_0
    //   20: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   23: aload_0
    //   24: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   27: getfield 37	aiyg:eG	[B
    //   30: aload_0
    //   31: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   34: getfield 41	aiyg:bqG	I
    //   37: invokevirtual 45	aiyg:h	([BI)I
    //   40: istore_2
    //   41: aload_0
    //   42: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   45: iload_2
    //   46: aload_0
    //   47: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   50: getfield 41	aiyg:bqG	I
    //   53: isub
    //   54: putfield 48	aiyg:dgJ	I
    //   57: aload_0
    //   58: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   61: getfield 48	aiyg:dgJ	I
    //   64: ifgt +4 -> 68
    //   67: return
    //   68: aload_0
    //   69: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   72: aload_0
    //   73: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   76: getfield 48	aiyg:dgJ	I
    //   79: aload_0
    //   80: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   83: getfield 41	aiyg:bqG	I
    //   86: aload_0
    //   87: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   90: getfield 37	aiyg:eG	[B
    //   93: invokevirtual 52	aiyg:b	(II[B)V
    //   96: aload_0
    //   97: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   100: iload_2
    //   101: putfield 41	aiyg:bqG	I
    //   104: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   107: lstore 7
    //   109: aload_0
    //   110: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   113: getfield 56	aiyg:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   116: aload_0
    //   117: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   120: getfield 59	aiyg:eH	[B
    //   123: aload_0
    //   124: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   127: getfield 48	aiyg:dgJ	I
    //   130: aload_0
    //   131: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   134: getfield 62	aiyg:eI	[B
    //   137: invokevirtual 68	com/tencent/mobileqq/magicface/DecoderUtil:decodeVideoDecoder	([BI[B)I
    //   140: pop
    //   141: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +48 -> 192
    //   147: ldc 76
    //   149: iconst_2
    //   150: new 78	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   157: ldc 81
    //   159: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   165: lload 7
    //   167: lsub
    //   168: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: ldc 90
    //   173: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   180: getfield 48	aiyg:dgJ	I
    //   183: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload_0
    //   193: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   196: getfield 104	aiyg:videoWidth	I
    //   199: iconst_m1
    //   200: if_icmpne +61 -> 261
    //   203: aload_0
    //   204: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   207: aload_0
    //   208: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   211: getfield 56	aiyg:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   214: invokevirtual 108	com/tencent/mobileqq/magicface/DecoderUtil:getWidthVideoDecoder	()I
    //   217: putfield 104	aiyg:videoWidth	I
    //   220: aload_0
    //   221: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   224: aload_0
    //   225: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   228: getfield 56	aiyg:jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil	Lcom/tencent/mobileqq/magicface/DecoderUtil;
    //   231: invokevirtual 111	com/tencent/mobileqq/magicface/DecoderUtil:getHeightVideoDecoder	()I
    //   234: putfield 114	aiyg:videoHeight	I
    //   237: aload_0
    //   238: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   241: aload_0
    //   242: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   245: getfield 114	aiyg:videoHeight	I
    //   248: aload_0
    //   249: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   252: getfield 104	aiyg:videoWidth	I
    //   255: imul
    //   256: newarray int
    //   258: putfield 118	aiyg:colors	[I
    //   261: aload_0
    //   262: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   265: getfield 122	aiyg:object	Ljava/lang/Object;
    //   268: astore 10
    //   270: aload 10
    //   272: monitorenter
    //   273: aload_0
    //   274: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   277: getfield 125	aiyg:cmJ	Z
    //   280: istore 9
    //   282: iload 9
    //   284: ifne +13 -> 297
    //   287: aload_0
    //   288: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   291: getfield 122	aiyg:object	Ljava/lang/Object;
    //   294: invokevirtual 128	java/lang/Object:wait	()V
    //   297: aload 10
    //   299: monitorexit
    //   300: aload_0
    //   301: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   304: aload_0
    //   305: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   308: getfield 62	aiyg:eI	[B
    //   311: aload_0
    //   312: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   315: getfield 131	aiyg:eK	[B
    //   318: invokevirtual 134	aiyg:a	([B[B)[I
    //   321: astore 10
    //   323: aload_0
    //   324: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   327: getfield 137	aiyg:jdField_a_of_type_Aiyc$b	Laiyc$b;
    //   330: ifnull +31 -> 361
    //   333: aload_0
    //   334: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   337: getfield 137	aiyg:jdField_a_of_type_Aiyc$b	Laiyc$b;
    //   340: aload 10
    //   342: aload_0
    //   343: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   346: getfield 104	aiyg:videoWidth	I
    //   349: aload_0
    //   350: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   353: getfield 114	aiyg:videoHeight	I
    //   356: invokeinterface 142 4 0
    //   361: invokestatic 33	java/lang/System:currentTimeMillis	()J
    //   364: lload_3
    //   365: lsub
    //   366: lstore 7
    //   368: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +29 -> 400
    //   374: ldc 76
    //   376: iconst_2
    //   377: new 78	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   384: ldc 144
    //   386: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: lload 7
    //   391: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   394: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: lload 7
    //   402: aload_0
    //   403: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   406: getfield 147	aiyg:dgI	I
    //   409: i2l
    //   410: lcmp
    //   411: ifge +129 -> 540
    //   414: lload 5
    //   416: lconst_0
    //   417: lcmp
    //   418: ifle +94 -> 512
    //   421: aload_0
    //   422: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   425: getfield 147	aiyg:dgI	I
    //   428: i2l
    //   429: lload 7
    //   431: lsub
    //   432: lstore_3
    //   433: lload_3
    //   434: lload 5
    //   436: lcmp
    //   437: ifle +67 -> 504
    //   440: lload_3
    //   441: lload 5
    //   443: lsub
    //   444: invokestatic 153	java/lang/Thread:sleep	(J)V
    //   447: lload 5
    //   449: lstore_3
    //   450: aload_0
    //   451: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   454: getfield 156	aiyg:ec	Ljava/lang/Object;
    //   457: astore 10
    //   459: aload 10
    //   461: monitorenter
    //   462: aload_0
    //   463: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   466: getfield 156	aiyg:ec	Ljava/lang/Object;
    //   469: invokevirtual 159	java/lang/Object:notify	()V
    //   472: aload 10
    //   474: monitorexit
    //   475: iconst_0
    //   476: istore_1
    //   477: lload_3
    //   478: lstore 5
    //   480: goto -475 -> 5
    //   483: astore 11
    //   485: aload 10
    //   487: monitorexit
    //   488: aload 11
    //   490: athrow
    //   491: astore 10
    //   493: aload 10
    //   495: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   498: return
    //   499: astore 10
    //   501: aload 10
    //   503: athrow
    //   504: lload 5
    //   506: lload_3
    //   507: lsub
    //   508: lstore_3
    //   509: goto -59 -> 450
    //   512: aload_0
    //   513: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   516: getfield 147	aiyg:dgI	I
    //   519: i2l
    //   520: lload 7
    //   522: lsub
    //   523: invokestatic 153	java/lang/Thread:sleep	(J)V
    //   526: lload 5
    //   528: lstore_3
    //   529: goto -79 -> 450
    //   532: astore 10
    //   534: aload 10
    //   536: invokevirtual 163	java/lang/OutOfMemoryError:printStackTrace	()V
    //   539: return
    //   540: lload 5
    //   542: lstore_3
    //   543: iload_1
    //   544: ifne -94 -> 450
    //   547: aload_0
    //   548: getfield 12	com/tencent/mobileqq/magicface/model/MagicfaceXBigDecoder$1:this$0	Laiyg;
    //   551: getfield 147	aiyg:dgI	I
    //   554: istore_1
    //   555: lload 5
    //   557: lload 7
    //   559: iload_1
    //   560: i2l
    //   561: lsub
    //   562: ladd
    //   563: lstore_3
    //   564: goto -114 -> 450
    //   567: astore 11
    //   569: aload 10
    //   571: monitorexit
    //   572: aload 11
    //   574: athrow
    //   575: astore 10
    //   577: goto -102 -> 475
    //   580: astore 11
    //   582: goto -285 -> 297
    //   585: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	1
    //   1	559	1	i	int
    //   40	61	2	j	int
    //   18	546	3	l1	long
    //   3	553	5	l2	long
    //   107	451	7	l3	long
    //   280	3	9	bool	boolean
    //   491	3	10	localException1	java.lang.Exception
    //   499	3	10	localObject2	Object
    //   532	38	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   575	1	10	localException2	java.lang.Exception
    //   483	6	11	localObject3	Object
    //   567	6	11	localObject4	Object
    //   580	1	11	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   273	282	483	finally
    //   287	297	483	finally
    //   297	300	483	finally
    //   485	488	483	finally
    //   5	67	491	java/lang/Exception
    //   68	192	491	java/lang/Exception
    //   192	261	491	java/lang/Exception
    //   261	273	491	java/lang/Exception
    //   300	361	491	java/lang/Exception
    //   361	400	491	java/lang/Exception
    //   400	414	491	java/lang/Exception
    //   421	433	491	java/lang/Exception
    //   440	447	491	java/lang/Exception
    //   488	491	491	java/lang/Exception
    //   512	526	491	java/lang/Exception
    //   547	555	491	java/lang/Exception
    //   5	67	499	finally
    //   68	192	499	finally
    //   192	261	499	finally
    //   261	273	499	finally
    //   300	361	499	finally
    //   361	400	499	finally
    //   400	414	499	finally
    //   421	433	499	finally
    //   440	447	499	finally
    //   450	462	499	finally
    //   488	491	499	finally
    //   493	498	499	finally
    //   512	526	499	finally
    //   534	539	499	finally
    //   547	555	499	finally
    //   572	575	499	finally
    //   5	67	532	java/lang/OutOfMemoryError
    //   68	192	532	java/lang/OutOfMemoryError
    //   192	261	532	java/lang/OutOfMemoryError
    //   261	273	532	java/lang/OutOfMemoryError
    //   300	361	532	java/lang/OutOfMemoryError
    //   361	400	532	java/lang/OutOfMemoryError
    //   400	414	532	java/lang/OutOfMemoryError
    //   421	433	532	java/lang/OutOfMemoryError
    //   440	447	532	java/lang/OutOfMemoryError
    //   450	462	532	java/lang/OutOfMemoryError
    //   488	491	532	java/lang/OutOfMemoryError
    //   512	526	532	java/lang/OutOfMemoryError
    //   547	555	532	java/lang/OutOfMemoryError
    //   572	575	532	java/lang/OutOfMemoryError
    //   462	475	567	finally
    //   569	572	567	finally
    //   450	462	575	java/lang/Exception
    //   572	575	575	java/lang/Exception
    //   287	297	580	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceXBigDecoder.1
 * JD-Core Version:    0.7.0.1
 */