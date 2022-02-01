import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qav.observer.FilterableObservable.1;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class asfb
{
  private final List<asfc> DA = new Vector();
  private final List<asfc> JN = new Vector();
  private Handler cb;
  private Handler mUIHandler;
  
  asfb()
  {
    if (this.mUIHandler == null) {
      this.mUIHandler = new Handler(Looper.getMainLooper());
    }
    if (this.cb == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FilterableObservable-bg-thread");
      localHandlerThread.start();
      this.cb = new Handler(localHandlerThread.getLooper());
    }
  }
  
  private void a(asfc paramasfc, Handler paramHandler, int paramInt, Object... paramVarArgs)
  {
    paramHandler.post(new FilterableObservable.1(this, paramasfc, paramInt, paramVarArgs));
  }
  
  public void a(asfc paramasfc, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.DA.add(paramasfc);
        return;
      }
      finally {}
      this.JN.add(paramasfc);
    }
  }
  
  public void a(Class<? extends asfc> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    asfc localasfc;
    synchronized (this.JN)
    {
      localIterator = this.JN.iterator();
      while (localIterator.hasNext())
      {
        localasfc = (asfc)localIterator.next();
        if ((paramClass != null) && (localasfc != null) && (paramClass.isAssignableFrom(localasfc.getClass()))) {
          a(localasfc, this.mUIHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.DA)
    {
      localIterator = this.DA.iterator();
      while (localIterator.hasNext())
      {
        localasfc = (asfc)localIterator.next();
        if ((paramClass != null) && (localasfc != null) && (paramClass.isAssignableFrom(localasfc.getClass()))) {
          a(localasfc, this.cb, paramInt, paramVarArgs);
        }
      }
    }
  }
  
  public void b(asfc paramasfc)
  {
    if (paramasfc != null) {}
    try
    {
      this.JN.remove(paramasfc);
      this.DA.remove(paramasfc);
      return;
    }
    finally
    {
      paramasfc = finally;
      throw paramasfc;
    }
  }
  
  public void destroy()
  {
    try
    {
      this.JN.clear();
      this.DA.clear();
      if (this.cb != null) {
        this.cb.getLooper().quit();
      }
      this.mUIHandler = null;
      this.cb = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asfb
 * JD-Core Version:    0.7.0.1
 */