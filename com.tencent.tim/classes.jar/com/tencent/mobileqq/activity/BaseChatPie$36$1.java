package com.tencent.mobileqq.activity;

import apat;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import wki;

class BaseChatPie$36$1
  implements Runnable
{
  BaseChatPie$36$1(BaseChatPie.36 param36, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.a().isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.bEG > 200));
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.TAG + ".troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.Fx + ", mr.shmsgseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
      }
      if ((int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.Fx >= this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq + 1L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.jdField_a_of_type_Apat != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.jdField_a_of_type_Apat.j(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.Fx, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.val$type == 5) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.mj(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.val$type, 0, -1, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.dI, 6);
        return;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.jdField_a_of_type_Wki.b((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie$36.val$type, i, i, null, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.36.1
 * JD-Core Version:    0.7.0.1
 */