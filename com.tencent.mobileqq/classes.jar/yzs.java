import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yzs
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, yry>
{
  public yzs(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull yry paramyry)
  {
    if (paramyry != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramyry.a, paramyry.b, paramyry.c, paramyry.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return yry.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzs
 * JD-Core Version:    0.7.0.1
 */