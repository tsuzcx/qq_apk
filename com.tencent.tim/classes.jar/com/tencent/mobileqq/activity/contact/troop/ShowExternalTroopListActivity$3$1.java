package com.tencent.mobileqq.activity.contact.troop;

import acfp;
import android.widget.TextView;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopMemberCard;

class ShowExternalTroopListActivity$3$1
  implements Runnable
{
  ShowExternalTroopListActivity$3$1(ShowExternalTroopListActivity.3 param3, String paramString, Card paramCard) {}
  
  public void run()
  {
    this.a.BB.setText(this.val$nickName);
    if (this.a.this$0.xv) {
      this.a.Mf.setText(acfp.m(2131714532));
    }
    do
    {
      TroopMemberCard localTroopMemberCard;
      do
      {
        return;
        this.a.Mf.setText(acfp.m(2131714531));
        if (this.a.this$0.aZN == null) {
          break;
        }
        localTroopMemberCard = this.a.this$0.b.a(this.a.this$0.aZN, this.a.this$0.aZM);
      } while (localTroopMemberCard == null);
      if (localTroopMemberCard.sex == 1) {
        this.a.Mf.setText(acfp.m(2131714533));
      }
      this.a.BB.setText(localTroopMemberCard.nick);
      return;
    } while ((this.c == null) || (this.c.shGender != 1));
    this.a.Mf.setText(acfp.m(2131714534));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.3.1
 * JD-Core Version:    0.7.0.1
 */