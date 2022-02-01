package com.tencent.qqmail.attachment.activity;

import android.view.View;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImagePagerFragment$5
  implements AttachDownloadListener
{
  ImagePagerFragment$5(ImagePagerFragment paramImagePagerFragment) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    Threads.runOnMainThread(new ImagePagerFragment.5.3(this));
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    Threads.runOnMainThread(new ImagePagerFragment.5.1(this, paramString, paramLong1, paramLong2));
  }
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    ImagePagerFragment.access$200(this.this$0).post(new ImagePagerFragment.5.2(this, paramFile));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.5
 * JD-Core Version:    0.7.0.1
 */