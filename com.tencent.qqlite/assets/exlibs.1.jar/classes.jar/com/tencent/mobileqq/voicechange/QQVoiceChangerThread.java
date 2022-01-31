package com.tencent.mobileqq.voicechange;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.IAudioCompressor;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.mobileqq.utils.PTTAgcWrapper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import ezg;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class QQVoiceChangerThread
  extends Thread
{
  public static final int a = 960;
  public static final String a = "QQVoiceChanger";
  public static HashMap a;
  private static final int jdField_b_of_type_Int = 4;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack = null;
  private IAudioCompressor jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor = null;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private PTTAgcWrapper jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = null;
  private QQVoiceChangerThread.TuneVoiceListener jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener = null;
  private VoiceChange jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange = null;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream = null;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream = null;
  public volatile boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[960];
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private boolean jdField_d_of_type_Boolean = true;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private int h = 0;
  private int i = 0;
  private int j = 1;
  private int k = 0;
  private int l = 960;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public QQVoiceChangerThread(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, QQVoiceChangerThread.TuneVoiceListener paramTuneVoiceListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_f_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
    this.j = paramInt5;
    this.jdField_e_of_type_Int = paramInt6;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener = paramTuneVoiceListener;
    try
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, new ezg(this, false, paramInt6, paramInt5, 0, ""));
      if (QLog.isColorLevel()) {
        QLog.d("QQVoiceChanger", 2, "new QQVoiceChangerThread filePath=" + this.jdField_b_of_type_JavaLangString + " sampleRate=" + paramInt1 + " channel=" + paramInt2 + " sampleSize=" + paramInt3 + " bitRate=" + paramInt4 + " voiceType=" + paramInt5 + " changeType=" + paramInt6);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString, QQVoiceChangerThread.CompressFinishListener paramCompressFinishListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "queryStateByPath called path=" + paramString);
    }
    for (;;)
    {
      ezg localezg;
      try
      {
        localezg = (ezg)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localezg == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "no task path=" + paramString);
          }
          return false;
        }
        if (localezg.jdField_a_of_type_Boolean)
        {
          VoiceTuneUtil.a(paramString, localezg.jdField_a_of_type_JavaLangString, localezg.jdField_a_of_type_Int);
          jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          paramCompressFinishListener.a(paramString, localezg.b, localezg.c);
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "queryStateByPath onCompressFinished filePath=" + paramString + " time=" + localezg.c + " voiceType=" + localezg.b);
          }
          return true;
        }
      }
      finally {}
      localezg.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$CompressFinishListener = paramCompressFinishListener;
    }
  }
  
  /* Error */
  private void c(int paramInt)
  {
    // Byte code:
    //   0: ldc 10
    //   2: monitorenter
    //   3: iload_1
    //   4: i2d
    //   5: dstore_2
    //   6: dload_2
    //   7: invokestatic 192	com/tencent/mobileqq/utils/QQRecorder:a	(D)I
    //   10: istore_1
    //   11: getstatic 45	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   14: aload_0
    //   15: getfield 100	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokevirtual 155	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 102	ezg
    //   24: astore 4
    //   26: aload 4
    //   28: ifnull +111 -> 139
    //   31: aload 4
    //   33: getfield 186	ezg:jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$CompressFinishListener	Lcom/tencent/mobileqq/voicechange/QQVoiceChangerThread$CompressFinishListener;
    //   36: ifnull +107 -> 143
    //   39: aload_0
    //   40: getfield 100	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   43: aload_0
    //   44: getfield 194	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   47: aload_0
    //   48: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_e_of_type_Int	I
    //   51: invokestatic 167	com/tencent/mobileqq/voicechange/VoiceTuneUtil:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   54: aload 4
    //   56: getfield 186	ezg:jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$CompressFinishListener	Lcom/tencent/mobileqq/voicechange/QQVoiceChangerThread$CompressFinishListener;
    //   59: aload_0
    //   60: getfield 100	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 66	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:j	I
    //   67: iload_1
    //   68: invokeinterface 179 4 0
    //   73: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +52 -> 128
    //   79: ldc 10
    //   81: iconst_2
    //   82: new 119	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   89: ldc 196
    //   91: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 100	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 183
    //   103: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_1
    //   107: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc 141
    //   112: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_0
    //   116: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_e_of_type_Int	I
    //   119: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: getstatic 45	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   131: aload_0
    //   132: getfield 100	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   135: invokevirtual 170	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: ldc 10
    //   141: monitorexit
    //   142: return
    //   143: aload 4
    //   145: iconst_1
    //   146: putfield 158	ezg:jdField_a_of_type_Boolean	Z
    //   149: aload 4
    //   151: iload_1
    //   152: putfield 174	ezg:c	I
    //   155: aload 4
    //   157: aload_0
    //   158: getfield 56	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_e_of_type_Int	I
    //   161: putfield 162	ezg:jdField_a_of_type_Int	I
    //   164: aload 4
    //   166: aload_0
    //   167: getfield 66	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:j	I
    //   170: putfield 172	ezg:b	I
    //   173: aload 4
    //   175: aload_0
    //   176: getfield 194	com/tencent/mobileqq/voicechange/QQVoiceChangerThread:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   179: putfield 160	ezg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   182: goto -43 -> 139
    //   185: astore 4
    //   187: ldc 10
    //   189: monitorexit
    //   190: aload 4
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	QQVoiceChangerThread
    //   0	193	1	paramInt	int
    //   5	2	2	d1	double
    //   24	150	4	localezg	ezg
    //   185	6	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	26	185	finally
    //   31	128	185	finally
    //   128	139	185	finally
    //   139	142	185	finally
    //   143	182	185	finally
    //   187	190	185	finally
  }
  
  private void f()
  {
    this.jdField_c_of_type_JavaLangString = VoiceTuneUtil.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_c_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "open:" + this.jdField_c_of_type_JavaLangString + " a=" + this.jdField_a_of_type_JavaIoFileInputStream.available());
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = PTTAgcWrapper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = NoiseSuppression.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(this.jdField_f_of_type_Int);
  }
  
  private void h()
  {
    if (this.j == 0) {}
    for (this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor = new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext);; this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor = new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext, true, this.jdField_f_of_type_Int, this.i))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor.a(960);
      return;
    }
  }
  
  private void i()
  {
    int m = 2;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange = new VoiceChange(this.jdField_a_of_type_AndroidContentContext);
    if (!this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQVoiceChanger", 2, "create voice changer failed");
      }
      throw new Exception();
    }
    VoiceChange localVoiceChange = this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange;
    int n = this.jdField_f_of_type_Int;
    if (this.jdField_g_of_type_Int == 2) {
      m = 1;
    }
    this.l = localVoiceChange.a(n, m, this.jdField_e_of_type_Int);
    this.jdField_b_of_type_ArrayOfByte = new byte[this.l * 10];
    this.jdField_d_of_type_ArrayOfByte = new byte[this.l];
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioTrack != null) {
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange != null) {
      this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange.a();
    }
    if (this.jdField_a_of_type_JavaIoFileInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileInputStream.close();
      if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor == null) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          do
          {
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor.a();
              if (this.jdField_g_of_type_Boolean) {
                VoiceTuneUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
              }
              if (QLog.isColorLevel()) {
                QLog.d("QQVoiceChanger", 2, "clean up requestToCancel=" + this.jdField_g_of_type_Boolean);
              }
              return;
              localIOException1 = localIOException1;
              localIOException1.printStackTrace();
              if (QLog.isColorLevel()) {
                QLog.d("QQVoiceChanger", 2, "close fis failed:" + localIOException1.getStackTrace());
              }
            }
            localIOException2 = localIOException2;
            localIOException2.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.d("QQVoiceChanger", 2, "close fos failed:" + localIOException2.getStackTrace());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            localIOException3.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("QQVoiceChanger", 2, "close iAudioCompressor failed:" + localIOException3.getStackTrace());
            }
          }
        }
      }
    }
  }
  
  protected void a()
  {
    int m = AudioTrack.getMinBufferSize(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.h);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_f_of_type_Int, 4, 2, m, 1);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
  }
  
  protected void a(int paramInt)
  {
    File localFile = new File(VoiceTuneUtil.a(this.jdField_b_of_type_JavaLangString, paramInt));
    localFile.createNewFile();
    this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
  }
  
  protected void b()
  {
    int i11 = this.jdField_a_of_type_JavaIoFileInputStream.available();
    int n = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    Object localObject4 = null;
    Object localObject5 = null;
    if (this.jdField_d_of_type_Boolean) {
      arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    }
    Object localObject1 = localObject4;
    int m = i6;
    int i3 = n;
    Object localObject3 = localObject5;
    int i1 = i5;
    int i2 = i4;
    if (QLog.isColorLevel())
    {
      QLog.d("QQVoiceChanger", 2, "start progress totalSize=" + i11 + " filePath=" + this.jdField_b_of_type_JavaLangString + "pcmFilePath=" + this.jdField_c_of_type_JavaLangString);
      i2 = i4;
      i1 = i5;
      localObject3 = localObject5;
      i3 = n;
      m = i6;
      localObject1 = localObject4;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!this.jdField_c_of_type_Boolean) || (m != 0)) {
        break label1125;
      }
      if (this.j != 0) {
        break label323;
      }
      this.jdField_a_of_type_JavaIoFileInputStream.skip("#!AMR\n".length());
    }
    label186:
    label323:
    label469:
    label1125:
    for (n = 1;; n = m)
    {
      m = 0;
      if (localObject1 != null)
      {
        m = localObject1.length;
        System.arraycopy(localObject1, 0, this.jdField_a_of_type_ArrayOfByte, 0, m);
      }
      try
      {
        i4 = this.jdField_a_of_type_JavaIoFileInputStream.read(this.jdField_a_of_type_ArrayOfByte, m, 960 - m);
        if ((i4 != -1) && (i4 >= 960 - m)) {
          break label391;
        }
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener.h();
        }
        c(i2);
        if (QLog.isColorLevel()) {
          QLog.d("QQVoiceChanger", 2, "finishedCompress playedTime=" + i2);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("QQVoiceChanger", 2, "read failed" + localIOException.getStackTrace());
          }
        }
        m += i4;
        if (this.jdField_e_of_type_Boolean) {
          break label410;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener.j();
      }
      return;
      if (this.j != 1) {
        break label186;
      }
      this.jdField_a_of_type_JavaIoFileInputStream.skip(10L);
      break label186;
      if (this.jdField_d_of_type_Boolean)
      {
        i4 = m % this.l;
        if (i4 != 0)
        {
          localObject4 = new byte[i4];
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, m - i4, localObject4, 0, i4);
          m -= i4;
        }
      }
      for (;;)
      {
        int i10 = i3 + m;
        int i8 = 0;
        i6 = m;
        int i9 = i2;
        int i7 = m;
        i2 = i7;
        i3 = i8;
        m = i6;
        Object localObject2 = localObject3;
        if (this.jdField_d_of_type_Boolean)
        {
          m = 0;
          if (localObject3 != null) {
            m = localObject3.length;
          }
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, i8, this.jdField_d_of_type_ArrayOfByte, 0, this.l);
          i4 = this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChange.a(this.jdField_d_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte);
          i8 += this.l;
          i7 -= this.l;
          if (i4 == 0)
          {
            i4 = i9;
            i5 = i1;
            localObject5 = localObject3;
          }
        }
        for (;;)
        {
          if ((i7 >= this.l) && (this.jdField_d_of_type_Boolean))
          {
            localObject3 = localObject5;
            i1 = i5;
            i9 = i4;
            if (this.jdField_a_of_type_Boolean) {
              break label469;
            }
          }
          localObject2 = localObject4;
          m = n;
          i3 = i10;
          localObject3 = localObject5;
          i1 = i5;
          i2 = i4;
          break;
          if (m > 0)
          {
            System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, m, i4);
            System.arraycopy(localObject3, 0, this.jdField_b_of_type_ArrayOfByte, 0, m);
            i4 = m + i4;
            localObject2 = null;
            m = 0;
          }
          for (;;)
          {
            i5 = m;
            if (this.jdField_e_of_type_Boolean) {
              i5 = i4 % NoiseSuppression.jdField_f_of_type_Int;
            }
            i2 = i7;
            i3 = i8;
            m = i4;
            if (i5 != 0)
            {
              localObject2 = new byte[i5];
              System.arraycopy(this.jdField_b_of_type_ArrayOfByte, i4 - i5, localObject2, 0, i5);
              m = i4 - i5;
              i3 = i8;
              i2 = i7;
            }
            if (!this.jdField_e_of_type_Boolean) {
              break;
            }
            i4 = 0;
            while (i4 < m)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper != null) {
                this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper.a(arrayOfByte, i4, NoiseSuppression.jdField_f_of_type_Int);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
                this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.a(arrayOfByte, i4, NoiseSuppression.jdField_f_of_type_Int);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper != null) {
                this.jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper.b(arrayOfByte, i4, NoiseSuppression.jdField_f_of_type_Int);
              }
              i4 += NoiseSuppression.jdField_f_of_type_Int;
            }
            localObject2 = localObject3;
          }
          i7 = i2;
          i8 = i3;
          i6 = m;
          localObject5 = localObject2;
          i5 = i1;
          i4 = i9;
          if (m > 0)
          {
            this.k = ((int)AudioHelper.a(this.jdField_a_of_type_AndroidContentContext, arrayOfByte, m, 1.0F));
            i9 += (int)QQRecorder.a(this.jdField_f_of_type_Int, 4, 2, m);
            if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener.a(this.k, i10 * 100 / i11, i9);
            }
            if (this.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_AndroidMediaAudioTrack.write(arrayOfByte, 0, m);
            }
            if (this.jdField_f_of_type_Boolean) {
              this.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqUtilsIAudioCompressor.a(arrayOfByte, m);
            }
            i7 = i2;
            i8 = i3;
            i6 = m;
            localObject5 = localObject2;
            i5 = i1;
            i4 = i9;
            if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
            {
              i7 = i2;
              i8 = i3;
              i6 = m;
              localObject5 = localObject2;
              i5 = i1;
              i4 = i9;
              if (this.jdField_f_of_type_Boolean)
              {
                i5 = i1;
                if (i1 == 0)
                {
                  localObject3 = RecordParams.a(this.j, this.jdField_f_of_type_Int);
                  this.jdField_a_of_type_JavaIoFileOutputStream.write((byte[])localObject3, 0, localObject3.length);
                  this.jdField_a_of_type_JavaIoFileOutputStream.flush();
                  i5 = 1;
                }
                this.jdField_a_of_type_JavaIoFileOutputStream.write(this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte.length);
                this.jdField_a_of_type_JavaIoFileOutputStream.flush();
                i7 = i2;
                i8 = i3;
                i6 = m;
                localObject5 = localObject2;
                i4 = i9;
              }
            }
          }
        }
        localObject4 = localObject2;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    d();
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToSend isRunning=" + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQVoiceChanger", 2, "requestToCancel isRunning=" + this.jdField_a_of_type_Boolean);
    }
    d();
    if (!this.jdField_a_of_type_Boolean) {
      VoiceTuneUtil.b(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener = null;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    try
    {
      if (this.jdField_e_of_type_Int == 0) {
        this.jdField_d_of_type_Boolean = false;
      }
      if (this.jdField_d_of_type_Boolean) {
        i();
      }
      if (this.jdField_e_of_type_Boolean) {
        g();
      }
      if (this.jdField_f_of_type_Boolean) {
        h();
      }
      f();
      a(this.jdField_e_of_type_Int);
      a();
      b();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener.i();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQVoiceChanger", 2, "file io failed:" + localIOException.getStackTrace());
      }
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread$TuneVoiceListener.i();
      }
      localException.printStackTrace();
      return;
    }
    finally
    {
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.QQVoiceChangerThread
 * JD-Core Version:    0.7.0.1
 */