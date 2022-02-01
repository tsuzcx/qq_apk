import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class akng
{
  public static String bTS;
  public static String bTT;
  public static String bTU;
  public static boolean cte = true;
  
  static
  {
    File localFile1 = new File(acbn.SDCARD_PATH, "ocr");
    bTS = localFile1.getAbsolutePath();
    if ((!localFile1.exists()) && (!localFile1.mkdir()))
    {
      cte = false;
      QLog.d("Q.ocr.image", 1, "WTF! mk ocr dir failed!");
    }
    if (localFile1.exists())
    {
      File localFile2 = new File(bTS, "preview");
      bTT = localFile2.getAbsolutePath();
      if ((!localFile2.exists()) && (!localFile2.mkdir())) {
        QLog.d("Q.ocr.image", 1, "WTF! mk ocr preview dir failed!");
      }
    }
    if (localFile1.exists())
    {
      localFile1 = new File(bTS, "cache");
      bTU = localFile1.getAbsolutePath();
      if ((!localFile1.exists()) && (!localFile1.mkdir())) {
        QLog.d("Q.ocr.image", 1, "mkdir cache dir failed!");
      }
    }
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (paramInt1 >= paramInt2) {}
      paramOptions.inSampleSize += 1;
    }
    return localObject;
    return a(paramString, paramOptions, paramInt1 + 1, paramInt2);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +75 -> 81
    //   9: aload_0
    //   10: ifnull +77 -> 87
    //   13: aload_0
    //   14: arraylength
    //   15: i2l
    //   16: lstore 5
    //   18: ldc 42
    //   20: iconst_2
    //   21: new 89	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   28: ldc 93
    //   30: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: lload 5
    //   35: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc 102
    //   40: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 107
    //   49: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc 109
    //   58: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_3
    //   62: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc 111
    //   67: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 4
    //   72: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: ifnonnull +11 -> 93
    //   85: aconst_null
    //   86: areturn
    //   87: lconst_0
    //   88: lstore 5
    //   90: goto -72 -> 18
    //   93: invokestatic 117	akng:xF	()Ljava/lang/String;
    //   96: iconst_1
    //   97: invokestatic 121	akng:u	(Ljava/lang/String;Z)Ljava/lang/String;
    //   100: astore 9
    //   102: iload_2
    //   103: ifle +19 -> 122
    //   106: iload_1
    //   107: ifle +15 -> 122
    //   110: iload_3
    //   111: bipush 17
    //   113: if_icmpeq +19 -> 132
    //   116: iload_3
    //   117: bipush 20
    //   119: if_icmpeq +13 -> 132
    //   122: ldc 42
    //   124: iconst_1
    //   125: ldc 123
    //   127: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aconst_null
    //   131: areturn
    //   132: aload 9
    //   134: new 125	android/graphics/YuvImage
    //   137: dup
    //   138: aload_0
    //   139: iload_3
    //   140: iload_1
    //   141: iload_2
    //   142: aconst_null
    //   143: invokespecial 128	android/graphics/YuvImage:<init>	([BIII[I)V
    //   146: bipush 100
    //   148: invokestatic 131	akng:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   151: ifne +13 -> 164
    //   154: ldc 42
    //   156: iconst_1
    //   157: ldc 133
    //   159: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 9
    //   166: invokestatic 136	akng:u	(Ljava/lang/String;)[B
    //   169: astore_0
    //   170: aload_0
    //   171: ifnonnull +14 -> 185
    //   174: ldc 42
    //   176: iconst_1
    //   177: ldc 138
    //   179: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 9
    //   184: areturn
    //   185: aload_0
    //   186: new 140	android/graphics/Rect
    //   189: dup
    //   190: iconst_0
    //   191: iconst_0
    //   192: getstatic 145	ankt:SCREEN_WIDTH	I
    //   195: getstatic 148	ankt:cIE	I
    //   198: invokespecial 151	android/graphics/Rect:<init>	(IIII)V
    //   201: iconst_0
    //   202: iconst_0
    //   203: invokestatic 156	aeah:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   206: astore 8
    //   208: aload 8
    //   210: ifnonnull +43 -> 253
    //   213: ldc 42
    //   215: iconst_1
    //   216: ldc 158
    //   218: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: new 16	java/io/File
    //   224: dup
    //   225: aload 9
    //   227: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   230: invokevirtual 37	java/io/File:exists	()Z
    //   233: ifeq +17 -> 250
    //   236: iconst_0
    //   237: ifeq +13 -> 250
    //   240: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   243: aload 9
    //   245: aconst_null
    //   246: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload 9
    //   252: areturn
    //   253: aload 8
    //   255: iload 4
    //   257: iconst_1
    //   258: invokestatic 177	aeah:rotateBitmap	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   261: astore_0
    //   262: aload_0
    //   263: astore 7
    //   265: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +32 -> 300
    //   271: aload_0
    //   272: astore 7
    //   274: ldc 42
    //   276: iconst_2
    //   277: new 89	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   284: ldc 179
    //   286: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 4
    //   291: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: ifnonnull +81 -> 382
    //   304: aload_0
    //   305: astore 7
    //   307: aload 8
    //   309: bipush 100
    //   311: new 16	java/io/File
    //   314: dup
    //   315: aload 9
    //   317: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: invokestatic 185	aqhu:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   323: pop
    //   324: aload_0
    //   325: astore 7
    //   327: ldc 42
    //   329: iconst_1
    //   330: ldc 187
    //   332: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: new 16	java/io/File
    //   338: dup
    //   339: aload 9
    //   341: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: invokevirtual 37	java/io/File:exists	()Z
    //   347: ifeq +17 -> 364
    //   350: aload_0
    //   351: ifnull +13 -> 364
    //   354: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   357: aload 9
    //   359: aload_0
    //   360: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: new 16	java/io/File
    //   367: dup
    //   368: aload 9
    //   370: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   373: invokevirtual 37	java/io/File:exists	()Z
    //   376: ifeq -291 -> 85
    //   379: aload 9
    //   381: areturn
    //   382: aload_0
    //   383: astore 7
    //   385: aload_0
    //   386: bipush 100
    //   388: new 16	java/io/File
    //   391: dup
    //   392: aload 9
    //   394: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: invokestatic 185	aqhu:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   400: pop
    //   401: goto -66 -> 335
    //   404: astore 7
    //   406: aload_0
    //   407: astore 7
    //   409: ldc 42
    //   411: iconst_1
    //   412: ldc 189
    //   414: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_0
    //   418: astore 7
    //   420: aload_0
    //   421: invokestatic 195	aeah:b	(Landroid/graphics/Bitmap;)Z
    //   424: pop
    //   425: new 16	java/io/File
    //   428: dup
    //   429: aload 9
    //   431: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   434: invokevirtual 37	java/io/File:exists	()Z
    //   437: ifeq -73 -> 364
    //   440: aload_0
    //   441: ifnull -77 -> 364
    //   444: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   447: aload 9
    //   449: aload_0
    //   450: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: goto -90 -> 364
    //   457: astore 7
    //   459: aconst_null
    //   460: astore_0
    //   461: aload 7
    //   463: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   466: aload_0
    //   467: invokestatic 195	aeah:b	(Landroid/graphics/Bitmap;)Z
    //   470: pop
    //   471: new 16	java/io/File
    //   474: dup
    //   475: aload 9
    //   477: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   480: invokevirtual 37	java/io/File:exists	()Z
    //   483: ifeq -119 -> 364
    //   486: aload_0
    //   487: ifnull -123 -> 364
    //   490: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   493: aload 9
    //   495: aload_0
    //   496: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: goto -136 -> 364
    //   503: astore_0
    //   504: new 16	java/io/File
    //   507: dup
    //   508: aload 9
    //   510: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: invokevirtual 37	java/io/File:exists	()Z
    //   516: ifeq +19 -> 535
    //   519: aload 7
    //   521: ifnull +14 -> 535
    //   524: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   527: aload 9
    //   529: aload 7
    //   531: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: pop
    //   535: aload_0
    //   536: athrow
    //   537: astore_0
    //   538: goto -34 -> 504
    //   541: astore 8
    //   543: aload_0
    //   544: astore 7
    //   546: aload 8
    //   548: astore_0
    //   549: goto -45 -> 504
    //   552: astore 7
    //   554: goto -93 -> 461
    //   557: astore_0
    //   558: aconst_null
    //   559: astore_0
    //   560: goto -154 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	paramArrayOfByte	byte[]
    //   0	563	1	paramInt1	int
    //   0	563	2	paramInt2	int
    //   0	563	3	paramInt3	int
    //   0	563	4	paramInt4	int
    //   16	73	5	l	long
    //   1	383	7	arrayOfByte1	byte[]
    //   404	1	7	localOutOfMemoryError	OutOfMemoryError
    //   407	12	7	arrayOfByte2	byte[]
    //   457	73	7	localIOException1	java.io.IOException
    //   544	1	7	arrayOfByte3	byte[]
    //   552	1	7	localIOException2	java.io.IOException
    //   206	102	8	localBitmap	Bitmap
    //   541	6	8	localObject	Object
    //   100	428	9	str	String
    // Exception table:
    //   from	to	target	type
    //   265	271	404	java/lang/OutOfMemoryError
    //   274	300	404	java/lang/OutOfMemoryError
    //   307	324	404	java/lang/OutOfMemoryError
    //   327	335	404	java/lang/OutOfMemoryError
    //   385	401	404	java/lang/OutOfMemoryError
    //   185	208	457	java/io/IOException
    //   213	221	457	java/io/IOException
    //   253	262	457	java/io/IOException
    //   185	208	503	finally
    //   213	221	503	finally
    //   253	262	503	finally
    //   265	271	537	finally
    //   274	300	537	finally
    //   307	324	537	finally
    //   327	335	537	finally
    //   385	401	537	finally
    //   409	417	537	finally
    //   420	425	537	finally
    //   461	471	541	finally
    //   265	271	552	java/io/IOException
    //   274	300	552	java/io/IOException
    //   307	324	552	java/io/IOException
    //   327	335	552	java/io/IOException
    //   385	401	552	java/io/IOException
    //   185	208	557	java/lang/OutOfMemoryError
    //   213	221	557	java/lang/OutOfMemoryError
    //   253	262	557	java/lang/OutOfMemoryError
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, null, false);
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, android.graphics.RectF paramRectF, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +85 -> 88
    //   6: aload_0
    //   7: ifnull +87 -> 94
    //   10: aload_0
    //   11: arraylength
    //   12: i2l
    //   13: lstore 9
    //   15: ldc 42
    //   17: iconst_2
    //   18: new 89	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   25: ldc 93
    //   27: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: lload 9
    //   32: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: ldc 102
    //   37: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc 107
    //   46: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_1
    //   50: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc 109
    //   55: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 206
    //   64: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 5
    //   69: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 208
    //   74: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 6
    //   79: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: ifnonnull +11 -> 100
    //   92: aconst_null
    //   93: areturn
    //   94: lconst_0
    //   95: lstore 9
    //   97: goto -82 -> 15
    //   100: invokestatic 117	akng:xF	()Ljava/lang/String;
    //   103: iconst_1
    //   104: invokestatic 121	akng:u	(Ljava/lang/String;Z)Ljava/lang/String;
    //   107: astore 13
    //   109: iload 7
    //   111: ifeq +22 -> 133
    //   114: aload_0
    //   115: astore 11
    //   117: aload 11
    //   119: ifnonnull +86 -> 205
    //   122: ldc 42
    //   124: iconst_1
    //   125: ldc 138
    //   127: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 13
    //   132: areturn
    //   133: iload_2
    //   134: ifle +19 -> 153
    //   137: iload_1
    //   138: ifle +15 -> 153
    //   141: iload_3
    //   142: bipush 17
    //   144: if_icmpeq +19 -> 163
    //   147: iload_3
    //   148: bipush 20
    //   150: if_icmpeq +13 -> 163
    //   153: ldc 42
    //   155: iconst_1
    //   156: ldc 123
    //   158: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aconst_null
    //   162: areturn
    //   163: aload 13
    //   165: new 125	android/graphics/YuvImage
    //   168: dup
    //   169: aload_0
    //   170: iload_3
    //   171: iload_1
    //   172: iload_2
    //   173: aconst_null
    //   174: invokespecial 128	android/graphics/YuvImage:<init>	([BIII[I)V
    //   177: bipush 100
    //   179: invokestatic 131	akng:a	(Ljava/lang/String;Landroid/graphics/YuvImage;I)Z
    //   182: ifne +13 -> 195
    //   185: ldc 42
    //   187: iconst_1
    //   188: ldc 133
    //   190: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aconst_null
    //   194: areturn
    //   195: aload 13
    //   197: invokestatic 136	akng:u	(Ljava/lang/String;)[B
    //   200: astore 11
    //   202: goto -85 -> 117
    //   205: aconst_null
    //   206: astore 12
    //   208: aload 12
    //   210: astore_0
    //   211: aload 11
    //   213: new 140	android/graphics/Rect
    //   216: dup
    //   217: iconst_0
    //   218: iconst_0
    //   219: getstatic 145	ankt:SCREEN_WIDTH	I
    //   222: getstatic 148	ankt:cIE	I
    //   225: invokespecial 151	android/graphics/Rect:<init>	(IIII)V
    //   228: iconst_0
    //   229: iconst_0
    //   230: invokestatic 156	aeah:a	([BLandroid/graphics/Rect;ZI)Landroid/graphics/Bitmap;
    //   233: astore 14
    //   235: aload 14
    //   237: ifnonnull +46 -> 283
    //   240: aload 12
    //   242: astore_0
    //   243: ldc 42
    //   245: iconst_1
    //   246: ldc 158
    //   248: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: new 16	java/io/File
    //   254: dup
    //   255: aload 13
    //   257: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: invokevirtual 37	java/io/File:exists	()Z
    //   263: ifeq +17 -> 280
    //   266: iconst_0
    //   267: ifeq +13 -> 280
    //   270: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   273: aload 13
    //   275: aconst_null
    //   276: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: aload 13
    //   282: areturn
    //   283: aload 12
    //   285: astore_0
    //   286: invokestatic 216	aeab:a	()Laeab;
    //   289: iload 4
    //   291: iload 5
    //   293: invokestatic 219	aeah:a	(Laeab;II)I
    //   296: istore_3
    //   297: aload 12
    //   299: astore_0
    //   300: aload 14
    //   302: iload_3
    //   303: iconst_1
    //   304: invokestatic 177	aeah:rotateBitmap	(Landroid/graphics/Bitmap;IZ)Landroid/graphics/Bitmap;
    //   307: astore 11
    //   309: aload 11
    //   311: astore_0
    //   312: aload_0
    //   313: astore 11
    //   315: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +31 -> 349
    //   321: aload_0
    //   322: astore 11
    //   324: ldc 42
    //   326: iconst_2
    //   327: new 89	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   334: ldc 179
    //   336: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_3
    //   340: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 6
    //   351: ifnull +387 -> 738
    //   354: aload_0
    //   355: ifnull +383 -> 738
    //   358: iload_1
    //   359: istore 4
    //   361: iload_2
    //   362: istore_3
    //   363: iload_1
    //   364: iload_2
    //   365: if_icmple +27 -> 392
    //   368: iload_1
    //   369: istore 4
    //   371: iload_2
    //   372: istore_3
    //   373: aload_0
    //   374: astore 11
    //   376: aload_0
    //   377: invokevirtual 225	android/graphics/Bitmap:getWidth	()I
    //   380: aload_0
    //   381: invokevirtual 228	android/graphics/Bitmap:getHeight	()I
    //   384: if_icmpge +8 -> 392
    //   387: iload_1
    //   388: istore_3
    //   389: iload_2
    //   390: istore 4
    //   392: aload_0
    //   393: astore 11
    //   395: aload 6
    //   397: getfield 234	android/graphics/RectF:left	F
    //   400: iload 4
    //   402: i2f
    //   403: fmul
    //   404: ldc 235
    //   406: fadd
    //   407: iload 4
    //   409: aload_0
    //   410: invokevirtual 225	android/graphics/Bitmap:getWidth	()I
    //   413: isub
    //   414: iconst_2
    //   415: idiv
    //   416: i2f
    //   417: fsub
    //   418: f2i
    //   419: istore_1
    //   420: aload_0
    //   421: astore 11
    //   423: aload 6
    //   425: getfield 238	android/graphics/RectF:top	F
    //   428: iload_3
    //   429: i2f
    //   430: fmul
    //   431: ldc 235
    //   433: fadd
    //   434: iload_3
    //   435: aload_0
    //   436: invokevirtual 228	android/graphics/Bitmap:getHeight	()I
    //   439: isub
    //   440: iconst_2
    //   441: idiv
    //   442: i2f
    //   443: fsub
    //   444: f2i
    //   445: istore 5
    //   447: iload_1
    //   448: ifgt +208 -> 656
    //   451: aload_0
    //   452: astore 11
    //   454: aload_0
    //   455: invokevirtual 225	android/graphics/Bitmap:getWidth	()I
    //   458: istore_2
    //   459: iconst_0
    //   460: istore_1
    //   461: iload 5
    //   463: ifgt +213 -> 676
    //   466: iconst_0
    //   467: istore_3
    //   468: aload_0
    //   469: astore 11
    //   471: aload_0
    //   472: invokevirtual 228	android/graphics/Bitmap:getHeight	()I
    //   475: istore 4
    //   477: aload_0
    //   478: astore 11
    //   480: aload_0
    //   481: iload_1
    //   482: iload_3
    //   483: iload_2
    //   484: iload 4
    //   486: invokestatic 242	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   489: astore 12
    //   491: aload 12
    //   493: astore 6
    //   495: aload_0
    //   496: astore 11
    //   498: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +62 -> 563
    //   504: aload_0
    //   505: astore 11
    //   507: ldc 42
    //   509: iconst_2
    //   510: iconst_3
    //   511: anewarray 4	java/lang/Object
    //   514: dup
    //   515: iconst_0
    //   516: new 89	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   523: ldc 244
    //   525: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 12
    //   530: invokevirtual 225	android/graphics/Bitmap:getWidth	()I
    //   533: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: aastore
    //   540: dup
    //   541: iconst_1
    //   542: ldc 246
    //   544: aastore
    //   545: dup
    //   546: iconst_2
    //   547: aload 12
    //   549: invokevirtual 228	android/graphics/Bitmap:getHeight	()I
    //   552: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   559: aload 12
    //   561: astore 6
    //   563: aload 6
    //   565: ifnonnull +179 -> 744
    //   568: aload 6
    //   570: astore_0
    //   571: aload 6
    //   573: astore 11
    //   575: aload 14
    //   577: bipush 100
    //   579: new 16	java/io/File
    //   582: dup
    //   583: aload 13
    //   585: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   588: invokestatic 185	aqhu:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   591: pop
    //   592: aload 6
    //   594: astore_0
    //   595: aload 6
    //   597: astore 11
    //   599: ldc 42
    //   601: iconst_1
    //   602: ldc 187
    //   604: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: new 16	java/io/File
    //   610: dup
    //   611: aload 13
    //   613: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   616: invokevirtual 37	java/io/File:exists	()Z
    //   619: ifeq +19 -> 638
    //   622: aload 6
    //   624: ifnull +14 -> 638
    //   627: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   630: aload 13
    //   632: aload 6
    //   634: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   637: pop
    //   638: new 16	java/io/File
    //   641: dup
    //   642: aload 13
    //   644: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   647: invokevirtual 37	java/io/File:exists	()Z
    //   650: ifeq +263 -> 913
    //   653: aload 13
    //   655: areturn
    //   656: aload_0
    //   657: astore 11
    //   659: aload 6
    //   661: invokevirtual 259	android/graphics/RectF:width	()F
    //   664: iload 4
    //   666: i2f
    //   667: fmul
    //   668: ldc 235
    //   670: fadd
    //   671: f2i
    //   672: istore_2
    //   673: goto -212 -> 461
    //   676: aload_0
    //   677: astore 11
    //   679: aload 6
    //   681: invokevirtual 262	android/graphics/RectF:height	()F
    //   684: fstore 8
    //   686: fload 8
    //   688: iload_3
    //   689: i2f
    //   690: fmul
    //   691: ldc 235
    //   693: fadd
    //   694: f2i
    //   695: istore 4
    //   697: iload 5
    //   699: istore_3
    //   700: goto -223 -> 477
    //   703: astore 6
    //   705: aload_0
    //   706: astore 11
    //   708: ldc 42
    //   710: iconst_1
    //   711: new 89	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 264
    //   721: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 6
    //   726: invokevirtual 267	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   729: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload_0
    //   739: astore 6
    //   741: goto -178 -> 563
    //   744: aload 6
    //   746: astore_0
    //   747: aload 6
    //   749: astore 11
    //   751: aload 6
    //   753: bipush 100
    //   755: new 16	java/io/File
    //   758: dup
    //   759: aload 13
    //   761: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   764: invokestatic 185	aqhu:b	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   767: pop
    //   768: goto -161 -> 607
    //   771: astore 6
    //   773: aload_0
    //   774: astore 11
    //   776: ldc 42
    //   778: iconst_1
    //   779: ldc 189
    //   781: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   784: aload_0
    //   785: astore 11
    //   787: aload_0
    //   788: invokestatic 195	aeah:b	(Landroid/graphics/Bitmap;)Z
    //   791: pop
    //   792: new 16	java/io/File
    //   795: dup
    //   796: aload 13
    //   798: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   801: invokevirtual 37	java/io/File:exists	()Z
    //   804: ifeq -166 -> 638
    //   807: aload_0
    //   808: ifnull -170 -> 638
    //   811: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   814: aload 13
    //   816: aload_0
    //   817: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   820: pop
    //   821: goto -183 -> 638
    //   824: astore 6
    //   826: aconst_null
    //   827: astore_0
    //   828: aload_0
    //   829: astore 11
    //   831: aload 6
    //   833: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   836: aload_0
    //   837: astore 11
    //   839: aload_0
    //   840: invokestatic 195	aeah:b	(Landroid/graphics/Bitmap;)Z
    //   843: pop
    //   844: new 16	java/io/File
    //   847: dup
    //   848: aload 13
    //   850: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   853: invokevirtual 37	java/io/File:exists	()Z
    //   856: ifeq -218 -> 638
    //   859: aload_0
    //   860: ifnull -222 -> 638
    //   863: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   866: aload 13
    //   868: aload_0
    //   869: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   872: pop
    //   873: goto -235 -> 638
    //   876: astore_0
    //   877: aconst_null
    //   878: astore 11
    //   880: new 16	java/io/File
    //   883: dup
    //   884: aload 13
    //   886: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   889: invokevirtual 37	java/io/File:exists	()Z
    //   892: ifeq +19 -> 911
    //   895: aload 11
    //   897: ifnull +14 -> 911
    //   900: getstatic 167	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   903: aload 13
    //   905: aload 11
    //   907: invokevirtual 173	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   910: pop
    //   911: aload_0
    //   912: athrow
    //   913: aconst_null
    //   914: areturn
    //   915: astore_0
    //   916: goto -36 -> 880
    //   919: astore_0
    //   920: goto -40 -> 880
    //   923: astore 6
    //   925: goto -97 -> 828
    //   928: astore 11
    //   930: aload 6
    //   932: astore_0
    //   933: aload 11
    //   935: astore 6
    //   937: goto -109 -> 828
    //   940: astore 6
    //   942: goto -169 -> 773
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	paramArrayOfByte	byte[]
    //   0	945	1	paramInt1	int
    //   0	945	2	paramInt2	int
    //   0	945	3	paramInt3	int
    //   0	945	4	paramInt4	int
    //   0	945	5	paramInt5	int
    //   0	945	6	paramRectF	android.graphics.RectF
    //   0	945	7	paramBoolean	boolean
    //   684	3	8	f	float
    //   13	83	9	l	long
    //   115	791	11	localObject	Object
    //   928	6	11	localIOException	java.io.IOException
    //   206	354	12	localBitmap1	Bitmap
    //   107	797	13	str	String
    //   233	343	14	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   376	387	703	java/lang/Throwable
    //   395	420	703	java/lang/Throwable
    //   423	447	703	java/lang/Throwable
    //   454	459	703	java/lang/Throwable
    //   471	477	703	java/lang/Throwable
    //   480	491	703	java/lang/Throwable
    //   498	504	703	java/lang/Throwable
    //   507	559	703	java/lang/Throwable
    //   659	673	703	java/lang/Throwable
    //   679	686	703	java/lang/Throwable
    //   211	235	771	java/lang/OutOfMemoryError
    //   243	251	771	java/lang/OutOfMemoryError
    //   286	297	771	java/lang/OutOfMemoryError
    //   300	309	771	java/lang/OutOfMemoryError
    //   575	592	771	java/lang/OutOfMemoryError
    //   599	607	771	java/lang/OutOfMemoryError
    //   751	768	771	java/lang/OutOfMemoryError
    //   211	235	824	java/io/IOException
    //   243	251	824	java/io/IOException
    //   286	297	824	java/io/IOException
    //   300	309	824	java/io/IOException
    //   211	235	876	finally
    //   243	251	876	finally
    //   286	297	876	finally
    //   300	309	876	finally
    //   315	321	915	finally
    //   324	349	915	finally
    //   376	387	915	finally
    //   395	420	915	finally
    //   423	447	915	finally
    //   454	459	915	finally
    //   471	477	915	finally
    //   480	491	915	finally
    //   498	504	915	finally
    //   507	559	915	finally
    //   659	673	915	finally
    //   679	686	915	finally
    //   708	738	915	finally
    //   831	836	915	finally
    //   839	844	915	finally
    //   575	592	919	finally
    //   599	607	919	finally
    //   751	768	919	finally
    //   776	784	919	finally
    //   787	792	919	finally
    //   315	321	923	java/io/IOException
    //   324	349	923	java/io/IOException
    //   376	387	923	java/io/IOException
    //   395	420	923	java/io/IOException
    //   423	447	923	java/io/IOException
    //   454	459	923	java/io/IOException
    //   471	477	923	java/io/IOException
    //   480	491	923	java/io/IOException
    //   498	504	923	java/io/IOException
    //   507	559	923	java/io/IOException
    //   659	673	923	java/io/IOException
    //   679	686	923	java/io/IOException
    //   708	738	923	java/io/IOException
    //   575	592	928	java/io/IOException
    //   599	607	928	java/io/IOException
    //   751	768	928	java/io/IOException
    //   315	321	940	java/lang/OutOfMemoryError
    //   324	349	940	java/lang/OutOfMemoryError
    //   376	387	940	java/lang/OutOfMemoryError
    //   395	420	940	java/lang/OutOfMemoryError
    //   423	447	940	java/lang/OutOfMemoryError
    //   454	459	940	java/lang/OutOfMemoryError
    //   471	477	940	java/lang/OutOfMemoryError
    //   480	491	940	java/lang/OutOfMemoryError
    //   498	504	940	java/lang/OutOfMemoryError
    //   507	559	940	java/lang/OutOfMemoryError
    //   659	673	940	java/lang/OutOfMemoryError
    //   679	686	940	java/lang/OutOfMemoryError
    //   708	738	940	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 16	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 9
    //   13: aconst_null
    //   14: astore 10
    //   16: new 272	java/io/BufferedOutputStream
    //   19: dup
    //   20: new 274	java/io/FileOutputStream
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 277	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 280	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 8
    //   34: aload 8
    //   36: astore 9
    //   38: aload_0
    //   39: aload_2
    //   40: iload_3
    //   41: aload 8
    //   43: invokevirtual 284	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   46: istore 5
    //   48: aload 8
    //   50: astore 9
    //   52: aload 8
    //   54: invokevirtual 287	java/io/BufferedOutputStream:flush	()V
    //   57: iload 4
    //   59: ifeq +11 -> 70
    //   62: aload 8
    //   64: astore 9
    //   66: aload_0
    //   67: invokevirtual 290	android/graphics/Bitmap:recycle	()V
    //   70: iload 5
    //   72: istore 4
    //   74: aload 8
    //   76: ifnull +12 -> 88
    //   79: aload 8
    //   81: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   84: iload 5
    //   86: istore 4
    //   88: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +99 -> 190
    //   94: lconst_0
    //   95: lstore 6
    //   97: new 16	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokevirtual 37	java/io/File:exists	()Z
    //   108: ifeq +20 -> 128
    //   111: new 16	java/io/File
    //   114: dup
    //   115: aload_1
    //   116: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 297	java/io/File:length	()J
    //   122: ldc2_w 298
    //   125: ldiv
    //   126: lstore 6
    //   128: ldc 42
    //   130: iconst_2
    //   131: new 89	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 301
    //   141: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 109
    //   150: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_2
    //   154: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: ldc_w 303
    //   160: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_3
    //   164: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 305
    //   170: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: lload 6
    //   175: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 307
    //   181: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 4
    //   192: ireturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   198: iload 5
    //   200: istore 4
    //   202: goto -114 -> 88
    //   205: astore_0
    //   206: aconst_null
    //   207: astore 8
    //   209: iconst_0
    //   210: istore 5
    //   212: aload 8
    //   214: astore 9
    //   216: ldc 42
    //   218: iconst_1
    //   219: ldc_w 309
    //   222: aload_0
    //   223: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 8
    //   232: ifnull -144 -> 88
    //   235: aload 8
    //   237: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   240: iload 5
    //   242: istore 4
    //   244: goto -156 -> 88
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   252: iload 5
    //   254: istore 4
    //   256: goto -168 -> 88
    //   259: astore_0
    //   260: iconst_0
    //   261: istore 5
    //   263: aload 10
    //   265: astore_0
    //   266: aload_0
    //   267: astore 9
    //   269: ldc 42
    //   271: iconst_1
    //   272: ldc_w 314
    //   275: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload 5
    //   280: istore 4
    //   282: aload_0
    //   283: ifnull -195 -> 88
    //   286: aload_0
    //   287: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   290: iload 5
    //   292: istore 4
    //   294: goto -206 -> 88
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   302: iload 5
    //   304: istore 4
    //   306: goto -218 -> 88
    //   309: astore_0
    //   310: aload 9
    //   312: ifnull +8 -> 320
    //   315: aload 9
    //   317: invokevirtual 293	java/io/BufferedOutputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: aload_1
    //   324: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   327: goto -7 -> 320
    //   330: astore_0
    //   331: goto -21 -> 310
    //   334: astore_0
    //   335: aload 8
    //   337: astore_0
    //   338: iconst_0
    //   339: istore 5
    //   341: goto -75 -> 266
    //   344: astore_0
    //   345: aload 8
    //   347: astore_0
    //   348: goto -82 -> 266
    //   351: astore_0
    //   352: iconst_0
    //   353: istore 5
    //   355: goto -143 -> 212
    //   358: astore_0
    //   359: goto -147 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	paramBitmap	Bitmap
    //   0	362	1	paramString	String
    //   0	362	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	362	3	paramInt	int
    //   0	362	4	paramBoolean	boolean
    //   46	308	5	bool	boolean
    //   95	79	6	l	long
    //   8	338	8	localObject1	Object
    //   11	305	9	localObject2	Object
    //   14	250	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   79	84	193	java/io/IOException
    //   16	34	205	java/lang/Exception
    //   235	240	247	java/io/IOException
    //   16	34	259	java/lang/OutOfMemoryError
    //   286	290	297	java/io/IOException
    //   16	34	309	finally
    //   269	278	309	finally
    //   315	320	322	java/io/IOException
    //   38	48	330	finally
    //   52	57	330	finally
    //   66	70	330	finally
    //   216	226	330	finally
    //   38	48	334	java/lang/OutOfMemoryError
    //   52	57	344	java/lang/OutOfMemoryError
    //   66	70	344	java/lang/OutOfMemoryError
    //   38	48	351	java/lang/Exception
    //   52	57	358	java/lang/Exception
    //   66	70	358	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(String paramString, android.graphics.YuvImage paramYuvImage, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 274	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: aload_1
    //   13: ifnull +31 -> 44
    //   16: aload 5
    //   18: astore_0
    //   19: aload_1
    //   20: new 140	android/graphics/Rect
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: aload_1
    //   27: invokevirtual 316	android/graphics/YuvImage:getWidth	()I
    //   30: aload_1
    //   31: invokevirtual 317	android/graphics/YuvImage:getHeight	()I
    //   34: invokespecial 151	android/graphics/Rect:<init>	(IIII)V
    //   37: iload_2
    //   38: aload 5
    //   40: invokevirtual 321	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   43: pop
    //   44: aload 5
    //   46: astore_0
    //   47: aload 5
    //   49: invokevirtual 322	java/io/FileOutputStream:flush	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: iload 4
    //   57: istore_3
    //   58: aload 5
    //   60: ifnull +11 -> 71
    //   63: aload 5
    //   65: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   68: iload 4
    //   70: istore_3
    //   71: iload_3
    //   72: ireturn
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 6
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: astore_0
    //   86: aload 6
    //   88: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   91: aload_1
    //   92: ifnull -21 -> 71
    //   95: aload_1
    //   96: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_1
    //   130: goto -19 -> 111
    //   133: astore 6
    //   135: aload 5
    //   137: astore_1
    //   138: goto -54 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   0	141	1	paramYuvImage	android.graphics.YuvImage
    //   0	141	2	paramInt	int
    //   1	71	3	bool1	boolean
    //   53	16	4	bool2	boolean
    //   10	126	5	localFileOutputStream	java.io.FileOutputStream
    //   80	7	6	localException1	Exception
    //   133	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   63	68	73	java/io/IOException
    //   2	12	80	java/lang/Exception
    //   95	99	101	java/io/IOException
    //   2	12	108	finally
    //   115	119	121	java/io/IOException
    //   19	44	129	finally
    //   47	52	129	finally
    //   86	91	129	finally
    //   19	44	133	java/lang/Exception
    //   47	52	133	java/lang/Exception
  }
  
  public static boolean bk(String paramString1, String paramString2)
  {
    int j = 10;
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("Q.ocr.image", 1, "compressImage, newImagePath is empty");
      return false;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
    int n = ((BitmapFactory.Options)localObject).outHeight;
    int m = ((BitmapFactory.Options)localObject).outWidth;
    int i;
    label91:
    int k;
    if (aknv.a() != null) {
      if (aknv.a().dnQ < 400)
      {
        i = 400;
        if (aknv.a().picQuality >= 10) {
          break label392;
        }
        k = i;
        i = j;
      }
    }
    for (;;)
    {
      float f;
      if ((m > n) && (n > k)) {
        f = k * 1.0F / n;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.image", 2, "compressImage radio:" + f + ",source file size:" + new File(paramString1).length() + ",shortSide:" + k + ",picQuality:" + i);
        }
        j = (int)(n * f);
        k = (int)(m * f);
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(f, f);
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        localObject = a(paramString1, (BitmapFactory.Options)localObject, 1, 2);
        if (localObject != null)
        {
          if (((Bitmap)localObject).getHeight() <= j)
          {
            paramString1 = (String)localObject;
            if (((Bitmap)localObject).getWidth() <= k) {
              break label309;
            }
          }
          try
          {
            paramString1 = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, false);
            if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
              ((Bitmap)localObject).recycle();
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
              paramString1 = (String)localObject;
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              label309:
              paramString1.printStackTrace();
              label392:
              paramString1 = (String)localObject;
            }
          }
          if (paramString1 != null)
          {
            j = paramString1.getRowBytes();
            k = paramString1.getHeight();
            if (QLog.isColorLevel()) {
              QLog.d("Q.ocr.image", 2, "compressImage target bmp size:" + j * k / 1024 + "KB");
            }
            return a(paramString1, paramString2, Bitmap.CompressFormat.JPEG, i, true);
            i = aknv.a().dnQ;
            break;
            j = aknv.a().picQuality;
            break label91;
            if ((m >= n) || (m <= k)) {
              break label454;
            }
            f = k * 1.0F / m;
            continue;
          }
        }
        return false;
        label454:
        f = 1.0F;
      }
      i = 70;
      k = 800;
    }
  }
  
  public static String mA(String paramString)
  {
    try
    {
      String str3 = new File(paramString).getName();
      int i = str3.lastIndexOf('.');
      str1 = str3;
      if (i > -1)
      {
        str1 = str3;
        if (i < str3.length()) {
          str1 = str3.substring(0, i);
        }
      }
      str1 = str1 + "_" + System.currentTimeMillis() + ".tmp";
      str1 = new File(bTU, str1).getAbsolutePath();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        localException.printStackTrace();
        String str2 = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, String.format("getCachePath oldPath: %s, newPath: %s", new Object[] { paramString, str1 }));
    }
    return str1;
  }
  
  public static boolean nJ(String paramString)
  {
    paramString = PhotoUtils.hS(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.image", 2, "checkImageFormat format:" + paramString);
    }
    return (!TextUtils.isEmpty(paramString)) || ("image/bmp".equalsIgnoreCase(paramString)) || ("image/jpeg".equalsIgnoreCase(paramString)) || ("image/png".equalsIgnoreCase(paramString));
  }
  
  public static String u(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject = new File(bTS);
      File localFile = new File(bTT);
      if ((!((File)localObject).exists()) && (!((File)localObject).mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr dir failed!");
      }
      if ((!localFile.exists()) && (!localFile.mkdir())) {
        QLog.d("Q.ocr.image", 1, "getImagePath WTF! mk ocr preview dir failed!");
      }
      if (paramBoolean) {}
      for (localObject = bTT;; localObject = bTS) {
        return new File((String)localObject, paramString).getAbsolutePath();
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static byte[] u(String paramString)
  {
    // Byte code:
    //   0: new 16	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 297	java/io/File:length	()J
    //   13: l2i
    //   14: newarray byte
    //   16: astore_2
    //   17: new 453	java/io/BufferedInputStream
    //   20: dup
    //   21: new 455	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 456	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 459	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_2
    //   37: iconst_0
    //   38: aload_2
    //   39: arraylength
    //   40: invokevirtual 463	java/io/BufferedInputStream:read	([BII)I
    //   43: pop
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   50: aload_1
    //   51: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   54: aload_2
    //   55: astore_0
    //   56: aload_0
    //   57: ifnull +10 -> 67
    //   60: aload_0
    //   61: astore_1
    //   62: aload_0
    //   63: arraylength
    //   64: ifne +14 -> 78
    //   67: ldc 42
    //   69: iconst_1
    //   70: ldc_w 466
    //   73: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -31 -> 56
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore_0
    //   95: aload_2
    //   96: invokevirtual 467	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   103: aconst_null
    //   104: astore_0
    //   105: goto -49 -> 56
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aconst_null
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: invokevirtual 198	java/io/IOException:printStackTrace	()V
    //   127: aload_1
    //   128: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -77 -> 56
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   141: aconst_null
    //   142: astore_0
    //   143: goto -87 -> 56
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 464	java/io/BufferedInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_1
    //   164: goto -15 -> 149
    //   167: astore_2
    //   168: goto -47 -> 121
    //   171: astore_2
    //   172: goto -79 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramString	String
    //   32	96	1	localObject1	Object
    //   146	8	1	localObject2	Object
    //   163	1	1	localObject3	Object
    //   16	70	2	arrayOfByte	byte[]
    //   90	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   118	6	2	localIOException1	java.io.IOException
    //   167	1	2	localIOException2	java.io.IOException
    //   171	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   50	54	80	java/lang/Exception
    //   17	33	90	java/io/FileNotFoundException
    //   99	103	108	java/lang/Exception
    //   17	33	118	java/io/IOException
    //   127	131	136	java/lang/Exception
    //   17	33	146	finally
    //   149	153	155	java/lang/Exception
    //   35	44	163	finally
    //   46	50	163	finally
    //   95	99	163	finally
    //   123	127	163	finally
    //   35	44	167	java/io/IOException
    //   46	50	167	java/io/IOException
    //   35	44	171	java/io/FileNotFoundException
    //   46	50	171	java/io/FileNotFoundException
  }
  
  private static String xF()
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyyMMddHHmmss");
      Date localDate = new Date(System.currentTimeMillis());
      localObject = ((SimpleDateFormat)localObject).format(localDate) + ".jpg";
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akng
 * JD-Core Version:    0.7.0.1
 */