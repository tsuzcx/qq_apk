package com.tencent.imageservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Log;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import java.io.IOException;

public class ImageProcessUtil
{
  private static final String TAG = "ImageProcessUtil";
  private static boolean mPngUtilsLibLoaded = false;
  
  static
  {
    try
    {
      System.loadLibrary("pixelutils");
      mPngUtilsLibLoaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.w("ImageProcessUtil", localUnsatisfiedLinkError.toString());
      return;
    }
    catch (Exception localException)
    {
      Log.w("ImageProcessUtil", localException.toString());
    }
  }
  
  /* Error */
  public static boolean bitmapToFile(Bitmap paramBitmap, String paramString1, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +29 -> 33
    //   7: ldc 57
    //   9: putstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   12: ldc 64
    //   14: getstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   17: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   20: pop
    //   21: getstatic 68	com/tencent/imageservice/ImageProcessService:MILESTONE	Lcom/tencent/imageservice/Milestone;
    //   24: ldc 69
    //   26: invokevirtual 75	com/tencent/imageservice/Milestone:enable	(I)V
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: ireturn
    //   33: new 77	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: new 77	java/io/File
    //   46: dup
    //   47: new 81	java/lang/StringBuilder
    //   50: dup
    //   51: aload 9
    //   53: invokevirtual 84	java/io/File:getParent	()Ljava/lang/String;
    //   56: invokestatic 90	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: getstatic 94	java/io/File:separator	Ljava/lang/String;
    //   65: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   71: invokevirtual 105	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   74: ldc 107
    //   76: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 111	java/lang/Object:hashCode	()I
    //   83: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: astore 10
    //   94: ldc 64
    //   96: new 81	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 117
    //   102: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload 10
    //   107: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aconst_null
    //   121: astore 7
    //   123: aconst_null
    //   124: astore 8
    //   126: iload_3
    //   127: ifeq +236 -> 363
    //   130: getstatic 126	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   133: astore_1
    //   134: aload 5
    //   136: ifnull +234 -> 370
    //   139: aload 5
    //   141: ldc 128
    //   143: invokevirtual 132	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +13 -> 159
    //   149: aload 5
    //   151: ldc 134
    //   153: invokevirtual 132	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   156: ifeq +214 -> 370
    //   159: iconst_1
    //   160: istore 6
    //   162: aload_1
    //   163: astore 5
    //   165: getstatic 140	android/os/Build$VERSION:SDK_INT	I
    //   168: bipush 14
    //   170: if_icmplt +50 -> 220
    //   173: aload_1
    //   174: astore 5
    //   176: iload 6
    //   178: ifeq +42 -> 220
    //   181: aload_1
    //   182: astore 5
    //   184: iload 4
    //   186: ifeq +34 -> 220
    //   189: ldc 122
    //   191: ldc 142
    //   193: invokevirtual 148	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   196: aconst_null
    //   197: invokevirtual 154	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: astore 11
    //   202: aload_1
    //   203: astore 5
    //   205: aload 11
    //   207: instanceof 122
    //   210: ifeq +10 -> 220
    //   213: aload 11
    //   215: checkcast 122	android/graphics/Bitmap$CompressFormat
    //   218: astore 5
    //   220: ldc 64
    //   222: new 81	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 156
    //   228: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload 5
    //   233: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 162	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   242: pop
    //   243: aload 7
    //   245: astore_1
    //   246: new 164	java/io/BufferedOutputStream
    //   249: dup
    //   250: new 166	java/io/FileOutputStream
    //   253: dup
    //   254: aload 10
    //   256: invokespecial 169	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   259: invokespecial 172	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   262: astore 7
    //   264: aload_0
    //   265: aload 5
    //   267: iload_2
    //   268: aload 7
    //   270: invokevirtual 178	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   273: istore 4
    //   275: aload 7
    //   277: invokevirtual 181	java/io/BufferedOutputStream:flush	()V
    //   280: iload 4
    //   282: istore_3
    //   283: aload 7
    //   285: ifnull +303 -> 588
    //   288: aload 7
    //   290: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   293: iload 4
    //   295: istore_3
    //   296: ldc 64
    //   298: ldc 186
    //   300: invokestatic 162	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   303: pop
    //   304: iload_3
    //   305: ifeq +286 -> 591
    //   308: aload 10
    //   310: aload 9
    //   312: invokevirtual 190	java/io/File:renameTo	(Ljava/io/File;)Z
    //   315: ifne -284 -> 31
    //   318: aload 10
    //   320: invokevirtual 194	java/io/File:delete	()Z
    //   323: pop
    //   324: new 81	java/lang/StringBuilder
    //   327: dup
    //   328: ldc 196
    //   330: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: aload 9
    //   335: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: putstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   344: ldc 64
    //   346: getstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   349: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: getstatic 68	com/tencent/imageservice/ImageProcessService:MILESTONE	Lcom/tencent/imageservice/Milestone;
    //   356: ldc 197
    //   358: invokevirtual 75	com/tencent/imageservice/Milestone:enable	(I)V
    //   361: iconst_0
    //   362: ireturn
    //   363: getstatic 200	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   366: astore_1
    //   367: goto -233 -> 134
    //   370: iconst_0
    //   371: istore 6
    //   373: goto -211 -> 162
    //   376: astore 5
    //   378: aload 8
    //   380: astore_0
    //   381: iconst_0
    //   382: istore 4
    //   384: aload_0
    //   385: astore_1
    //   386: new 81	java/lang/StringBuilder
    //   389: dup
    //   390: ldc 202
    //   392: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload 5
    //   397: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: putstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   409: aload_0
    //   410: astore_1
    //   411: ldc 64
    //   413: getstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   416: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   419: pop
    //   420: aload_0
    //   421: astore_1
    //   422: getstatic 68	com/tencent/imageservice/ImageProcessService:MILESTONE	Lcom/tencent/imageservice/Milestone;
    //   425: ldc 206
    //   427: invokevirtual 75	com/tencent/imageservice/Milestone:enable	(I)V
    //   430: iload 4
    //   432: istore_3
    //   433: aload_0
    //   434: ifnull -138 -> 296
    //   437: aload_0
    //   438: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   441: iload 4
    //   443: istore_3
    //   444: goto -148 -> 296
    //   447: astore_0
    //   448: iconst_0
    //   449: istore_3
    //   450: new 81	java/lang/StringBuilder
    //   453: dup
    //   454: ldc 208
    //   456: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   459: aload_0
    //   460: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   463: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: putstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   472: ldc 64
    //   474: getstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   477: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   480: pop
    //   481: getstatic 68	com/tencent/imageservice/ImageProcessService:MILESTONE	Lcom/tencent/imageservice/Milestone;
    //   484: ldc 209
    //   486: invokevirtual 75	com/tencent/imageservice/Milestone:enable	(I)V
    //   489: goto -193 -> 296
    //   492: astore_0
    //   493: aload_1
    //   494: ifnull +7 -> 501
    //   497: aload_1
    //   498: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   501: aload_0
    //   502: athrow
    //   503: astore_1
    //   504: new 81	java/lang/StringBuilder
    //   507: dup
    //   508: ldc 208
    //   510: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   513: aload_1
    //   514: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   517: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: putstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   526: ldc 64
    //   528: getstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   531: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   534: pop
    //   535: getstatic 68	com/tencent/imageservice/ImageProcessService:MILESTONE	Lcom/tencent/imageservice/Milestone;
    //   538: ldc 209
    //   540: invokevirtual 75	com/tencent/imageservice/Milestone:enable	(I)V
    //   543: goto -42 -> 501
    //   546: astore_0
    //   547: iconst_0
    //   548: istore_3
    //   549: new 81	java/lang/StringBuilder
    //   552: dup
    //   553: ldc 208
    //   555: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   558: aload_0
    //   559: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   562: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: putstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   571: ldc 64
    //   573: getstatic 62	com/tencent/imageservice/ImageProcessService:sMsg	Ljava/lang/String;
    //   576: invokestatic 36	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   579: pop
    //   580: getstatic 68	com/tencent/imageservice/ImageProcessService:MILESTONE	Lcom/tencent/imageservice/Milestone;
    //   583: ldc 209
    //   585: invokevirtual 75	com/tencent/imageservice/Milestone:enable	(I)V
    //   588: goto -292 -> 296
    //   591: aload 10
    //   593: invokevirtual 194	java/io/File:delete	()Z
    //   596: pop
    //   597: iload_3
    //   598: ireturn
    //   599: astore_0
    //   600: aload 7
    //   602: astore_1
    //   603: goto -110 -> 493
    //   606: astore 5
    //   608: aload 7
    //   610: astore_0
    //   611: goto -230 -> 381
    //   614: astore 5
    //   616: aload_1
    //   617: astore 5
    //   619: goto -399 -> 220
    //   622: astore 5
    //   624: aload_1
    //   625: astore 5
    //   627: goto -407 -> 220
    //   630: astore 5
    //   632: aload_1
    //   633: astore 5
    //   635: goto -415 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramBitmap	Bitmap
    //   0	638	1	paramString1	String
    //   0	638	2	paramInt	int
    //   0	638	3	paramBoolean1	boolean
    //   0	638	4	paramBoolean2	boolean
    //   0	638	5	paramString2	String
    //   160	212	6	i	int
    //   121	488	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   124	255	8	localObject1	Object
    //   41	293	9	localFile1	java.io.File
    //   92	500	10	localFile2	java.io.File
    //   200	14	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   246	264	376	java/lang/Exception
    //   437	441	447	java/lang/Exception
    //   246	264	492	finally
    //   386	409	492	finally
    //   411	420	492	finally
    //   422	430	492	finally
    //   497	501	503	java/lang/Exception
    //   288	293	546	java/lang/Exception
    //   264	280	599	finally
    //   264	280	606	java/lang/Exception
    //   189	202	614	java/lang/IllegalAccessException
    //   205	220	614	java/lang/IllegalAccessException
    //   189	202	622	java/lang/IllegalArgumentException
    //   205	220	622	java/lang/IllegalArgumentException
    //   189	202	630	java/lang/NoSuchFieldException
    //   205	220	630	java/lang/NoSuchFieldException
  }
  
  private static int calculateRotateDegree(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    catch (IOException paramString)
    {
      ImageProcessService.MILESTONE.enable(2048);
      Log.w("ImageProcessService", "calculateRotateDegree() EXIF_NULL " + paramString.getMessage());
      return 0;
    }
    return 90;
    return 180;
    return 270;
  }
  
  public static String compressFile(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    ImageProcessService.MILESTONE.enable(1);
    BitmapFactory.Options localOptions1 = decodeBitmapOptions(paramString1);
    boolean bool3 = "image/png".equalsIgnoreCase(localOptions1.outMimeType);
    "image/jpeg".equalsIgnoreCase(localOptions1.outMimeType);
    Object localObject1 = new IUploadConfig.UploadImageSize(localOptions1.outWidth, localOptions1.outHeight, 100);
    if ((((IUploadConfig.UploadImageSize)localObject1).width == 0) || (((IUploadConfig.UploadImageSize)localObject1).height == 0))
    {
      ImageProcessService.MILESTONE.enable(2);
      ImageProcessService.sMsg = "decodeBitmapSize=0";
      Log.w("ImageProcessService", ImageProcessService.sMsg);
      return null;
    }
    int j = Math.min(((IUploadConfig.UploadImageSize)localObject1).width / paramInt1, ((IUploadConfig.UploadImageSize)localObject1).height / paramInt2);
    int i = j;
    if (j < 1) {
      i = 1;
    }
    ImageProcessService.MILESTONE.enable(4);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    localOptions2.inSampleSize = i;
    Log.v("ImageProcessService", "decodeFileWithRetry sampleSize=" + i);
    Object localObject2 = decodeFileWithRetry(paramString1, localOptions2);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      ImageProcessService.MILESTONE.enable(128);
      ImageProcessService.MILESTONE.disableAll(new int[] { 8, 16, 32, 64 });
      localOptions2.inSampleSize += 1;
      localObject1 = decodeFileWithRetry(paramString1, localOptions2);
      Log.i("ImageProcessService", "re decodeFileWithRetry");
    }
    ImageProcessService.MILESTONE.enable(256);
    if (localObject1 == null)
    {
      ImageProcessService.sMsg = "decodeFileWithRetry=null";
      Log.w("ImageProcessService", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(512);
      return null;
    }
    i = ((Bitmap)localObject1).getWidth();
    j = ((Bitmap)localObject1).getHeight();
    float f2 = paramInt1 / i;
    float f3 = paramInt2 / j;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    f2 = f3;
    if (f3 > 1.0F) {
      f2 = 1.0F;
    }
    localObject2 = new Matrix();
    ((Matrix)localObject2).postScale(f1, f2);
    if (paramBoolean1)
    {
      ImageProcessService.MILESTONE.enable(1024);
      int k = calculateRotateDegree(paramString1);
      if (k != 0)
      {
        ((Matrix)localObject2).postRotate(k, paramInt1 / 2, paramInt2 / 2);
        ImageProcessService.MILESTONE.enable(4096);
      }
    }
    boolean bool2 = false;
    boolean bool1 = false;
    paramBoolean1 = bool2;
    long l;
    if (bool3)
    {
      paramBoolean1 = bool2;
      if (isAlphaChanelOpen(paramString1))
      {
        l = System.currentTimeMillis();
        paramBoolean1 = bool1;
        if (!mPngUtilsLibLoaded) {}
      }
    }
    try
    {
      paramBoolean1 = hasAlphaZero((Bitmap)localObject1);
      Log.w("ImageProcessService", "hasAlphaZero:" + paramBoolean1 + " cost: " + (System.currentTimeMillis() - l));
      localObject2 = transformBitmap((Bitmap)localObject1, i, j, (Matrix)localObject2);
      ImageProcessService.MILESTONE.enable(262144);
      paramString1 = (String)localObject2;
      if (localObject2 == null)
      {
        ImageProcessService.MILESTONE.enable(524288);
        paramString1 = (String)localObject1;
      }
      if (paramString1 != localObject1) {
        ((Bitmap)localObject1).recycle();
      }
      Log.v("ImageProcessService", "transformBitmap scaleWidth=" + f1 + " scaleHeight=" + f2);
      paramBoolean1 = bitmapToFile(paramString1, paramString2, paramInt3, paramBoolean1, paramBoolean2, localOptions1.outMimeType);
      paramString1.recycle();
      if (paramBoolean1)
      {
        ImageProcessService.MILESTONE.enable(8388608);
        return paramString2;
      }
      ImageProcessService.sMsg = "bitmapToFile=false";
      Log.w("ImageProcessService", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(16777216);
      return null;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramBoolean1 = bool1;
      }
    }
  }
  
  public static BitmapFactory.Options decodeBitmapOptions(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions;
  }
  
  public static IUploadConfig.UploadImageSize decodeBitmapSize(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new IUploadConfig.UploadImageSize(localOptions.outWidth, localOptions.outHeight, 100);
  }
  
  public static Bitmap decodeFileWithRetry(String paramString, BitmapFactory.Options paramOptions)
  {
    ImageProcessService.MILESTONE.enable(8);
    String str = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageProcessService.sMsg = "decodeFile=oom";
      Log.w("ImageProcessService", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(16);
      System.gc();
      System.gc();
    }
    try
    {
      Thread.sleep(1000L);
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, paramOptions);
        str = paramString;
        ImageProcessService.MILESTONE.enable(32);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        ImageProcessService.sMsg = "decodeFile2=oom";
        Log.w("ImageProcessService", ImageProcessService.sMsg);
        ImageProcessService.MILESTONE.enable(64);
        System.gc();
        System.gc();
        try
        {
          Thread.sleep(1000L);
          return str;
        }
        catch (InterruptedException paramString)
        {
          Log.w("ImageProcessService", paramString);
          return str;
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("ImageProcessService", localInterruptedException);
      }
    }
  }
  
  public static String decodeMimeType(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return localOptions.outMimeType;
  }
  
  private static native boolean hasAlphaZero(Bitmap paramBitmap);
  
  public static boolean isAlphaChanelOpen(String paramString)
  {
    return new PNGReader().isTransparentPng(paramString);
  }
  
  public static Bitmap transformBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    ImageProcessService.MILESTONE.enable(8192);
    Object localObject = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      localObject = localBitmap;
      ImageProcessService.MILESTONE.enable(16384);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      ImageProcessService.sMsg = "createBitmap=oom" + localThrowable.toString();
      Log.w("ImageProcessService", ImageProcessService.sMsg);
      ImageProcessService.MILESTONE.enable(32768);
      System.gc();
      System.gc();
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
        localObject = paramBitmap;
        ImageProcessService.MILESTONE.enable(65536);
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        ImageProcessService.sMsg = "createBitmap2=oom" + paramBitmap.toString();
        Log.w("ImageProcessService", ImageProcessService.sMsg);
        ImageProcessService.MILESTONE.enable(131072);
        System.gc();
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.imageservice.ImageProcessUtil
 * JD-Core Version:    0.7.0.1
 */