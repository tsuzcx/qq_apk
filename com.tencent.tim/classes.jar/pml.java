import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public abstract class pml<T extends IEventReceiver, EVENT extends plt>
  extends QQUIEventReceiver<T, EVENT>
{
  public pml(T paramT)
  {
    super(paramT);
  }
  
  public final void a(@NonNull T paramT, @NonNull EVENT paramEVENT)
  {
    if ((paramEVENT.b != null) && (paramEVENT.b.isFail()))
    {
      c(paramT, paramEVENT);
      return;
    }
    b(paramT, paramEVENT);
  }
  
  public abstract void b(@NonNull T paramT, @NonNull EVENT paramEVENT);
  
  public abstract void c(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pml
 * JD-Core Version:    0.7.0.1
 */