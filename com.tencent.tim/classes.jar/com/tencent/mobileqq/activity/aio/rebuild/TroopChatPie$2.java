package com.tencent.mobileqq.activity.aio.rebuild;

import anot;
import apuf;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Iterator;
import java.util.List;

class TroopChatPie$2
  implements Runnable
{
  TroopChatPie$2(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.app.getManager(52);
    Object localObject = localTroopManager.al(this.this$0.sessionInfo.aTl);
    long l;
    TroopMemberInfo localTroopMemberInfo;
    if (localObject != null)
    {
      l = NetConnInfoCenter.getServerTime();
      localObject = ((List)localObject).iterator();
      l += 2592000L;
      if (((Iterator)localObject).hasNext())
      {
        localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject).next();
        if ((localTroopMemberInfo.mUniqueTitleExpire > 0) && (localTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime() < 259200L) && (!localTroopManager.aB(this.this$0.sessionInfo.aTl, localTroopMemberInfo.memberuin)))
        {
          ((apuf)this.this$0.app.getManager(81)).a(this.this$0.sessionInfo.aTl, this.this$0.a(localTroopMemberInfo), NetConnInfoCenter.getServerTime(), localTroopMemberInfo.mUniqueTitleExpire, 0, 1);
          localTroopManager.F(this.this$0.sessionInfo.aTl, localTroopMemberInfo.memberuin, true);
          anot.a(this.this$0.app, "P_CliOper", "Grp_manage", "", "grp_aio", "exp_expire", 0, 0, this.this$0.sessionInfo.aTl, "", "", "");
        }
      }
    }
    for (;;)
    {
      break;
      if ((localTroopMemberInfo.mUniqueTitleExpire != 0) && (localTroopMemberInfo.mUniqueTitleExpire != -1) && (localTroopMemberInfo.mUniqueTitleExpire < l))
      {
        l = localTroopMemberInfo.mUniqueTitleExpire;
        continue;
        localTroopManager.ab(this.this$0.sessionInfo.aTl, l);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.2
 * JD-Core Version:    0.7.0.1
 */