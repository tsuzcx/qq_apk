import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekd
{
  private boolean needSeparate;
  
  public static aekd a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aekd localaekd = new aekd();
        localaekd.needSeparate = new JSONObject(paramString).optBoolean("needSeparatePersonWithGroup", false);
        return localaekd;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("GlobalSearchConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean agK()
  {
    return this.needSeparate;
  }
  
  public String toString()
  {
    return "needSeparate:" + this.needSeparate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekd
 * JD-Core Version:    0.7.0.1
 */