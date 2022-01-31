import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vjo
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, vbu>
{
  public vjo(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull vbu paramvbu)
  {
    if (paramvbu != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramvbu.a, paramvbu.b, paramvbu.c, paramvbu.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return vbu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjo
 * JD-Core Version:    0.7.0.1
 */