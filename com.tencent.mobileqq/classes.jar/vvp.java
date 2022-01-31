import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vvp
  extends QQUIEventReceiver<vvc, uzc>
{
  public vvp(@NonNull vvc paramvvc)
  {
    super(paramvvc);
  }
  
  public void a(@NonNull vvc paramvvc, @NonNull uzc paramuzc)
  {
    if (paramuzc.a.isSuccess())
    {
      wsv.a(paramvvc.b, "receive user info event. %s.", paramuzc.toString());
      paramvvc.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvp
 * JD-Core Version:    0.7.0.1
 */