import org.json.JSONObject;

public class ugk
  extends ugc
{
  public long a;
  public boolean a;
  
  public ugk(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static ugk a(JSONObject paramJSONObject)
  {
    return new ugk(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isPreloadVideoPlugin");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("queryPluginTimeInterval");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 3600L;
  }
  
  public String toString()
  {
    return "WeSeeVideoPluginConfigInfo{mIsPreloadPluginInWsRecommend=" + this.jdField_a_of_type_Boolean + ", mQueryPluginTimeInterval=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugk
 * JD-Core Version:    0.7.0.1
 */