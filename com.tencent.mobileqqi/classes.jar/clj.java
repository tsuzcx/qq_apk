import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ForwardOperations;

public class clj
  implements Handler.Callback
{
  public clj(ForwardOperations paramForwardOperations) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    ForwardOperations.a(this.a).sendEmptyMessage(1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clj
 * JD-Core Version:    0.7.0.1
 */