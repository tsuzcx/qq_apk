import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public final class woi
  extends QQUIEventReceiver<woa, wlx>
{
  public woi(@NonNull woa paramwoa)
  {
    super(paramwoa);
  }
  
  public void a(@NonNull woa paramwoa, @NonNull wlx paramwlx)
  {
    paramwoa.a.a(paramwlx.a);
  }
  
  public Class acceptEventClass()
  {
    return wlx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woi
 * JD-Core Version:    0.7.0.1
 */