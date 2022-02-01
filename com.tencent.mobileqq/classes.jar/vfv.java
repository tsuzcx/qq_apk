import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class vfv
  extends Handler
{
  private vft a;
  
  vfv(Looper paramLooper, vft paramvft)
  {
    super(paramLooper);
    this.a = paramvft;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      vft.a(this.a);
      return;
    }
    vft.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfv
 * JD-Core Version:    0.7.0.1
 */