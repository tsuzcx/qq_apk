import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wxt
  extends QQUIEventReceiver<wxp, wsm>
{
  public wxt(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull wsm paramwsm)
  {
    paramwxp.a.b(paramwsm);
  }
  
  public Class acceptEventClass()
  {
    return wsm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxt
 * JD-Core Version:    0.7.0.1
 */