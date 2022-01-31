import org.json.JSONObject;

public class yzb
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public static yzb a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      yzb localyzb = new yzb();
      paramString = new JSONObject(paramString);
      localyzb.a = paramString.optString("icon_image_url", "");
      localyzb.b = paramString.optString("md5", "");
      localyzb.c = paramString.optString("widget_id", "");
      return localyzb;
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
    return "k = icon_image_url, value = " + this.a + "\n k = md5, value = " + this.b + "\n k = widget_id, value = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yzb
 * JD-Core Version:    0.7.0.1
 */