import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uht
  extends QQUIEventReceiver<uhj, tkn>
{
  public uht(@NonNull uhj paramuhj)
  {
    super(paramuhj);
  }
  
  public void a(@NonNull uhj paramuhj, @NonNull tkn paramtkn)
  {
    if (paramtkn.a.isSuccess())
    {
      veg.a(paramuhj.b, "receive user info event. %s.", paramtkn.toString());
      paramuhj.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uht
 * JD-Core Version:    0.7.0.1
 */