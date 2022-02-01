import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpx
  extends QQUIEventReceiver<xpv, wrd>
{
  public xpx(@NonNull xpv paramxpv)
  {
    super(paramxpv);
  }
  
  public void a(@NonNull xpv paramxpv, @NonNull wrd paramwrd)
  {
    if (paramwrd.a.isSuccess())
    {
      ykq.a(this.TAG, "receive user info event. %s.", paramwrd.toString());
      paramxpv.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpx
 * JD-Core Version:    0.7.0.1
 */