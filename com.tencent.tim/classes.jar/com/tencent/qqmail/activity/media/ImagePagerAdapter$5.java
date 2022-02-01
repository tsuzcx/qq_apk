package com.tencent.qqmail.activity.media;

import android.view.View;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImagePagerAdapter$5
  implements AttachDownloadListener
{
  ImagePagerAdapter$5(ImagePagerAdapter paramImagePagerAdapter, View paramView, MediaItemInfo paramMediaItemInfo, String paramString, long paramLong) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    Threads.runOnMainThread(new ImagePagerAdapter.5.3(this, paramObject, paramString));
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    Threads.runOnMainThread(new ImagePagerAdapter.5.1(this, paramString, paramLong1, paramLong2));
  }
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    Threads.runOnMainThread(new ImagePagerAdapter.5.2(this, paramFile, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.5
 * JD-Core Version:    0.7.0.1
 */