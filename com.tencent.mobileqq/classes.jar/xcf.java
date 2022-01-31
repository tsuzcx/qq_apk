import org.json.JSONObject;

public class xcf
{
  public String a;
  public String b;
  
  public xcf(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xcf
 * JD-Core Version:    0.7.0.1
 */