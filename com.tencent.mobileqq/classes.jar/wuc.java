import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class wuc
  extends QQUIEventReceiver<wtu, wrr>
{
  public wuc(@NonNull wtu paramwtu)
  {
    super(paramwtu);
  }
  
  public void a(@NonNull wtu paramwtu, @NonNull wrr paramwrr)
  {
    paramwtu.a.a(paramwrr.a);
  }
  
  public Class acceptEventClass()
  {
    return wrr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuc
 * JD-Core Version:    0.7.0.1
 */