import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xli
  extends QQUIEventReceiver<xlc, vuc>
{
  public xli(xlc paramxlc)
  {
    super(paramxlc);
  }
  
  public void a(@NonNull xlc paramxlc, @NonNull vuc paramvuc)
  {
    if (paramvuc.a.isSuccess())
    {
      xvv.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramvuc.toString());
      xlc.a(paramxlc, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return vuc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xli
 * JD-Core Version:    0.7.0.1
 */