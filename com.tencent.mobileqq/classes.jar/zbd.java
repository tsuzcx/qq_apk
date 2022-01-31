import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class zbd
  extends Handler
{
  private WeakReference<zbb> a;
  
  public zbd(zbb paramzbb, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramzbb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (zbb localzbb = (zbb)this.a.get();; localzbb = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof zbc)) {
          localObject1 = (zbc)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localzbb != null) && (localObject1 != null))
        {
          ((zbb)this.a.get()).d();
          continue;
          if ((localzbb != null) && (localObject1 != null))
          {
            ((zbb)this.a.get()).e();
            continue;
            if ((localzbb != null) && (localObject1 != null))
            {
              ((zbb)this.a.get()).c(((zbc)localObject1).a);
              continue;
              if ((localzbb != null) && (localObject1 != null))
              {
                ((zbb)this.a.get()).f();
                continue;
                if ((localzbb != null) && (localObject1 != null)) {
                  ((zbb)this.a.get()).b(((zbc)localObject1).a);
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
 * Qualified Name:     zbd
 * JD-Core Version:    0.7.0.1
 */