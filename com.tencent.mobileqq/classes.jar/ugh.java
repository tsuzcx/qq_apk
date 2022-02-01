import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ugh
{
  public ugg a;
  public ugj a;
  public ugk a;
  
  public ugh()
  {
    this.jdField_a_of_type_Ugk = new ugk(null);
    this.jdField_a_of_type_Ugj = new ugj(null);
    this.jdField_a_of_type_Ugg = new ugg(null);
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
  
  public static ugh a()
  {
    return (ugh)aran.a().a(447);
  }
  
  public void a(String paramString)
  {
    uqf.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Ugk = ugk.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Ugj = ugj.a(paramString.optJSONObject("trends_tab_strategy"));
    this.jdField_a_of_type_Ugg = ugg.a(paramString.optJSONObject("beacon_report_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Ugk).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Ugj != null) {}
    for (String str = this.jdField_a_of_type_Ugj.a;; str = "null") {
      return str + "mBeaconConfigInfo=" + this.jdField_a_of_type_Ugg + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugh
 * JD-Core Version:    0.7.0.1
 */