package com.tencent.mobileqq.pic.compress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.photopreview.PhotoPreviewConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gee;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Utils
{
  public static final int a = 20971520;
  private static final String a = "compress.Utils";
  
  public static long a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.b(paramString)))
    {
      Logger.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
      return 0L;
    }
    return new File(paramString).length();
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setXfermode(null);
      paramBitmap.recycle();
      paramBitmap = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    Logger.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  private static gee a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 1;
    int k = PhotoPreviewConstant.j;
    int m = PhotoPreviewConstant.i;
    if (paramInt1 > k) {
      if (a(paramInt1, paramInt2))
      {
        paramInt2 = 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      gee localgee = new gee(null);
      localgee.a = paramInt2;
      localgee.b = paramInt1;
      Logger.a("compress.Utils", "getType()", " type=" + localgee);
      return localgee;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= k) && (paramInt1 > m))
      {
        if (paramInt2 > k)
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= m) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)))
    {
      String str2 = AppConstants.an + "thumb/";
      if (paramString.startsWith(str2)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      String str1;
      if (j <= 0) {
        str1 = paramString.substring(i + 1);
      }
      for (;;)
      {
        long l = new File(paramString).lastModified();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str2);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append(str1);
        localStringBuffer.append("_").append(l);
        localStringBuffer.append(".jpg");
        paramString = new File(str2);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        if (i < j + 1) {
          str1 = paramString.substring(i + 1, j);
        } else {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    Logger.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)) && (PicQuality.a(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      Object localObject;
      String str;
      StringBuffer localStringBuffer;
      if (j <= 0)
      {
        localObject = paramString.substring(i + 1);
        long l = new File(paramString).lastModified();
        str = AppConstants.an + "photo/";
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!a()) {
          break label228;
        }
      }
      label228:
      for (paramString = "wifi";; paramString = "xg")
      {
        ((StringBuffer)localObject).append(paramString);
        localStringBuffer.append("_").append(paramInt);
        localStringBuffer.append(".jpg");
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        localObject = paramString.substring(i + 1, j);
        break;
      }
    }
    Logger.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  public static void a(Context paramContext, List paramList)
  {
    int k = 1;
    if ((paramList == null) || (paramList.isEmpty())) {}
    label259:
    label262:
    label266:
    for (;;)
    {
      return;
      int j;
      Object localObject2;
      Object localObject1;
      String str3;
      String str1;
      int i;
      if (paramList.size() > 1)
      {
        j = 1;
        localObject2 = "";
        localObject1 = BaseApplication.getContext().getString(2131562577);
        str3 = BaseApplication.getContext().getString(2131562578);
        str1 = BaseApplication.getContext().getString(2131563037);
        String str2 = BaseApplication.getContext().getString(2131562943);
        Iterator localIterator = paramList.iterator();
        i = 0;
        paramList = (List)localObject2;
        if (!localIterator.hasNext()) {
          break label262;
        }
        localObject2 = (CompressInfo)localIterator.next();
        if ((localObject2 == null) || (((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
          break label259;
        }
        if (!str1.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) {
          break label212;
        }
        i = k;
        localObject1 = paramList;
        if (!str1.equals(paramList))
        {
          if (j == 0) {
            break label202;
          }
          localObject1 = str2;
          i = k;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        QQToast.a(paramContext, (CharSequence)localObject1, 0).b(paramContext.getResources().getDimensionPixelSize(2131427376));
        return;
        j = 0;
        break;
        label202:
        localObject1 = str1;
        i = k;
        continue;
        label212:
        if ((((String)localObject1).equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) && (!((String)localObject1).equals(paramList))) {
          if (j != 0)
          {
            paramList = str3;
            i = 1;
          }
        }
        for (;;)
        {
          break;
          paramList = (List)localObject1;
          i = 1;
          continue;
          i = 1;
        }
        localObject1 = paramList;
      }
    }
  }
  
  public static boolean a()
  {
    return NetworkUtil.b(BaseApplication.getContext());
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > paramInt1 * 3;
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramOptions.inSampleSize;; paramInt = 1)
    {
      paramOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      Logger.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if (j > i)
    {
      i = j;
      if (i > paramInt1)
      {
        j = 1;
        int k;
        int m;
        do
        {
          do
          {
            k = i >> 1;
            m = j * 2;
            i = k;
            j = m;
          } while (k < paramInt2);
          i = k;
          j = m;
        } while (k > paramInt1);
        paramOptions.inSampleSize = m;
      }
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label214;
      }
    }
    label214:
    for (paramInt1 = paramOptions.inSampleSize;; paramInt1 = 1)
    {
      paramOptions.inSampleSize = paramInt1;
      Logger.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  public static boolean a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      boolean bool = GifDrawable.isGifFile(paramFile);
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isGifFile result:" + bool);
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return a(new File(paramString));
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 22	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +17 -> 21
    //   7: aload_1
    //   8: ifnull +13 -> 21
    //   11: iload_2
    //   12: bipush 100
    //   14: if_icmpgt +7 -> 21
    //   17: iload_2
    //   18: ifgt +33 -> 51
    //   21: ldc 10
    //   23: ldc_w 391
    //   26: new 32	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   33: aload_3
    //   34: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 393
    //   40: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   49: iconst_0
    //   50: ireturn
    //   51: ldc 10
    //   53: ldc_w 391
    //   56: new 32	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   63: aload_3
    //   64: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 395
    //   70: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload_2
    //   74: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 119	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   83: new 50	java/io/File
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 203	java/io/File:exists	()Z
    //   96: ifeq +8 -> 104
    //   99: aload_0
    //   100: invokevirtual 398	java/io/File:delete	()Z
    //   103: pop
    //   104: aload_0
    //   105: invokevirtual 401	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 403	java/io/FileOutputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 406	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: astore 4
    //   119: aload 4
    //   121: astore_0
    //   122: aload_1
    //   123: getstatic 412	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: iload_2
    //   127: aload 4
    //   129: invokevirtual 416	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload 4
    //   135: astore_0
    //   136: aload 4
    //   138: invokevirtual 419	java/io/FileOutputStream:flush	()V
    //   141: aload 4
    //   143: astore_0
    //   144: aload 4
    //   146: invokevirtual 423	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +20 -> 171
    //   154: aload 4
    //   156: astore_0
    //   157: aload_1
    //   158: invokevirtual 428	java/io/FileDescriptor:valid	()Z
    //   161: ifeq +10 -> 171
    //   164: aload 4
    //   166: astore_0
    //   167: aload_1
    //   168: invokevirtual 431	java/io/FileDescriptor:sync	()V
    //   171: aload 4
    //   173: ifnull +8 -> 181
    //   176: aload 4
    //   178: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   181: iconst_1
    //   182: ireturn
    //   183: astore_0
    //   184: aload 4
    //   186: astore_0
    //   187: ldc 10
    //   189: ldc_w 436
    //   192: ldc_w 438
    //   195: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -27 -> 171
    //   201: astore_1
    //   202: aload 4
    //   204: astore_0
    //   205: ldc 10
    //   207: ldc_w 391
    //   210: new 32	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   217: aload_3
    //   218: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 440
    //   224: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload 4
    //   235: astore_0
    //   236: aload_1
    //   237: invokevirtual 441	java/io/FileNotFoundException:printStackTrace	()V
    //   240: aload 4
    //   242: ifnull -193 -> 49
    //   245: aload 4
    //   247: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   250: iconst_0
    //   251: ireturn
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual 442	java/io/IOException:printStackTrace	()V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: aload 4
    //   262: astore_0
    //   263: ldc 10
    //   265: ldc_w 436
    //   268: ldc_w 444
    //   271: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   274: goto -103 -> 171
    //   277: astore_1
    //   278: aload 4
    //   280: astore_0
    //   281: ldc 10
    //   283: ldc_w 391
    //   286: new 32	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   293: aload_3
    //   294: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: ldc_w 446
    //   300: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 48	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload 4
    //   311: astore_0
    //   312: aload_1
    //   313: invokevirtual 442	java/io/IOException:printStackTrace	()V
    //   316: aload 4
    //   318: ifnull -269 -> 49
    //   321: aload 4
    //   323: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   326: iconst_0
    //   327: ireturn
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 442	java/io/IOException:printStackTrace	()V
    //   333: iconst_0
    //   334: ireturn
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual 442	java/io/IOException:printStackTrace	()V
    //   340: goto -159 -> 181
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload_0
    //   347: ifnull +7 -> 354
    //   350: aload_0
    //   351: invokevirtual 434	java/io/FileOutputStream:close	()V
    //   354: aload_1
    //   355: athrow
    //   356: astore_0
    //   357: aload_0
    //   358: invokevirtual 442	java/io/IOException:printStackTrace	()V
    //   361: goto -7 -> 354
    //   364: astore_1
    //   365: goto -19 -> 346
    //   368: astore_1
    //   369: aconst_null
    //   370: astore 4
    //   372: goto -94 -> 278
    //   375: astore_1
    //   376: aconst_null
    //   377: astore 4
    //   379: goto -177 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramString1	String
    //   0	382	1	paramBitmap	Bitmap
    //   0	382	2	paramInt	int
    //   0	382	3	paramString2	String
    //   117	261	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   136	141	183	java/io/SyncFailedException
    //   144	150	183	java/io/SyncFailedException
    //   157	164	183	java/io/SyncFailedException
    //   167	171	183	java/io/SyncFailedException
    //   122	133	201	java/io/FileNotFoundException
    //   136	141	201	java/io/FileNotFoundException
    //   144	150	201	java/io/FileNotFoundException
    //   157	164	201	java/io/FileNotFoundException
    //   167	171	201	java/io/FileNotFoundException
    //   187	198	201	java/io/FileNotFoundException
    //   263	274	201	java/io/FileNotFoundException
    //   245	250	252	java/io/IOException
    //   136	141	259	java/io/IOException
    //   144	150	259	java/io/IOException
    //   157	164	259	java/io/IOException
    //   167	171	259	java/io/IOException
    //   122	133	277	java/io/IOException
    //   187	198	277	java/io/IOException
    //   263	274	277	java/io/IOException
    //   321	326	328	java/io/IOException
    //   176	181	335	java/io/IOException
    //   104	119	343	finally
    //   350	354	356	java/io/IOException
    //   122	133	364	finally
    //   136	141	364	finally
    //   144	150	364	finally
    //   157	164	364	finally
    //   167	171	364	finally
    //   187	198	364	finally
    //   205	233	364	finally
    //   236	240	364	finally
    //   263	274	364	finally
    //   281	309	364	finally
    //   312	316	364	finally
    //   104	119	368	java/io/IOException
    //   104	119	375	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return ImageUtil.b(paramString1, paramString2);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      paramBoolean = false;
      label65:
      return paramBoolean;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString1, localOptions);
    int j;
    if (localOptions.outWidth > localOptions.outHeight) {
      j = localOptions.outWidth;
    }
    gee localgee;
    for (int i = localOptions.outHeight;; i = localOptions.outWidth)
    {
      localgee = a(i, j);
      if (a(localOptions, PhotoPreviewConstant.j)) {
        break;
      }
      Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localOptions.outHeight;
    }
    Object localObject3;
    try
    {
      localObject3 = BitmapFactory.decodeFile(paramString1, localOptions);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      localOutOfMemoryError1.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
    }
    for (;;)
    {
      Object localObject2;
      int k;
      int i1;
      int n;
      int i4;
      int i2;
      boolean bool1;
      try
      {
        localObject2 = BitmapFactory.decodeFile(paramString1, localOptions);
        k = ((Bitmap)localObject2).getWidth();
        j = ((Bitmap)localObject2).getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnail()", paramString3 + " sample after W:" + k + " H:" + j);
        switch (localgee.b)
        {
        case 2: 
        case 4: 
        case 5: 
        default: 
          i = j;
          m = k;
          i1 = j;
          j = m;
          n = k;
          localObject3 = new Matrix();
          i4 = ImageUtil.b(paramString1);
          if ((!paramBoolean) || (i4 == 0) || (i4 % 90 != 0)) {
            break label1638;
          }
          bool2 = true;
          Logger.a("compress.Utils", "compressAIOThumbnail()", paramString3 + " sample after W:" + n + " H:" + i1 + " isLongImg:" + a(0, 0) + " type:" + localgee + " needRotate:" + bool2);
          if (j <= i) {
            break label913;
          }
          i3 = j;
          m = i;
          k = PhotoPreviewConstant.j;
          i2 = PhotoPreviewConstant.i;
          switch (localgee.a)
          {
          default: 
            bool1 = false;
            paramString1 = (String)localObject2;
            paramBoolean = false;
            Logger.a("compress.Utils", "compressAIOThumbnail()", paramString3 + " destWidth：" + j + " destHeight:" + i + " needCut:" + bool1 + " needScale:" + paramBoolean + " needRotate:" + bool2);
            paramString1 = a(paramString1);
            bool1 = a(paramString2, paramString1, 70, paramString3);
            paramBoolean = bool1;
            if (paramString1 == null) {
              break label65;
            }
            paramString1.recycle();
            return bool1;
          }
          break;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
        return false;
      }
      Logger.a("compress.Utils", "compressAIOThumbnail()", paramString3 + " type.type2:136");
      if (k > j)
      {
        i = j;
        label779:
        m = i * 3;
        if (k <= j) {
          break label849;
        }
        j = i;
      }
      for (;;)
      {
        try
        {
          localObject3 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, m, j);
          localObject2 = localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          label849:
          if (localObject2 == null) {
            continue;
          }
          ((Bitmap)localObject2).recycle();
          localOutOfMemoryError2.printStackTrace();
          Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " cut 3:1 createBitmap OutOfMemoryError, type:" + localgee);
          continue;
        }
        n = ((Bitmap)localObject2).getWidth();
        k = ((Bitmap)localObject2).getHeight();
        i = k;
        j = n;
        i1 = k;
        break;
        i = k;
        break label779;
        j = m;
        m = i;
      }
      label913:
      int i3 = i;
      int m = j;
      continue;
      float f = i2 / (m * 1.0F);
      m = (int)(i3 * f);
      if (bool2) {
        localOutOfMemoryError2.postRotate(i4, n >> 1, i1 >> 1);
      }
      localOutOfMemoryError2.postScale(f, f);
      for (;;)
      {
        Bitmap localBitmap;
        for (;;)
        {
          try
          {
            localBitmap = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, i1, localOutOfMemoryError2, true);
            if (j > i)
            {
              j = i2;
              i = k;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1623;
              }
              paramString1 = Bitmap.createBitmap(localBitmap, 0, 0, j, i);
              bool1 = true;
              paramBoolean = true;
            }
            catch (OutOfMemoryError paramString1)
            {
              if (localBitmap == null) {
                break label1111;
              }
              localBitmap.recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " case 1: cut createBitmap OutOfMemoryError, type:" + localgee);
              return false;
            }
            paramString1 = paramString1;
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " case 1: scale or rotate createBitmap OutOfMemoryError, type:" + localgee);
            return false;
          }
          j = k;
          i = i2;
          continue;
          label1111:
          f = k / (i3 * 1.0F);
          m = (int)(m * f);
          if (j > i) {
            i = m;
          }
          for (j = k;; j = m)
          {
            for (;;)
            {
              if (bool2) {
                localBitmap.postRotate(i4, n >> 1, i1 >> 1);
              }
              localBitmap.postScale(f, f);
              try
              {
                paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, i1, localBitmap, true);
                bool1 = false;
                paramBoolean = true;
              }
              catch (OutOfMemoryError paramString1)
              {
                if (localObject2 == null) {
                  break label1264;
                }
                ((Bitmap)localObject2).recycle();
                paramString1.printStackTrace();
                Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " case 2: scale or rotate createBitmap OutOfMemoryError, type:" + localgee);
                return false;
              }
            }
            i = k;
          }
          label1264:
          if (!bool2) {
            break;
          }
          localBitmap.postRotate(i4, n >> 1, i1 >> 1);
          try
          {
            paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, i1, localBitmap, true);
            bool1 = false;
            paramBoolean = false;
          }
          catch (OutOfMemoryError paramString1)
          {
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " case 3: rotate createBitmap OutOfMemoryError, type:" + localgee);
            return false;
          }
        }
        if (bool2) {
          localBitmap.postRotate(i4, n >> 1, i1 >> 1);
        }
        for (;;)
        {
          try
          {
            paramString1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, n, i1, localBitmap, true);
            k = m * 3;
            if (j > i)
            {
              i = k;
              j = m;
            }
          }
          catch (OutOfMemoryError paramString1)
          {
            try
            {
              if (i4 / 90 % 2 == 0) {
                break label1602;
              }
              localObject2 = Bitmap.createBitmap(paramString1, 0, 0, j, i);
              paramString1 = (String)localObject2;
              bool1 = true;
              paramBoolean = false;
            }
            catch (OutOfMemoryError paramString2)
            {
              if (paramString1 == null) {
                break label1563;
              }
              paramString1.recycle();
              paramString2.printStackTrace();
              Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " case 4: cut createBitmap OutOfMemoryError, type:" + localgee);
              return false;
            }
            paramString1 = paramString1;
            if (localObject2 != null) {
              ((Bitmap)localObject2).recycle();
            }
            paramString1.printStackTrace();
            Logger.b("compress.Utils", "compressAIOThumbnail()", paramString3 + " case 4: rotate createBitmap OutOfMemoryError, type:" + localgee);
            return false;
          }
          i = m;
          j = k;
          continue;
          label1563:
          label1602:
          k = i;
          i = j;
          j = k;
          continue;
          paramString1 = (String)localObject2;
        }
        label1623:
        k = i;
        i = j;
        j = k;
      }
      label1638:
      boolean bool2 = false;
    }
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "isLargeFile w:" + j + ",h:" + i);
    }
    boolean bool1 = bool2;
    if (i != -1)
    {
      bool1 = bool2;
      if (j != -1) {
        if (i <= j * 3)
        {
          bool1 = bool2;
          if (j <= i * 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.Utils
 * JD-Core Version:    0.7.0.1
 */