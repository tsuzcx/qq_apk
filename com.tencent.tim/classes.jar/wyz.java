import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class wyz
  extends Handler
{
  wyz(wyy paramwyy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.obj == null)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 4: 
        wyy.a(this.a);
        return;
      }
      wyy.a(this.a, true);
      return;
    }
    WeakReference localWeakReference = (WeakReference)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      wyy.a(this.a, localWeakReference);
      return;
    case 2: 
      wyy.b(this.a, localWeakReference);
      return;
    }
    wyy.c(this.a, localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyz
 * JD-Core Version:    0.7.0.1
 */