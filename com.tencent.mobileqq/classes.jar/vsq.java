import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vsq
  extends QQUIEventReceiver<vsp, vsu>
{
  public vsq(@NonNull vsp paramvsp)
  {
    super(paramvsp);
  }
  
  public void a(@NonNull vsp paramvsp, @NonNull vsu paramvsu)
  {
    if (paramvsu.a.isSuccess())
    {
      wxe.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramvsu.toString());
      paramvsp.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return vsu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsq
 * JD-Core Version:    0.7.0.1
 */