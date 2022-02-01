package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;

class SPlayerPreDownloaderImpl$1
  implements Runnable
{
  SPlayerPreDownloaderImpl$1(SPlayerPreDownloaderImpl paramSPlayerPreDownloaderImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    LogUtil.d(SPlayerPreDownloaderImpl.TAG, "stopPreDownload() taskIdForTPProxy=" + this.val$taskid);
    SPlayerPreDownloaderImpl.access$000(this.this$0).stopPreload(this.val$taskIdForTPProxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */