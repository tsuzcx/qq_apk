import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class lgs
{
  public static lgs a;
  public lgt a;
  public lgu a;
  private final String aeO = "readinjoy_ex_last_update_time";
  public boolean ajZ;
  private AtomicBoolean ap = new AtomicBoolean(false);
  private long uh;
  
  private lgs()
  {
    this.jdField_a_of_type_Lgt = new lgt();
    this.jdField_a_of_type_Lgu = new lgu();
    if (b(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.ajZ = true;
      a(BaseApplicationImpl.getApplication().getRuntime(), false);
    }
  }
  
  public static lgs a()
  {
    if (jdField_a_of_type_Lgs == null) {}
    try
    {
      if (jdField_a_of_type_Lgs == null) {
        jdField_a_of_type_Lgs = new lgs();
      }
      return jdField_a_of_type_Lgs;
    }
    finally {}
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
    awit.a(paramAppRuntime, true);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = awit.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("simple_force_report_once", false);
  }
  
  private void ew(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = awit.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_ex_last_update_time", paramLong);
    awit.a((SharedPreferences.Editor)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgs
 * JD-Core Version:    0.7.0.1
 */