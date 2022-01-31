import com.tencent.mobileqq.activity.contacts.base.HonestSayController;
import com.tencent.mobileqq.statistics.ReportController;

public class wmy
  implements Runnable
{
  public wmy(HonestSayController paramHonestSayController) {}
  
  public void run()
  {
    HonestSayController.a(this.a, true);
    ReportController.b(HonestSayController.a(this.a), "dc00898", "", "", "0X8008F4A", "0X8008F4A", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmy
 * JD-Core Version:    0.7.0.1
 */