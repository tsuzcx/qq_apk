package com.tencent.qqmini.sdk.core.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class ShortVideoUtil
{
  static String SDCARD_IMG_CAMERA = SDCARD_ROOT + "/DCIM/Camera/";
  static String SDCARD_IMG_VIDEO;
  static String SDCARD_IMG_VIDEO_GN9000L;
  static String SDCARD_IMG_VIDEO_RUBBISH_MX040;
  static String SDCARD_IMG_VIDEO_VIVO_X7;
  static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static final String TAG = "ShortVideoUtil";
  static int VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT = 640;
  
  static
  {
    SDCARD_IMG_VIDEO = SDCARD_ROOT + "/DCIM/Video/";
    SDCARD_IMG_VIDEO_GN9000L = SDCARD_ROOT + "/照相机/Camera/";
    SDCARD_IMG_VIDEO_VIVO_X7 = SDCARD_ROOT + "/相机/";
    SDCARD_IMG_VIDEO_RUBBISH_MX040 = SDCARD_ROOT + "/Camera/Video/";
  }
  
  public static String getCameraPath()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      str = SDCARD_IMG_VIDEO_GN9000L;
    }
    for (;;)
    {
      QMLog.d("ShortVideoUtil", "getCameraPath: commonPath=" + str);
      return str;
      if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
        str = SDCARD_IMG_VIDEO;
      } else if (str.contains("M040")) {
        str = SDCARD_IMG_VIDEO_RUBBISH_MX040;
      } else if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
        str = SDCARD_IMG_VIDEO_VIVO_X7;
      } else {
        str = SDCARD_IMG_CAMERA;
      }
    }
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString)
  {
    return getVideoThumbnail(paramContext, paramString, VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT);
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt)
  {
    return getVideoThumbnail(paramContext, paramString, paramInt, -1L);
  }
  
  /* Error */
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: iload_2
    //   7: istore 6
    //   9: iload_2
    //   10: ifgt +8 -> 18
    //   13: getstatic 66	com/tencent/qqmini/sdk/core/utils/ShortVideoUtil:VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT	I
    //   16: istore 6
    //   18: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   21: lstore 9
    //   23: new 151	android/media/MediaMetadataRetriever
    //   26: dup
    //   27: invokespecial 152	android/media/MediaMetadataRetriever:<init>	()V
    //   30: astore 13
    //   32: aload 13
    //   34: aload_1
    //   35: invokevirtual 156	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload 13
    //   40: lload_3
    //   41: invokevirtual 160	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   44: astore_0
    //   45: aload 13
    //   47: invokevirtual 163	android/media/MediaMetadataRetriever:release	()V
    //   50: aload_0
    //   51: ifnonnull +77 -> 128
    //   54: aload 12
    //   56: astore 11
    //   58: aload 11
    //   60: areturn
    //   61: astore_0
    //   62: aload 13
    //   64: invokevirtual 163	android/media/MediaMetadataRetriever:release	()V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -19 -> 50
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: goto -25 -> 50
    //   78: astore_0
    //   79: aload 13
    //   81: invokevirtual 163	android/media/MediaMetadataRetriever:release	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: goto -36 -> 50
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_0
    //   92: goto -42 -> 50
    //   95: astore_0
    //   96: ldc 14
    //   98: ldc 165
    //   100: aload_0
    //   101: invokestatic 168	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload 13
    //   106: invokevirtual 163	android/media/MediaMetadataRetriever:release	()V
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -61 -> 50
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -67 -> 50
    //   120: astore_0
    //   121: aload 13
    //   123: invokevirtual 163	android/media/MediaMetadataRetriever:release	()V
    //   126: aload_0
    //   127: athrow
    //   128: aload_0
    //   129: invokevirtual 174	android/graphics/Bitmap:getWidth	()I
    //   132: istore 7
    //   134: aload_0
    //   135: invokevirtual 177	android/graphics/Bitmap:getHeight	()I
    //   138: istore_2
    //   139: iload 7
    //   141: iload_2
    //   142: invokestatic 183	java/lang/Math:max	(II)I
    //   145: istore 8
    //   147: iload 8
    //   149: iload 6
    //   151: if_icmple +180 -> 331
    //   154: iload 6
    //   156: i2f
    //   157: iload 8
    //   159: i2f
    //   160: fdiv
    //   161: fstore 5
    //   163: iload 7
    //   165: i2f
    //   166: fload 5
    //   168: fmul
    //   169: invokestatic 187	java/lang/Math:round	(F)I
    //   172: istore 6
    //   174: iload_2
    //   175: i2f
    //   176: fload 5
    //   178: fmul
    //   179: invokestatic 187	java/lang/Math:round	(F)I
    //   182: istore_2
    //   183: aload_0
    //   184: iload 6
    //   186: iload_2
    //   187: iconst_1
    //   188: invokestatic 191	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   191: astore_0
    //   192: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   195: lstore_3
    //   196: aload_0
    //   197: ifnull +90 -> 287
    //   200: aload_0
    //   201: astore 11
    //   203: invokestatic 195	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   206: ifeq -148 -> 58
    //   209: ldc 14
    //   211: new 34	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   218: ldc 197
    //   220: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: invokevirtual 174	android/graphics/Bitmap:getWidth	()I
    //   227: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: ldc 202
    //   232: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: invokevirtual 177	android/graphics/Bitmap:getHeight	()I
    //   239: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 204
    //   244: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 206
    //   253: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: lload_3
    //   257: lload 9
    //   259: lsub
    //   260: invokevirtual 209	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: ldc 211
    //   265: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 93	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual 214	java/lang/OutOfMemoryError:printStackTrace	()V
    //   281: aload 11
    //   283: astore_0
    //   284: goto -92 -> 192
    //   287: aload_0
    //   288: astore 11
    //   290: invokestatic 195	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   293: ifeq -235 -> 58
    //   296: ldc 14
    //   298: new 34	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   305: ldc 216
    //   307: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 219	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: areturn
    //   322: astore 13
    //   324: goto -274 -> 50
    //   327: astore_1
    //   328: goto -202 -> 126
    //   331: goto -139 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   0	334	1	paramString	String
    //   0	334	2	paramInt	int
    //   0	334	3	paramLong	long
    //   161	16	5	f	float
    //   7	178	6	i	int
    //   132	32	7	j	int
    //   145	13	8	k	int
    //   21	237	9	l	long
    //   1	288	11	localObject1	Object
    //   4	51	12	localObject2	Object
    //   30	92	13	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   322	1	13	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   32	45	61	java/lang/IllegalArgumentException
    //   62	67	72	java/lang/RuntimeException
    //   32	45	78	java/lang/RuntimeException
    //   79	84	89	java/lang/RuntimeException
    //   32	45	95	java/lang/OutOfMemoryError
    //   104	109	114	java/lang/RuntimeException
    //   32	45	120	finally
    //   96	104	120	finally
    //   183	192	276	java/lang/OutOfMemoryError
    //   45	50	322	java/lang/RuntimeException
    //   121	126	327	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ShortVideoUtil
 * JD-Core Version:    0.7.0.1
 */