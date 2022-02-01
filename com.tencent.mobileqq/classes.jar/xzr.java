import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xzr
  extends QQUIEventReceiver<xzp, xas>
{
  public xzr(@NonNull xzp paramxzp)
  {
    super(paramxzp);
  }
  
  public void a(@NonNull xzp paramxzp, @NonNull xas paramxas)
  {
    if (paramxas.a.isSuccess())
    {
      yuk.a(this.TAG, "receive user info event. %s.", paramxas.toString());
      paramxzp.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzr
 * JD-Core Version:    0.7.0.1
 */