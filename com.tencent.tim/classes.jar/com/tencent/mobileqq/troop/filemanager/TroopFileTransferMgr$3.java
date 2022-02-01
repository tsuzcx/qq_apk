package com.tencent.mobileqq.troop.filemanager;

import apdz;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFileTransferMgr$3
  implements Runnable
{
  public TroopFileTransferMgr$3(apdz paramapdz, TroopFileTransferManager.Item paramItem, UUID paramUUID) {}
  
  public void run()
  {
    switch (this.a.Status)
    {
    default: 
      return;
    case 9: 
    case 10: 
      if (this.a.TmpFile != null) {
        new VFSFile(this.a.TmpFile).delete();
      }
      break;
    }
    for (;;)
    {
      this.this$0.a(this.e, true);
      this.a.StatusUpdateTimeMs = 0L;
      this.a.ErrorCode = 0;
      this.a.LocalFile = null;
      this.this$0.c(this.a, 7);
      return;
      if (this.a.LocalFile != null) {
        new VFSFile(this.a.LocalFile).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.3
 * JD-Core Version:    0.7.0.1
 */