import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class vye
  extends MqqHandler
{
  public vye(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.this$0.app.isLogin()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.this$0.bOm();
      return;
    }
    this.this$0.bOm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vye
 * JD-Core Version:    0.7.0.1
 */