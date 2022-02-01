package com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader;

import agpy;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;

public class ExtfBaseFileUploader$3
  implements Runnable
{
  public ExtfBaseFileUploader$3(agpy paramagpy, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void run()
  {
    if (this.this$0.mIsStop) {
      return;
    }
    this.this$0.mIsStop = true;
    this.this$0.c(this.cYB, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfBaseFileUploader.3
 * JD-Core Version:    0.7.0.1
 */