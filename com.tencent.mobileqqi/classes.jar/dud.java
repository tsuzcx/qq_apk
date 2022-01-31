import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class dud
  extends TransProcessorHandler
{
  public dud(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dud
 * JD-Core Version:    0.7.0.1
 */