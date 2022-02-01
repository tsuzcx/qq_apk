package com.tencent.mobileqq.troop.troopCard;

import appo;
import aqha;
import aqju;

public class VisitorTroopCardFragment$17
  implements Runnable
{
  VisitorTroopCardFragment$17(VisitorTroopCardFragment paramVisitorTroopCardFragment, String paramString) {}
  
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
      this.this$0.x.setMessage(this.val$message);
      appo localappo = new appo(this);
      this.this$0.x.setPositiveButton(2131691970, localappo);
      this.this$0.x.setNegativeButton(2131721058, localappo);
    } while (this.this$0.x.isShowing());
    this.this$0.x.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.17
 * JD-Core Version:    0.7.0.1
 */