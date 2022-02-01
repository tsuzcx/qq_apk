package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import ayvp;
import ayvr.a;
import ayvs;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VideoFramesFetcher
  implements ayvs
{
  private static long mCount;
  private ayvp a;
  private int ckQ;
  private ConcurrentHashMap<Integer, a> dm;
  private BlockingQueue<a> h;
  private volatile boolean mIsDestroyed;
  private volatile int mStatus;
  private int mVideoDuration;
  
  private ayvr.a b(int paramInt)
  {
    if (!isInited()) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "FetchFrameAtTime fail, status=" + this.mStatus);
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
  
  public ayvr.a c(int paramInt)
  {
    if ((!isInited()) || (paramInt < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex1 fail, status=" + this.mStatus);
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
        QLog.d("VideoFramesFetcher", 2, "fetchFrameByIndex2 fail, status=" + this.mStatus);
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
  
  class FrameFetchRunnable
    implements Runnable
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 21	com/tencent/maxvideo/trim/TrimNative:isGetThumbnailReady	()Z
      //   3: ifne +50 -> 53
      //   6: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   9: ifeq +11 -> 20
      //   12: ldc 28
      //   14: iconst_2
      //   15: ldc 30
      //   17: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   20: return
      //   21: aload_3
      //   22: getfield 40	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$a:startTime	I
      //   25: i2l
      //   26: aload_3
      //   27: getfield 43	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$a:endTime	I
      //   30: i2l
      //   31: invokestatic 49	ayvm:b	(JJ)Landroid/graphics/Bitmap;
      //   34: astore_2
      //   35: aload_2
      //   36: ifnonnull +69 -> 105
      //   39: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   42: ifeq +11 -> 53
      //   45: ldc 28
      //   47: iconst_2
      //   48: ldc 51
      //   50: invokestatic 34	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   53: aload_0
      //   54: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   57: invokestatic 57	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
      //   60: ifne +138 -> 198
      //   63: aload_0
      //   64: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   67: invokestatic 60	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
      //   70: ifnull +128 -> 198
      //   73: aload_0
      //   74: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   77: invokestatic 60	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
      //   80: invokeinterface 66 1 0
      //   85: checkcast 36	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$a
      //   88: astore_3
      //   89: aload_0
      //   90: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   93: invokestatic 57	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
      //   96: istore_1
      //   97: iload_1
      //   98: ifeq -77 -> 21
      //   101: invokestatic 69	com/tencent/maxvideo/trim/TrimNative:release	()V
      //   104: return
      //   105: new 71	ayvr$a
      //   108: dup
      //   109: invokespecial 74	ayvr$a:<init>	()V
      //   112: astore 4
      //   114: aload 4
      //   116: aload_2
      //   117: getstatic 80	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
      //   120: iconst_1
      //   121: invokevirtual 86	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   124: putfield 90	ayvr$a:ey	Landroid/graphics/Bitmap;
      //   127: aload 4
      //   129: aload_3
      //   130: getfield 40	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$a:startTime	I
      //   133: aload_0
      //   134: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   137: invokestatic 93	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:b	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)I
      //   140: idiv
      //   141: putfield 96	ayvr$a:index	I
      //   144: aload_2
      //   145: invokevirtual 99	android/graphics/Bitmap:recycle	()V
      //   148: aload_0
      //   149: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   152: invokestatic 102	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Layvp;
      //   155: aload 4
      //   157: invokevirtual 107	ayvp:a	(Layvr$a;)V
      //   160: aload_0
      //   161: getfield 53	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$FrameFetchRunnable:this$0	Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
      //   164: invokestatic 110	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Ldov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/ConcurrentHashMap;
      //   167: aload_3
      //   168: getfield 40	dov/com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher$a:startTime	I
      //   171: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   174: invokevirtual 122	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   177: pop
      //   178: goto -125 -> 53
      //   181: astore_2
      //   182: ldc 28
      //   184: iconst_2
      //   185: ldc 124
      //   187: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   190: aload_2
      //   191: invokevirtual 130	java/lang/InterruptedException:printStackTrace	()V
      //   194: invokestatic 69	com/tencent/maxvideo/trim/TrimNative:release	()V
      //   197: return
      //   198: invokestatic 69	com/tencent/maxvideo/trim/TrimNative:release	()V
      //   201: return
      //   202: astore_2
      //   203: invokestatic 69	com/tencent/maxvideo/trim/TrimNative:release	()V
      //   206: aload_2
      //   207: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	208	0	this	FrameFetchRunnable
      //   96	2	1	bool	boolean
      //   34	111	2	localBitmap	android.graphics.Bitmap
      //   181	10	2	localInterruptedException	java.lang.InterruptedException
      //   202	5	2	localObject	Object
      //   21	147	3	locala	VideoFramesFetcher.a
      //   112	44	4	locala1	ayvr.a
      // Exception table:
      //   from	to	target	type
      //   21	35	181	java/lang/InterruptedException
      //   39	53	181	java/lang/InterruptedException
      //   53	97	181	java/lang/InterruptedException
      //   105	178	181	java/lang/InterruptedException
      //   21	35	202	finally
      //   39	53	202	finally
      //   53	97	202	finally
      //   105	178	202	finally
      //   182	194	202	finally
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
      this.endTime = Math.min(paramInt2, VideoFramesFetcher.a(VideoFramesFetcher.this));
      VideoFramesFetcher.a(VideoFramesFetcher.this).put(Integer.valueOf(paramInt1), this);
    }
    
    public int a(a parama)
    {
      return -(int)(this.lX - parama.lX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher
 * JD-Core Version:    0.7.0.1
 */