import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.ThreadPriorityManager;

public final class esu
  extends Handler
{
  public esu(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ThreadPriorityManager.a();
      return;
    }
    ThreadPriorityManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     esu
 * JD-Core Version:    0.7.0.1
 */