import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;

public class dpf
  extends Handler
{
  public dpf(OnlineFileSessionCenter paramOnlineFileSessionCenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dpf
 * JD-Core Version:    0.7.0.1
 */