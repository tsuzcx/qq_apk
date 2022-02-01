import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TargetApi(18)
public class azbq
{
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private azbq.b jdField_a_of_type_Azbq$b = new azbq.b(null);
  private String aAu;
  private MediaExtractor b;
  private MediaExtractor c;
  private String mAudioFilePath;
  private int mHeight;
  private int mWidth;
  
  public azbq(String paramString1, String paramString2)
  {
    this.aAu = paramString1;
    this.mAudioFilePath = paramString2;
  }
  
  /* Error */
  private static int C(List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +12 -> 13
    //   4: aload_0
    //   5: invokeinterface 50 1 0
    //   10: ifne +8 -> 18
    //   13: bipush 247
    //   15: istore_1
    //   16: iload_1
    //   17: ireturn
    //   18: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   21: invokestatic 62	azbp:am	(Landroid/content/Context;)Ljava/lang/String;
    //   24: astore 4
    //   26: new 64	java/io/File
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 71	java/io/File:exists	()Z
    //   42: ifeq +200 -> 242
    //   45: aload 5
    //   47: iconst_1
    //   48: iconst_1
    //   49: invokevirtual 75	java/io/File:setExecutable	(ZZ)Z
    //   52: istore_3
    //   53: new 77	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   60: ldc 80
    //   62: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_3
    //   66: invokevirtual 87	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: aconst_null
    //   73: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_0
    //   77: iconst_0
    //   78: aload 4
    //   80: invokeinterface 99 3 0
    //   85: aload_0
    //   86: iconst_1
    //   87: ldc 101
    //   89: invokeinterface 99 3 0
    //   94: aload_0
    //   95: iconst_2
    //   96: ldc 103
    //   98: invokeinterface 99 3 0
    //   103: aload_0
    //   104: iconst_3
    //   105: ldc 105
    //   107: invokeinterface 99 3 0
    //   112: aload_0
    //   113: iconst_4
    //   114: ldc 107
    //   116: invokeinterface 99 3 0
    //   121: aload_0
    //   122: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   125: invokestatic 110	azbp:an	(Landroid/content/Context;)Ljava/lang/String;
    //   128: invokeinterface 113 2 0
    //   133: pop
    //   134: new 6	azbq$a
    //   137: dup
    //   138: aconst_null
    //   139: invokespecial 114	azbq$a:<init>	(Lazbr;)V
    //   142: astore 4
    //   144: new 116	java/lang/ProcessBuilder
    //   147: dup
    //   148: iconst_0
    //   149: anewarray 118	java/lang/String
    //   152: invokespecial 121	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   155: astore 5
    //   157: aload 5
    //   159: iconst_1
    //   160: invokevirtual 125	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload_0
    //   167: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 133	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   176: astore_0
    //   177: aload 4
    //   179: aload_0
    //   180: putfield 136	azbq$a:a	Ljava/lang/Process;
    //   183: aload 4
    //   185: invokevirtual 139	azbq$a:initStream	()V
    //   188: aload_0
    //   189: invokevirtual 144	java/lang/Process:waitFor	()I
    //   192: pop
    //   193: aload_0
    //   194: invokevirtual 147	java/lang/Process:exitValue	()I
    //   197: istore_2
    //   198: iload_2
    //   199: ifeq +26 -> 225
    //   202: new 77	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   209: ldc 149
    //   211: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_2
    //   215: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: aconst_null
    //   222: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload 4
    //   227: invokevirtual 155	azbq$a:dRc	()V
    //   230: iload_2
    //   231: istore_1
    //   232: aload_0
    //   233: ifnull -217 -> 16
    //   236: aload_0
    //   237: invokevirtual 158	java/lang/Process:destroy	()V
    //   240: iload_2
    //   241: ireturn
    //   242: bipush 244
    //   244: ireturn
    //   245: astore_0
    //   246: ldc 160
    //   248: aload_0
    //   249: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: bipush 245
    //   254: ireturn
    //   255: astore 5
    //   257: ldc 160
    //   259: aload 5
    //   261: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: goto -71 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramList	List<String>
    //   15	217	1	i	int
    //   197	44	2	j	int
    //   52	14	3	bool	boolean
    //   24	202	4	localObject1	Object
    //   35	137	5	localObject2	Object
    //   255	5	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   171	177	245	java/io/IOException
    //   188	193	255	java/lang/InterruptedException
  }
  
  private final MediaExtractor a(String paramString)
  {
    if (pm(paramString)) {
      localMediaExtractor = new MediaExtractor();
    }
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int i = localMediaExtractor.getTrackCount();
      if (i != 1) {
        localMediaExtractor.release();
      }
      return localMediaExtractor;
    }
    catch (IOException localIOException1)
    {
      try
      {
        k("createExtractor:invalid media file:numTracks=" + i + " path=" + paramString, null);
        return null;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localMediaExtractor = null;
        }
      }
      localIOException1 = localIOException1;
      k("createExtractor path:" + paramString, localIOException1);
      localMediaExtractor.release();
      return null;
    }
  }
  
  public static boolean a(List<String> paramList, String paramString, int paramInt)
  {
    String str1 = "concat:";
    int i = 0;
    String str2;
    if (i < paramList.size())
    {
      String str3 = (String)paramList.get(i);
      str2 = str1;
      if (i > 0) {
        str2 = str1 + "|";
      }
      str1 = str3.replace(".mp4", ".ts");
      int j = ap(str3, str1);
      if (j != 0) {
        if (QLog.isColorLevel()) {
          QLog.e("HwVideoMerge", 2, "ffmpegMp4toTs fail, err: " + j);
        }
      }
    }
    do
    {
      return false;
      str1 = str2 + str1;
      i += 1;
      break;
      paramList = paramString.replace(".mp4", ".ts");
      i = ao(str1, paramList);
      if (i == 0) {
        break label199;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HwVideoMerge", 2, "ffmpegMergeTs fail, err: " + i);
    return false;
    label199:
    if (paramInt == 90) {
      i = 270;
    }
    for (;;)
    {
      paramInt = C(new ArrayList(Arrays.asList(new String[] { "-i", paramList, "-metadata:s", "rotate=" + i, "-vcodec", "copy", "-acodec", "copy", "-absf", "aac_adtstoasc", paramString })));
      if (paramInt == 0) {
        break label355;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("HwVideoMerge", 2, "ffmpegTstoMp4 fail, err: " + paramInt);
      return false;
      i = paramInt;
      if (paramInt == 270) {
        i = 90;
      }
    }
    label355:
    return true;
  }
  
  /* Error */
  public static int an(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 62	azbp:am	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 4
    //   8: new 64	java/io/File
    //   11: dup
    //   12: aload 4
    //   14: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 71	java/io/File:exists	()Z
    //   24: ifeq +452 -> 476
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 75	java/io/File:setExecutable	(ZZ)Z
    //   34: istore_3
    //   35: new 77	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 260
    //   45: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_3
    //   49: invokevirtual 87	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: aconst_null
    //   56: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: new 226	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 261	java/util/ArrayList:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: aload 4
    //   72: invokeinterface 113 2 0
    //   77: pop
    //   78: aload 5
    //   80: ldc 101
    //   82: invokeinterface 113 2 0
    //   87: pop
    //   88: aload 5
    //   90: ldc 105
    //   92: invokeinterface 113 2 0
    //   97: pop
    //   98: aload 5
    //   100: ldc_w 263
    //   103: invokeinterface 113 2 0
    //   108: pop
    //   109: aload 5
    //   111: ldc 103
    //   113: invokeinterface 113 2 0
    //   118: pop
    //   119: aload 5
    //   121: ldc 228
    //   123: invokeinterface 113 2 0
    //   128: pop
    //   129: aload 5
    //   131: aload_0
    //   132: invokeinterface 113 2 0
    //   137: pop
    //   138: aload 5
    //   140: ldc_w 265
    //   143: invokeinterface 113 2 0
    //   148: pop
    //   149: aload 5
    //   151: ldc_w 267
    //   154: invokeinterface 113 2 0
    //   159: pop
    //   160: aload 5
    //   162: ldc_w 269
    //   165: invokeinterface 113 2 0
    //   170: pop
    //   171: aload 5
    //   173: ldc_w 271
    //   176: invokeinterface 113 2 0
    //   181: pop
    //   182: aload 5
    //   184: ldc_w 273
    //   187: invokeinterface 113 2 0
    //   192: pop
    //   193: aload 5
    //   195: invokestatic 278	anki:JO	()I
    //   198: invokestatic 282	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   201: invokeinterface 113 2 0
    //   206: pop
    //   207: aload 5
    //   209: ldc_w 284
    //   212: invokeinterface 113 2 0
    //   217: pop
    //   218: aload 5
    //   220: ldc_w 286
    //   223: invokeinterface 113 2 0
    //   228: pop
    //   229: aload 5
    //   231: ldc_w 288
    //   234: invokeinterface 113 2 0
    //   239: pop
    //   240: aload 5
    //   242: ldc_w 290
    //   245: invokeinterface 113 2 0
    //   250: pop
    //   251: aload 5
    //   253: aload_1
    //   254: invokeinterface 113 2 0
    //   259: pop
    //   260: aload 5
    //   262: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   265: invokestatic 110	azbp:an	(Landroid/content/Context;)Ljava/lang/String;
    //   268: invokeinterface 113 2 0
    //   273: pop
    //   274: new 116	java/lang/ProcessBuilder
    //   277: dup
    //   278: iconst_0
    //   279: anewarray 118	java/lang/String
    //   282: invokespecial 121	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   285: astore_0
    //   286: aload_0
    //   287: iconst_1
    //   288: invokevirtual 125	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   291: pop
    //   292: aload_0
    //   293: aload 5
    //   295: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   298: pop
    //   299: aload_0
    //   300: invokevirtual 133	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   303: astore_0
    //   304: new 77	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   311: astore 4
    //   313: new 292	java/io/BufferedReader
    //   316: dup
    //   317: new 294	java/io/InputStreamReader
    //   320: dup
    //   321: aload_0
    //   322: invokevirtual 298	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   325: invokespecial 301	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   328: invokespecial 304	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   331: astore 5
    //   333: aload 5
    //   335: invokevirtual 307	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   338: astore 6
    //   340: aload 6
    //   342: ifnull +33 -> 375
    //   345: aload 4
    //   347: aload 6
    //   349: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: goto -20 -> 333
    //   356: astore 5
    //   358: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +14 -> 375
    //   364: ldc 213
    //   366: iconst_2
    //   367: ldc_w 309
    //   370: aload 5
    //   372: invokestatic 313	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   375: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +30 -> 408
    //   381: ldc 213
    //   383: iconst_2
    //   384: new 77	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 309
    //   394: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 4
    //   399: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 318	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_0
    //   409: invokevirtual 144	java/lang/Process:waitFor	()I
    //   412: pop
    //   413: aload_0
    //   414: invokevirtual 147	java/lang/Process:exitValue	()I
    //   417: istore_2
    //   418: iload_2
    //   419: ifeq +47 -> 466
    //   422: new 64	java/io/File
    //   425: dup
    //   426: aload_1
    //   427: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   430: astore_1
    //   431: aload_1
    //   432: invokevirtual 71	java/io/File:exists	()Z
    //   435: ifeq +8 -> 443
    //   438: aload_1
    //   439: invokevirtual 321	java/io/File:delete	()Z
    //   442: pop
    //   443: new 77	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   450: ldc 149
    //   452: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload_2
    //   456: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: aconst_null
    //   463: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   466: aload_0
    //   467: ifnull +7 -> 474
    //   470: aload_0
    //   471: invokevirtual 158	java/lang/Process:destroy	()V
    //   474: iload_2
    //   475: ireturn
    //   476: bipush 244
    //   478: ireturn
    //   479: astore_0
    //   480: ldc 160
    //   482: aload_0
    //   483: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   486: bipush 245
    //   488: ireturn
    //   489: astore 4
    //   491: ldc 160
    //   493: aload 4
    //   495: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   498: goto -85 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	paramString1	String
    //   0	501	1	paramString2	String
    //   417	58	2	i	int
    //   34	15	3	bool	boolean
    //   6	392	4	localObject1	Object
    //   489	5	4	localInterruptedException	java.lang.InterruptedException
    //   17	317	5	localObject2	Object
    //   356	15	5	localException	Exception
    //   338	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   313	333	356	java/lang/Exception
    //   333	340	356	java/lang/Exception
    //   345	353	356	java/lang/Exception
    //   299	304	479	java/io/IOException
    //   408	413	489	java/lang/InterruptedException
  }
  
  private static int ao(String paramString1, String paramString2)
  {
    return C(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", paramString2 })));
  }
  
  private static int ap(String paramString1, String paramString2)
  {
    return C(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", "-bsf:v", "h264_mp4toannexb", "-f", "mpegts", paramString2 })));
  }
  
  public static final int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return d(paramString1, paramString2, paramString3, paramInt);
  }
  
  public static final int d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new azbq(paramString1, paramString2).w(null, paramInt);
    int i;
    if ((j == -2) || (j == -4) || (j == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        i = 0;
      }
    }
    do
    {
      return i;
      return -10;
      i = j;
    } while (j != -9);
    return e(paramString1, paramString2, paramString3, paramInt);
  }
  
  /* Error */
  private static int e(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 62	azbp:am	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 64	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 71	java/io/File:exists	()Z
    //   24: ifeq +322 -> 346
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 75	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 77	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   43: ldc 80
    //   45: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 87	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_0
    //   61: iload_3
    //   62: invokestatic 350	azbq:x	(Ljava/lang/String;I)I
    //   65: pop
    //   66: new 226	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 261	java/util/ArrayList:<init>	()V
    //   73: astore 5
    //   75: aload 5
    //   77: aload 6
    //   79: invokeinterface 113 2 0
    //   84: pop
    //   85: aload 5
    //   87: ldc 101
    //   89: invokeinterface 113 2 0
    //   94: pop
    //   95: aload 5
    //   97: ldc 103
    //   99: invokeinterface 113 2 0
    //   104: pop
    //   105: aload 5
    //   107: ldc 105
    //   109: invokeinterface 113 2 0
    //   114: pop
    //   115: aload 5
    //   117: ldc 107
    //   119: invokeinterface 113 2 0
    //   124: pop
    //   125: aload 5
    //   127: ldc 228
    //   129: invokeinterface 113 2 0
    //   134: pop
    //   135: aload 5
    //   137: aload_0
    //   138: invokeinterface 113 2 0
    //   143: pop
    //   144: aload 5
    //   146: ldc 228
    //   148: invokeinterface 113 2 0
    //   153: pop
    //   154: aload 5
    //   156: aload_1
    //   157: invokeinterface 113 2 0
    //   162: pop
    //   163: aload 5
    //   165: ldc 234
    //   167: invokeinterface 113 2 0
    //   172: pop
    //   173: aload 5
    //   175: ldc 236
    //   177: invokeinterface 113 2 0
    //   182: pop
    //   183: aload 5
    //   185: ldc 238
    //   187: invokeinterface 113 2 0
    //   192: pop
    //   193: aload 5
    //   195: ldc 236
    //   197: invokeinterface 113 2 0
    //   202: pop
    //   203: aload 5
    //   205: aload_2
    //   206: invokeinterface 113 2 0
    //   211: pop
    //   212: aload 5
    //   214: invokestatic 56	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   217: invokestatic 110	azbp:an	(Landroid/content/Context;)Ljava/lang/String;
    //   220: invokeinterface 113 2 0
    //   225: pop
    //   226: new 6	azbq$a
    //   229: dup
    //   230: aconst_null
    //   231: invokespecial 114	azbq$a:<init>	(Lazbr;)V
    //   234: astore_0
    //   235: new 116	java/lang/ProcessBuilder
    //   238: dup
    //   239: iconst_0
    //   240: anewarray 118	java/lang/String
    //   243: invokespecial 121	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   246: astore_1
    //   247: aload_1
    //   248: iconst_1
    //   249: invokevirtual 125	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   252: pop
    //   253: aload_1
    //   254: aload 5
    //   256: invokevirtual 129	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   259: pop
    //   260: aload_1
    //   261: invokevirtual 133	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   264: astore_1
    //   265: aload_0
    //   266: aload_1
    //   267: putfield 136	azbq$a:a	Ljava/lang/Process;
    //   270: aload_0
    //   271: invokevirtual 139	azbq$a:initStream	()V
    //   274: aload_1
    //   275: invokevirtual 144	java/lang/Process:waitFor	()I
    //   278: pop
    //   279: aload_1
    //   280: invokevirtual 147	java/lang/Process:exitValue	()I
    //   283: istore_3
    //   284: iload_3
    //   285: ifeq +47 -> 332
    //   288: new 64	java/io/File
    //   291: dup
    //   292: aload_2
    //   293: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   296: astore_2
    //   297: aload_2
    //   298: invokevirtual 71	java/io/File:exists	()Z
    //   301: ifeq +8 -> 309
    //   304: aload_2
    //   305: invokevirtual 321	java/io/File:delete	()Z
    //   308: pop
    //   309: new 77	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   316: ldc 149
    //   318: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload_3
    //   322: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aconst_null
    //   329: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: aload_0
    //   333: invokevirtual 155	azbq$a:dRc	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 158	java/lang/Process:destroy	()V
    //   344: iload_3
    //   345: ireturn
    //   346: bipush 244
    //   348: ireturn
    //   349: astore_0
    //   350: ldc 160
    //   352: aload_0
    //   353: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: bipush 245
    //   358: ireturn
    //   359: astore 5
    //   361: ldc 160
    //   363: aload 5
    //   365: invokestatic 95	azbq:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: goto -89 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	paramString1	String
    //   0	371	1	paramString2	String
    //   0	371	2	paramString3	String
    //   0	371	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	238	5	localObject	Object
    //   359	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	72	6	str	String
    // Exception table:
    //   from	to	target	type
    //   260	265	349	java/io/IOException
    //   274	279	359	java/lang/InterruptedException
  }
  
  private static void k(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("HwVideoMerge", 2, paramString);
  }
  
  private boolean pm(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private void releaseExtractor()
  {
    if (this.b != null)
    {
      this.b.release();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
  }
  
  private int tQ()
  {
    int i = 0;
    this.jdField_a_of_type_Azbq$b.inputBuffer.position(0);
    if (this.b.readSampleData(this.jdField_a_of_type_Azbq$b.inputBuffer, 0) <= 0)
    {
      releaseExtractor();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Azbq$b.inputBuffer.position(0);
    } while (this.c.readSampleData(this.jdField_a_of_type_Azbq$b.inputBuffer, 0) > 0);
    releaseExtractor();
    return -6;
  }
  
  private static int x(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HwVideoMerge", 2, localException, new Object[0]);
        }
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i;
      return paramInt;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
  }
  
  public int w(String paramString, int paramInt)
  {
    this.b = a(this.aAu);
    int i;
    if (this.b == null) {
      i = -1;
    }
    MediaFormat localMediaFormat;
    Object localObject;
    int j;
    do
    {
      return i;
      this.c = a(this.mAudioFilePath);
      if (this.c == null)
      {
        releaseExtractor();
        return -2;
      }
      localMediaFormat = this.b.getTrackFormat(0);
      localObject = localMediaFormat.getString("mime");
      this.mWidth = localMediaFormat.getInteger("width");
      this.mHeight = localMediaFormat.getInteger("height");
      if (!((String)localObject).startsWith("video/")) {
        break;
      }
      this.b.selectTrack(0);
      localObject = this.c.getTrackFormat(0);
      if (!((MediaFormat)localObject).getString("mime").startsWith("audio/")) {
        break label198;
      }
      this.c.selectTrack(0);
      this.jdField_a_of_type_Azbq$b.init(this.mWidth, this.mHeight);
      j = tQ();
      i = j;
    } while (j != 0);
    if (!pm(paramString))
    {
      releaseExtractor();
      return -9;
      releaseExtractor();
      return -3;
      label198:
      releaseExtractor();
      return -4;
    }
    try
    {
      if (new File(paramString).exists())
      {
        releaseExtractor();
        return -8;
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
      paramInt = x(this.aAu, paramInt);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramInt);
      this.jdField_a_of_type_Azbq$b.videoTrack = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_Azbq$b.buj = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
      return j;
    }
    catch (IOException paramString)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      releaseExtractor();
    }
    return -7;
  }
  
  static class a
  {
    private InputStreamReader a;
    public Process a;
    private BufferedReader b;
    private InputStream l;
    
    public void dRc()
    {
      if (this.jdField_a_of_type_JavaLangProcess != null) {}
      try
      {
        for (;;)
        {
          String str = this.b.readLine();
          if (str == null) {
            break;
          }
          azbq.n("[@] compressVideo log:" + str, null);
        }
        label177:
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            if (this.l != null) {
              this.l.close();
            }
            if (this.jdField_a_of_type_JavaIoInputStreamReader != null) {
              this.jdField_a_of_type_JavaIoInputStreamReader.close();
            }
            if (this.b != null) {
              this.b.close();
            }
            return;
          }
          catch (IOException localIOException3) {}
          try
          {
            if (this.l != null) {
              this.l.close();
            }
            if (this.jdField_a_of_type_JavaIoInputStreamReader != null) {
              this.jdField_a_of_type_JavaIoInputStreamReader.close();
            }
            if (this.b == null) {
              continue;
            }
            this.b.close();
            return;
          }
          catch (IOException localIOException2)
          {
            return;
          }
        }
      }
      finally
      {
        try
        {
          if (this.l != null) {
            this.l.close();
          }
          if (this.jdField_a_of_type_JavaIoInputStreamReader != null) {
            this.jdField_a_of_type_JavaIoInputStreamReader.close();
          }
          if (this.b != null) {
            this.b.close();
          }
        }
        catch (IOException localIOException4)
        {
          break label177;
        }
      }
    }
    
    public void initStream()
    {
      if (this.jdField_a_of_type_JavaLangProcess != null)
      {
        this.l = this.jdField_a_of_type_JavaLangProcess.getInputStream();
        this.jdField_a_of_type_JavaIoInputStreamReader = new InputStreamReader(this.l);
        this.b = new BufferedReader(this.jdField_a_of_type_JavaIoInputStreamReader);
      }
    }
  }
  
  static class b
  {
    public MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    public int buj;
    public ByteBuffer inputBuffer;
    public int videoTrack;
    
    public void init(int paramInt1, int paramInt2)
    {
      this.inputBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbq
 * JD-Core Version:    0.7.0.1
 */