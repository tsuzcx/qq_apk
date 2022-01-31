import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wqp
  extends QQUIEventReceiver<wps, wqo>
{
  public wqp(@NonNull wps paramwps)
  {
    super(paramwps);
  }
  
  public void a(@NonNull wps paramwps, @NonNull wqo paramwqo)
  {
    paramwps.a(paramwqo);
  }
  
  public Class acceptEventClass()
  {
    return wqo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqp
 * JD-Core Version:    0.7.0.1
 */