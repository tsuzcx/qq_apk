import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.concurrent.atomic.AtomicLong;

public abstract class qxi<T extends Dispatcher.Dispatchable>
  extends QQUIEventReceiver<qwy, T>
  implements qxo
{
  protected static AtomicLong s = new AtomicLong(0L);
  public qxo.b a;
  public pxf b;
  public int requestCount;
  public long startTime;
  public int state;
  
  public boolean KI()
  {
    return this.requestCount > 0;
  }
  
  public abstract int a(T paramT);
  
  public abstract void a(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxi
 * JD-Core Version:    0.7.0.1
 */