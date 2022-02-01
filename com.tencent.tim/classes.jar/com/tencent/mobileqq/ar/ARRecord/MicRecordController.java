package com.tencent.mobileqq.ar.ARRecord;

import allc;
import android.media.AudioRecord;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class MicRecordController
  extends AudioRecordController
{
  private int cCA;
  private byte[] db;
  private boolean dp;
  private AudioRecord mAudioRecorder;
  private volatile boolean mIsPause;
  
  public MicRecordController(VideoRecordController paramVideoRecordController)
  {
    super(paramVideoRecordController);
  }
  
  public void Ml()
  {
    while (this.dp) {
      if ((this.mAudioRecorder != null) && (!this.mIsPause)) {
        try
        {
          int i = this.mAudioRecorder.read(this.db, 0, this.cCA);
          if (i > 0)
          {
            VideoRecordController localVideoRecordController = (VideoRecordController)this.mRef.get();
            if (localVideoRecordController != null)
            {
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(this.db, 0, arrayOfByte, 0, i);
              localVideoRecordController.j(arrayOfByte, SystemClock.elapsedRealtimeNanos());
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("MicAudioRecordControlle", 1, "AudioRecordController read fail.", localException);
        }
      }
    }
  }
  
  public void cQk()
  {
    if (this.mAudioRecorder == null)
    {
      this.cCA = (AudioRecord.getMinBufferSize(48000, 1, 2) * 4);
      this.mAudioRecorder = new AudioRecord(1, 48000, 1, 2, this.cCA);
      this.db = new byte[this.cCA];
    }
    if (!this.dp)
    {
      allc.a(this.mAudioRecorder);
      this.dp = true;
      start();
    }
  }
  
  public void stopAudioRecord()
  {
    if (this.dp)
    {
      if (this.mAudioRecorder != null)
      {
        this.mAudioRecorder.stop();
        this.mAudioRecorder.release();
        this.mAudioRecorder = null;
      }
      this.dp = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.MicRecordController
 * JD-Core Version:    0.7.0.1
 */