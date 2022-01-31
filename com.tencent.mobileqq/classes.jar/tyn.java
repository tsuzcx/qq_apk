import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tyn
  extends QQUIEventReceiver<tyf, tkn>
{
  public tyn(@NonNull tyf paramtyf)
  {
    super(paramtyf);
  }
  
  public void a(@NonNull tyf paramtyf, @NonNull tkn paramtkn)
  {
    if (paramtkn.a.isSuccess())
    {
      veg.a(this.TAG, "receive user info event. %s.", paramtkn.toString());
      paramtyf = paramtyf.a();
      if (paramtyf != null) {
        paramtyf.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyn
 * JD-Core Version:    0.7.0.1
 */