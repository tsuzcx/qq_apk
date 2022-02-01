package com.tencent.mobileqq.richmedia.capture.audio;

import alwc;
import amaj;
import amaj.b;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Process;
import anii;
import aniq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.utils.NoiseSuppression;
import com.tencent.qphone.base.util.QLog;

public class AudioCapture
  implements amaj.b
{
  public static int BUF_SIZE = 16384;
  public static int dyq = 4;
  amaj jdField_a_of_type_Amaj;
  public AudioRecord a;
  private RecordRunnable jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a;
  private NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression;
  private int audioFormat;
  public alwc b;
  private String bYH;
  private String bYI;
  private int channelConfig;
  private boolean czI;
  public volatile boolean czJ = true;
  private boolean czK;
  private boolean czL;
  private boolean czM;
  private boolean czN;
  private boolean czO;
  private boolean czP;
  public int dyr;
  public int dys;
  int dyt = 0;
  int dyu = 0;
  public volatile int dyv;
  private int dyw;
  byte[] fl = null;
  byte[] fm = null;
  private Handler handler;
  private int sampleRateInHz;
  private Thread t;
  
  public AudioCapture(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama, Handler paramHandler)
  {
    this.bYH = paramString;
    this.dyw = paramInt1;
    this.sampleRateInHz = paramInt2;
    this.channelConfig = paramInt3;
    this.audioFormat = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a = parama;
    this.handler = paramHandler;
    if (paramHandler == null) {
      this.handler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.dyr = 0;
    this.dys = 0;
    this.czK = false;
    this.czL = false;
  }
  
  private boolean auC()
  {
    boolean bool = true;
    for (;;)
    {
      int i;
      try
      {
        if (this.czI)
        {
          bool = this.czI;
          return bool;
        }
        this.dyt = AudioRecord.getMinBufferSize(this.sampleRateInHz, aniq.ckG, aniq.mAudioFormat);
        if ((this.dyt == -2) || (this.dyt == -1))
        {
          QLog.e("AudioCapture", 2, "getMinBufferSize error. mRecBufSize = " + this.dyt);
          bool = false;
          continue;
        }
        this.fl = new byte[this.dyt];
        i = BUF_SIZE / dyq;
        if (this.dyt <= i)
        {
          i = BUF_SIZE;
          this.dyu = i;
          this.fm = new byte[this.dyu];
          this.czI = true;
          continue;
        }
        i = this.dyt;
      }
      finally {}
      int j = dyq;
      i *= j;
    }
  }
  
  private void dKb()
  {
    this.dyt = 0;
    this.fl = null;
    this.dyu = 0;
    this.fm = null;
    this.czI = false;
    this.dyr = 0;
    this.dys = 0;
    this.czL = false;
  }
  
  public void Oh(boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (!this.czP) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = NoiseSuppression.a(BaseApplicationImpl.getContext());
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.init(16000);
          }
        }
        this.czP = paramBoolean;
        this.sampleRateInHz = 16000;
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
        return;
      }
    }
    this.czP = paramBoolean;
    this.sampleRateInHz = aniq.bth;
  }
  
  /* Error */
  public void Oi(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 139
    //   10: iconst_2
    //   11: new 141	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   18: ldc 206
    //   20: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   27: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: iload_1
    //   34: ifne +44 -> 78
    //   37: aload_0
    //   38: getfield 108	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   41: ifnull +37 -> 78
    //   44: aload_0
    //   45: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   48: ifnull +30 -> 78
    //   51: aload_0
    //   52: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   55: invokevirtual 216	java/lang/Thread:isAlive	()Z
    //   58: ifeq +20 -> 78
    //   61: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +11 -> 75
    //   67: ldc 139
    //   69: iconst_2
    //   70: ldc 218
    //   72: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: aload_0
    //   79: getfield 108	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   82: ifnull +33 -> 115
    //   85: aload_0
    //   86: getfield 108	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   89: iconst_1
    //   90: putfield 221	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:czQ	Z
    //   93: aload_0
    //   94: getfield 108	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   97: iconst_0
    //   98: putfield 224	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:isRecording	Z
    //   101: aload_0
    //   102: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   105: ifnull +10 -> 115
    //   108: aload_0
    //   109: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   112: invokevirtual 227	java/lang/Thread:interrupt	()V
    //   115: aload_0
    //   116: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   119: ifnull +10 -> 129
    //   122: aload_0
    //   123: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   126: invokevirtual 230	java/lang/Thread:join	()V
    //   129: aload_0
    //   130: new 8	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable
    //   133: dup
    //   134: aload_0
    //   135: invokespecial 232	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable:<init>	(Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;)V
    //   138: putfield 108	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 108	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture$RecordRunnable;
    //   146: ldc 234
    //   148: iconst_5
    //   149: invokestatic 238	com/tencent/mobileqq/app/ThreadManager:newFreeThread	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   152: putfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   155: aload_0
    //   156: getfield 113	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:t	Ljava/lang/Thread;
    //   159: invokevirtual 241	java/lang/Thread:start	()V
    //   162: aload_0
    //   163: getfield 243	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:czO	Z
    //   166: ifeq -91 -> 75
    //   169: aload_0
    //   170: getfield 245	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Amaj	Lamaj;
    //   173: ifnonnull -98 -> 75
    //   176: aload_0
    //   177: new 247	amaj
    //   180: dup
    //   181: invokespecial 248	amaj:<init>	()V
    //   184: putfield 245	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Amaj	Lamaj;
    //   187: aload_0
    //   188: getfield 245	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Amaj	Lamaj;
    //   191: aload_0
    //   192: getfield 77	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:sampleRateInHz	I
    //   195: invokevirtual 252	amaj:Ui	(I)V
    //   198: aload_0
    //   199: getfield 245	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:jdField_a_of_type_Amaj	Lamaj;
    //   202: aload_0
    //   203: invokevirtual 255	amaj:a	(Lamaj$b;)V
    //   206: goto -131 -> 75
    //   209: astore_2
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 256	java/lang/InterruptedException:printStackTrace	()V
    //   219: goto -90 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	AudioCapture
    //   0	222	1	paramBoolean	boolean
    //   209	4	2	localObject	Object
    //   214	2	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	33	209	finally
    //   37	75	209	finally
    //   78	115	209	finally
    //   115	129	209	finally
    //   129	206	209	finally
    //   215	219	209	finally
    //   115	129	214	java/lang/InterruptedException
  }
  
  public void Oj(boolean paramBoolean)
  {
    this.czN = paramBoolean;
  }
  
  void Tw(int paramInt)
  {
    if (paramInt == -3)
    {
      this.czJ = false;
      this.dyv = -1;
    }
    do
    {
      return;
      if (paramInt != 0) {
        break;
      }
      if (this.dyr < 5)
      {
        this.dyr += 1;
        return;
      }
      this.czJ = false;
      this.dyv = -2;
    } while (!QLog.isColorLevel());
    QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA_LENGTH]: result=" + paramInt + " mAudioInvalidCount=" + this.dyr);
    return;
    this.dyr = 0;
    if (paramInt > 128) {}
    for (int i = 128;; i = paramInt)
    {
      boolean bool;
      if (!this.czK)
      {
        bool = anii.isFoundProductFeature(anii.KEY_HARDWARE_PRIVILEGE_ERROR_MODEL);
        if ((!bool) || (this.dys >= 5)) {
          break label310;
        }
        this.czL = PreviewContext.checkIsDisablePrivilage(this.fl, i);
        label151:
        this.dys += 1;
        if (this.czL) {
          break label318;
        }
        this.czK = true;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=" + paramInt + " mDisableAudioPrivilage=" + this.czL + " blackPhone=" + bool + " mAudioInvalidData=" + this.dys);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.czL + " limit=" + i + " mAudioCanUsed=" + this.czJ + " result=" + paramInt);
        return;
        label310:
        this.czL = false;
        break label151;
        label318:
        if ((this.czL) && (this.dys >= 5))
        {
          this.czK = true;
          this.czJ = false;
          this.dyv = -3;
        }
      }
    }
  }
  
  public void aJ(boolean paramBoolean, String paramString)
  {
    this.czO = paramBoolean;
    this.bYI = paramString;
  }
  
  public void dJY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio queueResume");
    }
    this.handler.post(new AudioCapture.1(this));
  }
  
  public void dJZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "openMic");
    }
    this.handler.post(new AudioCapture.2(this));
  }
  
  public void dKa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "closeMic");
    }
    this.handler.post(new AudioCapture.3(this));
  }
  
  public void dKc()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a.Pn(this.bYI);
    }
  }
  
  public void dKd()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a.Tx(-6);
    }
  }
  
  public int getSampleRate()
  {
    return this.sampleRateInHz;
  }
  
  public void hd(String paramString1, String paramString2)
  {
    this.bYH = paramString1;
    this.bYI = paramString2;
  }
  
  public int j(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    if (!this.czP) {
      return 0;
    }
    int j = paramInt % NoiseSuppression.dZp;
    while (i < paramInt - j)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression.j(paramArrayOfByte, i, NoiseSuppression.dZp);
      }
      i += NoiseSuppression.dZp;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: remainder=" + j);
    }
    return j;
  }
  
  void p(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt > 0) && (paramInt <= paramArrayOfByte.length))
    {
      if (this.b == null) {
        break label80;
      }
      this.b.e(paramArrayOfByte, 0, paramInt);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Amaj != null)
      {
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
        this.jdField_a_of_type_Amaj.j(arrayOfByte, 0L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$a.n(paramArrayOfByte, 0, paramInt);
      }
      return;
      label80:
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio pause");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.mPause = true;
    }
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "audio resume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.mPause = false;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.ey)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.ey.notifyAll();
        return;
      }
    }
  }
  
  public void startRecord()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable == null) {
      Oi(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.czR = true;
    }
    resume();
    if (this.jdField_a_of_type_Amaj != null) {
      this.jdField_a_of_type_Amaj.onStart(this.bYI);
    }
  }
  
  public void stopRecord()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, new Object[] { "audio, stopRecord, isRecording:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.isRecording), " mIsVoiceRecognizerStat:", Boolean.valueOf(this.czN) });
      }
      this.czN = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable.isRecording = false;
      this.t.interrupt();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture$RecordRunnable = null;
    }
    this.czM = false;
  }
  
  class RecordRunnable
    implements Runnable
  {
    boolean czQ;
    boolean czR = false;
    Object ey = new Object();
    boolean isRecording;
    boolean mPause;
    
    public RecordRunnable()
    {
      if (!AudioCapture.b(AudioCapture.this)) {
        bool = true;
      }
      this.mPause = bool;
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "RecordRunnable run");
      }
      this.czQ = false;
      AudioCapture.a(AudioCapture.this);
      Process.setThreadPriority(-19);
      while ((!this.czR) || (AudioCapture.c(AudioCapture.this)))
      {
        if (this.czQ)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "RecordRunnable exit before record");
          }
          return;
        }
        if (this.mPause)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, "RecordRunnable pause");
          }
          synchronized (this.ey)
          {
            try
            {
              if (this.mPause) {
                this.ey.wait();
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("AudioCapture", 2, "RecordRunnable resume, startrecord:" + this.czR + " interrupt:" + this.czQ + " pause:" + this.mPause);
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.e("AudioCapture", 1, "RecordRunnable wait exception:", localException2);
              }
            }
          }
        }
        else
        {
          if ((AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord == null) || (AudioCapture.this.fl == null)) {
            break label529;
          }
          i = AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord.read(AudioCapture.this.fl, 0, AudioCapture.this.dyt);
          if (AudioCapture.a(AudioCapture.this) != null) {
            AudioCapture.a(AudioCapture.this).n(AudioCapture.this.fl, 0, i);
          }
          if ((this.czR) && (AudioCapture.c(AudioCapture.this))) {
            if (QLog.isColorLevel()) {
              QLog.d("AudioCapture", 2, "RecordRunnable mIsVoiceRecognizerStat true, start record");
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "RecordRunnable record run");
      }
      this.isRecording = true;
      AudioCapture.this.b = new alwc(AudioCapture.a(AudioCapture.this));
      AudioCapture.this.b.qh();
      int i = 0;
      label529:
      label544:
      label960:
      label965:
      for (;;)
      {
        try
        {
          if (((!this.isRecording) && (!AudioCapture.c(AudioCapture.this))) || (this.czQ)) {
            break label785;
          }
          if ((AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord == null) || (AudioCapture.this.fl == null) || (AudioCapture.this.fm == null)) {
            continue;
          }
          if (AudioCapture.this.dyt < AudioCapture.this.dyu) {
            break label544;
          }
          if ((AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord == null) || (AudioCapture.this.fl == null)) {
            break label960;
          }
          j = AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord.read(AudioCapture.this.fl, 0, AudioCapture.this.dyu);
          AudioCapture.this.Tw(j);
          AudioCapture.this.p(AudioCapture.this.fl, j);
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException1)
        {
          QLog.e("AudioCapture", 1, "audio, run exception: ", localException1);
          AudioCapture.this.b.yC();
          return;
        }
        QLog.d("AudioCapture", 2, "RecordRunnable exit, error param");
        return;
        if ((AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord != null) && (AudioCapture.this.fl != null)) {}
        for (int j = AudioCapture.this.jdField_a_of_type_AndroidMediaAudioRecord.read(AudioCapture.this.fl, 0, AudioCapture.this.dyt);; j = 0)
        {
          AudioCapture.this.Tw(j);
          if (j <= 0) {
            break;
          }
          if (i + j > AudioCapture.this.dyu)
          {
            System.arraycopy(AudioCapture.this.fl, 0, AudioCapture.this.fm, i, AudioCapture.this.dyu - i);
            int k = AudioCapture.this.j(AudioCapture.this.fm, AudioCapture.this.dyu);
            int m = AudioCapture.this.dyu - k;
            AudioCapture.this.p(AudioCapture.this.fm, m);
            if (k > 0) {
              System.arraycopy(AudioCapture.this.fm, m, AudioCapture.this.fm, 0, k);
            }
            i = AudioCapture.this.dyu - i;
            j -= i;
            System.arraycopy(AudioCapture.this.fl, i, AudioCapture.this.fm, k, j);
            i = j + k;
            break label965;
          }
          System.arraycopy(AudioCapture.this.fl, 0, AudioCapture.this.fm, i, j);
          i = j + i;
          break label965;
          if (AudioCapture.d(AudioCapture.this))
          {
            j = AudioCapture.this.j(AudioCapture.this.fm, i);
            AudioCapture.this.p(AudioCapture.this.fm, i - j);
          }
          AudioCapture.this.b.yC();
          if (AudioCapture.this.jdField_a_of_type_Amaj != null) {
            AudioCapture.this.jdField_a_of_type_Amaj.onStop();
          }
          if (QLog.isColorLevel()) {
            QLog.d("AudioCapture", 2, new Object[] { "audio, run out, isRecording:", Boolean.valueOf(this.isRecording), " mIsVoiceRecognizerStat:", Boolean.valueOf(AudioCapture.c(AudioCapture.this)) });
          }
          if ((!this.isRecording) && (AudioCapture.a(AudioCapture.this) != null)) {
            AudioCapture.a(AudioCapture.this).Pl(AudioCapture.this.b.wX());
          }
          AudioCapture.b(AudioCapture.this);
          return;
        }
        j = 0;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Pl(String paramString);
    
    public abstract void Pm(String paramString);
    
    public abstract void Pn(String paramString);
    
    public abstract void Tx(int paramInt);
    
    public abstract void dKe();
    
    public abstract void dKf();
    
    public abstract void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.audio.AudioCapture
 * JD-Core Version:    0.7.0.1
 */