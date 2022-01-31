import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class gjw
  implements Runnable
{
  public gjw(StartupDirector paramStartupDirector, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = BaseApplicationImpl.a.a();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8003F36", "0X8003F36", 0, 0, "", "", "", "");
      }
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      Log.i("AutoMonitor", "ActionLoginM, cost=" + this.b);
      localObject = new HashMap();
      ((HashMap)localObject).put("cost", this.b + "");
      StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginM", true, this.b, 0L, (HashMap)localObject, null);
    }
    if (this.c < 0L)
    {
      Log.i("AutoMonitor", "STATE_TOTAL, cost=" + this.d);
      localObject = new HashMap();
      ((HashMap)localObject).put("cost", this.d + "");
      StatisticCollector.a(BaseApplicationImpl.a).a(null, "actLoginS", true, this.d, 0L, (HashMap)localObject, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjw
 * JD-Core Version:    0.7.0.1
 */