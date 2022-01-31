import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tur
  extends QQUIEventReceiver<StoryPlayerActivity, tuq>
{
  public tur(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull tuq paramtuq)
  {
    paramStoryPlayerActivity.b = paramtuq.a;
  }
  
  public Class acceptEventClass()
  {
    return tuq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tur
 * JD-Core Version:    0.7.0.1
 */