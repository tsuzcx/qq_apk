import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ujn
  extends QQUIEventReceiver<ujl, tkn>
{
  public ujn(@NonNull ujl paramujl)
  {
    super(paramujl);
  }
  
  public void a(@NonNull ujl paramujl, @NonNull tkn paramtkn)
  {
    if (paramtkn.a.isSuccess())
    {
      veg.a(this.TAG, "receive user info event. %s.", paramtkn.toString());
      paramujl.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujn
 * JD-Core Version:    0.7.0.1
 */