import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public abstract class umf<T extends IEventReceiver, EVENT extends uli>
  extends QQUIEventReceiver<T, EVENT>
{
  public umf(T paramT)
  {
    super(paramT);
  }
  
  public final void a(@NonNull T paramT, @NonNull EVENT paramEVENT)
  {
    if ((paramEVENT.a != null) && (paramEVENT.a.isFail()))
    {
      c(paramT, paramEVENT);
      return;
    }
    b(paramT, paramEVENT);
  }
  
  public abstract void b(@NonNull T paramT, @NonNull EVENT paramEVENT);
  
  public abstract void c(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umf
 * JD-Core Version:    0.7.0.1
 */