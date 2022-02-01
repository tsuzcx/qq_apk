import org.json.JSONObject;

public class una
  extends umt
{
  public String a;
  
  public una(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static una a(JSONObject paramJSONObject)
  {
    return new una(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     una
 * JD-Core Version:    0.7.0.1
 */