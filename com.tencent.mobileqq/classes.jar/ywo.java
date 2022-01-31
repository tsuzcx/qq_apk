import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class ywo
  extends Handler
{
  private WeakReference<ywm> a;
  
  public ywo(ywm paramywm, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramywm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (ywm localywm = (ywm)this.a.get();; localywm = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof ywn)) {
          localObject1 = (ywn)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localywm != null) && (localObject1 != null))
        {
          ((ywm)this.a.get()).d();
          continue;
          if ((localywm != null) && (localObject1 != null))
          {
            ((ywm)this.a.get()).e();
            continue;
            if ((localywm != null) && (localObject1 != null))
            {
              ((ywm)this.a.get()).c(((ywn)localObject1).a);
              continue;
              if ((localywm != null) && (localObject1 != null))
              {
                ((ywm)this.a.get()).f();
                continue;
                if ((localywm != null) && (localObject1 != null)) {
                  ((ywm)this.a.get()).b(((ywn)localObject1).a);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywo
 * JD-Core Version:    0.7.0.1
 */