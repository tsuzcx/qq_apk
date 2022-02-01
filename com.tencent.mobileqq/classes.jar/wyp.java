import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wyp
  extends QQUIEventReceiver<wyc, wci>
{
  public wyp(@NonNull wyc paramwyc)
  {
    super(paramwyc);
  }
  
  public void a(@NonNull wyc paramwyc, @NonNull wci paramwci)
  {
    if (paramwci.a.isSuccess())
    {
      xvv.a(paramwyc.b, "receive user info event. %s.", paramwci.toString());
      paramwyc.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyp
 * JD-Core Version:    0.7.0.1
 */