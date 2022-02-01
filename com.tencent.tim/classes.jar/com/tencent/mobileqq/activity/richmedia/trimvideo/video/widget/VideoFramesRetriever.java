package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import aauw;
import aauy.a;
import aava;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

@TargetApi(10)
public class VideoFramesRetriever
  implements aava
{
  private static long mCount;
  private aauw a;
  private int ckQ = 1000;
  private ConcurrentHashMap<Integer, a> dm;
  private float fX;
  private BlockingQueue<a> h;
  private ExecutorService mExecutor;
  private volatile boolean mIsDestroyed;
  private MediaMetadataRetriever mRetriever;
  private volatile int mStatus = 1;
  private int mVideoDuration;
  private String mVideoPath;
  
  public VideoFramesRetriever(String paramString, float paramFloat)
  {
    this.mVideoPath = paramString;
    this.fX = paramFloat;
  }
  
  private aauy.a b(int paramInt)
  {
    if (!isInited()) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesRetriever", 2, "FetchFrameAtTime fail, status=" + this.mStatus);
      }
    }
    a locala2;
    do
    {
      return null;
      try
      {
        if (this.dm.containsKey(Integer.valueOf(paramInt)))
        {
          a locala1 = (a)this.dm.get(Integer.valueOf(paramInt));
          l = mCount;
          mCount = 1L + l;
          locala1.lX = l;
          return null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      long l = mCount;
      mCount = 1L + l;
      locala2 = new a(l, paramInt, paramInt + this.ckQ);
    } while (this.h == null);
    this.h.offer(locala2);
    return null;
  }
  
  public int a(int paramInt1, int paramInt2, aauw paramaauw)
  {
    this.ckQ = paramInt1;
    this.mVideoDuration = paramInt2;
    this.a = paramaauw;
    this.h = new PriorityBlockingQueue();
    this.dm = new ConcurrentHashMap();
    this.mRetriever = new MediaMetadataRetriever();
    this.mRetriever.setDataSource(this.mVideoPath);
    this.mExecutor = Executors.newSingleThreadExecutor();
    this.mExecutor.submit(new FrameFetchRunnable());
    return 0;
  }
  
  public aauy.a c(int paramInt)
  {
    if ((!isInited()) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesRetriever", 2, "fetchFrameByIndex1 fail, status=" + this.mStatus);
      }
      return null;
    }
    if (this.a.hF(paramInt)) {
      return this.a.a(paramInt);
    }
    return b(this.ckQ * paramInt);
  }
  
  public void gw(int paramInt1, int paramInt2)
  {
    if ((!isInited()) || (paramInt1 < 0) || (paramInt2 < 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesRetriever", 2, "fetchFrameByIndex2 fail, status=" + this.mStatus);
      }
    }
    for (;;)
    {
      return;
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        c(paramInt2);
        paramInt2 -= 1;
      }
    }
  }
  
  public boolean isInited()
  {
    return true;
  }
  
  public void release()
  {
    this.mStatus = 1;
    this.mIsDestroyed = true;
    if (this.h != null)
    {
      this.h.clear();
      this.h = null;
    }
    if (this.dm != null)
    {
      this.dm.clear();
      this.dm = null;
    }
    this.mExecutor.shutdownNow();
    if (this.mRetriever != null) {
      this.mRetriever.release();
    }
    mCount = 0L;
  }
  
  class FrameFetchRunnable
    implements Runnable
  {
    FrameFetchRunnable() {}
    
    public void run()
    {
      if (VideoFramesRetriever.a(VideoFramesRetriever.this) == null) {
        return;
      }
      for (;;)
      {
        Object localObject2;
        try
        {
          long l = System.currentTimeMillis();
          VideoFramesRetriever.a locala;
          localObject2 = VideoFramesRetriever.a(VideoFramesRetriever.this).getFrameAtTime((locala.startTime + locala.endTime) / 2 * 1000L);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoFramesRetriever", 2, "getThumbnail Failed");
            }
            if ((VideoFramesRetriever.a(VideoFramesRetriever.this)) || (VideoFramesRetriever.a(VideoFramesRetriever.this) == null)) {
              break;
            }
            locala = (VideoFramesRetriever.a)VideoFramesRetriever.a(VideoFramesRetriever.this).take();
            if (!VideoFramesRetriever.a(VideoFramesRetriever.this)) {
              continue;
            }
            return;
          }
          if (((Bitmap)localObject2).getWidth() > ((Bitmap)localObject2).getHeight())
          {
            i = 1;
            if (i == 0) {
              break label338;
            }
            f = VideoFramesRetriever.a(VideoFramesRetriever.this) / ((Bitmap)localObject2).getHeight();
            Object localObject1 = new Matrix();
            ((Matrix)localObject1).postScale(f, f);
            if (i == 0) {
              break label356;
            }
            localObject1 = Bitmap.createBitmap((Bitmap)localObject2, (((Bitmap)localObject2).getWidth() - ((Bitmap)localObject2).getHeight()) / 2, 0, ((Bitmap)localObject2).getHeight(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, true);
            ((Bitmap)localObject2).recycle();
            localObject2 = new aauy.a();
            ((aauy.a)localObject2).ey = ((Bitmap)localObject1).copy(Bitmap.Config.RGB_565, true);
            ((aauy.a)localObject2).index = (locala.startTime / VideoFramesRetriever.b(VideoFramesRetriever.this));
            ((Bitmap)localObject1).recycle();
            QLog.i("VideoFramesRetriever", 1, "end get frame bitmap, cost time=" + (System.currentTimeMillis() - l));
            VideoFramesRetriever.a(VideoFramesRetriever.this).a((aauy.a)localObject2);
            VideoFramesRetriever.a(VideoFramesRetriever.this).remove(Integer.valueOf(locala.startTime));
            continue;
          }
          int i = 0;
        }
        catch (Throwable localThrowable)
        {
          localThrowable = localThrowable;
          QLog.e("VideoFramesRetriever", 2, "FrameFetchRunnable, Exception:", localThrowable);
          return;
        }
        finally {}
        continue;
        label338:
        float f = VideoFramesRetriever.a(VideoFramesRetriever.this) / ((Bitmap)localObject2).getWidth();
        continue;
        label356:
        Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject2, 0, (((Bitmap)localObject2).getHeight() - ((Bitmap)localObject2).getWidth()) / 2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getWidth(), localMatrix, true);
      }
    }
  }
  
  class a
    implements Comparable<a>
  {
    public int endTime;
    public long lX;
    public int startTime;
    
    public a(long paramLong, int paramInt1, int paramInt2)
    {
      this.lX = paramLong;
      this.startTime = paramInt1;
      this.endTime = Math.min(paramInt2, VideoFramesRetriever.a(VideoFramesRetriever.this));
      VideoFramesRetriever.a(VideoFramesRetriever.this).put(Integer.valueOf(paramInt1), this);
    }
    
    public int a(a parama)
    {
      return -(int)(this.lX - parama.lX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever
 * JD-Core Version:    0.7.0.1
 */