import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wrx
  extends QQUIEventReceiver<wrh, ukn>
{
  public wrx(@NonNull wrh paramwrh)
  {
    super(paramwrh);
  }
  
  public void a(@NonNull wrh paramwrh, @NonNull ukn paramukn)
  {
    if (paramukn.a())
    {
      wsv.b(this.TAG, "group video upload");
      return;
    }
    if (!paramukn.b())
    {
      wsv.b(this.TAG, "ignore personal video");
      return;
    }
    paramwrh.a(paramukn);
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrx
 * JD-Core Version:    0.7.0.1
 */