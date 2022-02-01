import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xkv
  extends QQUIEventReceiver<StoryPlayerActivity, xku>
{
  public xkv(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull xku paramxku)
  {
    paramStoryPlayerActivity.b = paramxku.a;
  }
  
  public Class acceptEventClass()
  {
    return xku.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkv
 * JD-Core Version:    0.7.0.1
 */