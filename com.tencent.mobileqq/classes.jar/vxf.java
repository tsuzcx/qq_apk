import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vxf
  extends QQUIEventReceiver<vwo, uzc>
{
  public vxf(@NonNull vwo paramvwo)
  {
    super(paramvwo);
  }
  
  public void a(@NonNull vwo paramvwo, @NonNull uzc paramuzc)
  {
    if (paramuzc.a.isSuccess())
    {
      wsv.a(paramvwo.b, "receive user info event. %s.", paramuzc.toString());
      paramvwo.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */