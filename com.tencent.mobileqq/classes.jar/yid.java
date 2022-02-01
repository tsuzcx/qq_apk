import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yid
  extends QQUIEventReceiver<yhn, wiw>
{
  public yid(@NonNull yhn paramyhn)
  {
    super(paramyhn);
  }
  
  public void a(@NonNull yhn paramyhn, @NonNull wiw paramwiw)
  {
    if (paramwiw.a) {
      yhn.d(paramyhn);
    }
  }
  
  public Class acceptEventClass()
  {
    return wiw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yid
 * JD-Core Version:    0.7.0.1
 */