package com.tencent.TMG.ptt;

import android.util.Log;
import com.tencent.TMG.utils.CosFileTransfer;

class PttManager$2
  implements TokenFetcher.GetDownloadTokenListener
{
  PttManager$2(PttManager paramPttManager, String paramString1, PttListener.DownloadFileListener paramDownloadFileListener, String paramString2) {}
  
  public void onCompleted(int paramInt, String paramString, TokenFetcher.DownloadInfo paramDownloadInfo)
  {
    if ((paramInt == 0) && (paramDownloadInfo != null)) {
      CosFileTransfer.downloadFile(paramDownloadInfo.file_url, this.val$savePath, paramDownloadInfo.token, null, new PttManager.2.1(this));
    }
    do
    {
      return;
      Log.e("PTTManager", "downloadFile|get download file token failed");
    } while (this.val$monitor == null);
    this.val$monitor.onCompleted(paramInt, this.val$savePath, this.val$downloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.2
 * JD-Core Version:    0.7.0.1
 */