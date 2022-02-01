import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ygb
  extends QQUIEventReceiver<yfw, wii>
{
  public ygb(yfw paramyfw)
  {
    super(paramyfw);
  }
  
  public void a(@NonNull yfw paramyfw, @NonNull wii paramwii)
  {
    if (paramwii.a.isSuccess())
    {
      if (!paramwii.a()) {
        break label25;
      }
      yqp.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramwii.c())
        {
          yqp.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramwii.toString());
          return;
        }
      } while (!paramwii.b());
      yqp.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramwii.toString());
    } while (paramwii.b == null);
    yfw.a(paramyfw, true);
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygb
 * JD-Core Version:    0.7.0.1
 */