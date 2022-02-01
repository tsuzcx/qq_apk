package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class fp$1
  extends Handler
{
  fp$1(fp paramfp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 6: 
      fp.b(this.ra);
      return;
    case 5: 
      fp.c(this.ra, true);
      return;
    case 4: 
      fp.c(this.ra, false);
      return;
    case 3: 
      fp.a(this.ra);
      return;
    case 2: 
      bool = ((Boolean)paramMessage.obj).booleanValue();
      fp.b(this.ra, bool);
      return;
    }
    boolean bool = ((Boolean)paramMessage.obj).booleanValue();
    fp.a(this.ra, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fp.1
 * JD-Core Version:    0.7.0.1
 */