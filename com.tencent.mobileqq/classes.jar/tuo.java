import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tuo
  extends QQUIEventReceiver<StoryPlayerActivity, tun>
{
  public tuo(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull tun paramtun)
  {
    paramStoryPlayerActivity.b = paramtun.a;
  }
  
  public Class acceptEventClass()
  {
    return tun.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuo
 * JD-Core Version:    0.7.0.1
 */