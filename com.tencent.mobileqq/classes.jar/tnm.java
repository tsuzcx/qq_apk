import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class tnm
  implements Runnable
{
  public tnm(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X8008123", "0X8008123", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnm
 * JD-Core Version:    0.7.0.1
 */