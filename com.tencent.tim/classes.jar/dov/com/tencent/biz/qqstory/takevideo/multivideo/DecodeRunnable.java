package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class DecodeRunnable
  implements Runnable
{
  protected double dy;
  protected long mEndTime;
  protected int mFrameCount;
  protected int mFrameHeight;
  protected int mFrameIndex = -1;
  protected long mFrameTime;
  protected int mFrameWidth;
  protected WeakReference<a> mListenerRef;
  protected int mRotation;
  protected long mStartTime;
  protected boolean mStop;
  protected String mVideoPath;
  
  public DecodeRunnable(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, a parama)
  {
    this.mListenerRef = new WeakReference(parama);
    this.mVideoPath = paramString;
    this.mStartTime = (1000L * paramLong1);
    this.mEndTime = (1000L * paramLong2);
    this.mFrameWidth = paramInt1;
    this.mFrameHeight = paramInt2;
    this.mFrameCount = paramInt3;
    this.mRotation = paramInt4;
    this.mStop = false;
    this.mFrameTime = 0L;
    this.mFrameIndex = -1;
    if (QLog.isColorLevel()) {
      QLog.d("VFLDecodeRunnable", 2, "decode param, path:" + this.mVideoPath + " framesize:" + this.mFrameWidth + "-" + this.mFrameHeight + " framecount:" + this.mFrameCount + " rotation:" + this.mRotation + "range:" + this.mStartTime + "-" + this.mEndTime);
    }
    if ((this.mEndTime - this.mStartTime <= 0L) || (this.mFrameCount <= 0))
    {
      afs(1);
      return;
    }
    this.dy = ((float)(this.mEndTime - this.mStartTime) * 1.0F / (this.mFrameCount - 1));
  }
  
  protected void ZJ(boolean paramBoolean)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.ZJ(paramBoolean);
      }
    }
  }
  
  protected void a(int paramInt, long paramLong, Bitmap paramBitmap)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.a(paramInt, paramLong, paramBitmap);
      }
    }
  }
  
  public Bitmap ad(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new Matrix();
    if (this.mRotation % 180 != 0)
    {
      float f1 = this.mFrameWidth / paramBitmap.getHeight();
      float f2 = this.mFrameHeight / paramBitmap.getWidth();
      ((Matrix)localObject).postRotate(this.mRotation);
      ((Matrix)localObject).postScale(f1, f2);
    }
    for (;;)
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      paramBitmap.recycle();
      return localObject;
      ((Matrix)localObject).postScale(this.mFrameWidth / paramBitmap.getWidth(), this.mFrameHeight / paramBitmap.getHeight());
    }
  }
  
  protected void afs(int paramInt)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.afs(paramInt);
      }
    }
  }
  
  public boolean isStop()
  {
    return this.mStop;
  }
  
  protected long jb()
  {
    if (this.mFrameIndex < this.mFrameCount) {
      this.mFrameIndex += 1;
    }
    this.mFrameTime = ((this.mFrameIndex * this.dy));
    this.mFrameTime += this.mStartTime;
    if (this.mFrameTime < 0L) {
      this.mFrameTime = 0L;
    }
    for (;;)
    {
      return this.mFrameTime;
      if (this.mFrameTime > this.mEndTime) {
        this.mFrameTime = this.mEndTime;
      }
    }
  }
  
  protected void oR(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    a locala;
    do
    {
      do
      {
        return;
      } while (this.mListenerRef == null);
      locala = (a)this.mListenerRef.get();
    } while (locala == null);
    locala.oR(paramList);
  }
  
  protected void onDecodeStart()
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.onDecodeStart();
      }
    }
  }
  
  public void stop()
  {
    this.mStop = true;
  }
  
  public static abstract interface a
  {
    public abstract void ZJ(boolean paramBoolean);
    
    public abstract void a(int paramInt, long paramLong, Bitmap paramBitmap);
    
    public abstract void afs(int paramInt);
    
    public abstract void oR(List<Long> paramList);
    
    public abstract void onDecodeStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */