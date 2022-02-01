import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ylz<T extends Dispatcher.Dispatchable>
  extends QQUIEventReceiver<ylf, T>
  implements ymk
{
  protected static AtomicLong a = new AtomicLong(0L);
  public int a;
  public long a;
  public wvr a;
  public ymm a;
  public int b;
  
  public abstract int a(T paramT);
  
  public abstract void a(T paramT);
  
  public boolean b()
  {
    return this.b > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylz
 * JD-Core Version:    0.7.0.1
 */