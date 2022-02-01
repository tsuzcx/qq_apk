import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ytm
  extends QQUIEventReceiver<ysw, wmd>
{
  public ytm(@NonNull ysw paramysw)
  {
    super(paramysw);
  }
  
  public void a(@NonNull ysw paramysw, @NonNull wmd paramwmd)
  {
    if (paramwmd.a())
    {
      yuk.b(this.TAG, "group video upload");
      return;
    }
    if (!paramwmd.b())
    {
      yuk.b(this.TAG, "ignore personal video");
      return;
    }
    paramysw.a(paramwmd);
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytm
 * JD-Core Version:    0.7.0.1
 */