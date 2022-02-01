package com.tencent.mobileqq.troop.filemanager.thumbnail;

import apef.b;
import aqhq;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

class TroopFileThumbnailGenTask$1
  implements Runnable
{
  TroopFileThumbnailGenTask$1(TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.bkn)
    {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.this$0.coy + "] passiveEnd. but had stop");
      return;
    }
    if (!this.cQm)
    {
      this.this$0.bY(this.val$errCode, true);
      return;
    }
    this.this$0.mFilePath = this.this$0.c.getThumbnailFile(this.this$0.mTroopUin, this.this$0.bYf);
    if (this.this$0.mFilePath.equalsIgnoreCase(this.aJL))
    {
      apef.b.w("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.this$0.coy + "] passiveSuc thumbpath is same.");
      this.this$0.cy(true, true);
      return;
    }
    apef.b.i("TroopFileThumbnailGenTask", apef.b.USR, "[" + this.this$0.coy + "] passiveSuc copy file.");
    this.this$0.mTmpFilePath = (this.this$0.mFilePath + ".ttmp");
    aqhq.copyFile(this.aJL, this.this$0.mTmpFilePath);
    this.this$0.cy(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask.1
 * JD-Core Version:    0.7.0.1
 */