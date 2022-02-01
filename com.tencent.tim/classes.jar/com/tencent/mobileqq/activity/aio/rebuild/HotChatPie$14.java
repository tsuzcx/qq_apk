package com.tencent.mobileqq.activity.aio.rebuild;

import apat;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;
import wki;
import yam;

public class HotChatPie$14
  implements Runnable
{
  public HotChatPie$14(yam paramyam) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getVisibility() == 0) {
      this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    }
    int i = this.this$0.jdField_a_of_type_Wki.getCount();
    if ((this.this$0.jdField_a_of_type_Wki != null) && (this.this$0.bYh != i)) {
      this.this$0.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.showRedDot(true);
    }
    if ((this.this$0.jdField_a_of_type_Apat != null) && (this.this$0.jdField_a_of_type_Apat.Le() > 0)) {
      this.this$0.jdField_a_of_type_Apat.Wy(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG + "Q.hotchat.aio_post_red_point", 2, "update, mLastMsgCountBeforeSwitch2PostTab:" + this.this$0.bYh + ",current msgItemCount:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14
 * JD-Core Version:    0.7.0.1
 */