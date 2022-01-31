import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vnp
  extends QQUIEventReceiver<StoryPlayerActivity, vno>
{
  public vnp(@NonNull StoryPlayerActivity paramStoryPlayerActivity)
  {
    super(paramStoryPlayerActivity);
  }
  
  public void a(@NonNull StoryPlayerActivity paramStoryPlayerActivity, @NonNull vno paramvno)
  {
    paramStoryPlayerActivity.b = paramvno.a;
  }
  
  public Class acceptEventClass()
  {
    return vno.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */