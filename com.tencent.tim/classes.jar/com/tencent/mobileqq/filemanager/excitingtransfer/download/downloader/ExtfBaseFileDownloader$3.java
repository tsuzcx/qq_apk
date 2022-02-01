package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import agpj;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;

public class ExtfBaseFileDownloader$3
  implements Runnable
{
  public ExtfBaseFileDownloader$3(agpj paramagpj, int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo) {}
  
  public void run()
  {
    if (this.this$0.mIsStop) {
      return;
    }
    this.this$0.mIsStop = true;
    this.this$0.c(this.cYB, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */