import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekq
{
  public boolean bUJ;
  public boolean bUK;
  
  public static aekq a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      aekq localaekq = new aekq();
      paramString = new JSONObject(paramString);
      localaekq.bUJ = paramString.optBoolean("isCryptEnable", false);
      localaekq.bUK = paramString.optBoolean("isCryptLogOpen", false);
      return localaekq;
    }
    catch (Exception paramString)
    {
      QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return null;
  }
  
  public String toString()
  {
    return "MSFConfigBean{isCryptEnable=" + this.bUJ + ", isCryptLogOpen=" + this.bUK + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekq
 * JD-Core Version:    0.7.0.1
 */