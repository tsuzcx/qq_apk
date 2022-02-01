package com.tencent.qqmail.utilities.imageextention;

import android.graphics.Bitmap;
import com.tencent.qqmail.utilities.thread.Threads;

class QMImageLoader$1
  implements QMImageLoaderTask.LoadImageTaskCallback
{
  QMImageLoader$1(QMImageLoader paramQMImageLoader, QMImageLoader.QMImageLoaderCallback paramQMImageLoaderCallback) {}
  
  public void doInBackground(QMImageLoaderTask paramQMImageLoaderTask)
  {
    Bitmap localBitmap = QMImageLoader.access$000(this.this$0).getImage(paramQMImageLoaderTask.key);
    if (localBitmap != null)
    {
      paramQMImageLoaderTask.result = localBitmap;
      return;
    }
    this.val$loaderCallback.loadImageInBackground(paramQMImageLoaderTask);
  }
  
  public void onFinishLoading(QMImageLoaderTask paramQMImageLoaderTask)
  {
    if (!QMImageLoader.access$100(this.this$0)) {
      return;
    }
    Threads.runOnMainThread(new QMImageLoader.1.1(this, paramQMImageLoaderTask));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.QMImageLoader.1
 * JD-Core Version:    0.7.0.1
 */