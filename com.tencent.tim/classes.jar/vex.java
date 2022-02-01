import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vex
  implements Handler.Callback
{
  public vex(Leba paramLeba) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.leba", 4, "callback handleMessage,what = " + paramMessage.what);
    }
    if ((this.this$0.app != null) && ("0".equals(this.this$0.app.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
      }
      this.this$0.bQx();
      continue;
      Leba.c(this.this$0);
      continue;
      this.this$0.at(paramMessage);
      continue;
      this.this$0.bQO();
      continue;
      Leba.d(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vex
 * JD-Core Version:    0.7.0.1
 */