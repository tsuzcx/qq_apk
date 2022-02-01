import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xkw
  extends QQUIEventReceiver<xko, wwx>
{
  public xkw(@NonNull xko paramxko)
  {
    super(paramxko);
  }
  
  public void a(@NonNull xko paramxko, @NonNull wwx paramwwx)
  {
    if (paramwwx.a.isSuccess())
    {
      yqp.a(this.TAG, "receive user info event. %s.", paramwwx.toString());
      paramxko = paramxko.a();
      if (paramxko != null) {
        paramxko.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkw
 * JD-Core Version:    0.7.0.1
 */