package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import acfp;
import android.os.Bundle;
import anot;
import why;
import whz;
import wii;

public class ReminderListFragment$5$1
  implements Runnable
{
  public ReminderListFragment$5$1(why paramwhy, int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.val$type == 2001)
    {
      if (!this.val$isSucc) {
        break label155;
      }
      AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)this.val$bundle.getSerializable("rsp");
      if ((localAcsDelMsgRsp != null) && (localAcsDelMsgRsp.ret_code == 0))
      {
        anot.a(ReminderListFragment.a(this.a.this$0), "P_CliOper", "QQnotice", "", "", "QQnotice.set.delete", 0, 0, "", "", this.a.b.busi_id, this.a.b.msg_id);
        ReminderListFragment.a(this.a.this$0).xi(this.a.val$msgId);
        ReminderListFragment.a(this.a.this$0).a(this.a.val$msgId, new whz(this));
      }
    }
    else
    {
      return;
    }
    ReminderListFragment.a(this.a.this$0, acfp.m(2131713866));
    return;
    label155:
    ReminderListFragment.a(this.a.this$0, acfp.m(2131713863));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.5.1
 * JD-Core Version:    0.7.0.1
 */