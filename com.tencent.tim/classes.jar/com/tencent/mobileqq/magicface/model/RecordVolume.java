package com.tencent.mobileqq.magicface.model;

import allc;
import android.media.AudioRecord;
import aqlv;
import com.tencent.qphone.base.util.QLog;

public class RecordVolume
  implements Runnable
{
  private a a;
  private AudioRecord b;
  private int bs;
  private volatile boolean isRun;
  
  public RecordVolume(a parama)
  {
    this.a = parama;
  }
  
  public void run()
  {
    try
    {
      int i = aqlv.dZQ;
      this.bs = AudioRecord.getMinBufferSize(i, 2, 2);
      this.b = new AudioRecord(1, i, 2, 2, this.bs);
      allc.a(this.b);
      short[] arrayOfShort = new short[this.bs];
      this.isRun = true;
      for (;;)
      {
        boolean bool = this.isRun;
        if (!bool) {
          break;
        }
        try
        {
          int j = this.b.read(arrayOfShort, 0, this.bs);
          long l = 0L;
          i = 0;
          while (i < arrayOfShort.length)
          {
            l += arrayOfShort[i] * arrayOfShort[i];
            i += 1;
          }
          if ((j != 0) && (l != 0L))
          {
            double d = 10.0D * Math.log10(l / j);
            if (QLog.isColorLevel()) {
              QLog.i("recordVolume", 2, "====dB===" + d);
            }
            if (this.a != null) {
              this.a.Qs((int)Math.round(d));
            }
          }
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      try
      {
        if (this.b.getRecordingState() == 3) {
          this.b.stop();
        }
        this.b.release();
        this.b = null;
        if (QLog.isColorLevel()) {
          QLog.i("RecordVolume", 2, "====recordVolume release ok==");
        }
        throw localObject;
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecordVolume", 2, "RecordVolume exception=" + localException4.getMessage());
          }
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (this.b != null) {}
      try
      {
        if (this.b.getRecordingState() == 3) {
          this.b.stop();
        }
        this.b.release();
        this.b = null;
        if (QLog.isColorLevel()) {
          QLog.i("RecordVolume", 2, "====recordVolume release ok==");
        }
        for (;;)
        {
          return;
          if (this.b == null) {
            continue;
          }
          try
          {
            if (this.b.getRecordingState() == 3) {
              this.b.stop();
            }
            this.b.release();
            this.b = null;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("RecordVolume", 2, "====recordVolume release ok==");
            return;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i("RecordVolume", 2, "RecordVolume exception=" + localException2.getMessage());
              }
            }
          }
        }
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecordVolume", 2, "RecordVolume exception=" + localException3.getMessage());
          }
        }
      }
    }
    finally
    {
      if (this.b == null) {}
    }
  }
  
  public void stop()
  {
    this.isRun = false;
  }
  
  public static abstract interface a
  {
    public abstract void Qs(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.RecordVolume
 * JD-Core Version:    0.7.0.1
 */