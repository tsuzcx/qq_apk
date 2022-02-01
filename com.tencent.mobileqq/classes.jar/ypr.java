import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ypr
  extends QQUIEventReceiver<ypb, wii>
{
  public ypr(@NonNull ypb paramypb)
  {
    super(paramypb);
  }
  
  public void a(@NonNull ypb paramypb, @NonNull wii paramwii)
  {
    if (paramwii.a())
    {
      yqp.b(this.TAG, "group video upload");
      return;
    }
    if (!paramwii.b())
    {
      yqp.b(this.TAG, "ignore personal video");
      return;
    }
    paramypb.a(paramwii);
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypr
 * JD-Core Version:    0.7.0.1
 */