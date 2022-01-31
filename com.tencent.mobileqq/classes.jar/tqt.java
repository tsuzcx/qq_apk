import android.os.Message;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import mqq.os.MqqHandler;

public class tqt
  extends MqqHandler
{
  public tqt(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1981: 
      this.a.finish();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqt
 * JD-Core Version:    0.7.0.1
 */