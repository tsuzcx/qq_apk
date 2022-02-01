package com.tencent.moai.nativepages.download;

import com.tencent.moai.nativepages.util.Threads;

final class AdLandingPagesDownloadResourceHelper$3
  implements AdLandingPageDownloadVideoTask.Callback
{
  AdLandingPagesDownloadResourceHelper$3(AdLandingPagesDownloadResourceHelper.StreamVideoDownloadCallback paramStreamVideoDownloadCallback) {}
  
  public void onFail(String paramString)
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.3.2(this, paramString));
  }
  
  public void onFinish(String paramString)
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.3.3(this, paramString));
  }
  
  public void onProgress(String paramString, int paramInt)
  {
    Threads.runOnMainThread(new AdLandingPagesDownloadResourceHelper.3.1(this, paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.download.AdLandingPagesDownloadResourceHelper.3
 * JD-Core Version:    0.7.0.1
 */