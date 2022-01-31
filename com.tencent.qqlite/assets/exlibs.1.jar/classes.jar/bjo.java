import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class bjo
  implements Handler.Callback
{
  public bjo(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjo
 * JD-Core Version:    0.7.0.1
 */