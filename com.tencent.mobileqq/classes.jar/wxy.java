import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wxy
  extends QQUIEventReceiver<wxp, wmd>
{
  public wxy(@NonNull wxp paramwxp)
  {
    super(paramwxp);
  }
  
  public void a(@NonNull wxp paramwxp, @NonNull wmd paramwmd)
  {
    paramwxp.a.b(paramwmd);
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wxy
 * JD-Core Version:    0.7.0.1
 */