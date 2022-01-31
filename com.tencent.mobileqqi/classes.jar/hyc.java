import android.os.Handler;
import android.os.Message;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;

public class hyc
  extends Handler
{
  public hyc(AuthDevVerifyCodeActivity2 paramAuthDevVerifyCodeActivity2) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    AuthDevVerifyCodeActivity2.d(this.a);
    String str = paramMessage.obj.toString();
    paramMessage = str;
    if (str == null) {
      paramMessage = this.a.getString(2131563125);
    }
    AuthDevVerifyCodeActivity2.e(this.a, paramMessage, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyc
 * JD-Core Version:    0.7.0.1
 */