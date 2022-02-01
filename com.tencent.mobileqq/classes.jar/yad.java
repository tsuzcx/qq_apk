import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yad
  extends QQUIEventReceiver<xzx, wix>
{
  public yad(xzx paramxzx)
  {
    super(paramxzx);
  }
  
  public void a(@NonNull xzx paramxzx, @NonNull wix paramwix)
  {
    if (paramwix.a.isSuccess())
    {
      ykq.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramwix.toString());
      xzx.a(paramxzx, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return wix.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yad
 * JD-Core Version:    0.7.0.1
 */