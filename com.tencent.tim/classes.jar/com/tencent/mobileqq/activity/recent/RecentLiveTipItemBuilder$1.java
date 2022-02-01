package com.tencent.mobileqq.activity.recent;

import aake;
import acbn;
import ajpj;
import anov;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;

public class RecentLiveTipItemBuilder$1
  implements Runnable
{
  public RecentLiveTipItemBuilder$1(aake paramaake, QQAppInterface paramQQAppInterface, MessageForNearbyLiveTip paramMessageForNearbyLiveTip, ajpj paramajpj) {}
  
  public void run()
  {
    anov localanov = new anov(this.val$app).a("dc00899").b("grp_lbs").c("msg_box");
    if (this.a.isLiving)
    {
      str = "exp_livepush";
      localanov = localanov.d(str).e(String.valueOf(Long.valueOf(this.a.senderuin).longValue() - acbn.Pd));
      if (!this.a.isLiving) {
        break label125;
      }
    }
    label125:
    for (String str = String.valueOf(this.a.startLiveWordingType);; str = String.valueOf(this.a.endLiveWordingType))
    {
      localanov.a(new String[] { str, String.valueOf(this.b.GA()) }).report();
      return;
      str = "exp_relivepush";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */