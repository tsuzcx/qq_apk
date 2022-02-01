import android.os.Message;
import android.widget.EditText;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import mqq.os.MqqHandler;

public class vse
  extends MqqHandler
{
  public vse(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 107: 
    default: 
      return;
    case 106: 
      this.this$0.finish();
      return;
    }
    int i = 0;
    while (i < 6)
    {
      RegisterVerifyCodeActivity.a(this.this$0)[i].setText("");
      i += 1;
    }
    RegisterVerifyCodeActivity.a(this.this$0)[0].requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vse
 * JD-Core Version:    0.7.0.1
 */