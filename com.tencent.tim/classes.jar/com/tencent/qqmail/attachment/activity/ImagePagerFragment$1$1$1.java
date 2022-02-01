package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImagePagerFragment$1$1$1
  implements AttachDownloadListener
{
  ImagePagerFragment$1$1$1(ImagePagerFragment.1.1 param1) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    Threads.runOnMainThread(new ImagePagerFragment.1.1.1.2(this));
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    Threads.runOnMainThread(new ImagePagerFragment.1.1.1.1(this, paramFile));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */