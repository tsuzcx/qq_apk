package com.tencent.mobileqq.activity;

import aahb;
import android.os.Message;
import anot;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import mqq.os.MqqHandler;
import ury;

class Conversation$1$6$1
  implements Runnable
{
  Conversation$1$6$1(Conversation.1.6 param6, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.this$0.g.obtainMessage();
    localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.this$0.a.gm(26, 2);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.this$0.a.d(26, localMessage);
    anot.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation$1$6.a.this$0.app, "CliOper", "", "", "0X8008658", "0X8008658", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.1.6.1
 * JD-Core Version:    0.7.0.1
 */