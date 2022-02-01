import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class dii
  implements Handler.Callback
{
  public dii(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dii
 * JD-Core Version:    0.7.0.1
 */