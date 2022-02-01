import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeou
{
  public int cOm;
  public int result;
  
  public static aeou a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aeou localaeou = new aeou();
        paramString = new JSONObject(paramString);
        localaeou.result = paramString.optInt("switch", 0);
        localaeou.cOm = paramString.optInt("stoppreload", 0);
        QLog.d("ConfBean", 2, "confBean = " + localaeou.result);
        return localaeou;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("result:").append(this.result);
    localStringBuilder.append(" stoppreload:").append(this.cOm);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeou
 * JD-Core Version:    0.7.0.1
 */