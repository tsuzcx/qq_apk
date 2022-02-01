import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xmb
  extends QQUIEventReceiver<xma, xmf>
{
  public xmb(@NonNull xma paramxma)
  {
    super(paramxma);
  }
  
  public void a(@NonNull xma paramxma, @NonNull xmf paramxmf)
  {
    if (paramxmf.a.isSuccess())
    {
      yqp.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramxmf.toString());
      paramxma.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return xmf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmb
 * JD-Core Version:    0.7.0.1
 */