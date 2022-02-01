package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;

class ImageDownloadManager$6$1
  implements Runnable
{
  ImageDownloadManager$6$1(ImageDownloadManager.6 param6, String paramString, Object paramObject) {}
  
  public void run()
  {
    if (this.this$1.val$info.getImageDownloadListener() != null) {
      this.this$1.val$info.getImageDownloadListener().onErrorInMainThread(this.val$url, this.val$error);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.6.1
 * JD-Core Version:    0.7.0.1
 */