package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;

class ImageDownloadManager$8
  implements Runnable
{
  ImageDownloadManager$8(ImageDownloadManager paramImageDownloadManager, ImageDownloadListener paramImageDownloadListener, String paramString) {}
  
  public void run()
  {
    if (this.val$listener != null) {
      this.val$listener.onErrorInMainThread(this.val$url, "fromDisk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.8
 * JD-Core Version:    0.7.0.1
 */