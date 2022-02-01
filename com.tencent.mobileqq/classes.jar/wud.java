import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wud
  extends QQUIEventReceiver<wtu, wii>
{
  public wud(@NonNull wtu paramwtu)
  {
    super(paramwtu);
  }
  
  public void a(@NonNull wtu paramwtu, @NonNull wii paramwii)
  {
    paramwtu.a.b(paramwii);
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wud
 * JD-Core Version:    0.7.0.1
 */