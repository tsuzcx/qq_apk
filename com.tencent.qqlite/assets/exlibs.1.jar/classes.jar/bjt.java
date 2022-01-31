import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;

public class bjt
  implements Handler.Callback
{
  public bjt(ShortcutRouterActivity paramShortcutRouterActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    this.a.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bjt
 * JD-Core Version:    0.7.0.1
 */