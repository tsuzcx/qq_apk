import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class abgs
  extends Handler
{
  abgs(abgr paramabgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == abgr.a(this.this$0))
    {
      QLog.d(abgr.a(this.this$0), 4, "Receive Message!");
      this.this$0.XW();
    }
    for (;;)
    {
      try
      {
        anot.a(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == abgr.b(this.this$0))
      {
        QLog.d(abgr.a(this.this$0), 4, "Receive Message!");
        try
        {
          anot.a(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgs
 * JD-Core Version:    0.7.0.1
 */