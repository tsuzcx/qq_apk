import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wqi
  extends QQUIEventReceiver<wps, uqv>
{
  public wqi(@NonNull wps paramwps)
  {
    super(paramwps);
  }
  
  public void a(@NonNull wps paramwps, @NonNull uqv paramuqv)
  {
    if (paramuqv.a) {
      wps.d(paramwps);
    }
  }
  
  public Class acceptEventClass()
  {
    return uqv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqi
 * JD-Core Version:    0.7.0.1
 */