import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class qe
  implements Runnable
{
  public qe(QRDisplayActivity paramQRDisplayActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 12	qe:a	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   7: getfield 31	com/tencent/biz/qrcode/activity/QRDisplayActivity:b	Landroid/graphics/Bitmap;
    //   10: astore 8
    //   12: aload 8
    //   14: ifnull +573 -> 587
    //   17: aload 8
    //   19: invokevirtual 37	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifne +565 -> 587
    //   25: new 39	java/io/File
    //   28: dup
    //   29: getstatic 45	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   32: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 51	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: aload 4
    //   45: invokevirtual 54	java/io/File:canWrite	()Z
    //   48: ifeq +539 -> 587
    //   51: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   54: invokestatic 66	java/lang/Long:toString	(J)Ljava/lang/String;
    //   57: astore 4
    //   59: new 68	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   66: getstatic 45	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   69: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 75
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 4
    //   79: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 77
    //   84: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 6
    //   92: new 39	java/io/File
    //   95: dup
    //   96: aload 6
    //   98: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 7
    //   103: iconst_2
    //   104: istore_1
    //   105: aload 7
    //   107: invokevirtual 83	java/io/File:exists	()Z
    //   110: ifeq +69 -> 179
    //   113: iload_1
    //   114: ldc 84
    //   116: if_icmpge +63 -> 179
    //   119: new 68	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   126: getstatic 45	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   129: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 75
    //   134: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 86
    //   144: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload_1
    //   148: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc 91
    //   153: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 6
    //   161: new 39	java/io/File
    //   164: dup
    //   165: aload 6
    //   167: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore 7
    //   172: iload_1
    //   173: iconst_1
    //   174: iadd
    //   175: istore_1
    //   176: goto -71 -> 105
    //   179: new 93	java/io/FileOutputStream
    //   182: dup
    //   183: aload 7
    //   185: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   188: astore 4
    //   190: aload 4
    //   192: astore 5
    //   194: aload 8
    //   196: getstatic 102	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 75
    //   201: aload 4
    //   203: invokevirtual 106	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   206: istore_2
    //   207: aload 4
    //   209: ifnull +375 -> 584
    //   212: aload 4
    //   214: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   217: iload_2
    //   218: istore_3
    //   219: aload 6
    //   221: astore 4
    //   223: iload_2
    //   224: ifne +29 -> 253
    //   227: iload_2
    //   228: istore_3
    //   229: aload 6
    //   231: astore 4
    //   233: aload 7
    //   235: invokevirtual 83	java/io/File:exists	()Z
    //   238: ifeq +15 -> 253
    //   241: aload 7
    //   243: invokevirtual 112	java/io/File:delete	()Z
    //   246: pop
    //   247: aload 6
    //   249: astore 4
    //   251: iload_2
    //   252: istore_3
    //   253: aload_0
    //   254: getfield 12	qe:a	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   257: new 114	qf
    //   260: dup
    //   261: aload_0
    //   262: iload_3
    //   263: aload 4
    //   265: invokespecial 117	qf:<init>	(Lqe;ZLjava/lang/String;)V
    //   268: invokevirtual 121	com/tencent/biz/qrcode/activity/QRDisplayActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   271: return
    //   272: astore 4
    //   274: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +15 -> 292
    //   280: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   283: iconst_2
    //   284: aload 4
    //   286: invokevirtual 131	java/io/IOException:getMessage	()Ljava/lang/String;
    //   289: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -75 -> 217
    //   295: astore 8
    //   297: aload 5
    //   299: astore 4
    //   301: aload 8
    //   303: astore 5
    //   305: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +15 -> 323
    //   311: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   314: iconst_2
    //   315: aload 5
    //   317: invokevirtual 136	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   320: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload 4
    //   325: ifnull +254 -> 579
    //   328: aload 4
    //   330: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   333: iconst_0
    //   334: istore_2
    //   335: goto -118 -> 217
    //   338: astore 4
    //   340: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +15 -> 358
    //   346: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   349: iconst_2
    //   350: aload 4
    //   352: invokevirtual 131	java/io/IOException:getMessage	()Ljava/lang/String;
    //   355: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: iconst_0
    //   359: istore_2
    //   360: goto -143 -> 217
    //   363: astore 8
    //   365: aconst_null
    //   366: astore 4
    //   368: aload 4
    //   370: astore 5
    //   372: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +19 -> 394
    //   378: aload 4
    //   380: astore 5
    //   382: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   385: iconst_2
    //   386: aload 8
    //   388: invokevirtual 137	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   391: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload 4
    //   396: ifnull +183 -> 579
    //   399: aload 4
    //   401: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   404: iconst_0
    //   405: istore_2
    //   406: goto -189 -> 217
    //   409: astore 4
    //   411: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +15 -> 429
    //   417: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   420: iconst_2
    //   421: aload 4
    //   423: invokevirtual 131	java/io/IOException:getMessage	()Ljava/lang/String;
    //   426: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iconst_0
    //   430: istore_2
    //   431: goto -214 -> 217
    //   434: astore 8
    //   436: aconst_null
    //   437: astore 4
    //   439: aload 4
    //   441: astore 5
    //   443: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +19 -> 465
    //   449: aload 4
    //   451: astore 5
    //   453: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   456: iconst_2
    //   457: aload 8
    //   459: invokevirtual 138	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   462: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: aload 4
    //   467: ifnull +112 -> 579
    //   470: aload 4
    //   472: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   475: iconst_0
    //   476: istore_2
    //   477: goto -260 -> 217
    //   480: astore 4
    //   482: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +15 -> 500
    //   488: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   491: iconst_2
    //   492: aload 4
    //   494: invokevirtual 131	java/io/IOException:getMessage	()Ljava/lang/String;
    //   497: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: iconst_0
    //   501: istore_2
    //   502: goto -285 -> 217
    //   505: astore 4
    //   507: aconst_null
    //   508: astore 5
    //   510: aload 5
    //   512: ifnull +8 -> 520
    //   515: aload 5
    //   517: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   520: aload 4
    //   522: athrow
    //   523: astore 5
    //   525: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq -8 -> 520
    //   531: getstatic 128	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   534: iconst_2
    //   535: aload 5
    //   537: invokevirtual 131	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto -23 -> 520
    //   546: astore 4
    //   548: goto -38 -> 510
    //   551: astore 6
    //   553: aload 4
    //   555: astore 5
    //   557: aload 6
    //   559: astore 4
    //   561: goto -51 -> 510
    //   564: astore 8
    //   566: goto -127 -> 439
    //   569: astore 8
    //   571: goto -203 -> 368
    //   574: astore 5
    //   576: goto -271 -> 305
    //   579: iconst_0
    //   580: istore_2
    //   581: goto -364 -> 217
    //   584: goto -367 -> 217
    //   587: aconst_null
    //   588: astore 4
    //   590: iconst_0
    //   591: istore_3
    //   592: goto -339 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	qe
    //   104	72	1	i	int
    //   206	375	2	bool1	boolean
    //   218	374	3	bool2	boolean
    //   35	229	4	localObject1	Object
    //   272	13	4	localIOException1	java.io.IOException
    //   299	30	4	localObject2	Object
    //   338	13	4	localIOException2	java.io.IOException
    //   366	34	4	localObject3	Object
    //   409	13	4	localIOException3	java.io.IOException
    //   437	34	4	localObject4	Object
    //   480	13	4	localIOException4	java.io.IOException
    //   505	16	4	localObject5	Object
    //   546	8	4	localObject6	Object
    //   559	30	4	localObject7	Object
    //   1	515	5	localObject8	Object
    //   523	13	5	localIOException5	java.io.IOException
    //   555	1	5	localObject9	Object
    //   574	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   90	158	6	str	java.lang.String
    //   551	7	6	localObject10	Object
    //   101	141	7	localFile	java.io.File
    //   10	185	8	localBitmap	android.graphics.Bitmap
    //   295	7	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   363	24	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   434	24	8	localIllegalStateException1	java.lang.IllegalStateException
    //   564	1	8	localIllegalStateException2	java.lang.IllegalStateException
    //   569	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   212	217	272	java/io/IOException
    //   179	190	295	java/io/FileNotFoundException
    //   328	333	338	java/io/IOException
    //   179	190	363	java/lang/OutOfMemoryError
    //   399	404	409	java/io/IOException
    //   179	190	434	java/lang/IllegalStateException
    //   470	475	480	java/io/IOException
    //   179	190	505	finally
    //   515	520	523	java/io/IOException
    //   194	207	546	finally
    //   372	378	546	finally
    //   382	394	546	finally
    //   443	449	546	finally
    //   453	465	546	finally
    //   305	323	551	finally
    //   194	207	564	java/lang/IllegalStateException
    //   194	207	569	java/lang/OutOfMemoryError
    //   194	207	574	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     qe
 * JD-Core Version:    0.7.0.1
 */