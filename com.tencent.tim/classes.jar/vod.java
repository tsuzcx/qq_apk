import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class vod
  extends Handler
{
  public vod(QQLSActivity paramQQLSActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 5: 
    case 6: 
    case 4: 
    case 3: 
    case 1: 
    case 2: 
    case 16: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      do
      {
        boolean bool;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (QQLSActivity.b(this.this$0));
                if (hasMessages(5)) {
                  removeMessages(5);
                }
                QQLSActivity.b(this.this$0);
                if (QQLSActivity.a(this.this$0) != null) {
                  ((InputMethodManager)this.this$0.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.this$0).getWindowToken(), 0);
                }
                QQLSActivity.b(this.this$0).setVisibility(0);
                paramMessage = obtainMessage(3);
                if (hasMessages(3)) {
                  removeMessages(3);
                }
                sendMessageDelayed(paramMessage, 1200L);
                return;
              } while (QQLSActivity.b(this.this$0));
              if (hasMessages(6)) {
                removeMessages(6);
              }
              QQLSActivity.b(this.this$0);
              if (QQLSActivity.a(this.this$0) != null) {
                ((InputMethodManager)this.this$0.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.this$0).getWindowToken(), 0);
              }
              QQLSActivity.a(this.this$0).setVisibility(0);
              paramMessage = obtainMessage(4);
              if (hasMessages(4)) {
                removeMessages(4);
              }
              sendMessageDelayed(paramMessage, 1200L);
              return;
              QQLSActivity.a(this.this$0).setVisibility(4);
              return;
              QQLSActivity.b(this.this$0).setVisibility(4);
              return;
              this.this$0.send();
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message send finish");
              }
              QQLSActivity.a(this.this$0);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message finish activity finish");
              }
              this.this$0.finish();
              return;
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message finish activity finish, enter aio");
              }
              this.this$0.finish();
              return;
            } while ((QQLSActivity.c(this.this$0)) || (!QQLSActivity.d(this.this$0)));
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "sensor don't callback 1000ms later");
            }
            QQLSActivity.c(this.this$0);
            return;
            this.this$0.bTc();
            return;
          } while (QQLSActivity.a(this.this$0));
          anot.a(QQLSActivity.a(this.this$0), "CliOper", "", "", "0X800444B", "0X800444B", 0, 0, "", "", "", "");
          paramMessage = new Intent(this.this$0, QQLSUnlockActivity.class);
          this.this$0.startActivity(paramMessage);
          return;
          paramMessage = new Intent(this.this$0, QQLSActivity.class);
          paramMessage.addFlags(131072);
          this.this$0.startActivity(paramMessage);
          return;
          bool = QQLSActivity.e(this.this$0);
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "LS MSG_CHECKISLOCK" + bool);
          }
        } while (bool);
        this.this$0.finish();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "check sensor HasCallBack ====" + QQLSActivity.c(this.this$0));
        }
        if (QQLSActivity.c(this.this$0))
        {
          QQLSActivity.d(this.this$0);
          return;
        }
      } while (!QQLSActivity.d(this.this$0));
      QQLSActivity.c(this.this$0);
      return;
    case 13: 
      QQLSActivity.e(this.this$0);
      return;
    case 14: 
      QQLSActivity.a(this.this$0, false);
      return;
    case 15: 
      QQLSActivity.f(this.this$0);
      return;
    }
    this.this$0.a.a(QQLSActivity.a(this.this$0), (String)paramMessage.obj, 1008, false, -1, false);
    this.this$0.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vod
 * JD-Core Version:    0.7.0.1
 */