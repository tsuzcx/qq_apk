import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class dss
  extends Handler
{
  public dss(SubLoginActivity paramSubLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1982: 
      this.a.finish();
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dss
 * JD-Core Version:    0.7.0.1
 */