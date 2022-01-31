import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xcm
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, wus>
{
  public xcm(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull wus paramwus)
  {
    if (paramwus != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramwus.a, paramwus.b, paramwus.c, paramwus.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return wus.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcm
 * JD-Core Version:    0.7.0.1
 */