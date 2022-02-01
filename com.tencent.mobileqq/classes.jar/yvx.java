import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yvx
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, yod>
{
  public yvx(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull yod paramyod)
  {
    if (paramyod != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramyod.a, paramyod.b, paramyod.c, paramyod.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return yod.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvx
 * JD-Core Version:    0.7.0.1
 */