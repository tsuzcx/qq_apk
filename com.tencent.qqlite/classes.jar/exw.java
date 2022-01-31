import com.tencent.mobileqq.utils.QQRecorder;

public class exw
  extends Thread
{
  public volatile boolean a;
  private boolean b = false;
  
  public exw(QQRecorder paramQQRecorder, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    QQRecorder.a(paramQQRecorder, paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 38
    //   8: iconst_2
    //   9: new 40	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   16: ldc 43
    //   18: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: lconst_0
    //   32: lstore 18
    //   34: lconst_0
    //   35: lstore 16
    //   37: iconst_0
    //   38: istore 9
    //   40: dconst_0
    //   41: dstore_1
    //   42: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   45: lstore 34
    //   47: lconst_0
    //   48: lstore 14
    //   50: lconst_0
    //   51: lstore 28
    //   53: iconst_0
    //   54: istore 12
    //   56: iconst_0
    //   57: istore 6
    //   59: iconst_0
    //   60: istore 7
    //   62: lconst_0
    //   63: lstore 22
    //   65: iconst_0
    //   66: istore 13
    //   68: iconst_0
    //   69: istore 10
    //   71: iconst_0
    //   72: istore 8
    //   74: lconst_0
    //   75: lstore 24
    //   77: sipush 250
    //   80: istore 5
    //   82: bipush 237
    //   84: invokestatic 70	android/os/Process:setThreadPriority	(I)V
    //   87: aload_0
    //   88: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   91: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   94: ifnull +29 -> 123
    //   97: aload_0
    //   98: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   101: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   104: aload_0
    //   105: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   108: invokestatic 76	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   111: aload_0
    //   112: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   115: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   118: invokeinterface 84 3 0
    //   123: aload_0
    //   124: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   127: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   130: newarray byte
    //   132: astore 38
    //   134: aload_0
    //   135: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   138: invokestatic 90	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   141: aload_0
    //   142: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   145: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   148: ifnull +31 -> 179
    //   151: aload_0
    //   152: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   155: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   158: invokeinterface 93 1 0
    //   163: istore 11
    //   165: iload 11
    //   167: istore 5
    //   169: iload 11
    //   171: ifgt +8 -> 179
    //   174: sipush 250
    //   177: istore 5
    //   179: aload_0
    //   180: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   183: invokestatic 95	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   186: ldc2_w 96
    //   189: invokestatic 101	java/lang/Thread:sleep	(J)V
    //   192: iload 5
    //   194: aload_0
    //   195: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   198: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   201: getfield 106	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:a	I
    //   204: invokestatic 109	com/tencent/mobileqq/utils/QQRecorder:a	(I)I
    //   207: sipush 1000
    //   210: idiv
    //   211: imul
    //   212: istore 5
    //   214: iload 5
    //   216: newarray byte
    //   218: astore 36
    //   220: aload_0
    //   221: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   224: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   227: aload 36
    //   229: iconst_0
    //   230: iload 5
    //   232: invokevirtual 118	android/media/AudioRecord:read	([BII)I
    //   235: istore 11
    //   237: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +39 -> 279
    //   243: ldc 38
    //   245: iconst_2
    //   246: new 40	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   253: ldc 120
    //   255: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: iload 11
    //   260: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: ldc 125
    //   265: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: iload 5
    //   270: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   283: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   286: ifnull +4345 -> 4631
    //   289: aload_0
    //   290: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   293: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   296: invokeinterface 127 1 0
    //   301: istore 11
    //   303: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   306: lstore 30
    //   308: iconst_0
    //   309: istore 6
    //   311: iconst_0
    //   312: istore 5
    //   314: iconst_0
    //   315: istore 10
    //   317: lconst_0
    //   318: lstore 20
    //   320: lconst_0
    //   321: lstore 14
    //   323: lconst_0
    //   324: lstore 18
    //   326: aconst_null
    //   327: astore 36
    //   329: dconst_0
    //   330: dstore_1
    //   331: lload 22
    //   333: lstore 26
    //   335: aload_0
    //   336: getfield 17	exw:jdField_a_of_type_Boolean	Z
    //   339: ifeq +1585 -> 1924
    //   342: aload_0
    //   343: getfield 19	exw:b	Z
    //   346: ifne +1578 -> 1924
    //   349: iload 10
    //   351: istore 9
    //   353: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   356: lload 30
    //   358: lsub
    //   359: ldc2_w 128
    //   362: lcmp
    //   363: ifle +797 -> 1160
    //   366: iload 10
    //   368: istore 9
    //   370: iload 10
    //   372: ifne +788 -> 1160
    //   375: iconst_1
    //   376: istore 9
    //   378: lload 20
    //   380: lconst_0
    //   381: lcmp
    //   382: ifeq +8 -> 390
    //   385: iload 7
    //   387: ifne +773 -> 1160
    //   390: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +39 -> 432
    //   396: ldc 38
    //   398: iconst_2
    //   399: new 40	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   406: ldc 131
    //   408: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: lload 20
    //   413: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: ldc 136
    //   418: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iload 7
    //   423: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: new 138	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException
    //   435: dup
    //   436: ldc 140
    //   438: invokespecial 143	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException:<init>	(Ljava/lang/String;)V
    //   441: athrow
    //   442: astore 36
    //   444: lload 20
    //   446: lstore 16
    //   448: lload 18
    //   450: lstore 20
    //   452: lload 14
    //   454: lstore 18
    //   456: lload 20
    //   458: lstore 14
    //   460: lload 28
    //   462: lstore 20
    //   464: lload 26
    //   466: lstore 22
    //   468: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq +13 -> 484
    //   474: ldc 38
    //   476: iconst_2
    //   477: ldc 145
    //   479: aload 36
    //   481: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   484: aload_0
    //   485: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   488: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   491: ifnull +77 -> 568
    //   494: aload_0
    //   495: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   498: getfield 151	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   501: ifnull +25 -> 526
    //   504: aload_0
    //   505: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   508: invokestatic 154	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   511: iconst_m1
    //   512: if_icmpeq +14 -> 526
    //   515: aload_0
    //   516: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   519: getfield 151	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   522: iconst_0
    //   523: invokevirtual 159	android/media/AudioManager:setMode	(I)V
    //   526: aload 36
    //   528: instanceof 161
    //   531: ifne +11 -> 542
    //   534: aload 36
    //   536: instanceof 163
    //   539: ifeq +2375 -> 2914
    //   542: aload_0
    //   543: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   546: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   549: aload_0
    //   550: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   553: invokestatic 76	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   556: aload_0
    //   557: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   560: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   563: invokeinterface 165 3 0
    //   568: aload_0
    //   569: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   572: aload 36
    //   574: invokevirtual 168	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   577: aload_0
    //   578: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   581: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   584: ifnull +13 -> 597
    //   587: aload_0
    //   588: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   591: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   594: invokevirtual 171	android/media/AudioRecord:release	()V
    //   597: aload_0
    //   598: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   601: invokestatic 173	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   604: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   607: ifeq +84 -> 691
    //   610: ldc 38
    //   612: iconst_2
    //   613: new 40	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   620: ldc 175
    //   622: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_0
    //   626: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: ldc 38
    //   637: iconst_2
    //   638: new 40	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   645: ldc 177
    //   647: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: lload 18
    //   652: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   655: ldc 179
    //   657: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: lload 16
    //   662: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   665: ldc 181
    //   667: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: lload 14
    //   672: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   675: ldc 183
    //   677: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: iload 5
    //   682: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: lload 14
    //   693: ldc2_w 184
    //   696: lcmp
    //   697: iflt +11 -> 708
    //   700: dload_1
    //   701: ldc2_w 186
    //   704: dcmpg
    //   705: ifge +3 -> 708
    //   708: new 189	java/util/HashMap
    //   711: dup
    //   712: invokespecial 190	java/util/HashMap:<init>	()V
    //   715: astore 36
    //   717: aload 36
    //   719: ldc 192
    //   721: new 40	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   728: getstatic 197	android/os/Build$VERSION:SDK_INT	I
    //   731: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: ldc 199
    //   736: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   745: pop
    //   746: aload 36
    //   748: ldc 205
    //   750: new 40	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   757: getstatic 211	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   760: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: ldc 213
    //   765: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: getstatic 216	android/os/Build:MODEL	Ljava/lang/String;
    //   771: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   780: pop
    //   781: aload 36
    //   783: ldc 218
    //   785: new 40	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   792: lload 16
    //   794: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   797: ldc 199
    //   799: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   808: pop
    //   809: aload 36
    //   811: ldc 220
    //   813: new 40	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   820: dload_1
    //   821: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   824: ldc 199
    //   826: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   835: pop
    //   836: aload 36
    //   838: ldc 225
    //   840: new 40	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   847: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   850: lload 34
    //   852: lsub
    //   853: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   856: ldc 199
    //   858: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   867: pop
    //   868: aload 36
    //   870: ldc 227
    //   872: new 40	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   879: iload 7
    //   881: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: ldc 199
    //   886: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   895: pop
    //   896: aload 36
    //   898: ldc 229
    //   900: new 40	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   907: iload 8
    //   909: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   912: ldc 199
    //   914: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   923: pop
    //   924: lload 20
    //   926: lconst_0
    //   927: lcmp
    //   928: ifne +2946 -> 3874
    //   931: ldc2_w 230
    //   934: lstore 18
    //   936: goto +3701 -> 4637
    //   939: lload 18
    //   941: l2i
    //   942: istore 5
    //   944: aload 36
    //   946: ldc 233
    //   948: new 40	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   955: iload 6
    //   957: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   960: ldc 199
    //   962: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   971: pop
    //   972: aload 36
    //   974: ldc 235
    //   976: new 40	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   983: iload 5
    //   985: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   988: ldc 199
    //   990: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   999: pop
    //   1000: ldc 237
    //   1002: iconst_1
    //   1003: aload 36
    //   1005: invokestatic 240	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1008: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1011: ifeq +131 -> 1142
    //   1014: new 40	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   1021: astore 36
    //   1023: aload 36
    //   1025: ldc 242
    //   1027: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: iload 7
    //   1032: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1035: pop
    //   1036: aload 36
    //   1038: ldc 244
    //   1040: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: iload 6
    //   1045: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 36
    //   1051: ldc 246
    //   1053: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: iload 5
    //   1058: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload 36
    //   1064: ldc 248
    //   1066: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: iload 5
    //   1071: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: aload 36
    //   1077: ldc 250
    //   1079: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: lload 16
    //   1084: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 36
    //   1090: ldc 252
    //   1092: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: lload 14
    //   1097: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: aload 36
    //   1103: ldc 254
    //   1105: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: dload_1
    //   1109: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 36
    //   1115: ldc_w 256
    //   1118: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   1124: lload 34
    //   1126: lsub
    //   1127: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: ldc 38
    //   1133: iconst_2
    //   1134: aload 36
    //   1136: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1142: aload_0
    //   1143: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1146: aconst_null
    //   1147: putfield 259	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Exw	Lexw;
    //   1150: aload_0
    //   1151: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1154: aconst_null
    //   1155: invokestatic 24	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   1158: pop
    //   1159: return
    //   1160: iload 6
    //   1162: istore 10
    //   1164: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   1167: lload 30
    //   1169: lsub
    //   1170: ldc2_w 128
    //   1173: lcmp
    //   1174: ifle +80 -> 1254
    //   1177: iload 6
    //   1179: istore 10
    //   1181: iload 6
    //   1183: ifne +71 -> 1254
    //   1186: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1189: ifeq +3468 -> 4657
    //   1192: ldc 38
    //   1194: iconst_2
    //   1195: new 40	java/lang/StringBuilder
    //   1198: dup
    //   1199: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   1202: ldc_w 261
    //   1205: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: iload 8
    //   1210: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1219: goto +3438 -> 4657
    //   1222: iload 6
    //   1224: istore 10
    //   1226: aload_0
    //   1227: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1230: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1233: ifnull +21 -> 1254
    //   1236: aload_0
    //   1237: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1240: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1243: iload 6
    //   1245: invokeinterface 263 2 0
    //   1250: iload 6
    //   1252: istore 10
    //   1254: lload 14
    //   1256: lconst_1
    //   1257: ladd
    //   1258: lstore 16
    //   1260: iconst_0
    //   1261: istore 12
    //   1263: aload 36
    //   1265: ifnull +19 -> 1284
    //   1268: aload 36
    //   1270: arraylength
    //   1271: istore 12
    //   1273: aload 36
    //   1275: iconst_0
    //   1276: aload 38
    //   1278: iconst_0
    //   1279: iload 12
    //   1281: invokestatic 267	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1284: aload_0
    //   1285: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1288: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1291: aload 38
    //   1293: iload 12
    //   1295: aload_0
    //   1296: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1299: invokestatic 87	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1302: iload 12
    //   1304: isub
    //   1305: invokevirtual 118	android/media/AudioRecord:read	([BII)I
    //   1308: istore 6
    //   1310: iload 6
    //   1312: ifgt +34 -> 1346
    //   1315: ldc2_w 268
    //   1318: invokestatic 101	java/lang/Thread:sleep	(J)V
    //   1321: iload 6
    //   1323: istore 5
    //   1325: lload 16
    //   1327: lstore 14
    //   1329: iload 10
    //   1331: istore 6
    //   1333: iload 9
    //   1335: istore 10
    //   1337: goto -1002 -> 335
    //   1340: iconst_2
    //   1341: istore 6
    //   1343: goto -121 -> 1222
    //   1346: aconst_null
    //   1347: astore 36
    //   1349: lload 28
    //   1351: lconst_1
    //   1352: ladd
    //   1353: lstore 14
    //   1355: lload 20
    //   1357: iload 6
    //   1359: i2l
    //   1360: ladd
    //   1361: lstore 22
    //   1363: iload 12
    //   1365: iload 6
    //   1367: iadd
    //   1368: istore 12
    //   1370: iload 12
    //   1372: getstatic 274	com/tencent/mobileqq/utils/NoiseSuppression:f	I
    //   1375: irem
    //   1376: istore 6
    //   1378: iload 6
    //   1380: ifeq +3248 -> 4628
    //   1383: iload 6
    //   1385: newarray byte
    //   1387: astore 36
    //   1389: aload 38
    //   1391: iload 12
    //   1393: iload 6
    //   1395: isub
    //   1396: aload 36
    //   1398: iconst_0
    //   1399: iload 6
    //   1401: invokestatic 267	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1404: iload 12
    //   1406: iload 6
    //   1408: isub
    //   1409: istore 12
    //   1411: aload_0
    //   1412: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1415: invokestatic 277	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1418: aload 38
    //   1420: iload 12
    //   1422: fconst_1
    //   1423: invokestatic 282	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   1426: l2i
    //   1427: istore 13
    //   1429: iload 7
    //   1431: iload 13
    //   1433: invokestatic 288	java/lang/Math:max	(II)I
    //   1436: istore 6
    //   1438: lload 26
    //   1440: iload 13
    //   1442: i2l
    //   1443: ladd
    //   1444: lstore 20
    //   1446: iconst_0
    //   1447: istore 7
    //   1449: iload 7
    //   1451: iload 12
    //   1453: if_icmpge +96 -> 1549
    //   1456: aload_0
    //   1457: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1460: invokestatic 291	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   1463: ifnull +20 -> 1483
    //   1466: aload_0
    //   1467: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1470: invokestatic 291	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   1473: aload 38
    //   1475: iload 7
    //   1477: getstatic 274	com/tencent/mobileqq/utils/NoiseSuppression:f	I
    //   1480: invokevirtual 296	com/tencent/mobileqq/utils/PTTAgcWrapper:a	([BII)V
    //   1483: aload_0
    //   1484: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1487: invokestatic 299	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   1490: ifnull +21 -> 1511
    //   1493: aload_0
    //   1494: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1497: invokestatic 299	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   1500: aload 38
    //   1502: iload 7
    //   1504: getstatic 274	com/tencent/mobileqq/utils/NoiseSuppression:f	I
    //   1507: invokevirtual 301	com/tencent/mobileqq/utils/NoiseSuppression:a	([BII)I
    //   1510: pop
    //   1511: aload_0
    //   1512: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1515: invokestatic 291	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   1518: ifnull +20 -> 1538
    //   1521: aload_0
    //   1522: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1525: invokestatic 291	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   1528: aload 38
    //   1530: iload 7
    //   1532: getstatic 274	com/tencent/mobileqq/utils/NoiseSuppression:f	I
    //   1535: invokevirtual 303	com/tencent/mobileqq/utils/PTTAgcWrapper:b	([BII)V
    //   1538: iload 7
    //   1540: getstatic 274	com/tencent/mobileqq/utils/NoiseSuppression:f	I
    //   1543: iadd
    //   1544: istore 7
    //   1546: goto -97 -> 1449
    //   1549: aload_0
    //   1550: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1553: aload_0
    //   1554: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1557: invokestatic 277	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1560: aload 38
    //   1562: iload 12
    //   1564: fconst_1
    //   1565: invokestatic 282	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   1568: l2i
    //   1569: invokestatic 306	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;I)I
    //   1572: pop
    //   1573: iload 8
    //   1575: aload_0
    //   1576: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1579: invokestatic 308	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1582: invokestatic 288	java/lang/Math:max	(II)I
    //   1585: istore 7
    //   1587: aload_0
    //   1588: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1591: invokestatic 308	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1594: istore 8
    //   1596: lload 24
    //   1598: iload 8
    //   1600: i2l
    //   1601: ladd
    //   1602: lstore 24
    //   1604: iload 12
    //   1606: i2l
    //   1607: lstore 26
    //   1609: lload 26
    //   1611: aload_0
    //   1612: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1615: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1618: getfield 106	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:a	I
    //   1621: invokestatic 311	com/tencent/mobileqq/utils/QQRecorder:a	(JI)D
    //   1624: dstore_3
    //   1625: dload_1
    //   1626: dload_3
    //   1627: dadd
    //   1628: dstore_1
    //   1629: aload_0
    //   1630: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1633: invokestatic 314	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Z
    //   1636: ifeq +227 -> 1863
    //   1639: aload_0
    //   1640: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1643: invokestatic 317	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/IAudioCompressor;
    //   1646: aload 38
    //   1648: iload 12
    //   1650: invokeinterface 322 3 0
    //   1655: astore 37
    //   1657: aload_0
    //   1658: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1661: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1664: ifnull +39 -> 1703
    //   1667: aload_0
    //   1668: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1671: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1674: aload_0
    //   1675: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1678: invokestatic 76	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   1681: aload 37
    //   1683: aload_0
    //   1684: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1687: invokestatic 308	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1690: dload_1
    //   1691: aload_0
    //   1692: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1695: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1698: invokeinterface 325 7 0
    //   1703: aload 37
    //   1705: arraylength
    //   1706: istore 8
    //   1708: lload 18
    //   1710: iload 8
    //   1712: i2l
    //   1713: ladd
    //   1714: lstore 18
    //   1716: iload 10
    //   1718: istore 8
    //   1720: iload 10
    //   1722: iconst_1
    //   1723: if_icmpne +82 -> 1805
    //   1726: iload 10
    //   1728: istore 8
    //   1730: iload 7
    //   1732: sipush 500
    //   1735: if_icmple +70 -> 1805
    //   1738: iconst_2
    //   1739: istore 10
    //   1741: aload_0
    //   1742: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1745: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1748: ifnull +16 -> 1764
    //   1751: aload_0
    //   1752: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1755: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1758: iconst_2
    //   1759: invokeinterface 263 2 0
    //   1764: iload 10
    //   1766: istore 8
    //   1768: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1771: ifeq +34 -> 1805
    //   1774: ldc 38
    //   1776: iconst_2
    //   1777: new 40	java/lang/StringBuilder
    //   1780: dup
    //   1781: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   1784: ldc_w 327
    //   1787: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1790: iload 7
    //   1792: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1795: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1798: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1801: iload 10
    //   1803: istore 8
    //   1805: iload 11
    //   1807: iconst_m1
    //   1808: if_icmpeq +16 -> 1824
    //   1811: dload_1
    //   1812: iload 11
    //   1814: i2d
    //   1815: dcmpl
    //   1816: iflt +8 -> 1824
    //   1819: aload_0
    //   1820: iconst_1
    //   1821: putfield 19	exw:b	Z
    //   1824: iload 6
    //   1826: istore 10
    //   1828: iload 8
    //   1830: istore 6
    //   1832: iload 7
    //   1834: istore 8
    //   1836: lload 20
    //   1838: lstore 26
    //   1840: iload 10
    //   1842: istore 7
    //   1844: lload 14
    //   1846: lstore 28
    //   1848: iload 9
    //   1850: istore 10
    //   1852: lload 22
    //   1854: lstore 20
    //   1856: lload 16
    //   1858: lstore 14
    //   1860: goto -1525 -> 335
    //   1863: iload 12
    //   1865: newarray byte
    //   1867: astore 37
    //   1869: aload 38
    //   1871: iconst_0
    //   1872: aload 37
    //   1874: iconst_0
    //   1875: iload 12
    //   1877: invokestatic 267	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1880: goto -223 -> 1657
    //   1883: astore 36
    //   1885: lload 22
    //   1887: lstore 26
    //   1889: lload 16
    //   1891: lstore 28
    //   1893: iload 7
    //   1895: istore 8
    //   1897: lload 20
    //   1899: lstore 22
    //   1901: iload 6
    //   1903: istore 7
    //   1905: lload 14
    //   1907: lstore 20
    //   1909: lload 18
    //   1911: lstore 14
    //   1913: lload 26
    //   1915: lstore 16
    //   1917: lload 28
    //   1919: lstore 18
    //   1921: goto -1453 -> 468
    //   1924: aload_0
    //   1925: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1928: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1931: ifnull +62 -> 1993
    //   1934: aload_0
    //   1935: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1938: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1941: aload_0
    //   1942: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1945: invokestatic 76	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   1948: aload_0
    //   1949: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1952: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1955: dload_1
    //   1956: invokeinterface 330 5 0
    //   1961: aload_0
    //   1962: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1965: getfield 151	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1968: ifnull +25 -> 1993
    //   1971: aload_0
    //   1972: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1975: invokestatic 154	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1978: iconst_m1
    //   1979: if_icmpeq +14 -> 1993
    //   1982: aload_0
    //   1983: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1986: getfield 151	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1989: iconst_0
    //   1990: invokevirtual 159	android/media/AudioManager:setMode	(I)V
    //   1993: aload_0
    //   1994: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1997: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2000: ifnull +13 -> 2013
    //   2003: aload_0
    //   2004: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2007: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2010: invokevirtual 171	android/media/AudioRecord:release	()V
    //   2013: aload_0
    //   2014: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2017: invokestatic 173	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2020: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2023: ifeq +84 -> 2107
    //   2026: ldc 38
    //   2028: iconst_2
    //   2029: new 40	java/lang/StringBuilder
    //   2032: dup
    //   2033: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2036: ldc 175
    //   2038: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2041: aload_0
    //   2042: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2045: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2048: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2051: ldc 38
    //   2053: iconst_2
    //   2054: new 40	java/lang/StringBuilder
    //   2057: dup
    //   2058: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2061: ldc 177
    //   2063: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: lload 14
    //   2068: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2071: ldc 179
    //   2073: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: lload 20
    //   2078: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2081: ldc 181
    //   2083: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: lload 18
    //   2088: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2091: ldc 183
    //   2093: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: iload 5
    //   2098: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2101: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2104: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2107: lload 18
    //   2109: ldc2_w 184
    //   2112: lcmp
    //   2113: iflt +11 -> 2124
    //   2116: dload_1
    //   2117: ldc2_w 186
    //   2120: dcmpg
    //   2121: ifge +267 -> 2388
    //   2124: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   2127: lload 34
    //   2129: lsub
    //   2130: ldc2_w 128
    //   2133: lcmp
    //   2134: ifle +254 -> 2388
    //   2137: new 189	java/util/HashMap
    //   2140: dup
    //   2141: invokespecial 190	java/util/HashMap:<init>	()V
    //   2144: astore 36
    //   2146: aload 36
    //   2148: ldc_w 332
    //   2151: ldc_w 334
    //   2154: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2157: pop
    //   2158: aload 36
    //   2160: ldc 192
    //   2162: new 40	java/lang/StringBuilder
    //   2165: dup
    //   2166: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2169: getstatic 197	android/os/Build$VERSION:SDK_INT	I
    //   2172: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2175: ldc 199
    //   2177: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2183: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2186: pop
    //   2187: aload 36
    //   2189: ldc 205
    //   2191: new 40	java/lang/StringBuilder
    //   2194: dup
    //   2195: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2198: getstatic 211	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2201: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2204: ldc 213
    //   2206: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2209: getstatic 216	android/os/Build:MODEL	Ljava/lang/String;
    //   2212: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2218: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2221: pop
    //   2222: aload 36
    //   2224: ldc 218
    //   2226: new 40	java/lang/StringBuilder
    //   2229: dup
    //   2230: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2233: lload 20
    //   2235: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2238: ldc 199
    //   2240: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2246: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2249: pop
    //   2250: aload 36
    //   2252: ldc_w 336
    //   2255: new 40	java/lang/StringBuilder
    //   2258: dup
    //   2259: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2262: dload_1
    //   2263: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2266: ldc 199
    //   2268: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2274: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2277: pop
    //   2278: aload 36
    //   2280: ldc 225
    //   2282: new 40	java/lang/StringBuilder
    //   2285: dup
    //   2286: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2289: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   2292: lload 34
    //   2294: lsub
    //   2295: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2298: ldc 199
    //   2300: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2306: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2309: pop
    //   2310: ldc_w 338
    //   2313: iconst_0
    //   2314: aload 36
    //   2316: invokestatic 240	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2319: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2322: ifeq +66 -> 2388
    //   2325: ldc 38
    //   2327: iconst_2
    //   2328: new 40	java/lang/StringBuilder
    //   2331: dup
    //   2332: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2335: ldc_w 340
    //   2338: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: lload 20
    //   2343: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2346: ldc_w 342
    //   2349: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2352: lload 18
    //   2354: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2357: ldc_w 344
    //   2360: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2363: dload_1
    //   2364: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2367: ldc_w 346
    //   2370: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   2376: lload 34
    //   2378: lsub
    //   2379: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2382: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2385: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2388: new 189	java/util/HashMap
    //   2391: dup
    //   2392: invokespecial 190	java/util/HashMap:<init>	()V
    //   2395: astore 36
    //   2397: aload 36
    //   2399: ldc 192
    //   2401: new 40	java/lang/StringBuilder
    //   2404: dup
    //   2405: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2408: getstatic 197	android/os/Build$VERSION:SDK_INT	I
    //   2411: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2414: ldc 199
    //   2416: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2419: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2422: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2425: pop
    //   2426: aload 36
    //   2428: ldc 205
    //   2430: new 40	java/lang/StringBuilder
    //   2433: dup
    //   2434: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2437: getstatic 211	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2440: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: ldc 213
    //   2445: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: getstatic 216	android/os/Build:MODEL	Ljava/lang/String;
    //   2451: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2457: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2460: pop
    //   2461: aload 36
    //   2463: ldc 218
    //   2465: new 40	java/lang/StringBuilder
    //   2468: dup
    //   2469: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2472: lload 20
    //   2474: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2477: ldc 199
    //   2479: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2485: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2488: pop
    //   2489: aload 36
    //   2491: ldc 220
    //   2493: new 40	java/lang/StringBuilder
    //   2496: dup
    //   2497: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2500: dload_1
    //   2501: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2504: ldc 199
    //   2506: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2512: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2515: pop
    //   2516: aload 36
    //   2518: ldc 225
    //   2520: new 40	java/lang/StringBuilder
    //   2523: dup
    //   2524: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2527: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   2530: lload 34
    //   2532: lsub
    //   2533: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2536: ldc 199
    //   2538: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2541: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2544: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2547: pop
    //   2548: aload 36
    //   2550: ldc 227
    //   2552: new 40	java/lang/StringBuilder
    //   2555: dup
    //   2556: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2559: iload 7
    //   2561: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2564: ldc 199
    //   2566: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2569: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2572: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2575: pop
    //   2576: aload 36
    //   2578: ldc 229
    //   2580: new 40	java/lang/StringBuilder
    //   2583: dup
    //   2584: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2587: iload 8
    //   2589: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2592: ldc 199
    //   2594: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2600: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2603: pop
    //   2604: lload 28
    //   2606: lconst_0
    //   2607: lcmp
    //   2608: ifne +264 -> 2872
    //   2611: ldc2_w 230
    //   2614: lstore 14
    //   2616: goto +2060 -> 4676
    //   2619: lload 14
    //   2621: l2i
    //   2622: istore 5
    //   2624: aload 36
    //   2626: ldc 233
    //   2628: new 40	java/lang/StringBuilder
    //   2631: dup
    //   2632: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2635: iload 6
    //   2637: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2640: ldc 199
    //   2642: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2645: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2648: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2651: pop
    //   2652: aload 36
    //   2654: ldc 235
    //   2656: new 40	java/lang/StringBuilder
    //   2659: dup
    //   2660: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2663: iload 5
    //   2665: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2668: ldc 199
    //   2670: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2673: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2676: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2679: pop
    //   2680: ldc 237
    //   2682: iconst_1
    //   2683: aload 36
    //   2685: invokestatic 240	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2688: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2691: ifeq +131 -> 2822
    //   2694: new 40	java/lang/StringBuilder
    //   2697: dup
    //   2698: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   2701: astore 36
    //   2703: aload 36
    //   2705: ldc 242
    //   2707: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: iload 7
    //   2712: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2715: pop
    //   2716: aload 36
    //   2718: ldc 244
    //   2720: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2723: iload 6
    //   2725: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2728: pop
    //   2729: aload 36
    //   2731: ldc 246
    //   2733: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2736: iload 5
    //   2738: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2741: pop
    //   2742: aload 36
    //   2744: ldc 248
    //   2746: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: iload 5
    //   2751: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2754: pop
    //   2755: aload 36
    //   2757: ldc 250
    //   2759: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2762: lload 20
    //   2764: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2767: pop
    //   2768: aload 36
    //   2770: ldc 252
    //   2772: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2775: lload 18
    //   2777: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2780: pop
    //   2781: aload 36
    //   2783: ldc 254
    //   2785: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2788: dload_1
    //   2789: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2792: pop
    //   2793: aload 36
    //   2795: ldc_w 256
    //   2798: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2801: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   2804: lload 34
    //   2806: lsub
    //   2807: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2810: pop
    //   2811: ldc 38
    //   2813: iconst_2
    //   2814: aload 36
    //   2816: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2819: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2822: aload_0
    //   2823: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2826: aconst_null
    //   2827: putfield 259	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Exw	Lexw;
    //   2830: aload_0
    //   2831: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2834: aconst_null
    //   2835: invokestatic 24	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   2838: pop
    //   2839: return
    //   2840: astore 36
    //   2842: aload 36
    //   2844: invokevirtual 349	java/lang/Throwable:printStackTrace	()V
    //   2847: goto -827 -> 2020
    //   2850: astore 36
    //   2852: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2855: ifeq -467 -> 2388
    //   2858: ldc 38
    //   2860: iconst_2
    //   2861: ldc_w 351
    //   2864: aload 36
    //   2866: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2869: goto -481 -> 2388
    //   2872: lload 26
    //   2874: lload 28
    //   2876: ldiv
    //   2877: lstore 14
    //   2879: goto +1797 -> 4676
    //   2882: lload 24
    //   2884: lload 28
    //   2886: ldiv
    //   2887: lstore 14
    //   2889: goto -270 -> 2619
    //   2892: astore 36
    //   2894: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2897: ifeq -75 -> 2822
    //   2900: ldc 38
    //   2902: iconst_2
    //   2903: ldc_w 353
    //   2906: aload 36
    //   2908: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2911: goto -89 -> 2822
    //   2914: aload 36
    //   2916: instanceof 138
    //   2919: ifeq +911 -> 3830
    //   2922: aload_0
    //   2923: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2926: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2929: aload_0
    //   2930: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2933: invokestatic 76	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   2936: aload_0
    //   2937: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2940: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   2943: invokeinterface 355 3 0
    //   2948: goto -2380 -> 568
    //   2951: astore 36
    //   2953: lload 16
    //   2955: lstore 26
    //   2957: lload 18
    //   2959: lstore 16
    //   2961: iconst_1
    //   2962: istore 6
    //   2964: lload 26
    //   2966: lstore 18
    //   2968: lload 14
    //   2970: lstore 26
    //   2972: lload 22
    //   2974: lstore 14
    //   2976: aload_0
    //   2977: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2980: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2983: ifnull +13 -> 2996
    //   2986: aload_0
    //   2987: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2990: invokestatic 112	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2993: invokevirtual 171	android/media/AudioRecord:release	()V
    //   2996: aload_0
    //   2997: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3000: invokestatic 173	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   3003: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3006: ifeq +84 -> 3090
    //   3009: ldc 38
    //   3011: iconst_2
    //   3012: new 40	java/lang/StringBuilder
    //   3015: dup
    //   3016: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3019: ldc 175
    //   3021: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3024: aload_0
    //   3025: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3028: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3031: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3034: ldc 38
    //   3036: iconst_2
    //   3037: new 40	java/lang/StringBuilder
    //   3040: dup
    //   3041: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3044: ldc 177
    //   3046: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3049: lload 16
    //   3051: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3054: ldc 179
    //   3056: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3059: lload 18
    //   3061: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3064: ldc 181
    //   3066: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: lload 26
    //   3071: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3074: ldc 183
    //   3076: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: iload 5
    //   3081: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3084: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3087: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3090: lload 26
    //   3092: ldc2_w 184
    //   3095: lcmp
    //   3096: iflt +11 -> 3107
    //   3099: dload_1
    //   3100: ldc2_w 186
    //   3103: dcmpg
    //   3104: ifge +272 -> 3376
    //   3107: iload 6
    //   3109: ifne +267 -> 3376
    //   3112: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   3115: lload 34
    //   3117: lsub
    //   3118: ldc2_w 128
    //   3121: lcmp
    //   3122: ifle +254 -> 3376
    //   3125: new 189	java/util/HashMap
    //   3128: dup
    //   3129: invokespecial 190	java/util/HashMap:<init>	()V
    //   3132: astore 37
    //   3134: aload 37
    //   3136: ldc_w 332
    //   3139: ldc_w 334
    //   3142: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3145: pop
    //   3146: aload 37
    //   3148: ldc 192
    //   3150: new 40	java/lang/StringBuilder
    //   3153: dup
    //   3154: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3157: getstatic 197	android/os/Build$VERSION:SDK_INT	I
    //   3160: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3163: ldc 199
    //   3165: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3171: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3174: pop
    //   3175: aload 37
    //   3177: ldc 205
    //   3179: new 40	java/lang/StringBuilder
    //   3182: dup
    //   3183: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3186: getstatic 211	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3189: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3192: ldc 213
    //   3194: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3197: getstatic 216	android/os/Build:MODEL	Ljava/lang/String;
    //   3200: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3206: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3209: pop
    //   3210: aload 37
    //   3212: ldc 218
    //   3214: new 40	java/lang/StringBuilder
    //   3217: dup
    //   3218: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3221: lload 18
    //   3223: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3226: ldc 199
    //   3228: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3234: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3237: pop
    //   3238: aload 37
    //   3240: ldc_w 336
    //   3243: new 40	java/lang/StringBuilder
    //   3246: dup
    //   3247: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3250: dload_1
    //   3251: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3254: ldc 199
    //   3256: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3259: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3262: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3265: pop
    //   3266: aload 37
    //   3268: ldc 225
    //   3270: new 40	java/lang/StringBuilder
    //   3273: dup
    //   3274: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3277: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   3280: lload 34
    //   3282: lsub
    //   3283: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3286: ldc 199
    //   3288: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3291: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3294: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3297: pop
    //   3298: ldc_w 338
    //   3301: iconst_0
    //   3302: aload 37
    //   3304: invokestatic 240	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3307: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3310: ifeq +66 -> 3376
    //   3313: ldc 38
    //   3315: iconst_2
    //   3316: new 40	java/lang/StringBuilder
    //   3319: dup
    //   3320: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3323: ldc_w 340
    //   3326: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3329: lload 18
    //   3331: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3334: ldc_w 342
    //   3337: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: lload 26
    //   3342: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3345: ldc_w 344
    //   3348: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: dload_1
    //   3352: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3355: ldc_w 346
    //   3358: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3361: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   3364: lload 34
    //   3366: lsub
    //   3367: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3370: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3373: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3376: new 189	java/util/HashMap
    //   3379: dup
    //   3380: invokespecial 190	java/util/HashMap:<init>	()V
    //   3383: astore 37
    //   3385: aload 37
    //   3387: ldc 192
    //   3389: new 40	java/lang/StringBuilder
    //   3392: dup
    //   3393: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3396: getstatic 197	android/os/Build$VERSION:SDK_INT	I
    //   3399: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3402: ldc 199
    //   3404: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3407: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3410: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3413: pop
    //   3414: aload 37
    //   3416: ldc 205
    //   3418: new 40	java/lang/StringBuilder
    //   3421: dup
    //   3422: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3425: getstatic 211	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3428: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3431: ldc 213
    //   3433: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: getstatic 216	android/os/Build:MODEL	Ljava/lang/String;
    //   3439: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3448: pop
    //   3449: aload 37
    //   3451: ldc 218
    //   3453: new 40	java/lang/StringBuilder
    //   3456: dup
    //   3457: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3460: lload 18
    //   3462: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3465: ldc 199
    //   3467: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3473: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3476: pop
    //   3477: aload 37
    //   3479: ldc 220
    //   3481: new 40	java/lang/StringBuilder
    //   3484: dup
    //   3485: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3488: dload_1
    //   3489: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3492: ldc 199
    //   3494: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3500: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3503: pop
    //   3504: aload 37
    //   3506: ldc 225
    //   3508: new 40	java/lang/StringBuilder
    //   3511: dup
    //   3512: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3515: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   3518: lload 34
    //   3520: lsub
    //   3521: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3524: ldc 199
    //   3526: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3529: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3532: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3535: pop
    //   3536: aload 37
    //   3538: ldc 227
    //   3540: new 40	java/lang/StringBuilder
    //   3543: dup
    //   3544: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3547: iload 7
    //   3549: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3552: ldc 199
    //   3554: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3557: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3560: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3563: pop
    //   3564: aload 37
    //   3566: ldc 229
    //   3568: new 40	java/lang/StringBuilder
    //   3571: dup
    //   3572: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3575: iload 8
    //   3577: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3580: ldc 199
    //   3582: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3585: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3588: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3591: pop
    //   3592: lload 20
    //   3594: lconst_0
    //   3595: lcmp
    //   3596: ifne +352 -> 3948
    //   3599: ldc2_w 230
    //   3602: lstore 14
    //   3604: goto +1092 -> 4696
    //   3607: lload 14
    //   3609: l2i
    //   3610: istore 5
    //   3612: aload 37
    //   3614: ldc 233
    //   3616: new 40	java/lang/StringBuilder
    //   3619: dup
    //   3620: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3623: iload 6
    //   3625: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3628: ldc 199
    //   3630: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3633: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3636: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3639: pop
    //   3640: aload 37
    //   3642: ldc 235
    //   3644: new 40	java/lang/StringBuilder
    //   3647: dup
    //   3648: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3651: iload 5
    //   3653: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3656: ldc 199
    //   3658: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3661: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3664: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3667: pop
    //   3668: ldc 237
    //   3670: iconst_1
    //   3671: aload 37
    //   3673: invokestatic 240	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3676: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3679: ifeq +131 -> 3810
    //   3682: new 40	java/lang/StringBuilder
    //   3685: dup
    //   3686: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   3689: astore 37
    //   3691: aload 37
    //   3693: ldc 242
    //   3695: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3698: iload 7
    //   3700: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3703: pop
    //   3704: aload 37
    //   3706: ldc 244
    //   3708: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3711: iload 6
    //   3713: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3716: pop
    //   3717: aload 37
    //   3719: ldc 246
    //   3721: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3724: iload 5
    //   3726: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3729: pop
    //   3730: aload 37
    //   3732: ldc 248
    //   3734: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3737: iload 5
    //   3739: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3742: pop
    //   3743: aload 37
    //   3745: ldc 250
    //   3747: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3750: lload 18
    //   3752: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3755: pop
    //   3756: aload 37
    //   3758: ldc 252
    //   3760: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3763: lload 26
    //   3765: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3768: pop
    //   3769: aload 37
    //   3771: ldc 254
    //   3773: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3776: dload_1
    //   3777: invokevirtual 223	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3780: pop
    //   3781: aload 37
    //   3783: ldc_w 256
    //   3786: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3789: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   3792: lload 34
    //   3794: lsub
    //   3795: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3798: pop
    //   3799: ldc 38
    //   3801: iconst_2
    //   3802: aload 37
    //   3804: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3807: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3810: aload_0
    //   3811: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3814: aconst_null
    //   3815: putfield 259	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Exw	Lexw;
    //   3818: aload_0
    //   3819: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3822: aconst_null
    //   3823: invokestatic 24	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;Ljava/lang/String;)Ljava/lang/String;
    //   3826: pop
    //   3827: aload 36
    //   3829: athrow
    //   3830: aload_0
    //   3831: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3834: invokestatic 73	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   3837: aload_0
    //   3838: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3841: invokestatic 76	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Ljava/lang/String;
    //   3844: aload_0
    //   3845: getfield 12	exw:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3848: getfield 79	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   3851: aload 36
    //   3853: invokevirtual 358	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   3856: invokeinterface 361 4 0
    //   3861: goto -3293 -> 568
    //   3864: astore 36
    //   3866: aload 36
    //   3868: invokevirtual 349	java/lang/Throwable:printStackTrace	()V
    //   3871: goto -3267 -> 604
    //   3874: lload 22
    //   3876: lload 20
    //   3878: ldiv
    //   3879: lstore 18
    //   3881: goto +756 -> 4637
    //   3884: lload 24
    //   3886: lload 20
    //   3888: ldiv
    //   3889: lstore 18
    //   3891: goto -2952 -> 939
    //   3894: astore 36
    //   3896: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3899: ifeq -2757 -> 1142
    //   3902: ldc 38
    //   3904: iconst_2
    //   3905: ldc_w 353
    //   3908: aload 36
    //   3910: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3913: goto -2771 -> 1142
    //   3916: astore 37
    //   3918: aload 37
    //   3920: invokevirtual 349	java/lang/Throwable:printStackTrace	()V
    //   3923: goto -920 -> 3003
    //   3926: astore 37
    //   3928: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3931: ifeq -555 -> 3376
    //   3934: ldc 38
    //   3936: iconst_2
    //   3937: ldc_w 351
    //   3940: aload 37
    //   3942: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3945: goto -569 -> 3376
    //   3948: lload 14
    //   3950: lload 20
    //   3952: ldiv
    //   3953: lstore 14
    //   3955: goto +741 -> 4696
    //   3958: lload 24
    //   3960: lload 20
    //   3962: ldiv
    //   3963: lstore 14
    //   3965: goto -358 -> 3607
    //   3968: astore 37
    //   3970: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3973: ifeq -163 -> 3810
    //   3976: ldc 38
    //   3978: iconst_2
    //   3979: ldc_w 353
    //   3982: aload 37
    //   3984: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3987: goto -177 -> 3810
    //   3990: astore 36
    //   3992: iconst_0
    //   3993: istore 5
    //   3995: lconst_0
    //   3996: lstore 18
    //   3998: lconst_0
    //   3999: lstore 16
    //   4001: lconst_0
    //   4002: lstore 26
    //   4004: dconst_0
    //   4005: dstore_1
    //   4006: iconst_0
    //   4007: istore 9
    //   4009: iload 10
    //   4011: istore 8
    //   4013: lload 22
    //   4015: lstore 14
    //   4017: iload 6
    //   4019: istore 7
    //   4021: lload 28
    //   4023: lstore 20
    //   4025: iload 9
    //   4027: istore 6
    //   4029: goto -1053 -> 2976
    //   4032: astore 36
    //   4034: lload 14
    //   4036: lstore 20
    //   4038: iconst_0
    //   4039: istore 6
    //   4041: lload 26
    //   4043: lstore 14
    //   4045: lload 18
    //   4047: lstore 26
    //   4049: lload 22
    //   4051: lstore 18
    //   4053: goto -1077 -> 2976
    //   4056: astore 36
    //   4058: lload 14
    //   4060: lstore 26
    //   4062: iconst_0
    //   4063: istore 9
    //   4065: lload 20
    //   4067: lstore 14
    //   4069: iload 6
    //   4071: istore 7
    //   4073: lload 26
    //   4075: lstore 20
    //   4077: iload 9
    //   4079: istore 6
    //   4081: lload 18
    //   4083: lstore 26
    //   4085: lload 22
    //   4087: lstore 18
    //   4089: goto -1113 -> 2976
    //   4092: astore 36
    //   4094: lload 14
    //   4096: lstore 26
    //   4098: iconst_0
    //   4099: istore 9
    //   4101: iload 7
    //   4103: istore 8
    //   4105: lload 20
    //   4107: lstore 14
    //   4109: iload 6
    //   4111: istore 7
    //   4113: lload 26
    //   4115: lstore 20
    //   4117: iload 9
    //   4119: istore 6
    //   4121: lload 18
    //   4123: lstore 26
    //   4125: lload 22
    //   4127: lstore 18
    //   4129: goto -1153 -> 2976
    //   4132: astore 36
    //   4134: lload 14
    //   4136: lstore 26
    //   4138: iconst_0
    //   4139: istore 9
    //   4141: iload 7
    //   4143: istore 8
    //   4145: lload 20
    //   4147: lstore 14
    //   4149: iload 6
    //   4151: istore 7
    //   4153: lload 26
    //   4155: lstore 20
    //   4157: iload 9
    //   4159: istore 6
    //   4161: lload 18
    //   4163: lstore 26
    //   4165: lload 22
    //   4167: lstore 18
    //   4169: goto -1193 -> 2976
    //   4172: astore 36
    //   4174: lload 14
    //   4176: lstore 26
    //   4178: iconst_0
    //   4179: istore 9
    //   4181: lload 20
    //   4183: lstore 14
    //   4185: iload 7
    //   4187: istore 8
    //   4189: iload 6
    //   4191: istore 7
    //   4193: lload 26
    //   4195: lstore 20
    //   4197: iload 9
    //   4199: istore 6
    //   4201: lload 18
    //   4203: lstore 26
    //   4205: lload 22
    //   4207: lstore 18
    //   4209: goto -1233 -> 2976
    //   4212: astore 36
    //   4214: iconst_0
    //   4215: istore 9
    //   4217: lload 14
    //   4219: lstore 26
    //   4221: iload 7
    //   4223: istore 8
    //   4225: lload 20
    //   4227: lstore 14
    //   4229: iload 6
    //   4231: istore 7
    //   4233: lload 26
    //   4235: lstore 20
    //   4237: iload 9
    //   4239: istore 6
    //   4241: lload 18
    //   4243: lstore 26
    //   4245: lload 22
    //   4247: lstore 18
    //   4249: goto -1273 -> 2976
    //   4252: astore 36
    //   4254: iconst_0
    //   4255: istore 6
    //   4257: lload 20
    //   4259: lstore 16
    //   4261: lload 14
    //   4263: lstore 22
    //   4265: lload 26
    //   4267: lstore 14
    //   4269: lload 28
    //   4271: lstore 20
    //   4273: lload 18
    //   4275: lstore 26
    //   4277: lload 16
    //   4279: lstore 18
    //   4281: lload 22
    //   4283: lstore 16
    //   4285: goto -1309 -> 2976
    //   4288: astore 36
    //   4290: iconst_0
    //   4291: istore 6
    //   4293: lload 20
    //   4295: lstore 22
    //   4297: lload 26
    //   4299: lstore 14
    //   4301: lload 28
    //   4303: lstore 20
    //   4305: lload 18
    //   4307: lstore 26
    //   4309: lload 22
    //   4311: lstore 18
    //   4313: goto -1337 -> 2976
    //   4316: astore 36
    //   4318: iload 6
    //   4320: istore 5
    //   4322: lload 20
    //   4324: lstore 22
    //   4326: iconst_0
    //   4327: istore 6
    //   4329: lload 26
    //   4331: lstore 14
    //   4333: lload 28
    //   4335: lstore 20
    //   4337: lload 18
    //   4339: lstore 26
    //   4341: lload 22
    //   4343: lstore 18
    //   4345: goto -1369 -> 2976
    //   4348: astore 36
    //   4350: iload 13
    //   4352: istore 8
    //   4354: iload 12
    //   4356: istore 7
    //   4358: lload 28
    //   4360: lstore 20
    //   4362: iload 9
    //   4364: istore 5
    //   4366: goto -3898 -> 468
    //   4369: astore 36
    //   4371: lload 22
    //   4373: lstore 28
    //   4375: lload 16
    //   4377: lstore 30
    //   4379: lload 26
    //   4381: lstore 22
    //   4383: lload 14
    //   4385: lstore 20
    //   4387: lload 18
    //   4389: lstore 14
    //   4391: lload 28
    //   4393: lstore 16
    //   4395: lload 30
    //   4397: lstore 18
    //   4399: goto -3931 -> 468
    //   4402: astore 36
    //   4404: lload 22
    //   4406: lstore 26
    //   4408: lload 16
    //   4410: lstore 28
    //   4412: lload 20
    //   4414: lstore 22
    //   4416: iload 6
    //   4418: istore 7
    //   4420: lload 14
    //   4422: lstore 20
    //   4424: lload 18
    //   4426: lstore 14
    //   4428: lload 26
    //   4430: lstore 16
    //   4432: lload 28
    //   4434: lstore 18
    //   4436: goto -3968 -> 468
    //   4439: astore 36
    //   4441: lload 22
    //   4443: lstore 26
    //   4445: lload 16
    //   4447: lstore 28
    //   4449: iload 7
    //   4451: istore 8
    //   4453: lload 20
    //   4455: lstore 22
    //   4457: iload 6
    //   4459: istore 7
    //   4461: lload 14
    //   4463: lstore 20
    //   4465: lload 18
    //   4467: lstore 14
    //   4469: lload 26
    //   4471: lstore 16
    //   4473: lload 28
    //   4475: lstore 18
    //   4477: goto -4009 -> 468
    //   4480: astore 36
    //   4482: lload 22
    //   4484: lstore 26
    //   4486: lload 16
    //   4488: lstore 28
    //   4490: iload 7
    //   4492: istore 8
    //   4494: lload 20
    //   4496: lstore 22
    //   4498: iload 6
    //   4500: istore 7
    //   4502: lload 14
    //   4504: lstore 20
    //   4506: lload 18
    //   4508: lstore 14
    //   4510: lload 26
    //   4512: lstore 16
    //   4514: lload 28
    //   4516: lstore 18
    //   4518: goto -4050 -> 468
    //   4521: astore 36
    //   4523: lload 16
    //   4525: lstore 26
    //   4527: lload 22
    //   4529: lstore 16
    //   4531: iload 7
    //   4533: istore 8
    //   4535: lload 20
    //   4537: lstore 22
    //   4539: iload 6
    //   4541: istore 7
    //   4543: lload 14
    //   4545: lstore 20
    //   4547: lload 18
    //   4549: lstore 14
    //   4551: lload 26
    //   4553: lstore 18
    //   4555: goto -4087 -> 468
    //   4558: astore 36
    //   4560: lload 20
    //   4562: lstore 30
    //   4564: lload 16
    //   4566: lstore 32
    //   4568: lload 18
    //   4570: lstore 14
    //   4572: lload 26
    //   4574: lstore 22
    //   4576: lload 28
    //   4578: lstore 20
    //   4580: lload 30
    //   4582: lstore 16
    //   4584: lload 32
    //   4586: lstore 18
    //   4588: goto -4120 -> 468
    //   4591: astore 36
    //   4593: iload 6
    //   4595: istore 5
    //   4597: lload 20
    //   4599: lstore 30
    //   4601: lload 16
    //   4603: lstore 32
    //   4605: lload 18
    //   4607: lstore 14
    //   4609: lload 26
    //   4611: lstore 22
    //   4613: lload 28
    //   4615: lstore 20
    //   4617: lload 30
    //   4619: lstore 16
    //   4621: lload 32
    //   4623: lstore 18
    //   4625: goto -4157 -> 468
    //   4628: goto -3217 -> 1411
    //   4631: iconst_m1
    //   4632: istore 11
    //   4634: goto -4331 -> 303
    //   4637: lload 18
    //   4639: l2i
    //   4640: istore 6
    //   4642: lload 20
    //   4644: lconst_0
    //   4645: lcmp
    //   4646: ifne -762 -> 3884
    //   4649: ldc2_w 230
    //   4652: lstore 18
    //   4654: goto -3715 -> 939
    //   4657: iload 8
    //   4659: ifle -3319 -> 1340
    //   4662: iload 8
    //   4664: sipush 500
    //   4667: if_icmpge -3327 -> 1340
    //   4670: iconst_1
    //   4671: istore 6
    //   4673: goto -3451 -> 1222
    //   4676: lload 14
    //   4678: l2i
    //   4679: istore 6
    //   4681: lload 28
    //   4683: lconst_0
    //   4684: lcmp
    //   4685: ifne -1803 -> 2882
    //   4688: ldc2_w 230
    //   4691: lstore 14
    //   4693: goto -2074 -> 2619
    //   4696: lload 14
    //   4698: l2i
    //   4699: istore 6
    //   4701: lload 20
    //   4703: lconst_0
    //   4704: lcmp
    //   4705: ifne -747 -> 3958
    //   4708: ldc2_w 230
    //   4711: lstore 14
    //   4713: goto -1106 -> 3607
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4716	0	this	exw
    //   41	3965	1	d1	double
    //   1624	3	3	d2	double
    //   80	4516	5	i	int
    //   57	4643	6	j	int
    //   60	4482	7	k	int
    //   72	4596	8	m	int
    //   38	4325	9	n	int
    //   69	3941	10	i1	int
    //   163	4470	11	i2	int
    //   54	4301	12	i3	int
    //   66	4285	13	i4	int
    //   48	4664	14	l1	long
    //   35	4585	16	l2	long
    //   32	4621	18	l3	long
    //   318	4384	20	l4	long
    //   63	4549	22	l5	long
    //   75	3884	24	l6	long
    //   333	4277	26	l7	long
    //   51	4631	28	l8	long
    //   306	4312	30	l9	long
    //   4566	56	32	l10	long
    //   45	3748	34	l11	long
    //   218	110	36	arrayOfByte1	byte[]
    //   442	131	36	localThrowable1	java.lang.Throwable
    //   715	682	36	localObject1	java.lang.Object
    //   1883	1	36	localThrowable2	java.lang.Throwable
    //   2144	671	36	localObject2	java.lang.Object
    //   2840	3	36	localThrowable3	java.lang.Throwable
    //   2850	15	36	localException1	java.lang.Exception
    //   2892	23	36	localException2	java.lang.Exception
    //   2951	901	36	localObject3	java.lang.Object
    //   3864	3	36	localThrowable4	java.lang.Throwable
    //   3894	15	36	localException3	java.lang.Exception
    //   3990	1	36	localObject4	java.lang.Object
    //   4032	1	36	localObject5	java.lang.Object
    //   4056	1	36	localObject6	java.lang.Object
    //   4092	1	36	localObject7	java.lang.Object
    //   4132	1	36	localObject8	java.lang.Object
    //   4172	1	36	localObject9	java.lang.Object
    //   4212	1	36	localObject10	java.lang.Object
    //   4252	1	36	localObject11	java.lang.Object
    //   4288	1	36	localObject12	java.lang.Object
    //   4316	1	36	localObject13	java.lang.Object
    //   4348	1	36	localThrowable5	java.lang.Throwable
    //   4369	1	36	localThrowable6	java.lang.Throwable
    //   4402	1	36	localThrowable7	java.lang.Throwable
    //   4439	1	36	localThrowable8	java.lang.Throwable
    //   4480	1	36	localThrowable9	java.lang.Throwable
    //   4521	1	36	localThrowable10	java.lang.Throwable
    //   4558	1	36	localThrowable11	java.lang.Throwable
    //   4591	1	36	localThrowable12	java.lang.Throwable
    //   1655	2148	37	localObject14	java.lang.Object
    //   3916	3	37	localThrowable13	java.lang.Throwable
    //   3926	15	37	localException4	java.lang.Exception
    //   3968	15	37	localException5	java.lang.Exception
    //   132	1738	38	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   335	349	442	java/lang/Throwable
    //   353	366	442	java/lang/Throwable
    //   390	432	442	java/lang/Throwable
    //   432	442	442	java/lang/Throwable
    //   1164	1177	442	java/lang/Throwable
    //   1186	1219	442	java/lang/Throwable
    //   1226	1250	442	java/lang/Throwable
    //   1924	1993	442	java/lang/Throwable
    //   1629	1657	1883	java/lang/Throwable
    //   1657	1703	1883	java/lang/Throwable
    //   1703	1708	1883	java/lang/Throwable
    //   1863	1880	1883	java/lang/Throwable
    //   2013	2020	2840	java/lang/Throwable
    //   2137	2388	2850	java/lang/Exception
    //   2388	2604	2892	java/lang/Exception
    //   2624	2822	2892	java/lang/Exception
    //   2872	2879	2892	java/lang/Exception
    //   2882	2889	2892	java/lang/Exception
    //   468	484	2951	finally
    //   484	526	2951	finally
    //   526	542	2951	finally
    //   542	568	2951	finally
    //   568	577	2951	finally
    //   2914	2948	2951	finally
    //   3830	3861	2951	finally
    //   597	604	3864	java/lang/Throwable
    //   708	924	3894	java/lang/Exception
    //   944	1142	3894	java/lang/Exception
    //   3874	3881	3894	java/lang/Exception
    //   3884	3891	3894	java/lang/Exception
    //   2996	3003	3916	java/lang/Throwable
    //   3125	3376	3926	java/lang/Exception
    //   3376	3592	3968	java/lang/Exception
    //   3612	3810	3968	java/lang/Exception
    //   3948	3955	3968	java/lang/Exception
    //   3958	3965	3968	java/lang/Exception
    //   87	123	3990	finally
    //   123	141	3990	finally
    //   141	165	3990	finally
    //   179	279	3990	finally
    //   279	303	3990	finally
    //   303	308	3990	finally
    //   1370	1378	4032	finally
    //   1383	1404	4032	finally
    //   1411	1438	4032	finally
    //   1456	1483	4056	finally
    //   1483	1511	4056	finally
    //   1511	1538	4056	finally
    //   1538	1546	4056	finally
    //   1549	1587	4056	finally
    //   1587	1596	4092	finally
    //   1609	1625	4132	finally
    //   1629	1657	4172	finally
    //   1657	1703	4172	finally
    //   1703	1708	4172	finally
    //   1863	1880	4172	finally
    //   1741	1764	4212	finally
    //   1768	1801	4212	finally
    //   1819	1824	4212	finally
    //   335	349	4252	finally
    //   353	366	4252	finally
    //   390	432	4252	finally
    //   432	442	4252	finally
    //   1164	1177	4252	finally
    //   1186	1219	4252	finally
    //   1226	1250	4252	finally
    //   1924	1993	4252	finally
    //   1268	1284	4288	finally
    //   1284	1310	4288	finally
    //   1315	1321	4316	finally
    //   87	123	4348	java/lang/Throwable
    //   123	141	4348	java/lang/Throwable
    //   141	165	4348	java/lang/Throwable
    //   179	279	4348	java/lang/Throwable
    //   279	303	4348	java/lang/Throwable
    //   303	308	4348	java/lang/Throwable
    //   1370	1378	4369	java/lang/Throwable
    //   1383	1404	4369	java/lang/Throwable
    //   1411	1438	4369	java/lang/Throwable
    //   1456	1483	4402	java/lang/Throwable
    //   1483	1511	4402	java/lang/Throwable
    //   1511	1538	4402	java/lang/Throwable
    //   1538	1546	4402	java/lang/Throwable
    //   1549	1587	4402	java/lang/Throwable
    //   1587	1596	4439	java/lang/Throwable
    //   1609	1625	4480	java/lang/Throwable
    //   1741	1764	4521	java/lang/Throwable
    //   1768	1801	4521	java/lang/Throwable
    //   1819	1824	4521	java/lang/Throwable
    //   1268	1284	4558	java/lang/Throwable
    //   1284	1310	4558	java/lang/Throwable
    //   1315	1321	4591	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     exw
 * JD-Core Version:    0.7.0.1
 */