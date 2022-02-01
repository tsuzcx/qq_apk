import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeok
{
  public boolean bUz;
  public int cOg = 5;
  public int loadMoreCount = 15;
  
  public static aeok a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        aeok localaeok = new aeok();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("openSwitch", 0) == 1)
        {
          bool = true;
          localaeok.bUz = bool;
          localaeok.cOg = paramString.optInt("sameMsgCount", 5);
          localaeok.loadMoreCount = paramString.optInt("loadMoreCount", 15);
          if (localaeok.cOg < 2) {
            localaeok.bUz = false;
          }
          if (localaeok.loadMoreCount < 15) {
            localaeok.loadMoreCount = 15;
          }
          if (localaeok.loadMoreCount > 40) {
            localaeok.loadMoreCount = 40;
          }
          QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localaeok.toString());
          return localaeok;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("openSwitch = ").append(this.bUz).append(",sameMsgCount = ").append(this.cOg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeok
 * JD-Core Version:    0.7.0.1
 */