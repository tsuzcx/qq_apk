package com.tencent.mobileqq.troopgift;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import apxr;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class TroopInteractGiftAnimationController$5
  implements Runnable
{
  public TroopInteractGiftAnimationController$5(apxr paramapxr) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.hp.removeView(this.this$0.c);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null) {
      this.this$0.cV.removeView(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton);
    }
    this.this$0.c = null;
    this.this$0.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.5
 * JD-Core Version:    0.7.0.1
 */