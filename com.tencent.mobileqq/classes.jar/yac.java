import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yac
  extends QQUIEventReceiver<xzx, wcx>
{
  public yac(xzx paramxzx)
  {
    super(paramxzx);
  }
  
  public void a(@NonNull xzx paramxzx, @NonNull wcx paramwcx)
  {
    if (paramwcx.a.isSuccess())
    {
      if (!paramwcx.a()) {
        break label25;
      }
      ykq.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramwcx.c())
        {
          ykq.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramwcx.toString());
          return;
        }
      } while (!paramwcx.b());
      ykq.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramwcx.toString());
    } while (paramwcx.b == null);
    xzx.a(paramxzx, true);
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yac
 * JD-Core Version:    0.7.0.1
 */