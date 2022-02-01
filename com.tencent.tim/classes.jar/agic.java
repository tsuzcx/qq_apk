import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class agic
  extends Handler
{
  agic(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    ((agie)arrayOfObject[0]).onUpdate(paramMessage.what, ((Boolean)arrayOfObject[1]).booleanValue(), arrayOfObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agic
 * JD-Core Version:    0.7.0.1
 */