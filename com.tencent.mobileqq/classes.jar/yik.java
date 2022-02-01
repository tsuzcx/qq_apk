import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yik
  extends QQUIEventReceiver<yhn, yij>
{
  public yik(@NonNull yhn paramyhn)
  {
    super(paramyhn);
  }
  
  public void a(@NonNull yhn paramyhn, @NonNull yij paramyij)
  {
    paramyhn.a(paramyij);
  }
  
  public Class acceptEventClass()
  {
    return yij.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yik
 * JD-Core Version:    0.7.0.1
 */