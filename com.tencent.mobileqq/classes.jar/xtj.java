import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xtj
  extends QQUIEventReceiver<xsw, wwx>
{
  public xtj(@NonNull xsw paramxsw)
  {
    super(paramxsw);
  }
  
  public void a(@NonNull xsw paramxsw, @NonNull wwx paramwwx)
  {
    if (paramwwx.a.isSuccess())
    {
      yqp.a(paramxsw.b, "receive user info event. %s.", paramwwx.toString());
      paramxsw.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtj
 * JD-Core Version:    0.7.0.1
 */