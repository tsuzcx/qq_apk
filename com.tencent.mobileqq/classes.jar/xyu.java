import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xyu
  extends QQUIEventReceiver<xyd, xas>
{
  public xyu(@NonNull xyd paramxyd)
  {
    super(paramxyd);
  }
  
  public void a(@NonNull xyd paramxyd, @NonNull xas paramxas)
  {
    if (paramxas.a.isSuccess())
    {
      yuk.a(paramxyd.b, "receive user info event. %s.", paramxas.toString());
      paramxyd.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyu
 * JD-Core Version:    0.7.0.1
 */