import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tyk
  extends QQUIEventReceiver<tyc, tkk>
{
  public tyk(@NonNull tyc paramtyc)
  {
    super(paramtyc);
  }
  
  public void a(@NonNull tyc paramtyc, @NonNull tkk paramtkk)
  {
    if (paramtkk.a.isSuccess())
    {
      ved.a(this.TAG, "receive user info event. %s.", paramtkk.toString());
      paramtyc = paramtyc.a();
      if (paramtyc != null) {
        paramtyc.a();
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyk
 * JD-Core Version:    0.7.0.1
 */