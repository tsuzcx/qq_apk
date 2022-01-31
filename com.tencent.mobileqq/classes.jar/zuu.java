import com.tencent.ark.ark;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class zuu
  implements Runnable
{
  public zuu(JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify("com.tencent.test.groupDragon", "UpdateDragonTitle", this.a.toString(), "json");
      ark.arkNotify("com.tencent.groupDragon", "UpdateDragonTitle", this.a.toString(), "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e(".troop.survey", 2, "Error: arkNotify com.tencent.groupDragon error, .so notloaded", localUnsatisfiedLinkError);
      QQCatchedExceptionReporter.reportQQCatchedException(localUnsatisfiedLinkError, "TroopHandlerCatchedException", "Error: arkNotify com.tencent.groupDragon error, .so notloaded");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zuu
 * JD-Core Version:    0.7.0.1
 */