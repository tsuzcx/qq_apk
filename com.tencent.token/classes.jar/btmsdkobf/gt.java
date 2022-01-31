package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

class gt
  extends Handler
{
  gt(da paramda, Looper paramLooper)
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
    try
    {
      da.a(this.a).removeMessages(1);
      gz localgz = new gz(this.a, null);
      synchronized (da.b(this.a))
      {
        Iterator localIterator = da.c(this.a).iterator();
        if (localIterator.hasNext())
        {
          da.a locala = (da.a)localIterator.next();
          localgz.a(Integer.valueOf(locala.kC), locala);
          if ((locala.kJ & 0x40000000) == 0) {
            da.d(this.a).put(Integer.valueOf(locala.kC), locala);
          }
          eh.e("SharkProcessProxy", da.e(this.a) + " sendShark() MSG_SEND_PROXY_TASK task.mIpcSeqNo: " + locala.kC);
        }
      }
      da.c(this.a).clear();
    }
    catch (Exception ???)
    {
      eh.h("SharkProcessProxy", "exception: " + ???);
      return;
    }
    da.f(this.a).submit(localRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gt
 * JD-Core Version:    0.7.0.1
 */