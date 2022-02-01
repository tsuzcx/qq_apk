package com.tencent.mobileqq.bigbrother.RockDownloader;

import adxb;
import adxc;
import com.tencent.mobileqq.data.RockDownloadInfo;

public class RockDownloaderManager$2
  implements Runnable
{
  public void run()
  {
    adxc.a(new RockDownloadInfo("biz_src_kandian", "com.tencent.now"), new adxb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.2
 * JD-Core Version:    0.7.0.1
 */