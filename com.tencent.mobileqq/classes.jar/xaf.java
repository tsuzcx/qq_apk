import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xaf
  extends QQUIEventReceiver<wzo, wci>
{
  public xaf(@NonNull wzo paramwzo)
  {
    super(paramwzo);
  }
  
  public void a(@NonNull wzo paramwzo, @NonNull wci paramwci)
  {
    if (paramwci.a.isSuccess())
    {
      xvv.a(paramwzo.b, "receive user info event. %s.", paramwci.toString());
      paramwzo.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaf
 * JD-Core Version:    0.7.0.1
 */