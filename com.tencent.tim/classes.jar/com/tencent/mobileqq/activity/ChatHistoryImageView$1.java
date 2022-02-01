package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import xsi;
import xto;
import xuf;

class ChatHistoryImageView$1
  implements Runnable
{
  ChatHistoryImageView$1(ChatHistoryImageView paramChatHistoryImageView, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.mDestroy) {}
    do
    {
      return;
      Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.b(this.kQ);
      if ((localObject != null) && (QLog.isColorLevel())) {
        QLog.i("ChatHistoryImageView", 2, "onRevokeMsg, seq:" + ((ChatMessage)localObject).uniseq);
      }
      localObject = this.this$0.jdField_a_of_type_Xto.a(this.kQ);
      if (localObject != null)
      {
        this.this$0.jdField_a_of_type_Xto.h((xuf)localObject);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
    } while ((!this.this$0.aUd) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.id != this.kQ));
    xsi.bC(this.this$0.mActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.1
 * JD-Core Version:    0.7.0.1
 */