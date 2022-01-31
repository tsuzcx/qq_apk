import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wyd
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, wqj>
{
  public wyd(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull wqj paramwqj)
  {
    if (paramwqj != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramwqj.a, paramwqj.b, paramwqj.c, paramwqj.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return wqj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyd
 * JD-Core Version:    0.7.0.1
 */