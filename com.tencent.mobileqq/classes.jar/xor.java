import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xor
  extends QQUIEventReceiver<xoj, xas>
{
  public xor(@NonNull xoj paramxoj)
  {
    super(paramxoj);
  }
  
  public void a(@NonNull xoj paramxoj, @NonNull xas paramxas)
  {
    if (paramxas.a.isSuccess())
    {
      yuk.a(this.TAG, "receive user info event. %s.", paramxas.toString());
      paramxoj = paramxoj.a();
      if (paramxoj != null) {
        paramxoj.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xor
 * JD-Core Version:    0.7.0.1
 */