import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class tkm
  extends Handler
{
  public tkm(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.a.isFinishing())
      {
        this.a.a.a(this.a.getString(2131434046));
        this.a.a.d(2130845523);
        this.a.a.b(false);
      }
      sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.a == null) || (!this.a.a.isShowing()));
    this.a.a.cancel();
    this.a.a.a(this.a.getString(2131434045));
    this.a.a.c(true);
    this.a.a.a(false);
    this.a.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkm
 * JD-Core Version:    0.7.0.1
 */