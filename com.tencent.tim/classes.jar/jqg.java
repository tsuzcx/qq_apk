import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public class jqg
{
  protected static String TAG = "ImageUtil";
  protected static String TZ;
  protected static int aCC = 7;
  protected static int aCD = 10;
  
  public static byte[] Bitmap2Bytes(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1) {
        break label60;
      }
      j = 128;
      label31:
      if (j >= i) {
        break label84;
      }
    }
    label60:
    label84:
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1)) {
        return 1;
      }
    } while (paramInt1 == -1);
    return j;
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: ldc 79
    //   7: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +20 -> 30
    //   13: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   22: iconst_2
    //   23: ldc 93
    //   25: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aconst_null
    //   29: areturn
    //   30: new 99	java/io/File
    //   33: dup
    //   34: getstatic 104	acbn:bmi	Ljava/lang/String;
    //   37: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 110	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aload 4
    //   50: invokevirtual 113	java/io/File:canWrite	()Z
    //   53: ifne +20 -> 73
    //   56: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq -31 -> 28
    //   62: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   65: iconst_2
    //   66: ldc 115
    //   68: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: aconst_null
    //   72: areturn
    //   73: new 117	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 104	acbn:bmi	Ljava/lang/String;
    //   83: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokestatic 128	aoiz:getFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 4
    //   98: new 99	java/io/File
    //   101: dup
    //   102: aload 4
    //   104: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 5
    //   109: aload 5
    //   111: invokevirtual 135	java/io/File:exists	()Z
    //   114: ifeq +6 -> 120
    //   117: aload 4
    //   119: areturn
    //   120: aload_1
    //   121: ldc 137
    //   123: invokevirtual 141	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   126: ifeq +99 -> 225
    //   129: aload_1
    //   130: bipush 44
    //   132: invokevirtual 145	java/lang/String:indexOf	(I)I
    //   135: istore_3
    //   136: iload_3
    //   137: ifle +205 -> 342
    //   140: aload_1
    //   141: iconst_0
    //   142: iload_3
    //   143: invokevirtual 149	java/lang/String:substring	(II)Ljava/lang/String;
    //   146: ldc 151
    //   148: invokevirtual 155	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   151: ifeq +191 -> 342
    //   154: aload_1
    //   155: iload_3
    //   156: invokevirtual 158	java/lang/String:substring	(I)Ljava/lang/String;
    //   159: iconst_0
    //   160: invokestatic 164	aqgo:decode	(Ljava/lang/String;I)[B
    //   163: astore_0
    //   164: aload_0
    //   165: astore_1
    //   166: aload_1
    //   167: ifnonnull +77 -> 244
    //   170: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq -145 -> 28
    //   176: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   179: iconst_2
    //   180: ldc 166
    //   182: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq -163 -> 28
    //   194: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   197: iconst_2
    //   198: new 117	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   205: ldc 168
    //   207: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_0
    //   211: invokevirtual 169	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   214: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aconst_null
    //   224: areturn
    //   225: aload_0
    //   226: aload_1
    //   227: ldc 171
    //   229: aconst_null
    //   230: aload_2
    //   231: invokestatic 176	jqc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)[B
    //   234: astore_0
    //   235: goto -71 -> 164
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -75 -> 166
    //   244: new 178	java/io/FileOutputStream
    //   247: dup
    //   248: aload 5
    //   250: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   253: astore_2
    //   254: aload_2
    //   255: astore_0
    //   256: aload_2
    //   257: aload_1
    //   258: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   269: aload 4
    //   271: areturn
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_1
    //   276: astore_0
    //   277: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +14 -> 294
    //   283: aload_1
    //   284: astore_0
    //   285: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   288: iconst_2
    //   289: ldc 190
    //   291: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_1
    //   295: ifnull -267 -> 28
    //   298: aload_1
    //   299: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   302: aconst_null
    //   303: areturn
    //   304: astore_0
    //   305: aconst_null
    //   306: areturn
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_1
    //   311: ifnull +7 -> 318
    //   314: aload_1
    //   315: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   318: aload_0
    //   319: athrow
    //   320: astore_0
    //   321: goto -52 -> 269
    //   324: astore_1
    //   325: goto -7 -> 318
    //   328: astore_2
    //   329: aload_0
    //   330: astore_1
    //   331: aload_2
    //   332: astore_0
    //   333: goto -23 -> 310
    //   336: astore_0
    //   337: aload_2
    //   338: astore_1
    //   339: goto -64 -> 275
    //   342: aconst_null
    //   343: astore_0
    //   344: goto -180 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramContext	android.content.Context
    //   0	347	1	paramString	String
    //   0	347	2	paramBundle	android.os.Bundle
    //   135	21	3	i	int
    //   40	230	4	localObject	Object
    //   107	142	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   120	136	187	java/lang/OutOfMemoryError
    //   140	164	187	java/lang/OutOfMemoryError
    //   170	185	187	java/lang/OutOfMemoryError
    //   225	235	187	java/lang/OutOfMemoryError
    //   265	269	187	java/lang/OutOfMemoryError
    //   298	302	187	java/lang/OutOfMemoryError
    //   314	318	187	java/lang/OutOfMemoryError
    //   318	320	187	java/lang/OutOfMemoryError
    //   120	136	238	java/lang/Exception
    //   140	164	238	java/lang/Exception
    //   225	235	238	java/lang/Exception
    //   244	254	272	java/io/IOException
    //   298	302	304	java/io/IOException
    //   244	254	307	finally
    //   265	269	320	java/io/IOException
    //   314	318	324	java/io/IOException
    //   256	261	328	finally
    //   277	283	328	finally
    //   285	294	328	finally
    //   256	261	336	java/io/IOException
  }
  
  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    int i = 0;
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int k = paramBitmap.getHeight();
    int m = paramBitmap.getWidth();
    int j;
    if (k > m) {
      j = m;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      try
      {
        for (;;)
        {
          paramBitmap = Bitmap.createBitmap(paramBitmap, i, paramInt, j, j);
          return paramBitmap;
          j = k;
          break;
          if (k > m)
          {
            paramInt = k / 2 - m / 2;
          }
          else
          {
            i = m / 2 - k / 2;
            paramInt = 0;
            continue;
            paramInt = 0;
            continue;
            if (k > m)
            {
              paramInt = k - m;
            }
            else
            {
              i = m - k;
              paramInt = 0;
            }
          }
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "cutSquareBitmap OOM, e:" + paramBitmap);
          }
          paramBitmap = null;
        }
      }
    }
  }
  
  /* Error */
  public static String c(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: getstatic 215	jqg:TZ	Ljava/lang/String;
    //   3: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +12 -> 18
    //   9: invokestatic 226	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   12: invokevirtual 227	java/io/File:toString	()Ljava/lang/String;
    //   15: putstatic 215	jqg:TZ	Ljava/lang/String;
    //   18: new 117	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   25: getstatic 215	jqg:TZ	Ljava/lang/String;
    //   28: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 229
    //   33: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: aconst_null
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_2
    //   46: astore_1
    //   47: new 99	java/io/File
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload_2
    //   59: astore_1
    //   60: aload 5
    //   62: invokevirtual 135	java/io/File:exists	()Z
    //   65: ifne +11 -> 76
    //   68: aload_2
    //   69: astore_1
    //   70: aload 5
    //   72: invokevirtual 232	java/io/File:mkdir	()Z
    //   75: pop
    //   76: aload_2
    //   77: astore_1
    //   78: aload_0
    //   79: invokestatic 234	jqg:Bitmap2Bytes	(Landroid/graphics/Bitmap;)[B
    //   82: invokestatic 240	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   85: astore 5
    //   87: aload_2
    //   88: astore_1
    //   89: new 117	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   96: ldc 242
    //   98: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 5
    //   103: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 244
    //   108: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 5
    //   116: aload_2
    //   117: astore_1
    //   118: new 117	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   125: aload 4
    //   127: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 5
    //   132: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 4
    //   140: aload_2
    //   141: astore_1
    //   142: new 99	java/io/File
    //   145: dup
    //   146: aload 4
    //   148: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: astore 5
    //   153: aload_2
    //   154: astore_1
    //   155: aload 5
    //   157: invokevirtual 135	java/io/File:exists	()Z
    //   160: ifeq +103 -> 263
    //   163: aload_2
    //   164: astore_1
    //   165: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +14 -> 182
    //   171: aload_2
    //   172: astore_1
    //   173: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   176: iconst_2
    //   177: ldc 246
    //   179: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_2
    //   183: astore_1
    //   184: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +35 -> 222
    //   190: aload_2
    //   191: astore_1
    //   192: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   195: iconst_2
    //   196: new 117	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   203: ldc 251
    //   205: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 5
    //   210: invokevirtual 255	java/io/File:length	()J
    //   213: invokevirtual 258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload 4
    //   224: astore_1
    //   225: iconst_0
    //   226: ifeq +11 -> 237
    //   229: new 260	java/lang/NullPointerException
    //   232: dup
    //   233: invokespecial 261	java/lang/NullPointerException:<init>	()V
    //   236: athrow
    //   237: aload_1
    //   238: areturn
    //   239: astore_0
    //   240: aload 4
    //   242: astore_1
    //   243: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -9 -> 237
    //   249: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   252: iconst_2
    //   253: ldc_w 263
    //   256: aload_0
    //   257: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload 4
    //   262: areturn
    //   263: aload_2
    //   264: astore_1
    //   265: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +15 -> 283
    //   271: aload_2
    //   272: astore_1
    //   273: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   276: iconst_2
    //   277: ldc_w 269
    //   280: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_2
    //   284: astore_1
    //   285: new 271	java/io/BufferedOutputStream
    //   288: dup
    //   289: new 178	java/io/FileOutputStream
    //   292: dup
    //   293: aload 5
    //   295: invokespecial 181	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   298: invokespecial 274	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   301: astore_2
    //   302: aload_0
    //   303: getstatic 34	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   306: bipush 100
    //   308: aload_2
    //   309: invokevirtual 40	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   312: pop
    //   313: aload_2
    //   314: invokevirtual 277	java/io/BufferedOutputStream:flush	()V
    //   317: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +33 -> 353
    //   323: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   326: iconst_2
    //   327: new 117	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   334: ldc 251
    //   336: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 5
    //   341: invokevirtual 255	java/io/File:length	()J
    //   344: invokevirtual 258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 249	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload 4
    //   355: astore_1
    //   356: aload_2
    //   357: ifnull -120 -> 237
    //   360: aload_2
    //   361: invokevirtual 278	java/io/BufferedOutputStream:close	()V
    //   364: aload 4
    //   366: areturn
    //   367: astore_0
    //   368: aload 4
    //   370: astore_1
    //   371: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq -137 -> 237
    //   377: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   380: iconst_2
    //   381: ldc_w 263
    //   384: aload_0
    //   385: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   388: aload 4
    //   390: areturn
    //   391: astore_2
    //   392: aload_3
    //   393: astore_0
    //   394: aload_0
    //   395: astore_1
    //   396: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +16 -> 415
    //   402: aload_0
    //   403: astore_1
    //   404: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   407: iconst_2
    //   408: ldc_w 280
    //   411: aload_2
    //   412: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   415: ldc 79
    //   417: astore_2
    //   418: aload_2
    //   419: astore_1
    //   420: aload_0
    //   421: ifnull -184 -> 237
    //   424: aload_0
    //   425: invokevirtual 278	java/io/BufferedOutputStream:close	()V
    //   428: ldc 79
    //   430: areturn
    //   431: astore_0
    //   432: aload_2
    //   433: astore_1
    //   434: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq -200 -> 237
    //   440: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   443: iconst_2
    //   444: ldc_w 263
    //   447: aload_0
    //   448: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   451: ldc 79
    //   453: areturn
    //   454: astore_0
    //   455: aload_1
    //   456: ifnull +7 -> 463
    //   459: aload_1
    //   460: invokevirtual 278	java/io/BufferedOutputStream:close	()V
    //   463: aload_0
    //   464: athrow
    //   465: astore_1
    //   466: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq -6 -> 463
    //   472: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   475: iconst_2
    //   476: ldc_w 263
    //   479: aload_1
    //   480: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   483: goto -20 -> 463
    //   486: astore_0
    //   487: aload_2
    //   488: astore_1
    //   489: goto -34 -> 455
    //   492: astore_1
    //   493: aload_2
    //   494: astore_0
    //   495: aload_1
    //   496: astore_2
    //   497: goto -103 -> 394
    //   500: astore_1
    //   501: goto -483 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	paramBitmap	Bitmap
    //   46	414	1	localObject1	Object
    //   465	15	1	localException1	java.lang.Exception
    //   488	1	1	localObject2	Object
    //   492	4	1	localIOException1	java.io.IOException
    //   500	1	1	localException2	java.lang.Exception
    //   42	319	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   391	21	2	localIOException2	java.io.IOException
    //   417	80	2	localObject3	Object
    //   44	349	3	localObject4	Object
    //   39	350	4	str	String
    //   56	284	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   229	237	239	java/lang/Exception
    //   360	364	367	java/lang/Exception
    //   47	58	391	java/io/IOException
    //   60	68	391	java/io/IOException
    //   70	76	391	java/io/IOException
    //   78	87	391	java/io/IOException
    //   89	116	391	java/io/IOException
    //   118	140	391	java/io/IOException
    //   142	153	391	java/io/IOException
    //   155	163	391	java/io/IOException
    //   165	171	391	java/io/IOException
    //   173	182	391	java/io/IOException
    //   184	190	391	java/io/IOException
    //   192	222	391	java/io/IOException
    //   265	271	391	java/io/IOException
    //   273	283	391	java/io/IOException
    //   285	302	391	java/io/IOException
    //   424	428	431	java/lang/Exception
    //   47	58	454	finally
    //   60	68	454	finally
    //   70	76	454	finally
    //   78	87	454	finally
    //   89	116	454	finally
    //   118	140	454	finally
    //   142	153	454	finally
    //   155	163	454	finally
    //   165	171	454	finally
    //   173	182	454	finally
    //   184	190	454	finally
    //   192	222	454	finally
    //   265	271	454	finally
    //   273	283	454	finally
    //   285	302	454	finally
    //   396	402	454	finally
    //   404	415	454	finally
    //   459	463	465	java/lang/Exception
    //   302	353	486	finally
    //   302	353	492	java/io/IOException
    //   9	18	500	java/lang/Exception
  }
  
  public static final int computeSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = a(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      paramInt1 = 1;
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i) {
          break;
        }
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i + 7) / 8 * 8;
    return paramInt2;
  }
  
  /* Error */
  public static final Bitmap d(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: new 48	android/graphics/BitmapFactory$Options
    //   14: dup
    //   15: invokespecial 285	android/graphics/BitmapFactory$Options:<init>	()V
    //   18: astore 6
    //   20: aload 6
    //   22: iconst_1
    //   23: putfield 289	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   26: aload_0
    //   27: aload 6
    //   29: invokestatic 295	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   32: pop
    //   33: aload 6
    //   35: getfield 51	android/graphics/BitmapFactory$Options:outWidth	I
    //   38: istore_2
    //   39: aload 6
    //   41: getfield 54	android/graphics/BitmapFactory$Options:outHeight	I
    //   44: istore_3
    //   45: aload 6
    //   47: getfield 298	android/graphics/BitmapFactory$Options:mCancel	Z
    //   50: ifne +21 -> 71
    //   53: aload 6
    //   55: getfield 51	android/graphics/BitmapFactory$Options:outWidth	I
    //   58: iconst_m1
    //   59: if_icmpeq +12 -> 71
    //   62: aload 6
    //   64: getfield 54	android/graphics/BitmapFactory$Options:outHeight	I
    //   67: iconst_m1
    //   68: if_icmpne +5 -> 73
    //   71: aconst_null
    //   72: areturn
    //   73: iload_2
    //   74: iload_3
    //   75: if_icmple +108 -> 183
    //   78: aload 6
    //   80: getstatic 304	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   83: putfield 307	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   86: iload_2
    //   87: iload_1
    //   88: if_icmple +17 -> 105
    //   91: aload 6
    //   93: aload 6
    //   95: iconst_m1
    //   96: iload_1
    //   97: iload_1
    //   98: imul
    //   99: invokestatic 309	jqg:computeSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   102: putfield 312	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   105: aload 6
    //   107: iconst_0
    //   108: putfield 289	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: new 314	java/io/BufferedInputStream
    //   114: dup
    //   115: new 316	java/io/FileInputStream
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 317	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 320	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore_0
    //   127: aload_0
    //   128: astore 4
    //   130: aload_0
    //   131: aconst_null
    //   132: aload 6
    //   134: invokestatic 324	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   137: astore 5
    //   139: aload 5
    //   141: astore 4
    //   143: aload_0
    //   144: ifnull +7 -> 151
    //   147: aload_0
    //   148: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   151: aload 6
    //   153: getfield 51	android/graphics/BitmapFactory$Options:outWidth	I
    //   156: istore_2
    //   157: aload 6
    //   159: getfield 54	android/graphics/BitmapFactory$Options:outHeight	I
    //   162: istore_3
    //   163: iload_2
    //   164: iload_3
    //   165: if_icmple +192 -> 357
    //   168: aload 4
    //   170: astore_0
    //   171: iload_2
    //   172: iload_1
    //   173: if_icmple -164 -> 9
    //   176: aload 4
    //   178: iload_1
    //   179: invokestatic 328	jqg:scaleBitmap	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   182: areturn
    //   183: iload_3
    //   184: istore_2
    //   185: goto -107 -> 78
    //   188: astore_0
    //   189: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -41 -> 151
    //   195: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   198: iconst_2
    //   199: ldc_w 330
    //   202: aload_0
    //   203: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: goto -55 -> 151
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_0
    //   212: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +13 -> 228
    //   218: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   221: iconst_2
    //   222: ldc_w 332
    //   225: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: ifnull +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   236: aconst_null
    //   237: areturn
    //   238: astore_0
    //   239: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq -6 -> 236
    //   245: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   248: iconst_2
    //   249: ldc_w 330
    //   252: aload_0
    //   253: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: goto -20 -> 236
    //   259: astore 5
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: astore 4
    //   266: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +18 -> 287
    //   272: aload_0
    //   273: astore 4
    //   275: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   278: iconst_2
    //   279: ldc_w 336
    //   282: aload 5
    //   284: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload_0
    //   288: ifnull +7 -> 295
    //   291: aload_0
    //   292: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   295: aconst_null
    //   296: areturn
    //   297: astore_0
    //   298: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -6 -> 295
    //   304: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   307: iconst_2
    //   308: ldc_w 330
    //   311: aload_0
    //   312: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: goto -20 -> 295
    //   318: astore_0
    //   319: aconst_null
    //   320: astore 4
    //   322: aload 4
    //   324: ifnull +8 -> 332
    //   327: aload 4
    //   329: invokevirtual 325	java/io/BufferedInputStream:close	()V
    //   332: aload_0
    //   333: athrow
    //   334: astore 4
    //   336: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq -7 -> 332
    //   342: getstatic 20	jqg:TAG	Ljava/lang/String;
    //   345: iconst_2
    //   346: ldc_w 330
    //   349: aload 4
    //   351: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: goto -22 -> 332
    //   357: iload_3
    //   358: istore_2
    //   359: goto -191 -> 168
    //   362: astore_0
    //   363: goto -41 -> 322
    //   366: astore 5
    //   368: aload_0
    //   369: astore 4
    //   371: aload 5
    //   373: astore_0
    //   374: goto -52 -> 322
    //   377: astore 5
    //   379: goto -116 -> 263
    //   382: astore 4
    //   384: goto -172 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramString	String
    //   0	387	1	paramInt	int
    //   38	321	2	i	int
    //   44	314	3	j	int
    //   128	200	4	localObject1	Object
    //   334	16	4	localException1	java.lang.Exception
    //   369	1	4	str	String
    //   382	1	4	localOutOfMemoryError	OutOfMemoryError
    //   137	3	5	localBitmap	Bitmap
    //   259	24	5	localException2	java.lang.Exception
    //   366	6	5	localObject2	Object
    //   377	1	5	localException3	java.lang.Exception
    //   18	140	6	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   147	151	188	java/lang/Exception
    //   111	127	209	java/lang/OutOfMemoryError
    //   232	236	238	java/lang/Exception
    //   111	127	259	java/lang/Exception
    //   291	295	297	java/lang/Exception
    //   111	127	318	finally
    //   327	332	334	java/lang/Exception
    //   130	139	362	finally
    //   266	272	362	finally
    //   275	287	362	finally
    //   212	228	366	finally
    //   130	139	377	java/lang/Exception
    //   130	139	382	java/lang/OutOfMemoryError
  }
  
  public static Drawable d(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(new LightingColorFilter(0, paramInt));
    return paramDrawable;
  }
  
  public static final Bitmap scaleBitmap(Bitmap paramBitmap, int paramInt)
  {
    Object localObject1;
    if (paramBitmap == null)
    {
      localObject1 = null;
      return localObject1;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    if ((j <= 0) || (k <= 0)) {
      return null;
    }
    int i;
    if (j > k) {
      i = j;
    }
    for (;;)
    {
      localObject1 = paramBitmap;
      if (i <= paramInt) {
        break;
      }
      float f = paramInt / i;
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f, f);
      try
      {
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, (Matrix)localObject1, true);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
        return localObject1;
        i = k;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "scaleBitmap, exp=", localThrowable);
          }
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqg
 * JD-Core Version:    0.7.0.1
 */