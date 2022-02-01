import org.json.JSONObject;

public class vba
  extends vat
{
  public String a;
  
  public vba(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static vba a(JSONObject paramJSONObject)
  {
    return new vba(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vba
 * JD-Core Version:    0.7.0.1
 */