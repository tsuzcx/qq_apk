import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class bmk
  implements Runnable
{
  public bmk(QRDisplayActivity paramQRDisplayActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 12	bmk:a	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   7: getfield 29	com/tencent/biz/qrcode/activity/QRDisplayActivity:b	Landroid/graphics/Bitmap;
    //   10: astore 8
    //   12: aload 8
    //   14: ifnull +493 -> 507
    //   17: aload 8
    //   19: invokevirtual 35	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifne +485 -> 507
    //   25: new 37	java/io/File
    //   28: dup
    //   29: getstatic 43	com/tencent/mobileqq/app/AppConstants:ap	Ljava/lang/String;
    //   32: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 4
    //   37: aload 4
    //   39: invokevirtual 49	java/io/File:mkdirs	()Z
    //   42: pop
    //   43: aload 4
    //   45: invokevirtual 52	java/io/File:canWrite	()Z
    //   48: ifeq +459 -> 507
    //   51: invokestatic 58	java/lang/System:currentTimeMillis	()J
    //   54: invokestatic 64	java/lang/Long:toString	(J)Ljava/lang/String;
    //   57: astore 5
    //   59: new 66	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   66: getstatic 43	com/tencent/mobileqq/app/AppConstants:ap	Ljava/lang/String;
    //   69: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 73
    //   74: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 5
    //   79: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 75
    //   84: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 4
    //   92: new 37	java/io/File
    //   95: dup
    //   96: aload 4
    //   98: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 7
    //   103: iconst_2
    //   104: istore_1
    //   105: aload 7
    //   107: invokevirtual 81	java/io/File:exists	()Z
    //   110: ifeq +69 -> 179
    //   113: iload_1
    //   114: ldc 82
    //   116: if_icmpge +63 -> 179
    //   119: new 66	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   126: getstatic 43	com/tencent/mobileqq/app/AppConstants:ap	Ljava/lang/String;
    //   129: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 73
    //   134: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 5
    //   139: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 84
    //   144: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload_1
    //   148: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: ldc 89
    //   153: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 4
    //   161: new 37	java/io/File
    //   164: dup
    //   165: aload 4
    //   167: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore 7
    //   172: iload_1
    //   173: iconst_1
    //   174: iadd
    //   175: istore_1
    //   176: goto -71 -> 105
    //   179: new 91	java/io/FileOutputStream
    //   182: dup
    //   183: aload 7
    //   185: invokespecial 94	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   188: astore 5
    //   190: aload 5
    //   192: astore 6
    //   194: aload 8
    //   196: getstatic 100	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 75
    //   201: aload 5
    //   203: invokevirtual 104	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   206: istore_2
    //   207: aload 5
    //   209: ifnull +295 -> 504
    //   212: aload 5
    //   214: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   217: iload_2
    //   218: istore_3
    //   219: aload 4
    //   221: astore 5
    //   223: iload_2
    //   224: ifne +29 -> 253
    //   227: iload_2
    //   228: istore_3
    //   229: aload 4
    //   231: astore 5
    //   233: aload 7
    //   235: invokevirtual 81	java/io/File:exists	()Z
    //   238: ifeq +15 -> 253
    //   241: aload 7
    //   243: invokevirtual 110	java/io/File:delete	()Z
    //   246: pop
    //   247: aload 4
    //   249: astore 5
    //   251: iload_2
    //   252: istore_3
    //   253: aload_0
    //   254: getfield 12	bmk:a	Lcom/tencent/biz/qrcode/activity/QRDisplayActivity;
    //   257: new 112	bml
    //   260: dup
    //   261: aload_0
    //   262: iload_3
    //   263: aload 5
    //   265: invokespecial 115	bml:<init>	(Lbmk;ZLjava/lang/String;)V
    //   268: invokevirtual 119	com/tencent/biz/qrcode/activity/QRDisplayActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   271: return
    //   272: astore 5
    //   274: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +15 -> 292
    //   280: getstatic 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   283: iconst_2
    //   284: aload 5
    //   286: invokevirtual 129	java/io/IOException:getMessage	()Ljava/lang/String;
    //   289: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -75 -> 217
    //   295: astore 8
    //   297: aload 6
    //   299: astore 5
    //   301: aload 8
    //   303: astore 6
    //   305: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +15 -> 323
    //   311: getstatic 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   314: iconst_2
    //   315: aload 6
    //   317: invokevirtual 134	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   320: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload 5
    //   325: ifnull +174 -> 499
    //   328: aload 5
    //   330: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   333: iconst_0
    //   334: istore_2
    //   335: goto -118 -> 217
    //   338: astore 5
    //   340: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +15 -> 358
    //   346: getstatic 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   349: iconst_2
    //   350: aload 5
    //   352: invokevirtual 129	java/io/IOException:getMessage	()Ljava/lang/String;
    //   355: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: iconst_0
    //   359: istore_2
    //   360: goto -143 -> 217
    //   363: astore 8
    //   365: aconst_null
    //   366: astore 5
    //   368: aload 5
    //   370: astore 6
    //   372: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +19 -> 394
    //   378: aload 5
    //   380: astore 6
    //   382: getstatic 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   385: iconst_2
    //   386: aload 8
    //   388: invokevirtual 135	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   391: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: aload 5
    //   396: ifnull +103 -> 499
    //   399: aload 5
    //   401: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   404: iconst_0
    //   405: istore_2
    //   406: goto -189 -> 217
    //   409: astore 5
    //   411: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +15 -> 429
    //   417: getstatic 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   420: iconst_2
    //   421: aload 5
    //   423: invokevirtual 129	java/io/IOException:getMessage	()Ljava/lang/String;
    //   426: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iconst_0
    //   430: istore_2
    //   431: goto -214 -> 217
    //   434: astore 4
    //   436: aconst_null
    //   437: astore 6
    //   439: aload 6
    //   441: ifnull +8 -> 449
    //   444: aload 6
    //   446: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   449: aload 4
    //   451: athrow
    //   452: astore 5
    //   454: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq -8 -> 449
    //   460: getstatic 126	com/tencent/biz/qrcode/activity/QRDisplayActivity:a	Ljava/lang/String;
    //   463: iconst_2
    //   464: aload 5
    //   466: invokevirtual 129	java/io/IOException:getMessage	()Ljava/lang/String;
    //   469: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: goto -23 -> 449
    //   475: astore 4
    //   477: goto -38 -> 439
    //   480: astore 4
    //   482: aload 5
    //   484: astore 6
    //   486: goto -47 -> 439
    //   489: astore 8
    //   491: goto -123 -> 368
    //   494: astore 6
    //   496: goto -191 -> 305
    //   499: iconst_0
    //   500: istore_2
    //   501: goto -284 -> 217
    //   504: goto -287 -> 217
    //   507: aconst_null
    //   508: astore 5
    //   510: iconst_0
    //   511: istore_3
    //   512: goto -259 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	515	0	this	bmk
    //   104	72	1	i	int
    //   206	295	2	bool1	boolean
    //   218	294	3	bool2	boolean
    //   35	213	4	localObject1	Object
    //   434	16	4	localObject2	Object
    //   475	1	4	localObject3	Object
    //   480	1	4	localObject4	Object
    //   57	207	5	localObject5	Object
    //   272	13	5	localIOException1	java.io.IOException
    //   299	30	5	localObject6	Object
    //   338	13	5	localIOException2	java.io.IOException
    //   366	34	5	localObject7	Object
    //   409	13	5	localIOException3	java.io.IOException
    //   452	31	5	localIOException4	java.io.IOException
    //   508	1	5	localObject8	Object
    //   1	484	6	localObject9	Object
    //   494	1	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   101	141	7	localFile	java.io.File
    //   10	185	8	localBitmap	android.graphics.Bitmap
    //   295	7	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   363	24	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   489	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   212	217	272	java/io/IOException
    //   179	190	295	java/io/FileNotFoundException
    //   328	333	338	java/io/IOException
    //   179	190	363	java/lang/OutOfMemoryError
    //   399	404	409	java/io/IOException
    //   179	190	434	finally
    //   444	449	452	java/io/IOException
    //   194	207	475	finally
    //   372	378	475	finally
    //   382	394	475	finally
    //   305	323	480	finally
    //   194	207	489	java/lang/OutOfMemoryError
    //   194	207	494	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmk
 * JD-Core Version:    0.7.0.1
 */