import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wur
  extends QQUIEventReceiver<wub, uve>
{
  public wur(@NonNull wub paramwub)
  {
    super(paramwub);
  }
  
  public void a(@NonNull wub paramwub, @NonNull uve paramuve)
  {
    if (paramuve.a) {
      wub.d(paramwub);
    }
  }
  
  public Class acceptEventClass()
  {
    return uve.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wur
 * JD-Core Version:    0.7.0.1
 */