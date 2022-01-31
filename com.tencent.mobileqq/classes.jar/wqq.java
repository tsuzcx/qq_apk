import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wqq
  extends QQUIEventReceiver<wps, usb>
{
  public wqq(@NonNull wps paramwps)
  {
    super(paramwps);
  }
  
  public void a(@NonNull wps paramwps, @NonNull usb paramusb)
  {
    paramwps.i();
  }
  
  public Class acceptEventClass()
  {
    return usb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqq
 * JD-Core Version:    0.7.0.1
 */