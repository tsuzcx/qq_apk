import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class wyy
  extends Handler
{
  private WeakReference<wyw> a;
  
  public wyy(wyw paramwyw, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramwyw);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (wyw localwyw = (wyw)this.a.get();; localwyw = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof wyx)) {
          localObject1 = (wyx)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localwyw != null) && (localObject1 != null))
        {
          ((wyw)this.a.get()).d();
          continue;
          if ((localwyw != null) && (localObject1 != null))
          {
            ((wyw)this.a.get()).e();
            continue;
            if ((localwyw != null) && (localObject1 != null))
            {
              ((wyw)this.a.get()).c(((wyx)localObject1).a);
              continue;
              if ((localwyw != null) && (localObject1 != null))
              {
                ((wyw)this.a.get()).f();
                continue;
                if ((localwyw != null) && (localObject1 != null)) {
                  ((wyw)this.a.get()).b(((wyx)localObject1).a);
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
 * Qualified Name:     wyy
 * JD-Core Version:    0.7.0.1
 */