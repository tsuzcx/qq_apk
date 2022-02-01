package com.tencent.smtt.sdk;

import android.content.Context;

final class QbSdk$4
  implements TbsDownloader.TbsDownloaderCallback
{
  QbSdk$4(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if ((TbsShareManager.findCoreForThirdPartyApp(this.a) == 0) && (!TbsShareManager.getCoreDisabled())) {
      TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
    }
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(this.a))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
    }
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.4
 * JD-Core Version:    0.7.0.1
 */