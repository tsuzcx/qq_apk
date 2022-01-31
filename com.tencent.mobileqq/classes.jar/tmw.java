import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tmw
  extends QQUIEventReceiver<tmv, tna>
{
  public tmw(@NonNull tmv paramtmv)
  {
    super(paramtmv);
  }
  
  public void a(@NonNull tmv paramtmv, @NonNull tna paramtna)
  {
    if (paramtna.a.isSuccess())
    {
      urk.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramtna.toString());
      paramtmv.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return tna.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmw
 * JD-Core Version:    0.7.0.1
 */