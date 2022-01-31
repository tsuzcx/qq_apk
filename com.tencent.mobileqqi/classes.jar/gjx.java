import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;

public class gjx
  implements Runnable
{
  public gjx(StartupDirector paramStartupDirector, int paramInt) {}
  
  public void run()
  {
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_start", 0, 1, this.jdField_a_of_type_Int, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjx
 * JD-Core Version:    0.7.0.1
 */