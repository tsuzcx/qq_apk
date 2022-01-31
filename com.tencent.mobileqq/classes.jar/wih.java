import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wih
  extends QQUIEventReceiver<wic, ukn>
{
  public wih(wic paramwic)
  {
    super(paramwic);
  }
  
  public void a(@NonNull wic paramwic, @NonNull ukn paramukn)
  {
    if (paramukn.a.isSuccess())
    {
      if (!paramukn.a()) {
        break label25;
      }
      wsv.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramukn.c())
        {
          wsv.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramukn.toString());
          return;
        }
      } while (!paramukn.b());
      wsv.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramukn.toString());
    } while (paramukn.b == null);
    wic.a(paramwic, true);
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wih
 * JD-Core Version:    0.7.0.1
 */