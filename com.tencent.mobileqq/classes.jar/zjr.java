import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Timer;
import java.util.TimerTask;

public class zjr
  extends TimerTask
{
  public zjr(PrinterStatusHandler paramPrinterStatusHandler) {}
  
  public void run()
  {
    ReportController.b(this.a.b, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (PrinterStatusHandler.a(this.a) != null)
    {
      PrinterStatusHandler.a(this.a).cancel();
      PrinterStatusHandler.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjr
 * JD-Core Version:    0.7.0.1
 */