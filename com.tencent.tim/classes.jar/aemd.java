import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aemd
{
  private int cNL;
  private int cNM;
  private int open;
  
  public static aemd a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aemd localaemd = new aemd();
        paramString = new JSONObject(paramString);
        localaemd.open = paramString.optInt("showVoiceToTextSwitch", -1);
        localaemd.cNL = paramString.optInt("grayTipShowPerThousand", -1);
        localaemd.cNM = paramString.optInt("mainSwitch", -1);
        return localaemd;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public int Cq()
  {
    return this.cNL;
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
 * Qualified Name:     aemd
 * JD-Core Version:    0.7.0.1
 */