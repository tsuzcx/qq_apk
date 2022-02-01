import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xgc
  extends QQUIEventReceiver<xgb, xgg>
{
  public xgc(@NonNull xgb paramxgb)
  {
    super(paramxgb);
  }
  
  public void a(@NonNull xgb paramxgb, @NonNull xgg paramxgg)
  {
    if (paramxgg.a.isSuccess())
    {
      ykq.a("Q.qqstory.playernew.LoadingMoreWidget", "PlayVideoChangeReceiver. %s.", paramxgg.toString());
      paramxgb.e();
    }
  }
  
  public Class acceptEventClass()
  {
    return xgg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgc
 * JD-Core Version:    0.7.0.1
 */