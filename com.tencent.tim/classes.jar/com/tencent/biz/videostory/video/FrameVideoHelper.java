package com.tencent.biz.videostory.video;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.Serializable;
import java.util.ArrayList;
import spp;
import sqr;

public class FrameVideoHelper
{
  private long Da;
  private long Db;
  private long Dc = ((Long)spp.a().getValue("SmartCutPicWidth", Long.valueOf(224L))).longValue();
  private long Dd;
  private long De = ((Long)spp.a().getValue("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private long Df;
  private sqr a;
  private int byE = 80;
  private volatile boolean isRun;
  private long mStartTime;
  private final long mVideoDuration;
  private final String mVideoPath;
  private ArrayList<FrameBuffer> os = new ArrayList();
  private long py = ((Long)spp.a().getValue("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  
  public FrameVideoHelper(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.mVideoPath = paramString;
    this.Da = paramInt1;
    this.Db = paramInt2;
    long l = paramLong;
    if (paramLong > 60000L) {
      l = 60000L;
    }
    this.mVideoDuration = l;
  }
  
  public void a(long paramLong, a parama)
  {
    if (this.isRun) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
    } while (parama == null);
    parama.a(false, null, -1L);
    return;
    this.Dd = 0L;
    this.Df = 0L;
    this.mStartTime = System.currentTimeMillis();
    this.isRun = true;
    ThreadManager.executeOnFileThread(new FrameVideoHelper.1(this, paramLong, parama));
  }
  
  public void a(a parama)
  {
    a(0L, parama);
  }
  
  public long eb()
  {
    return this.Df / 1000L;
  }
  
  public long getExecuteTime()
  {
    return this.Dd;
  }
  
  public void stop()
  {
    if (this.a != null) {
      this.a.release();
    }
    if (this.os != null) {
      this.os.clear();
    }
  }
  
  public static class FrameBuffer
    implements Serializable
  {
    private static final long serialVersionUID = 739662983371469000L;
    private final byte[] mData;
    
    public FrameBuffer(byte[] paramArrayOfByte)
    {
      this.mData = paramArrayOfByte;
    }
    
    public byte[] getData()
    {
      return this.mData;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper
 * JD-Core Version:    0.7.0.1
 */