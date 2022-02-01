package com.tencent.mobileqq.dating;

import acbn;
import ajpj;
import anov;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;

class MsgBoxListActivity$7
  implements Runnable
{
  MsgBoxListActivity$7(MsgBoxListActivity paramMsgBoxListActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, ajpj paramajpj) {}
  
  public void run()
  {
    String str1;
    int i;
    String str2;
    label42:
    anov localanov;
    if (this.a.isLiving)
    {
      str1 = String.valueOf(this.a.startLiveWordingType);
      i = this.b.GA();
      if (!this.this$0.isFromNearby) {
        break label157;
      }
      str2 = "1";
      localanov = new anov(this.this$0.app).a("dc00899").b("grp_lbs").c("msg_box");
      if (!this.a.isLiving) {
        break label163;
      }
    }
    label157:
    label163:
    for (String str3 = "clk_livepush";; str3 = "clk_relivepush")
    {
      localanov.d(str3).e(String.valueOf(Long.valueOf(this.a.senderuin).longValue() - acbn.Pd)).a(new String[] { str1, String.valueOf(i), str2 }).report();
      return;
      str1 = String.valueOf(this.a.endLiveWordingType);
      break;
      str2 = "0";
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.7
 * JD-Core Version:    0.7.0.1
 */