import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.QQStoryMsgHolder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.StoryChatVideoView;

public class vaq
  implements Runnable
{
  public vaq(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    Long localLong = (Long)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    if ((localLong == null) || (localLong.longValue() != this.jdField_a_of_type_Long)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
    QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vaq
 * JD-Core Version:    0.7.0.1
 */