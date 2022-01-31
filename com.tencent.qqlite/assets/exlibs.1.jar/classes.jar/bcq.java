import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.List;

public class bcq
  extends Handler
{
  public bcq(QQLSActivity paramQQLSActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
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
              do
              {
                do
                {
                  return;
                } while (QQLSActivity.b(this.a));
                if (hasMessages(5)) {
                  removeMessages(5);
                }
                QQLSActivity.c(this.a);
                if (QQLSActivity.a(this.a) != null) {
                  ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.a).getWindowToken(), 0);
                }
                QQLSActivity.b(this.a).setVisibility(0);
                paramMessage = obtainMessage(3);
                if (hasMessages(3)) {
                  removeMessages(3);
                }
                sendMessageDelayed(paramMessage, 1200L);
                return;
              } while (QQLSActivity.b(this.a));
              if (hasMessages(6)) {
                removeMessages(6);
              }
              QQLSActivity.c(this.a);
              if (QQLSActivity.a(this.a) != null) {
                ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.a).getWindowToken(), 0);
              }
              QQLSActivity.a(this.a).setVisibility(0);
              paramMessage = obtainMessage(4);
              if (hasMessages(4)) {
                removeMessages(4);
              }
              sendMessageDelayed(paramMessage, 1200L);
              return;
              QQLSActivity.a(this.a).setVisibility(4);
              return;
              QQLSActivity.b(this.a).setVisibility(4);
              return;
              this.a.b();
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message send finish");
              }
              this.a.finish();
              return;
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message finish activity finish");
              }
              this.a.finish();
              return;
            } while ((QQLSActivity.c(this.a)) || (!QQLSActivity.d(this.a)));
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "sensor don't callback 1000ms later");
            }
            QQLSActivity.d(this.a);
            return;
          } while (this.a.a == null);
          this.a.a.b();
          this.a.a = null;
          return;
        } while (QQLSActivity.a(this.a));
        ReportController.b(QQLSActivity.a(this.a), "CliOper", "", "", "0X800444B", "0X800444B", 0, 0, "", "", "", "");
        paramMessage = new Intent(this.a, QQLSUnlockActivity.class);
        this.a.startActivity(paramMessage);
        return;
        paramMessage = ((ActivityManager)this.a.getSystemService("activity")).getRunningTasks(1);
      } while ((paramMessage == null) || (paramMessage.size() <= 0));
      paramMessage = ((ActivityManager.RunningTaskInfo)paramMessage.get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "qqlsActivity onpause by :" + paramMessage);
      }
    } while (!paramMessage.equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity"));
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
    }
    paramMessage = new Intent(this.a, QQLSActivity.class);
    paramMessage.addFlags(131072);
    this.a.startActivity(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcq
 * JD-Core Version:    0.7.0.1
 */