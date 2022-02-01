package com.tencent.mobileqq.troop.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class TroopFileTransferManager$3$1
  implements Runnable
{
  TroopFileTransferManager$3$1(TroopFileTransferManager.3 param3) {}
  
  public void run()
  {
    synchronized (this.a.this$0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileTransferManager", 1, Thread.currentThread().getName() + "removeitem:[" + this.a.a.Id + "]");
      }
      this.a.this$0.nC.remove(this.a.a.Id);
      this.a.a.ErrorCode = 0;
      this.a.a.LocalFile = null;
      this.a.this$0.c(this.a.a, 7);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.3.1
 * JD-Core Version:    0.7.0.1
 */