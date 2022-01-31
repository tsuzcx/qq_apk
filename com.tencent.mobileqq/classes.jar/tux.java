import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tux
  extends QQUIEventReceiver<tun, sxr>
{
  public tux(@NonNull tun paramtun)
  {
    super(paramtun);
  }
  
  public void a(@NonNull tun paramtun, @NonNull sxr paramsxr)
  {
    if (paramsxr.a.isSuccess())
    {
      urk.a(paramtun.b, "receive user info event. %s.", paramsxr.toString());
      paramtun.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tux
 * JD-Core Version:    0.7.0.1
 */