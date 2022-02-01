import java.util.HashMap;
import java.util.Map;

public class itl
{
  private static volatile itl a;
  private Map<String, String> df = new HashMap();
  
  private itl()
  {
    this.df.put("request", new String("-1"));
    this.df.put("update", new String("-1"));
    this.df.put("load", new String("-1"));
  }
  
  public static itl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new itl();
      }
      return a;
    }
    finally {}
  }
  
  public void al(String paramString, int paramInt)
  {
    try
    {
      this.df.put(paramString, String.valueOf(paramInt));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String get(String paramString)
  {
    return (String)this.df.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itl
 * JD-Core Version:    0.7.0.1
 */