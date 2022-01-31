import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.TribeShortVideoMsgHolder;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.qphone.base.util.QLog;

public class vjf
  implements Runnable
{
  public vjf(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, String paramString, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "itemBuilder handleGetVideo 2: fileName = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.c, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.coverImgUrl, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vjf
 * JD-Core Version:    0.7.0.1
 */