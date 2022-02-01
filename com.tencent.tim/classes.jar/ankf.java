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

@TargetApi(18)
public class ankf
{
  private static Process d;
  private static Process e;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private ankf.b jdField_a_of_type_Ankf$b = new ankf.b(null);
  private String aAu;
  private MediaExtractor b;
  private MediaExtractor c;
  private String mAudioFilePath;
  private int mHeight;
  private int mWidth;
  
  public ankf(String paramString1, String paramString2)
  {
    this.aAu = paramString1;
    this.mAudioFilePath = paramString2;
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
  
  public static boolean axF()
  {
    boolean bool = false;
    k("[@]  ffmpegProcess try destroy!", null);
    if ((d != null) && (!rqj.a(d)))
    {
      d.destroy();
      d = null;
      k("[@]  ffmpegProcess, destroyMergeProcess!", null);
    }
    for (int i = 1;; i = 0)
    {
      if ((e != null) && (!rqj.a(e)))
      {
        e.destroy();
        e = null;
        k("[@]  ffmpegProcess, destroyRecodeProcess!", null);
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  public static final int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return d(paramString1, paramString2, paramString3, paramInt);
  }
  
  public static final int d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new ankf(paramString1, paramString2).w(null, paramInt);
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
    //   0: invokestatic 135	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 141	ankc:am	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 119	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 144	java/io/File:exists	()Z
    //   24: ifeq +411 -> 435
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 148	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 64	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   43: ldc 150
    //   45: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 153	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc 155
    //   55: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 5
    //   60: invokevirtual 159	java/io/File:length	()J
    //   63: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aconst_null
    //   70: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: iload_3
    //   75: invokestatic 165	ankf:x	(Ljava/lang/String;I)I
    //   78: pop
    //   79: new 167	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 168	java/util/ArrayList:<init>	()V
    //   86: astore 5
    //   88: aload 5
    //   90: aload 6
    //   92: invokeinterface 174 2 0
    //   97: pop
    //   98: aload 5
    //   100: ldc 176
    //   102: invokeinterface 174 2 0
    //   107: pop
    //   108: aload 5
    //   110: ldc 178
    //   112: invokeinterface 174 2 0
    //   117: pop
    //   118: aload 5
    //   120: ldc 180
    //   122: invokeinterface 174 2 0
    //   127: pop
    //   128: aload 5
    //   130: ldc 182
    //   132: invokeinterface 174 2 0
    //   137: pop
    //   138: aload 5
    //   140: ldc 184
    //   142: invokeinterface 174 2 0
    //   147: pop
    //   148: aload 5
    //   150: aload_0
    //   151: invokeinterface 174 2 0
    //   156: pop
    //   157: aload 5
    //   159: ldc 184
    //   161: invokeinterface 174 2 0
    //   166: pop
    //   167: aload 5
    //   169: aload_1
    //   170: invokeinterface 174 2 0
    //   175: pop
    //   176: aload 5
    //   178: ldc 186
    //   180: invokeinterface 174 2 0
    //   185: pop
    //   186: aload 5
    //   188: ldc 188
    //   190: invokeinterface 174 2 0
    //   195: pop
    //   196: aload 5
    //   198: ldc 190
    //   200: invokeinterface 174 2 0
    //   205: pop
    //   206: aload 5
    //   208: ldc 188
    //   210: invokeinterface 174 2 0
    //   215: pop
    //   216: aload 5
    //   218: aload_2
    //   219: invokeinterface 174 2 0
    //   224: pop
    //   225: aload 5
    //   227: invokestatic 135	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   230: invokestatic 193	ankc:an	(Landroid/content/Context;)Ljava/lang/String;
    //   233: invokeinterface 174 2 0
    //   238: pop
    //   239: new 64	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   246: ldc 195
    //   248: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 5
    //   253: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: aconst_null
    //   260: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: new 6	ankf$a
    //   266: dup
    //   267: aconst_null
    //   268: invokespecial 199	ankf$a:<init>	(Lankg;)V
    //   271: astore_0
    //   272: new 201	java/lang/ProcessBuilder
    //   275: dup
    //   276: iconst_0
    //   277: anewarray 203	java/lang/String
    //   280: invokespecial 206	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   283: astore_1
    //   284: aload_1
    //   285: iconst_1
    //   286: invokevirtual 210	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   289: pop
    //   290: aload_1
    //   291: aload 5
    //   293: invokevirtual 214	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   296: pop
    //   297: aload_1
    //   298: invokevirtual 218	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   301: astore_1
    //   302: aload_1
    //   303: putstatic 92	ankf:d	Ljava/lang/Process;
    //   306: aload_0
    //   307: aload_1
    //   308: putfield 220	ankf$a:a	Ljava/lang/Process;
    //   311: aload_0
    //   312: invokevirtual 223	ankf$a:initStream	()V
    //   315: aload_1
    //   316: invokevirtual 226	java/lang/Process:waitFor	()I
    //   319: pop
    //   320: aload_1
    //   321: invokevirtual 229	java/lang/Process:exitValue	()I
    //   324: istore_3
    //   325: iload_3
    //   326: ifeq +50 -> 376
    //   329: new 119	java/io/File
    //   332: dup
    //   333: aload_2
    //   334: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   337: astore 5
    //   339: aload 5
    //   341: invokevirtual 144	java/io/File:exists	()Z
    //   344: ifeq +9 -> 353
    //   347: aload 5
    //   349: invokevirtual 232	java/io/File:delete	()Z
    //   352: pop
    //   353: new 64	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   360: ldc 234
    //   362: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload_3
    //   366: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: aconst_null
    //   373: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   376: new 119	java/io/File
    //   379: dup
    //   380: aload_2
    //   381: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   384: astore_2
    //   385: new 64	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   392: ldc 236
    //   394: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_2
    //   398: invokevirtual 144	java/io/File:exists	()Z
    //   401: invokevirtual 153	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: aconst_null
    //   408: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload_0
    //   412: invokevirtual 239	ankf$a:dRc	()V
    //   415: aload_1
    //   416: ifnull +17 -> 433
    //   419: aload_1
    //   420: invokevirtual 102	java/lang/Process:destroy	()V
    //   423: getstatic 92	ankf:d	Ljava/lang/Process;
    //   426: ifnull +7 -> 433
    //   429: aconst_null
    //   430: putstatic 92	ankf:d	Ljava/lang/Process;
    //   433: iload_3
    //   434: ireturn
    //   435: bipush 244
    //   437: ireturn
    //   438: astore_0
    //   439: ldc 241
    //   441: aload_0
    //   442: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   445: bipush 245
    //   447: ireturn
    //   448: astore 5
    //   450: ldc 241
    //   452: aload 5
    //   454: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   457: goto -137 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	paramString1	String
    //   0	460	1	paramString2	String
    //   0	460	2	paramString3	String
    //   0	460	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	331	5	localObject	Object
    //   448	5	5	localInterruptedException	java.lang.InterruptedException
    //   6	85	6	str	String
    // Exception table:
    //   from	to	target	type
    //   297	306	438	java/io/IOException
    //   315	320	448	java/lang/InterruptedException
  }
  
  /* Error */
  public static int h(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 135	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 141	ankc:am	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 5
    //   8: new 119	java/io/File
    //   11: dup
    //   12: aload 5
    //   14: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 144	java/io/File:exists	()Z
    //   24: ifeq +326 -> 350
    //   27: aload 4
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 148	java/io/File:setExecutable	(ZZ)Z
    //   34: istore_3
    //   35: new 64	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   42: ldc 150
    //   44: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 153	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_0
    //   59: iload_2
    //   60: invokestatic 165	ankf:x	(Ljava/lang/String;I)I
    //   63: pop
    //   64: new 167	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 168	java/util/ArrayList:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: aload 5
    //   77: invokeinterface 174 2 0
    //   82: pop
    //   83: aload 4
    //   85: ldc 176
    //   87: invokeinterface 174 2 0
    //   92: pop
    //   93: aload 4
    //   95: ldc 178
    //   97: invokeinterface 174 2 0
    //   102: pop
    //   103: aload 4
    //   105: ldc 180
    //   107: invokeinterface 174 2 0
    //   112: pop
    //   113: aload 4
    //   115: ldc 182
    //   117: invokeinterface 174 2 0
    //   122: pop
    //   123: aload 4
    //   125: ldc 184
    //   127: invokeinterface 174 2 0
    //   132: pop
    //   133: aload 4
    //   135: aload_0
    //   136: invokeinterface 174 2 0
    //   141: pop
    //   142: aload 4
    //   144: ldc 245
    //   146: invokeinterface 174 2 0
    //   151: pop
    //   152: aload 4
    //   154: ldc 247
    //   156: invokeinterface 174 2 0
    //   161: pop
    //   162: aload 4
    //   164: ldc 249
    //   166: invokeinterface 174 2 0
    //   171: pop
    //   172: aload 4
    //   174: ldc 251
    //   176: invokeinterface 174 2 0
    //   181: pop
    //   182: aload 4
    //   184: aload_1
    //   185: invokeinterface 174 2 0
    //   190: pop
    //   191: aload 4
    //   193: invokestatic 135	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   196: invokestatic 193	ankc:an	(Landroid/content/Context;)Ljava/lang/String;
    //   199: invokeinterface 174 2 0
    //   204: pop
    //   205: new 6	ankf$a
    //   208: dup
    //   209: aconst_null
    //   210: invokespecial 199	ankf$a:<init>	(Lankg;)V
    //   213: astore_0
    //   214: new 201	java/lang/ProcessBuilder
    //   217: dup
    //   218: iconst_0
    //   219: anewarray 203	java/lang/String
    //   222: invokespecial 206	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   225: astore 5
    //   227: aload 5
    //   229: iconst_1
    //   230: invokevirtual 210	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   233: pop
    //   234: aload 5
    //   236: aload 4
    //   238: invokevirtual 214	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   241: pop
    //   242: aload 5
    //   244: invokevirtual 218	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   247: astore 4
    //   249: aload 4
    //   251: putstatic 106	ankf:e	Ljava/lang/Process;
    //   254: aload_0
    //   255: aload 4
    //   257: putfield 220	ankf$a:a	Ljava/lang/Process;
    //   260: aload_0
    //   261: invokevirtual 223	ankf$a:initStream	()V
    //   264: aload 4
    //   266: invokevirtual 226	java/lang/Process:waitFor	()I
    //   269: pop
    //   270: aload 4
    //   272: invokevirtual 229	java/lang/Process:exitValue	()I
    //   275: istore_2
    //   276: iload_2
    //   277: ifeq +47 -> 324
    //   280: new 119	java/io/File
    //   283: dup
    //   284: aload_1
    //   285: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 144	java/io/File:exists	()Z
    //   293: ifeq +8 -> 301
    //   296: aload_1
    //   297: invokevirtual 232	java/io/File:delete	()Z
    //   300: pop
    //   301: new 64	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   308: ldc 234
    //   310: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload_2
    //   314: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: aconst_null
    //   321: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   324: aload_0
    //   325: invokevirtual 239	ankf$a:dRc	()V
    //   328: aload 4
    //   330: ifnull +18 -> 348
    //   333: aload 4
    //   335: invokevirtual 102	java/lang/Process:destroy	()V
    //   338: getstatic 106	ankf:e	Ljava/lang/Process;
    //   341: ifnull +7 -> 348
    //   344: aconst_null
    //   345: putstatic 106	ankf:e	Ljava/lang/Process;
    //   348: iload_2
    //   349: ireturn
    //   350: bipush 244
    //   352: ireturn
    //   353: astore_0
    //   354: ldc 241
    //   356: aload_0
    //   357: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: bipush 245
    //   362: ireturn
    //   363: astore 5
    //   365: ldc 241
    //   367: aload 5
    //   369: invokestatic 84	ankf:k	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: goto -102 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramString1	String
    //   0	375	1	paramString2	String
    //   0	375	2	paramInt	int
    //   34	14	3	bool	boolean
    //   17	317	4	localObject1	Object
    //   6	237	5	localObject2	Object
    //   363	5	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   242	254	353	java/io/IOException
    //   264	270	363	java/lang/InterruptedException
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
    this.jdField_a_of_type_Ankf$b.inputBuffer.position(0);
    if (this.b.readSampleData(this.jdField_a_of_type_Ankf$b.inputBuffer, 0) <= 0)
    {
      releaseExtractor();
      i = -5;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Ankf$b.inputBuffer.position(0);
    } while (this.c.readSampleData(this.jdField_a_of_type_Ankf$b.inputBuffer, 0) > 0);
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
      this.jdField_a_of_type_Ankf$b.init(this.mWidth, this.mHeight);
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
      this.jdField_a_of_type_Ankf$b.videoTrack = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(localMediaFormat);
      this.jdField_a_of_type_Ankf$b.buj = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)localObject);
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
          ankf.n("[@] compressVideo log:" + str, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankf
 * JD-Core Version:    0.7.0.1
 */