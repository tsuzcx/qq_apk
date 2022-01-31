import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class vnf
  extends Handler
{
  vnf(vne paramvne, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a) {
      return;
    }
    vne.a(this.a, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnf
 * JD-Core Version:    0.7.0.1
 */