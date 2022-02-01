package com.tencent.mobileqq.activity;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.qphone.base.util.QLog;
import xto;

class ChatHistoryImageView$2
  implements Runnable
{
  ChatHistoryImageView$2(ChatHistoryImageView paramChatHistoryImageView, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    long l;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[onImageListLoad]: ");
      if (this.a == null)
      {
        localObject = "null";
        QLog.d("ChatHistoryImageView", 2, localObject);
      }
    }
    else
    {
      l = SystemClock.uptimeMillis();
      if ((this.a != null) && (!this.this$0.jdField_a_of_type_Xto.a(this.a, this.bFv))) {
        this.this$0.jdField_a_of_type_Xto.SL();
      }
      if (this.this$0.jdField_a_of_type_Xto.getCount() != 0) {
        break label231;
      }
      this.this$0.mEmptyView.setVisibility(0);
    }
    for (;;)
    {
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.ay(false)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) {
        this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false);
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$a.bKo();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onImageListLoad] cost: " + (SystemClock.uptimeMillis() - l));
      }
      return;
      localObject = Integer.valueOf(this.a.length);
      break;
      label231:
      this.this$0.mEmptyView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView.2
 * JD-Core Version:    0.7.0.1
 */