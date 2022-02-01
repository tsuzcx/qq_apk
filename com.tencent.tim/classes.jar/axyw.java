import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class axyw
  implements axzz.b
{
  private static final String TAG = axyw.class.getSimpleName();
  private static axyw a = new axyw();
  private HashMap<String, axzy> rw = new HashMap();
  private HashMap<String, AtomicInteger> rx = new HashMap();
  
  public static axyw a()
  {
    return a;
  }
  
  @NonNull
  public <T extends axzy> T a(@NonNull Class<T> paramClass)
  {
    if (axyv.class.isAssignableFrom(paramClass))
    {
      if (!this.rw.containsKey(paramClass.getName())) {}
      try
      {
        this.rw.put(paramClass.getName(), paramClass.newInstance());
        this.rx.put(paramClass.getName(), new AtomicInteger(0));
        AtomicInteger localAtomicInteger = (AtomicInteger)this.rx.get(paramClass.getName());
        if (localAtomicInteger != null)
        {
          localAtomicInteger.incrementAndGet();
          QLog.d(TAG, 1, paramClass.getName() + " has created and ref = " + localAtomicInteger.get());
        }
        return (axzy)this.rw.get(paramClass.getName());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          localInstantiationException.printStackTrace();
        }
      }
    }
    throw new RuntimeException("Cannot create non global view model " + paramClass.getName() + " by GlobalViewModelFactory");
  }
  
  public void a(axzy paramaxzy)
  {
    if ((paramaxzy instanceof axyv))
    {
      AtomicInteger localAtomicInteger = (AtomicInteger)this.rx.get(paramaxzy.getClass().getName());
      if ((localAtomicInteger != null) && (localAtomicInteger.decrementAndGet() == 0))
      {
        this.rw.remove(paramaxzy.getClass().getName());
        this.rx.remove(paramaxzy.getClass().getName());
        QLog.d(TAG, 1, paramaxzy.getClass().getName() + " has removed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyw
 * JD-Core Version:    0.7.0.1
 */