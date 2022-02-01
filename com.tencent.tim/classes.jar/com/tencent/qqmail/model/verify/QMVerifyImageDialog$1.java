package com.tencent.qqmail.model.verify;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;

class QMVerifyImageDialog$1
  implements ImageDownloadListener
{
  QMVerifyImageDialog$1(QMVerifyImageDialog paramQMVerifyImageDialog, ImageDownloadListener paramImageDownloadListener, QMVerifyImageDialog.SendVeifyCallBack paramSendVeifyCallBack) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    if (this.val$imageDownloadListener != null) {
      this.val$imageDownloadListener.onErrorInMainThread(paramString, paramObject);
    }
    QMVerifyImageDialog.access$000(this.this$0, null, null);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.val$imageDownloadListener != null) {
      this.val$imageDownloadListener.onSuccessInMainThread(paramString1, paramBitmap, paramString2);
    }
    QMVerifyImageDialog.access$000(this.this$0, paramBitmap, this.val$sendVeifyCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.verify.QMVerifyImageDialog.1
 * JD-Core Version:    0.7.0.1
 */