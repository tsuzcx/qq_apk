import com.tencent.mobileqq.utils.QQRecorder;

public class hds
  extends Thread
{
  public volatile boolean a;
  
  public hds(QQRecorder paramQQRecorder, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    QQRecorder.a(paramQQRecorder, paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 35
    //   8: iconst_2
    //   9: new 37	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   16: ldc 40
    //   18: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   34: lstore 29
    //   36: lconst_0
    //   37: lstore 13
    //   39: iconst_0
    //   40: istore 5
    //   42: lconst_0
    //   43: lstore 11
    //   45: aload_0
    //   46: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   49: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   52: ifnull +22 -> 74
    //   55: aload_0
    //   56: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   59: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   62: aload_0
    //   63: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   66: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   69: invokeinterface 72 2 0
    //   74: sipush 1600
    //   77: newarray byte
    //   79: astore 33
    //   81: aload_0
    //   82: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   85: invokestatic 75	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   88: aload_0
    //   89: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   92: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   95: ifnull +15 -> 110
    //   98: aload_0
    //   99: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   102: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   105: invokeinterface 78 1 0
    //   110: aload_0
    //   111: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   114: invokestatic 81	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   117: ldc2_w 82
    //   120: invokestatic 87	java/lang/Thread:sleep	(J)V
    //   123: invokestatic 90	com/tencent/mobileqq/utils/QQRecorder:b	()I
    //   126: sipush 1000
    //   129: idiv
    //   130: sipush 250
    //   133: imul
    //   134: istore 6
    //   136: iload 6
    //   138: newarray byte
    //   140: astore 32
    //   142: aload_0
    //   143: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   146: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   149: aload 32
    //   151: iconst_0
    //   152: iload 6
    //   154: invokevirtual 99	android/media/AudioRecord:read	([BII)I
    //   157: istore 7
    //   159: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +39 -> 201
    //   165: ldc 35
    //   167: iconst_2
    //   168: new 37	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   175: ldc 101
    //   177: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 7
    //   182: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc 106
    //   187: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 6
    //   192: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_0
    //   202: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   205: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   208: ifnull +15 -> 223
    //   211: aload_0
    //   212: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   215: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   218: invokeinterface 109 1 0
    //   223: lconst_0
    //   224: lstore 11
    //   226: dconst_0
    //   227: dstore_1
    //   228: iconst_0
    //   229: istore 5
    //   231: lconst_0
    //   232: lstore 21
    //   234: lconst_0
    //   235: lstore 15
    //   237: iconst_0
    //   238: istore 7
    //   240: lconst_0
    //   241: lstore 17
    //   243: iconst_0
    //   244: istore 8
    //   246: aconst_null
    //   247: astore 32
    //   249: lconst_0
    //   250: lstore 19
    //   252: lconst_0
    //   253: lstore 13
    //   255: aload_0
    //   256: getfield 16	hds:jdField_a_of_type_Boolean	Z
    //   259: istore 31
    //   261: iload 31
    //   263: ifeq +478 -> 741
    //   266: lload 19
    //   268: lconst_1
    //   269: ladd
    //   270: lstore 19
    //   272: lload 21
    //   274: lstore 23
    //   276: lload 21
    //   278: lstore 25
    //   280: ldc2_w 110
    //   283: invokestatic 87	java/lang/Thread:sleep	(J)V
    //   286: iconst_0
    //   287: istore 6
    //   289: aload 32
    //   291: ifnull +35 -> 326
    //   294: lload 21
    //   296: lstore 23
    //   298: lload 21
    //   300: lstore 25
    //   302: aload 32
    //   304: arraylength
    //   305: istore 6
    //   307: lload 21
    //   309: lstore 23
    //   311: lload 21
    //   313: lstore 25
    //   315: aload 32
    //   317: iconst_0
    //   318: aload 33
    //   320: iconst_0
    //   321: iload 6
    //   323: invokestatic 115	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   326: lload 21
    //   328: lstore 23
    //   330: lload 21
    //   332: lstore 25
    //   334: aload_0
    //   335: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   338: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   341: aload 33
    //   343: iload 6
    //   345: sipush 800
    //   348: iload 6
    //   350: isub
    //   351: invokevirtual 99	android/media/AudioRecord:read	([BII)I
    //   354: istore 9
    //   356: iload 9
    //   358: ifgt +10 -> 368
    //   361: iload 9
    //   363: istore 5
    //   365: goto -110 -> 255
    //   368: lload 21
    //   370: iload 9
    //   372: i2l
    //   373: ladd
    //   374: lstore 21
    //   376: aconst_null
    //   377: astore 32
    //   379: iload 6
    //   381: iload 9
    //   383: iadd
    //   384: istore 9
    //   386: iload 9
    //   388: sipush 160
    //   391: irem
    //   392: istore 6
    //   394: iload 6
    //   396: ifeq +4261 -> 4657
    //   399: lload 21
    //   401: lstore 23
    //   403: lload 21
    //   405: lstore 25
    //   407: iload 6
    //   409: newarray byte
    //   411: astore 32
    //   413: lload 21
    //   415: lstore 23
    //   417: lload 21
    //   419: lstore 25
    //   421: aload 33
    //   423: iload 9
    //   425: iload 6
    //   427: isub
    //   428: aload 32
    //   430: iconst_0
    //   431: iload 6
    //   433: invokestatic 115	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   436: iload 9
    //   438: iload 6
    //   440: isub
    //   441: istore 9
    //   443: lload 21
    //   445: lstore 23
    //   447: lload 21
    //   449: lstore 25
    //   451: aload_0
    //   452: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   455: invokestatic 118	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   458: aload 33
    //   460: iload 9
    //   462: fconst_1
    //   463: invokestatic 123	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   466: l2i
    //   467: istore 10
    //   469: lload 21
    //   471: lstore 23
    //   473: lload 21
    //   475: lstore 25
    //   477: iload 8
    //   479: iload 10
    //   481: invokestatic 129	java/lang/Math:max	(II)I
    //   484: istore 6
    //   486: lload 17
    //   488: iload 10
    //   490: i2l
    //   491: ladd
    //   492: lstore 17
    //   494: iconst_0
    //   495: istore 8
    //   497: iload 8
    //   499: iload 9
    //   501: if_icmpge +88 -> 589
    //   504: aload_0
    //   505: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   508: invokestatic 132	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   511: ifnull +20 -> 531
    //   514: aload_0
    //   515: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   518: invokestatic 132	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   521: aload 33
    //   523: iload 8
    //   525: sipush 160
    //   528: invokevirtual 137	com/tencent/mobileqq/utils/PTTAgcWrapper:a	([BII)V
    //   531: aload_0
    //   532: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   535: invokestatic 140	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   538: ifnull +21 -> 559
    //   541: aload_0
    //   542: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   545: invokestatic 140	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   548: aload 33
    //   550: iload 8
    //   552: sipush 160
    //   555: invokevirtual 144	com/tencent/mobileqq/utils/NoiseSuppression:a	([BII)I
    //   558: pop
    //   559: aload_0
    //   560: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   563: invokestatic 132	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   566: ifnull +4094 -> 4660
    //   569: aload_0
    //   570: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   573: invokestatic 132	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   576: aload 33
    //   578: iload 8
    //   580: sipush 160
    //   583: invokevirtual 146	com/tencent/mobileqq/utils/PTTAgcWrapper:b	([BII)V
    //   586: goto +4074 -> 4660
    //   589: aload_0
    //   590: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   593: aload_0
    //   594: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   597: invokestatic 118	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   600: aload 33
    //   602: iload 9
    //   604: fconst_1
    //   605: invokestatic 123	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   608: l2i
    //   609: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;I)I
    //   612: pop
    //   613: iload 7
    //   615: aload_0
    //   616: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   619: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   622: invokestatic 129	java/lang/Math:max	(II)I
    //   625: istore 8
    //   627: aload_0
    //   628: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   631: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   634: istore 7
    //   636: lload 15
    //   638: iload 7
    //   640: i2l
    //   641: ladd
    //   642: lstore 15
    //   644: iload 9
    //   646: i2l
    //   647: lstore 23
    //   649: lload 23
    //   651: invokestatic 155	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   654: dstore_3
    //   655: dload_1
    //   656: dload_3
    //   657: dadd
    //   658: dstore_1
    //   659: aload_0
    //   660: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   663: aload 33
    //   665: iload 9
    //   667: invokestatic 158	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;[BI)[B
    //   670: astore 34
    //   672: aload_0
    //   673: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   676: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   679: ifnull +32 -> 711
    //   682: aload_0
    //   683: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   686: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   689: aload_0
    //   690: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   693: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   696: aload 34
    //   698: aload_0
    //   699: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   702: invokestatic 152	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   705: dload_1
    //   706: invokeinterface 161 6 0
    //   711: aload 34
    //   713: arraylength
    //   714: istore 7
    //   716: lload 11
    //   718: iload 7
    //   720: i2l
    //   721: ladd
    //   722: lstore 11
    //   724: lload 13
    //   726: lconst_1
    //   727: ladd
    //   728: lstore 13
    //   730: iload 8
    //   732: istore 7
    //   734: iload 6
    //   736: istore 8
    //   738: goto -483 -> 255
    //   741: aload_0
    //   742: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   745: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   748: ifnull +54 -> 802
    //   751: aload_0
    //   752: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   755: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   758: aload_0
    //   759: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   762: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   765: invokeinterface 164 2 0
    //   770: aload_0
    //   771: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   774: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   777: ifnull +25 -> 802
    //   780: aload_0
    //   781: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   784: invokestatic 169	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   787: iconst_m1
    //   788: if_icmpeq +14 -> 802
    //   791: aload_0
    //   792: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   795: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   798: iconst_0
    //   799: invokevirtual 175	android/media/AudioManager:setMode	(I)V
    //   802: aload_0
    //   803: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   806: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   809: ifnull +13 -> 822
    //   812: aload_0
    //   813: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   816: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   819: invokevirtual 178	android/media/AudioRecord:release	()V
    //   822: aload_0
    //   823: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   826: invokestatic 180	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   829: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +172 -> 1004
    //   835: ldc 35
    //   837: iconst_2
    //   838: new 37	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   845: ldc 182
    //   847: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload_0
    //   851: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   854: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   860: ldc 35
    //   862: iconst_2
    //   863: new 37	java/lang/StringBuilder
    //   866: dup
    //   867: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   870: ldc 184
    //   872: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: lload 19
    //   877: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   880: ldc 189
    //   882: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: lload 21
    //   887: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   890: ldc 191
    //   892: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: lload 11
    //   897: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   900: ldc 193
    //   902: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: iload 5
    //   907: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   916: ldc 35
    //   918: new 37	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   925: ldc 195
    //   927: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: dload_1
    //   931: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   934: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   940: pop
    //   941: ldc 35
    //   943: new 37	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   950: ldc 205
    //   952: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: lload 21
    //   957: invokestatic 155	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   960: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   963: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   969: pop
    //   970: ldc 35
    //   972: new 37	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   979: ldc 207
    //   981: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_0
    //   985: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   988: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   991: invokestatic 210	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   994: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   997: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1000: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1003: pop
    //   1004: lload 11
    //   1006: ldc2_w 211
    //   1009: lcmp
    //   1010: iflt +11 -> 1021
    //   1013: dload_1
    //   1014: ldc2_w 213
    //   1017: dcmpg
    //   1018: ifge +311 -> 1329
    //   1021: invokestatic 220	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1024: invokestatic 225	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1027: astore 32
    //   1029: new 227	java/util/HashMap
    //   1032: dup
    //   1033: invokespecial 228	java/util/HashMap:<init>	()V
    //   1036: astore 33
    //   1038: aload 33
    //   1040: ldc 230
    //   1042: ldc 232
    //   1044: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1047: pop
    //   1048: aload 33
    //   1050: ldc 238
    //   1052: getstatic 244	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1055: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1058: pop
    //   1059: aload 33
    //   1061: ldc 246
    //   1063: new 37	java/lang/StringBuilder
    //   1066: dup
    //   1067: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1070: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   1073: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: ldc 252
    //   1078: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1087: pop
    //   1088: aload 33
    //   1090: ldc 254
    //   1092: new 37	java/lang/StringBuilder
    //   1095: dup
    //   1096: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1099: getstatic 259	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1102: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: ldc_w 261
    //   1108: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: getstatic 264	android/os/Build:MODEL	Ljava/lang/String;
    //   1114: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: pop
    //   1124: aload 33
    //   1126: ldc_w 266
    //   1129: new 37	java/lang/StringBuilder
    //   1132: dup
    //   1133: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1136: lload 21
    //   1138: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1141: ldc 252
    //   1143: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1149: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1152: pop
    //   1153: aload 33
    //   1155: ldc_w 268
    //   1158: new 37	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1165: lload 11
    //   1167: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1170: ldc 252
    //   1172: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1181: pop
    //   1182: aload 33
    //   1184: ldc_w 270
    //   1187: new 37	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1194: dload_1
    //   1195: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1198: ldc 252
    //   1200: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1209: pop
    //   1210: aload 33
    //   1212: ldc_w 272
    //   1215: new 37	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1222: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1225: lload 29
    //   1227: lsub
    //   1228: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1231: ldc 252
    //   1233: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1239: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1242: pop
    //   1243: aload 32
    //   1245: ldc 252
    //   1247: ldc_w 274
    //   1250: iconst_0
    //   1251: lconst_0
    //   1252: lconst_0
    //   1253: aload 33
    //   1255: ldc 252
    //   1257: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1260: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1263: ifeq +66 -> 1329
    //   1266: ldc 35
    //   1268: iconst_2
    //   1269: new 37	java/lang/StringBuilder
    //   1272: dup
    //   1273: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1276: ldc_w 279
    //   1279: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1282: lload 21
    //   1284: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1287: ldc_w 281
    //   1290: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: lload 11
    //   1295: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1298: ldc_w 283
    //   1301: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: dload_1
    //   1305: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1308: ldc_w 285
    //   1311: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1317: lload 29
    //   1319: lsub
    //   1320: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1329: invokestatic 220	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   1332: invokestatic 225	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1335: astore 32
    //   1337: new 227	java/util/HashMap
    //   1340: dup
    //   1341: invokespecial 228	java/util/HashMap:<init>	()V
    //   1344: astore 33
    //   1346: aload 33
    //   1348: ldc 238
    //   1350: getstatic 244	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   1353: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1356: pop
    //   1357: aload 33
    //   1359: ldc 246
    //   1361: new 37	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1368: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   1371: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1374: ldc 252
    //   1376: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1385: pop
    //   1386: aload 33
    //   1388: ldc 254
    //   1390: new 37	java/lang/StringBuilder
    //   1393: dup
    //   1394: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1397: getstatic 259	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1400: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: ldc_w 261
    //   1406: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: getstatic 264	android/os/Build:MODEL	Ljava/lang/String;
    //   1412: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1421: pop
    //   1422: aload 33
    //   1424: ldc_w 266
    //   1427: new 37	java/lang/StringBuilder
    //   1430: dup
    //   1431: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1434: lload 21
    //   1436: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1439: ldc 252
    //   1441: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1450: pop
    //   1451: aload 33
    //   1453: ldc_w 268
    //   1456: new 37	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1463: lload 11
    //   1465: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1468: ldc 252
    //   1470: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1479: pop
    //   1480: aload 33
    //   1482: ldc_w 287
    //   1485: new 37	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1492: dload_1
    //   1493: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1496: ldc 252
    //   1498: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1507: pop
    //   1508: aload 33
    //   1510: ldc_w 272
    //   1513: new 37	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1520: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1523: lload 29
    //   1525: lsub
    //   1526: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1529: ldc 252
    //   1531: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1537: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1540: pop
    //   1541: aload 33
    //   1543: ldc_w 289
    //   1546: new 37	java/lang/StringBuilder
    //   1549: dup
    //   1550: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1553: iload 8
    //   1555: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1558: ldc 252
    //   1560: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1569: pop
    //   1570: aload 33
    //   1572: ldc_w 291
    //   1575: new 37	java/lang/StringBuilder
    //   1578: dup
    //   1579: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1582: iload 7
    //   1584: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1587: ldc 252
    //   1589: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1595: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1598: pop
    //   1599: lload 13
    //   1601: lconst_0
    //   1602: lcmp
    //   1603: ifne +282 -> 1885
    //   1606: ldc2_w 292
    //   1609: lstore 17
    //   1611: goto +3060 -> 4671
    //   1614: lload 13
    //   1616: l2i
    //   1617: istore 5
    //   1619: aload 33
    //   1621: ldc_w 295
    //   1624: new 37	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1631: iload 6
    //   1633: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1636: ldc 252
    //   1638: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1641: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1644: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1647: pop
    //   1648: aload 33
    //   1650: ldc_w 297
    //   1653: new 37	java/lang/StringBuilder
    //   1656: dup
    //   1657: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1660: iload 5
    //   1662: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1665: ldc 252
    //   1667: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1673: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1676: pop
    //   1677: aload 32
    //   1679: ldc 252
    //   1681: ldc_w 299
    //   1684: iconst_0
    //   1685: lconst_0
    //   1686: lconst_0
    //   1687: aload 33
    //   1689: ldc 252
    //   1691: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1694: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1697: ifeq +138 -> 1835
    //   1700: new 37	java/lang/StringBuilder
    //   1703: dup
    //   1704: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1707: astore 32
    //   1709: aload 32
    //   1711: ldc_w 301
    //   1714: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: iload 8
    //   1719: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1722: pop
    //   1723: aload 32
    //   1725: ldc_w 303
    //   1728: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: iload 6
    //   1733: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1736: pop
    //   1737: aload 32
    //   1739: ldc_w 305
    //   1742: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1745: iload 5
    //   1747: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1750: pop
    //   1751: aload 32
    //   1753: ldc_w 307
    //   1756: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: iload 5
    //   1761: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: aload 32
    //   1767: ldc_w 309
    //   1770: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: lload 21
    //   1775: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1778: pop
    //   1779: aload 32
    //   1781: ldc_w 311
    //   1784: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: lload 11
    //   1789: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1792: pop
    //   1793: aload 32
    //   1795: ldc_w 313
    //   1798: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: dload_1
    //   1802: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1805: pop
    //   1806: aload 32
    //   1808: ldc_w 315
    //   1811: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1817: lload 29
    //   1819: lsub
    //   1820: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1823: pop
    //   1824: ldc 35
    //   1826: iconst_2
    //   1827: aload 32
    //   1829: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1835: aload_0
    //   1836: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1839: aconst_null
    //   1840: putfield 318	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Hds	Lhds;
    //   1843: aload_0
    //   1844: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1847: aconst_null
    //   1848: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   1851: pop
    //   1852: return
    //   1853: astore 32
    //   1855: aload 32
    //   1857: invokevirtual 321	java/lang/Throwable:printStackTrace	()V
    //   1860: goto -1031 -> 829
    //   1863: astore 32
    //   1865: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1868: ifeq -539 -> 1329
    //   1871: ldc 35
    //   1873: iconst_2
    //   1874: ldc_w 323
    //   1877: aload 32
    //   1879: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1882: goto -553 -> 1329
    //   1885: lload 17
    //   1887: lload 13
    //   1889: ldiv
    //   1890: lstore 17
    //   1892: goto +2779 -> 4671
    //   1895: lload 15
    //   1897: lload 13
    //   1899: ldiv
    //   1900: lstore 13
    //   1902: goto -288 -> 1614
    //   1905: astore 32
    //   1907: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1910: ifeq -75 -> 1835
    //   1913: ldc 35
    //   1915: iconst_2
    //   1916: ldc_w 328
    //   1919: aload 32
    //   1921: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1924: goto -89 -> 1835
    //   1927: astore 32
    //   1929: lconst_0
    //   1930: lstore 15
    //   1932: iconst_0
    //   1933: istore 6
    //   1935: iconst_0
    //   1936: istore 7
    //   1938: lconst_0
    //   1939: lstore 17
    //   1941: dconst_0
    //   1942: dstore_1
    //   1943: lconst_0
    //   1944: lstore 21
    //   1946: lconst_0
    //   1947: lstore 19
    //   1949: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1952: ifeq +35 -> 1987
    //   1955: ldc 35
    //   1957: iconst_2
    //   1958: new 37	java/lang/StringBuilder
    //   1961: dup
    //   1962: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1965: ldc_w 330
    //   1968: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1971: aload 32
    //   1973: invokestatic 334	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1976: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1982: aload 32
    //   1984: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1987: aload_0
    //   1988: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1991: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1994: ifnull +59 -> 2053
    //   1997: aload_0
    //   1998: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2001: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2004: ifnull +25 -> 2029
    //   2007: aload_0
    //   2008: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2011: invokestatic 169	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   2014: iconst_m1
    //   2015: if_icmpeq +14 -> 2029
    //   2018: aload_0
    //   2019: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2022: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2025: iconst_0
    //   2026: invokevirtual 175	android/media/AudioManager:setMode	(I)V
    //   2029: aload_0
    //   2030: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2033: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2036: aload_0
    //   2037: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2040: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2043: aload 32
    //   2045: invokevirtual 337	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2048: invokeinterface 340 3 0
    //   2053: aload_0
    //   2054: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2057: aload 32
    //   2059: invokevirtual 343	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   2062: aload_0
    //   2063: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2066: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2069: ifnull +13 -> 2082
    //   2072: aload_0
    //   2073: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2076: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2079: invokevirtual 178	android/media/AudioRecord:release	()V
    //   2082: aload_0
    //   2083: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2086: invokestatic 180	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2089: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2092: ifeq +172 -> 2264
    //   2095: ldc 35
    //   2097: iconst_2
    //   2098: new 37	java/lang/StringBuilder
    //   2101: dup
    //   2102: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2105: ldc 182
    //   2107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2110: aload_0
    //   2111: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2114: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2117: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2120: ldc 35
    //   2122: iconst_2
    //   2123: new 37	java/lang/StringBuilder
    //   2126: dup
    //   2127: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2130: ldc 184
    //   2132: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: lload 21
    //   2137: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2140: ldc 189
    //   2142: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: lload 19
    //   2147: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2150: ldc 191
    //   2152: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: lload 17
    //   2157: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2160: ldc 193
    //   2162: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: iload 6
    //   2167: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2170: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2173: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2176: ldc 35
    //   2178: new 37	java/lang/StringBuilder
    //   2181: dup
    //   2182: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2185: ldc 195
    //   2187: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2190: dload_1
    //   2191: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2194: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2197: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2200: pop
    //   2201: ldc 35
    //   2203: new 37	java/lang/StringBuilder
    //   2206: dup
    //   2207: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2210: ldc 205
    //   2212: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: lload 19
    //   2217: invokestatic 155	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   2220: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2223: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2226: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2229: pop
    //   2230: ldc 35
    //   2232: new 37	java/lang/StringBuilder
    //   2235: dup
    //   2236: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2239: ldc 207
    //   2241: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2244: aload_0
    //   2245: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2248: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2251: invokestatic 210	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   2254: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2257: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2260: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2263: pop
    //   2264: lload 17
    //   2266: ldc2_w 211
    //   2269: lcmp
    //   2270: iflt +11 -> 2281
    //   2273: dload_1
    //   2274: ldc2_w 213
    //   2277: dcmpg
    //   2278: ifge +3 -> 2281
    //   2281: invokestatic 220	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2284: invokestatic 225	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2287: astore 32
    //   2289: new 227	java/util/HashMap
    //   2292: dup
    //   2293: invokespecial 228	java/util/HashMap:<init>	()V
    //   2296: astore 33
    //   2298: aload 33
    //   2300: ldc 238
    //   2302: getstatic 244	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   2305: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2308: pop
    //   2309: aload 33
    //   2311: ldc 246
    //   2313: new 37	java/lang/StringBuilder
    //   2316: dup
    //   2317: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2320: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   2323: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2326: ldc 252
    //   2328: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2331: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2334: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2337: pop
    //   2338: aload 33
    //   2340: ldc 254
    //   2342: new 37	java/lang/StringBuilder
    //   2345: dup
    //   2346: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2349: getstatic 259	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2352: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2355: ldc_w 261
    //   2358: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2361: getstatic 264	android/os/Build:MODEL	Ljava/lang/String;
    //   2364: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2370: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2373: pop
    //   2374: aload 33
    //   2376: ldc_w 266
    //   2379: new 37	java/lang/StringBuilder
    //   2382: dup
    //   2383: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2386: lload 19
    //   2388: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2391: ldc 252
    //   2393: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2399: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2402: pop
    //   2403: aload 33
    //   2405: ldc_w 268
    //   2408: new 37	java/lang/StringBuilder
    //   2411: dup
    //   2412: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2415: lload 17
    //   2417: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2420: ldc 252
    //   2422: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2425: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2428: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2431: pop
    //   2432: aload 33
    //   2434: ldc_w 287
    //   2437: new 37	java/lang/StringBuilder
    //   2440: dup
    //   2441: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2444: dload_1
    //   2445: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2448: ldc 252
    //   2450: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2453: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2456: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2459: pop
    //   2460: aload 33
    //   2462: ldc_w 272
    //   2465: new 37	java/lang/StringBuilder
    //   2468: dup
    //   2469: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2472: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2475: lload 29
    //   2477: lsub
    //   2478: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2481: ldc 252
    //   2483: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2486: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2489: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2492: pop
    //   2493: aload 33
    //   2495: ldc_w 289
    //   2498: new 37	java/lang/StringBuilder
    //   2501: dup
    //   2502: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2505: iload 7
    //   2507: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2510: ldc 252
    //   2512: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2515: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2518: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2521: pop
    //   2522: aload 33
    //   2524: ldc_w 291
    //   2527: new 37	java/lang/StringBuilder
    //   2530: dup
    //   2531: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2534: iload 5
    //   2536: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2539: ldc 252
    //   2541: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2547: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2550: pop
    //   2551: lload 15
    //   2553: lconst_0
    //   2554: lcmp
    //   2555: ifne +260 -> 2815
    //   2558: ldc2_w 292
    //   2561: lstore 13
    //   2563: goto +2128 -> 4691
    //   2566: lload 11
    //   2568: l2i
    //   2569: istore 5
    //   2571: aload 33
    //   2573: ldc_w 295
    //   2576: new 37	java/lang/StringBuilder
    //   2579: dup
    //   2580: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2583: iload 6
    //   2585: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2588: ldc 252
    //   2590: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2593: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2596: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2599: pop
    //   2600: aload 33
    //   2602: ldc_w 297
    //   2605: new 37	java/lang/StringBuilder
    //   2608: dup
    //   2609: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2612: iload 5
    //   2614: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2617: ldc 252
    //   2619: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2625: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2628: pop
    //   2629: aload 32
    //   2631: ldc 252
    //   2633: ldc_w 299
    //   2636: iconst_0
    //   2637: lconst_0
    //   2638: lconst_0
    //   2639: aload 33
    //   2641: ldc 252
    //   2643: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2646: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2649: ifeq +138 -> 2787
    //   2652: new 37	java/lang/StringBuilder
    //   2655: dup
    //   2656: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2659: astore 32
    //   2661: aload 32
    //   2663: ldc_w 301
    //   2666: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2669: iload 7
    //   2671: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2674: pop
    //   2675: aload 32
    //   2677: ldc_w 303
    //   2680: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2683: iload 6
    //   2685: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2688: pop
    //   2689: aload 32
    //   2691: ldc_w 305
    //   2694: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: iload 5
    //   2699: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2702: pop
    //   2703: aload 32
    //   2705: ldc_w 307
    //   2708: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2711: iload 5
    //   2713: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2716: pop
    //   2717: aload 32
    //   2719: ldc_w 309
    //   2722: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2725: lload 19
    //   2727: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2730: pop
    //   2731: aload 32
    //   2733: ldc_w 311
    //   2736: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2739: lload 17
    //   2741: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2744: pop
    //   2745: aload 32
    //   2747: ldc_w 313
    //   2750: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: dload_1
    //   2754: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2757: pop
    //   2758: aload 32
    //   2760: ldc_w 315
    //   2763: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2766: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2769: lload 29
    //   2771: lsub
    //   2772: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2775: pop
    //   2776: ldc 35
    //   2778: iconst_2
    //   2779: aload 32
    //   2781: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2784: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2787: aload_0
    //   2788: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2791: aconst_null
    //   2792: putfield 318	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Hds	Lhds;
    //   2795: aload_0
    //   2796: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2799: aconst_null
    //   2800: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   2803: pop
    //   2804: return
    //   2805: astore 32
    //   2807: aload 32
    //   2809: invokevirtual 321	java/lang/Throwable:printStackTrace	()V
    //   2812: goto -723 -> 2089
    //   2815: lload 13
    //   2817: lload 15
    //   2819: ldiv
    //   2820: lstore 13
    //   2822: goto +1869 -> 4691
    //   2825: lload 11
    //   2827: lload 15
    //   2829: ldiv
    //   2830: lstore 11
    //   2832: goto -266 -> 2566
    //   2835: astore 32
    //   2837: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2840: ifeq -53 -> 2787
    //   2843: ldc 35
    //   2845: iconst_2
    //   2846: ldc_w 328
    //   2849: aload 32
    //   2851: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2854: goto -67 -> 2787
    //   2857: astore 32
    //   2859: lconst_0
    //   2860: lstore 17
    //   2862: dconst_0
    //   2863: dstore_1
    //   2864: lconst_0
    //   2865: lstore 21
    //   2867: lconst_0
    //   2868: lstore 19
    //   2870: iconst_0
    //   2871: istore 8
    //   2873: lconst_0
    //   2874: lstore 15
    //   2876: lconst_0
    //   2877: lstore 11
    //   2879: lconst_0
    //   2880: lstore 13
    //   2882: iconst_0
    //   2883: istore 6
    //   2885: iconst_0
    //   2886: istore 5
    //   2888: iconst_0
    //   2889: istore 7
    //   2891: aload_0
    //   2892: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2895: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2898: ifnull +13 -> 2911
    //   2901: aload_0
    //   2902: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2905: invokestatic 93	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2908: invokevirtual 178	android/media/AudioRecord:release	()V
    //   2911: aload_0
    //   2912: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2915: invokestatic 180	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2918: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2921: ifeq +172 -> 3093
    //   2924: ldc 35
    //   2926: iconst_2
    //   2927: new 37	java/lang/StringBuilder
    //   2930: dup
    //   2931: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2934: ldc 182
    //   2936: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: aload_0
    //   2940: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2943: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2946: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2949: ldc 35
    //   2951: iconst_2
    //   2952: new 37	java/lang/StringBuilder
    //   2955: dup
    //   2956: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2959: ldc 184
    //   2961: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2964: lload 19
    //   2966: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2969: ldc 189
    //   2971: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2974: lload 21
    //   2976: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2979: ldc 191
    //   2981: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2984: lload 17
    //   2986: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2989: ldc 193
    //   2991: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2994: iload 6
    //   2996: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2999: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3002: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3005: ldc 35
    //   3007: new 37	java/lang/StringBuilder
    //   3010: dup
    //   3011: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3014: ldc 195
    //   3016: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3019: dload_1
    //   3020: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3023: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3026: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3029: pop
    //   3030: ldc 35
    //   3032: new 37	java/lang/StringBuilder
    //   3035: dup
    //   3036: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3039: ldc 205
    //   3041: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: lload 21
    //   3046: invokestatic 155	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   3049: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3052: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3055: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3058: pop
    //   3059: ldc 35
    //   3061: new 37	java/lang/StringBuilder
    //   3064: dup
    //   3065: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3068: ldc 207
    //   3070: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: aload_0
    //   3074: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3077: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   3080: invokestatic 210	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   3083: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3086: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3089: invokestatic 203	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3092: pop
    //   3093: lload 17
    //   3095: ldc2_w 211
    //   3098: lcmp
    //   3099: iflt +11 -> 3110
    //   3102: dload_1
    //   3103: ldc2_w 213
    //   3106: dcmpg
    //   3107: ifge +316 -> 3423
    //   3110: iload 5
    //   3112: ifne +311 -> 3423
    //   3115: invokestatic 220	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3118: invokestatic 225	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3121: astore 33
    //   3123: new 227	java/util/HashMap
    //   3126: dup
    //   3127: invokespecial 228	java/util/HashMap:<init>	()V
    //   3130: astore 34
    //   3132: aload 34
    //   3134: ldc 230
    //   3136: ldc 232
    //   3138: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3141: pop
    //   3142: aload 34
    //   3144: ldc 238
    //   3146: getstatic 244	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   3149: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3152: pop
    //   3153: aload 34
    //   3155: ldc 246
    //   3157: new 37	java/lang/StringBuilder
    //   3160: dup
    //   3161: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3164: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   3167: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3170: ldc 252
    //   3172: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3178: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3181: pop
    //   3182: aload 34
    //   3184: ldc 254
    //   3186: new 37	java/lang/StringBuilder
    //   3189: dup
    //   3190: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3193: getstatic 259	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3196: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3199: ldc_w 261
    //   3202: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: getstatic 264	android/os/Build:MODEL	Ljava/lang/String;
    //   3208: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3211: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3214: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3217: pop
    //   3218: aload 34
    //   3220: ldc_w 266
    //   3223: new 37	java/lang/StringBuilder
    //   3226: dup
    //   3227: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3230: lload 21
    //   3232: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3235: ldc 252
    //   3237: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3240: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3243: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3246: pop
    //   3247: aload 34
    //   3249: ldc_w 268
    //   3252: new 37	java/lang/StringBuilder
    //   3255: dup
    //   3256: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3259: lload 17
    //   3261: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3264: ldc 252
    //   3266: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3269: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3272: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3275: pop
    //   3276: aload 34
    //   3278: ldc_w 270
    //   3281: new 37	java/lang/StringBuilder
    //   3284: dup
    //   3285: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3288: dload_1
    //   3289: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3292: ldc 252
    //   3294: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3297: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3300: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3303: pop
    //   3304: aload 34
    //   3306: ldc_w 272
    //   3309: new 37	java/lang/StringBuilder
    //   3312: dup
    //   3313: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3316: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3319: lload 29
    //   3321: lsub
    //   3322: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3325: ldc 252
    //   3327: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3330: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3333: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3336: pop
    //   3337: aload 33
    //   3339: ldc 252
    //   3341: ldc_w 274
    //   3344: iconst_0
    //   3345: lconst_0
    //   3346: lconst_0
    //   3347: aload 34
    //   3349: ldc 252
    //   3351: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3354: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3357: ifeq +66 -> 3423
    //   3360: ldc 35
    //   3362: iconst_2
    //   3363: new 37	java/lang/StringBuilder
    //   3366: dup
    //   3367: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3370: ldc_w 279
    //   3373: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3376: lload 21
    //   3378: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3381: ldc_w 281
    //   3384: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: lload 17
    //   3389: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3392: ldc_w 283
    //   3395: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: dload_1
    //   3399: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3402: ldc_w 285
    //   3405: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3408: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3411: lload 29
    //   3413: lsub
    //   3414: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3417: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3420: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3423: invokestatic 220	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3426: invokestatic 225	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3429: astore 33
    //   3431: new 227	java/util/HashMap
    //   3434: dup
    //   3435: invokespecial 228	java/util/HashMap:<init>	()V
    //   3438: astore 34
    //   3440: aload 34
    //   3442: ldc 238
    //   3444: getstatic 244	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   3447: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3450: pop
    //   3451: aload 34
    //   3453: ldc 246
    //   3455: new 37	java/lang/StringBuilder
    //   3458: dup
    //   3459: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3462: getstatic 250	android/os/Build$VERSION:SDK_INT	I
    //   3465: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3468: ldc 252
    //   3470: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3473: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3476: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3479: pop
    //   3480: aload 34
    //   3482: ldc 254
    //   3484: new 37	java/lang/StringBuilder
    //   3487: dup
    //   3488: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3491: getstatic 259	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3494: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: ldc_w 261
    //   3500: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3503: getstatic 264	android/os/Build:MODEL	Ljava/lang/String;
    //   3506: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3509: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3512: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3515: pop
    //   3516: aload 34
    //   3518: ldc_w 266
    //   3521: new 37	java/lang/StringBuilder
    //   3524: dup
    //   3525: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3528: lload 21
    //   3530: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3533: ldc 252
    //   3535: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3541: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3544: pop
    //   3545: aload 34
    //   3547: ldc_w 268
    //   3550: new 37	java/lang/StringBuilder
    //   3553: dup
    //   3554: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3557: lload 17
    //   3559: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3562: ldc 252
    //   3564: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3570: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3573: pop
    //   3574: aload 34
    //   3576: ldc_w 287
    //   3579: new 37	java/lang/StringBuilder
    //   3582: dup
    //   3583: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3586: dload_1
    //   3587: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3590: ldc 252
    //   3592: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3598: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3601: pop
    //   3602: aload 34
    //   3604: ldc_w 272
    //   3607: new 37	java/lang/StringBuilder
    //   3610: dup
    //   3611: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3614: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3617: lload 29
    //   3619: lsub
    //   3620: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3623: ldc 252
    //   3625: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3631: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3634: pop
    //   3635: aload 34
    //   3637: ldc_w 289
    //   3640: new 37	java/lang/StringBuilder
    //   3643: dup
    //   3644: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3647: iload 8
    //   3649: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3652: ldc 252
    //   3654: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3657: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3660: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3663: pop
    //   3664: aload 34
    //   3666: ldc_w 291
    //   3669: new 37	java/lang/StringBuilder
    //   3672: dup
    //   3673: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3676: iload 7
    //   3678: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3681: ldc 252
    //   3683: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3686: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3689: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3692: pop
    //   3693: lload 15
    //   3695: lconst_0
    //   3696: lcmp
    //   3697: ifne +284 -> 3981
    //   3700: ldc2_w 292
    //   3703: lstore 13
    //   3705: goto +1006 -> 4711
    //   3708: lload 11
    //   3710: l2i
    //   3711: istore 5
    //   3713: aload 34
    //   3715: ldc_w 295
    //   3718: new 37	java/lang/StringBuilder
    //   3721: dup
    //   3722: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3725: iload 6
    //   3727: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3730: ldc 252
    //   3732: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3738: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3741: pop
    //   3742: aload 34
    //   3744: ldc_w 297
    //   3747: new 37	java/lang/StringBuilder
    //   3750: dup
    //   3751: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3754: iload 5
    //   3756: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3759: ldc 252
    //   3761: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3764: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3767: invokevirtual 236	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3770: pop
    //   3771: aload 33
    //   3773: ldc 252
    //   3775: ldc_w 299
    //   3778: iconst_0
    //   3779: lconst_0
    //   3780: lconst_0
    //   3781: aload 34
    //   3783: ldc 252
    //   3785: invokevirtual 277	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3788: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3791: ifeq +138 -> 3929
    //   3794: new 37	java/lang/StringBuilder
    //   3797: dup
    //   3798: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3801: astore 33
    //   3803: aload 33
    //   3805: ldc_w 301
    //   3808: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: iload 8
    //   3813: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3816: pop
    //   3817: aload 33
    //   3819: ldc_w 303
    //   3822: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3825: iload 6
    //   3827: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3830: pop
    //   3831: aload 33
    //   3833: ldc_w 305
    //   3836: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: iload 5
    //   3841: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3844: pop
    //   3845: aload 33
    //   3847: ldc_w 307
    //   3850: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3853: iload 5
    //   3855: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3858: pop
    //   3859: aload 33
    //   3861: ldc_w 309
    //   3864: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: lload 21
    //   3869: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3872: pop
    //   3873: aload 33
    //   3875: ldc_w 311
    //   3878: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3881: lload 17
    //   3883: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3886: pop
    //   3887: aload 33
    //   3889: ldc_w 313
    //   3892: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3895: dload_1
    //   3896: invokevirtual 198	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3899: pop
    //   3900: aload 33
    //   3902: ldc_w 315
    //   3905: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3908: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3911: lload 29
    //   3913: lsub
    //   3914: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3917: pop
    //   3918: ldc 35
    //   3920: iconst_2
    //   3921: aload 33
    //   3923: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3926: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3929: aload_0
    //   3930: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3933: aconst_null
    //   3934: putfield 318	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Hds	Lhds;
    //   3937: aload_0
    //   3938: getfield 11	hds:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3941: aconst_null
    //   3942: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   3945: pop
    //   3946: aload 32
    //   3948: athrow
    //   3949: astore 33
    //   3951: aload 33
    //   3953: invokevirtual 321	java/lang/Throwable:printStackTrace	()V
    //   3956: goto -1038 -> 2918
    //   3959: astore 33
    //   3961: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3964: ifeq -541 -> 3423
    //   3967: ldc 35
    //   3969: iconst_2
    //   3970: ldc_w 323
    //   3973: aload 33
    //   3975: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3978: goto -555 -> 3423
    //   3981: lload 13
    //   3983: lload 15
    //   3985: ldiv
    //   3986: lstore 13
    //   3988: goto +723 -> 4711
    //   3991: lload 11
    //   3993: lload 15
    //   3995: ldiv
    //   3996: lstore 11
    //   3998: goto -290 -> 3708
    //   4001: astore 33
    //   4003: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4006: ifeq -77 -> 3929
    //   4009: ldc 35
    //   4011: iconst_2
    //   4012: ldc_w 328
    //   4015: aload 33
    //   4017: invokestatic 326	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4020: goto -91 -> 3929
    //   4023: astore 32
    //   4025: iload 5
    //   4027: istore 6
    //   4029: iconst_0
    //   4030: istore 5
    //   4032: lload 13
    //   4034: lstore 21
    //   4036: lload 11
    //   4038: lstore 25
    //   4040: lload 15
    //   4042: lstore 11
    //   4044: lload 17
    //   4046: lstore 13
    //   4048: lload 21
    //   4050: lstore 15
    //   4052: lload 25
    //   4054: lstore 17
    //   4056: lload 23
    //   4058: lstore 21
    //   4060: goto -1169 -> 2891
    //   4063: astore 32
    //   4065: iload 5
    //   4067: istore 8
    //   4069: iconst_0
    //   4070: istore 5
    //   4072: lload 11
    //   4074: lstore 23
    //   4076: lload 13
    //   4078: lstore 25
    //   4080: iload 6
    //   4082: istore 9
    //   4084: iload 8
    //   4086: istore 6
    //   4088: lload 15
    //   4090: lstore 11
    //   4092: lload 17
    //   4094: lstore 13
    //   4096: iload 9
    //   4098: istore 8
    //   4100: lload 25
    //   4102: lstore 15
    //   4104: lload 23
    //   4106: lstore 17
    //   4108: goto -1217 -> 2891
    //   4111: astore 32
    //   4113: iconst_0
    //   4114: istore 10
    //   4116: lload 17
    //   4118: lstore 23
    //   4120: iload 8
    //   4122: istore 7
    //   4124: iload 5
    //   4126: istore 9
    //   4128: lload 11
    //   4130: lstore 17
    //   4132: lload 13
    //   4134: lstore 25
    //   4136: iload 6
    //   4138: istore 8
    //   4140: iload 10
    //   4142: istore 5
    //   4144: iload 9
    //   4146: istore 6
    //   4148: lload 15
    //   4150: lstore 11
    //   4152: lload 23
    //   4154: lstore 13
    //   4156: lload 25
    //   4158: lstore 15
    //   4160: goto -1269 -> 2891
    //   4163: astore 32
    //   4165: iconst_0
    //   4166: istore 10
    //   4168: lload 17
    //   4170: lstore 23
    //   4172: iload 8
    //   4174: istore 7
    //   4176: iload 5
    //   4178: istore 9
    //   4180: lload 11
    //   4182: lstore 17
    //   4184: lload 13
    //   4186: lstore 25
    //   4188: iload 6
    //   4190: istore 8
    //   4192: iload 10
    //   4194: istore 5
    //   4196: iload 9
    //   4198: istore 6
    //   4200: lload 15
    //   4202: lstore 11
    //   4204: lload 23
    //   4206: lstore 13
    //   4208: lload 25
    //   4210: lstore 15
    //   4212: goto -1321 -> 2891
    //   4215: astore 32
    //   4217: iconst_0
    //   4218: istore 10
    //   4220: lload 17
    //   4222: lstore 23
    //   4224: iload 8
    //   4226: istore 7
    //   4228: iload 5
    //   4230: istore 9
    //   4232: lload 11
    //   4234: lstore 17
    //   4236: lload 13
    //   4238: lstore 25
    //   4240: iload 6
    //   4242: istore 8
    //   4244: iload 10
    //   4246: istore 5
    //   4248: iload 9
    //   4250: istore 6
    //   4252: lload 15
    //   4254: lstore 11
    //   4256: lload 23
    //   4258: lstore 13
    //   4260: lload 25
    //   4262: lstore 15
    //   4264: goto -1373 -> 2891
    //   4267: astore 32
    //   4269: iload 5
    //   4271: istore 6
    //   4273: lload 13
    //   4275: lstore 23
    //   4277: lload 11
    //   4279: lstore 25
    //   4281: iconst_0
    //   4282: istore 5
    //   4284: lload 15
    //   4286: lstore 11
    //   4288: lload 17
    //   4290: lstore 13
    //   4292: lload 23
    //   4294: lstore 15
    //   4296: lload 25
    //   4298: lstore 17
    //   4300: goto -1409 -> 2891
    //   4303: astore 32
    //   4305: lload 21
    //   4307: lstore 23
    //   4309: iload 7
    //   4311: istore 8
    //   4313: iload 5
    //   4315: istore 7
    //   4317: iconst_1
    //   4318: istore 5
    //   4320: lload 19
    //   4322: lstore 21
    //   4324: lload 23
    //   4326: lstore 19
    //   4328: goto -1437 -> 2891
    //   4331: astore 32
    //   4333: lload 13
    //   4335: lstore 21
    //   4337: iload 5
    //   4339: istore 6
    //   4341: lload 11
    //   4343: lstore 23
    //   4345: lload 19
    //   4347: lstore 27
    //   4349: lload 15
    //   4351: lstore 11
    //   4353: iload 7
    //   4355: istore 5
    //   4357: lload 17
    //   4359: lstore 13
    //   4361: lload 21
    //   4363: lstore 15
    //   4365: iload 8
    //   4367: istore 7
    //   4369: lload 23
    //   4371: lstore 17
    //   4373: lload 25
    //   4375: lstore 19
    //   4377: lload 27
    //   4379: lstore 21
    //   4381: goto -2432 -> 1949
    //   4384: astore 32
    //   4386: lload 13
    //   4388: lstore 23
    //   4390: iload 5
    //   4392: istore 8
    //   4394: lload 11
    //   4396: lstore 25
    //   4398: iload 6
    //   4400: istore 9
    //   4402: lload 19
    //   4404: lstore 27
    //   4406: lload 15
    //   4408: lstore 11
    //   4410: iload 7
    //   4412: istore 5
    //   4414: lload 17
    //   4416: lstore 13
    //   4418: lload 23
    //   4420: lstore 15
    //   4422: iload 8
    //   4424: istore 6
    //   4426: iload 9
    //   4428: istore 7
    //   4430: lload 25
    //   4432: lstore 17
    //   4434: lload 21
    //   4436: lstore 19
    //   4438: lload 27
    //   4440: lstore 21
    //   4442: goto -2493 -> 1949
    //   4445: astore 32
    //   4447: lload 13
    //   4449: lstore 23
    //   4451: iload 6
    //   4453: istore 7
    //   4455: lload 11
    //   4457: lstore 25
    //   4459: iload 5
    //   4461: istore 6
    //   4463: lload 19
    //   4465: lstore 27
    //   4467: lload 15
    //   4469: lstore 11
    //   4471: iload 8
    //   4473: istore 5
    //   4475: lload 17
    //   4477: lstore 13
    //   4479: lload 23
    //   4481: lstore 15
    //   4483: lload 25
    //   4485: lstore 17
    //   4487: lload 21
    //   4489: lstore 19
    //   4491: lload 27
    //   4493: lstore 21
    //   4495: goto -2546 -> 1949
    //   4498: astore 32
    //   4500: lload 17
    //   4502: lstore 23
    //   4504: iload 6
    //   4506: istore 7
    //   4508: lload 11
    //   4510: lstore 17
    //   4512: lload 13
    //   4514: lstore 27
    //   4516: iload 5
    //   4518: istore 6
    //   4520: lload 19
    //   4522: lstore 25
    //   4524: lload 15
    //   4526: lstore 11
    //   4528: iload 8
    //   4530: istore 5
    //   4532: lload 23
    //   4534: lstore 13
    //   4536: lload 27
    //   4538: lstore 15
    //   4540: lload 21
    //   4542: lstore 19
    //   4544: lload 25
    //   4546: lstore 21
    //   4548: goto -2599 -> 1949
    //   4551: astore 32
    //   4553: iload 6
    //   4555: istore 7
    //   4557: lload 11
    //   4559: lstore 23
    //   4561: lload 13
    //   4563: lstore 27
    //   4565: iload 5
    //   4567: istore 6
    //   4569: lload 19
    //   4571: lstore 25
    //   4573: lload 17
    //   4575: lstore 13
    //   4577: lload 15
    //   4579: lstore 11
    //   4581: iload 8
    //   4583: istore 5
    //   4585: lload 27
    //   4587: lstore 15
    //   4589: lload 23
    //   4591: lstore 17
    //   4593: lload 21
    //   4595: lstore 19
    //   4597: lload 25
    //   4599: lstore 21
    //   4601: goto -2652 -> 1949
    //   4604: astore 32
    //   4606: lload 13
    //   4608: lstore 25
    //   4610: iload 5
    //   4612: istore 6
    //   4614: lload 19
    //   4616: lstore 23
    //   4618: lload 11
    //   4620: lstore 19
    //   4622: lload 15
    //   4624: lstore 11
    //   4626: iload 7
    //   4628: istore 5
    //   4630: lload 17
    //   4632: lstore 13
    //   4634: lload 25
    //   4636: lstore 15
    //   4638: iload 8
    //   4640: istore 7
    //   4642: lload 19
    //   4644: lstore 17
    //   4646: lload 21
    //   4648: lstore 19
    //   4650: lload 23
    //   4652: lstore 21
    //   4654: goto -2705 -> 1949
    //   4657: goto -4214 -> 443
    //   4660: iload 8
    //   4662: sipush 160
    //   4665: iadd
    //   4666: istore 8
    //   4668: goto -4171 -> 497
    //   4671: lload 17
    //   4673: l2i
    //   4674: istore 6
    //   4676: lload 13
    //   4678: lconst_0
    //   4679: lcmp
    //   4680: ifne -2785 -> 1895
    //   4683: ldc2_w 292
    //   4686: lstore 13
    //   4688: goto -3074 -> 1614
    //   4691: lload 13
    //   4693: l2i
    //   4694: istore 6
    //   4696: lload 15
    //   4698: lconst_0
    //   4699: lcmp
    //   4700: ifne -1875 -> 2825
    //   4703: ldc2_w 292
    //   4706: lstore 11
    //   4708: goto -2142 -> 2566
    //   4711: lload 13
    //   4713: l2i
    //   4714: istore 6
    //   4716: lload 15
    //   4718: lconst_0
    //   4719: lcmp
    //   4720: ifne -729 -> 3991
    //   4723: ldc2_w 292
    //   4726: lstore 11
    //   4728: goto -1020 -> 3708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4731	0	this	hds
    //   227	3669	1	d1	double
    //   654	3	3	d2	double
    //   40	4589	5	i	int
    //   134	4581	6	j	int
    //   157	4484	7	k	int
    //   244	4423	8	m	int
    //   354	4073	9	n	int
    //   467	3778	10	i1	int
    //   43	4684	11	l1	long
    //   37	4675	13	l2	long
    //   235	4482	15	l3	long
    //   241	4431	17	l4	long
    //   250	4399	19	l5	long
    //   232	4421	21	l6	long
    //   274	4377	23	l7	long
    //   278	4357	25	l8	long
    //   4347	239	27	l9	long
    //   34	3878	29	l10	long
    //   259	3	31	bool	boolean
    //   140	1688	32	localObject1	java.lang.Object
    //   1853	3	32	localThrowable1	java.lang.Throwable
    //   1863	15	32	localException1	java.lang.Exception
    //   1905	15	32	localException2	java.lang.Exception
    //   1927	131	32	localThrowable2	java.lang.Throwable
    //   2287	493	32	localObject2	java.lang.Object
    //   2805	3	32	localThrowable3	java.lang.Throwable
    //   2835	15	32	localException3	java.lang.Exception
    //   2857	1090	32	localObject3	java.lang.Object
    //   4023	1	32	localObject4	java.lang.Object
    //   4063	1	32	localObject5	java.lang.Object
    //   4111	1	32	localObject6	java.lang.Object
    //   4163	1	32	localObject7	java.lang.Object
    //   4215	1	32	localObject8	java.lang.Object
    //   4267	1	32	localObject9	java.lang.Object
    //   4303	1	32	localObject10	java.lang.Object
    //   4331	1	32	localThrowable4	java.lang.Throwable
    //   4384	1	32	localThrowable5	java.lang.Throwable
    //   4445	1	32	localThrowable6	java.lang.Throwable
    //   4498	1	32	localThrowable7	java.lang.Throwable
    //   4551	1	32	localThrowable8	java.lang.Throwable
    //   4604	1	32	localThrowable9	java.lang.Throwable
    //   79	3843	33	localObject11	java.lang.Object
    //   3949	3	33	localThrowable10	java.lang.Throwable
    //   3959	15	33	localException4	java.lang.Exception
    //   4001	15	33	localException5	java.lang.Exception
    //   670	3112	34	localObject12	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   822	829	1853	java/lang/Throwable
    //   1021	1329	1863	java/lang/Exception
    //   1329	1599	1905	java/lang/Exception
    //   1619	1835	1905	java/lang/Exception
    //   1885	1892	1905	java/lang/Exception
    //   1895	1902	1905	java/lang/Exception
    //   45	74	1927	java/lang/Throwable
    //   74	110	1927	java/lang/Throwable
    //   110	201	1927	java/lang/Throwable
    //   201	223	1927	java/lang/Throwable
    //   2082	2089	2805	java/lang/Throwable
    //   2281	2551	2835	java/lang/Exception
    //   2571	2787	2835	java/lang/Exception
    //   2815	2822	2835	java/lang/Exception
    //   2825	2832	2835	java/lang/Exception
    //   45	74	2857	finally
    //   74	110	2857	finally
    //   110	201	2857	finally
    //   201	223	2857	finally
    //   2911	2918	3949	java/lang/Throwable
    //   3115	3423	3959	java/lang/Exception
    //   3423	3693	4001	java/lang/Exception
    //   3713	3929	4001	java/lang/Exception
    //   3981	3988	4001	java/lang/Exception
    //   3991	3998	4001	java/lang/Exception
    //   280	286	4023	finally
    //   302	307	4023	finally
    //   315	326	4023	finally
    //   334	356	4023	finally
    //   407	413	4023	finally
    //   421	436	4023	finally
    //   451	469	4023	finally
    //   477	486	4023	finally
    //   504	531	4063	finally
    //   531	559	4063	finally
    //   559	586	4063	finally
    //   589	627	4063	finally
    //   627	636	4111	finally
    //   649	655	4163	finally
    //   659	711	4215	finally
    //   711	716	4215	finally
    //   255	261	4267	finally
    //   741	802	4267	finally
    //   1949	1987	4303	finally
    //   1987	2029	4303	finally
    //   2029	2053	4303	finally
    //   2053	2062	4303	finally
    //   280	286	4331	java/lang/Throwable
    //   302	307	4331	java/lang/Throwable
    //   315	326	4331	java/lang/Throwable
    //   334	356	4331	java/lang/Throwable
    //   407	413	4331	java/lang/Throwable
    //   421	436	4331	java/lang/Throwable
    //   451	469	4331	java/lang/Throwable
    //   477	486	4331	java/lang/Throwable
    //   504	531	4384	java/lang/Throwable
    //   531	559	4384	java/lang/Throwable
    //   559	586	4384	java/lang/Throwable
    //   589	627	4384	java/lang/Throwable
    //   627	636	4445	java/lang/Throwable
    //   649	655	4498	java/lang/Throwable
    //   659	711	4551	java/lang/Throwable
    //   711	716	4551	java/lang/Throwable
    //   255	261	4604	java/lang/Throwable
    //   741	802	4604	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hds
 * JD-Core Version:    0.7.0.1
 */