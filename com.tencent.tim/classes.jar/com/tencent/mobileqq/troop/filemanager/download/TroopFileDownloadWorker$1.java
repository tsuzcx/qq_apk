package com.tencent.mobileqq.troop.filemanager.download;

import ahbj;
import apef.b;
import apey;
import aqhs;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.MD5;

public class TroopFileDownloadWorker$1
  implements Runnable
{
  public TroopFileDownloadWorker$1(apey paramapey) {}
  
  public void run()
  {
    if (this.this$0.bkn)
    {
      apef.b.w("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] start. had stoped");
      return;
    }
    this.this$0.aAV();
    String str = MD5.toMD5(this.this$0.c.FilePath);
    this.this$0.mTmpFilePath = (this.this$0.coz + str);
    str = this.this$0.coz + aqhs.bytes2HexStr(this.this$0.c.FilePath.getBytes()) + ".tmp";
    if (ahbj.getFileSize(str) > 0L)
    {
      apef.b.w("TroopFileDownloadWorker", apef.b.USR, "[" + this.this$0.coy + "] start. use oldVerTmpPath to resume.");
      this.this$0.mTmpFilePath = str;
    }
    this.this$0.c.TmpFile = this.this$0.mTmpFilePath;
    this.this$0.dYW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadWorker.1
 * JD-Core Version:    0.7.0.1
 */