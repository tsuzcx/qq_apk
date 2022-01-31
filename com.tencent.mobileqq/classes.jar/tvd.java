import android.os.Message;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import mqq.os.MqqHandler;

public class tvd
  extends MqqHandler
{
  public tvd(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 107: 
    default: 
      return;
    case 106: 
      this.a.finish();
      return;
    }
    int i = 0;
    while (i < 6)
    {
      RegisterVerifyCodeActivity.a(this.a)[i].setText("");
      i += 1;
    }
    RegisterVerifyCodeActivity.a(this.a)[0].requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvd
 * JD-Core Version:    0.7.0.1
 */