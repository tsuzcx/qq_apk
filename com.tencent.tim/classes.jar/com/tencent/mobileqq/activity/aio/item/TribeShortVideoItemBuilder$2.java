package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$2
  implements Runnable
{
  TribeShortVideoItemBuilder$2(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, String paramString, TribeShortVideoItemBuilder.b paramb, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "itemBuilder handleGetVideo 2: fileName = " + this.axJ);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$b.isPlaying = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$b.b.bwe();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$b.b.setVisibility(8);
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$b, this.Jc, this.this$0.bUz, this.this$0.bUA, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.coverImgUrl, this.axJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */