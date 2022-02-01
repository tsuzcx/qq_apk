package com.tencent.mobileqq.utils;

import aliv;
import aliv.a;
import aliw;
import aliy;
import allc;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.StatFs;
import android.text.TextUtils;
import anpc;
import aqhq;
import aqlp;
import aqlv;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

public class QQRecorder
{
  private static String cub;
  public static int dZK = 60000;
  private static int[] frameSize = { 13, 14, 16, 18, 20, 21, 27, 32 };
  public RecordThread a;
  public RecorderParam a;
  private a jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$a;
  private b jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$b;
  private aliy b;
  boolean cUu = false;
  public boolean cUv;
  private Context context;
  private String cua;
  private AudioRecord d;
  private int dZJ;
  private int frameLengthPerRead = 800;
  AudioManager mAudioManager;
  private int mAudioSource = -1;
  private int mMode = -1;
  private boolean needCompress = true;
  private int recorderInitBufSize = 20480;
  
  public QQRecorder(Context paramContext)
  {
    this.context = paramContext;
    this.mAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new RecorderParam(aqlv.dZQ, 0, 0);
    paramContext = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.qq_audio_record.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "Init | dpc config = " + paramContext);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.mMode = Integer.parseInt(paramContext[0]);
        this.mAudioSource = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          initBufferSize(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.isHoneycomb()) && ((this.mMode == 3) || (this.mAudioSource == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.mMode = -1;
        this.mAudioSource = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "mMode = " + this.mMode + " | mAudioSource = " + this.mAudioSource + " | recorderBufSize = " + this.recorderInitBufSize + " | readLength = " + this.frameLengthPerRead);
    }
  }
  
  public static String Cf()
  {
    return cub;
  }
  
  public static double a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLong <= 0L) {
      return 0.0D;
    }
    return paramLong / bytesInMillisecond(paramInt1, paramInt2, paramInt3);
  }
  
  private static double a(long paramLong, int paramInt)
  {
    return a(paramInt, 2, 2, paramLong);
  }
  
  public static int a(byte paramByte, InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[2];
    paramByte = 0;
    while (paramInputStream.read(arrayOfByte) > 0)
    {
      int i = aqlv.z(arrayOfByte);
      byte b1 = paramByte + 20;
      paramByte = b1;
      if (i > 0)
      {
        paramInputStream.skip(i);
        paramByte = b1;
      }
    }
    return paramByte;
  }
  
  public static RecorderParam a()
  {
    return new RecorderParam(aqlv.dZQ, 0, 0);
  }
  
  private static void a(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (new Random().nextInt(1000) == 521)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "real do report");
      }
      anpc.a(BaseApplication.getContext()).collectPerformance("", paramString, paramBoolean, 0L, 0L, paramHashMap, "");
    }
  }
  
  public static boolean aES()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1;
  }
  
  public static int bytesInMillisecond(int paramInt1, int paramInt2, int paramInt3)
  {
    return bytesInSecond(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  public static int bytesInSecond(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
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
    i = 1;
    return i * paramInt1 * paramInt2;
  }
  
  public static int d(double paramDouble)
  {
    return e(paramDouble / 1000.0D);
  }
  
  public static int e(double paramDouble)
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
  
  private void eeh()
    throws IOException
  {
    this.b = new aliy();
    Object localObject = new WechatNsWrapper(this.context);
    if (WechatNsWrapper.soLoaded) {
      this.b.a((aliv)localObject);
    }
    if (this.needCompress)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mAudioType != 0) {
        break label219;
      }
      this.b.a(new AmrInputStreamWrapper(this.context));
    }
    for (;;)
    {
      this.b.init(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mSampleRate, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mBitRate, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mAudioType);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mAudioType=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mAudioType + ", mSampleRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mSampleRate + " ,mBitRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mBitRate + " ,Codec=" + this.b).append(" ,processor = ").append(" ,time is :").append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
      }
      return;
      label219:
      this.b.a(new SilkCodecWrapper(this.context));
    }
  }
  
  private void eei()
    throws IOException
  {
    if (this.b != null)
    {
      this.b.release();
      this.b = null;
    }
  }
  
  /* Error */
  public static int fi(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: new 381	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 382	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 384	java/io/DataInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 387	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 7
    //   27: aload_0
    //   28: invokevirtual 390	java/io/FileInputStream:available	()I
    //   31: istore 4
    //   33: bipush 10
    //   35: newarray byte
    //   37: astore 8
    //   39: aload 7
    //   41: aload 8
    //   43: invokevirtual 391	java/io/DataInputStream:read	([B)I
    //   46: aload 8
    //   48: arraylength
    //   49: if_icmpne +234 -> 283
    //   52: aload 8
    //   54: invokestatic 395	aqlv:u	([B)Z
    //   57: ifeq +54 -> 111
    //   60: aload 8
    //   62: iconst_0
    //   63: baload
    //   64: aload 7
    //   66: invokestatic 397	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: i2d
    //   70: ldc2_w 314
    //   73: ddiv
    //   74: dstore_1
    //   75: aload 7
    //   77: invokevirtual 400	java/io/DataInputStream:close	()V
    //   80: aload_0
    //   81: invokevirtual 401	java/io/FileInputStream:close	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 401	java/io/FileInputStream:close	()V
    //   94: aload 6
    //   96: ifnull +8 -> 104
    //   99: aload 6
    //   101: invokevirtual 400	java/io/DataInputStream:close	()V
    //   104: dload_1
    //   105: invokestatic 318	com/tencent/mobileqq/utils/QQRecorder:e	(D)I
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
    //   129: getstatic 56	com/tencent/mobileqq/utils/QQRecorder:frameSize	[I
    //   132: iload 5
    //   134: iaload
    //   135: istore 4
    //   137: dload_1
    //   138: ldc2_w 402
    //   141: dsub
    //   142: iload 4
    //   144: i2d
    //   145: ddiv
    //   146: ldc2_w 404
    //   149: ddiv
    //   150: dstore_1
    //   151: goto -76 -> 75
    //   154: astore 8
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 7
    //   160: astore 6
    //   162: aload 8
    //   164: invokevirtual 408	java/lang/Exception:printStackTrace	()V
    //   167: aload 6
    //   169: ifnull +8 -> 177
    //   172: aload 6
    //   174: invokevirtual 401	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: ifnull -69 -> 109
    //   181: aload_0
    //   182: invokevirtual 400	java/io/DataInputStream:close	()V
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
    //   202: invokevirtual 401	java/io/FileInputStream:close	()V
    //   205: aload 7
    //   207: ifnull +8 -> 215
    //   210: aload 7
    //   212: invokevirtual 400	java/io/DataInputStream:close	()V
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
    //   1	109	3	i	int
    //   31	112	4	j	int
    //   123	10	5	k	int
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
  
  public static int kd(int paramInt)
  {
    String str1 = Build.MANUFACTURER + "-" + Build.MODEL;
    String str2 = Build.MANUFACTURER;
    int i;
    if ((str1.equalsIgnoreCase("Xiaomi-MI NOTE Pro")) || (str2.equalsIgnoreCase("OPPO"))) {
      i = paramInt + 100;
    }
    do
    {
      return i;
      i = paramInt;
    } while (!str2.equalsIgnoreCase("vivo"));
    return paramInt + 130;
  }
  
  private static int ke(int paramInt)
  {
    return bytesInSecond(paramInt, 2, 2);
  }
  
  public static boolean mw(int paramInt)
  {
    if (paramInt == 0) {
      if (!AmrInputStreamWrapper.aCf()) {}
    }
    while ((SilkCodecWrapper.aCf()) || (aqhq.getAvailableInnernalMemorySize() > 1310720.0F))
    {
      do
      {
        return true;
      } while (aqhq.getAvailableInnernalMemorySize() > 327680.0F);
      return false;
    }
    return false;
  }
  
  public static int n(MessageRecord paramMessageRecord)
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
      return fi(str);
      if ((paramMessageRecord instanceof QQMessageFacade.Message)) {
        str = ((QQMessageFacade.Message)paramMessageRecord).pttUrl;
      }
    }
    return 0;
  }
  
  private void startRecording()
  {
    if (this.mAudioManager != null) {}
    for (int i = this.mAudioManager.getMode();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "startRecording | audio mode = " + i);
      }
      if ((this.mAudioManager != null) && (this.mMode != -1)) {
        this.mAudioManager.setMode(this.mMode);
      }
      if ((this.d == null) || (this.d.getState() == 0) || (this.cUu)) {
        if (this.mAudioSource != -1) {
          break label203;
        }
      }
      label203:
      for (i = 0;; i = this.mAudioSource)
      {
        this.d = new AudioRecord(i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mSampleRate, 2, 2, this.recorderInitBufSize);
        this.cUu = false;
        if (this.d.getState() == 1) {
          break;
        }
        i = this.d.getState();
        if (this.d != null) {
          this.d.release();
        }
        this.d = null;
        throw new RecordInitException("mRecorder.getState is not STATE_INITIALIZED, state = " + i);
      }
      allc.a(this.d);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$a.hB();
      }
      return;
    }
  }
  
  public void SI(boolean paramBoolean)
  {
    if (this.cUv != paramBoolean)
    {
      this.cUv = paramBoolean;
      this.cUu = true;
    }
  }
  
  public void US(String paramString)
  {
    this.cua = paramString;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$a = parama;
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$b = paramb;
  }
  
  public void b(RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mSampleRate != paramRecorderParam.mSampleRate) {
      this.cUu = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    ThreadManager.excute(new QQRecorder.1(this), 16, null, false);
  }
  
  public void initBufferSize(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.mSampleRate, 2, 2);
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.recorderInitBufSize = (paramInt2 * paramInt1);
      }
    }
    for (;;)
    {
      if (paramInt3 != -1) {
        this.frameLengthPerRead = paramInt3;
      }
      return;
      if (paramInt2 != -1) {
        this.recorderInitBufSize = paramInt2;
      }
    }
  }
  
  public boolean isRecording()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.isRunning);
  }
  
  public boolean isStop()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.isRunning);
  }
  
  void m(Throwable paramThrowable)
  {
    int i = 7;
    try
    {
      String str = paramThrowable.toString();
      if ((paramThrowable instanceof RuntimeException)) {
        if (str.contains("STATE_INITIALIZED")) {
          i = 2;
        }
      }
      for (;;)
      {
        paramThrowable = new HashMap();
        paramThrowable.put("exceptionType", i + "");
        paramThrowable.put("osVersion", Build.VERSION.SDK_INT + "");
        paramThrowable.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        paramThrowable.put("exceptionMsg", str);
        a("actPttRecordException", false, paramThrowable);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQRecorder", 2, "report exception(catch exception) | exceptionType = " + i + " | exceptionMessage = " + str);
        return;
        if ((paramThrowable instanceof UnsatisfiedLinkError)) {
          if (str.contains("Native method not found"))
          {
            i = 4;
          }
          else
          {
            boolean bool = str.contains("Library not found");
            if (bool) {
              i = 5;
            } else {
              i = 6;
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
  
  public void release()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.aET())) {}
    synchronized (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.isAlive = false;
    }
  }
  
  public void start(String paramString)
  {
    start(paramString, true);
  }
  
  public void start(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread + ", time is:" + System.currentTimeMillis());
    }
    if (this.mAudioManager != null) {}
    try
    {
      if (this.mAudioManager.isMicrophoneMute())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "mic is mute, set mute false.");
        }
        this.mAudioManager.setMicrophoneMute(false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQRecorder", 2, "setMicrophoneMute error.", localException);
        }
      }
      if (!QLog.isColorLevel()) {
        break label199;
      }
      QLog.d("QQRecorder", 2, "start, RecordThread exist , notify ");
      synchronized (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.isAlive = true;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.recorderPath = paramString;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.init();
        try
        {
          notifyAll();
          return;
        }
        finally {}
      }
    }
    this.needCompress = paramBoolean;
    cub = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.aET()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder.start, new RecordThread ");
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread = new RecordThread();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.recorderPath = paramString;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.init();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.start();
      return;
    }
  }
  
  public boolean stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.isRunning;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.isRunning = false;
      return bool;
    }
    return false;
  }
  
  static class RecordInitException
    extends RuntimeException
  {
    public RecordInitException(String paramString)
    {
      super();
    }
  }
  
  static class RecordNoPermissonException
    extends RuntimeException
  {
    public RecordNoPermissonException(String paramString)
    {
      super();
    }
  }
  
  class RecordThread
    extends Thread
    implements aliw
  {
    long ata = 0L;
    File bb;
    private boolean cUw;
    int dZL = 0;
    public volatile boolean isAlive = true;
    public volatile boolean isRunning = true;
    FileOutputStream n;
    public String recorderPath;
    
    RecordThread() {}
    
    /* Error */
    private void UT(String paramString)
    {
      // Byte code:
      //   0: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3: ifeq +28 -> 31
      //   6: ldc 55
      //   8: iconst_2
      //   9: new 57	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   16: ldc 60
      //   18: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: aload_0
      //   22: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   25: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   28: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   31: lconst_0
      //   32: lstore 28
      //   34: lconst_0
      //   35: lstore 24
      //   37: iconst_0
      //   38: istore 14
      //   40: dconst_0
      //   41: dstore_2
      //   42: iconst_m1
      //   43: istore 18
      //   45: lconst_0
      //   46: lstore 22
      //   48: iconst_0
      //   49: istore 17
      //   51: iconst_0
      //   52: istore 19
      //   54: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   57: lstore 34
      //   59: lconst_0
      //   60: lstore 20
      //   62: iconst_0
      //   63: istore 15
      //   65: iconst_0
      //   66: istore 13
      //   68: iconst_0
      //   69: istore 12
      //   71: lconst_0
      //   72: lstore 30
      //   74: sipush 250
      //   77: istore 10
      //   79: bipush 237
      //   81: invokestatic 87	android/os/Process:setThreadPriority	(I)V
      //   84: aload_0
      //   85: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   88: invokestatic 91	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
      //   91: iconst_1
      //   92: invokestatic 97	aqge:m	(Landroid/content/Context;Z)Z
      //   95: pop
      //   96: aload_0
      //   97: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   100: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   103: ifnull +14 -> 117
      //   106: aload_0
      //   107: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   110: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   113: iconst_0
      //   114: putfield 105	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:dZO	I
      //   117: aload_0
      //   118: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   121: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   124: ifnull +23 -> 147
      //   127: aload_0
      //   128: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   131: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   134: aload_1
      //   135: aload_0
      //   136: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   139: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   142: invokeinterface 113 3 0
      //   147: aload_0
      //   148: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   151: invokestatic 117	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   154: newarray byte
      //   156: astore 36
      //   158: aload_0
      //   159: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   162: invokestatic 119	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
      //   165: aload_0
      //   166: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   169: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   172: ifnull +38 -> 210
      //   175: aload_0
      //   176: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   179: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   182: invokeinterface 123 1 0
      //   187: istore 11
      //   189: iload 11
      //   191: istore 10
      //   193: iload 11
      //   195: ifgt +8 -> 203
      //   198: sipush 250
      //   201: istore 10
      //   203: iload 10
      //   205: invokestatic 127	com/tencent/mobileqq/utils/QQRecorder:kd	(I)I
      //   208: istore 10
      //   210: invokestatic 130	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   213: ifeq +34 -> 247
      //   216: ldc 55
      //   218: iconst_4
      //   219: new 57	java/lang/StringBuilder
      //   222: dup
      //   223: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   226: ldc 132
      //   228: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
      //   234: getstatic 142	aomq:aqc	J
      //   237: lsub
      //   238: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   241: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   244: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   247: aload_0
      //   248: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   251: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
      //   254: aload_0
      //   255: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   258: invokestatic 150	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Laliy;
      //   261: aload_0
      //   262: invokevirtual 155	aliy:a	(Laliw;)V
      //   265: ldc2_w 156
      //   268: invokestatic 161	java/lang/Thread:sleep	(J)V
      //   271: aload_0
      //   272: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   275: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   278: getfield 164	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:mSampleRate	I
      //   281: invokestatic 167	com/tencent/mobileqq/utils/QQRecorder:kf	(I)I
      //   284: sipush 1000
      //   287: idiv
      //   288: iload 10
      //   290: imul
      //   291: istore 16
      //   293: iconst_0
      //   294: istore 10
      //   296: iload 10
      //   298: iload 16
      //   300: if_icmpge +60 -> 360
      //   303: aload_0
      //   304: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   307: invokestatic 117	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   310: istore 11
      //   312: aload_0
      //   313: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   316: invokestatic 117	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   319: iload 16
      //   321: iload 10
      //   323: isub
      //   324: if_icmple +10 -> 334
      //   327: iload 16
      //   329: iload 10
      //   331: isub
      //   332: istore 11
      //   334: aload_0
      //   335: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   338: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   341: aload 36
      //   343: iconst_0
      //   344: iload 11
      //   346: invokevirtual 176	android/media/AudioRecord:read	([BII)I
      //   349: pop
      //   350: iload 11
      //   352: iload 10
      //   354: iadd
      //   355: istore 10
      //   357: goto -61 -> 296
      //   360: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   363: ifeq +39 -> 402
      //   366: ldc 55
      //   368: iconst_2
      //   369: new 57	java/lang/StringBuilder
      //   372: dup
      //   373: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   376: ldc 178
      //   378: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   381: iload 10
      //   383: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   386: ldc 183
      //   388: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: iload 16
      //   393: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   396: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   399: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   402: aload_0
      //   403: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   406: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   409: ifnull +70 -> 479
      //   412: aload_0
      //   413: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   416: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   419: aload_0
      //   420: getfield 185	com/tencent/mobileqq/utils/QQRecorder$RecordThread:recorderPath	Ljava/lang/String;
      //   423: aload_0
      //   424: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   427: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   430: invokeinterface 188 3 0
      //   435: istore 18
      //   437: iload 18
      //   439: sipush 1000
      //   442: idiv
      //   443: bipush 10
      //   445: imul
      //   446: istore 11
      //   448: iload 11
      //   450: istore 10
      //   452: iload 11
      //   454: sipush 6000
      //   457: if_icmple +8 -> 465
      //   460: sipush 6000
      //   463: istore 10
      //   465: aload_0
      //   466: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   469: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   472: iload 10
      //   474: newarray int
      //   476: putfield 192	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:oY	[I
      //   479: invokestatic 130	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   482: ifeq +34 -> 516
      //   485: ldc 55
      //   487: iconst_4
      //   488: new 57	java/lang/StringBuilder
      //   491: dup
      //   492: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   495: ldc 194
      //   497: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   500: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
      //   503: getstatic 142	aomq:aqc	J
      //   506: lsub
      //   507: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   510: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   513: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   516: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   519: lstore 32
      //   521: iconst_0
      //   522: istore 16
      //   524: iconst_0
      //   525: istore 10
      //   527: lconst_0
      //   528: lstore 24
      //   530: lconst_0
      //   531: lstore 22
      //   533: lconst_0
      //   534: lstore 26
      //   536: dconst_0
      //   537: dstore_2
      //   538: lconst_0
      //   539: lstore 20
      //   541: iconst_0
      //   542: istore 11
      //   544: aload_0
      //   545: getfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:isRunning	Z
      //   548: ifeq +1532 -> 2080
      //   551: aload_0
      //   552: getfield 196	com/tencent/mobileqq/utils/QQRecorder$RecordThread:cUw	Z
      //   555: ifne +1525 -> 2080
      //   558: iload 11
      //   560: istore 13
      //   562: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   565: lload 32
      //   567: lsub
      //   568: ldc2_w 197
      //   571: lcmp
      //   572: ifle +828 -> 1400
      //   575: iload 11
      //   577: istore 13
      //   579: iload 11
      //   581: ifne +819 -> 1400
      //   584: iconst_1
      //   585: istore 13
      //   587: lload 24
      //   589: lconst_0
      //   590: lcmp
      //   591: ifeq +8 -> 599
      //   594: iload 12
      //   596: ifne +804 -> 1400
      //   599: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   602: ifeq +39 -> 641
      //   605: ldc 55
      //   607: iconst_2
      //   608: new 57	java/lang/StringBuilder
      //   611: dup
      //   612: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   615: ldc 200
      //   617: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   620: lload 24
      //   622: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   625: ldc 202
      //   627: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: iload 12
      //   632: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   635: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   638: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   641: new 204	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException
      //   644: dup
      //   645: ldc 206
      //   647: invokespecial 208	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException:<init>	(Ljava/lang/String;)V
      //   650: athrow
      //   651: astore 36
      //   653: lload 20
      //   655: lstore 32
      //   657: lload 26
      //   659: lstore 20
      //   661: lload 22
      //   663: lstore 28
      //   665: lload 32
      //   667: lstore 26
      //   669: lload 20
      //   671: lstore 22
      //   673: lload 28
      //   675: lstore 20
      //   677: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   680: ifeq +13 -> 693
      //   683: ldc 55
      //   685: iconst_2
      //   686: ldc 210
      //   688: aload 36
      //   690: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   693: aload_0
      //   694: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   697: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   700: ifnull +71 -> 771
      //   703: aload_0
      //   704: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   707: getfield 217	com/tencent/mobileqq/utils/QQRecorder:mAudioManager	Landroid/media/AudioManager;
      //   710: ifnull +25 -> 735
      //   713: aload_0
      //   714: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   717: invokestatic 219	com/tencent/mobileqq/utils/QQRecorder:d	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   720: iconst_m1
      //   721: if_icmpeq +14 -> 735
      //   724: aload_0
      //   725: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   728: getfield 217	com/tencent/mobileqq/utils/QQRecorder:mAudioManager	Landroid/media/AudioManager;
      //   731: iconst_0
      //   732: invokevirtual 224	android/media/AudioManager:setMode	(I)V
      //   735: aload 36
      //   737: instanceof 226
      //   740: ifne +11 -> 751
      //   743: aload 36
      //   745: instanceof 228
      //   748: ifeq +2391 -> 3139
      //   751: aload_0
      //   752: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   755: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   758: aload_1
      //   759: aload_0
      //   760: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   763: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   766: invokeinterface 231 3 0
      //   771: aload_0
      //   772: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   775: aload 36
      //   777: invokevirtual 234	com/tencent/mobileqq/utils/QQRecorder:m	(Ljava/lang/Throwable;)V
      //   780: aload_0
      //   781: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   784: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   787: ifnull +27 -> 814
      //   790: aload_0
      //   791: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   794: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   797: invokevirtual 237	android/media/AudioRecord:getState	()I
      //   800: iconst_1
      //   801: if_icmpne +13 -> 814
      //   804: aload_0
      //   805: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   808: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   811: invokevirtual 240	android/media/AudioRecord:stop	()V
      //   814: aload_0
      //   815: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   818: ifnull +15 -> 833
      //   821: aload_0
      //   822: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   825: invokevirtual 247	java/io/FileOutputStream:close	()V
      //   828: aload_0
      //   829: aconst_null
      //   830: putfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   833: aload_0
      //   834: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   837: invokestatic 249	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
      //   840: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   843: ifeq +86 -> 929
      //   846: ldc 55
      //   848: iconst_2
      //   849: new 57	java/lang/StringBuilder
      //   852: dup
      //   853: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   856: ldc 251
      //   858: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   861: aload_0
      //   862: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   865: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   868: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   871: ldc 55
      //   873: iconst_2
      //   874: new 57	java/lang/StringBuilder
      //   877: dup
      //   878: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   881: ldc 253
      //   883: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   886: lload 26
      //   888: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   891: ldc 255
      //   893: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   896: lload 24
      //   898: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   901: ldc_w 257
      //   904: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   907: lload 20
      //   909: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   912: ldc_w 259
      //   915: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   918: iload 10
      //   920: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   923: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   926: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   929: aload_0
      //   930: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   933: invokestatic 91	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
      //   936: iconst_0
      //   937: invokestatic 97	aqge:m	(Landroid/content/Context;Z)Z
      //   940: pop
      //   941: lload 20
      //   943: ldc2_w 260
      //   946: lcmp
      //   947: iflt +11 -> 958
      //   950: dload_2
      //   951: ldc2_w 262
      //   954: dcmpg
      //   955: ifge +3 -> 958
      //   958: new 265	java/util/HashMap
      //   961: dup
      //   962: invokespecial 266	java/util/HashMap:<init>	()V
      //   965: astore_1
      //   966: aload_1
      //   967: ldc_w 268
      //   970: new 57	java/lang/StringBuilder
      //   973: dup
      //   974: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   977: getstatic 273	android/os/Build$VERSION:SDK_INT	I
      //   980: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   983: ldc_w 275
      //   986: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   989: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   992: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   995: pop
      //   996: aload_1
      //   997: ldc_w 281
      //   1000: new 57	java/lang/StringBuilder
      //   1003: dup
      //   1004: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1007: getstatic 286	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   1010: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1013: ldc_w 288
      //   1016: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1019: getstatic 291	android/os/Build:MODEL	Ljava/lang/String;
      //   1022: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1025: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1028: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1031: pop
      //   1032: aload_1
      //   1033: ldc_w 293
      //   1036: new 57	java/lang/StringBuilder
      //   1039: dup
      //   1040: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1043: lload 24
      //   1045: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1048: ldc_w 275
      //   1051: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1054: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1057: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1060: pop
      //   1061: aload_1
      //   1062: ldc_w 295
      //   1065: new 57	java/lang/StringBuilder
      //   1068: dup
      //   1069: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1072: dload_2
      //   1073: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   1076: ldc_w 275
      //   1079: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1082: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1085: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1088: pop
      //   1089: aload_1
      //   1090: ldc_w 300
      //   1093: new 57	java/lang/StringBuilder
      //   1096: dup
      //   1097: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1100: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   1103: lload 34
      //   1105: lsub
      //   1106: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1109: ldc_w 275
      //   1112: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1115: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1118: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1121: pop
      //   1122: aload_1
      //   1123: ldc_w 302
      //   1126: new 57	java/lang/StringBuilder
      //   1129: dup
      //   1130: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1133: iload 12
      //   1135: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1138: ldc_w 275
      //   1141: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1144: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1147: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1150: pop
      //   1151: aload_1
      //   1152: ldc_w 304
      //   1155: new 57	java/lang/StringBuilder
      //   1158: dup
      //   1159: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1162: aload_0
      //   1163: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   1166: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1169: ldc_w 275
      //   1172: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1175: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1178: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1181: pop
      //   1182: lload 22
      //   1184: lconst_0
      //   1185: lcmp
      //   1186: ifne +2990 -> 4176
      //   1189: ldc2_w 305
      //   1192: lstore 26
      //   1194: goto +3450 -> 4644
      //   1197: lload 22
      //   1199: l2i
      //   1200: istore 10
      //   1202: aload_1
      //   1203: ldc_w 308
      //   1206: new 57	java/lang/StringBuilder
      //   1209: dup
      //   1210: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1213: iload 11
      //   1215: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1218: ldc_w 275
      //   1221: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1224: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1227: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1230: pop
      //   1231: aload_1
      //   1232: ldc_w 310
      //   1235: new 57	java/lang/StringBuilder
      //   1238: dup
      //   1239: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1242: iload 10
      //   1244: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1247: ldc_w 275
      //   1250: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1253: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1256: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1259: pop
      //   1260: ldc_w 312
      //   1263: iconst_1
      //   1264: aload_1
      //   1265: invokestatic 315	com/tencent/mobileqq/utils/QQRecorder:b	(Ljava/lang/String;ZLjava/util/HashMap;)V
      //   1268: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1271: ifeq +128 -> 1399
      //   1274: new 57	java/lang/StringBuilder
      //   1277: dup
      //   1278: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1281: astore_1
      //   1282: aload_1
      //   1283: ldc_w 317
      //   1286: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1289: iload 12
      //   1291: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1294: pop
      //   1295: aload_1
      //   1296: ldc_w 319
      //   1299: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1302: iload 11
      //   1304: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1307: pop
      //   1308: aload_1
      //   1309: ldc_w 321
      //   1312: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1315: iload 10
      //   1317: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1320: pop
      //   1321: aload_1
      //   1322: ldc_w 323
      //   1325: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1328: iload 10
      //   1330: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1333: pop
      //   1334: aload_1
      //   1335: ldc_w 325
      //   1338: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1341: lload 24
      //   1343: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1346: pop
      //   1347: aload_1
      //   1348: ldc_w 327
      //   1351: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1354: lload 20
      //   1356: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1359: pop
      //   1360: aload_1
      //   1361: ldc_w 329
      //   1364: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1367: dload_2
      //   1368: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   1371: pop
      //   1372: aload_1
      //   1373: ldc_w 331
      //   1376: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1379: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   1382: lload 34
      //   1384: lsub
      //   1385: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1388: pop
      //   1389: ldc 55
      //   1391: iconst_2
      //   1392: aload_1
      //   1393: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1396: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1399: return
      //   1400: iload 16
      //   1402: istore 14
      //   1404: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   1407: lload 32
      //   1409: lsub
      //   1410: ldc2_w 197
      //   1413: lcmp
      //   1414: ifle +99 -> 1513
      //   1417: iload 16
      //   1419: istore 14
      //   1421: iload 16
      //   1423: ifne +90 -> 1513
      //   1426: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1429: ifeq +32 -> 1461
      //   1432: ldc 55
      //   1434: iconst_2
      //   1435: new 57	java/lang/StringBuilder
      //   1438: dup
      //   1439: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   1442: ldc_w 333
      //   1445: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1448: aload_0
      //   1449: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   1452: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1455: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1458: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1461: aload_0
      //   1462: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   1465: ifle +102 -> 1567
      //   1468: aload_0
      //   1469: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   1472: sipush 500
      //   1475: if_icmpge +92 -> 1567
      //   1478: iconst_1
      //   1479: istore 11
      //   1481: iload 11
      //   1483: istore 14
      //   1485: aload_0
      //   1486: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1489: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   1492: ifnull +21 -> 1513
      //   1495: aload_0
      //   1496: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1499: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   1502: iload 11
      //   1504: invokeinterface 336 2 0
      //   1509: iload 11
      //   1511: istore 14
      //   1513: lload 20
      //   1515: lconst_1
      //   1516: ladd
      //   1517: lstore 20
      //   1519: aload_0
      //   1520: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1523: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   1526: aload 36
      //   1528: iconst_0
      //   1529: aload_0
      //   1530: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1533: invokestatic 117	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   1536: invokevirtual 176	android/media/AudioRecord:read	([BII)I
      //   1539: istore 15
      //   1541: iload 15
      //   1543: ifgt +30 -> 1573
      //   1546: ldc2_w 337
      //   1549: invokestatic 161	java/lang/Thread:sleep	(J)V
      //   1552: iload 13
      //   1554: istore 11
      //   1556: iload 15
      //   1558: istore 10
      //   1560: iload 14
      //   1562: istore 16
      //   1564: goto -1020 -> 544
      //   1567: iconst_2
      //   1568: istore 11
      //   1570: goto -89 -> 1481
      //   1573: aload_0
      //   1574: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   1577: ifnull +15 -> 1592
      //   1580: aload_0
      //   1581: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   1584: aload 36
      //   1586: iconst_0
      //   1587: iload 15
      //   1589: invokevirtual 342	java/io/FileOutputStream:write	([BII)V
      //   1592: lconst_1
      //   1593: lload 26
      //   1595: ladd
      //   1596: lstore 26
      //   1598: lload 24
      //   1600: iload 15
      //   1602: i2l
      //   1603: ladd
      //   1604: lstore 28
      //   1606: aload_0
      //   1607: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1610: invokestatic 91	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
      //   1613: aload 36
      //   1615: iload 15
      //   1617: fconst_1
      //   1618: invokestatic 347	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
      //   1621: l2i
      //   1622: istore 16
      //   1624: iload 12
      //   1626: iload 16
      //   1628: invokestatic 353	java/lang/Math:max	(II)I
      //   1631: istore 11
      //   1633: lload 30
      //   1635: iload 16
      //   1637: i2l
      //   1638: ladd
      //   1639: lstore 24
      //   1641: dload_2
      //   1642: dstore 4
      //   1644: dload_2
      //   1645: dstore 6
      //   1647: aload_0
      //   1648: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1651: invokestatic 150	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Laliy;
      //   1654: aload 36
      //   1656: iconst_0
      //   1657: iload 15
      //   1659: invokevirtual 356	aliy:a	([BII)Laliv$a;
      //   1662: astore 37
      //   1664: dload_2
      //   1665: dstore 4
      //   1667: dload_2
      //   1668: dstore 6
      //   1670: invokestatic 359	aomq:dVW	()V
      //   1673: dload_2
      //   1674: dstore 4
      //   1676: dload_2
      //   1677: dstore 6
      //   1679: iload 15
      //   1681: i2l
      //   1682: aload_0
      //   1683: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1686: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1689: getfield 164	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:mSampleRate	I
      //   1692: invokestatic 362	com/tencent/mobileqq/utils/QQRecorder:b	(JI)D
      //   1695: dstore 8
      //   1697: dload_2
      //   1698: dload 8
      //   1700: dadd
      //   1701: dstore_2
      //   1702: dload 8
      //   1704: iload 19
      //   1706: i2d
      //   1707: dadd
      //   1708: d2i
      //   1709: istore 15
      //   1711: dload_2
      //   1712: dstore 4
      //   1714: dload_2
      //   1715: dstore 6
      //   1717: aload_0
      //   1718: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1721: invokestatic 364	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   1724: iload 17
      //   1726: invokestatic 353	java/lang/Math:max	(II)I
      //   1729: istore 17
      //   1731: iload 15
      //   1733: bipush 100
      //   1735: if_icmplt +2906 -> 4641
      //   1738: dload_2
      //   1739: dstore 4
      //   1741: dload_2
      //   1742: dstore 6
      //   1744: aload_0
      //   1745: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1748: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1751: getfield 192	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:oY	[I
      //   1754: ifnull +2910 -> 4664
      //   1757: dload_2
      //   1758: dstore 4
      //   1760: dload_2
      //   1761: dstore 6
      //   1763: aload_0
      //   1764: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1767: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1770: getfield 192	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:oY	[I
      //   1773: aload_0
      //   1774: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1777: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1780: getfield 105	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:dZO	I
      //   1783: iload 17
      //   1785: iastore
      //   1786: dload_2
      //   1787: dstore 4
      //   1789: dload_2
      //   1790: dstore 6
      //   1792: aload_0
      //   1793: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1796: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1799: getfield 105	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:dZO	I
      //   1802: aload_0
      //   1803: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1806: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1809: getfield 192	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:oY	[I
      //   1812: arraylength
      //   1813: iconst_1
      //   1814: isub
      //   1815: if_icmpge +2849 -> 4664
      //   1818: dload_2
      //   1819: dstore 4
      //   1821: dload_2
      //   1822: dstore 6
      //   1824: aload_0
      //   1825: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1828: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1831: astore 38
      //   1833: dload_2
      //   1834: dstore 4
      //   1836: dload_2
      //   1837: dstore 6
      //   1839: aload 38
      //   1841: aload 38
      //   1843: getfield 105	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:dZO	I
      //   1846: iconst_1
      //   1847: iadd
      //   1848: putfield 105	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:dZO	I
      //   1851: goto +2813 -> 4664
      //   1854: dload_2
      //   1855: dstore 4
      //   1857: dload_2
      //   1858: dstore 6
      //   1860: aload_0
      //   1861: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1864: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   1867: ifnull +52 -> 1919
      //   1870: aload 37
      //   1872: ifnull +47 -> 1919
      //   1875: dload_2
      //   1876: dstore 4
      //   1878: dload_2
      //   1879: dstore 6
      //   1881: aload_0
      //   1882: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1885: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   1888: aload_1
      //   1889: aload 37
      //   1891: getfield 370	aliv$a:data	[B
      //   1894: aload 37
      //   1896: getfield 373	aliv$a:size	I
      //   1899: aload_0
      //   1900: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1903: invokestatic 364	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   1906: dload_2
      //   1907: aload_0
      //   1908: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1911: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   1914: invokeinterface 376 8 0
      //   1919: aload 37
      //   1921: ifnull +2717 -> 4638
      //   1924: dload_2
      //   1925: dstore 4
      //   1927: dload_2
      //   1928: dstore 6
      //   1930: aload 37
      //   1932: getfield 373	aliv$a:size	I
      //   1935: istore 12
      //   1937: iload 12
      //   1939: i2l
      //   1940: lload 22
      //   1942: ladd
      //   1943: lstore 22
      //   1945: iload 14
      //   1947: istore 16
      //   1949: iload 14
      //   1951: iconst_1
      //   1952: if_icmpne +86 -> 2038
      //   1955: iload 14
      //   1957: istore 16
      //   1959: aload_0
      //   1960: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   1963: sipush 500
      //   1966: if_icmple +72 -> 2038
      //   1969: iconst_2
      //   1970: istore 12
      //   1972: aload_0
      //   1973: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1976: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   1979: ifnull +16 -> 1995
      //   1982: aload_0
      //   1983: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   1986: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   1989: iconst_2
      //   1990: invokeinterface 336 2 0
      //   1995: iload 12
      //   1997: istore 16
      //   1999: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2002: ifeq +36 -> 2038
      //   2005: ldc 55
      //   2007: iconst_2
      //   2008: new 57	java/lang/StringBuilder
      //   2011: dup
      //   2012: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2015: ldc_w 378
      //   2018: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2021: aload_0
      //   2022: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   2025: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2028: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2031: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2034: iload 12
      //   2036: istore 16
      //   2038: iload 18
      //   2040: iconst_m1
      //   2041: if_icmpeq +16 -> 2057
      //   2044: dload_2
      //   2045: iload 18
      //   2047: i2d
      //   2048: dcmpl
      //   2049: iflt +8 -> 2057
      //   2052: aload_0
      //   2053: iconst_1
      //   2054: putfield 196	com/tencent/mobileqq/utils/QQRecorder$RecordThread:cUw	Z
      //   2057: lload 24
      //   2059: lstore 30
      //   2061: lload 28
      //   2063: lstore 24
      //   2065: iload 11
      //   2067: istore 12
      //   2069: iload 13
      //   2071: istore 11
      //   2073: iload 15
      //   2075: istore 19
      //   2077: goto -1533 -> 544
      //   2080: aload_0
      //   2081: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   2084: ifnull +10 -> 2094
      //   2087: aload_0
      //   2088: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   2091: invokevirtual 381	java/io/FileOutputStream:flush	()V
      //   2094: aload_0
      //   2095: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2098: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   2101: ifnull +56 -> 2157
      //   2104: aload_0
      //   2105: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2108: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   2111: aload_1
      //   2112: aload_0
      //   2113: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2116: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   2119: dload_2
      //   2120: invokeinterface 384 5 0
      //   2125: aload_0
      //   2126: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2129: getfield 217	com/tencent/mobileqq/utils/QQRecorder:mAudioManager	Landroid/media/AudioManager;
      //   2132: ifnull +25 -> 2157
      //   2135: aload_0
      //   2136: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2139: invokestatic 219	com/tencent/mobileqq/utils/QQRecorder:d	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
      //   2142: iconst_m1
      //   2143: if_icmpeq +14 -> 2157
      //   2146: aload_0
      //   2147: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2150: getfield 217	com/tencent/mobileqq/utils/QQRecorder:mAudioManager	Landroid/media/AudioManager;
      //   2153: iconst_0
      //   2154: invokevirtual 224	android/media/AudioManager:setMode	(I)V
      //   2157: aload_0
      //   2158: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2161: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   2164: ifnull +27 -> 2191
      //   2167: aload_0
      //   2168: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2171: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   2174: invokevirtual 237	android/media/AudioRecord:getState	()I
      //   2177: iconst_1
      //   2178: if_icmpne +13 -> 2191
      //   2181: aload_0
      //   2182: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2185: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   2188: invokevirtual 240	android/media/AudioRecord:stop	()V
      //   2191: aload_0
      //   2192: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   2195: ifnull +15 -> 2210
      //   2198: aload_0
      //   2199: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   2202: invokevirtual 247	java/io/FileOutputStream:close	()V
      //   2205: aload_0
      //   2206: aconst_null
      //   2207: putfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   2210: aload_0
      //   2211: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2214: invokestatic 249	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
      //   2217: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2220: ifeq +86 -> 2306
      //   2223: ldc 55
      //   2225: iconst_2
      //   2226: new 57	java/lang/StringBuilder
      //   2229: dup
      //   2230: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2233: ldc 251
      //   2235: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2238: aload_0
      //   2239: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   2242: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2245: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2248: ldc 55
      //   2250: iconst_2
      //   2251: new 57	java/lang/StringBuilder
      //   2254: dup
      //   2255: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2258: ldc 253
      //   2260: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2263: lload 20
      //   2265: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2268: ldc 255
      //   2270: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2273: lload 24
      //   2275: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2278: ldc_w 257
      //   2281: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2284: lload 22
      //   2286: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2289: ldc_w 259
      //   2292: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2295: iload 10
      //   2297: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2300: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2303: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2306: aload_0
      //   2307: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   2310: invokestatic 91	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
      //   2313: iconst_0
      //   2314: invokestatic 97	aqge:m	(Landroid/content/Context;Z)Z
      //   2317: pop
      //   2318: lload 22
      //   2320: ldc2_w 260
      //   2323: lcmp
      //   2324: iflt +11 -> 2335
      //   2327: dload_2
      //   2328: ldc2_w 262
      //   2331: dcmpg
      //   2332: ifge +297 -> 2629
      //   2335: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   2338: lload 34
      //   2340: lsub
      //   2341: ldc2_w 197
      //   2344: lcmp
      //   2345: ifle +284 -> 2629
      //   2348: new 265	java/util/HashMap
      //   2351: dup
      //   2352: invokespecial 266	java/util/HashMap:<init>	()V
      //   2355: astore_1
      //   2356: aload_1
      //   2357: ldc_w 386
      //   2360: ldc_w 388
      //   2363: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2366: pop
      //   2367: aload_1
      //   2368: ldc_w 268
      //   2371: new 57	java/lang/StringBuilder
      //   2374: dup
      //   2375: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2378: getstatic 273	android/os/Build$VERSION:SDK_INT	I
      //   2381: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2384: ldc_w 275
      //   2387: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2390: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2393: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2396: pop
      //   2397: aload_1
      //   2398: ldc_w 281
      //   2401: new 57	java/lang/StringBuilder
      //   2404: dup
      //   2405: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2408: getstatic 286	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   2411: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2414: ldc_w 288
      //   2417: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2420: getstatic 291	android/os/Build:MODEL	Ljava/lang/String;
      //   2423: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2426: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2429: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2432: pop
      //   2433: aload_1
      //   2434: ldc_w 293
      //   2437: new 57	java/lang/StringBuilder
      //   2440: dup
      //   2441: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2444: lload 24
      //   2446: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2449: ldc_w 275
      //   2452: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2455: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2458: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2461: pop
      //   2462: aload_1
      //   2463: ldc_w 302
      //   2466: new 57	java/lang/StringBuilder
      //   2469: dup
      //   2470: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2473: iload 12
      //   2475: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2478: ldc_w 275
      //   2481: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2484: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2487: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2490: pop
      //   2491: aload_1
      //   2492: ldc_w 390
      //   2495: new 57	java/lang/StringBuilder
      //   2498: dup
      //   2499: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2502: dload_2
      //   2503: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   2506: ldc_w 275
      //   2509: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2512: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2515: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2518: pop
      //   2519: aload_1
      //   2520: ldc_w 300
      //   2523: new 57	java/lang/StringBuilder
      //   2526: dup
      //   2527: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2530: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   2533: lload 34
      //   2535: lsub
      //   2536: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2539: ldc_w 275
      //   2542: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2545: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2548: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2551: pop
      //   2552: ldc_w 392
      //   2555: iconst_0
      //   2556: aload_1
      //   2557: invokestatic 315	com/tencent/mobileqq/utils/QQRecorder:b	(Ljava/lang/String;ZLjava/util/HashMap;)V
      //   2560: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2563: ifeq +66 -> 2629
      //   2566: ldc 55
      //   2568: iconst_2
      //   2569: new 57	java/lang/StringBuilder
      //   2572: dup
      //   2573: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2576: ldc_w 394
      //   2579: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2582: lload 24
      //   2584: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2587: ldc_w 396
      //   2590: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2593: lload 22
      //   2595: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2598: ldc_w 398
      //   2601: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2604: dload_2
      //   2605: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   2608: ldc_w 400
      //   2611: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2614: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   2617: lload 34
      //   2619: lsub
      //   2620: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2623: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2626: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2629: new 265	java/util/HashMap
      //   2632: dup
      //   2633: invokespecial 266	java/util/HashMap:<init>	()V
      //   2636: astore_1
      //   2637: aload_1
      //   2638: ldc_w 268
      //   2641: new 57	java/lang/StringBuilder
      //   2644: dup
      //   2645: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2648: getstatic 273	android/os/Build$VERSION:SDK_INT	I
      //   2651: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2654: ldc_w 275
      //   2657: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2660: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2663: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2666: pop
      //   2667: aload_1
      //   2668: ldc_w 281
      //   2671: new 57	java/lang/StringBuilder
      //   2674: dup
      //   2675: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2678: getstatic 286	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   2681: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2684: ldc_w 288
      //   2687: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2690: getstatic 291	android/os/Build:MODEL	Ljava/lang/String;
      //   2693: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2696: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2699: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2702: pop
      //   2703: aload_1
      //   2704: ldc_w 293
      //   2707: new 57	java/lang/StringBuilder
      //   2710: dup
      //   2711: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2714: lload 24
      //   2716: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2719: ldc_w 275
      //   2722: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2725: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2728: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2731: pop
      //   2732: aload_1
      //   2733: ldc_w 295
      //   2736: new 57	java/lang/StringBuilder
      //   2739: dup
      //   2740: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2743: dload_2
      //   2744: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   2747: ldc_w 275
      //   2750: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2753: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2756: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2759: pop
      //   2760: aload_1
      //   2761: ldc_w 300
      //   2764: new 57	java/lang/StringBuilder
      //   2767: dup
      //   2768: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2771: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   2774: lload 34
      //   2776: lsub
      //   2777: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2780: ldc_w 275
      //   2783: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2786: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2789: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2792: pop
      //   2793: aload_1
      //   2794: ldc_w 302
      //   2797: new 57	java/lang/StringBuilder
      //   2800: dup
      //   2801: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2804: iload 12
      //   2806: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2809: ldc_w 275
      //   2812: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2815: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2818: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2821: pop
      //   2822: aload_1
      //   2823: ldc_w 304
      //   2826: new 57	java/lang/StringBuilder
      //   2829: dup
      //   2830: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2833: aload_0
      //   2834: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   2837: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2840: ldc_w 275
      //   2843: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2846: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2849: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2852: pop
      //   2853: lload 26
      //   2855: lconst_0
      //   2856: lcmp
      //   2857: ifne +260 -> 3117
      //   2860: ldc2_w 305
      //   2863: lstore 20
      //   2865: goto +1808 -> 4673
      //   2868: lload 20
      //   2870: l2i
      //   2871: istore 10
      //   2873: aload_1
      //   2874: ldc_w 308
      //   2877: new 57	java/lang/StringBuilder
      //   2880: dup
      //   2881: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2884: iload 11
      //   2886: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2889: ldc_w 275
      //   2892: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2895: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2898: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2901: pop
      //   2902: aload_1
      //   2903: ldc_w 310
      //   2906: new 57	java/lang/StringBuilder
      //   2909: dup
      //   2910: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2913: iload 10
      //   2915: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2918: ldc_w 275
      //   2921: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2924: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2927: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2930: pop
      //   2931: ldc_w 312
      //   2934: iconst_1
      //   2935: aload_1
      //   2936: invokestatic 315	com/tencent/mobileqq/utils/QQRecorder:b	(Ljava/lang/String;ZLjava/util/HashMap;)V
      //   2939: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2942: ifeq -1543 -> 1399
      //   2945: new 57	java/lang/StringBuilder
      //   2948: dup
      //   2949: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   2952: astore_1
      //   2953: aload_1
      //   2954: ldc_w 317
      //   2957: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2960: iload 12
      //   2962: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2965: pop
      //   2966: aload_1
      //   2967: ldc_w 319
      //   2970: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2973: iload 11
      //   2975: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2978: pop
      //   2979: aload_1
      //   2980: ldc_w 321
      //   2983: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2986: iload 10
      //   2988: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2991: pop
      //   2992: aload_1
      //   2993: ldc_w 323
      //   2996: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2999: iload 10
      //   3001: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3004: pop
      //   3005: aload_1
      //   3006: ldc_w 325
      //   3009: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3012: lload 24
      //   3014: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3017: pop
      //   3018: aload_1
      //   3019: ldc_w 327
      //   3022: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3025: lload 22
      //   3027: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3030: pop
      //   3031: aload_1
      //   3032: ldc_w 329
      //   3035: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3038: dload_2
      //   3039: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   3042: pop
      //   3043: aload_1
      //   3044: ldc_w 331
      //   3047: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3050: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   3053: lload 34
      //   3055: lsub
      //   3056: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3059: pop
      //   3060: ldc 55
      //   3062: iconst_2
      //   3063: aload_1
      //   3064: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3067: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   3070: return
      //   3071: astore_1
      //   3072: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3075: ifeq -1676 -> 1399
      //   3078: ldc 55
      //   3080: iconst_2
      //   3081: ldc_w 402
      //   3084: aload_1
      //   3085: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   3088: return
      //   3089: astore_1
      //   3090: aload_1
      //   3091: invokevirtual 405	java/lang/Throwable:printStackTrace	()V
      //   3094: goto -877 -> 2217
      //   3097: astore_1
      //   3098: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3101: ifeq -472 -> 2629
      //   3104: ldc 55
      //   3106: iconst_2
      //   3107: ldc_w 407
      //   3110: aload_1
      //   3111: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   3114: goto -485 -> 2629
      //   3117: lload 30
      //   3119: lload 26
      //   3121: ldiv
      //   3122: lstore 20
      //   3124: goto +1549 -> 4673
      //   3127: aload_0
      //   3128: getfield 40	com/tencent/mobileqq/utils/QQRecorder$RecordThread:ata	J
      //   3131: lload 26
      //   3133: ldiv
      //   3134: lstore 20
      //   3136: goto -268 -> 2868
      //   3139: aload 36
      //   3141: instanceof 204
      //   3144: ifeq +996 -> 4140
      //   3147: aload_0
      //   3148: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3151: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   3154: aload_1
      //   3155: aload_0
      //   3156: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3159: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   3162: invokeinterface 409 3 0
      //   3167: goto -2396 -> 771
      //   3170: astore_1
      //   3171: iconst_1
      //   3172: istore 11
      //   3174: lload 24
      //   3176: lstore 28
      //   3178: lload 26
      //   3180: lstore 24
      //   3182: lload 20
      //   3184: lstore 26
      //   3186: lload 22
      //   3188: lstore 20
      //   3190: aload_0
      //   3191: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3194: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   3197: ifnull +27 -> 3224
      //   3200: aload_0
      //   3201: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3204: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   3207: invokevirtual 237	android/media/AudioRecord:getState	()I
      //   3210: iconst_1
      //   3211: if_icmpne +13 -> 3224
      //   3214: aload_0
      //   3215: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3218: invokestatic 170	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
      //   3221: invokevirtual 240	android/media/AudioRecord:stop	()V
      //   3224: aload_0
      //   3225: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   3228: ifnull +15 -> 3243
      //   3231: aload_0
      //   3232: getfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   3235: invokevirtual 247	java/io/FileOutputStream:close	()V
      //   3238: aload_0
      //   3239: aconst_null
      //   3240: putfield 242	com/tencent/mobileqq/utils/QQRecorder$RecordThread:n	Ljava/io/FileOutputStream;
      //   3243: aload_0
      //   3244: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3247: invokestatic 249	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
      //   3250: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3253: ifeq +86 -> 3339
      //   3256: ldc 55
      //   3258: iconst_2
      //   3259: new 57	java/lang/StringBuilder
      //   3262: dup
      //   3263: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3266: ldc 251
      //   3268: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3271: aload_0
      //   3272: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   3275: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3278: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   3281: ldc 55
      //   3283: iconst_2
      //   3284: new 57	java/lang/StringBuilder
      //   3287: dup
      //   3288: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3291: ldc 253
      //   3293: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3296: lload 24
      //   3298: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3301: ldc 255
      //   3303: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3306: lload 28
      //   3308: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3311: ldc_w 257
      //   3314: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3317: lload 26
      //   3319: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3322: ldc_w 259
      //   3325: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3328: iload 10
      //   3330: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3333: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3336: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   3339: aload_0
      //   3340: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   3343: invokestatic 91	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
      //   3346: iconst_0
      //   3347: invokestatic 97	aqge:m	(Landroid/content/Context;Z)Z
      //   3350: pop
      //   3351: lload 26
      //   3353: ldc2_w 260
      //   3356: lcmp
      //   3357: iflt +11 -> 3368
      //   3360: dload_2
      //   3361: ldc2_w 262
      //   3364: dcmpg
      //   3365: ifge +311 -> 3676
      //   3368: iload 11
      //   3370: ifne +306 -> 3676
      //   3373: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   3376: lload 34
      //   3378: lsub
      //   3379: ldc2_w 197
      //   3382: lcmp
      //   3383: ifle +293 -> 3676
      //   3386: new 265	java/util/HashMap
      //   3389: dup
      //   3390: invokespecial 266	java/util/HashMap:<init>	()V
      //   3393: astore 36
      //   3395: aload 36
      //   3397: ldc_w 386
      //   3400: ldc_w 388
      //   3403: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3406: pop
      //   3407: aload 36
      //   3409: ldc_w 268
      //   3412: new 57	java/lang/StringBuilder
      //   3415: dup
      //   3416: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3419: getstatic 273	android/os/Build$VERSION:SDK_INT	I
      //   3422: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3425: ldc_w 275
      //   3428: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3431: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3434: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3437: pop
      //   3438: aload 36
      //   3440: ldc_w 281
      //   3443: new 57	java/lang/StringBuilder
      //   3446: dup
      //   3447: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3450: getstatic 286	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   3453: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3456: ldc_w 288
      //   3459: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3462: getstatic 291	android/os/Build:MODEL	Ljava/lang/String;
      //   3465: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3468: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3471: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3474: pop
      //   3475: aload 36
      //   3477: ldc_w 293
      //   3480: new 57	java/lang/StringBuilder
      //   3483: dup
      //   3484: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3487: lload 28
      //   3489: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3492: ldc_w 275
      //   3495: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3498: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3501: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3504: pop
      //   3505: aload 36
      //   3507: ldc_w 302
      //   3510: new 57	java/lang/StringBuilder
      //   3513: dup
      //   3514: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3517: iload 12
      //   3519: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3522: ldc_w 275
      //   3525: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3528: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3531: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3534: pop
      //   3535: aload 36
      //   3537: ldc_w 390
      //   3540: new 57	java/lang/StringBuilder
      //   3543: dup
      //   3544: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3547: dload_2
      //   3548: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   3551: ldc_w 275
      //   3554: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3557: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3560: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3563: pop
      //   3564: aload 36
      //   3566: ldc_w 300
      //   3569: new 57	java/lang/StringBuilder
      //   3572: dup
      //   3573: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3576: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   3579: lload 34
      //   3581: lsub
      //   3582: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3585: ldc_w 275
      //   3588: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3591: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3594: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3597: pop
      //   3598: ldc_w 392
      //   3601: iconst_0
      //   3602: aload 36
      //   3604: invokestatic 315	com/tencent/mobileqq/utils/QQRecorder:b	(Ljava/lang/String;ZLjava/util/HashMap;)V
      //   3607: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3610: ifeq +66 -> 3676
      //   3613: ldc 55
      //   3615: iconst_2
      //   3616: new 57	java/lang/StringBuilder
      //   3619: dup
      //   3620: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3623: ldc_w 394
      //   3626: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3629: lload 28
      //   3631: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3634: ldc_w 396
      //   3637: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3640: lload 26
      //   3642: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3645: ldc_w 398
      //   3648: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3651: dload_2
      //   3652: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   3655: ldc_w 400
      //   3658: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3661: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   3664: lload 34
      //   3666: lsub
      //   3667: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3670: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3673: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   3676: new 265	java/util/HashMap
      //   3679: dup
      //   3680: invokespecial 266	java/util/HashMap:<init>	()V
      //   3683: astore 36
      //   3685: aload 36
      //   3687: ldc_w 268
      //   3690: new 57	java/lang/StringBuilder
      //   3693: dup
      //   3694: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3697: getstatic 273	android/os/Build$VERSION:SDK_INT	I
      //   3700: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3703: ldc_w 275
      //   3706: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3709: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3712: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3715: pop
      //   3716: aload 36
      //   3718: ldc_w 281
      //   3721: new 57	java/lang/StringBuilder
      //   3724: dup
      //   3725: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3728: getstatic 286	android/os/Build:MANUFACTURER	Ljava/lang/String;
      //   3731: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3734: ldc_w 288
      //   3737: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3740: getstatic 291	android/os/Build:MODEL	Ljava/lang/String;
      //   3743: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3746: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3749: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3752: pop
      //   3753: aload 36
      //   3755: ldc_w 293
      //   3758: new 57	java/lang/StringBuilder
      //   3761: dup
      //   3762: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3765: lload 28
      //   3767: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3770: ldc_w 275
      //   3773: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3776: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3779: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3782: pop
      //   3783: aload 36
      //   3785: ldc_w 295
      //   3788: new 57	java/lang/StringBuilder
      //   3791: dup
      //   3792: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3795: dload_2
      //   3796: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   3799: ldc_w 275
      //   3802: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3805: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3808: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3811: pop
      //   3812: aload 36
      //   3814: ldc_w 300
      //   3817: new 57	java/lang/StringBuilder
      //   3820: dup
      //   3821: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3824: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   3827: lload 34
      //   3829: lsub
      //   3830: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3833: ldc_w 275
      //   3836: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3839: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3842: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3845: pop
      //   3846: aload 36
      //   3848: ldc_w 302
      //   3851: new 57	java/lang/StringBuilder
      //   3854: dup
      //   3855: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3858: iload 12
      //   3860: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3863: ldc_w 275
      //   3866: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3869: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3872: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3875: pop
      //   3876: aload 36
      //   3878: ldc_w 304
      //   3881: new 57	java/lang/StringBuilder
      //   3884: dup
      //   3885: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3888: aload_0
      //   3889: getfield 38	com/tencent/mobileqq/utils/QQRecorder$RecordThread:dZL	I
      //   3892: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3895: ldc_w 275
      //   3898: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3901: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3904: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3907: pop
      //   3908: lload 20
      //   3910: lconst_0
      //   3911: lcmp
      //   3912: ifne +336 -> 4248
      //   3915: ldc2_w 305
      //   3918: lstore 22
      //   3920: goto +773 -> 4693
      //   3923: lload 20
      //   3925: l2i
      //   3926: istore 10
      //   3928: aload 36
      //   3930: ldc_w 308
      //   3933: new 57	java/lang/StringBuilder
      //   3936: dup
      //   3937: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3940: iload 11
      //   3942: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3945: ldc_w 275
      //   3948: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3951: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3954: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3957: pop
      //   3958: aload 36
      //   3960: ldc_w 310
      //   3963: new 57	java/lang/StringBuilder
      //   3966: dup
      //   3967: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   3970: iload 10
      //   3972: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3975: ldc_w 275
      //   3978: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3981: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3984: invokevirtual 279	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   3987: pop
      //   3988: ldc_w 312
      //   3991: iconst_1
      //   3992: aload 36
      //   3994: invokestatic 315	com/tencent/mobileqq/utils/QQRecorder:b	(Ljava/lang/String;ZLjava/util/HashMap;)V
      //   3997: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   4000: ifeq +138 -> 4138
      //   4003: new 57	java/lang/StringBuilder
      //   4006: dup
      //   4007: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   4010: astore 36
      //   4012: aload 36
      //   4014: ldc_w 317
      //   4017: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4020: iload 12
      //   4022: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   4025: pop
      //   4026: aload 36
      //   4028: ldc_w 319
      //   4031: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4034: iload 11
      //   4036: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   4039: pop
      //   4040: aload 36
      //   4042: ldc_w 321
      //   4045: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4048: iload 10
      //   4050: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   4053: pop
      //   4054: aload 36
      //   4056: ldc_w 323
      //   4059: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4062: iload 10
      //   4064: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   4067: pop
      //   4068: aload 36
      //   4070: ldc_w 325
      //   4073: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4076: lload 28
      //   4078: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   4081: pop
      //   4082: aload 36
      //   4084: ldc_w 327
      //   4087: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4090: lload 26
      //   4092: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   4095: pop
      //   4096: aload 36
      //   4098: ldc_w 329
      //   4101: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4104: dload_2
      //   4105: invokevirtual 298	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   4108: pop
      //   4109: aload 36
      //   4111: ldc_w 331
      //   4114: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4117: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   4120: lload 34
      //   4122: lsub
      //   4123: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   4126: pop
      //   4127: ldc 55
      //   4129: iconst_2
      //   4130: aload 36
      //   4132: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   4135: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   4138: aload_1
      //   4139: athrow
      //   4140: aload_0
      //   4141: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   4144: invokestatic 108	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$a;
      //   4147: aload_1
      //   4148: aload_0
      //   4149: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   4152: getfield 100	com/tencent/mobileqq/utils/QQRecorder:a	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
      //   4155: aload 36
      //   4157: invokevirtual 412	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   4160: invokeinterface 415 4 0
      //   4165: goto -3394 -> 771
      //   4168: astore_1
      //   4169: aload_1
      //   4170: invokevirtual 405	java/lang/Throwable:printStackTrace	()V
      //   4173: goto -3333 -> 840
      //   4176: lload 30
      //   4178: lload 22
      //   4180: ldiv
      //   4181: lstore 26
      //   4183: goto +461 -> 4644
      //   4186: aload_0
      //   4187: getfield 40	com/tencent/mobileqq/utils/QQRecorder$RecordThread:ata	J
      //   4190: lload 22
      //   4192: ldiv
      //   4193: lstore 22
      //   4195: goto -2998 -> 1197
      //   4198: astore_1
      //   4199: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   4202: ifeq -2803 -> 1399
      //   4205: ldc 55
      //   4207: iconst_2
      //   4208: ldc_w 402
      //   4211: aload_1
      //   4212: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   4215: return
      //   4216: astore 36
      //   4218: aload 36
      //   4220: invokevirtual 405	java/lang/Throwable:printStackTrace	()V
      //   4223: goto -973 -> 3250
      //   4226: astore 36
      //   4228: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   4231: ifeq -555 -> 3676
      //   4234: ldc 55
      //   4236: iconst_2
      //   4237: ldc_w 407
      //   4240: aload 36
      //   4242: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   4245: goto -569 -> 3676
      //   4248: lload 30
      //   4250: lload 20
      //   4252: ldiv
      //   4253: lstore 22
      //   4255: goto +438 -> 4693
      //   4258: aload_0
      //   4259: getfield 40	com/tencent/mobileqq/utils/QQRecorder$RecordThread:ata	J
      //   4262: lload 20
      //   4264: ldiv
      //   4265: lstore 20
      //   4267: goto -344 -> 3923
      //   4270: astore 36
      //   4272: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   4275: ifeq -137 -> 4138
      //   4278: ldc 55
      //   4280: iconst_2
      //   4281: ldc_w 402
      //   4284: aload 36
      //   4286: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   4289: goto -151 -> 4138
      //   4292: astore_1
      //   4293: iconst_0
      //   4294: istore 10
      //   4296: lconst_0
      //   4297: lstore 32
      //   4299: lconst_0
      //   4300: lstore 26
      //   4302: iconst_0
      //   4303: istore 11
      //   4305: iload 13
      //   4307: istore 12
      //   4309: lload 22
      //   4311: lstore 20
      //   4313: lload 28
      //   4315: lstore 24
      //   4317: lload 32
      //   4319: lstore 28
      //   4321: goto -1131 -> 3190
      //   4324: astore_1
      //   4325: lload 24
      //   4327: lstore 28
      //   4329: lload 20
      //   4331: lstore 24
      //   4333: lload 26
      //   4335: lstore 20
      //   4337: iconst_0
      //   4338: istore 11
      //   4340: lload 22
      //   4342: lstore 26
      //   4344: goto -1154 -> 3190
      //   4347: astore_1
      //   4348: lload 24
      //   4350: lstore 28
      //   4352: lload 20
      //   4354: lstore 24
      //   4356: lload 26
      //   4358: lstore 20
      //   4360: iconst_0
      //   4361: istore 11
      //   4363: lload 22
      //   4365: lstore 26
      //   4367: goto -1177 -> 3190
      //   4370: astore_1
      //   4371: iload 15
      //   4373: istore 10
      //   4375: lload 24
      //   4377: lstore 28
      //   4379: lload 20
      //   4381: lstore 24
      //   4383: lload 26
      //   4385: lstore 20
      //   4387: iconst_0
      //   4388: istore 11
      //   4390: lload 22
      //   4392: lstore 26
      //   4394: goto -1204 -> 3190
      //   4397: astore_1
      //   4398: iconst_0
      //   4399: istore 11
      //   4401: lload 20
      //   4403: lstore 24
      //   4405: lload 26
      //   4407: lstore 20
      //   4409: lload 22
      //   4411: lstore 26
      //   4413: goto -1223 -> 3190
      //   4416: astore_1
      //   4417: lload 24
      //   4419: lstore 30
      //   4421: iconst_0
      //   4422: istore 13
      //   4424: dload 4
      //   4426: dstore_2
      //   4427: lload 20
      //   4429: lstore 24
      //   4431: iload 11
      //   4433: istore 12
      //   4435: iload 13
      //   4437: istore 11
      //   4439: lload 26
      //   4441: lstore 20
      //   4443: lload 22
      //   4445: lstore 26
      //   4447: goto -1257 -> 3190
      //   4450: astore_1
      //   4451: iconst_0
      //   4452: istore 13
      //   4454: lload 24
      //   4456: lstore 30
      //   4458: lload 20
      //   4460: lstore 24
      //   4462: iload 11
      //   4464: istore 12
      //   4466: iload 13
      //   4468: istore 11
      //   4470: lload 26
      //   4472: lstore 20
      //   4474: lload 22
      //   4476: lstore 26
      //   4478: goto -1288 -> 3190
      //   4481: astore 36
      //   4483: iload 15
      //   4485: istore 12
      //   4487: iload 14
      //   4489: istore 10
      //   4491: lload 28
      //   4493: lstore 26
      //   4495: goto -3818 -> 677
      //   4498: astore 36
      //   4500: lload 20
      //   4502: lstore 28
      //   4504: lload 22
      //   4506: lstore 20
      //   4508: lload 26
      //   4510: lstore 22
      //   4512: lload 28
      //   4514: lstore 26
      //   4516: goto -3839 -> 677
      //   4519: astore 36
      //   4521: lload 20
      //   4523: lstore 28
      //   4525: lload 22
      //   4527: lstore 20
      //   4529: iload 15
      //   4531: istore 10
      //   4533: lload 26
      //   4535: lstore 22
      //   4537: lload 28
      //   4539: lstore 26
      //   4541: goto -3864 -> 677
      //   4544: astore 36
      //   4546: lload 28
      //   4548: lstore 24
      //   4550: lload 20
      //   4552: lstore 28
      //   4554: lload 22
      //   4556: lstore 20
      //   4558: lload 26
      //   4560: lstore 22
      //   4562: lload 28
      //   4564: lstore 26
      //   4566: goto -3889 -> 677
      //   4569: astore 36
      //   4571: lload 24
      //   4573: lstore 30
      //   4575: dload 6
      //   4577: dstore_2
      //   4578: lload 28
      //   4580: lstore 24
      //   4582: lload 26
      //   4584: lstore 28
      //   4586: lload 20
      //   4588: lstore 26
      //   4590: iload 11
      //   4592: istore 12
      //   4594: lload 22
      //   4596: lstore 20
      //   4598: lload 28
      //   4600: lstore 22
      //   4602: goto -3925 -> 677
      //   4605: astore 36
      //   4607: lload 24
      //   4609: lstore 30
      //   4611: lload 26
      //   4613: lstore 24
      //   4615: lload 20
      //   4617: lstore 26
      //   4619: iload 11
      //   4621: istore 12
      //   4623: lload 22
      //   4625: lstore 20
      //   4627: lload 24
      //   4629: lstore 22
      //   4631: lload 28
      //   4633: lstore 24
      //   4635: goto -3958 -> 677
      //   4638: goto -2693 -> 1945
      //   4641: goto -2787 -> 1854
      //   4644: lload 26
      //   4646: l2i
      //   4647: istore 11
      //   4649: lload 22
      //   4651: lconst_0
      //   4652: lcmp
      //   4653: ifne -467 -> 4186
      //   4656: ldc2_w 305
      //   4659: lstore 22
      //   4661: goto -3464 -> 1197
      //   4664: iconst_0
      //   4665: istore 15
      //   4667: iconst_0
      //   4668: istore 17
      //   4670: goto -2816 -> 1854
      //   4673: lload 20
      //   4675: l2i
      //   4676: istore 11
      //   4678: lload 26
      //   4680: lconst_0
      //   4681: lcmp
      //   4682: ifne -1555 -> 3127
      //   4685: ldc2_w 305
      //   4688: lstore 20
      //   4690: goto -1822 -> 2868
      //   4693: lload 22
      //   4695: l2i
      //   4696: istore 11
      //   4698: lload 20
      //   4700: lconst_0
      //   4701: lcmp
      //   4702: ifne -444 -> 4258
      //   4705: ldc2_w 305
      //   4708: lstore 20
      //   4710: goto -787 -> 3923
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	4713	0	this	RecordThread
      //   0	4713	1	paramString	String
      //   41	4537	2	d1	double
      //   1642	2783	4	d2	double
      //   1645	2931	6	d3	double
      //   1695	8	8	d4	double
      //   77	4455	10	i	int
      //   187	4510	11	j	int
      //   69	4553	12	k	int
      //   66	4401	13	m	int
      //   38	4450	14	i1	int
      //   63	4603	15	i2	int
      //   291	1746	16	i3	int
      //   49	4620	17	i4	int
      //   43	2003	18	i5	int
      //   52	2024	19	i6	int
      //   60	4649	20	l1	long
      //   46	4648	22	l2	long
      //   35	4599	24	l3	long
      //   534	4145	26	l4	long
      //   32	4600	28	l5	long
      //   72	4538	30	l6	long
      //   519	3799	32	l7	long
      //   57	4064	34	l8	long
      //   156	186	36	arrayOfByte	byte[]
      //   651	2489	36	localThrowable1	Throwable
      //   3393	763	36	localObject	Object
      //   4216	3	36	localThrowable2	Throwable
      //   4226	15	36	localException1	Exception
      //   4270	15	36	localException2	Exception
      //   4481	1	36	localThrowable3	Throwable
      //   4498	1	36	localThrowable4	Throwable
      //   4519	1	36	localThrowable5	Throwable
      //   4544	1	36	localThrowable6	Throwable
      //   4569	1	36	localThrowable7	Throwable
      //   4605	1	36	localThrowable8	Throwable
      //   1662	269	37	locala	aliv.a
      //   1831	11	38	localRecorderParam	QQRecorder.RecorderParam
      // Exception table:
      //   from	to	target	type
      //   544	558	651	java/lang/Throwable
      //   562	575	651	java/lang/Throwable
      //   599	641	651	java/lang/Throwable
      //   641	651	651	java/lang/Throwable
      //   1404	1417	651	java/lang/Throwable
      //   1426	1461	651	java/lang/Throwable
      //   1461	1478	651	java/lang/Throwable
      //   1485	1509	651	java/lang/Throwable
      //   2080	2094	651	java/lang/Throwable
      //   2094	2157	651	java/lang/Throwable
      //   2629	2853	3071	java/lang/Exception
      //   2873	3070	3071	java/lang/Exception
      //   3117	3124	3071	java/lang/Exception
      //   3127	3136	3071	java/lang/Exception
      //   2191	2210	3089	java/lang/Throwable
      //   2210	2217	3089	java/lang/Throwable
      //   2348	2629	3097	java/lang/Exception
      //   677	693	3170	finally
      //   693	735	3170	finally
      //   735	751	3170	finally
      //   751	771	3170	finally
      //   771	780	3170	finally
      //   3139	3167	3170	finally
      //   4140	4165	3170	finally
      //   814	833	4168	java/lang/Throwable
      //   833	840	4168	java/lang/Throwable
      //   958	1182	4198	java/lang/Exception
      //   1202	1399	4198	java/lang/Exception
      //   4176	4183	4198	java/lang/Exception
      //   4186	4195	4198	java/lang/Exception
      //   3224	3243	4216	java/lang/Throwable
      //   3243	3250	4216	java/lang/Throwable
      //   3386	3676	4226	java/lang/Exception
      //   3676	3908	4270	java/lang/Exception
      //   3928	4138	4270	java/lang/Exception
      //   4248	4255	4270	java/lang/Exception
      //   4258	4267	4270	java/lang/Exception
      //   117	147	4292	finally
      //   147	165	4292	finally
      //   165	189	4292	finally
      //   203	210	4292	finally
      //   210	247	4292	finally
      //   247	293	4292	finally
      //   303	312	4292	finally
      //   312	327	4292	finally
      //   334	350	4292	finally
      //   360	402	4292	finally
      //   402	448	4292	finally
      //   465	479	4292	finally
      //   479	516	4292	finally
      //   516	521	4292	finally
      //   544	558	4324	finally
      //   562	575	4324	finally
      //   599	641	4324	finally
      //   641	651	4324	finally
      //   1404	1417	4324	finally
      //   1426	1461	4324	finally
      //   1461	1478	4324	finally
      //   1485	1509	4324	finally
      //   2080	2094	4324	finally
      //   2094	2157	4324	finally
      //   1519	1541	4347	finally
      //   1573	1592	4347	finally
      //   1546	1552	4370	finally
      //   1606	1633	4397	finally
      //   1647	1664	4416	finally
      //   1670	1673	4416	finally
      //   1679	1697	4416	finally
      //   1717	1731	4416	finally
      //   1744	1757	4416	finally
      //   1763	1786	4416	finally
      //   1792	1818	4416	finally
      //   1824	1833	4416	finally
      //   1839	1851	4416	finally
      //   1860	1870	4416	finally
      //   1881	1919	4416	finally
      //   1930	1937	4416	finally
      //   1959	1969	4450	finally
      //   1972	1995	4450	finally
      //   1999	2034	4450	finally
      //   2052	2057	4450	finally
      //   117	147	4481	java/lang/Throwable
      //   147	165	4481	java/lang/Throwable
      //   165	189	4481	java/lang/Throwable
      //   203	210	4481	java/lang/Throwable
      //   210	247	4481	java/lang/Throwable
      //   247	293	4481	java/lang/Throwable
      //   303	312	4481	java/lang/Throwable
      //   312	327	4481	java/lang/Throwable
      //   334	350	4481	java/lang/Throwable
      //   360	402	4481	java/lang/Throwable
      //   402	448	4481	java/lang/Throwable
      //   465	479	4481	java/lang/Throwable
      //   479	516	4481	java/lang/Throwable
      //   516	521	4481	java/lang/Throwable
      //   1519	1541	4498	java/lang/Throwable
      //   1573	1592	4498	java/lang/Throwable
      //   1546	1552	4519	java/lang/Throwable
      //   1606	1633	4544	java/lang/Throwable
      //   1647	1664	4569	java/lang/Throwable
      //   1670	1673	4569	java/lang/Throwable
      //   1679	1697	4569	java/lang/Throwable
      //   1717	1731	4569	java/lang/Throwable
      //   1744	1757	4569	java/lang/Throwable
      //   1763	1786	4569	java/lang/Throwable
      //   1792	1818	4569	java/lang/Throwable
      //   1824	1833	4569	java/lang/Throwable
      //   1839	1851	4569	java/lang/Throwable
      //   1860	1870	4569	java/lang/Throwable
      //   1881	1919	4569	java/lang/Throwable
      //   1930	1937	4569	java/lang/Throwable
      //   1959	1969	4605	java/lang/Throwable
      //   1972	1995	4605	java/lang/Throwable
      //   1999	2034	4605	java/lang/Throwable
      //   2052	2057	4605	java/lang/Throwable
    }
    
    public void a(aliv paramaliv, aliv.a parama)
    {
      if ((paramaliv instanceof WechatNsWrapper))
      {
        QQRecorder.b(QQRecorder.this, (int)AudioHelper.a(QQRecorder.a(QQRecorder.this), parama.data, parama.size, 1.0F));
        this.dZL = Math.max(this.dZL, QQRecorder.c(QQRecorder.this));
        this.ata += QQRecorder.c(QQRecorder.this);
        if (QQRecorder.a(QQRecorder.this) != null) {
          QQRecorder.a(QQRecorder.this).a(paramaliv, parama);
        }
      }
    }
    
    public boolean aET()
    {
      return (this.isAlive) || (QQRecorder.a(QQRecorder.this) != null);
    }
    
    public void b(aliv paramaliv, aliv.a parama)
    {
      if (((paramaliv instanceof WechatNsWrapper)) && (QQRecorder.a(QQRecorder.this) != null)) {
        QQRecorder.a(QQRecorder.this).b(paramaliv, parama);
      }
    }
    
    public void eej()
    {
      if (QQRecorder.a(QQRecorder.this) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "releaseRecorder");
        }
        QQRecorder.a(QQRecorder.this).release();
        QQRecorder.a(QQRecorder.this, null);
      }
    }
    
    public void init()
    {
      if (QQRecorder.a(QQRecorder.this) != null)
      {
        this.bb = new File(QQRecorder.a(QQRecorder.this));
        if (this.bb.exists()) {
          this.bb.delete();
        }
      }
      try
      {
        this.n = new FileOutputStream(this.bb.getAbsoluteFile());
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 36	com/tencent/mobileqq/utils/QQRecorder$RecordThread:isAlive	Z
      //   4: ifeq +116 -> 120
      //   7: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   10: ifeq +12 -> 22
      //   13: ldc 55
      //   15: iconst_2
      //   16: ldc_w 470
      //   19: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   22: aload_0
      //   23: iconst_1
      //   24: putfield 34	com/tencent/mobileqq/utils/QQRecorder$RecordThread:isRunning	Z
      //   27: aload_0
      //   28: iconst_0
      //   29: putfield 196	com/tencent/mobileqq/utils/QQRecorder$RecordThread:cUw	Z
      //   32: aload_0
      //   33: aload_0
      //   34: getfield 185	com/tencent/mobileqq/utils/QQRecorder$RecordThread:recorderPath	Ljava/lang/String;
      //   37: invokespecial 472	com/tencent/mobileqq/utils/QQRecorder$RecordThread:UT	(Ljava/lang/String;)V
      //   40: aload_0
      //   41: getfield 36	com/tencent/mobileqq/utils/QQRecorder$RecordThread:isAlive	Z
      //   44: ifeq -44 -> 0
      //   47: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
      //   50: lstore_1
      //   51: aload_0
      //   52: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   55: astore_3
      //   56: aload_3
      //   57: monitorenter
      //   58: aload_0
      //   59: getfield 29	com/tencent/mobileqq/utils/QQRecorder$RecordThread:this$0	Lcom/tencent/mobileqq/utils/QQRecorder;
      //   62: getstatic 475	com/tencent/mobileqq/utils/QQRecorder:dZK	I
      //   65: i2l
      //   66: invokevirtual 480	java/lang/Object:wait	(J)V
      //   69: aload_3
      //   70: monitorexit
      //   71: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
      //   74: lload_1
      //   75: lsub
      //   76: getstatic 475	com/tencent/mobileqq/utils/QQRecorder:dZK	I
      //   79: i2l
      //   80: lcmp
      //   81: iflt -81 -> 0
      //   84: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   87: ifeq +12 -> 99
      //   90: ldc 55
      //   92: iconst_2
      //   93: ldc_w 482
      //   96: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   99: aload_0
      //   100: monitorenter
      //   101: aload_0
      //   102: iconst_0
      //   103: putfield 36	com/tencent/mobileqq/utils/QQRecorder$RecordThread:isAlive	Z
      //   106: aload_0
      //   107: monitorexit
      //   108: aload_0
      //   109: invokevirtual 484	com/tencent/mobileqq/utils/QQRecorder$RecordThread:eej	()V
      //   112: goto -112 -> 0
      //   115: astore_3
      //   116: aload_3
      //   117: invokevirtual 485	java/lang/InterruptedException:printStackTrace	()V
      //   120: aload_0
      //   121: invokevirtual 484	com/tencent/mobileqq/utils/QQRecorder$RecordThread:eej	()V
      //   124: return
      //   125: astore 4
      //   127: aload_3
      //   128: monitorexit
      //   129: aload 4
      //   131: athrow
      //   132: astore_3
      //   133: aload_0
      //   134: monitorexit
      //   135: aload_3
      //   136: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	137	0	this	RecordThread
      //   50	25	1	l	long
      //   115	13	3	localInterruptedException	java.lang.InterruptedException
      //   132	4	3	localObject1	Object
      //   125	5	4	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   47	58	115	java/lang/InterruptedException
      //   71	99	115	java/lang/InterruptedException
      //   99	101	115	java/lang/InterruptedException
      //   108	112	115	java/lang/InterruptedException
      //   129	132	115	java/lang/InterruptedException
      //   135	137	115	java/lang/InterruptedException
      //   58	71	125	finally
      //   127	129	125	finally
      //   101	108	132	finally
      //   133	135	132	finally
    }
  }
  
  public static class RecorderParam
    implements Parcelable
  {
    public static final Parcelable.Creator<RecorderParam> CREATOR = new aqlp();
    public String cuc;
    public int dZM;
    public int dZN;
    public int dZO;
    public int mAudioType;
    public int mBitRate;
    public int mSampleRate;
    public Object mUserData;
    public int[] oY;
    
    public RecorderParam(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mSampleRate = paramInt1;
      this.mBitRate = paramInt2;
      this.mAudioType = paramInt3;
    }
    
    public RecorderParam(Parcel paramParcel)
    {
      this.mSampleRate = paramParcel.readInt();
      this.mBitRate = paramParcel.readInt();
      this.mAudioType = paramParcel.readInt();
      this.dZM = paramParcel.readInt();
      this.dZN = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mSampleRate);
      paramParcel.writeInt(this.mBitRate);
      paramParcel.writeInt(this.mAudioType);
      paramParcel.writeInt(this.dZM);
      paramParcel.writeInt(this.dZN);
    }
  }
  
  public static abstract interface a
  {
    public abstract int a(String paramString, QQRecorder.RecorderParam paramRecorderParam);
    
    public abstract void a(String paramString, QQRecorder.RecorderParam paramRecorderParam);
    
    public abstract void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble);
    
    public abstract void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2);
    
    public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam);
    
    public abstract void as(int paramInt);
    
    public abstract void at(String paramString);
    
    public abstract void b(String paramString, QQRecorder.RecorderParam paramRecorderParam);
    
    public abstract int bz();
    
    public abstract void c(String paramString, QQRecorder.RecorderParam paramRecorderParam);
    
    public abstract void hB();
  }
  
  public static abstract interface b
  {
    public abstract void a(aliv paramaliv, aliv.a parama);
    
    public abstract void b(aliv paramaliv, aliv.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder
 * JD-Core Version:    0.7.0.1
 */