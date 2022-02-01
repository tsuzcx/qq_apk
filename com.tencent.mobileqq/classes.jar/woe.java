import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class woe
  extends QQUIEventReceiver<woa, wix>
{
  public woe(@NonNull woa paramwoa)
  {
    super(paramwoa);
  }
  
  public void a(@NonNull woa paramwoa, @NonNull wix paramwix)
  {
    paramwoa.a.b(paramwix);
  }
  
  public Class acceptEventClass()
  {
    return wix.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woe
 * JD-Core Version:    0.7.0.1
 */