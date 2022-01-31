import android.os.Message;
import com.tencent.mobileqq.activity.SubLoginActivity;
import mqq.os.MqqHandler;

public class trm
  extends MqqHandler
{
  public trm(SubLoginActivity paramSubLoginActivity) {}
  
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
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trm
 * JD-Core Version:    0.7.0.1
 */