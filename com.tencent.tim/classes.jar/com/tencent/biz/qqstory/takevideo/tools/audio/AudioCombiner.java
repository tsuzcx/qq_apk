package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rmx;

public class AudioCombiner
{
  private AudioSegmentLooper jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper;
  private a jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$a;
  private int duration;
  private int gap;
  private boolean hasStarted;
  private List<rmx> pb;
  private long startTime;
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$a = parama;
  }
  
  public void a(rmx paramrmx)
  {
    if (paramrmx == null) {}
    for (;;)
    {
      return;
      try
      {
        this.pb.add(paramrmx);
      }
      finally {}
    }
  }
  
  public long dV()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.startTime;
    if (this.startTime == 0L) {
      return 0L;
    }
    return l1 - l2;
  }
  
  public void release()
  {
    int i = 0;
    try
    {
      while (i < this.pb.size())
      {
        rmx localrmx = (rmx)this.pb.get(i);
        if (localrmx != null) {
          localrmx.release();
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void setDuration(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.duration = paramInt;
  }
  
  public void setGap(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.gap = paramInt;
  }
  
  public void start()
  {
    if (this.hasStarted) {
      return;
    }
    this.hasStarted = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper = new AudioSegmentLooper();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper.start();
    ThreadManager.excute(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper, 16, null, true);
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner$AudioSegmentLooper.stop();
    }
    int i = 0;
    while (i < this.pb.size())
    {
      rmx localrmx = (rmx)this.pb.get(i);
      if (localrmx != null) {
        localrmx.stop();
      }
      i += 1;
    }
  }
  
  class AudioSegmentLooper
    implements Runnable
  {
    private int curTime;
    private boolean isRun;
    
    AudioSegmentLooper() {}
    
    private byte[] a(List<byte[]> paramList, int paramInt)
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        return null;
      }
      int m = paramList.size();
      if (paramList.size() == 1) {
        return (byte[])paramList.get(0);
      }
      byte[] arrayOfByte1 = new byte[paramInt];
      int k = paramInt / 2;
      short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { m, k });
      paramInt = 0;
      int i;
      while (paramInt < m)
      {
        byte[] arrayOfByte2 = (byte[])paramList.get(paramInt);
        i = 0;
        if (i < k)
        {
          if (i * 2 + 1 < arrayOfByte2.length) {
            arrayOfShort[paramInt][i] = ((short)(arrayOfByte2[(i * 2)] & 0xFF | (arrayOfByte2[(i * 2 + 1)] & 0xFF) << 8));
          }
          for (;;)
          {
            i += 1;
            break;
            arrayOfShort[paramInt][i] = 0;
          }
        }
        paramInt += 1;
      }
      paramList = new short[k];
      int j = 0;
      while (j < k)
      {
        i = 0;
        int n;
        for (paramInt = 0; i < m; paramInt = n + paramInt)
        {
          n = arrayOfShort[i][j];
          i += 1;
        }
        i = paramInt;
        if (paramInt > 32767) {
          i = 32767;
        }
        paramInt = i;
        if (i < -32768) {
          paramInt = -32768;
        }
        paramList[j] = ((short)paramInt);
        j += 1;
      }
      paramInt = 0;
      while (paramInt < k)
      {
        arrayOfByte1[(paramInt * 2)] = ((byte)(paramList[paramInt] & 0xFF));
        arrayOfByte1[(paramInt * 2 + 1)] = ((byte)((paramList[paramInt] & 0xFF00) >> 8));
        paramInt += 1;
      }
      return arrayOfByte1;
    }
    
    public void run()
    {
      if (AudioCombiner.a(AudioCombiner.this) == null) {
        return;
      }
      AudioCombiner.a(AudioCombiner.this, SystemClock.elapsedRealtime());
      long l;
      ArrayList localArrayList;
      int i;
      if ((this.curTime < AudioCombiner.a(AudioCombiner.this)) && (this.isRun))
      {
        l = SystemClock.elapsedRealtime();
        localArrayList = new ArrayList();
        i = 0;
      }
      label424:
      for (;;)
      {
        for (;;)
        {
          synchronized (AudioCombiner.this)
          {
            Iterator localIterator2 = AudioCombiner.a(AudioCombiner.this).iterator();
            if (localIterator2.hasNext())
            {
              byte[] arrayOfByte = ((rmx)localIterator2.next()).a(this.curTime, this.curTime + AudioCombiner.b(AudioCombiner.this));
              if (arrayOfByte == null) {
                continue;
              }
              if (arrayOfByte.length <= i) {
                break label424;
              }
              i = arrayOfByte.length;
              localArrayList.add(arrayOfByte);
              continue;
            }
            ??? = a(localArrayList, i);
            if (AudioCombiner.a(AudioCombiner.this) != null) {
              AudioCombiner.a(AudioCombiner.this).i((byte[])???, this.curTime, this.curTime + AudioCombiner.b(AudioCombiner.this));
            }
            localArrayList.clear();
            System.gc();
            l = SystemClock.elapsedRealtime() - l;
            if (QLog.isColorLevel()) {
              QLog.d("AudioCombiner", 2, "cost : " + l);
            }
            if (l >= AudioCombiner.b(AudioCombiner.this)) {}
          }
          try
          {
            Thread.sleep(AudioCombiner.b(AudioCombiner.this) - l);
            this.curTime += AudioCombiner.b(AudioCombiner.this);
            break;
            localObject1 = finally;
            throw localObject1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AudioCombiner", 2, "combiner has been Interrupted");
              }
            }
          }
        }
        Iterator localIterator1 = AudioCombiner.a(AudioCombiner.this).iterator();
        while (localIterator1.hasNext()) {
          ((rmx)localIterator1.next()).bvA();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AudioCombiner", 2, "audio combiner has finished. curTime : " + this.curTime + "  duration : " + AudioCombiner.a(AudioCombiner.this) + "  isRun : " + this.isRun);
        return;
      }
    }
    
    public void start()
    {
      this.isRun = true;
      this.curTime = 0;
    }
    
    public void stop()
    {
      this.isRun = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.AudioCombiner
 * JD-Core Version:    0.7.0.1
 */