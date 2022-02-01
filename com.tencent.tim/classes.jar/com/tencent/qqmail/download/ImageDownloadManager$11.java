package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;

class ImageDownloadManager$11
  implements Runnable
{
  ImageDownloadManager$11(ImageDownloadManager paramImageDownloadManager, String paramString, ImageDownloadListener paramImageDownloadListener) {}
  
  public void run()
  {
    Threads.runOnMainThread(new ImageDownloadManager.11.1(this, ImageUtil.fixImageOrientation(this.val$url)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.11
 * JD-Core Version:    0.7.0.1
 */