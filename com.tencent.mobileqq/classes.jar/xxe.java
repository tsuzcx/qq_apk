import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xxe
  extends QQUIEventReceiver<xwr, xas>
{
  public xxe(@NonNull xwr paramxwr)
  {
    super(paramxwr);
  }
  
  public void a(@NonNull xwr paramxwr, @NonNull xas paramxas)
  {
    if (paramxas.a.isSuccess())
    {
      yuk.a(paramxwr.b, "receive user info event. %s.", paramxas.toString());
      paramxwr.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxe
 * JD-Core Version:    0.7.0.1
 */