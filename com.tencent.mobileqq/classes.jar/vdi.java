import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qphone.base.util.QLog;

public class vdi
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  public vdi(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_a_of_type_Long < 50L) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)((BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView)).a;
    if (TroopStoryUtil.a(localMessageForQQStoryComment.vid))
    {
      StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext, localMessageForQQStoryComment.vid, 1004);
      StoryReportor.a("story_grp", "aio_obj", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramView = localMessageForQQStoryComment.selfuin;
    if (localMessageForQQStoryComment.isSend()) {
      paramView = localMessageForQQStoryComment.frienduin;
    }
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramView);
      StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext, localMessageForQQStoryComment.vid, l1, 5, null, 0);
      return;
    }
    catch (NumberFormatException paramView)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("QQStoryCommentItemBuilder", 2, "uin parse error");
          l1 = l2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */