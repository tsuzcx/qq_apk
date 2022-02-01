import org.json.JSONObject;

public class ugj
  extends ugc
{
  public String a;
  
  public ugj(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static ugj a(JSONObject paramJSONObject)
  {
    return new ugj(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugj
 * JD-Core Version:    0.7.0.1
 */