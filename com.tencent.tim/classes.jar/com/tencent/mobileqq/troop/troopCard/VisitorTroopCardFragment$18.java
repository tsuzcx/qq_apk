package com.tencent.mobileqq.troop.troopCard;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import appp;
import aqha;
import aqju;

public class VisitorTroopCardFragment$18
  implements Runnable
{
  VisitorTroopCardFragment$18(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void run()
  {
    if (this.this$0.x != null) {
      if (!this.this$0.x.isShowing()) {
        this.this$0.x.show();
      }
    }
    do
    {
      return;
      this.this$0.x = aqha.a(this.this$0.getActivity(), 230);
      this.this$0.x.setMessage(this.this$0.getActivity().getResources().getString(2131721369));
      appp localappp = new appp(this);
      this.this$0.x.setPositiveButton(2131691970, localappp);
    } while (this.this$0.x.isShowing());
    this.this$0.x.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.18
 * JD-Core Version:    0.7.0.1
 */