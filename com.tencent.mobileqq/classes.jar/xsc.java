import android.content.Context;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler;
import mqq.os.MqqHandler;

public class xsc
  implements Runnable
{
  public xsc(GuideVideoHandler paramGuideVideoHandler, Context paramContext, int paramInt, MqqHandler paramMqqHandler) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 36	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: new 38	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   12: ldc 41
    //   14: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 17	xsc:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   21: invokevirtual 51	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: invokevirtual 55	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 57
    //   32: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 58
    //   37: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 70	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   46: astore 11
    //   48: aconst_null
    //   49: astore 9
    //   51: aconst_null
    //   52: astore 7
    //   54: new 72	android/media/MediaMetadataRetriever
    //   57: dup
    //   58: invokespecial 73	android/media/MediaMetadataRetriever:<init>	()V
    //   61: astore 10
    //   63: aload 10
    //   65: aload_0
    //   66: getfield 17	xsc:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   69: aload 11
    //   71: invokevirtual 77	android/media/MediaMetadataRetriever:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   74: aload 10
    //   76: aload_0
    //   77: getfield 19	xsc:jdField_a_of_type_Int	I
    //   80: sipush 1000
    //   83: imul
    //   84: i2l
    //   85: invokevirtual 81	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   88: astore 7
    //   90: aload 7
    //   92: ifnonnull +79 -> 171
    //   95: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +11 -> 109
    //   101: ldc 89
    //   103: iconst_2
    //   104: ldc 91
    //   106: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   113: bipush 101
    //   115: invokevirtual 101	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   118: pop
    //   119: aload_0
    //   120: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   123: invokevirtual 105	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   126: astore 8
    //   128: aload 8
    //   130: aconst_null
    //   131: putfield 111	android/os/Message:obj	Ljava/lang/Object;
    //   134: aload 8
    //   136: bipush 101
    //   138: putfield 114	android/os/Message:what	I
    //   141: aload_0
    //   142: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   145: aload 8
    //   147: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   150: pop
    //   151: aload 7
    //   153: ifnull +3 -> 156
    //   156: aload 10
    //   158: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   161: aload_0
    //   162: getfield 15	xsc:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   165: iconst_0
    //   166: invokestatic 126	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   169: pop
    //   170: return
    //   171: aload_0
    //   172: getfield 17	xsc:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   175: invokevirtual 130	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   178: invokevirtual 136	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   181: getfield 141	android/util/DisplayMetrics:widthPixels	I
    //   184: istore_3
    //   185: aload_0
    //   186: getfield 17	xsc:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   189: invokevirtual 130	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   192: invokevirtual 136	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   195: getfield 144	android/util/DisplayMetrics:heightPixels	I
    //   198: istore 4
    //   200: iload_3
    //   201: i2f
    //   202: aload 7
    //   204: invokevirtual 150	android/graphics/Bitmap:getWidth	()I
    //   207: i2f
    //   208: fdiv
    //   209: fstore_1
    //   210: iload 4
    //   212: i2f
    //   213: aload 7
    //   215: invokevirtual 153	android/graphics/Bitmap:getHeight	()I
    //   218: i2f
    //   219: fdiv
    //   220: fstore_2
    //   221: new 155	android/graphics/Matrix
    //   224: dup
    //   225: invokespecial 156	android/graphics/Matrix:<init>	()V
    //   228: astore 8
    //   230: aload 8
    //   232: fload_1
    //   233: fload_2
    //   234: invokevirtual 160	android/graphics/Matrix:postScale	(FF)Z
    //   237: pop
    //   238: aload 7
    //   240: iconst_0
    //   241: iconst_0
    //   242: aload 7
    //   244: invokevirtual 150	android/graphics/Bitmap:getWidth	()I
    //   247: aload 7
    //   249: invokevirtual 153	android/graphics/Bitmap:getHeight	()I
    //   252: aload 8
    //   254: iconst_1
    //   255: invokestatic 164	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   258: astore 8
    //   260: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +50 -> 313
    //   266: ldc 89
    //   268: iconst_2
    //   269: iconst_2
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: ldc 166
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: new 38	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   287: invokestatic 36	java/lang/System:currentTimeMillis	()J
    //   290: lload 5
    //   292: lsub
    //   293: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: ldc 171
    //   298: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 8
    //   303: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: aastore
    //   310: invokestatic 177	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   313: aload_0
    //   314: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   317: invokevirtual 105	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   320: astore 9
    //   322: aload 9
    //   324: aload 8
    //   326: putfield 111	android/os/Message:obj	Ljava/lang/Object;
    //   329: aload 9
    //   331: bipush 101
    //   333: putfield 114	android/os/Message:what	I
    //   336: aload_0
    //   337: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   340: aload 9
    //   342: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   345: pop
    //   346: aload 8
    //   348: aload 7
    //   350: if_acmpeq +3 -> 353
    //   353: aload 10
    //   355: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   358: aload_0
    //   359: getfield 15	xsc:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   362: iconst_0
    //   363: invokestatic 126	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   366: pop
    //   367: return
    //   368: astore 8
    //   370: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +11 -> 384
    //   376: ldc 89
    //   378: iconst_2
    //   379: ldc 179
    //   381: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload_0
    //   385: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   388: invokevirtual 105	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   391: astore 8
    //   393: aload 8
    //   395: aconst_null
    //   396: putfield 111	android/os/Message:obj	Ljava/lang/Object;
    //   399: aload 8
    //   401: bipush 101
    //   403: putfield 114	android/os/Message:what	I
    //   406: aload_0
    //   407: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   410: aload 8
    //   412: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   415: pop
    //   416: iconst_0
    //   417: ifeq +3 -> 420
    //   420: aload 7
    //   422: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   425: aload_0
    //   426: getfield 15	xsc:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   429: iconst_0
    //   430: invokestatic 126	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   433: pop
    //   434: return
    //   435: astore 7
    //   437: aconst_null
    //   438: astore 10
    //   440: aconst_null
    //   441: astore 9
    //   443: aconst_null
    //   444: astore 8
    //   446: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +20 -> 469
    //   452: ldc 89
    //   454: iconst_2
    //   455: aload 7
    //   457: iconst_1
    //   458: anewarray 4	java/lang/Object
    //   461: dup
    //   462: iconst_0
    //   463: ldc 181
    //   465: aastore
    //   466: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   469: new 38	java/lang/StringBuilder
    //   472: dup
    //   473: ldc 186
    //   475: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   478: astore 12
    //   480: aload 12
    //   482: ldc 191
    //   484: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 11
    //   489: invokevirtual 192	android/net/Uri:toString	()Ljava/lang/String;
    //   492: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc 194
    //   497: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 12
    //   503: ldc 196
    //   505: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: getstatic 202	android/os/Build:BRAND	Ljava/lang/String;
    //   511: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc 204
    //   516: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: getstatic 207	android/os/Build:MODEL	Ljava/lang/String;
    //   522: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc 194
    //   527: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 12
    //   533: ldc 209
    //   535: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 7
    //   540: invokevirtual 210	java/lang/Exception:toString	()Ljava/lang/String;
    //   543: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 7
    //   549: ldc 212
    //   551: aload 12
    //   553: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 218	com/tencent/mobileqq/statistics/QQCatchedExceptionReporter:reportQQCatchedException	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_0
    //   560: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   563: invokevirtual 105	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   566: astore 7
    //   568: aload 7
    //   570: aconst_null
    //   571: putfield 111	android/os/Message:obj	Ljava/lang/Object;
    //   574: aload 7
    //   576: bipush 101
    //   578: putfield 114	android/os/Message:what	I
    //   581: aload_0
    //   582: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   585: aload 7
    //   587: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   590: pop
    //   591: iconst_0
    //   592: ifeq +3 -> 595
    //   595: aload 10
    //   597: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   600: aload_0
    //   601: getfield 15	xsc:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   604: iconst_0
    //   605: invokestatic 126	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   608: pop
    //   609: return
    //   610: astore 7
    //   612: aconst_null
    //   613: astore 10
    //   615: aconst_null
    //   616: astore 8
    //   618: aload_0
    //   619: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   622: invokevirtual 105	mqq/os/MqqHandler:obtainMessage	()Landroid/os/Message;
    //   625: astore 11
    //   627: aload 11
    //   629: aload 8
    //   631: putfield 111	android/os/Message:obj	Ljava/lang/Object;
    //   634: aload 11
    //   636: bipush 101
    //   638: putfield 114	android/os/Message:what	I
    //   641: aload_0
    //   642: getfield 21	xsc:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   645: aload 11
    //   647: invokevirtual 118	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   650: pop
    //   651: aload 8
    //   653: aload 9
    //   655: if_acmpeq +3 -> 658
    //   658: aload 10
    //   660: invokevirtual 121	android/media/MediaMetadataRetriever:release	()V
    //   663: aload_0
    //   664: getfield 15	xsc:jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler	Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;
    //   667: iconst_0
    //   668: invokestatic 126	com/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler:a	(Lcom/tencent/mobileqq/activity/registerGuideLogin/GuideVideoHandler;Z)Z
    //   671: pop
    //   672: aload 7
    //   674: athrow
    //   675: astore 7
    //   677: aconst_null
    //   678: astore 8
    //   680: goto -62 -> 618
    //   683: astore 8
    //   685: aload 7
    //   687: astore 9
    //   689: aload 8
    //   691: astore 7
    //   693: aconst_null
    //   694: astore 8
    //   696: goto -78 -> 618
    //   699: astore 11
    //   701: aload 7
    //   703: astore 9
    //   705: aload 11
    //   707: astore 7
    //   709: goto -91 -> 618
    //   712: astore 8
    //   714: aload 7
    //   716: astore 10
    //   718: aload 8
    //   720: astore 7
    //   722: aconst_null
    //   723: astore 8
    //   725: aconst_null
    //   726: astore 9
    //   728: goto -110 -> 618
    //   731: astore 7
    //   733: goto -115 -> 618
    //   736: astore 7
    //   738: goto -298 -> 440
    //   741: astore 7
    //   743: aload 10
    //   745: astore 7
    //   747: goto -377 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	this	xsc
    //   209	24	1	f1	float
    //   220	14	2	f2	float
    //   184	17	3	i	int
    //   198	13	4	j	int
    //   3	288	5	l	long
    //   52	369	7	localBitmap	android.graphics.Bitmap
    //   435	113	7	localException1	java.lang.Exception
    //   566	20	7	localMessage1	android.os.Message
    //   610	63	7	localObject1	Object
    //   675	11	7	localObject2	Object
    //   691	30	7	localObject3	Object
    //   731	1	7	localObject4	Object
    //   736	1	7	localException2	java.lang.Exception
    //   741	1	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   745	1	7	localObject5	Object
    //   126	221	8	localObject6	Object
    //   368	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   391	288	8	localMessage2	android.os.Message
    //   683	7	8	localObject7	Object
    //   694	1	8	localObject8	Object
    //   712	7	8	localObject9	Object
    //   723	1	8	localObject10	Object
    //   49	678	9	localObject11	Object
    //   61	683	10	localObject12	Object
    //   46	600	11	localObject13	Object
    //   699	7	11	localObject14	Object
    //   478	74	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	63	368	java/lang/OutOfMemoryError
    //   54	63	435	java/lang/Exception
    //   54	63	610	finally
    //   63	90	675	finally
    //   95	109	683	finally
    //   109	119	683	finally
    //   171	260	683	finally
    //   260	313	699	finally
    //   370	384	712	finally
    //   446	469	731	finally
    //   469	559	731	finally
    //   63	90	736	java/lang/Exception
    //   95	109	736	java/lang/Exception
    //   109	119	736	java/lang/Exception
    //   171	260	736	java/lang/Exception
    //   260	313	736	java/lang/Exception
    //   63	90	741	java/lang/OutOfMemoryError
    //   95	109	741	java/lang/OutOfMemoryError
    //   109	119	741	java/lang/OutOfMemoryError
    //   171	260	741	java/lang/OutOfMemoryError
    //   260	313	741	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsc
 * JD-Core Version:    0.7.0.1
 */