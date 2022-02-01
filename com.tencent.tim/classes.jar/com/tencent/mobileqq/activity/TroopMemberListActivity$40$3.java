package com.tencent.mobileqq.activity;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import wcd;

public class TroopMemberListActivity$40$3
  implements Runnable
{
  public TroopMemberListActivity$40$3(wcd paramwcd, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (TroopManager)this.a.this$0.app.getManager(52);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).b(this.a.this$0.mTroopUin);
    if (localTroopInfo == null) {
      return;
    }
    if (this.val$list == null) {}
    for (int i = 0;; i = this.val$list.size())
    {
      if (i == 1)
      {
        Object localObject2 = (oidb_0x899.memberlist)this.val$list.get(0);
        if ((localObject2 == null) || (!((oidb_0x899.memberlist)localObject2).uint64_member_uin.has())) {
          break;
        }
        localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
        if ((localObject2 != null) && (!"".equals(((String)localObject2).trim()))) {
          localTroopInfo.troopowneruin = ((String)localObject2).trim();
        }
      }
      ((TroopManager)localObject1).i(localTroopInfo);
      localObject1 = (acms)this.a.this$0.app.getBusinessHandler(20);
      if (localObject1 == null) {
        break;
      }
      try
      {
        ((acms)localObject1).a(Long.parseLong(this.a.this$0.mTroopUin), 0L, 2, 0, 0);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopMemberListActivityget_troop_member", 2, localException.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.3
 * JD-Core Version:    0.7.0.1
 */