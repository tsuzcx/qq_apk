import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uin
  extends QQUIEventReceiver<uhw, tkk>
{
  public uin(@NonNull uhw paramuhw)
  {
    super(paramuhw);
  }
  
  public void a(@NonNull uhw paramuhw, @NonNull tkk paramtkk)
  {
    if (paramtkk.a.isSuccess())
    {
      ved.a(paramuhw.b, "receive user info event. %s.", paramtkk.toString());
      paramuhw.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uin
 * JD-Core Version:    0.7.0.1
 */