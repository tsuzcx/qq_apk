import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class cai
  extends Handler
{
  public cai(TroopChatPie paramTroopChatPie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      TroopChatPie.a(this.a, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cai
 * JD-Core Version:    0.7.0.1
 */