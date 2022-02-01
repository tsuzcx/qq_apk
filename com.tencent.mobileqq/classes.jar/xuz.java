import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xuz
  extends QQUIEventReceiver<xui, wwx>
{
  public xuz(@NonNull xui paramxui)
  {
    super(paramxui);
  }
  
  public void a(@NonNull xui paramxui, @NonNull wwx paramwwx)
  {
    if (paramwwx.a.isSuccess())
    {
      yqp.a(paramxui.b, "receive user info event. %s.", paramwwx.toString());
      paramxui.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuz
 * JD-Core Version:    0.7.0.1
 */