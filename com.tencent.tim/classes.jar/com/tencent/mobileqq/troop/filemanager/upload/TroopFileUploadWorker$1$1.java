package com.tencent.mobileqq.troop.filemanager.upload;

import apgb;
import apgc;
import apsd.a;
import apue.a;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileUploadWorker$1$1
  implements Runnable
{
  public TroopFileUploadWorker$1$1(apgc paramapgc, long paramLong) {}
  
  public void run()
  {
    if (this.a.this$0.bkn) {
      return;
    }
    apsd.a locala = new apsd.a(this.a.this$0.c.FileName, this.Hg, 3, 210);
    this.a.this$0.a.resultCode = 1;
    this.a.this$0.a.dTI = -36;
    this.a.this$0.a(false, apue.a.dVZ, -36, locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker.1.1
 * JD-Core Version:    0.7.0.1
 */