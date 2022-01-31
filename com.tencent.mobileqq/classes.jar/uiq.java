import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uiq
  extends QQUIEventReceiver<uhz, tkn>
{
  public uiq(@NonNull uhz paramuhz)
  {
    super(paramuhz);
  }
  
  public void a(@NonNull uhz paramuhz, @NonNull tkn paramtkn)
  {
    if (paramtkn.a.isSuccess())
    {
      veg.a(paramuhz.b, "receive user info event. %s.", paramtkn.toString());
      paramuhz.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uiq
 * JD-Core Version:    0.7.0.1
 */