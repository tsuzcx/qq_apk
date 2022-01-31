import com.tencent.mobileqq.utils.QQRecorder;

public class evm
  extends Thread
{
  public volatile boolean a;
  
  public evm(QQRecorder paramQQRecorder, String paramString)
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
    //   31: lconst_0
    //   32: lstore 19
    //   34: lconst_0
    //   35: lstore 17
    //   37: iconst_0
    //   38: istore 5
    //   40: dconst_0
    //   41: dstore_1
    //   42: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   45: lstore 27
    //   47: lconst_0
    //   48: lstore 15
    //   50: lconst_0
    //   51: lstore 13
    //   53: iconst_0
    //   54: istore 6
    //   56: iconst_0
    //   57: istore 10
    //   59: lconst_0
    //   60: lstore 21
    //   62: iconst_0
    //   63: istore 7
    //   65: iconst_0
    //   66: istore 9
    //   68: iconst_0
    //   69: istore 8
    //   71: lconst_0
    //   72: lstore 23
    //   74: aload_0
    //   75: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   78: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   81: ifnull +22 -> 103
    //   84: aload_0
    //   85: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   88: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   91: aload_0
    //   92: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   95: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   98: invokeinterface 72 2 0
    //   103: aload_0
    //   104: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   107: invokestatic 75	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   110: newarray byte
    //   112: astore 32
    //   114: aload_0
    //   115: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   118: invokestatic 78	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   121: aload_0
    //   122: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   125: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   128: ifnull +15 -> 143
    //   131: aload_0
    //   132: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   135: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   138: invokeinterface 80 1 0
    //   143: aload_0
    //   144: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   147: invokestatic 83	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   150: ldc2_w 84
    //   153: invokestatic 89	java/lang/Thread:sleep	(J)V
    //   156: invokestatic 92	com/tencent/mobileqq/utils/QQRecorder:b	()I
    //   159: sipush 1000
    //   162: idiv
    //   163: sipush 250
    //   166: imul
    //   167: istore 11
    //   169: iload 11
    //   171: newarray byte
    //   173: astore 31
    //   175: aload_0
    //   176: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   179: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   182: aload 31
    //   184: iconst_0
    //   185: iload 11
    //   187: invokevirtual 101	android/media/AudioRecord:read	([BII)I
    //   190: istore 12
    //   192: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +39 -> 234
    //   198: ldc 35
    //   200: iconst_2
    //   201: new 37	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   208: ldc 103
    //   210: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload 12
    //   215: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc 108
    //   220: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 11
    //   225: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aload_0
    //   235: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   238: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   241: ifnull +15 -> 256
    //   244: aload_0
    //   245: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   248: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   251: invokeinterface 110 1 0
    //   256: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   259: lstore 29
    //   261: aconst_null
    //   262: astore 31
    //   264: iconst_0
    //   265: istore 5
    //   267: iconst_0
    //   268: istore 11
    //   270: iconst_0
    //   271: istore 6
    //   273: lconst_0
    //   274: lstore 25
    //   276: lconst_0
    //   277: lstore 15
    //   279: dconst_0
    //   280: dstore_1
    //   281: lconst_0
    //   282: lstore 17
    //   284: lconst_0
    //   285: lstore 13
    //   287: iconst_0
    //   288: istore 7
    //   290: aload_0
    //   291: getfield 16	evm:jdField_a_of_type_Boolean	Z
    //   294: ifeq +702 -> 996
    //   297: iload 6
    //   299: istore 9
    //   301: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   304: lload 29
    //   306: lsub
    //   307: ldc2_w 111
    //   310: lcmp
    //   311: ifle +119 -> 430
    //   314: iload 6
    //   316: istore 9
    //   318: iload 6
    //   320: ifne +110 -> 430
    //   323: iconst_1
    //   324: istore 10
    //   326: lload 25
    //   328: lconst_0
    //   329: lcmp
    //   330: ifeq +12 -> 342
    //   333: iload 10
    //   335: istore 9
    //   337: iload 7
    //   339: ifne +91 -> 430
    //   342: aload_0
    //   343: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   346: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   349: ifnull +31 -> 380
    //   352: aload_0
    //   353: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   356: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   359: astore 33
    //   361: lload 25
    //   363: lconst_0
    //   364: lcmp
    //   365: ifne +244 -> 609
    //   368: iconst_0
    //   369: istore 6
    //   371: aload 33
    //   373: iload 6
    //   375: invokeinterface 115 2 0
    //   380: iload 10
    //   382: istore 9
    //   384: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +43 -> 430
    //   390: ldc 35
    //   392: iconst_2
    //   393: new 37	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   400: ldc 117
    //   402: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: lload 25
    //   407: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: ldc 122
    //   412: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: iload 7
    //   417: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: iload 10
    //   428: istore 9
    //   430: iload 11
    //   432: istore 10
    //   434: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   437: lload 29
    //   439: lsub
    //   440: ldc2_w 111
    //   443: lcmp
    //   444: ifle +79 -> 523
    //   447: iload 11
    //   449: istore 10
    //   451: iload 11
    //   453: ifne +70 -> 523
    //   456: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +3974 -> 4433
    //   462: ldc 35
    //   464: iconst_2
    //   465: new 37	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   472: ldc 124
    //   474: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: iload 8
    //   479: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: goto +3945 -> 4433
    //   491: iload 6
    //   493: istore 10
    //   495: aload_0
    //   496: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   499: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   502: ifnull +21 -> 523
    //   505: aload_0
    //   506: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   509: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   512: iload 6
    //   514: invokeinterface 126 2 0
    //   519: iload 6
    //   521: istore 10
    //   523: lload 15
    //   525: lconst_1
    //   526: ladd
    //   527: lstore 19
    //   529: iconst_0
    //   530: istore 11
    //   532: aload 31
    //   534: ifnull +19 -> 553
    //   537: aload 31
    //   539: arraylength
    //   540: istore 11
    //   542: aload 31
    //   544: iconst_0
    //   545: aload 32
    //   547: iconst_0
    //   548: iload 11
    //   550: invokestatic 130	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   553: aload_0
    //   554: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   557: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   560: aload 32
    //   562: iload 11
    //   564: aload_0
    //   565: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   568: invokestatic 75	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   571: iload 11
    //   573: isub
    //   574: invokevirtual 101	android/media/AudioRecord:read	([BII)I
    //   577: istore 6
    //   579: iload 6
    //   581: ifgt +40 -> 621
    //   584: ldc2_w 131
    //   587: invokestatic 89	java/lang/Thread:sleep	(J)V
    //   590: iload 6
    //   592: istore 5
    //   594: lload 19
    //   596: lstore 15
    //   598: iload 9
    //   600: istore 6
    //   602: iload 10
    //   604: istore 11
    //   606: goto -316 -> 290
    //   609: iconst_1
    //   610: istore 6
    //   612: goto -241 -> 371
    //   615: iconst_2
    //   616: istore 6
    //   618: goto -127 -> 491
    //   621: aconst_null
    //   622: astore 31
    //   624: lconst_1
    //   625: lload 13
    //   627: ladd
    //   628: lstore 15
    //   630: lload 25
    //   632: iload 6
    //   634: i2l
    //   635: ladd
    //   636: lstore 13
    //   638: iload 11
    //   640: iload 6
    //   642: iadd
    //   643: istore 11
    //   645: iload 11
    //   647: sipush 160
    //   650: irem
    //   651: istore 6
    //   653: iload 6
    //   655: ifeq +3775 -> 4430
    //   658: iload 6
    //   660: newarray byte
    //   662: astore 31
    //   664: aload 32
    //   666: iload 11
    //   668: iload 6
    //   670: isub
    //   671: aload 31
    //   673: iconst_0
    //   674: iload 6
    //   676: invokestatic 130	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   679: iload 11
    //   681: iload 6
    //   683: isub
    //   684: istore 11
    //   686: aload_0
    //   687: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   690: invokestatic 135	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   693: aload 32
    //   695: iload 11
    //   697: fconst_1
    //   698: invokestatic 140	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   701: l2i
    //   702: istore 12
    //   704: iload 7
    //   706: iload 12
    //   708: invokestatic 146	java/lang/Math:max	(II)I
    //   711: istore 6
    //   713: lload 21
    //   715: iload 12
    //   717: i2l
    //   718: ladd
    //   719: lstore 21
    //   721: iconst_0
    //   722: istore 7
    //   724: iload 7
    //   726: iload 11
    //   728: if_icmpge +14 -> 742
    //   731: iload 7
    //   733: sipush 160
    //   736: iadd
    //   737: istore 7
    //   739: goto -15 -> 724
    //   742: aload_0
    //   743: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   746: aload_0
    //   747: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   750: invokestatic 135	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   753: aload 32
    //   755: iload 11
    //   757: fconst_1
    //   758: invokestatic 140	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   761: l2i
    //   762: invokestatic 149	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;I)I
    //   765: pop
    //   766: iload 8
    //   768: aload_0
    //   769: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   772: invokestatic 151	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   775: invokestatic 146	java/lang/Math:max	(II)I
    //   778: istore 7
    //   780: aload_0
    //   781: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   784: invokestatic 151	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   787: istore 8
    //   789: lload 23
    //   791: iload 8
    //   793: i2l
    //   794: ladd
    //   795: lstore 23
    //   797: iload 11
    //   799: i2l
    //   800: lstore 25
    //   802: lload 25
    //   804: invokestatic 154	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   807: dstore_3
    //   808: dload_1
    //   809: dload_3
    //   810: dadd
    //   811: dstore_1
    //   812: aload_0
    //   813: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   816: aload 32
    //   818: iload 11
    //   820: invokestatic 157	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;[BI)[B
    //   823: astore 33
    //   825: aload_0
    //   826: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   829: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   832: ifnull +32 -> 864
    //   835: aload_0
    //   836: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   839: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   842: aload_0
    //   843: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   846: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   849: aload 33
    //   851: aload_0
    //   852: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   855: invokestatic 151	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   858: dload_1
    //   859: invokeinterface 160 6 0
    //   864: aload 33
    //   866: arraylength
    //   867: istore 8
    //   869: lload 17
    //   871: iload 8
    //   873: i2l
    //   874: ladd
    //   875: lstore 17
    //   877: iload 10
    //   879: iconst_1
    //   880: if_icmpne +3543 -> 4423
    //   883: iload 7
    //   885: sipush 500
    //   888: if_icmple +3535 -> 4423
    //   891: iconst_2
    //   892: istore 10
    //   894: aload_0
    //   895: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   898: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   901: ifnull +16 -> 917
    //   904: aload_0
    //   905: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   908: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   911: iconst_2
    //   912: invokeinterface 126 2 0
    //   917: iload 10
    //   919: istore 8
    //   921: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   924: ifeq +33 -> 957
    //   927: ldc 35
    //   929: iconst_2
    //   930: new 37	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   937: ldc 162
    //   939: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: iload 7
    //   944: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   947: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   953: iload 10
    //   955: istore 8
    //   957: iload 8
    //   959: istore 11
    //   961: iload 9
    //   963: istore 8
    //   965: iload 6
    //   967: istore 9
    //   969: lload 13
    //   971: lstore 25
    //   973: iload 8
    //   975: istore 6
    //   977: iload 7
    //   979: istore 8
    //   981: iload 9
    //   983: istore 7
    //   985: lload 15
    //   987: lstore 13
    //   989: lload 19
    //   991: lstore 15
    //   993: goto -703 -> 290
    //   996: aload_0
    //   997: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1000: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1003: ifnull +54 -> 1057
    //   1006: aload_0
    //   1007: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1010: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1013: aload_0
    //   1014: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1017: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   1020: invokeinterface 164 2 0
    //   1025: aload_0
    //   1026: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1029: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1032: ifnull +25 -> 1057
    //   1035: aload_0
    //   1036: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1039: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1042: iconst_m1
    //   1043: if_icmpeq +14 -> 1057
    //   1046: aload_0
    //   1047: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1050: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1053: iconst_0
    //   1054: invokevirtual 175	android/media/AudioManager:setMode	(I)V
    //   1057: aload_0
    //   1058: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1061: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1064: ifnull +13 -> 1077
    //   1067: aload_0
    //   1068: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1071: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1074: invokevirtual 178	android/media/AudioRecord:release	()V
    //   1077: aload_0
    //   1078: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1081: invokestatic 180	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   1084: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +172 -> 1259
    //   1090: ldc 35
    //   1092: iconst_2
    //   1093: new 37	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1100: ldc 182
    //   1102: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: aload_0
    //   1106: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: ldc 35
    //   1117: iconst_2
    //   1118: new 37	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1125: ldc 184
    //   1127: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: lload 15
    //   1132: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1135: ldc 186
    //   1137: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: lload 25
    //   1142: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1145: ldc 188
    //   1147: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: lload 17
    //   1152: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1155: ldc 190
    //   1157: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: iload 5
    //   1162: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1165: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1168: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1171: ldc 35
    //   1173: new 37	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1180: ldc 192
    //   1182: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: dload_1
    //   1186: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1189: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1192: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1195: pop
    //   1196: ldc 35
    //   1198: new 37	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1205: ldc 202
    //   1207: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: lload 25
    //   1212: invokestatic 154	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   1215: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1218: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1221: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1224: pop
    //   1225: ldc 35
    //   1227: new 37	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1234: ldc 204
    //   1236: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload_0
    //   1240: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1243: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   1246: invokestatic 207	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   1249: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1258: pop
    //   1259: lload 17
    //   1261: ldc2_w 208
    //   1264: lcmp
    //   1265: iflt +11 -> 1276
    //   1268: dload_1
    //   1269: ldc2_w 210
    //   1272: dcmpg
    //   1273: ifge +263 -> 1536
    //   1276: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1279: lload 27
    //   1281: lsub
    //   1282: ldc2_w 111
    //   1285: lcmp
    //   1286: ifle +250 -> 1536
    //   1289: new 213	java/util/HashMap
    //   1292: dup
    //   1293: invokespecial 214	java/util/HashMap:<init>	()V
    //   1296: astore 31
    //   1298: aload 31
    //   1300: ldc 216
    //   1302: ldc 218
    //   1304: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1307: pop
    //   1308: aload 31
    //   1310: ldc 224
    //   1312: new 37	java/lang/StringBuilder
    //   1315: dup
    //   1316: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1319: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   1322: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1325: ldc 232
    //   1327: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1336: pop
    //   1337: aload 31
    //   1339: ldc 234
    //   1341: new 37	java/lang/StringBuilder
    //   1344: dup
    //   1345: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1348: getstatic 240	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1351: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: ldc 242
    //   1356: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: getstatic 245	android/os/Build:MODEL	Ljava/lang/String;
    //   1362: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1368: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1371: pop
    //   1372: aload 31
    //   1374: ldc 247
    //   1376: new 37	java/lang/StringBuilder
    //   1379: dup
    //   1380: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1383: lload 25
    //   1385: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1388: ldc 232
    //   1390: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1396: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1399: pop
    //   1400: aload 31
    //   1402: ldc 249
    //   1404: new 37	java/lang/StringBuilder
    //   1407: dup
    //   1408: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1411: dload_1
    //   1412: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1415: ldc 232
    //   1417: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1423: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1426: pop
    //   1427: aload 31
    //   1429: ldc 251
    //   1431: new 37	java/lang/StringBuilder
    //   1434: dup
    //   1435: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1438: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1441: lload 27
    //   1443: lsub
    //   1444: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1447: ldc 232
    //   1449: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1458: pop
    //   1459: ldc 253
    //   1461: iconst_0
    //   1462: aload 31
    //   1464: invokestatic 256	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1467: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1470: ifeq +66 -> 1536
    //   1473: ldc 35
    //   1475: iconst_2
    //   1476: new 37	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1483: ldc_w 258
    //   1486: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: lload 25
    //   1491: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1494: ldc_w 260
    //   1497: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: lload 17
    //   1502: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1505: ldc_w 262
    //   1508: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: dload_1
    //   1512: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1515: ldc_w 264
    //   1518: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1524: lload 27
    //   1526: lsub
    //   1527: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1530: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1533: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1536: new 213	java/util/HashMap
    //   1539: dup
    //   1540: invokespecial 214	java/util/HashMap:<init>	()V
    //   1543: astore 31
    //   1545: aload 31
    //   1547: ldc 224
    //   1549: new 37	java/lang/StringBuilder
    //   1552: dup
    //   1553: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1556: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   1559: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1562: ldc 232
    //   1564: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1573: pop
    //   1574: aload 31
    //   1576: ldc 234
    //   1578: new 37	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1585: getstatic 240	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1588: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: ldc 242
    //   1593: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: getstatic 245	android/os/Build:MODEL	Ljava/lang/String;
    //   1599: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1608: pop
    //   1609: aload 31
    //   1611: ldc 247
    //   1613: new 37	java/lang/StringBuilder
    //   1616: dup
    //   1617: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1620: lload 25
    //   1622: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1625: ldc 232
    //   1627: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1633: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1636: pop
    //   1637: aload 31
    //   1639: ldc_w 266
    //   1642: new 37	java/lang/StringBuilder
    //   1645: dup
    //   1646: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1649: dload_1
    //   1650: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1653: ldc 232
    //   1655: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1664: pop
    //   1665: aload 31
    //   1667: ldc 251
    //   1669: new 37	java/lang/StringBuilder
    //   1672: dup
    //   1673: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1676: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1679: lload 27
    //   1681: lsub
    //   1682: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1685: ldc 232
    //   1687: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1693: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1696: pop
    //   1697: aload 31
    //   1699: ldc_w 268
    //   1702: new 37	java/lang/StringBuilder
    //   1705: dup
    //   1706: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1709: iload 7
    //   1711: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1714: ldc 232
    //   1716: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1722: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1725: pop
    //   1726: aload 31
    //   1728: ldc_w 270
    //   1731: new 37	java/lang/StringBuilder
    //   1734: dup
    //   1735: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1738: iload 8
    //   1740: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1743: ldc 232
    //   1745: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1751: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1754: pop
    //   1755: lload 13
    //   1757: lconst_0
    //   1758: lcmp
    //   1759: ifne +274 -> 2033
    //   1762: ldc2_w 271
    //   1765: lstore 15
    //   1767: goto +2685 -> 4452
    //   1770: lload 13
    //   1772: l2i
    //   1773: istore 5
    //   1775: aload 31
    //   1777: ldc_w 274
    //   1780: new 37	java/lang/StringBuilder
    //   1783: dup
    //   1784: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1787: iload 6
    //   1789: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1792: ldc 232
    //   1794: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1803: pop
    //   1804: aload 31
    //   1806: ldc_w 276
    //   1809: new 37	java/lang/StringBuilder
    //   1812: dup
    //   1813: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1816: iload 5
    //   1818: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1821: ldc 232
    //   1823: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1829: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1832: pop
    //   1833: ldc_w 278
    //   1836: iconst_1
    //   1837: aload 31
    //   1839: invokestatic 256	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1842: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1845: ifeq +138 -> 1983
    //   1848: new 37	java/lang/StringBuilder
    //   1851: dup
    //   1852: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   1855: astore 31
    //   1857: aload 31
    //   1859: ldc_w 280
    //   1862: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: iload 7
    //   1867: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload 31
    //   1873: ldc_w 282
    //   1876: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: iload 6
    //   1881: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1884: pop
    //   1885: aload 31
    //   1887: ldc_w 284
    //   1890: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1893: iload 5
    //   1895: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1898: pop
    //   1899: aload 31
    //   1901: ldc_w 286
    //   1904: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: iload 5
    //   1909: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1912: pop
    //   1913: aload 31
    //   1915: ldc_w 288
    //   1918: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: lload 25
    //   1923: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1926: pop
    //   1927: aload 31
    //   1929: ldc_w 290
    //   1932: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: lload 17
    //   1937: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1940: pop
    //   1941: aload 31
    //   1943: ldc_w 292
    //   1946: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: dload_1
    //   1950: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1953: pop
    //   1954: aload 31
    //   1956: ldc_w 294
    //   1959: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1965: lload 27
    //   1967: lsub
    //   1968: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1971: pop
    //   1972: ldc 35
    //   1974: iconst_2
    //   1975: aload 31
    //   1977: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1980: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1983: aload_0
    //   1984: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1987: aconst_null
    //   1988: putfield 297	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Evm	Levm;
    //   1991: aload_0
    //   1992: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1995: aconst_null
    //   1996: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   1999: pop
    //   2000: return
    //   2001: astore 31
    //   2003: aload 31
    //   2005: invokevirtual 300	java/lang/Throwable:printStackTrace	()V
    //   2008: goto -924 -> 1084
    //   2011: astore 31
    //   2013: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2016: ifeq -480 -> 1536
    //   2019: ldc 35
    //   2021: iconst_2
    //   2022: ldc_w 302
    //   2025: aload 31
    //   2027: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2030: goto -494 -> 1536
    //   2033: lload 21
    //   2035: lload 13
    //   2037: ldiv
    //   2038: lstore 15
    //   2040: goto +2412 -> 4452
    //   2043: lload 23
    //   2045: lload 13
    //   2047: ldiv
    //   2048: lstore 13
    //   2050: goto -280 -> 1770
    //   2053: astore 31
    //   2055: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2058: ifeq -75 -> 1983
    //   2061: ldc 35
    //   2063: iconst_2
    //   2064: ldc_w 307
    //   2067: aload 31
    //   2069: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2072: goto -89 -> 1983
    //   2075: astore 31
    //   2077: iload 10
    //   2079: istore 6
    //   2081: iload 7
    //   2083: istore 8
    //   2085: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2088: ifeq +35 -> 2123
    //   2091: ldc 35
    //   2093: iconst_2
    //   2094: new 37	java/lang/StringBuilder
    //   2097: dup
    //   2098: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2101: ldc_w 309
    //   2104: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: aload 31
    //   2109: invokestatic 313	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2112: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2115: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2118: aload 31
    //   2120: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2123: aload_0
    //   2124: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2127: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2130: ifnull +59 -> 2189
    //   2133: aload_0
    //   2134: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2137: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2140: ifnull +25 -> 2165
    //   2143: aload_0
    //   2144: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2147: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   2150: iconst_m1
    //   2151: if_icmpeq +14 -> 2165
    //   2154: aload_0
    //   2155: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2158: getfield 167	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   2161: iconst_0
    //   2162: invokevirtual 175	android/media/AudioManager:setMode	(I)V
    //   2165: aload_0
    //   2166: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2169: invokestatic 64	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2172: aload_0
    //   2173: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2176: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2179: aload 31
    //   2181: invokevirtual 316	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2184: invokeinterface 319 3 0
    //   2189: aload_0
    //   2190: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2193: aload 31
    //   2195: invokevirtual 322	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   2198: aload_0
    //   2199: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2202: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2205: ifnull +13 -> 2218
    //   2208: aload_0
    //   2209: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2212: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2215: invokevirtual 178	android/media/AudioRecord:release	()V
    //   2218: aload_0
    //   2219: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2222: invokestatic 180	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2225: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2228: ifeq +172 -> 2400
    //   2231: ldc 35
    //   2233: iconst_2
    //   2234: new 37	java/lang/StringBuilder
    //   2237: dup
    //   2238: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2241: ldc 182
    //   2243: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: aload_0
    //   2247: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2250: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2253: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2256: ldc 35
    //   2258: iconst_2
    //   2259: new 37	java/lang/StringBuilder
    //   2262: dup
    //   2263: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2266: ldc 184
    //   2268: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: lload 19
    //   2273: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2276: ldc 186
    //   2278: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: lload 17
    //   2283: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2286: ldc 188
    //   2288: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: lload 15
    //   2293: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2296: ldc 190
    //   2298: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2301: iload 5
    //   2303: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2306: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2309: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2312: ldc 35
    //   2314: new 37	java/lang/StringBuilder
    //   2317: dup
    //   2318: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2321: ldc 192
    //   2323: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: dload_1
    //   2327: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2330: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2333: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2336: pop
    //   2337: ldc 35
    //   2339: new 37	java/lang/StringBuilder
    //   2342: dup
    //   2343: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2346: ldc 202
    //   2348: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2351: lload 17
    //   2353: invokestatic 154	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   2356: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2359: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2362: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2365: pop
    //   2366: ldc 35
    //   2368: new 37	java/lang/StringBuilder
    //   2371: dup
    //   2372: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2375: ldc 204
    //   2377: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: aload_0
    //   2381: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2384: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2387: invokestatic 207	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   2390: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2393: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2396: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   2399: pop
    //   2400: lload 15
    //   2402: ldc2_w 208
    //   2405: lcmp
    //   2406: iflt +11 -> 2417
    //   2409: dload_1
    //   2410: ldc2_w 210
    //   2413: dcmpg
    //   2414: ifge +3 -> 2417
    //   2417: new 213	java/util/HashMap
    //   2420: dup
    //   2421: invokespecial 214	java/util/HashMap:<init>	()V
    //   2424: astore 31
    //   2426: aload 31
    //   2428: ldc 224
    //   2430: new 37	java/lang/StringBuilder
    //   2433: dup
    //   2434: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2437: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   2440: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2443: ldc 232
    //   2445: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2451: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2454: pop
    //   2455: aload 31
    //   2457: ldc 234
    //   2459: new 37	java/lang/StringBuilder
    //   2462: dup
    //   2463: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2466: getstatic 240	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2469: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2472: ldc 242
    //   2474: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: getstatic 245	android/os/Build:MODEL	Ljava/lang/String;
    //   2480: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2486: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2489: pop
    //   2490: aload 31
    //   2492: ldc 247
    //   2494: new 37	java/lang/StringBuilder
    //   2497: dup
    //   2498: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2501: lload 17
    //   2503: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2506: ldc 232
    //   2508: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2511: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2514: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2517: pop
    //   2518: aload 31
    //   2520: ldc_w 266
    //   2523: new 37	java/lang/StringBuilder
    //   2526: dup
    //   2527: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2530: dload_1
    //   2531: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2534: ldc 232
    //   2536: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2539: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2542: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2545: pop
    //   2546: aload 31
    //   2548: ldc 251
    //   2550: new 37	java/lang/StringBuilder
    //   2553: dup
    //   2554: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2557: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2560: lload 27
    //   2562: lsub
    //   2563: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2566: ldc 232
    //   2568: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2574: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2577: pop
    //   2578: aload 31
    //   2580: ldc_w 268
    //   2583: new 37	java/lang/StringBuilder
    //   2586: dup
    //   2587: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2590: iload 6
    //   2592: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2595: ldc 232
    //   2597: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2600: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2603: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2606: pop
    //   2607: aload 31
    //   2609: ldc_w 270
    //   2612: new 37	java/lang/StringBuilder
    //   2615: dup
    //   2616: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2619: iload 8
    //   2621: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2624: ldc 232
    //   2626: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2632: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2635: pop
    //   2636: lload 13
    //   2638: lconst_0
    //   2639: lcmp
    //   2640: ifne +252 -> 2892
    //   2643: ldc2_w 271
    //   2646: lstore 19
    //   2648: goto +1824 -> 4472
    //   2651: lload 13
    //   2653: l2i
    //   2654: istore 5
    //   2656: aload 31
    //   2658: ldc_w 274
    //   2661: new 37	java/lang/StringBuilder
    //   2664: dup
    //   2665: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2668: iload 7
    //   2670: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2673: ldc 232
    //   2675: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2678: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2681: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2684: pop
    //   2685: aload 31
    //   2687: ldc_w 276
    //   2690: new 37	java/lang/StringBuilder
    //   2693: dup
    //   2694: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2697: iload 5
    //   2699: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2702: ldc 232
    //   2704: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2710: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2713: pop
    //   2714: ldc_w 278
    //   2717: iconst_1
    //   2718: aload 31
    //   2720: invokestatic 256	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2723: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2726: ifeq +138 -> 2864
    //   2729: new 37	java/lang/StringBuilder
    //   2732: dup
    //   2733: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   2736: astore 31
    //   2738: aload 31
    //   2740: ldc_w 280
    //   2743: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2746: iload 6
    //   2748: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2751: pop
    //   2752: aload 31
    //   2754: ldc_w 282
    //   2757: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2760: iload 7
    //   2762: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2765: pop
    //   2766: aload 31
    //   2768: ldc_w 284
    //   2771: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2774: iload 5
    //   2776: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2779: pop
    //   2780: aload 31
    //   2782: ldc_w 286
    //   2785: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2788: iload 5
    //   2790: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2793: pop
    //   2794: aload 31
    //   2796: ldc_w 288
    //   2799: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2802: lload 17
    //   2804: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2807: pop
    //   2808: aload 31
    //   2810: ldc_w 290
    //   2813: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: lload 15
    //   2818: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2821: pop
    //   2822: aload 31
    //   2824: ldc_w 292
    //   2827: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2830: dload_1
    //   2831: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2834: pop
    //   2835: aload 31
    //   2837: ldc_w 294
    //   2840: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2843: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   2846: lload 27
    //   2848: lsub
    //   2849: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2852: pop
    //   2853: ldc 35
    //   2855: iconst_2
    //   2856: aload 31
    //   2858: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2861: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2864: aload_0
    //   2865: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2868: aconst_null
    //   2869: putfield 297	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Evm	Levm;
    //   2872: aload_0
    //   2873: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2876: aconst_null
    //   2877: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   2880: pop
    //   2881: return
    //   2882: astore 31
    //   2884: aload 31
    //   2886: invokevirtual 300	java/lang/Throwable:printStackTrace	()V
    //   2889: goto -664 -> 2225
    //   2892: lload 21
    //   2894: lload 13
    //   2896: ldiv
    //   2897: lstore 19
    //   2899: goto +1573 -> 4472
    //   2902: lload 23
    //   2904: lload 13
    //   2906: ldiv
    //   2907: lstore 13
    //   2909: goto -258 -> 2651
    //   2912: astore 31
    //   2914: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2917: ifeq -53 -> 2864
    //   2920: ldc 35
    //   2922: iconst_2
    //   2923: ldc_w 307
    //   2926: aload 31
    //   2928: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2931: goto -67 -> 2864
    //   2934: astore 31
    //   2936: iconst_0
    //   2937: istore 5
    //   2939: lconst_0
    //   2940: lstore 19
    //   2942: dconst_0
    //   2943: dstore_1
    //   2944: lconst_0
    //   2945: lstore 15
    //   2947: lconst_0
    //   2948: lstore 17
    //   2950: iconst_0
    //   2951: istore 7
    //   2953: iload 9
    //   2955: istore 8
    //   2957: aload_0
    //   2958: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2961: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2964: ifnull +13 -> 2977
    //   2967: aload_0
    //   2968: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2971: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2974: invokevirtual 178	android/media/AudioRecord:release	()V
    //   2977: aload_0
    //   2978: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2981: invokestatic 180	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2984: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2987: ifeq +172 -> 3159
    //   2990: ldc 35
    //   2992: iconst_2
    //   2993: new 37	java/lang/StringBuilder
    //   2996: dup
    //   2997: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3000: ldc 182
    //   3002: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3005: aload_0
    //   3006: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3009: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3012: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3015: ldc 35
    //   3017: iconst_2
    //   3018: new 37	java/lang/StringBuilder
    //   3021: dup
    //   3022: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3025: ldc 184
    //   3027: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3030: lload 19
    //   3032: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3035: ldc 186
    //   3037: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3040: lload 15
    //   3042: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3045: ldc 188
    //   3047: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3050: lload 17
    //   3052: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3055: ldc 190
    //   3057: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3060: iload 5
    //   3062: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3065: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3068: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3071: ldc 35
    //   3073: new 37	java/lang/StringBuilder
    //   3076: dup
    //   3077: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3080: ldc 192
    //   3082: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3085: dload_1
    //   3086: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3089: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3092: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3095: pop
    //   3096: ldc 35
    //   3098: new 37	java/lang/StringBuilder
    //   3101: dup
    //   3102: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3105: ldc 202
    //   3107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: lload 15
    //   3112: invokestatic 154	com/tencent/mobileqq/utils/QQRecorder:a	(J)D
    //   3115: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3118: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3121: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3124: pop
    //   3125: ldc 35
    //   3127: new 37	java/lang/StringBuilder
    //   3130: dup
    //   3131: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3134: ldc 204
    //   3136: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3139: aload_0
    //   3140: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3143: invokestatic 67	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   3146: invokestatic 207	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;)I
    //   3149: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3152: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3155: invokestatic 200	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3158: pop
    //   3159: lload 17
    //   3161: ldc2_w 208
    //   3164: lcmp
    //   3165: iflt +11 -> 3176
    //   3168: dload_1
    //   3169: ldc2_w 210
    //   3172: dcmpg
    //   3173: ifge +268 -> 3441
    //   3176: iload 7
    //   3178: ifne +263 -> 3441
    //   3181: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3184: lload 27
    //   3186: lsub
    //   3187: ldc2_w 111
    //   3190: lcmp
    //   3191: ifle +250 -> 3441
    //   3194: new 213	java/util/HashMap
    //   3197: dup
    //   3198: invokespecial 214	java/util/HashMap:<init>	()V
    //   3201: astore 32
    //   3203: aload 32
    //   3205: ldc 216
    //   3207: ldc 218
    //   3209: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3212: pop
    //   3213: aload 32
    //   3215: ldc 224
    //   3217: new 37	java/lang/StringBuilder
    //   3220: dup
    //   3221: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3224: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   3227: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3230: ldc 232
    //   3232: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3235: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3238: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3241: pop
    //   3242: aload 32
    //   3244: ldc 234
    //   3246: new 37	java/lang/StringBuilder
    //   3249: dup
    //   3250: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3253: getstatic 240	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3256: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3259: ldc 242
    //   3261: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3264: getstatic 245	android/os/Build:MODEL	Ljava/lang/String;
    //   3267: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3270: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3273: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3276: pop
    //   3277: aload 32
    //   3279: ldc 247
    //   3281: new 37	java/lang/StringBuilder
    //   3284: dup
    //   3285: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3288: lload 15
    //   3290: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3293: ldc 232
    //   3295: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3301: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3304: pop
    //   3305: aload 32
    //   3307: ldc 249
    //   3309: new 37	java/lang/StringBuilder
    //   3312: dup
    //   3313: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3316: dload_1
    //   3317: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3320: ldc 232
    //   3322: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3325: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3328: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3331: pop
    //   3332: aload 32
    //   3334: ldc 251
    //   3336: new 37	java/lang/StringBuilder
    //   3339: dup
    //   3340: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3343: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3346: lload 27
    //   3348: lsub
    //   3349: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3352: ldc 232
    //   3354: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3357: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3360: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3363: pop
    //   3364: ldc 253
    //   3366: iconst_0
    //   3367: aload 32
    //   3369: invokestatic 256	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3372: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3375: ifeq +66 -> 3441
    //   3378: ldc 35
    //   3380: iconst_2
    //   3381: new 37	java/lang/StringBuilder
    //   3384: dup
    //   3385: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3388: ldc_w 258
    //   3391: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3394: lload 15
    //   3396: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3399: ldc_w 260
    //   3402: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3405: lload 17
    //   3407: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3410: ldc_w 262
    //   3413: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3416: dload_1
    //   3417: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3420: ldc_w 264
    //   3423: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3429: lload 27
    //   3431: lsub
    //   3432: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3435: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3438: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3441: new 213	java/util/HashMap
    //   3444: dup
    //   3445: invokespecial 214	java/util/HashMap:<init>	()V
    //   3448: astore 32
    //   3450: aload 32
    //   3452: ldc 224
    //   3454: new 37	java/lang/StringBuilder
    //   3457: dup
    //   3458: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3461: getstatic 230	android/os/Build$VERSION:SDK_INT	I
    //   3464: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3467: ldc 232
    //   3469: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3472: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3475: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3478: pop
    //   3479: aload 32
    //   3481: ldc 234
    //   3483: new 37	java/lang/StringBuilder
    //   3486: dup
    //   3487: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3490: getstatic 240	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3493: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3496: ldc 242
    //   3498: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3501: getstatic 245	android/os/Build:MODEL	Ljava/lang/String;
    //   3504: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3507: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3510: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3513: pop
    //   3514: aload 32
    //   3516: ldc 247
    //   3518: new 37	java/lang/StringBuilder
    //   3521: dup
    //   3522: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3525: lload 15
    //   3527: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3530: ldc 232
    //   3532: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3535: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3538: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3541: pop
    //   3542: aload 32
    //   3544: ldc_w 266
    //   3547: new 37	java/lang/StringBuilder
    //   3550: dup
    //   3551: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3554: dload_1
    //   3555: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3558: ldc 232
    //   3560: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3563: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3566: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3569: pop
    //   3570: aload 32
    //   3572: ldc 251
    //   3574: new 37	java/lang/StringBuilder
    //   3577: dup
    //   3578: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3581: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3584: lload 27
    //   3586: lsub
    //   3587: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3590: ldc 232
    //   3592: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3598: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3601: pop
    //   3602: aload 32
    //   3604: ldc_w 268
    //   3607: new 37	java/lang/StringBuilder
    //   3610: dup
    //   3611: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3614: iload 6
    //   3616: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3619: ldc 232
    //   3621: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3624: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3627: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3630: pop
    //   3631: aload 32
    //   3633: ldc_w 270
    //   3636: new 37	java/lang/StringBuilder
    //   3639: dup
    //   3640: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3643: iload 8
    //   3645: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3648: ldc 232
    //   3650: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3653: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3656: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3659: pop
    //   3660: lload 13
    //   3662: lconst_0
    //   3663: lcmp
    //   3664: ifne +276 -> 3940
    //   3667: ldc2_w 271
    //   3670: lstore 19
    //   3672: goto +820 -> 4492
    //   3675: lload 13
    //   3677: l2i
    //   3678: istore 5
    //   3680: aload 32
    //   3682: ldc_w 274
    //   3685: new 37	java/lang/StringBuilder
    //   3688: dup
    //   3689: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3692: iload 7
    //   3694: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3697: ldc 232
    //   3699: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3702: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3705: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3708: pop
    //   3709: aload 32
    //   3711: ldc_w 276
    //   3714: new 37	java/lang/StringBuilder
    //   3717: dup
    //   3718: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3721: iload 5
    //   3723: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3726: ldc 232
    //   3728: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3731: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3734: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3737: pop
    //   3738: ldc_w 278
    //   3741: iconst_1
    //   3742: aload 32
    //   3744: invokestatic 256	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3747: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3750: ifeq +138 -> 3888
    //   3753: new 37	java/lang/StringBuilder
    //   3756: dup
    //   3757: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   3760: astore 32
    //   3762: aload 32
    //   3764: ldc_w 280
    //   3767: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: iload 6
    //   3772: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3775: pop
    //   3776: aload 32
    //   3778: ldc_w 282
    //   3781: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3784: iload 7
    //   3786: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3789: pop
    //   3790: aload 32
    //   3792: ldc_w 284
    //   3795: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3798: iload 5
    //   3800: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3803: pop
    //   3804: aload 32
    //   3806: ldc_w 286
    //   3809: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3812: iload 5
    //   3814: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3817: pop
    //   3818: aload 32
    //   3820: ldc_w 288
    //   3823: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3826: lload 15
    //   3828: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3831: pop
    //   3832: aload 32
    //   3834: ldc_w 290
    //   3837: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: lload 17
    //   3842: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3845: pop
    //   3846: aload 32
    //   3848: ldc_w 292
    //   3851: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3854: dload_1
    //   3855: invokevirtual 195	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3858: pop
    //   3859: aload 32
    //   3861: ldc_w 294
    //   3864: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3870: lload 27
    //   3872: lsub
    //   3873: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3876: pop
    //   3877: ldc 35
    //   3879: iconst_2
    //   3880: aload 32
    //   3882: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3885: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3888: aload_0
    //   3889: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3892: aconst_null
    //   3893: putfield 297	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Evm	Levm;
    //   3896: aload_0
    //   3897: getfield 11	evm:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3900: aconst_null
    //   3901: invokestatic 21	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   3904: pop
    //   3905: aload 31
    //   3907: athrow
    //   3908: astore 32
    //   3910: aload 32
    //   3912: invokevirtual 300	java/lang/Throwable:printStackTrace	()V
    //   3915: goto -931 -> 2984
    //   3918: astore 32
    //   3920: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3923: ifeq -482 -> 3441
    //   3926: ldc 35
    //   3928: iconst_2
    //   3929: ldc_w 302
    //   3932: aload 32
    //   3934: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3937: goto -496 -> 3441
    //   3940: lload 21
    //   3942: lload 13
    //   3944: ldiv
    //   3945: lstore 19
    //   3947: goto +545 -> 4492
    //   3950: lload 23
    //   3952: lload 13
    //   3954: ldiv
    //   3955: lstore 13
    //   3957: goto -282 -> 3675
    //   3960: astore 32
    //   3962: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3965: ifeq -77 -> 3888
    //   3968: ldc 35
    //   3970: iconst_2
    //   3971: ldc_w 307
    //   3974: aload 32
    //   3976: invokestatic 305	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3979: goto -91 -> 3888
    //   3982: astore 31
    //   3984: iload 7
    //   3986: istore 6
    //   3988: iconst_0
    //   3989: istore 7
    //   3991: lload 13
    //   3993: lstore 25
    //   3995: lload 15
    //   3997: lstore 13
    //   3999: lload 25
    //   4001: lstore 15
    //   4003: goto -1046 -> 2957
    //   4006: astore 31
    //   4008: iconst_0
    //   4009: istore 7
    //   4011: lload 13
    //   4013: lstore 25
    //   4015: lload 15
    //   4017: lstore 13
    //   4019: lload 25
    //   4021: lstore 15
    //   4023: goto -1066 -> 2957
    //   4026: astore 31
    //   4028: iconst_0
    //   4029: istore 9
    //   4031: lload 13
    //   4033: lstore 25
    //   4035: iload 7
    //   4037: istore 8
    //   4039: lload 15
    //   4041: lstore 13
    //   4043: iload 9
    //   4045: istore 7
    //   4047: lload 25
    //   4049: lstore 15
    //   4051: goto -1094 -> 2957
    //   4054: astore 31
    //   4056: iconst_0
    //   4057: istore 9
    //   4059: lload 13
    //   4061: lstore 25
    //   4063: iload 7
    //   4065: istore 8
    //   4067: lload 15
    //   4069: lstore 13
    //   4071: iload 9
    //   4073: istore 7
    //   4075: lload 25
    //   4077: lstore 15
    //   4079: goto -1122 -> 2957
    //   4082: astore 31
    //   4084: iconst_0
    //   4085: istore 9
    //   4087: lload 13
    //   4089: lstore 25
    //   4091: iload 7
    //   4093: istore 8
    //   4095: lload 15
    //   4097: lstore 13
    //   4099: iload 9
    //   4101: istore 7
    //   4103: lload 25
    //   4105: lstore 15
    //   4107: goto -1150 -> 2957
    //   4110: astore 31
    //   4112: iconst_0
    //   4113: istore 9
    //   4115: lload 13
    //   4117: lstore 25
    //   4119: iload 7
    //   4121: istore 8
    //   4123: lload 15
    //   4125: lstore 13
    //   4127: iload 9
    //   4129: istore 7
    //   4131: lload 25
    //   4133: lstore 15
    //   4135: goto -1178 -> 2957
    //   4138: astore 31
    //   4140: iload 7
    //   4142: istore 6
    //   4144: lload 15
    //   4146: lstore 19
    //   4148: iconst_0
    //   4149: istore 7
    //   4151: lload 25
    //   4153: lstore 15
    //   4155: goto -1198 -> 2957
    //   4158: astore 31
    //   4160: iload 7
    //   4162: istore 6
    //   4164: iconst_0
    //   4165: istore 7
    //   4167: lload 25
    //   4169: lstore 15
    //   4171: goto -1214 -> 2957
    //   4174: astore 31
    //   4176: iload 6
    //   4178: istore 5
    //   4180: iconst_0
    //   4181: istore 9
    //   4183: iload 7
    //   4185: istore 6
    //   4187: iload 9
    //   4189: istore 7
    //   4191: lload 25
    //   4193: lstore 15
    //   4195: goto -1238 -> 2957
    //   4198: astore 31
    //   4200: lload 15
    //   4202: lstore 25
    //   4204: iconst_1
    //   4205: istore 7
    //   4207: lload 17
    //   4209: lstore 15
    //   4211: lload 25
    //   4213: lstore 17
    //   4215: goto -1258 -> 2957
    //   4218: astore 31
    //   4220: iload 7
    //   4222: istore 6
    //   4224: lload 13
    //   4226: lstore 25
    //   4228: lload 15
    //   4230: lstore 13
    //   4232: lload 17
    //   4234: lstore 15
    //   4236: lload 25
    //   4238: lstore 17
    //   4240: goto -2155 -> 2085
    //   4243: astore 31
    //   4245: lload 13
    //   4247: lstore 25
    //   4249: lload 15
    //   4251: lstore 13
    //   4253: lload 17
    //   4255: lstore 15
    //   4257: lload 25
    //   4259: lstore 17
    //   4261: goto -2176 -> 2085
    //   4264: astore 31
    //   4266: lload 13
    //   4268: lstore 25
    //   4270: iload 7
    //   4272: istore 8
    //   4274: lload 15
    //   4276: lstore 13
    //   4278: lload 17
    //   4280: lstore 15
    //   4282: lload 25
    //   4284: lstore 17
    //   4286: goto -2201 -> 2085
    //   4289: astore 31
    //   4291: lload 13
    //   4293: lstore 25
    //   4295: iload 7
    //   4297: istore 8
    //   4299: lload 15
    //   4301: lstore 13
    //   4303: lload 17
    //   4305: lstore 15
    //   4307: lload 25
    //   4309: lstore 17
    //   4311: goto -2226 -> 2085
    //   4314: astore 31
    //   4316: lload 13
    //   4318: lstore 25
    //   4320: iload 7
    //   4322: istore 8
    //   4324: lload 15
    //   4326: lstore 13
    //   4328: lload 17
    //   4330: lstore 15
    //   4332: lload 25
    //   4334: lstore 17
    //   4336: goto -2251 -> 2085
    //   4339: astore 31
    //   4341: lload 13
    //   4343: lstore 25
    //   4345: iload 7
    //   4347: istore 8
    //   4349: lload 15
    //   4351: lstore 13
    //   4353: lload 17
    //   4355: lstore 15
    //   4357: lload 25
    //   4359: lstore 17
    //   4361: goto -2276 -> 2085
    //   4364: astore 31
    //   4366: iload 7
    //   4368: istore 6
    //   4370: lload 15
    //   4372: lstore 19
    //   4374: lload 17
    //   4376: lstore 15
    //   4378: lload 25
    //   4380: lstore 17
    //   4382: goto -2297 -> 2085
    //   4385: astore 31
    //   4387: iload 7
    //   4389: istore 6
    //   4391: lload 17
    //   4393: lstore 15
    //   4395: lload 25
    //   4397: lstore 17
    //   4399: goto -2314 -> 2085
    //   4402: astore 31
    //   4404: iload 6
    //   4406: istore 5
    //   4408: lload 17
    //   4410: lstore 15
    //   4412: iload 7
    //   4414: istore 6
    //   4416: lload 25
    //   4418: lstore 17
    //   4420: goto -2335 -> 2085
    //   4423: iload 10
    //   4425: istore 8
    //   4427: goto -3470 -> 957
    //   4430: goto -3744 -> 686
    //   4433: iload 8
    //   4435: ifle -3820 -> 615
    //   4438: iload 8
    //   4440: sipush 500
    //   4443: if_icmpge -3828 -> 615
    //   4446: iconst_1
    //   4447: istore 6
    //   4449: goto -3958 -> 491
    //   4452: lload 15
    //   4454: l2i
    //   4455: istore 6
    //   4457: lload 13
    //   4459: lconst_0
    //   4460: lcmp
    //   4461: ifne -2418 -> 2043
    //   4464: ldc2_w 271
    //   4467: lstore 13
    //   4469: goto -2699 -> 1770
    //   4472: lload 19
    //   4474: l2i
    //   4475: istore 7
    //   4477: lload 13
    //   4479: lconst_0
    //   4480: lcmp
    //   4481: ifne -1579 -> 2902
    //   4484: ldc2_w 271
    //   4487: lstore 13
    //   4489: goto -1838 -> 2651
    //   4492: lload 19
    //   4494: l2i
    //   4495: istore 7
    //   4497: lload 13
    //   4499: lconst_0
    //   4500: lcmp
    //   4501: ifne -551 -> 3950
    //   4504: ldc2_w 271
    //   4507: lstore 13
    //   4509: goto -834 -> 3675
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4512	0	this	evm
    //   41	3814	1	d1	double
    //   807	3	3	d2	double
    //   38	4369	5	i	int
    //   54	4402	6	j	int
    //   63	4433	7	k	int
    //   69	4375	8	m	int
    //   66	4122	9	n	int
    //   57	4367	10	i1	int
    //   167	793	11	i2	int
    //   190	526	12	i3	int
    //   51	4457	13	l1	long
    //   48	4405	15	l2	long
    //   35	4384	17	l3	long
    //   32	4461	19	l4	long
    //   60	3881	21	l5	long
    //   72	3879	23	l6	long
    //   274	4143	25	l7	long
    //   45	3826	27	l8	long
    //   259	179	29	l9	long
    //   173	1803	31	localObject1	java.lang.Object
    //   2001	3	31	localThrowable1	java.lang.Throwable
    //   2011	15	31	localException1	java.lang.Exception
    //   2053	15	31	localException2	java.lang.Exception
    //   2075	119	31	localThrowable2	java.lang.Throwable
    //   2424	433	31	localObject2	java.lang.Object
    //   2882	3	31	localThrowable3	java.lang.Throwable
    //   2912	15	31	localException3	java.lang.Exception
    //   2934	972	31	localObject3	java.lang.Object
    //   3982	1	31	localObject4	java.lang.Object
    //   4006	1	31	localObject5	java.lang.Object
    //   4026	1	31	localObject6	java.lang.Object
    //   4054	1	31	localObject7	java.lang.Object
    //   4082	1	31	localObject8	java.lang.Object
    //   4110	1	31	localObject9	java.lang.Object
    //   4138	1	31	localObject10	java.lang.Object
    //   4158	1	31	localObject11	java.lang.Object
    //   4174	1	31	localObject12	java.lang.Object
    //   4198	1	31	localObject13	java.lang.Object
    //   4218	1	31	localThrowable4	java.lang.Throwable
    //   4243	1	31	localThrowable5	java.lang.Throwable
    //   4264	1	31	localThrowable6	java.lang.Throwable
    //   4289	1	31	localThrowable7	java.lang.Throwable
    //   4314	1	31	localThrowable8	java.lang.Throwable
    //   4339	1	31	localThrowable9	java.lang.Throwable
    //   4364	1	31	localThrowable10	java.lang.Throwable
    //   4385	1	31	localThrowable11	java.lang.Throwable
    //   4402	1	31	localThrowable12	java.lang.Throwable
    //   112	3769	32	localObject14	java.lang.Object
    //   3908	3	32	localThrowable13	java.lang.Throwable
    //   3918	15	32	localException4	java.lang.Exception
    //   3960	15	32	localException5	java.lang.Exception
    //   359	506	33	localObject15	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   1077	1084	2001	java/lang/Throwable
    //   1289	1536	2011	java/lang/Exception
    //   1536	1755	2053	java/lang/Exception
    //   1775	1983	2053	java/lang/Exception
    //   2033	2040	2053	java/lang/Exception
    //   2043	2050	2053	java/lang/Exception
    //   74	103	2075	java/lang/Throwable
    //   103	143	2075	java/lang/Throwable
    //   143	234	2075	java/lang/Throwable
    //   234	256	2075	java/lang/Throwable
    //   256	261	2075	java/lang/Throwable
    //   2218	2225	2882	java/lang/Throwable
    //   2417	2636	2912	java/lang/Exception
    //   2656	2864	2912	java/lang/Exception
    //   2892	2899	2912	java/lang/Exception
    //   2902	2909	2912	java/lang/Exception
    //   74	103	2934	finally
    //   103	143	2934	finally
    //   143	234	2934	finally
    //   234	256	2934	finally
    //   256	261	2934	finally
    //   2977	2984	3908	java/lang/Throwable
    //   3194	3441	3918	java/lang/Exception
    //   3441	3660	3960	java/lang/Exception
    //   3680	3888	3960	java/lang/Exception
    //   3940	3947	3960	java/lang/Exception
    //   3950	3957	3960	java/lang/Exception
    //   658	679	3982	finally
    //   686	713	3982	finally
    //   742	780	4006	finally
    //   780	789	4026	finally
    //   802	808	4054	finally
    //   812	864	4082	finally
    //   864	869	4082	finally
    //   894	917	4110	finally
    //   921	953	4110	finally
    //   290	297	4138	finally
    //   301	314	4138	finally
    //   342	361	4138	finally
    //   371	380	4138	finally
    //   384	426	4138	finally
    //   434	447	4138	finally
    //   456	488	4138	finally
    //   495	519	4138	finally
    //   996	1057	4138	finally
    //   537	553	4158	finally
    //   553	579	4158	finally
    //   584	590	4174	finally
    //   2085	2123	4198	finally
    //   2123	2165	4198	finally
    //   2165	2189	4198	finally
    //   2189	2198	4198	finally
    //   658	679	4218	java/lang/Throwable
    //   686	713	4218	java/lang/Throwable
    //   742	780	4243	java/lang/Throwable
    //   780	789	4264	java/lang/Throwable
    //   802	808	4289	java/lang/Throwable
    //   812	864	4314	java/lang/Throwable
    //   864	869	4314	java/lang/Throwable
    //   894	917	4339	java/lang/Throwable
    //   921	953	4339	java/lang/Throwable
    //   290	297	4364	java/lang/Throwable
    //   301	314	4364	java/lang/Throwable
    //   342	361	4364	java/lang/Throwable
    //   371	380	4364	java/lang/Throwable
    //   384	426	4364	java/lang/Throwable
    //   434	447	4364	java/lang/Throwable
    //   456	488	4364	java/lang/Throwable
    //   495	519	4364	java/lang/Throwable
    //   996	1057	4364	java/lang/Throwable
    //   537	553	4385	java/lang/Throwable
    //   553	579	4385	java/lang/Throwable
    //   584	590	4402	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     evm
 * JD-Core Version:    0.7.0.1
 */