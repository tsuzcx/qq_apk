package com.tencent.tim.cloudfile.troopFile;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;

class AutoRetryManager$2
  implements Runnable
{
  AutoRetryManager$2(AutoRetryManager paramAutoRetryManager, TroopFileCopyInfoEntity paramTroopFileCopyInfoEntity, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      TroopFileCopyInfoEntity localTroopFileCopyInfoEntity = this.a;
      if (localTroopFileCopyInfoEntity == null) {
        return;
      }
      AutoRetryManager.a(this.this$0).getTransaction().begin();
      if (this.cQm) {
        this.a.mStatus = 1;
      }
      this.a.lastRetryTime = NetConnInfoCenter.getServerTime();
      if (QLog.isDebugVersion()) {
        QLog.i("AutoRetryManager.TroopAutoSaveToCloud", 1, this.a.troopUin + ":" + this.a.strFileName + " copy[" + this.cQm + "]");
      }
      AutoRetryManager.a(this.this$0).update(this.a);
      AutoRetryManager.a(this.this$0).getTransaction().commit();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AutoRetryManager.TroopAutoSaveToCloud", 1, "saveDB failed exception:  " + localException.toString());
      return;
    }
    finally
    {
      AutoRetryManager.a(this.this$0).getTransaction().end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.troopFile.AutoRetryManager.2
 * JD-Core Version:    0.7.0.1
 */