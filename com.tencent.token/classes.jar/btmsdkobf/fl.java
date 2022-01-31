package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;

class fl
  extends Handler
{
  fl(cb paramcb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    }
    for (;;)
    {
      synchronized (cb.a(this.a))
      {
        if (cb.b(this.a) >= 4) {
          break label164;
        }
        fo localfo = (fo)cb.c(this.a).poll();
        if (localfo != null)
        {
          eh.f(cb.aS(), "[http_control]handleMessage(), allow start, running tasks: " + cb.b(this.a));
          cb.d(this.a);
          cb.a(this.a, localfo.b, localfo.a, localfo.c);
          return;
        }
      }
      eh.e(cb.aS(), "[http_control]handleMessage(), allow start but no data to send, running tasks: " + cb.b(this.a));
      continue;
      label164:
      eh.g(cb.aS(), "[http_control]handleMessage(), not allow start, running tasks(>=4): " + cb.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fl
 * JD-Core Version:    0.7.0.1
 */