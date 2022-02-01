package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ImageDownloadManager$1$1
  implements Runnable
{
  ImageDownloadManager$1$1(ImageDownloadManager.1 param1) {}
  
  public void run()
  {
    if (this.this$1.val$info.getImageDownloadListener() != null) {
      this.this$1.val$info.getImageDownloadListener().onErrorInMainThread(this.this$1.val$url, new QMNetworkError(-1, -10009));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.1.1
 * JD-Core Version:    0.7.0.1
 */