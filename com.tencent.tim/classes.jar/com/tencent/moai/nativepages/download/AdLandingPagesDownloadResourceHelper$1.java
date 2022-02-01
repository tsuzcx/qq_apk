package com.tencent.moai.nativepages.download;

import com.tencent.moai.nativepages.util.Threads;

final class AdLandingPagesDownloadResourceHelper$1
  implements AdLandingPageDownloadFileTask.Callback
{
  AdLandingPagesDownloadResourceHelper$1(AdLandingPagesDownloadResourceHelper.Callback paramCallback, String paramString) {}
  
  public void onDownloadError()
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.1.2(this));
  }
  
  public void onDownloaded()
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.1.3(this));
  }
  
  public void onStartDownload()
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.1
 * JD-Core Version:    0.7.0.1
 */