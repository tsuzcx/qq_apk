import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.QQStoryMsgHolder;
import com.tencent.qphone.base.util.QLog;

public class vdu
  implements Runnable
{
  public vdu(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString1, QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
    if ((localStoryVideoItem == null) || (TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder setVideoView 1: storyVideoItem = " + localStoryVideoItem);
      }
      ((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.b).runOnUiThread(new vdv(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder setVideoView 2: storyVideoItem = " + localStoryVideoItem);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$QQStoryMsgHolder, this.jdField_a_of_type_Long, localStoryVideoItem, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdu
 * JD-Core Version:    0.7.0.1
 */