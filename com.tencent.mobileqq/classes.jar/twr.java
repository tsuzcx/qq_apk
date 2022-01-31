import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class twr
  extends QQUIEventReceiver<twp, sxr>
{
  public twr(@NonNull twp paramtwp)
  {
    super(paramtwp);
  }
  
  public void a(@NonNull twp paramtwp, @NonNull sxr paramsxr)
  {
    if (paramsxr.a.isSuccess())
    {
      urk.a(this.TAG, "receive user info event. %s.", paramsxr.toString());
      paramtwp.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twr
 * JD-Core Version:    0.7.0.1
 */