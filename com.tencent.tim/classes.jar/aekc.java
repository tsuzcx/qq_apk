import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekc
{
  public boolean bUz;
  
  public static aekc a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        aekc localaekc = new aekc();
        if (new JSONObject(paramString).optInt("openSwitch", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaekc.bUz = bool;
          return localaekc;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Exception paramString) {}
    }
    QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekc
 * JD-Core Version:    0.7.0.1
 */