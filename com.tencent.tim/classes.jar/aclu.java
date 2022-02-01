import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aclu
  implements Handler.Callback
{
  public aclu(SignatureManager paramSignatureManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (2 == paramMessage.what)
    {
      SignatureManager.a = (aqqr.a[])paramMessage.obj;
      if (this.this$0.mApp != null)
      {
        paramMessage = this.this$0.mApp.getHandler(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(2, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "update sign tpl info...");
        }
      }
    }
    for (;;)
    {
      return true;
      if ((3 == paramMessage.what) && (this.this$0.mApp != null))
      {
        paramMessage = this.this$0.mApp.getHandler(EditActivity.class);
        if (paramMessage != null) {
          paramMessage.sendEmptyMessageDelayed(7, 50L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "update sign tpl animation ...");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclu
 * JD-Core Version:    0.7.0.1
 */