import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjw
  extends QQUIEventReceiver<yjr, wmd>
{
  public yjw(yjr paramyjr)
  {
    super(paramyjr);
  }
  
  public void a(@NonNull yjr paramyjr, @NonNull wmd paramwmd)
  {
    if (paramwmd.a.isSuccess())
    {
      if (!paramwmd.a()) {
        break label25;
      }
      yuk.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramwmd.c())
        {
          yuk.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramwmd.toString());
          return;
        }
      } while (!paramwmd.b());
      yuk.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramwmd.toString());
    } while (paramwmd.b == null);
    yjr.a(paramyjr, true);
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjw
 * JD-Core Version:    0.7.0.1
 */