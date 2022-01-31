import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ugx
  extends QQUIEventReceiver<ugk, tkk>
{
  public ugx(@NonNull ugk paramugk)
  {
    super(paramugk);
  }
  
  public void a(@NonNull ugk paramugk, @NonNull tkk paramtkk)
  {
    if (paramtkk.a.isSuccess())
    {
      ved.a(paramugk.b, "receive user info event. %s.", paramtkk.toString());
      paramugk.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugx
 * JD-Core Version:    0.7.0.1
 */