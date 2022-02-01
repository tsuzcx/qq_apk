import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xha
  extends QQUIEventReceiver<StoryPlayerActivity, xgz>
{
  public xha(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull xgz paramxgz)
  {
    paramStoryPlayerActivity.b = paramxgz.a;
  }
  
  public Class acceptEventClass()
  {
    return xgz.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xha
 * JD-Core Version:    0.7.0.1
 */