import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import mqq.os.MqqHandler;

public class yyc
  extends MqqHandler
{
  public yyc(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (TroopSuspiciousFragment.a(this.this$0) == null);
      TroopSuspiciousFragment.a(this.this$0).notifyDataSetChanged();
      return;
    }
    this.this$0.cmu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyc
 * JD-Core Version:    0.7.0.1
 */