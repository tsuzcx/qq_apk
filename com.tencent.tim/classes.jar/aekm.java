import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekm
{
  private String byO = "";
  private String byP = "";
  
  public static aekm a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aekm localaekm = new aekm();
        paramString = new JSONObject(paramString);
        localaekm.byO = paramString.optString("dest_icon", "");
        localaekm.byP = paramString.optString("avatar_pendant", "");
        return localaekm;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String tj()
  {
    return this.byO;
  }
  
  public String tk()
  {
    return this.byP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekm
 * JD-Core Version:    0.7.0.1
 */