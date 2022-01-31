import org.json.JSONObject;

public class yui
{
  private String a = yuh.b;
  private String b = "1";
  private String c = yuh.a;
  
  public static yui a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      yui localyui = new yui();
      paramString = new JSONObject(paramString);
      localyui.a = paramString.optString("mine_videostory_entrance", yuh.b);
      localyui.b = paramString.optString("enable_click_take_picture", "1");
      localyui.c = paramString.optString("mine_videostory_drawer_entrance", yuh.a);
      return localyui;
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
 * Qualified Name:     yui
 * JD-Core Version:    0.7.0.1
 */