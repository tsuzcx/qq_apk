package com.tencent.mobileqq.ar.ARRecord;

import adcq;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PcmRecordController
  extends AudioRecordController
{
  private long Sd;
  private adcq a;
  private volatile boolean dp;
  private String mAudioPath;
  private volatile boolean mIsPause;
  
  public PcmRecordController(VideoRecordController paramVideoRecordController, String paramString)
  {
    super(paramVideoRecordController);
    this.mAudioPath = paramString;
  }
  
  public void Ml()
  {
    this.Sd = System.currentTimeMillis();
    while (this.dp) {
      if ((this.a != null) && (this.Sd > 0L) && (!this.mIsPause)) {
        try
        {
          long l = System.currentTimeMillis() - this.Sd;
          byte[] arrayOfByte = this.a.e(l);
          VideoRecordController localVideoRecordController = (VideoRecordController)this.mRef.get();
          if (localVideoRecordController != null) {
            localVideoRecordController.j(arrayOfByte, SystemClock.elapsedRealtimeNanos());
          }
          if (QLog.isColorLevel()) {
            QLog.d("PcmRecordController", 2, String.format("record audio duration: %s, buffer length: %s", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) }));
          }
          this.Sd = System.currentTimeMillis();
          sleep(200L);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.e("PcmRecordController", 1, "AudioRecordController read fail.", localException);
        }
      }
    }
  }
  
  public void cQk()
  {
    try
    {
      if (this.a == null) {
        this.a = new adcq(this.mAudioPath, 48000, 1, 16);
      }
      if (!this.dp)
      {
        this.dp = true;
        this.mIsPause = false;
        start();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PcmRecordController", 2, String.format("startAudioRecord, mIsRecording: %s", new Object[] { Boolean.valueOf(this.dp) }));
    }
  }
  
  public void stopAudioRecord()
  {
    if (this.dp)
    {
      if (this.a != null)
      {
        this.a.release();
        this.a = null;
      }
      this.dp = false;
      this.Sd = 0L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PcmRecordController", 2, String.format("stopAudioRecord, isRecording: %s", new Object[] { Boolean.valueOf(this.dp) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.PcmRecordController
 * JD-Core Version:    0.7.0.1
 */