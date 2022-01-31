import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vwi
  extends QQUIEventReceiver<vvy, uzc>
{
  public vwi(@NonNull vvy paramvvy)
  {
    super(paramvvy);
  }
  
  public void a(@NonNull vvy paramvvy, @NonNull uzc paramuzc)
  {
    if (paramuzc.a.isSuccess())
    {
      wsv.a(paramvvy.b, "receive user info event. %s.", paramuzc.toString());
      paramvvy.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwi
 * JD-Core Version:    0.7.0.1
 */