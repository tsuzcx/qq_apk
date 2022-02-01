import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class vrm
  extends Handler
{
  vrm(vrl paramvrl, Looper paramLooper)
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
      vrl.a(this.a);
      return;
    }
    vrl.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrm
 * JD-Core Version:    0.7.0.1
 */