package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class RetrieverDecodeRunnable
  extends DecodeRunnable
{
  public RetrieverDecodeRunnable(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, DecodeRunnable.a parama)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, parama);
  }
  
  private void eTi()
  {
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever1 = new MediaMetadataRetriever();
        try
        {
          localMediaMetadataRetriever1.setDataSource(this.mVideoPath);
          this.mFrameIndex = -1;
          if (QLog.isColorLevel()) {
            QLog.d("VFLDecodeRunnable", 2, "runWithRetriever, start");
          }
          localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
          if (Thread.interrupted()) {
            continue;
          }
          localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
          if (isStop()) {
            continue;
          }
          localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
          if (this.mFrameIndex >= this.mFrameCount - 1) {
            continue;
          }
          l = jb();
          Bitmap localBitmap1 = localMediaMetadataRetriever1.getFrameAtTime(l, 3);
          if (localBitmap1 != null) {
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VFLDecodeRunnable", 2, "runWithRetriever return null! time:" + l);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        MediaMetadataRetriever localMediaMetadataRetriever2;
        long l;
        Bitmap localBitmap2;
        MediaMetadataRetriever localMediaMetadataRetriever1 = null;
        continue;
      }
      localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
      if (QLog.isColorLevel())
      {
        QLog.d("VFLDecodeRunnable", 2, "runWithRetriever Load video frame execption:" + localException1);
        localMediaMetadataRetriever2 = localMediaMetadataRetriever1;
      }
      if (localMediaMetadataRetriever2 != null) {
        localMediaMetadataRetriever2.release();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "runWithRetriever, end");
      }
      return;
      localBitmap2 = ad(localException1);
      a(this.mFrameIndex, l, localBitmap2);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VFLDecodeRunnable", 2, "RetrieverDecodeRunnable run");
    }
    onDecodeStart();
    if ((TextUtils.isEmpty(this.mVideoPath)) || (this.mFrameHeight <= 0) || (this.mFrameWidth <= 0) || (this.mEndTime - this.mStartTime <= 0L) || (this.mFrameCount <= 0))
    {
      this.mStop = true;
      afs(1);
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "Retriever param error, path:" + this.mVideoPath + " height:" + this.mFrameHeight + " width:" + this.mFrameWidth + "time:" + this.mStartTime + "-" + this.mEndTime + " Count:" + this.mFrameCount);
      }
      return;
    }
    eTi();
    ZJ(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.RetrieverDecodeRunnable
 * JD-Core Version:    0.7.0.1
 */