import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeos
{
  public int cOl;
  
  public static aeos a(String paramString)
  {
    aeos localaeos = new aeos();
    try
    {
      localaeos.cOl = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localaeos.toString());
      return localaeos;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localaeos;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.cOl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeos
 * JD-Core Version:    0.7.0.1
 */