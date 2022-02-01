import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ypu
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, yie>
{
  public ypu(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull yie paramyie)
  {
    if (paramyie != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramyie.a, paramyie.b, paramyie.c, paramyie.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return yie.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypu
 * JD-Core Version:    0.7.0.1
 */