import org.json.JSONObject;

public class xfp
{
  private String a = xfo.b;
  private String b = "1";
  private String c = xfo.a;
  
  public static xfp a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      xfp localxfp = new xfp();
      paramString = new JSONObject(paramString);
      localxfp.a = paramString.optString("mine_videostory_entrance", xfo.b);
      localxfp.b = paramString.optString("enable_click_take_picture", "1");
      localxfp.c = paramString.optString("mine_videostory_drawer_entrance", xfo.a);
      return localxfp;
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
 * Qualified Name:     xfp
 * JD-Core Version:    0.7.0.1
 */