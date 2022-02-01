import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeiw
{
  public boolean bUi;
  
  public static aeiw a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aeiw localaeiw = new aeiw();
        localaeiw.bUi = new JSONObject(paramString).optBoolean("is_in_messagetab", false);
        QLog.d("AppletNotificationConfProcessor", 2, "confBean = " + localaeiw.toString());
        return localaeiw;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppletNotificationConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeiw
 * JD-Core Version:    0.7.0.1
 */