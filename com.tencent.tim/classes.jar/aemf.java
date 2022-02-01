import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aemf
{
  private int open;
  
  public static aemf a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aemf localaemf = new aemf();
        localaemf.open = new JSONObject(paramString).optInt("pttWithTextSwitch", -1);
        return localaemf;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PttWithTextSwitchBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean isOpen()
  {
    return this.open == 1;
  }
  
  public String toString()
  {
    return "open:" + this.open;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemf
 * JD-Core Version:    0.7.0.1
 */