package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

class en$2
  extends Handler
{
  en$2(en paramen, Looper paramLooper)
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
      en.a(this.nS).removeMessages(1);
      en.b localb = new en.b(this.nS, null);
      synchronized (en.b(this.nS))
      {
        Iterator localIterator = en.b(this.nS).iterator();
        while (localIterator.hasNext())
        {
          en.a locala = (en.a)localIterator.next();
          localb.a(Integer.valueOf(locala.ob), locala);
          if ((locala.oh & 0x40000000) == 0) {
            en.c(this.nS).put(Integer.valueOf(locala.ob), locala);
          }
        }
      }
      en.b(this.nS).clear();
    }
    catch (Exception ???)
    {
      return;
    }
    en.d(this.nS).submit(localRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.en.2
 * JD-Core Version:    0.7.0.1
 */