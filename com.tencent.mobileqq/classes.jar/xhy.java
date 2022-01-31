import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class xhy
  extends Handler
{
  private WeakReference<xhw> a;
  
  public xhy(xhw paramxhw, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramxhw);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (xhw localxhw = (xhw)this.a.get();; localxhw = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof xhx)) {
          localObject1 = (xhx)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localxhw != null) && (localObject1 != null))
        {
          ((xhw)this.a.get()).d();
          continue;
          if ((localxhw != null) && (localObject1 != null))
          {
            ((xhw)this.a.get()).e();
            continue;
            if ((localxhw != null) && (localObject1 != null))
            {
              ((xhw)this.a.get()).c(((xhx)localObject1).a);
              continue;
              if ((localxhw != null) && (localObject1 != null))
              {
                ((xhw)this.a.get()).f();
                continue;
                if ((localxhw != null) && (localObject1 != null)) {
                  ((xhw)this.a.get()).b(((xhx)localObject1).a);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xhy
 * JD-Core Version:    0.7.0.1
 */