import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeky
{
  public boolean bUT = true;
  
  public static aeky a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aeky localaeky = new aeky();
        if (new JSONObject(paramString).optInt("enableMultiChannelReport", 1) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaeky.bUT = bool;
          return localaeky;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("MultiChannelReportProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeky
 * JD-Core Version:    0.7.0.1
 */