package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

class TroopFileTransferManager$3
  implements Runnable
{
  TroopFileTransferManager$3(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    switch (this.a.Status)
    {
    default: 
      return;
    case 9: 
    case 10: 
      if (this.a.TmpFile != null) {
        new File(this.a.TmpFile).delete();
      }
      break;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new TroopFileTransferManager.3.1(this));
      return;
      if (this.a.LocalFile != null) {
        new File(this.a.LocalFile).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.3
 * JD-Core Version:    0.7.0.1
 */