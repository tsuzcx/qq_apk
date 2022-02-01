import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class ynr
  extends Handler
{
  public ynr(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)paramMessage.obj;
      this.this$0.aa(paramMessage, true);
      return;
    }
    paramMessage = (List)paramMessage.obj;
    this.this$0.aa(paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynr
 * JD-Core Version:    0.7.0.1
 */