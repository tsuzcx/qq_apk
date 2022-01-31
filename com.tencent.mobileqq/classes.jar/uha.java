import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uha
  extends QQUIEventReceiver<ugn, tkn>
{
  public uha(@NonNull ugn paramugn)
  {
    super(paramugn);
  }
  
  public void a(@NonNull ugn paramugn, @NonNull tkn paramtkn)
  {
    if (paramtkn.a.isSuccess())
    {
      veg.a(paramugn.b, "receive user info event. %s.", paramtkn.toString());
      paramugn.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */