import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class utp
  extends QQUIEventReceiver<utk, svv>
{
  public utp(utk paramutk)
  {
    super(paramutk);
  }
  
  public void a(@NonNull utk paramutk, @NonNull svv paramsvv)
  {
    if (paramsvv.a.isSuccess())
    {
      if (!paramsvv.a()) {
        break label25;
      }
      ved.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramsvv.c())
        {
          ved.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramsvv.toString());
          return;
        }
      } while (!paramsvv.b());
      ved.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramsvv.toString());
    } while (paramsvv.b == null);
    utk.a(paramutk, true);
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utp
 * JD-Core Version:    0.7.0.1
 */