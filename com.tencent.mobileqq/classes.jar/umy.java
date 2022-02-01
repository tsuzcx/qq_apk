import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class umy
{
  public umx a;
  public una a;
  public unb a;
  
  public umy()
  {
    this.jdField_a_of_type_Unb = new unb(null);
    this.jdField_a_of_type_Una = new una(null);
    this.jdField_a_of_type_Umx = new umx(null);
  }
  
  private static JSONObject a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static umy a()
  {
    return (umy)apub.a().a(447);
  }
  
  public void a(String paramString)
  {
    uya.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Unb = unb.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Una = una.a(paramString.optJSONObject("trends_tab_strategy"));
    this.jdField_a_of_type_Umx = umx.a(paramString.optJSONObject("beacon_report_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Unb).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Una != null) {}
    for (String str = this.jdField_a_of_type_Una.a;; str = "null") {
      return str + "mBeaconConfigInfo=" + this.jdField_a_of_type_Umx + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umy
 * JD-Core Version:    0.7.0.1
 */