import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yrx
  extends QQUIEventReceiver<yrh, wsl>
{
  public yrx(@NonNull yrh paramyrh)
  {
    super(paramyrh);
  }
  
  public void a(@NonNull yrh paramyrh, @NonNull wsl paramwsl)
  {
    if (paramwsl.a) {
      yrh.d(paramyrh);
    }
  }
  
  public Class acceptEventClass()
  {
    return wsl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrx
 * JD-Core Version:    0.7.0.1
 */