package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;

class ez$1
  extends Handler
{
  ez$1(ez paramez, Looper paramLooper)
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
    synchronized (ez.a(this.px))
    {
      if (ez.b(this.px) < 4)
      {
        ez.a locala = (ez.a)ez.c(this.px).poll();
        if (locala != null)
        {
          ez.d(this.px);
          ez.a(this.px, locala.pE, locala.data, locala.pF);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.ez.1
 * JD-Core Version:    0.7.0.1
 */