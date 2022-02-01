package com.tencent.mobileqq.activity;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

class TroopInviteStatusFragment$2
  implements Runnable
{
  TroopInviteStatusFragment$2(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    ((acms)this.this$0.mApp.getBusinessHandler(20)).i(this.this$0.troopCode, this.this$0.aQy, this.this$0.msgSeq);
    TroopManager localTroopManager = (TroopManager)this.this$0.mApp.getManager(52);
    if (localTroopManager != null) {
      this.this$0.troopInfo = localTroopManager.b(this.this$0.troopCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.2
 * JD-Core Version:    0.7.0.1
 */