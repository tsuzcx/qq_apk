import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;

public class emj
  extends Handler
{
  public emj(TroopAioNewMessageBar paramTroopAioNewMessageBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == TroopAioNewMessageBar.a()) && (TroopAioNewMessageBar.b() == TroopAioNewMessageBar.a(this.a))) {
      TroopAioNewMessageBar.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     emj
 * JD-Core Version:    0.7.0.1
 */