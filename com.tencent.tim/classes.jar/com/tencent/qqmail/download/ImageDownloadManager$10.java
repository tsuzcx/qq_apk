package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;

class ImageDownloadManager$10
  implements Runnable
{
  ImageDownloadManager$10(ImageDownloadManager paramImageDownloadManager, DownloadInfo paramDownloadInfo, String paramString) {}
  
  public void run()
  {
    if (this.val$info.getImageDownloadListener() != null) {
      this.val$info.getImageDownloadListener().onErrorInMainThread(this.val$url, "fromDisk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.10
 * JD-Core Version:    0.7.0.1
 */