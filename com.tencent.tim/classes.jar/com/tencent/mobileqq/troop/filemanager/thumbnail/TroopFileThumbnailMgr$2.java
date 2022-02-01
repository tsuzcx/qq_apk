package com.tencent.mobileqq.troop.filemanager.thumbnail;

import ahbj;
import apfp;
import apfq;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileThumbnailMgr$2
  implements Runnable
{
  public TroopFileThumbnailMgr$2(apfq paramapfq, TroopFileTransferManager.Item paramItem, long paramLong, int paramInt) {}
  
  public void run()
  {
    String str = this.a.getThumbnailFile(this.Hg, 640);
    if (ahbj.fileExistsAndNotEmpty(str)) {
      apfq.a(this.this$0).a(this.Hg, this.a, this.dTY, str);
    }
    while ((this.a.LocalFile == null) || (!new VFSFile(this.a.LocalFile).exists())) {
      return;
    }
    apfq.a(this.this$0).a(this.Hg, this.a, this.dTY, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailMgr.2
 * JD-Core Version:    0.7.0.1
 */