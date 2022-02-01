package com.tencent.biz.troopgift;

import android.widget.TextView;
import snw;

public class TroopGiftPanel$9$1
  implements Runnable
{
  public TroopGiftPanel$9$1(snw paramsnw, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.a.this$0.AM.setText(this.val$count + "");
    if (this.bys > 0)
    {
      this.a.this$0.AN.setText("+" + this.bys);
      this.a.this$0.AN.setVisibility(0);
      return;
    }
    this.a.this$0.AN.setText("");
    this.a.this$0.AN.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.9.1
 * JD-Core Version:    0.7.0.1
 */