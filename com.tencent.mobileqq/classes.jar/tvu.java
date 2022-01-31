import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tvu
  extends QQUIEventReceiver<tvd, sxr>
{
  public tvu(@NonNull tvd paramtvd)
  {
    super(paramtvd);
  }
  
  public void a(@NonNull tvd paramtvd, @NonNull sxr paramsxr)
  {
    if (paramsxr.a.isSuccess())
    {
      urk.a(paramtvd.b, "receive user info event. %s.", paramsxr.toString());
      paramtvd.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvu
 * JD-Core Version:    0.7.0.1
 */