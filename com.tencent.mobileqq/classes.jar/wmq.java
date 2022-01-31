import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wmq
  extends QQUIEventReceiver<wml, uow>
{
  public wmq(wml paramwml)
  {
    super(paramwml);
  }
  
  public void a(@NonNull wml paramwml, @NonNull uow paramuow)
  {
    if (paramuow.a.isSuccess())
    {
      if (!paramuow.a()) {
        break label25;
      }
      wxe.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramuow.c())
        {
          wxe.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramuow.toString());
          return;
        }
      } while (!paramuow.b());
      wxe.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramuow.toString());
    } while (paramuow.b == null);
    wml.a(paramwml, true);
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmq
 * JD-Core Version:    0.7.0.1
 */