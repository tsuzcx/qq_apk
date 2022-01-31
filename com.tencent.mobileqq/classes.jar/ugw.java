import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugw
  extends QQUIEventReceiver<ugr, sjc>
{
  public ugw(ugr paramugr)
  {
    super(paramugr);
  }
  
  public void a(@NonNull ugr paramugr, @NonNull sjc paramsjc)
  {
    if (paramsjc.a.isSuccess())
    {
      if (!paramsjc.a()) {
        break label25;
      }
      urk.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramsjc.c())
        {
          urk.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramsjc.toString());
          return;
        }
      } while (!paramsjc.b());
      urk.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramsjc.toString());
    } while (paramsjc.b == null);
    ugr.a(paramugr, true);
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugw
 * JD-Core Version:    0.7.0.1
 */