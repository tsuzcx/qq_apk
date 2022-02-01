import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.JumpActivity;

public class cre
  implements Handler.Callback
{
  public cre(JumpActivity paramJumpActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cre
 * JD-Core Version:    0.7.0.1
 */