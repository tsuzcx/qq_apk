import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wjw
  extends QQUIEventReceiver<StoryMessageListActivity, uzc>
{
  public wjw(@NonNull StoryMessageListActivity paramStoryMessageListActivity)
  {
    super(paramStoryMessageListActivity);
  }
  
  public void a(@NonNull StoryMessageListActivity paramStoryMessageListActivity, @NonNull uzc paramuzc)
  {
    if (paramuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 2, "get userinfo come back. >>>>>> " + paramuzc.jdField_a_of_type_JavaUtilList);
      }
      paramStoryMessageListActivity.g();
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjw
 * JD-Core Version:    0.7.0.1
 */