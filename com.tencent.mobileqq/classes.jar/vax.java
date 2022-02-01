import org.json.JSONObject;

public class vax
  extends vat
{
  public boolean a;
  
  public vax(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static vax a(JSONObject paramJSONObject)
  {
    return new vax(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optBoolean("isImmediatelyUpload");
      return;
    }
    this.a = false;
  }
  
  public String toString()
  {
    return "WeSeeBeaconReportConfigInfo{mIsImmediatelyUpload=" + this.a + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vax
 * JD-Core Version:    0.7.0.1
 */