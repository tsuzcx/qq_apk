import android.content.Context;
import android.support.annotation.WorkerThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class olh
  extends old
{
  private olc a;
  private int aVX;
  private String aqj;
  private String aqk;
  private int bfo;
  private volatile ArrayList<Integer> lw;
  private Context mContext;
  private long mFileSize;
  private boolean mIsSeeking;
  private long mLastPlayPosition;
  private final Object mLock = new Object();
  private AtomicInteger mState = new AtomicInteger(0);
  private long mVideoDuration;
  private Object tag;
  private long vF;
  private long vG = -1L;
  private long xd;
  private long xe;
  private long xf;
  private long yR;
  private long yS;
  
  public olh(Context paramContext)
  {
    this.mContext = paramContext;
    initMediaPlayer();
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    return false;
  }
  
  private void aTP() {}
  
  private void aTQ() {}
  
  public boolean Hb()
  {
    return this.mState.get() == 0;
  }
  
  public void a(olc paramolc)
  {
    this.a = paramolc;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public void aTU()
  {
    this.mIsSeeking = false;
    this.mVideoDuration = 0L;
    this.xd = 0L;
    this.mLastPlayPosition = 0L;
    this.xe = 0L;
    this.xf = 0L;
    this.aVX = 0;
    this.vF = 0L;
    this.mFileSize = 0L;
    this.vG = -1L;
    this.yS = 0L;
    this.yR = 0L;
    this.aqj = "";
    this.aqk = "";
    synchronized (this.mLock)
    {
      this.lw = null;
      return;
    }
  }
  
  public void bfH()
  {
    this.yR = c(false);
  }
  
  public void bfI()
  {
    this.xd = (c(true) + this.xd);
  }
  
  public void bfJ()
  {
    this.mLastPlayPosition = 0L;
  }
  
  public long c(boolean paramBoolean)
  {
    long l2 = this.xd;
    if (paramBoolean) {}
    for (long l1 = getDuration(); l1 - this.mLastPlayPosition > 0L; l1 = getCurrentPosition()) {
      return l1 - this.mLastPlayPosition + l2;
    }
    return l2;
  }
  
  public long dd()
  {
    return this.xf;
  }
  
  public void destroy()
  {
    destroy(true);
  }
  
  public void destroy(boolean paramBoolean) {}
  
  public long df()
  {
    if (this.vG == -1L) {}
    synchronized (this.mLock)
    {
      if ((this.lw != null) && (this.lw.size() > 0))
      {
        int k = Math.min(10, this.lw.size());
        int i = 0;
        int j = 0;
        while (i < k)
        {
          j += ((Integer)this.lw.get(i)).intValue();
          i += 1;
        }
        if (k != 0) {
          this.vG = (j / k);
        }
      }
      return this.vG;
    }
  }
  
  public long dg()
  {
    long l2 = -1L;
    Object localObject1 = this.mLock;
    long l1 = l2;
    label111:
    label118:
    for (;;)
    {
      int i;
      try
      {
        if (this.lw != null)
        {
          l1 = l2;
          if (this.lw.size() > 0)
          {
            int j = this.lw.size();
            i = 0;
            l1 = -1L;
            if (i >= j) {
              break label118;
            }
            int k = ((Integer)this.lw.get(i)).intValue();
            if (i == 0)
            {
              l1 = k;
              break label111;
            }
            l1 = Math.min(k, l1);
            break label111;
          }
        }
        return l1;
      }
      finally {}
      i += 1;
    }
  }
  
  public long dh()
  {
    long l2 = -1L;
    Object localObject1 = this.mLock;
    long l1 = l2;
    label111:
    label118:
    for (;;)
    {
      int i;
      try
      {
        if (this.lw != null)
        {
          l1 = l2;
          if (this.lw.size() > 0)
          {
            int j = this.lw.size();
            i = 0;
            l1 = -1L;
            if (i >= j) {
              break label118;
            }
            int k = ((Integer)this.lw.get(i)).intValue();
            if (i == 0)
            {
              l1 = k;
              break label111;
            }
            l1 = Math.max(k, l1);
            break label111;
          }
        }
        return l1;
      }
      finally {}
      i += 1;
    }
  }
  
  public long dq()
  {
    long l2 = 0L;
    long l3 = this.vF;
    long l1 = l2;
    if (l3 > 0L)
    {
      l1 = l2;
      if (this.yS > 0L) {
        l1 = this.yS / l3;
      }
    }
    return l1;
  }
  
  public void dx(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      aTP();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      ooz.bY("WS_VIDEO_PLAYER", "[VideoPlayerWrapper.java][removeVideoViewFromParent] remove scroll view parents!");
      aTQ();
    }
  }
  
  public long e(boolean paramBoolean)
  {
    return c(paramBoolean) - this.yR;
  }
  
  public long getCurrentPosition()
  {
    return 0L;
  }
  
  public long getDuration()
  {
    return -1L;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public Object getTag()
  {
    return this.tag;
  }
  
  public long getVideoBitRate()
  {
    return this.vF;
  }
  
  public int getVideoHeight()
  {
    return -1;
  }
  
  public int getVideoWidth()
  {
    return -1;
  }
  
  public void initMediaPlayer() {}
  
  public boolean isPause()
  {
    return false;
  }
  
  public boolean isPlaying()
  {
    return false;
  }
  
  public boolean isReady()
  {
    return this.mState.get() == 2;
  }
  
  public boolean isSeeking()
  {
    return this.mIsSeeking;
  }
  
  public String ky()
  {
    for (;;)
    {
      int i;
      synchronized (this.mLock)
      {
        if ((this.lw != null) && (this.lw.size() > 0))
        {
          Object localObject2 = new StringBuilder();
          int j = Math.min(20, this.lw.size());
          i = 0;
          if (i < j)
          {
            ((StringBuilder)localObject2).append(((Integer)this.lw.get(i)).intValue());
            if (i != j - 1) {
              ((StringBuilder)localObject2).append(",");
            }
          }
          else
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            return localObject2;
          }
        }
        else
        {
          return "";
        }
      }
      i += 1;
    }
  }
  
  public String lA()
  {
    return this.aqj;
  }
  
  public String lz()
  {
    return this.aqk;
  }
  
  public void pause() {}
  
  public int qe()
  {
    return this.mState.get();
  }
  
  public int qf()
  {
    return this.aVX;
  }
  
  public int rB()
  {
    return this.bfo;
  }
  
  public void resumeDownload() {}
  
  public void seekTo(int paramInt) {}
  
  public void setLoopback(boolean paramBoolean) {}
  
  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  public void start() {}
  
  @WorkerThread
  public void stop() {}
  
  public void stopDownload() {}
  
  public void uL(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olh
 * JD-Core Version:    0.7.0.1
 */