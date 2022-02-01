package com.tencent.qqmail.download;

import com.tencent.moai.downloader.file.DownloadFileUtil;
import com.tencent.qqmail.download.model.DownloadInfo;

class DownloadInfoManager$1
  implements Runnable
{
  DownloadInfoManager$1(DownloadInfoManager paramDownloadInfoManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (DownloadFileUtil.delete(this.val$downloadInfo.getFilePath())) {
      this.this$0.deleteDownloadInfoById(this.val$downloadInfo.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.DownloadInfoManager.1
 * JD-Core Version:    0.7.0.1
 */