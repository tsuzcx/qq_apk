package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class iw
  extends Handler
{
  public iw(en paramen, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    removeMessages(paramMessage.what);
    if (en.a(this.a))
    {
      eg.f("ThreadPool", "thread pool is pause");
      long l = System.currentTimeMillis();
      if ((en.db() > 0L) && (Math.abs(en.dc() - l) > en.db()))
      {
        eg.f("ThreadPool", "thread pool is auto wakeup");
        this.a.cY();
      }
      sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    en.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.iw
 * JD-Core Version:    0.7.0.1
 */