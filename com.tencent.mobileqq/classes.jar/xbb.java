import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xbb
  extends QQUIEventReceiver<StoryPlayerActivity, xba>
{
  public xbb(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull xba paramxba)
  {
    paramStoryPlayerActivity.b = paramxba.a;
  }
  
  public Class acceptEventClass()
  {
    return xba.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbb
 * JD-Core Version:    0.7.0.1
 */