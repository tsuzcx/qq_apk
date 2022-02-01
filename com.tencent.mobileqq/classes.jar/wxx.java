import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wxx
  extends QQUIEventReceiver<wxp, wvm>
{
  public wxx(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull wvm paramwvm)
  {
    paramwxp.a.a(paramwvm.a);
  }
  
  public Class acceptEventClass()
  {
    return wvm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxx
 * JD-Core Version:    0.7.0.1
 */