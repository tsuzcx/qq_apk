import org.json.JSONObject;

public class xfw
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public static xfw a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      xfw localxfw = new xfw();
      paramString = new JSONObject(paramString);
      localxfw.a = paramString.optString("icon_image_url", "");
      localxfw.b = paramString.optString("md5", "");
      localxfw.c = paramString.optString("widget_id", "");
      return localxfw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfw
 * JD-Core Version:    0.7.0.1
 */