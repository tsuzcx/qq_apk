import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.mobileqq.statistics.ReportController;

@SuppressLint({"HandlerLeak"})
public class bhs
  extends Handler
{
  public bhs(GaInviteActivity paramGaInviteActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.a = true;
      if (this.a.c) {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        this.a.c();
        return;
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
      }
    }
    this.a.f();
    super.sendEmptyMessageDelayed(1, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhs
 * JD-Core Version:    0.7.0.1
 */