import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class aapm
{
  private static final String bdB = EditLocalVideoActivity.bdw + File.separator + "silent.m4a";
  
  public static String Z(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramInt >= 2)
    {
      localObject = new ArrayList();
      int i = 0;
      while (i < paramInt)
      {
        ((List)localObject).add(paramString);
        i += 1;
      }
      localObject = y((List)localObject);
    }
    return localObject;
  }
  
  public static String a(long paramLong1, long paramLong2, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (new File(paramString).exists())
      {
        str = EditLocalVideoActivity.bdw + File.separator + "clipped." + aD(paramString, "m4a");
        int i = awdv.c(new String[] { "-y", "-i", paramString, "-ss", bf(paramLong1), "-t", bf(paramLong2), "-c", "copy", str });
        if (i == 0) {
          break label182;
        }
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegClipAudio: FFmpeg run failed with " + i });
        str = null;
      }
    }
    return str;
    label182:
    return str;
  }
  
  /* Error */
  public static String a(long paramLong1, String paramString, long paramLong2)
  {
    // Byte code:
    //   0: new 10	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 18	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:bdw	Ljava/lang/String;
    //   10: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: getstatic 27	java/io/File:separator	Ljava/lang/String;
    //   16: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 118
    //   21: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 10
    //   29: lload_0
    //   30: lload_3
    //   31: ldiv
    //   32: lconst_1
    //   33: ladd
    //   34: l2i
    //   35: istore 6
    //   37: new 120	java/io/BufferedWriter
    //   40: dup
    //   41: new 122	java/io/OutputStreamWriter
    //   44: dup
    //   45: new 124	java/io/FileOutputStream
    //   48: dup
    //   49: aload 10
    //   51: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 128	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   57: invokespecial 131	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   60: astore 8
    //   62: iconst_0
    //   63: istore 5
    //   65: iload 5
    //   67: iload 6
    //   69: if_icmpge +64 -> 133
    //   72: aload 8
    //   74: astore 7
    //   76: aload 8
    //   78: new 10	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   85: ldc 133
    //   87: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: new 24	java/io/File
    //   93: dup
    //   94: aload_2
    //   95: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 136	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   101: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 138
    //   106: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 141	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   115: aload 8
    //   117: astore 7
    //   119: aload 8
    //   121: invokevirtual 144	java/io/BufferedWriter:newLine	()V
    //   124: iload 5
    //   126: iconst_1
    //   127: iadd
    //   128: istore 5
    //   130: goto -65 -> 65
    //   133: aload 8
    //   135: astore 7
    //   137: aload 8
    //   139: invokevirtual 147	java/io/BufferedWriter:flush	()V
    //   142: aload 8
    //   144: ifnull +8 -> 152
    //   147: aload 8
    //   149: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   152: bipush 12
    //   154: anewarray 76	java/lang/String
    //   157: dup
    //   158: iconst_0
    //   159: ldc 78
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: ldc 152
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: ldc 154
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: ldc 156
    //   176: aastore
    //   177: dup
    //   178: iconst_4
    //   179: ldc 158
    //   181: aastore
    //   182: dup
    //   183: iconst_5
    //   184: ldc 80
    //   186: aastore
    //   187: dup
    //   188: bipush 6
    //   190: aload 10
    //   192: aastore
    //   193: dup
    //   194: bipush 7
    //   196: ldc 88
    //   198: aastore
    //   199: dup
    //   200: bipush 8
    //   202: lload_0
    //   203: invokestatic 86	aapm:bf	(J)Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: bipush 9
    //   210: ldc 90
    //   212: aastore
    //   213: dup
    //   214: bipush 10
    //   216: ldc 92
    //   218: aastore
    //   219: dup
    //   220: bipush 11
    //   222: getstatic 35	aapm:bdB	Ljava/lang/String;
    //   225: aastore
    //   226: invokestatic 98	awdv:c	([Ljava/lang/String;)I
    //   229: istore 5
    //   231: new 24	java/io/File
    //   234: dup
    //   235: aload 10
    //   237: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokevirtual 161	java/io/File:delete	()Z
    //   243: ifeq +29 -> 272
    //   246: ldc 100
    //   248: iconst_2
    //   249: new 10	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   256: ldc 163
    //   258: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 10
    //   263: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 167	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: iload 5
    //   274: ifeq +131 -> 405
    //   277: ldc 100
    //   279: iconst_2
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: new 10	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   293: ldc 169
    //   295: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 5
    //   300: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 111	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   310: aconst_null
    //   311: areturn
    //   312: astore_2
    //   313: ldc 100
    //   315: iconst_2
    //   316: aload_2
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   324: goto -172 -> 152
    //   327: astore 9
    //   329: aconst_null
    //   330: astore_2
    //   331: aload_2
    //   332: astore 7
    //   334: ldc 100
    //   336: iconst_2
    //   337: aload 9
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   346: aload_2
    //   347: ifnull -195 -> 152
    //   350: aload_2
    //   351: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   354: goto -202 -> 152
    //   357: astore_2
    //   358: ldc 100
    //   360: iconst_2
    //   361: aload_2
    //   362: iconst_0
    //   363: anewarray 4	java/lang/Object
    //   366: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   369: goto -217 -> 152
    //   372: astore_2
    //   373: aconst_null
    //   374: astore 7
    //   376: aload 7
    //   378: ifnull +8 -> 386
    //   381: aload 7
    //   383: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   386: aload_2
    //   387: athrow
    //   388: astore 7
    //   390: ldc 100
    //   392: iconst_2
    //   393: aload 7
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   402: goto -16 -> 386
    //   405: getstatic 35	aapm:bdB	Ljava/lang/String;
    //   408: areturn
    //   409: astore_2
    //   410: goto -34 -> 376
    //   413: astore 9
    //   415: aload 8
    //   417: astore_2
    //   418: goto -87 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramLong1	long
    //   0	421	2	paramString	String
    //   0	421	3	paramLong2	long
    //   63	236	5	i	int
    //   35	35	6	j	int
    //   74	308	7	localObject	Object
    //   388	6	7	localIOException	java.io.IOException
    //   60	356	8	localBufferedWriter	java.io.BufferedWriter
    //   327	11	9	localException1	java.lang.Exception
    //   413	1	9	localException2	java.lang.Exception
    //   27	235	10	str	String
    // Exception table:
    //   from	to	target	type
    //   147	152	312	java/io/IOException
    //   37	62	327	java/lang/Exception
    //   350	354	357	java/io/IOException
    //   37	62	372	finally
    //   381	386	388	java/io/IOException
    //   76	115	409	finally
    //   119	124	409	finally
    //   137	142	409	finally
    //   334	346	409	finally
    //   76	115	413	java/lang/Exception
    //   119	124	413	java/lang/Exception
    //   137	142	413	java/lang/Exception
  }
  
  @NonNull
  private static String aD(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf('.');
    if (i > 0) {
      paramString2 = paramString1.substring(i + 1);
    }
    return paramString2;
  }
  
  private static String bf(long paramLong)
  {
    return String.format(Locale.getDefault(), "%.3f", new Object[] { Float.valueOf((float)paramLong / 1000.0F) });
  }
  
  public static String f(String paramString1, String paramString2, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      String str = EditLocalVideoActivity.bdw + File.separator + "merged_" + UUID.randomUUID().toString() + ".mp4";
      String[] arrayOfString = new String[14];
      arrayOfString[0] = "-y";
      arrayOfString[1] = "-i";
      arrayOfString[2] = paramString1;
      arrayOfString[3] = "-i";
      arrayOfString[4] = paramString2;
      arrayOfString[5] = "-t";
      arrayOfString[6] = bf(paramLong);
      arrayOfString[7] = "-codec";
      arrayOfString[8] = "copy";
      arrayOfString[9] = "-map";
      arrayOfString[10] = "0:v:0";
      arrayOfString[11] = "-map";
      arrayOfString[12] = "1:a";
      arrayOfString[13] = str;
      QZLog.d("EditLocalVideoMusicMixH", 2, "ffmpegMergeVideoAndAudio: " + Arrays.toString(arrayOfString));
      int i = awdv.c(arrayOfString);
      if (i != 0)
      {
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegMergeVideoAndAudio: FFmpeg run failed with code " + i });
        return null;
      }
      return str;
    }
    QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegMergeVideoAndAudio: input video/audio is empty " + paramString1 + " " + paramString2 });
    return null;
  }
  
  public static String ik(String paramString)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))
    {
      str = EditLocalVideoActivity.bdw + File.separator + UUID.randomUUID().toString() + "_an." + aD(paramString, "mp4");
      int i = awdv.c(new String[] { "-y", "-i", paramString, "-an", "-c", "copy", str });
      if (i != 0) {
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegRemoveAudioTrack: FFmpeg run failed with code " + i });
      }
    }
    else
    {
      return paramString;
    }
    return str;
  }
  
  public static String il(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (new File(paramString).exists())
      {
        str = EditLocalVideoActivity.bdw + File.separator + "converted_no_video." + aD(paramString, "m4a");
        int i = awdv.c(new String[] { "-y", "-i", paramString, "-vn", "-c", "copy", "-map", "0:a:0", str });
        if (i == 0) {
          return str;
        }
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegRemoveVideoTrack: FFmpeg run failed with " + i });
        str = null;
      }
    }
    return str;
    return str;
  }
  
  public static String im(String paramString)
  {
    if ((paramString != null) && (new File(paramString).exists()))
    {
      if (paramString.endsWith("m4a")) {
        return paramString;
      }
      String str = EditLocalVideoActivity.bdw + File.separator + "converted.m4a";
      int i = awdv.c(new String[] { "-y", "-i", paramString, "-c:a", "aac", str });
      if (i != 0)
      {
        QZLog.e("EditLocalVideoMusicMixH", 2, new Object[] { "ffmpegConvert2AAC: FFmpeg run failed with " + i });
        return null;
      }
      return str;
    }
    return null;
  }
  
  /* Error */
  public static String y(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +424 -> 425
    //   4: aload_0
    //   5: invokeinterface 271 1 0
    //   10: iconst_1
    //   11: if_icmpne +16 -> 27
    //   14: aload_0
    //   15: iconst_0
    //   16: invokeinterface 275 2 0
    //   21: checkcast 76	java/lang/String
    //   24: astore_0
    //   25: aload_0
    //   26: areturn
    //   27: new 10	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   34: getstatic 18	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:bdw	Ljava/lang/String;
    //   37: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 27	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 277
    //   49: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore 4
    //   57: new 120	java/io/BufferedWriter
    //   60: dup
    //   61: new 122	java/io/OutputStreamWriter
    //   64: dup
    //   65: new 124	java/io/FileOutputStream
    //   68: dup
    //   69: aload 4
    //   71: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   74: invokespecial 128	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   77: invokespecial 131	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   80: astore_3
    //   81: aload_3
    //   82: astore_2
    //   83: aload_0
    //   84: invokeinterface 281 1 0
    //   89: astore_0
    //   90: aload_3
    //   91: astore_2
    //   92: aload_0
    //   93: invokeinterface 286 1 0
    //   98: ifeq +252 -> 350
    //   101: aload_3
    //   102: astore_2
    //   103: aload_0
    //   104: invokeinterface 290 1 0
    //   109: checkcast 76	java/lang/String
    //   112: astore 5
    //   114: aload_3
    //   115: astore_2
    //   116: aload_3
    //   117: new 10	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   124: ldc 133
    //   126: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: new 24	java/io/File
    //   132: dup
    //   133: aload 5
    //   135: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: invokevirtual 136	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   141: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 138
    //   146: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokevirtual 141	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   155: aload_3
    //   156: astore_2
    //   157: aload_3
    //   158: invokevirtual 144	java/io/BufferedWriter:newLine	()V
    //   161: goto -71 -> 90
    //   164: astore_2
    //   165: aload_3
    //   166: astore_0
    //   167: aload_2
    //   168: astore_3
    //   169: aload_0
    //   170: astore_2
    //   171: ldc 100
    //   173: iconst_2
    //   174: aload_3
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   190: new 10	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   197: getstatic 18	com/tencent/mobileqq/activity/richmedia/EditLocalVideoActivity:bdw	Ljava/lang/String;
    //   200: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: getstatic 27	java/io/File:separator	Ljava/lang/String;
    //   206: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokestatic 211	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   212: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: ldc_w 295
    //   218: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: astore_0
    //   225: bipush 10
    //   227: anewarray 76	java/lang/String
    //   230: dup
    //   231: iconst_0
    //   232: ldc 78
    //   234: aastore
    //   235: dup
    //   236: iconst_1
    //   237: ldc 152
    //   239: aastore
    //   240: dup
    //   241: iconst_2
    //   242: ldc 154
    //   244: aastore
    //   245: dup
    //   246: iconst_3
    //   247: ldc 156
    //   249: aastore
    //   250: dup
    //   251: iconst_4
    //   252: ldc 158
    //   254: aastore
    //   255: dup
    //   256: iconst_5
    //   257: ldc 80
    //   259: aastore
    //   260: dup
    //   261: bipush 6
    //   263: aload 4
    //   265: aastore
    //   266: dup
    //   267: bipush 7
    //   269: ldc 90
    //   271: aastore
    //   272: dup
    //   273: bipush 8
    //   275: ldc 92
    //   277: aastore
    //   278: dup
    //   279: bipush 9
    //   281: aload_0
    //   282: aastore
    //   283: invokestatic 98	awdv:c	([Ljava/lang/String;)I
    //   286: istore_1
    //   287: new 24	java/io/File
    //   290: dup
    //   291: aload 4
    //   293: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   296: invokevirtual 161	java/io/File:delete	()Z
    //   299: ifeq +12 -> 311
    //   302: ldc 100
    //   304: ldc_w 297
    //   307: invokestatic 302	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   310: pop
    //   311: iload_1
    //   312: ifeq -287 -> 25
    //   315: ldc 100
    //   317: iconst_2
    //   318: iconst_1
    //   319: anewarray 4	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: new 10	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 304
    //   334: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: iload_1
    //   338: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: aastore
    //   345: invokestatic 111	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   348: aconst_null
    //   349: areturn
    //   350: aload_3
    //   351: astore_2
    //   352: aload_3
    //   353: invokevirtual 147	java/io/BufferedWriter:flush	()V
    //   356: aload_3
    //   357: ifnull -167 -> 190
    //   360: aload_3
    //   361: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   364: goto -174 -> 190
    //   367: astore_0
    //   368: ldc 100
    //   370: iconst_2
    //   371: aload_0
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   379: goto -189 -> 190
    //   382: astore_0
    //   383: ldc 100
    //   385: iconst_2
    //   386: aload_0
    //   387: iconst_0
    //   388: anewarray 4	java/lang/Object
    //   391: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   394: goto -204 -> 190
    //   397: astore_0
    //   398: aconst_null
    //   399: astore_2
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 150	java/io/BufferedWriter:close	()V
    //   408: aload_0
    //   409: athrow
    //   410: astore_2
    //   411: ldc 100
    //   413: iconst_2
    //   414: aload_2
    //   415: iconst_0
    //   416: anewarray 4	java/lang/Object
    //   419: invokestatic 172	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   422: goto -14 -> 408
    //   425: aconst_null
    //   426: areturn
    //   427: astore_0
    //   428: goto -28 -> 400
    //   431: astore_3
    //   432: aconst_null
    //   433: astore_0
    //   434: goto -265 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	paramList	List<String>
    //   286	52	1	i	int
    //   82	75	2	localObject1	Object
    //   164	4	2	localException1	java.lang.Exception
    //   170	235	2	localObject2	Object
    //   410	5	2	localIOException	java.io.IOException
    //   80	281	3	localObject3	Object
    //   431	1	3	localException2	java.lang.Exception
    //   55	237	4	str1	String
    //   112	22	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   83	90	164	java/lang/Exception
    //   92	101	164	java/lang/Exception
    //   103	114	164	java/lang/Exception
    //   116	155	164	java/lang/Exception
    //   157	161	164	java/lang/Exception
    //   352	356	164	java/lang/Exception
    //   360	364	367	java/io/IOException
    //   186	190	382	java/io/IOException
    //   57	81	397	finally
    //   404	408	410	java/io/IOException
    //   83	90	427	finally
    //   92	101	427	finally
    //   103	114	427	finally
    //   116	155	427	finally
    //   157	161	427	finally
    //   171	182	427	finally
    //   352	356	427	finally
    //   57	81	431	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapm
 * JD-Core Version:    0.7.0.1
 */