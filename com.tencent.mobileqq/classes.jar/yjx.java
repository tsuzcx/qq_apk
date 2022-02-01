import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjx
  extends QQUIEventReceiver<yjr, wsm>
{
  public yjx(yjr paramyjr)
  {
    super(paramyjr);
  }
  
  public void a(@NonNull yjr paramyjr, @NonNull wsm paramwsm)
  {
    if (paramwsm.a.isSuccess())
    {
      yuk.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramwsm.toString());
      yjr.a(paramyjr, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return wsm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjx
 * JD-Core Version:    0.7.0.1
 */