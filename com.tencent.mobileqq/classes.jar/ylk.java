import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ylk
  extends QQUIEventReceiver<StoryMessageListActivity, wtr>
{
  public ylk(@NonNull StoryMessageListActivity paramStoryMessageListActivity)
  {
    super(paramStoryMessageListActivity);
  }
  
  public void a(@NonNull StoryMessageListActivity paramStoryMessageListActivity, @NonNull wtr paramwtr)
  {
    if (paramwtr.a.isSuccess())
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.TAG, 2, "TroopNickNameUpdateEvent");
      }
      paramStoryMessageListActivity.g();
    }
  }
  
  public Class acceptEventClass()
  {
    return wtr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylk
 * JD-Core Version:    0.7.0.1
 */