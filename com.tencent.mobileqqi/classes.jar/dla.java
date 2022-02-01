import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SubAccountBindActivity;

public class dla
  extends Handler
{
  public dla(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1981: 
      this.a.finish();
      return;
    case 1990: 
      this.a.f();
      return;
    }
    SubAccountBindActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dla
 * JD-Core Version:    0.7.0.1
 */