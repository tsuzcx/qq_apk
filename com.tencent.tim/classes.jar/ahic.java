import java.util.HashMap;
import java.util.Map;

public class ahic
{
  private static ahic a;
  private Map<String, String> kR = new HashMap();
  
  public static ahic a()
  {
    if (a == null) {
      a = new ahic();
    }
    return a;
  }
  
  public static String ln(String paramString)
  {
    if (a == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)a.kR.remove(paramString);
      paramString = str;
    } while (!a.kR.isEmpty());
    a = null;
    return str;
  }
  
  public void ga(String paramString1, String paramString2)
  {
    this.kR.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahic
 * JD-Core Version:    0.7.0.1
 */