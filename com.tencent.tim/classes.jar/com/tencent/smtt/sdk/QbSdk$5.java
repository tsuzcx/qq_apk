package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class QbSdk$5
  implements TbsListener
{
  public void onDownloadFinish(int paramInt)
  {
    if (TbsDownloader.needDownloadDecoupleCore())
    {
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
      TbsDownloader.a = true;
    }
    do
    {
      return;
      TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
      TbsDownloader.a = false;
      if ((paramInt != 100) || (QbSdk.c() != null)) {
        QbSdk.c().onDownloadFinish(paramInt);
      }
    } while (QbSdk.d() == null);
    QbSdk.d().onDownloadFinish(paramInt);
  }
  
  public void onDownloadProgress(int paramInt)
  {
    if (QbSdk.d() != null) {
      QbSdk.d().onDownloadProgress(paramInt);
    }
    if (QbSdk.c() != null) {
      QbSdk.c().onDownloadProgress(paramInt);
    }
  }
  
  public void onInstallFinish(int paramInt)
  {
    if ((paramInt != 200) && (paramInt == 220)) {}
    TbsLog.i("QbSdk", "onInstallFinish errCode is " + paramInt, true);
    QbSdk.setTBSInstallingStatus(false);
    TbsDownloader.a = false;
    if (TbsDownloader.startDecoupleCoreIfNeeded()) {}
    for (TbsDownloader.a = true;; TbsDownloader.a = false)
    {
      if (QbSdk.c() != null) {
        QbSdk.c().onInstallFinish(paramInt);
      }
      if (QbSdk.d() != null) {
        QbSdk.d().onInstallFinish(paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.5
 * JD-Core Version:    0.7.0.1
 */