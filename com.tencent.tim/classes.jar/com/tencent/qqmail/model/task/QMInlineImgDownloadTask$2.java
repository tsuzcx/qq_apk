package com.tencent.qqmail.model.task;

import com.tencent.qqmail.model.mail.loader.ProtocolInlineImgCallback;

class QMInlineImgDownloadTask$2
  implements ProtocolInlineImgCallback
{
  QMInlineImgDownloadTask$2(QMInlineImgDownloadTask paramQMInlineImgDownloadTask) {}
  
  public void onError(Object paramObject)
  {
    this.this$0.handleError(paramObject);
  }
  
  public boolean onProgress(long paramLong1, long paramLong2)
  {
    if (QMInlineImgDownloadTask.access$100(this.this$0)) {
      return true;
    }
    this.this$0.handleRunning(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    return false;
  }
  
  public void onSuccess(String paramString)
  {
    QMInlineImgDownloadTask.access$000(this.this$0, paramString, this.this$0.getSrc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMInlineImgDownloadTask.2
 * JD-Core Version:    0.7.0.1
 */