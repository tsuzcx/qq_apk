import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class zyj
  extends Handler
{
  private WeakReference<zyh> a;
  
  public zyj(zyh paramzyh, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramzyh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (zyh localzyh = (zyh)this.a.get();; localzyh = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof zyi)) {
          localObject1 = (zyi)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localzyh != null) && (localObject1 != null))
        {
          ((zyh)this.a.get()).d();
          continue;
          if ((localzyh != null) && (localObject1 != null))
          {
            ((zyh)this.a.get()).e();
            continue;
            if ((localzyh != null) && (localObject1 != null))
            {
              ((zyh)this.a.get()).c(((zyi)localObject1).a);
              continue;
              if ((localzyh != null) && (localObject1 != null))
              {
                ((zyh)this.a.get()).f();
                continue;
                if ((localzyh != null) && (localObject1 != null)) {
                  ((zyh)this.a.get()).b(((zyi)localObject1).a);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyj
 * JD-Core Version:    0.7.0.1
 */