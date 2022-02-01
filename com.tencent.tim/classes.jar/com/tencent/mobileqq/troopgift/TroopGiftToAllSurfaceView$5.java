package com.tencent.mobileqq.troopgift;

import anyb;
import anyc;
import anyr;
import apxm;

public class TroopGiftToAllSurfaceView$5
  implements Runnable
{
  TroopGiftToAllSurfaceView$5(TroopGiftToAllSurfaceView paramTroopGiftToAllSurfaceView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    TroopGiftToAllSurfaceView.a(this.this$0, new anyr(this.this$0, this.this$0.getContext(), this.val$text, this.TJ, this.dXP));
    TroopGiftToAllSurfaceView.a(this.this$0).setPosition(TroopGiftToAllSurfaceView.a(this.this$0).viewWidth / 2, TroopGiftToAllSurfaceView.a(this.this$0).viewHeight * TroopGiftToAllSurfaceView.a(this.this$0).dgn / 100);
    this.this$0.b(TroopGiftToAllSurfaceView.a(this.this$0));
    TroopGiftToAllSurfaceView.a(this.this$0).opacity = 0;
    anyc localanyc = new anyc(500);
    localanyc.a(new apxm(this));
    TroopGiftToAllSurfaceView.a(this.this$0).a(new anyb[] { localanyc });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */