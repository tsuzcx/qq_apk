import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import mqq.os.MqqHandler;

public class aaxi
  extends MqqHandler
{
  public aaxi(PhoneContactTabView paramPhoneContactTabView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    this.a.showListView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxi
 * JD-Core Version:    0.7.0.1
 */