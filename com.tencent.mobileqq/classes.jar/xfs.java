import org.json.JSONObject;

public class xfs
{
  private String a = xfr.b;
  private String b = "1";
  private String c = xfr.a;
  
  public static xfs a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      xfs localxfs = new xfs();
      paramString = new JSONObject(paramString);
      localxfs.a = paramString.optString("mine_videostory_entrance", xfr.b);
      localxfs.b = paramString.optString("enable_click_take_picture", "1");
      localxfs.c = paramString.optString("mine_videostory_drawer_entrance", xfr.a);
      return localxfs;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "k = mine_videostory_entrance, value = " + this.a + "\n k = enableClickTakePicture, value = " + this.b + "\n k = mine_videostory_chouti_entrance, value = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfs
 * JD-Core Version:    0.7.0.1
 */