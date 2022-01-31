import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class uac
  extends Handler
{
  uac(uab paramuab, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4097: 
      uab.a(this.a);
      return;
    }
    uab.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uac
 * JD-Core Version:    0.7.0.1
 */