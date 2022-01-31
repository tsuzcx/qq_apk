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
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import evr;
import java.io.File;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
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
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  private static final int n = 8000;
  private static final int o = 2;
  private static final int p = 2;
  private static final int q = 20480;
  private static final int r = 800;
  private static final int u = 160;
  private static final int w = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  public AudioManager a;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord = null;
  private AmrInputStreamWrapper jdField_a_of_type_ComTencentMobileqqUtilsAmrInputStreamWrapper = null;
  private QQRecorder.OnQQRecorderListener jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener;
  public evr a;
  private PipedInputStream jdField_a_of_type_JavaIoPipedInputStream = null;
  private PipedOutputStream jdField_a_of_type_JavaIoPipedOutputStream = null;
  private String jdField_c_of_type_JavaLangString;
  private int s = 20480;
  private int t = 800;
  private int v = 0;
  private int x = -1;
  private int y = -1;
  
  static
  {
    d = null;
  }
  
  public QQRecorder(Context paramContext)
  {
    this.c = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_record.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "Init | dpc config = " + paramContext);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.x = Integer.parseInt(paramContext[0]);
        this.y = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.e()) && ((this.x == 3) || (this.y == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.x = -1;
        this.y = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "mMode = " + this.x + " | mAudioSource = " + this.y + " | recorderBufSize = " + this.s + " | readLength = " + this.t);
    }
  }
  
  public static double a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLong <= 0L) {
      return 0.0D;
    }
    return paramLong / b(paramInt1, paramInt2, paramInt3);
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
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: new 209	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 210	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 10
    //   13: new 212	java/io/DataInputStream
    //   16: dup
    //   17: aload 10
    //   19: invokespecial 215	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 9
    //   24: aload 10
    //   26: invokevirtual 219	java/io/FileInputStream:available	()I
    //   29: istore 7
    //   31: iconst_0
    //   32: istore 5
    //   34: aload 9
    //   36: invokevirtual 223	java/io/DataInputStream:readByte	()B
    //   39: istore 8
    //   41: iload 8
    //   43: ifle +237 -> 280
    //   46: iload 5
    //   48: iconst_1
    //   49: iadd
    //   50: istore 6
    //   52: iload 6
    //   54: istore 5
    //   56: iload 6
    //   58: bipush 7
    //   60: if_icmpne -26 -> 34
    //   63: iload 8
    //   65: iconst_3
    //   66: ishr
    //   67: i2b
    //   68: bipush 7
    //   70: iand
    //   71: i2b
    //   72: istore 5
    //   74: iload 7
    //   76: i2d
    //   77: ldc2_w 224
    //   80: dsub
    //   81: getstatic 64	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ArrayOfInt	[I
    //   84: iload 5
    //   86: iaload
    //   87: i2d
    //   88: ddiv
    //   89: ldc2_w 226
    //   92: ddiv
    //   93: dstore_3
    //   94: aload 9
    //   96: invokevirtual 230	java/io/DataInputStream:close	()V
    //   99: aload 10
    //   101: invokevirtual 231	java/io/FileInputStream:close	()V
    //   104: aload 10
    //   106: ifnull +8 -> 114
    //   109: aload 10
    //   111: invokevirtual 231	java/io/FileInputStream:close	()V
    //   114: aload 9
    //   116: ifnull +8 -> 124
    //   119: aload 9
    //   121: invokevirtual 230	java/io/DataInputStream:close	()V
    //   124: dload_3
    //   125: dstore_1
    //   126: dload_3
    //   127: ldc2_w 232
    //   130: dcmpg
    //   131: ifgt +17 -> 148
    //   134: dload_3
    //   135: dstore_1
    //   136: dload_3
    //   137: dconst_0
    //   138: dcmpl
    //   139: ifle +9 -> 148
    //   142: dload_3
    //   143: ldc2_w 232
    //   146: dadd
    //   147: dstore_1
    //   148: dload_1
    //   149: ldc2_w 232
    //   152: dadd
    //   153: d2i
    //   154: ireturn
    //   155: astore 10
    //   157: aconst_null
    //   158: astore_0
    //   159: aload 11
    //   161: astore 9
    //   163: aload 10
    //   165: invokevirtual 236	java/lang/Exception:printStackTrace	()V
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 231	java/io/FileInputStream:close	()V
    //   176: aload 9
    //   178: ifnull +8 -> 186
    //   181: aload 9
    //   183: invokevirtual 230	java/io/DataInputStream:close	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: astore_0
    //   189: aconst_null
    //   190: astore 9
    //   192: aconst_null
    //   193: astore 10
    //   195: aload 10
    //   197: ifnull +8 -> 205
    //   200: aload 10
    //   202: invokevirtual 231	java/io/FileInputStream:close	()V
    //   205: aload 9
    //   207: ifnull +8 -> 215
    //   210: aload 9
    //   212: invokevirtual 230	java/io/DataInputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: astore 9
    //   219: goto -4 -> 215
    //   222: astore_0
    //   223: aconst_null
    //   224: astore 9
    //   226: goto -31 -> 195
    //   229: astore_0
    //   230: goto -35 -> 195
    //   233: astore 11
    //   235: aload_0
    //   236: astore 10
    //   238: aload 11
    //   240: astore_0
    //   241: goto -46 -> 195
    //   244: astore_0
    //   245: goto -59 -> 186
    //   248: astore 9
    //   250: aload 10
    //   252: astore_0
    //   253: aload 9
    //   255: astore 10
    //   257: aload 11
    //   259: astore 9
    //   261: goto -98 -> 163
    //   264: astore 11
    //   266: aload 10
    //   268: astore_0
    //   269: aload 11
    //   271: astore 10
    //   273: goto -110 -> 163
    //   276: astore_0
    //   277: goto -153 -> 124
    //   280: iconst_0
    //   281: istore 5
    //   283: goto -209 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramString	String
    //   125	24	1	d1	double
    //   93	50	3	d2	double
    //   32	250	5	i1	int
    //   50	11	6	i2	int
    //   29	46	7	i3	int
    //   39	28	8	i4	int
    //   22	189	9	localObject1	Object
    //   217	1	9	localException1	Exception
    //   224	1	9	localObject2	Object
    //   248	6	9	localException2	Exception
    //   259	1	9	localObject3	Object
    //   11	99	10	localFileInputStream	java.io.FileInputStream
    //   155	9	10	localException3	Exception
    //   193	79	10	localObject4	Object
    //   1	159	11	localObject5	Object
    //   233	25	11	localObject6	Object
    //   264	6	11	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   3	13	155	java/lang/Exception
    //   3	13	188	finally
    //   200	205	217	java/lang/Exception
    //   210	215	217	java/lang/Exception
    //   13	24	222	finally
    //   24	31	229	finally
    //   34	41	229	finally
    //   74	104	229	finally
    //   163	168	233	finally
    //   172	176	244	java/lang/Exception
    //   181	186	244	java/lang/Exception
    //   13	24	248	java/lang/Exception
    //   24	31	264	java/lang/Exception
    //   34	41	264	java/lang/Exception
    //   74	104	264	java/lang/Exception
    //   109	114	276	java/lang/Exception
    //   119	124	276	java/lang/Exception
  }
  
  public static String a()
  {
    return d;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(8000, 2, 2);
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
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[this.t];
    byte[] arrayOfByte2 = new byte[16];
    this.jdField_a_of_type_JavaIoPipedOutputStream.write(paramArrayOfByte, 0, paramInt);
    paramInt = 0;
    while (this.jdField_a_of_type_JavaIoPipedInputStream.available() >= 320)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqUtilsAmrInputStreamWrapper.read(arrayOfByte2);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, i1);
      paramInt += i1;
    }
    paramArrayOfByte = new byte[paramInt];
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, paramInt);
    return paramArrayOfByte;
  }
  
  private static double b(long paramLong)
  {
    return a(8000, 2, 2, paramLong);
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
      if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.x != -1)) {
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.x);
      }
      if (this.y == -1) {}
      for (i1 = i2;; i1 = this.y)
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(i1, 8000, 2, 2, this.s);
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 1) {
          break;
        }
        i1 = this.jdField_a_of_type_AndroidMediaAudioRecord.getState();
        if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
          this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        }
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener.d();
        }
        throw new RuntimeException("mRecorder.getState is not STATE_INITIALIZED, state = " + i1);
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener.c();
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
  
  private static int c()
  {
    return a(8000, 2, 2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream = new PipedOutputStream();
    this.jdField_a_of_type_JavaIoPipedInputStream = new PipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream);
    this.jdField_a_of_type_ComTencentMobileqqUtilsAmrInputStreamWrapper = new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoPipedInputStream);
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, new StringBuilder().toString());
    }
  }
  
  public static boolean c()
  {
    if (AmrInputStreamWrapper.a()) {}
    while (FileUtils.a() > 327680.0F) {
      return true;
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaIoPipedOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedOutputStream.close();
      this.jdField_a_of_type_JavaIoPipedOutputStream = null;
    }
    if (this.jdField_a_of_type_JavaIoPipedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream.close();
      this.jdField_a_of_type_JavaIoPipedInputStream = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsAmrInputStreamWrapper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsAmrInputStreamWrapper.close();
      this.jdField_a_of_type_ComTencentMobileqqUtilsAmrInputStreamWrapper = null;
    }
  }
  
  public static boolean d()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Evr == null) {
      return 0;
    }
    return this.v;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_Evr + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Evr != null) {
      this.jdField_a_of_type_Evr.a = false;
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_Evr + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Evr == null)
    {
      this.jdField_a_of_type_Evr = new evr(this, paramString);
      this.jdField_a_of_type_Evr.start();
      d = paramString;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$OnQQRecorderListener.c(paramString);
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
    return this.jdField_a_of_type_Evr != null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Evr == null) || (!this.jdField_a_of_type_Evr.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder
 * JD-Core Version:    0.7.0.1
 */