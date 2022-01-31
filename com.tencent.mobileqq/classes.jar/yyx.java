import org.json.JSONObject;

public class yyx
{
  private String a = yyw.b;
  private String b = "1";
  private String c = yyw.a;
  
  public static yyx a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      yyx localyyx = new yyx();
      paramString = new JSONObject(paramString);
      localyyx.a = paramString.optString("mine_videostory_entrance", yyw.b);
      localyyx.b = paramString.optString("enable_click_take_picture", "1");
      localyyx.c = paramString.optString("mine_videostory_drawer_entrance", yyw.a);
      return localyyx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyx
 * JD-Core Version:    0.7.0.1
 */