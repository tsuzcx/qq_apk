import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class atsr
  extends Handler
{
  atsr(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    ((agie)arrayOfObject[0]).onUpdate(paramMessage.what, ((Boolean)arrayOfObject[1]).booleanValue(), arrayOfObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsr
 * JD-Core Version:    0.7.0.1
 */