import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xlh
  extends QQUIEventReceiver<xlc, voc>
{
  public xlh(xlc paramxlc)
  {
    super(paramxlc);
  }
  
  public void a(@NonNull xlc paramxlc, @NonNull voc paramvoc)
  {
    if (paramvoc.a.isSuccess())
    {
      if (!paramvoc.a()) {
        break label25;
      }
      xvv.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramvoc.c())
        {
          xvv.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramvoc.toString());
          return;
        }
      } while (!paramvoc.b());
      xvv.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramvoc.toString());
    } while (paramvoc.b == null);
    xlc.a(paramxlc, true);
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlh
 * JD-Core Version:    0.7.0.1
 */