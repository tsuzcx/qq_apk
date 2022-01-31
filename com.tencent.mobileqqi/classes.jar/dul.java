import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class dul
  extends Handler
{
  public dul(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.b.isLogin()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.h();
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dul
 * JD-Core Version:    0.7.0.1
 */