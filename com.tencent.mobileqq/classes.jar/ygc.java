import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ygc
  extends QQUIEventReceiver<yfw, wor>
{
  public ygc(yfw paramyfw)
  {
    super(paramyfw);
  }
  
  public void a(@NonNull yfw paramyfw, @NonNull wor paramwor)
  {
    if (paramwor.a.isSuccess())
    {
      yqp.a("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", paramwor.toString());
      yfw.a(paramyfw, true);
    }
  }
  
  public Class acceptEventClass()
  {
    return wor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygc
 * JD-Core Version:    0.7.0.1
 */