import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yoj
  extends QQUIEventReceiver<ynm, yoi>
{
  public yoj(@NonNull ynm paramynm)
  {
    super(paramynm);
  }
  
  public void a(@NonNull ynm paramynm, @NonNull yoi paramyoi)
  {
    paramynm.a(paramyoi);
  }
  
  public Class acceptEventClass()
  {
    return yoi.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yoj
 * JD-Core Version:    0.7.0.1
 */