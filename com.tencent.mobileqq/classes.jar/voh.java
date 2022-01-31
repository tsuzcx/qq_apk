import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class voh
  extends QQUIEventReceiver<vog, vol>
{
  public voh(@NonNull vog paramvog)
  {
    super(paramvog);
  }
  
  public void a(@NonNull vog paramvog, @NonNull vol paramvol)
  {
    if (paramvol.a.isSuccess())
    {
      wsv.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramvol.toString());
      paramvog.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return vol.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voh
 * JD-Core Version:    0.7.0.1
 */