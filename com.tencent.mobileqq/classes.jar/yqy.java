import org.json.JSONObject;

public class yqy
{
  public String a;
  public String b;
  
  public yqy(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yqy
 * JD-Core Version:    0.7.0.1
 */