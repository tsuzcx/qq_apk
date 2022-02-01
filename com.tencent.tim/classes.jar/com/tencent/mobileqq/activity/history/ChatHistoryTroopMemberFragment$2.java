package com.tencent.mobileqq.activity.history;

import acff;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import aqgx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChatHistoryTroopMemberFragment$2
  implements Runnable
{
  ChatHistoryTroopMemberFragment$2(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, Intent paramIntent, acff paramacff, TroopManager paramTroopManager) {}
  
  public void run()
  {
    boolean bool2 = false;
    ??? = "";
    int i;
    if (this.val$data != null)
    {
      i = this.val$data.getIntExtra("memberOperationFlag", 0);
      ??? = this.val$data.getStringExtra("memberOperateUin");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + i + ", optUin=" + (String)???);
      }
      if ((i & 0x1) != 0)
      {
        this.this$0.a((String)???);
        if (((i & 0x4) != 0) && (this.e != null))
        {
          this.this$0.b = this.e.b(this.this$0.mTroopUin);
          ??? = this.this$0;
          if ((this.this$0.b == null) || (!this.this$0.b.isHomeworkTroop())) {
            break label514;
          }
        }
      }
      label514:
      for (boolean bool1 = true;; bool1 = false) {
        for (;;)
        {
          ((ChatHistoryTroopMemberFragment)???).aLZ = bool1;
          if (this.this$0.b != null)
          {
            if (this.this$0.b.troopowneruin != null) {
              this.this$0.aPW = this.this$0.b.troopowneruin;
            }
            if (this.this$0.b.Administrator != null) {
              this.this$0.aPX = this.this$0.b.Administrator;
            }
            ??? = this.this$0;
            if ((this.this$0.b.troopowneruin == null) || (!this.this$0.b.troopowneruin.equals(this.this$0.getActivity().app.getCurrentAccountUin())))
            {
              bool1 = bool2;
              if (this.this$0.aPX != null)
              {
                bool1 = bool2;
                if (!this.this$0.aPX.contains(this.this$0.getActivity().app.getCurrentAccountUin())) {}
              }
            }
            else
            {
              bool1 = true;
            }
            ((ChatHistoryTroopMemberFragment)???).bap = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("Q.history.BaseFragment", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:" + this.this$0.aPX + " owner:" + this.this$0.aPW);
            }
          }
          if ((i != 0) && (this.this$0.a != null)) {
            this.this$0.mHandler.sendEmptyMessage(9);
          }
          return;
          if ((i & 0x2) == 0) {
            break;
          }
          Object localObject2 = aqgx.a().a(this.this$0.app, this.this$0.mTroopUin, (String)???);
          if ((localObject2 == null) || (this.g == null)) {
            break;
          }
          this.this$0.a((String)???);
          synchronized (this.this$0)
          {
            localObject2 = this.this$0.a((TroopMemberInfo)localObject2, this.g);
            this.this$0.pr.add(localObject2);
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */