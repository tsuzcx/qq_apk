import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class xhv
  extends Handler
{
  private WeakReference<xht> a;
  
  public xhv(xht paramxht, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramxht);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (xht localxht = (xht)this.a.get();; localxht = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof xhu)) {
          localObject1 = (xhu)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localxht != null) && (localObject1 != null))
        {
          ((xht)this.a.get()).d();
          continue;
          if ((localxht != null) && (localObject1 != null))
          {
            ((xht)this.a.get()).e();
            continue;
            if ((localxht != null) && (localObject1 != null))
            {
              ((xht)this.a.get()).c(((xhu)localObject1).a);
              continue;
              if ((localxht != null) && (localObject1 != null))
              {
                ((xht)this.a.get()).f();
                continue;
                if ((localxht != null) && (localObject1 != null)) {
                  ((xht)this.a.get()).b(((xhu)localObject1).a);
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
 * Qualified Name:     xhv
 * JD-Core Version:    0.7.0.1
 */