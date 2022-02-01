package com.tencent.mobileqq.shortvideo.mediadevice;

import acfp;
import allc;
import android.content.Context;
import android.media.AudioRecord;
import android.os.Process;
import android.os.SystemClock;
import anhn;
import anho;
import anhr;
import anii;
import aniq;
import anit;
import aniu;
import anka;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.a;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicReference;

public class AudioCapture
  extends anhn
{
  public static int BUF_SIZE = 160768;
  public static boolean cGN = true;
  public static int dyq = 4;
  AudioRecord a;
  long alH;
  long alI;
  private boolean cGO;
  private boolean czI;
  public volatile boolean czJ = true;
  private boolean czK;
  private boolean czL;
  public AtomicReference<anka> d = new AtomicReference(null);
  public int dyr;
  public int dys;
  int dyt = 0;
  int dyu = 0;
  public volatile int dyv;
  byte[] fl = null;
  byte[] fm = null;
  boolean isCreate = false;
  volatile boolean isRunning = false;
  boolean isStart = false;
  int mBlockIndex = 0;
  Context mContext;
  public AtomicReference<SVHwEncoder> mEncodeRef = new AtomicReference(null);
  int mFrameIndex = 0;
  Object mLock = new Object();
  
  public AudioCapture(Context paramContext)
  {
    this.mContext = paramContext;
    this.dyr = 0;
    this.dys = 0;
  }
  
  private int k(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  void Tw(int paramInt)
  {
    if (paramInt == -3)
    {
      this.czJ = false;
      this.dyv = -1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "checkAudioPrivilage[end]: result=" + paramInt + " mAudioCanUsed=" + this.czJ);
      }
      return;
      if (paramInt != 0) {
        break;
      }
      if (this.dyr < 5)
      {
        this.dyr += 1;
      }
      else
      {
        this.czJ = false;
        this.dyv = -2;
      }
    }
    this.dyr = 0;
    if (paramInt > 128) {}
    for (int i = 128;; i = paramInt)
    {
      boolean bool;
      if (!this.czK)
      {
        bool = anii.isFoundProductFeature(anii.KEY_HARDWARE_PRIVILEGE_ERROR_MODEL);
        if ((!bool) || (this.dys >= 5)) {
          break label297;
        }
        this.czL = PreviewContext.checkIsDisablePrivilage(this.fl, i);
        label153:
        this.dys += 1;
        if (this.czL) {
          break label305;
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
        QLog.d("AudioCapture", 2, "checkAudioPrivilage: mDisableAudioPrivilage=" + this.czL + " limit=" + i + " mAudioCanUsed=" + this.czJ);
        break;
        label297:
        this.czL = false;
        break label153;
        label305:
        if ((this.czL) && (this.dys >= 5))
        {
          this.czK = true;
          this.czJ = false;
          this.dyv = -3;
        }
      }
    }
  }
  
  public void a(a parama)
  {
    a(parama, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    Object localObject = new AVIOStruct();
    int i;
    if (paramBoolean) {
      i = this.mBlockIndex;
    }
    for (;;)
    {
      ((AVIOStruct)localObject).pBlockIndex = i;
      i = this.mFrameIndex;
      this.mFrameIndex = (i + 1);
      ((AVIOStruct)localObject).pFrameIndex = i;
      ((AVIOStruct)localObject).aBitrate = aniq.dHj;
      ((AVIOStruct)localObject).pCodec = aniq.mCodecId;
      ((AVIOStruct)localObject).pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
      ((AVIOStruct)localObject).aChannel = aniq.ckG;
      ((AVIOStruct)localObject).aFormat = aniq.mAudioFormat;
      ((AVIOStruct)localObject).aSampleRate = aniq.bth;
      if ((paramArrayOfByte != null) && (paramInt1 > 0))
      {
        byte[] arrayOfByte = new byte[paramInt1];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt1);
        aniu.a().a().handleAudio(arrayOfByte, (AVIOStruct)localObject, (int)paramLong);
        paramArrayOfByte = (SVHwEncoder)this.mEncodeRef.get();
        if (paramArrayOfByte != null)
        {
          localObject = new SVHwEncoder.a();
          ((SVHwEncoder.a)localObject).data = arrayOfByte;
          ((SVHwEncoder.a)localObject).offset = 0;
          ((SVHwEncoder.a)localObject).size = arrayOfByte.length;
          ((SVHwEncoder.a)localObject).time = SystemClock.elapsedRealtime();
          ((SVHwEncoder.a)localObject).finish = false;
          ((SVHwEncoder.a)localObject).isVideo = false;
          paramArrayOfByte.a((SVHwEncoder.a)localObject, false);
        }
        notify(paramInt2, new Object[] { Integer.valueOf(0) });
      }
      return;
      i = this.mBlockIndex;
      this.mBlockIndex = (i + 1);
    }
  }
  
  public boolean auC()
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
        this.dyt = AudioRecord.getMinBufferSize(aniq.bth, aniq.ckG, aniq.mAudioFormat);
        if ((this.dyt == -2) || (this.dyt == -1))
        {
          if (aniu.a().b().a(this, 3, "init audio failed")) {
            break label187;
          }
          notify(3, new Object[] { "init audio failed" });
          break label187;
        }
        this.fl = new byte[this.dyt];
        i = BUF_SIZE / dyq;
        if (this.dyt <= i)
        {
          i = BUF_SIZE;
          this.dyu = i;
          this.fm = new byte[this.dyu];
          this.czI = true;
          notify(3, new Object[] { Boolean.valueOf(true), Integer.valueOf(0) });
          continue;
        }
        i = this.dyt;
      }
      finally {}
      int j = dyq;
      i *= j;
      continue;
      label187:
      bool = false;
    }
  }
  
  public void b(a parama)
  {
    a(parama);
  }
  
  void b(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 > 0) && (paramInt1 <= paramArrayOfByte.length))
    {
      if (this.d.get() == null) {
        break label59;
      }
      ((anka)this.d.get()).e(paramArrayOfByte, 0, paramInt1);
    }
    for (;;)
    {
      notify(paramInt2, new Object[] { Integer.valueOf(0) });
      return;
      label59:
      if (QLog.isColorLevel()) {
        QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
      }
    }
  }
  
  void c(byte[] paramArrayOfByte, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (this.cGO)
    {
      b(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
      return;
    }
    a(paramArrayOfByte, paramInt1, paramLong, paramBoolean, paramInt2);
  }
  
  public void dJZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    if (!this.isCreate) {}
    while (!QLog.isColorLevel())
    {
      try
      {
        auC();
        this.a = new AudioRecord(1, aniq.bth, aniq.ckG, aniq.mAudioFormat, this.dyt);
        if (this.a.getState() == 0)
        {
          notify(5, new Object[] { acfp.m(2131702916) });
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        notify(5, new Object[] { acfp.m(2131702919) });
        return;
      }
      this.isCreate = true;
    }
    QLog.d("AudioCapture", 2, "AudioCapture[openMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
  }
  
  public void dKb()
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
  
  public void dQg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    if ((this.a != null) && (this.isCreate) && (!this.isStart)) {}
    for (;;)
    {
      try
      {
        allc.a(this.a);
        this.isStart = true;
        notify(6, new Object[] { Boolean.valueOf(true) });
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "AudioCapture[startMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
        }
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        this.isStart = false;
        localIllegalStateException.printStackTrace();
      }
      try
      {
        this.a.release();
        notify(6, new Object[] { acfp.m(2131702920) });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void dQh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    if ((this.a != null) && (this.isCreate) && (this.isStart))
    {
      this.a.stop();
      this.isStart = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[stopMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    this.mContext = null;
  }
  
  public void dQi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    if (this.a != null)
    {
      this.a.release();
      this.a = null;
      this.isCreate = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[releaseMic]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    this.mContext = null;
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioCapture", 2, "AudioCapture[destory]: isCreate=" + this.isCreate + " isStart=" + this.isStart + " mAudioRecord=" + this.a);
    }
    this.isRunning = false;
    synchronized (this.mLock)
    {
      this.mLock.notifyAll();
      dQh();
      dQi();
      this.mBlockIndex = 0;
      this.mFrameIndex = 0;
      return;
    }
  }
  
  public boolean init()
  {
    this.isRunning = true;
    this.czK = false;
    this.czL = false;
    this.cGO = RMVideoStateMgr.a().hB(6);
    new RecordThread2().start();
    return true;
  }
  
  public void reset()
  {
    this.mBlockIndex = 0;
    this.mFrameIndex = 0;
  }
  
  public void startRecord()
  {
    if (!anit.cHa) {
      return;
    }
    synchronized (this.mLock)
    {
      this.mLock.notifyAll();
      notify(1, new Object[] { Integer.valueOf(0) });
      return;
    }
  }
  
  public void stopRecord()
  {
    if (anit.cHa) {
      return;
    }
    notify(2, new Object[] { Integer.valueOf(0) });
  }
  
  class RecordThread2
    extends Thread
  {
    RecordThread2() {}
    
    public void run()
    {
      AudioCapture.this.auC();
      int i = 0;
      int j;
      label86:
      int m;
      if (AudioCapture.this.isRunning)
      {
        for (;;)
        {
          synchronized (AudioCapture.this.mLock)
          {
            try
            {
              AudioCapture.this.mLock.wait();
              if (!AudioCapture.this.isRunning) {
                break;
              }
              AudioCapture.this.alH = System.currentTimeMillis();
              AudioCapture.this.alI = System.currentTimeMillis();
              Process.setThreadPriority(-19);
              k = 1;
              j = i;
              i = k;
              if (!anit.cHa) {
                break label542;
              }
              if ((AudioCapture.this.a == null) || (AudioCapture.this.fl == null) || (AudioCapture.this.fm == null)) {
                continue;
              }
              AudioCapture.this.alI = System.currentTimeMillis();
              if (AudioCapture.this.dyt < AudioCapture.this.dyu) {
                break label273;
              }
              m = 0;
              k = m;
              if (AudioCapture.this.a != null)
              {
                k = m;
                if (AudioCapture.this.fl != null) {
                  k = AudioCapture.this.a.read(AudioCapture.this.fl, 0, AudioCapture.this.dyu);
                }
              }
              AudioCapture.this.Tw(k);
              if (i != 0)
              {
                i = 0;
                continue;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          AudioCapture.this.c(AudioCapture.this.fl, k, System.currentTimeMillis() - AudioCapture.this.alH, true, 4);
        }
        label273:
        if ((AudioCapture.this.a == null) || (AudioCapture.this.fl == null)) {
          break label662;
        }
      }
      label662:
      for (int k = AudioCapture.this.a.read(AudioCapture.this.fl, 0, AudioCapture.this.dyt);; k = 0)
      {
        AudioCapture.this.Tw(k);
        if (k <= 0) {
          break label86;
        }
        if (i != 0)
        {
          i = 0;
          break label86;
        }
        if (j + k > AudioCapture.this.dyu)
        {
          System.arraycopy(AudioCapture.this.fl, 0, AudioCapture.this.fm, j, AudioCapture.this.dyu - j);
          m = AudioCapture.a(AudioCapture.this, AudioCapture.this.fm, AudioCapture.this.dyu);
          int n = AudioCapture.this.dyu - m;
          AudioCapture.this.c(AudioCapture.this.fm, n, System.currentTimeMillis() - AudioCapture.this.alH, true, 4);
          if (m > 0) {
            System.arraycopy(AudioCapture.this.fm, n, AudioCapture.this.fm, 0, m);
          }
          j = AudioCapture.this.dyu - j;
          k -= j;
          System.arraycopy(AudioCapture.this.fl, j, AudioCapture.this.fm, m, k);
          j = m + k;
        }
        for (;;)
        {
          break;
          System.arraycopy(AudioCapture.this.fl, 0, AudioCapture.this.fm, j, k);
          j += k;
        }
        label542:
        i = AudioCapture.a(AudioCapture.this, AudioCapture.this.fm, j);
        j -= i;
        AudioCapture.this.c(AudioCapture.this.fm, j, System.currentTimeMillis() - AudioCapture.this.alH, false, 9);
        if (i > 0)
        {
          System.arraycopy(AudioCapture.this.fm, j, AudioCapture.this.fm, 0, i);
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AudioCapture", 2, "AudioNoiseSuppression[QQ]: leftLen=" + i);
        }
        i = 0;
        break;
        AudioCapture.this.dKb();
        return;
      }
    }
  }
  
  public static abstract interface a
    extends anho
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture
 * JD-Core Version:    0.7.0.1
 */