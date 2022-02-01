package com.tencent.biz.pubaccount.NativeAd.module;

import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.open.downloadnew.DownloadInfo;
import jyy;

public class AdModuleBase$6
  implements Runnable
{
  public AdModuleBase$6(jyy paramjyy, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.this$0.b != null) {
      this.this$0.b.setProgress(this.a.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.6
 * JD-Core Version:    0.7.0.1
 */