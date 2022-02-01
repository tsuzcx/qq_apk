import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xuc
  extends QQUIEventReceiver<xts, wwx>
{
  public xuc(@NonNull xts paramxts)
  {
    super(paramxts);
  }
  
  public void a(@NonNull xts paramxts, @NonNull wwx paramwwx)
  {
    if (paramwwx.a.isSuccess())
    {
      yqp.a(paramxts.b, "receive user info event. %s.", paramwwx.toString());
      paramxts.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuc
 * JD-Core Version:    0.7.0.1
 */