import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wzi
  extends QQUIEventReceiver<wyy, wci>
{
  public wzi(@NonNull wyy paramwyy)
  {
    super(paramwyy);
  }
  
  public void a(@NonNull wyy paramwyy, @NonNull wci paramwci)
  {
    if (paramwci.a.isSuccess())
    {
      xvv.a(paramwyy.b, "receive user info event. %s.", paramwci.toString());
      paramwyy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzi
 * JD-Core Version:    0.7.0.1
 */