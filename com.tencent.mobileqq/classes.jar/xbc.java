import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xbc
  extends QQUIEventReceiver<xba, wci>
{
  public xbc(@NonNull xba paramxba)
  {
    super(paramxba);
  }
  
  public void a(@NonNull xba paramxba, @NonNull wci paramwci)
  {
    if (paramwci.a.isSuccess())
    {
      xvv.a(this.TAG, "receive user info event. %s.", paramwci.toString());
      paramxba.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbc
 * JD-Core Version:    0.7.0.1
 */