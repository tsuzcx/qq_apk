import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uws
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, uoy>
{
  public uws(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull uoy paramuoy)
  {
    if (paramuoy != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramuoy.a, paramuoy.b, paramuoy.c, paramuoy.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return uoy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uws
 * JD-Core Version:    0.7.0.1
 */