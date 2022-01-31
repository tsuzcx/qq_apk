import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.JumpActivity;

public class cxl
  implements Handler.Callback
{
  public cxl(JumpActivity paramJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cxl
 * JD-Core Version:    0.7.0.1
 */