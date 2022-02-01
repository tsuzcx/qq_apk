import android.graphics.Bitmap;
import java.util.Map;

public class yeh
  implements yej
{
  public Bitmap a;
  public Map<String, Bitmap> a;
  
  public yeh(Map<String, Bitmap> paramMap, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  /* Error */
  public Bitmap a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 33	android/graphics/Bitmap:getWidth	()I
    //   4: aload_1
    //   5: invokevirtual 36	android/graphics/Bitmap:getHeight	()I
    //   8: invokestatic 42	java/lang/Math:min	(II)I
    //   11: istore_3
    //   12: aload_1
    //   13: invokevirtual 33	android/graphics/Bitmap:getWidth	()I
    //   16: iload_3
    //   17: isub
    //   18: iconst_2
    //   19: idiv
    //   20: istore 4
    //   22: aload_1
    //   23: invokevirtual 36	android/graphics/Bitmap:getHeight	()I
    //   26: iload_3
    //   27: isub
    //   28: iconst_2
    //   29: idiv
    //   30: istore 5
    //   32: aload_0
    //   33: getfield 19	yeh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   36: ifnull +445 -> 481
    //   39: aload_0
    //   40: getfield 19	yeh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   43: new 44	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   50: ldc 47
    //   52: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_3
    //   56: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc 56
    //   61: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload_3
    //   65: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokeinterface 66 2 0
    //   76: checkcast 29	android/graphics/Bitmap
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +11 -> 94
    //   86: aload 6
    //   88: invokevirtual 70	android/graphics/Bitmap:isRecycled	()Z
    //   91: ifeq +104 -> 195
    //   94: aload_1
    //   95: iload 4
    //   97: iload 5
    //   99: iload_3
    //   100: iload_3
    //   101: invokestatic 74	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   104: astore 6
    //   106: aload_0
    //   107: getfield 19	yeh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   110: ifnull +43 -> 153
    //   113: aload_0
    //   114: getfield 19	yeh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   117: new 44	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   124: ldc 47
    //   126: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload_3
    //   130: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc 56
    //   135: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload 6
    //   147: invokeinterface 78 3 0
    //   152: pop
    //   153: aload 6
    //   155: astore 7
    //   157: aload 6
    //   159: ifnonnull +171 -> 330
    //   162: aconst_null
    //   163: areturn
    //   164: astore 7
    //   166: aconst_null
    //   167: astore 6
    //   169: ldc 80
    //   171: ldc 82
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: iload_3
    //   180: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload 7
    //   188: aastore
    //   189: invokestatic 94	ykq:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: goto -39 -> 153
    //   195: aload 6
    //   197: iconst_0
    //   198: invokevirtual 98	android/graphics/Bitmap:eraseColor	(I)V
    //   201: aload_1
    //   202: aload 6
    //   204: iload 4
    //   206: iload 5
    //   208: iload_3
    //   209: iload_3
    //   210: aconst_null
    //   211: iconst_0
    //   212: invokestatic 103	yex:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)V
    //   215: aload 6
    //   217: astore 7
    //   219: aload 6
    //   221: ifnonnull +109 -> 330
    //   224: aconst_null
    //   225: areturn
    //   226: astore 7
    //   228: aload_1
    //   229: iload 4
    //   231: iload 5
    //   233: iload_3
    //   234: iload_3
    //   235: invokestatic 74	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   238: astore 7
    //   240: aload 7
    //   242: astore 6
    //   244: aload_0
    //   245: getfield 19	yeh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   248: ifnull +47 -> 295
    //   251: aload 7
    //   253: astore 6
    //   255: aload_0
    //   256: getfield 19	yeh:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   259: new 44	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   266: ldc 47
    //   268: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: iload_3
    //   272: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: ldc 56
    //   277: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload_3
    //   281: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: aload 7
    //   289: invokeinterface 78 3 0
    //   294: pop
    //   295: aload 7
    //   297: astore 6
    //   299: goto -84 -> 215
    //   302: astore 7
    //   304: ldc 80
    //   306: ldc 82
    //   308: iconst_2
    //   309: anewarray 4	java/lang/Object
    //   312: dup
    //   313: iconst_0
    //   314: iload_3
    //   315: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 7
    //   323: aastore
    //   324: invokestatic 94	ykq:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   327: goto -112 -> 215
    //   330: aload_0
    //   331: getfield 17	yeh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   334: ifnull +13 -> 347
    //   337: aload_0
    //   338: getfield 17	yeh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   341: invokevirtual 70	android/graphics/Bitmap:isRecycled	()Z
    //   344: ifeq +119 -> 463
    //   347: iload_3
    //   348: iload_3
    //   349: getstatic 109	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   352: invokestatic 112	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   355: astore 6
    //   357: aload 6
    //   359: astore_1
    //   360: iload_3
    //   361: i2f
    //   362: fconst_2
    //   363: fdiv
    //   364: fstore_2
    //   365: new 114	android/graphics/Canvas
    //   368: dup
    //   369: aload_1
    //   370: invokespecial 117	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   373: astore 6
    //   375: new 119	android/graphics/Paint
    //   378: dup
    //   379: invokespecial 120	android/graphics/Paint:<init>	()V
    //   382: astore 8
    //   384: aload 8
    //   386: new 122	android/graphics/BitmapShader
    //   389: dup
    //   390: aload 7
    //   392: getstatic 128	android/graphics/Shader$TileMode:CLAMP	Landroid/graphics/Shader$TileMode;
    //   395: getstatic 128	android/graphics/Shader$TileMode:CLAMP	Landroid/graphics/Shader$TileMode;
    //   398: invokespecial 131	android/graphics/BitmapShader:<init>	(Landroid/graphics/Bitmap;Landroid/graphics/Shader$TileMode;Landroid/graphics/Shader$TileMode;)V
    //   401: invokevirtual 135	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   404: pop
    //   405: aload 8
    //   407: iconst_1
    //   408: invokevirtual 139	android/graphics/Paint:setAntiAlias	(Z)V
    //   411: aload 6
    //   413: fload_2
    //   414: fload_2
    //   415: fload_2
    //   416: aload 8
    //   418: invokevirtual 143	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   421: aload_1
    //   422: areturn
    //   423: astore 6
    //   425: ldc 80
    //   427: ldc 145
    //   429: aload 6
    //   431: invokestatic 149	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   434: iload_3
    //   435: iconst_2
    //   436: idiv
    //   437: istore_3
    //   438: iload_3
    //   439: iload_3
    //   440: aload_1
    //   441: invokevirtual 153	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   444: invokestatic 112	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   447: astore_1
    //   448: goto -88 -> 360
    //   451: astore_1
    //   452: ldc 80
    //   454: ldc 155
    //   456: aload 6
    //   458: invokestatic 149	ykq:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   461: aconst_null
    //   462: areturn
    //   463: aload_0
    //   464: getfield 17	yeh:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   467: astore_1
    //   468: aload_1
    //   469: iconst_0
    //   470: invokevirtual 98	android/graphics/Bitmap:eraseColor	(I)V
    //   473: goto -113 -> 360
    //   476: astore 7
    //   478: goto -309 -> 169
    //   481: aconst_null
    //   482: astore 6
    //   484: goto -403 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	yeh
    //   0	487	1	paramBitmap	Bitmap
    //   364	52	2	f	float
    //   11	429	3	i	int
    //   20	210	4	j	int
    //   30	202	5	k	int
    //   79	333	6	localObject1	Object
    //   423	34	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   482	1	6	localObject2	Object
    //   155	1	7	localObject3	Object
    //   164	23	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   217	1	7	localObject4	Object
    //   226	1	7	localException	java.lang.Exception
    //   238	58	7	localBitmap	Bitmap
    //   302	89	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   476	1	7	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   382	35	8	localPaint	android.graphics.Paint
    // Exception table:
    //   from	to	target	type
    //   94	106	164	java/lang/OutOfMemoryError
    //   201	215	226	java/lang/Exception
    //   228	240	302	java/lang/OutOfMemoryError
    //   244	251	302	java/lang/OutOfMemoryError
    //   255	295	302	java/lang/OutOfMemoryError
    //   347	357	423	java/lang/OutOfMemoryError
    //   438	448	451	java/lang/OutOfMemoryError
    //   106	153	476	java/lang/OutOfMemoryError
  }
  
  public String a()
  {
    return "circle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeh
 * JD-Core Version:    0.7.0.1
 */