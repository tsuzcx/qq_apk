package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import exw;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

public class QQRecorder
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a = "QQRecorder";
  private static int[] jdField_a_of_type_ArrayOfInt = { 13, 14, 16, 18, 20, 21, 27, 32 };
  static final int b = 2;
  public static final String b = "http://kf.qq.com/touch/apifaq/1211147RVfAV140904mA3QjU.html?platform=14";
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  private static String jdField_d_of_type_JavaLangString;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  public static final int h = 500;
  public static final int i = 250;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  private static final int o = 2;
  private static final int p = 2;
  private static final int q = 20480;
  private static final int r = 800;
  private static final int v = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public AudioManager a;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord = null;
  private IAudioCompressor jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private PTTAgcWrapper jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = null;
  private QQRecorder.OnQQRecorderListener jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener;
  public QQRecorder.RecorderParam a;
  public exw a;
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private int s = 20480;
  private int t = 800;
  private int u = 0;
  private int w = -1;
  private int x = -1;
  
  static
  {
    d = null;
  }
  
  public QQRecorder(Context paramContext)
  {
    this.c = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(RecordParams.f, 0, 0);
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_record.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "Init | dpc config = " + paramContext);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.w = Integer.parseInt(paramContext[0]);
        this.x = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.e()) && ((this.w == 3) || (this.x == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.w = -1;
        this.x = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "mMode = " + this.w + " | mAudioSource = " + this.x + " | recorderBufSize = " + this.s + " | readLength = " + this.t);
    }
  }
  
  public static double a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLong <= 0L) {
      return 0.0D;
    }
    return paramLong / b(paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(byte paramByte, InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2];
    paramByte = 0;
    while (paramInputStream.read(arrayOfByte) > 0)
    {
      int i1 = RecordParams.a(arrayOfByte);
      byte b1 = paramByte + 20;
      paramByte = b1;
      if (i1 > 0)
      {
        paramInputStream.skip(i1);
        paramByte = b1;
      }
    }
    return paramByte;
  }
  
  public static int a(double paramDouble)
  {
    return b(paramDouble / 1000.0D);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 2;
    switch (paramInt2)
    {
    default: 
      throw new RuntimeException("channel Illegal");
    }
    for (paramInt2 = 1;; paramInt2 = 2) {
      switch (paramInt3)
      {
      default: 
        throw new RuntimeException("format Illegal");
      }
    }
    i1 = 1;
    return i1 * paramInt1 * paramInt2;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    String str = null;
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "voiceLength getFilePlayTime " + ((MessageForPtt)paramMessageRecord).voiceLength);
      }
      if (((MessageForPtt)paramMessageRecord).voiceLength > 1) {
        return ((MessageForPtt)paramMessageRecord).voiceLength;
      }
      str = ((MessageForPtt)paramMessageRecord).getLocalFilePath();
    }
    while (str != null)
    {
      return a(str);
      if ((paramMessageRecord instanceof QQMessageFacade.Message)) {
        str = ((QQMessageFacade.Message)paramMessageRecord).pttUrl;
      }
    }
    return 0;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: new 258	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 261	java/io/DataInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 264	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 7
    //   27: aload_0
    //   28: invokevirtual 268	java/io/FileInputStream:available	()I
    //   31: istore 4
    //   33: bipush 10
    //   35: newarray byte
    //   37: astore 8
    //   39: aload 7
    //   41: aload 8
    //   43: invokevirtual 269	java/io/DataInputStream:read	([B)I
    //   46: aload 8
    //   48: arraylength
    //   49: if_icmpne +234 -> 283
    //   52: aload 8
    //   54: invokestatic 272	com/tencent/mobileqq/utils/RecordParams:a	([B)Z
    //   57: ifeq +54 -> 111
    //   60: aload 8
    //   62: iconst_0
    //   63: baload
    //   64: aload 7
    //   66: invokestatic 274	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: i2d
    //   70: ldc2_w 226
    //   73: ddiv
    //   74: dstore_1
    //   75: aload 7
    //   77: invokevirtual 277	java/io/DataInputStream:close	()V
    //   80: aload_0
    //   81: invokevirtual 278	java/io/FileInputStream:close	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 278	java/io/FileInputStream:close	()V
    //   94: aload 6
    //   96: ifnull +8 -> 104
    //   99: aload 6
    //   101: invokevirtual 277	java/io/DataInputStream:close	()V
    //   104: dload_1
    //   105: invokestatic 229	com/tencent/mobileqq/utils/QQRecorder:b	(D)I
    //   108: istore_3
    //   109: iload_3
    //   110: ireturn
    //   111: aload 8
    //   113: bipush 6
    //   115: baload
    //   116: iconst_3
    //   117: ishr
    //   118: i2b
    //   119: bipush 7
    //   121: iand
    //   122: i2b
    //   123: istore 5
    //   125: iload 4
    //   127: i2d
    //   128: dstore_1
    //   129: getstatic 64	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ArrayOfInt	[I
    //   132: iload 5
    //   134: iaload
    //   135: istore 4
    //   137: dload_1
    //   138: ldc2_w 279
    //   141: dsub
    //   142: iload 4
    //   144: i2d
    //   145: ddiv
    //   146: ldc2_w 281
    //   149: ddiv
    //   150: dstore_1
    //   151: goto -76 -> 75
    //   154: astore 8
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 7
    //   160: astore 6
    //   162: aload 8
    //   164: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   167: aload 6
    //   169: ifnull +8 -> 177
    //   172: aload 6
    //   174: invokevirtual 278	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: ifnull -69 -> 109
    //   181: aload_0
    //   182: invokevirtual 277	java/io/DataInputStream:close	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_0
    //   188: iconst_0
    //   189: ireturn
    //   190: astore 6
    //   192: aconst_null
    //   193: astore 7
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 278	java/io/FileInputStream:close	()V
    //   205: aload 7
    //   207: ifnull +8 -> 215
    //   210: aload 7
    //   212: invokevirtual 277	java/io/DataInputStream:close	()V
    //   215: aload 6
    //   217: athrow
    //   218: astore_0
    //   219: goto -4 -> 215
    //   222: astore 6
    //   224: aconst_null
    //   225: astore 7
    //   227: goto -30 -> 197
    //   230: astore 6
    //   232: goto -35 -> 197
    //   235: astore 7
    //   237: aload 6
    //   239: astore 8
    //   241: aload 7
    //   243: astore 6
    //   245: aload_0
    //   246: astore 7
    //   248: aload 8
    //   250: astore_0
    //   251: goto -54 -> 197
    //   254: astore 8
    //   256: aconst_null
    //   257: astore 7
    //   259: aload_0
    //   260: astore 6
    //   262: aload 7
    //   264: astore_0
    //   265: goto -103 -> 162
    //   268: astore 8
    //   270: aload_0
    //   271: astore 6
    //   273: aload 7
    //   275: astore_0
    //   276: goto -114 -> 162
    //   279: astore_0
    //   280: goto -176 -> 104
    //   283: aload 7
    //   285: astore 6
    //   287: dconst_0
    //   288: dstore_1
    //   289: goto -203 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString	String
    //   74	215	1	d1	double
    //   1	109	3	i1	int
    //   31	112	4	i2	int
    //   123	10	5	i3	int
    //   6	167	6	localDataInputStream1	java.io.DataInputStream
    //   190	26	6	localObject1	Object
    //   222	1	6	localObject2	Object
    //   230	8	6	localObject3	Object
    //   243	43	6	localObject4	Object
    //   3	223	7	localDataInputStream2	java.io.DataInputStream
    //   235	7	7	localObject5	Object
    //   246	38	7	str	String
    //   37	75	8	arrayOfByte	byte[]
    //   154	9	8	localException1	Exception
    //   239	10	8	localObject6	Object
    //   254	1	8	localException2	Exception
    //   268	1	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   8	17	154	java/lang/Exception
    //   172	177	187	java/lang/Exception
    //   181	185	187	java/lang/Exception
    //   8	17	190	finally
    //   201	205	218	java/lang/Exception
    //   210	215	218	java/lang/Exception
    //   17	27	222	finally
    //   80	84	222	finally
    //   27	75	230	finally
    //   75	80	230	finally
    //   129	137	230	finally
    //   162	167	235	finally
    //   17	27	254	java/lang/Exception
    //   80	84	254	java/lang/Exception
    //   27	75	268	java/lang/Exception
    //   75	80	268	java/lang/Exception
    //   129	137	268	java/lang/Exception
    //   90	94	279	java/lang/Exception
    //   99	104	279	java/lang/Exception
  }
  
  public static String a()
  {
    return d;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, 2, 2);
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.s = (paramInt2 * paramInt1);
      }
    }
    for (;;)
    {
      if (paramInt3 != -1) {
        this.t = paramInt3;
      }
      return;
      if (paramInt2 != -1) {
        this.s = paramInt2;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      if (!AmrInputStreamWrapper.a()) {}
    }
    while ((SilkCodecWrapper.a()) || (FileUtils.a() > 1310720.0F))
    {
      do
      {
        return true;
      } while (FileUtils.a() > 327680.0F);
      return false;
    }
    return false;
  }
  
  private static double b(long paramLong, int paramInt)
  {
    return a(paramInt, 2, 2, paramLong);
  }
  
  public static int b(double paramDouble)
  {
    double d1 = paramDouble;
    if (paramDouble <= 0.5D)
    {
      d1 = paramDouble;
      if (paramDouble > 0.0D) {
        d1 = paramDouble + 0.5D;
      }
    }
    return (int)(d1 + 0.5D);
  }
  
  private static int b(int paramInt)
  {
    return a(paramInt, 2, 2);
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  private void b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
      this.jdField_a_of_type_AndroidMediaAudioRecord.release();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    for (int i1 = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "startRecording | audio mode = " + i1);
      }
      if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.w != -1)) {
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.w);
      }
      if (this.x == -1) {}
      for (i1 = i2;; i1 = this.x)
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(i1, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, 2, 2, this.s);
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 1) {
          break;
        }
        i1 = this.jdField_a_of_type_AndroidMediaAudioRecord.getState();
        if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
          this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        }
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
        throw new QQRecorder.RecordInitException("mRecorder.getState is not STATE_INITIALIZED, state = " + i1);
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener.a();
      }
      return;
    }
  }
  
  private static void b(String paramString, boolean paramBoolean, HashMap paramHashMap)
  {
    if (new Random().nextInt(1000) == 521)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "real do report");
      }
      StatisticCollector.a(BaseApplication.getContext()).a("", paramString, paramBoolean, 0L, 0L, paramHashMap, "");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = PTTAgcWrapper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a);
    this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = NoiseSuppression.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c == 0) {}
    for (this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor = new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext);; this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor = new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor.a(this.t);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mAudioType=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c + ", mSampleRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a + " ,mBitRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.b + " ,Codec=" + this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor).append(" ,agcCode = " + this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper).append(" ,nsCodec = " + this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression).append(" ,time is :").append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public static boolean c()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor = null;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Exw == null) {
      return 0;
    }
    return this.u;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_Exw + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Exw != null) {
      this.jdField_a_of_type_Exw.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a(QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    int i1 = AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.a, 2, 2);
    if (this.s < i1) {
      this.s = i1;
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_Exw + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Exw == null)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Exw = new exw(this, paramString);
      this.jdField_a_of_type_Exw.start();
      d = paramString;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener.a(paramString);
  }
  
  public void a(Throwable paramThrowable)
  {
    int i1 = 7;
    try
    {
      String str = paramThrowable.toString();
      if ((paramThrowable instanceof RuntimeException)) {
        if (str.contains("STATE_INITIALIZED")) {
          i1 = 2;
        }
      }
      for (;;)
      {
        paramThrowable = new HashMap();
        paramThrowable.put("exceptionType", i1 + "");
        paramThrowable.put("osVersion", Build.VERSION.SDK_INT + "");
        paramThrowable.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        paramThrowable.put("exceptionMsg", str);
        b("actPttRecordException", false, paramThrowable);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQRecorder", 2, "report exception(catch exception) | exceptionType = " + i1 + " | exceptionMessage = " + str);
        return;
        if ((paramThrowable instanceof UnsatisfiedLinkError)) {
          if (str.contains("Native method not found"))
          {
            i1 = 4;
          }
          else
          {
            boolean bool = str.contains("Library not found");
            if (bool) {
              i1 = 5;
            } else {
              i1 = 6;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "Report exception error.", paramThrowable);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Exw != null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Exw == null) || (!this.jdField_a_of_type_Exw.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder
 * JD-Core Version:    0.7.0.1
 */