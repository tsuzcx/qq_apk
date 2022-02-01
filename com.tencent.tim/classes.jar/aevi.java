import org.json.JSONObject;

public class aevi
{
  public boolean bWD;
  
  public static aevi a(String paramString)
  {
    aevi localaevi = new aevi();
    try
    {
      localaevi.bWD = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localaevi;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aevi
 * JD-Core Version:    0.7.0.1
 */