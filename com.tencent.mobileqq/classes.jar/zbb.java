import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class zbb
  extends Handler
{
  zbb(zay paramzay, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof begh)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((begh)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zbb
 * JD-Core Version:    0.7.0.1
 */