import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class augp
  extends Handler
{
  augp(augo paramaugo, Looper paramLooper)
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
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MailPluginManager", 2, "getPluginUnreadMsg");
        }
        augt.a().a(augo.a(this.this$0), "cmd_get_unread", null);
      } while ((!augo.a(this.this$0).booleanValue()) || (augo.a(this.this$0) <= 0));
      augo.a(this.this$0).sendEmptyMessageDelayed(111, augo.a(this.this$0));
      return;
      augo.a(this.this$0, true);
      return;
      augo.a(this.this$0, true);
    } while ((augo.a(this.this$0) == null) || (!augo.a(this.this$0).isShowing()));
    augo.a(this.this$0).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augp
 * JD-Core Version:    0.7.0.1
 */