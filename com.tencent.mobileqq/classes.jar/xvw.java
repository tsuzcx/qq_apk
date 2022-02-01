import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xvw
  extends QQUIEventReceiver<xvu, wwx>
{
  public xvw(@NonNull xvu paramxvu)
  {
    super(paramxvu);
  }
  
  public void a(@NonNull xvu paramxvu, @NonNull wwx paramwwx)
  {
    if (paramwwx.a.isSuccess())
    {
      yqp.a(this.TAG, "receive user info event. %s.", paramwwx.toString());
      paramxvu.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvw
 * JD-Core Version:    0.7.0.1
 */