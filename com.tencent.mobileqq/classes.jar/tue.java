import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tue
  extends QQUIEventReceiver<ttr, sxr>
{
  public tue(@NonNull ttr paramttr)
  {
    super(paramttr);
  }
  
  public void a(@NonNull ttr paramttr, @NonNull sxr paramsxr)
  {
    if (paramsxr.a.isSuccess())
    {
      urk.a(paramttr.b, "receive user info event. %s.", paramsxr.toString());
      paramttr.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tue
 * JD-Core Version:    0.7.0.1
 */