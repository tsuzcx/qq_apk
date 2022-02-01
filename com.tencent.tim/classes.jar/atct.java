import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.call.activity.CallActivity;

public class atct
  implements Handler.Callback
{
  public atct(CallActivity paramCallActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.this$0.app.isLogin()) {}
    do
    {
      do
      {
        do
        {
          return true;
          switch (paramMessage.what)
          {
          case 1023: 
          case 1024: 
          case 1026: 
          case 1028: 
          case 1029: 
          default: 
            return false;
          case 1025: 
            CallActivity.a(this.this$0);
            return true;
          case 1020: 
            CallActivity.b(this.this$0);
            return true;
          case 1030: 
            CallActivity.c(this.this$0);
            return true;
          }
        } while (CallActivity.a(this.this$0) == null);
        CallActivity.a(this.this$0).aV(paramMessage);
        return true;
      } while (CallActivity.a(this.this$0) == null);
      CallActivity.a(this.this$0).aCB();
      return true;
    } while (this.this$0.app == null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atct
 * JD-Core Version:    0.7.0.1
 */