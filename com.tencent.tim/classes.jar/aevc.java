import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aevc
{
  private int cOt;
  
  public static aevc a(aeic paramaeic)
  {
    localaevc = new aevc();
    if (paramaeic != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
      try
      {
        if (paramaeic.content == null) {}
        for (paramaeic = "";; paramaeic = paramaeic.content)
        {
          localaevc.cOt = new JSONObject(paramaeic).optInt("suspiciousSwitch", 0);
          return localaevc;
        }
        return localaevc;
      }
      catch (JSONException paramaeic)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaeic.toString());
        }
      }
    }
  }
  
  public boolean UP()
  {
    return this.cOt == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevc
 * JD-Core Version:    0.7.0.1
 */