import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ybb
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, xtj>
{
  public ybb(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull xtj paramxtj)
  {
    if (paramxtj != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramxtj.a, paramxtj.b, paramxtj.c, paramxtj.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return xtj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybb
 * JD-Core Version:    0.7.0.1
 */