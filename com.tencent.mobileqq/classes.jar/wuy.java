import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wuy
  extends QQUIEventReceiver<wub, wux>
{
  public wuy(@NonNull wub paramwub)
  {
    super(paramwub);
  }
  
  public void a(@NonNull wub paramwub, @NonNull wux paramwux)
  {
    paramwub.a(paramwux);
  }
  
  public Class acceptEventClass()
  {
    return wux.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuy
 * JD-Core Version:    0.7.0.1
 */