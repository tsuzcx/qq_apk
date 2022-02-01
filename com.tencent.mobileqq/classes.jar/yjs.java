import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjs
  extends QQUIEventReceiver<yjc, wcx>
{
  public yjs(@NonNull yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wcx paramwcx)
  {
    if (paramwcx.a())
    {
      ykq.b(this.TAG, "group video upload");
      return;
    }
    if (!paramwcx.b())
    {
      ykq.b(this.TAG, "ignore personal video");
      return;
    }
    paramyjc.a(paramwcx);
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjs
 * JD-Core Version:    0.7.0.1
 */