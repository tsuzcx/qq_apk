import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.QQStoryTakeVideoCloseAnimationActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vjl
  extends QQUIEventReceiver<QQStoryTakeVideoCloseAnimationActivity, vbr>
{
  public vjl(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity)
  {
    super(paramQQStoryTakeVideoCloseAnimationActivity);
  }
  
  public void a(@NonNull QQStoryTakeVideoCloseAnimationActivity paramQQStoryTakeVideoCloseAnimationActivity, @NonNull vbr paramvbr)
  {
    if (paramvbr != null) {
      paramQQStoryTakeVideoCloseAnimationActivity.a(paramvbr.a, paramvbr.b, paramvbr.c, paramvbr.d);
    }
  }
  
  public Class acceptEventClass()
  {
    return vbr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjl
 * JD-Core Version:    0.7.0.1
 */