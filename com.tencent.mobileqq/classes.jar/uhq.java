import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uhq
  extends QQUIEventReceiver<uhg, tkk>
{
  public uhq(@NonNull uhg paramuhg)
  {
    super(paramuhg);
  }
  
  public void a(@NonNull uhg paramuhg, @NonNull tkk paramtkk)
  {
    if (paramtkk.a.isSuccess())
    {
      ved.a(paramuhg.b, "receive user info event. %s.", paramtkk.toString());
      paramuhg.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhq
 * JD-Core Version:    0.7.0.1
 */