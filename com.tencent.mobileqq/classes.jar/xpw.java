import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpw
  extends QQUIEventReceiver<xpv, xqa>
{
  public xpw(@NonNull xpv paramxpv)
  {
    super(paramxpv);
  }
  
  public void a(@NonNull xpv paramxpv, @NonNull xqa paramxqa)
  {
    if (paramxqa.a.isSuccess())
    {
      yuk.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramxqa.toString());
      paramxpv.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return xqa.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpw
 * JD-Core Version:    0.7.0.1
 */