import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xxx
  extends QQUIEventReceiver<xxn, xas>
{
  public xxx(@NonNull xxn paramxxn)
  {
    super(paramxxn);
  }
  
  public void a(@NonNull xxn paramxxn, @NonNull xas paramxas)
  {
    if (paramxas.a.isSuccess())
    {
      yuk.a(paramxxn.b, "receive user info event. %s.", paramxas.toString());
      paramxxn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxx
 * JD-Core Version:    0.7.0.1
 */