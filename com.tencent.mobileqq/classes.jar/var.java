import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.QQStoryMsgHolder;
import com.tencent.qphone.base.util.QLog;

public class var
  implements Runnable
{
  public var(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, StoryVideoItem paramStoryVideoItem, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryItemBuilder", 2, "QQStoryItemBuilder handleGetVideo 3: fileName = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
    PlayModeUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalMaskPath, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOriginalMaskPicUrl, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoWidth, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoHeight, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     var
 * JD-Core Version:    0.7.0.1
 */