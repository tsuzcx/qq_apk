package com.tencent.moai.nativepages.download;

import com.tencent.moai.nativepages.util.Threads;

final class AdLandingPagesDownloadResourceHelper$2
  implements AdLandingPageDownloadFileTask.Callback
{
  AdLandingPagesDownloadResourceHelper$2(AdLandingPagesDownloadResourceHelper.Callback paramCallback, String paramString) {}
  
  public void onDownloadError()
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.2.2(this));
  }
  
  public void onDownloaded()
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.2.3(this));
  }
  
  public void onStartDownload()
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.2
 * JD-Core Version:    0.7.0.1
 */