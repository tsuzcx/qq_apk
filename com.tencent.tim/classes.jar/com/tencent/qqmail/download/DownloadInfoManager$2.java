package com.tencent.qqmail.download;

import com.tencent.qqmail.download.model.DownloadInfo;
import java.io.File;

class DownloadInfoManager$2
  implements Runnable
{
  DownloadInfoManager$2(DownloadInfoManager paramDownloadInfoManager, File paramFile, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    if (this.val$file.renameTo(new File(this.val$renamePath))) {
      this.this$0.deleteDownloadInfoById(this.val$downloadInfo.getId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.DownloadInfoManager.2
 * JD-Core Version:    0.7.0.1
 */