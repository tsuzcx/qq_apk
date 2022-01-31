import org.json.JSONObject;

public class wwu
{
  private String a = wwt.b;
  private String b = "1";
  private String c = wwt.a;
  
  public static wwu a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      wwu localwwu = new wwu();
      paramString = new JSONObject(paramString);
      localwwu.a = paramString.optString("mine_videostory_entrance", wwt.b);
      localwwu.b = paramString.optString("enable_click_take_picture", "1");
      localwwu.c = paramString.optString("mine_videostory_drawer_entrance", wwt.a);
      return localwwu;
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
 * Qualified Name:     wwu
 * JD-Core Version:    0.7.0.1
 */