import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uts
  extends QQUIEventReceiver<utn, svy>
{
  public uts(utn paramutn)
  {
    super(paramutn);
  }
  
  public void a(@NonNull utn paramutn, @NonNull svy paramsvy)
  {
    if (paramsvy.a.isSuccess())
    {
      if (!paramsvy.a()) {
        break label25;
      }
      veg.c("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
    }
    label25:
    do
    {
      do
      {
        return;
        if (paramsvy.c())
        {
          veg.b("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramsvy.toString());
          return;
        }
      } while (!paramsvy.b());
      veg.a("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramsvy.toString());
    } while (paramsvy.b == null);
    utn.a(paramutn, true);
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uts
 * JD-Core Version:    0.7.0.1
 */