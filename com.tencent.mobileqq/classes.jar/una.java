import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.statistics.ReportController;

public class una
  implements Runnable
{
  public una(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    RedTouchItem localRedTouchItem = this.a.a.a(100601);
    if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.passThroughLevel > 0))
    {
      localRedTouchItem.passThroughLevel = 0;
      this.a.a.d();
      ReportController.b(this.a.app, "dc00898", "", "", "0X800760F", "0X800760F", 0, 0, "1", "", "", "");
      return;
    }
    ReportController.b(this.a.app, "dc00898", "", "", "0X800760F", "0X800760F", 0, 0, "2", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     una
 * JD-Core Version:    0.7.0.1
 */