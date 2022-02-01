package com.tencent.qqmini.miniapp.receiver;

import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.smtt.sdk.TbsDownloader;

class WebProcessReceiver$1
  implements Runnable
{
  WebProcessReceiver$1(WebProcessReceiver paramWebProcessReceiver, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    WebProcessReceiver localWebProcessReceiver;
    boolean bool2;
    if (TbsDownloader.needDownload(AppLoaderFactory.g().getContext(), this.val$isDownloadForeground))
    {
      localWebProcessReceiver = this.this$0;
      bool2 = this.val$isDownloadForeground;
      if (this.val$fromMiniApp) {
        break label43;
      }
    }
    label43:
    for (boolean bool1 = true;; bool1 = false)
    {
      localWebProcessReceiver.downloadTbs(false, bool2, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.1
 * JD-Core Version:    0.7.0.1
 */