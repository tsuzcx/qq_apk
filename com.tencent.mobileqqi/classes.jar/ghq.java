import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;

public class ghq
  extends Handler
{
  public ghq(StatusHistoryActivity paramStatusHistoryActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghq
 * JD-Core Version:    0.7.0.1
 */