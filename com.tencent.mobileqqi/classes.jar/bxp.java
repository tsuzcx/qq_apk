import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;

public class bxp
  extends Handler
{
  public bxp(AccountManageActivity paramAccountManageActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 9875: 
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "SUBACCOUNT_REQUEST_CHANGE_HANDLER_VALUE");
      }
      AccountManageActivity.a(this.a);
      AccountManageActivity.b(this.a);
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bxp
 * JD-Core Version:    0.7.0.1
 */