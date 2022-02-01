package com.tencent.mobileqq.ar.ARPromotion;

import adbn;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class ARTransferDoorLogicManager$5
  implements Runnable
{
  public ARTransferDoorLogicManager$5(adbn paramadbn, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.bLg == true) {
      adbn.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      QLog.d(adbn.TAG, 2, "makeARTransferPromotionTouchViewVisiable " + this.bLg);
      return;
      adbn.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5
 * JD-Core Version:    0.7.0.1
 */