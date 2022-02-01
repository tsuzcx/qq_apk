import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;

public class aqtk
  extends Handler
{
  public aqtk(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      QLog.d("HealthBusinessPlugin", 1, "plugin success");
      return;
    case 1: 
      QLog.d("HealthBusinessPlugin", 1, "plugin fail");
      return;
    }
    QLog.d("HealthBusinessPlugin", 1, String.format("plugin install %d", new Object[] { Integer.valueOf(this.this$0.ecy) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtk
 * JD-Core Version:    0.7.0.1
 */