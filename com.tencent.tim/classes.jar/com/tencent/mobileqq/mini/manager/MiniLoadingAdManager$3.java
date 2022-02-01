package com.tencent.mobileqq.mini.manager;

import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;

final class MiniLoadingAdManager$3
  implements Runnable
{
  MiniLoadingAdManager$3(MiniLoadingAdManager.CachedAdInfo paramCachedAdInfo) {}
  
  public void run()
  {
    MiniappDownloadUtil.getInstance().download(MiniLoadingAdManager.CachedAdInfo.access$400(this.val$cachedAdInfo), MiniLoadingAdManager.CachedAdInfo.access$500(this.val$cachedAdInfo), false, MiniLoadingAdManager.CachedAdInfo.access$600(this.val$cachedAdInfo), Downloader.DownloadMode.OkHttpMode, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.3
 * JD-Core Version:    0.7.0.1
 */