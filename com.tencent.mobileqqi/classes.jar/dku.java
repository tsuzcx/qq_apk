import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.RegisterBaseActivity;

public class dku
  extends Handler
{
  public dku(RegisterBaseActivity paramRegisterBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.g();
    String str = paramMessage.obj.toString();
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131563125);
    }
    this.a.a(paramMessage, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dku
 * JD-Core Version:    0.7.0.1
 */