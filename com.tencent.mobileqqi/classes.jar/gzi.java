import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;

public class gzi
  extends Handler
{
  public gzi(TroopAioNewMessageBar paramTroopAioNewMessageBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == TroopAioNewMessageBar.a()) && (TroopAioNewMessageBar.b() == TroopAioNewMessageBar.a(this.a))) {
      TroopAioNewMessageBar.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzi
 * JD-Core Version:    0.7.0.1
 */