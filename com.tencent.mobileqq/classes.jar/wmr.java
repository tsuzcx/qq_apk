import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wmr
  extends QQUIEventReceiver<wml, uvf>
{
  public wmr(wml paramwml)
  {
    super(paramwml);
  }
  
  public void a(@NonNull wml paramwml, @NonNull uvf paramuvf)
  {
    if (paramuvf.a.isSuccess())
    {
      wxe.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramuvf.toString());
      wml.a(paramwml, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return uvf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wmr
 * JD-Core Version:    0.7.0.1
 */