import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class thv
  extends QQUIEventReceiver<StoryPlayerActivity, thu>
{
  public thv(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull thu paramthu)
  {
    paramStoryPlayerActivity.b = paramthu.a;
  }
  
  public Class acceptEventClass()
  {
    return thu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thv
 * JD-Core Version:    0.7.0.1
 */