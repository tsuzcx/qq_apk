import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.antiphing.AntiphishingUrlConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class eyx
  extends Handler
{
  public eyx(AntiphishingUrlConfig paramAntiphishingUrlConfig) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == AntiphishingUrlConfig.a(this.a))
    {
      QLog.d(AntiphishingUrlConfig.a(this.a), 4, "Receive Message!");
      this.a.a();
    }
    for (;;)
    {
      try
      {
        ReportController.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == AntiphishingUrlConfig.b(this.a))
      {
        QLog.d(AntiphishingUrlConfig.a(this.a), 4, "Receive Message!");
        try
        {
          ReportController.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     eyx
 * JD-Core Version:    0.7.0.1
 */