package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.text.TextUtils;
import aqmr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import yeh;

public class TroopChatPie$12$1
  implements Runnable
{
  public TroopChatPie$12$1(yeh paramyeh, List paramList) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.a.this$0.app.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.a.this$0.sessionInfo.aTl);
    if (localTroopInfo == null) {
      break label45;
    }
    label45:
    while (aqmr.isEmpty(localTroopInfo.troopowneruin)) {
      return;
    }
    int i = 0;
    int j = 0;
    String str = this.a.this$0.app.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    int k;
    label94:
    int m;
    label97:
    oidb_0x899.memberlist localmemberlist;
    int n;
    if (this.val$list == null)
    {
      k = 0;
      m = 0;
      if (m >= k) {
        break label287;
      }
      localmemberlist = (oidb_0x899.memberlist)this.val$list.get(m);
      if (localmemberlist == null) {
        break label563;
      }
      if (localmemberlist.uint64_member_uin.has()) {
        break label177;
      }
      n = j;
      j = i;
      i = n;
    }
    for (;;)
    {
      n = m + 1;
      m = j;
      j = i;
      i = m;
      m = n;
      break label97;
      k = this.val$list.size();
      break label94;
      label177:
      long l = localmemberlist.uint64_member_uin.get();
      n = localmemberlist.uint32_privilege.get();
      if (l != 0L) {
        if (n == 2)
        {
          localStringBuilder.append(l).append("|");
          if (String.valueOf(l).equals(str))
          {
            n = 1;
            i = j;
            j = n;
          }
        }
        else if (n == 1)
        {
          localTroopInfo.troopowneruin = String.valueOf(l);
          if (localTroopInfo.troopowneruin.equals(str))
          {
            n = 1;
            j = i;
            i = n;
            continue;
            label287:
            localTroopInfo.Administrator = localStringBuilder.toString();
            if (!TextUtils.isEmpty(str))
            {
              if (i == 0) {
                break label529;
              }
              localTroopInfo.dwCmdUinUinFlag |= 1L;
              label321:
              if (j == 0) {
                break label546;
              }
            }
            label529:
            label546:
            for (localTroopInfo.dwAdditionalFlag |= 1L;; localTroopInfo.dwAdditionalFlag &= 0xFFFFFFFE)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.a.this$0.TAG, 2, "onOIDB0X899_0_Ret: toopUin=" + this.a.this$0.sessionInfo.aTl + ", admin=" + localTroopInfo.Administrator + ", owner=" + localTroopInfo.troopowneruin);
              }
              localTroopManager.i(localTroopInfo);
              if (QLog.isColorLevel()) {
                QLog.i(this.a.this$0.TAG, 2, localTroopInfo.Administrator);
              }
              if (QLog.isColorLevel()) {
                QLog.d("troop_gag", 2, "onOIDB0X899_0_Ret, sendEmptyMessage-TIMER_ID, hasDestory=" + this.a.this$0.aSY);
              }
              if (this.a.this$0.aSY) {
                break;
              }
              this.a.this$0.bX.removeMessages(1);
              this.a.this$0.bX.sendEmptyMessage(1);
              return;
              localTroopInfo.dwCmdUinUinFlag &= 0xFFFFFFFE;
              break label321;
            }
          }
        }
      }
      label563:
      n = i;
      i = j;
      j = n;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.1
 * JD-Core Version:    0.7.0.1
 */