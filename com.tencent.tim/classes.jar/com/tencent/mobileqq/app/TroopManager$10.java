package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

class TroopManager$10
  implements Runnable
{
  TroopManager$10(TroopManager paramTroopManager, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.this$0.c(this.Uf, this.aMs);
    ThreadManager.getUIHandler().post(new TroopManager.10.1(this, localTroopMemberInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.10
 * JD-Core Version:    0.7.0.1
 */