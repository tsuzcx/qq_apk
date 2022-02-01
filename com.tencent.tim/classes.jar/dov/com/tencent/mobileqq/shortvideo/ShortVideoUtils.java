package dov.com.tencent.mobileqq.shortvideo;

import aasa;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Formatter;
import anft;
import aqhq;
import azcc;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import pog;
import rop;
import rqa;
import rqi;

public class ShortVideoUtils
  implements anft
{
  private static AtomicInteger bO;
  private static volatile boolean cFD;
  public static boolean cFE = true;
  public static boolean cFF = true;
  private static boolean cFH = true;
  private static int dFy;
  private static int dFz;
  private static String[] gC = { "GT-N7108" };
  private static int[] ni;
  
  static
  {
    bO = new AtomicInteger(0);
    dFy = 2;
    dFz = 1;
    ni = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ShortVideoUtils.1());
  }
  
  public static void B(AppInterface paramAppInterface)
  {
    try
    {
      if (!awI())
      {
        VideoEnvironment.a("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "LoadExtractedShortVideoSo:status_end=" + VideoEnvironment.Jq());
        }
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      do
      {
        paramAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoUtils", 2, "Load libAVCodec.so failure.", paramAppInterface);
    }
  }
  
  public static String C(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = azcc.w(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(aasa.SDCARD_PATH);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append("_local");
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String ID()
  {
    String str = azcc.Ab();
    return aasa.SDCARD_PATH + "shortvideo" + File.separator + "temp" + File.separator + "source" + File.separator + str + "watermark.png";
  }
  
  public static int[] Y()
  {
    return ni;
  }
  
  public static String a(HashSet<Integer> paramHashSet)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    paramHashSet = paramHashSet.iterator();
    int i = 1;
    while (paramHashSet.hasNext())
    {
      if (i == 0) {
        localStringBuilder.append(",");
      }
      i = 0;
      localStringBuilder.append(paramHashSet.next());
    }
    return localStringBuilder.toString();
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  public static boolean awI()
  {
    return VideoEnvironment.awT();
  }
  
  public static String bw(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(zJ());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String by(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(aasa.SDCARD_PATH);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String fg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " shortvideo_cmd_unknow ";
    case 2: 
      return " shortvideo_cmd_download ";
    case 0: 
      return " shortvideo_cmd_send ";
    case 1: 
      return " shortvideo_cmd_resend ";
    case 3: 
      return " shortvideo_cmd_forward ";
    }
    return " shortvideo_cmd_reforward ";
  }
  
  public static String g(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int i = str.length();
    paramContext = str;
    if (i > 3) {
      paramContext = str.substring(0, i - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static long getDuration(String paramString)
  {
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Path:" + paramString + ", not exits!");
      }
      return -1L;
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int i = localMediaPlayer.getDuration();
      long l = i;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDuration", paramString);
      }
      return -1L;
    }
    finally
    {
      localMediaPlayer.release();
    }
  }
  
  @TargetApi(14)
  public static long getDurationOfVideo(String paramString)
  {
    if (!aqhq.fileExists(paramString)) {
      return 0L;
    }
    return pog.getDurationOfVideo(paramString);
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString)
  {
    return getVideoThumbnail(paramContext, paramString, 640);
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
    //   0: iload_2
    //   1: istore 6
    //   3: iload_2
    //   4: ifgt +8 -> 12
    //   7: sipush 640
    //   10: istore 6
    //   12: invokestatic 332	java/lang/System:currentTimeMillis	()J
    //   15: lstore 9
    //   17: new 334	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 335	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 11
    //   26: aload 11
    //   28: aload_1
    //   29: invokevirtual 336	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   32: aload 11
    //   34: lload_3
    //   35: invokevirtual 340	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload 11
    //   41: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   44: aload_0
    //   45: ifnonnull +49 -> 94
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aload 11
    //   55: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   58: aconst_null
    //   59: astore_0
    //   60: goto -16 -> 44
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -22 -> 44
    //   69: astore_0
    //   70: aload 11
    //   72: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -33 -> 44
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -39 -> 44
    //   86: astore_0
    //   87: aload 11
    //   89: invokevirtual 341	android/media/MediaMetadataRetriever:release	()V
    //   92: aload_0
    //   93: athrow
    //   94: aload_0
    //   95: invokevirtual 346	android/graphics/Bitmap:getWidth	()I
    //   98: istore_2
    //   99: aload_0
    //   100: invokevirtual 349	android/graphics/Bitmap:getHeight	()I
    //   103: istore 7
    //   105: iload_2
    //   106: iload 7
    //   108: invokestatic 355	java/lang/Math:max	(II)I
    //   111: istore 8
    //   113: aload_0
    //   114: astore 11
    //   116: iload 8
    //   118: iload 6
    //   120: if_icmple +36 -> 156
    //   123: iload 6
    //   125: i2f
    //   126: iload 8
    //   128: i2f
    //   129: fdiv
    //   130: fstore 5
    //   132: aload_0
    //   133: iload_2
    //   134: i2f
    //   135: fload 5
    //   137: fmul
    //   138: invokestatic 359	java/lang/Math:round	(F)I
    //   141: iload 7
    //   143: i2f
    //   144: fload 5
    //   146: fmul
    //   147: invokestatic 359	java/lang/Math:round	(F)I
    //   150: iconst_1
    //   151: invokestatic 363	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   154: astore 11
    //   156: invokestatic 332	java/lang/System:currentTimeMillis	()J
    //   159: lstore_3
    //   160: aload 11
    //   162: ifnull +88 -> 250
    //   165: aload 11
    //   167: astore_0
    //   168: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -121 -> 50
    //   174: ldc 95
    //   176: iconst_2
    //   177: new 97	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 365
    //   187: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 11
    //   192: invokevirtual 346	android/graphics/Bitmap:getWidth	()I
    //   195: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 367
    //   201: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 11
    //   206: invokevirtual 349	android/graphics/Bitmap:getHeight	()I
    //   209: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 369
    //   215: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 371
    //   225: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: lload_3
    //   229: lload 9
    //   231: lsub
    //   232: invokevirtual 374	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: ldc_w 376
    //   238: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload 11
    //   249: areturn
    //   250: aload 11
    //   252: astore_0
    //   253: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq -206 -> 50
    //   259: ldc 95
    //   261: iconst_2
    //   262: new 97	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 378
    //   272: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload 11
    //   287: areturn
    //   288: astore 11
    //   290: goto -246 -> 44
    //   293: astore_1
    //   294: goto -202 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramContext	Context
    //   0	297	1	paramString	String
    //   0	297	2	paramInt	int
    //   0	297	3	paramLong	long
    //   130	15	5	f	float
    //   1	123	6	i	int
    //   103	39	7	j	int
    //   111	16	8	k	int
    //   15	215	9	l	long
    //   24	262	11	localObject	Object
    //   288	1	11	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   26	39	52	java/lang/IllegalArgumentException
    //   53	58	63	java/lang/RuntimeException
    //   26	39	69	java/lang/RuntimeException
    //   70	75	80	java/lang/RuntimeException
    //   26	39	86	finally
    //   39	44	288	java/lang/RuntimeException
    //   87	92	293	java/lang/RuntimeException
  }
  
  public static String nr(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QIM视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String sV(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = azcc.w(new File(paramString));
    StringBuilder localStringBuilder = new StringBuilder(aasa.SDCARD_PATH);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append("watermark");
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String stringForTime(long paramLong)
  {
    int k = (int)paramLong / 1000;
    int i = k % 60;
    int j = k / 60 % 60;
    k /= 3600;
    if (k > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }).toString();
  }
  
  public static String u(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = azcc.w(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(aasa.SDCARD_PATH);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("audio");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String zJ()
  {
    StringBuilder localStringBuilder = new StringBuilder(zK());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      aqhq.UD((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  private static String zK()
  {
    StringBuilder localStringBuilder = new StringBuilder(aasa.SDCARD_PATH);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static class VideoFileSaveRunnable
    implements Runnable
  {
    MqqHandler b;
    boolean cFM;
    String cdK;
    InputStream m;
    String mVideoPath;
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 8
      //   6: aconst_null
      //   7: astore 9
      //   9: aconst_null
      //   10: astore 7
      //   12: aload_0
      //   13: getfield 26	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   16: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   19: ifne +13 -> 32
      //   22: aload_0
      //   23: getfield 26	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   26: invokestatic 38	aqhq:fileExists	(Ljava/lang/String;)Z
      //   29: ifne +54 -> 83
      //   32: aload_0
      //   33: getfield 40	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:m	Ljava/io/InputStream;
      //   36: ifnonnull +47 -> 83
      //   39: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   42: ifeq +31 -> 73
      //   45: ldc 48
      //   47: iconst_2
      //   48: new 50	java/lang/StringBuilder
      //   51: dup
      //   52: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   55: ldc 55
      //   57: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   60: aload_0
      //   61: getfield 26	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   64: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   67: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   70: invokestatic 67	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   73: aload_0
      //   74: getfield 69	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   77: iconst_1
      //   78: invokevirtual 75	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
      //   81: pop
      //   82: return
      //   83: aload_0
      //   84: getfield 40	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:m	Ljava/io/InputStream;
      //   87: ifnonnull +431 -> 518
      //   90: new 77	java/io/File
      //   93: dup
      //   94: aload_0
      //   95: getfield 26	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   98: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   101: astore_3
      //   102: invokestatic 85	com/tencent/util/VersionUtils:isrFroyo	()Z
      //   105: ifeq +70 -> 175
      //   108: getstatic 90	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
      //   111: invokestatic 94	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
      //   114: astore_2
      //   115: aload_2
      //   116: invokevirtual 97	java/io/File:mkdirs	()Z
      //   119: pop
      //   120: new 77	java/io/File
      //   123: dup
      //   124: aload_2
      //   125: aload_0
      //   126: getfield 99	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:cdK	Ljava/lang/String;
      //   129: invokestatic 103	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:nr	(Ljava/lang/String;)Ljava/lang/String;
      //   132: invokespecial 106	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   135: astore 10
      //   137: aload_0
      //   138: getfield 108	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:cFM	Z
      //   141: ifne +48 -> 189
      //   144: aload 10
      //   146: invokevirtual 111	java/io/File:exists	()Z
      //   149: ifeq +40 -> 189
      //   152: aload_0
      //   153: getfield 69	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   156: iconst_3
      //   157: aload_0
      //   158: getfield 26	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:mVideoPath	Ljava/lang/String;
      //   161: invokevirtual 115	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   164: astore_2
      //   165: aload_0
      //   166: getfield 69	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   169: aload_2
      //   170: invokevirtual 119	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
      //   173: pop
      //   174: return
      //   175: new 77	java/io/File
      //   178: dup
      //   179: getstatic 124	aasa:beb	Ljava/lang/String;
      //   182: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   185: astore_2
      //   186: goto -71 -> 115
      //   189: new 126	java/io/FileOutputStream
      //   192: dup
      //   193: aload 10
      //   195: invokespecial 129	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   198: astore 6
      //   200: aload 7
      //   202: astore 5
      //   204: aload 9
      //   206: astore_2
      //   207: aload 6
      //   209: astore 4
      //   211: aload_0
      //   212: getfield 40	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:m	Ljava/io/InputStream;
      //   215: ifnull +161 -> 376
      //   218: aload 7
      //   220: astore 5
      //   222: aload 9
      //   224: astore_2
      //   225: aload 6
      //   227: astore 4
      //   229: aload_0
      //   230: getfield 40	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:m	Ljava/io/InputStream;
      //   233: astore_3
      //   234: aload_3
      //   235: astore 5
      //   237: aload_3
      //   238: astore_2
      //   239: aload 6
      //   241: astore 4
      //   243: ldc 130
      //   245: newarray byte
      //   247: astore 7
      //   249: aload_3
      //   250: astore 5
      //   252: aload_3
      //   253: astore_2
      //   254: aload 6
      //   256: astore 4
      //   258: aload_3
      //   259: aload 7
      //   261: invokevirtual 136	java/io/InputStream:read	([B)I
      //   264: istore_1
      //   265: iload_1
      //   266: iconst_m1
      //   267: if_icmpeq +132 -> 399
      //   270: aload_3
      //   271: astore 5
      //   273: aload_3
      //   274: astore_2
      //   275: aload 6
      //   277: astore 4
      //   279: aload 6
      //   281: aload 7
      //   283: iconst_0
      //   284: iload_1
      //   285: invokevirtual 140	java/io/FileOutputStream:write	([BII)V
      //   288: aload_3
      //   289: astore 5
      //   291: aload_3
      //   292: astore_2
      //   293: aload 6
      //   295: astore 4
      //   297: aload 6
      //   299: invokevirtual 143	java/io/FileOutputStream:flush	()V
      //   302: goto -53 -> 249
      //   305: astore_2
      //   306: aload 6
      //   308: astore_3
      //   309: aload_2
      //   310: astore 6
      //   312: aload 5
      //   314: astore_2
      //   315: aload_3
      //   316: astore 4
      //   318: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   321: ifeq +19 -> 340
      //   324: aload 5
      //   326: astore_2
      //   327: aload_3
      //   328: astore 4
      //   330: ldc 48
      //   332: iconst_2
      //   333: ldc 145
      //   335: aload 6
      //   337: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   340: aload 5
      //   342: astore_2
      //   343: aload_3
      //   344: astore 4
      //   346: aload_0
      //   347: getfield 69	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   350: iconst_1
      //   351: invokevirtual 75	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
      //   354: pop
      //   355: aload_3
      //   356: ifnull +7 -> 363
      //   359: aload_3
      //   360: invokevirtual 151	java/io/FileOutputStream:close	()V
      //   363: aload 5
      //   365: ifnull -283 -> 82
      //   368: aload 5
      //   370: invokevirtual 152	java/io/InputStream:close	()V
      //   373: return
      //   374: astore_2
      //   375: return
      //   376: aload 7
      //   378: astore 5
      //   380: aload 9
      //   382: astore_2
      //   383: aload 6
      //   385: astore 4
      //   387: new 154	java/io/FileInputStream
      //   390: dup
      //   391: aload_3
      //   392: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   395: astore_3
      //   396: goto -162 -> 234
      //   399: aload_3
      //   400: astore 5
      //   402: aload_3
      //   403: astore_2
      //   404: aload 6
      //   406: astore 4
      //   408: aload_0
      //   409: getfield 69	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   412: iconst_2
      //   413: aload 10
      //   415: invokevirtual 158	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   418: invokevirtual 115	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   421: astore 7
      //   423: aload_3
      //   424: astore 5
      //   426: aload_3
      //   427: astore_2
      //   428: aload 6
      //   430: astore 4
      //   432: aload_0
      //   433: getfield 69	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Lmqq/os/MqqHandler;
      //   436: aload 7
      //   438: invokevirtual 119	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
      //   441: pop
      //   442: aload 6
      //   444: ifnull +8 -> 452
      //   447: aload 6
      //   449: invokevirtual 151	java/io/FileOutputStream:close	()V
      //   452: aload_3
      //   453: ifnull -371 -> 82
      //   456: aload_3
      //   457: invokevirtual 152	java/io/InputStream:close	()V
      //   460: return
      //   461: astore_2
      //   462: return
      //   463: astore_3
      //   464: aconst_null
      //   465: astore 4
      //   467: aload 8
      //   469: astore_2
      //   470: aload 4
      //   472: ifnull +8 -> 480
      //   475: aload 4
      //   477: invokevirtual 151	java/io/FileOutputStream:close	()V
      //   480: aload_2
      //   481: ifnull +7 -> 488
      //   484: aload_2
      //   485: invokevirtual 152	java/io/InputStream:close	()V
      //   488: aload_3
      //   489: athrow
      //   490: astore_2
      //   491: goto -39 -> 452
      //   494: astore_2
      //   495: goto -132 -> 363
      //   498: astore 4
      //   500: goto -20 -> 480
      //   503: astore_2
      //   504: goto -16 -> 488
      //   507: astore_3
      //   508: goto -38 -> 470
      //   511: astore 6
      //   513: aconst_null
      //   514: astore_3
      //   515: goto -203 -> 312
      //   518: aconst_null
      //   519: astore_3
      //   520: goto -418 -> 102
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	523	0	this	VideoFileSaveRunnable
      //   264	21	1	i	int
      //   114	179	2	localObject1	Object
      //   305	5	2	localException1	Exception
      //   314	29	2	localObject2	Object
      //   374	1	2	localIOException1	java.io.IOException
      //   382	46	2	localObject3	Object
      //   461	1	2	localIOException2	java.io.IOException
      //   469	16	2	localObject4	Object
      //   490	1	2	localIOException3	java.io.IOException
      //   494	1	2	localIOException4	java.io.IOException
      //   503	1	2	localIOException5	java.io.IOException
      //   101	356	3	localObject5	Object
      //   463	26	3	localObject6	Object
      //   507	1	3	localObject7	Object
      //   514	6	3	localObject8	Object
      //   209	267	4	localObject9	Object
      //   498	1	4	localIOException6	java.io.IOException
      //   1	424	5	localObject10	Object
      //   198	250	6	localObject11	Object
      //   511	1	6	localException2	Exception
      //   10	427	7	localObject12	Object
      //   4	464	8	localObject13	Object
      //   7	374	9	localObject14	Object
      //   135	279	10	localFile	File
      // Exception table:
      //   from	to	target	type
      //   211	218	305	java/lang/Exception
      //   229	234	305	java/lang/Exception
      //   243	249	305	java/lang/Exception
      //   258	265	305	java/lang/Exception
      //   279	288	305	java/lang/Exception
      //   297	302	305	java/lang/Exception
      //   387	396	305	java/lang/Exception
      //   408	423	305	java/lang/Exception
      //   432	442	305	java/lang/Exception
      //   368	373	374	java/io/IOException
      //   456	460	461	java/io/IOException
      //   189	200	463	finally
      //   447	452	490	java/io/IOException
      //   359	363	494	java/io/IOException
      //   475	480	498	java/io/IOException
      //   484	488	503	java/io/IOException
      //   211	218	507	finally
      //   229	234	507	finally
      //   243	249	507	finally
      //   258	265	507	finally
      //   279	288	507	finally
      //   297	302	507	finally
      //   318	324	507	finally
      //   330	340	507	finally
      //   346	355	507	finally
      //   387	396	507	finally
      //   408	423	507	finally
      //   432	442	507	finally
      //   189	200	511	java/lang/Exception
    }
  }
  
  public static class WatermarkVideoRunnable
    implements Runnable
  {
    private static final Object LOCK = new Object();
    private static rqa a;
    private String cYu;
    private boolean cancel;
    private WeakReference<Context> context;
    private rqi d;
    private MqqHandler g;
    private int height;
    private String src;
    private int taskId;
    String watermarkPath;
    private int width;
    
    private void Fu(int paramInt)
    {
      lG(paramInt, 0);
    }
    
    private void lG(int paramInt1, int paramInt2)
    {
      if ((!this.cancel) && (this.g != null))
      {
        Message localMessage = this.g.obtainMessage(paramInt1, this.taskId, paramInt2);
        this.g.sendMessage(localMessage);
      }
    }
    
    @TargetApi(10)
    public void run()
    {
      Object localObject1;
      Object localObject3;
      Object localObject5;
      Object localObject6;
      if (VersionUtils.isIceScreamSandwich())
      {
        localObject1 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject1).setDataSource(this.src);
        localObject3 = ((MediaMetadataRetriever)localObject1).extractMetadata(18);
        localObject5 = ((MediaMetadataRetriever)localObject1).extractMetadata(19);
        localObject6 = ((MediaMetadataRetriever)localObject1).extractMetadata(24);
        ((MediaMetadataRetriever)localObject1).release();
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6))) {
          break label808;
        }
        this.width = Integer.valueOf((String)localObject3).intValue();
        this.height = Integer.valueOf((String)localObject5).intValue();
      }
      label808:
      for (int i = Integer.valueOf((String)localObject6).intValue();; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "watermark task measure, w=" + this.width + ", h=" + this.height + ",r=" + i);
        }
        if (a == null) {
          a = rqa.a(BaseApplicationImpl.getContext());
        }
        this.watermarkPath = ShortVideoUtils.ID();
        localObject5 = new File(this.watermarkPath);
        if ((!((File)localObject5).getParentFile().exists()) && (!((File)localObject5).getParentFile().mkdirs()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUtils", 2, new Object[] { "create watermark dir failed: ", this.watermarkPath });
          }
          Fu(10001);
        }
        for (;;)
        {
          return;
          Fu(10001);
          return;
          if (this.context.get() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUtils", 2, "context is null");
            }
            Fu(10001);
            return;
          }
          for (;;)
          {
            try
            {
              localObject1 = BitmapFactory.decodeResource(((Context)this.context.get()).getResources(), 2130846913);
              if (this.width != 576)
              {
                float f = this.width / 576.0F;
                localObject3 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true);
                ((Bitmap)localObject1).recycle();
                localObject1 = localObject3;
                localObject3 = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
                localObject6 = new Canvas((Bitmap)localObject3);
                if ((i / 90 + 1) % 2 == 0)
                {
                  j = 1;
                  if (j == 0) {
                    break label631;
                  }
                  k = this.width - 20 - ((Bitmap)localObject1).getHeight();
                  if (j != 0)
                  {
                    ((Canvas)localObject6).save();
                    int m = this.width / 2;
                    int n = this.height / 2;
                    ((Canvas)localObject6).rotate(360 - i, m, n);
                    ((Canvas)localObject6).translate(m - n, n - m);
                  }
                  ((Canvas)localObject6).drawBitmap((Bitmap)localObject1, 20.0F, k, null);
                  if (j != 0) {
                    ((Canvas)localObject6).restore();
                  }
                  if (rop.a((Bitmap)localObject3, Bitmap.CompressFormat.PNG, 100, ((File)localObject5).getAbsolutePath())) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoUtils", 2, "compress watermark to file failed");
                  }
                  rop.f((Bitmap)localObject3);
                  rop.f((Bitmap)localObject1);
                  Fu(10001);
                }
              }
              else
              {
                continue;
              }
              int j = 0;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoUtils", 2, localOutOfMemoryError, new Object[0]);
              }
              Fu(10001);
              return;
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoUtils", 2, localException1, new Object[0]);
              }
              Fu(10001);
              return;
            }
            continue;
            label631:
            int k = this.height - 20 - localException1.getHeight();
          }
          rop.f((Bitmap)localObject3);
          rop.f(localException1);
          if (a.LT()) {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUtils", 2, "generate files mFFmpeg is running!");
            }
          }
          synchronized (LOCK)
          {
            try
            {
              LOCK.wait();
              try
              {
                a.sH(this.cYu);
                a.a(this.watermarkPath, this.src, this.cYu, this.width, this.height, this.d);
                return;
              }
              catch (Exception localException2) {}
              if (QLog.isColorLevel())
              {
                QLog.d("ShortVideoUtils", 2, "generate files save alum:" + localException2);
                return;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("ShortVideoUtils", 2, localInterruptedException, new Object[0]);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */