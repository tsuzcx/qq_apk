import android.os.Message;
import com.tencent.mobileqq.activity.SubLoginActivity;
import mqq.os.MqqHandler;

public class vwl
  extends MqqHandler
{
  public vwl(SubLoginActivity paramSubLoginActivity) {}
  
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
    this.a.ath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwl
 * JD-Core Version:    0.7.0.1
 */