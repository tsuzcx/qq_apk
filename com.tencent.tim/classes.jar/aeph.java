import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeph
{
  private int cOt = 1;
  
  public static aeph a(aeic paramaeic)
  {
    aeph localaeph = new aeph();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    try
    {
      localaeph.cOt = new JSONObject(paramaeic.content).optInt("suspiciousSwitch", 1);
      return localaeph;
    }
    catch (JSONException paramaeic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaeic.toString());
    }
    return localaeph;
  }
  
  public boolean UP()
  {
    return this.cOt == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeph
 * JD-Core Version:    0.7.0.1
 */