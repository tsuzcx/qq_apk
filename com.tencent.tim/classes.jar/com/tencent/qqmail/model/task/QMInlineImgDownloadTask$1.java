package com.tencent.qqmail.model.task;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class QMInlineImgDownloadTask$1
  implements ImageDownloadListener
{
  QMInlineImgDownloadTask$1(QMInlineImgDownloadTask paramQMInlineImgDownloadTask) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    this.this$0.handleError(paramObject);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2)
  {
    this.this$0.handleRunning(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMInlineImgDownloadTask.access$000(this.this$0, paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMInlineImgDownloadTask.1
 * JD-Core Version:    0.7.0.1
 */