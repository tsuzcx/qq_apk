import org.json.JSONObject;

public class oid
  extends ohx
{
  public boolean axp;
  public long yP;
  
  public oid(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static oid a(JSONObject paramJSONObject)
  {
    return new oid(paramJSONObject);
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.axp = paramJSONObject.optBoolean("isPreloadVideoPlugin");
      this.yP = paramJSONObject.optLong("queryPluginTimeInterval");
      return;
    }
    this.axp = true;
    this.yP = 3600L;
  }
  
  public String toString()
  {
    return "WeSeeVideoPluginConfigInfo{mIsPreloadPluginInWsRecommend=" + this.axp + ", mQueryPluginTimeInterval=" + this.yP + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oid
 * JD-Core Version:    0.7.0.1
 */