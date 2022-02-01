import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ugf
{
  public uge a;
  public ugh a;
  public ugi a;
  
  public ugf()
  {
    this.jdField_a_of_type_Ugi = new ugi(null);
    this.jdField_a_of_type_Ugh = new ugh(null);
    this.jdField_a_of_type_Uge = new uge(null);
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
  
  public static ugf a()
  {
    return (ugf)aqlk.a().a(447);
  }
  
  public void a(String paramString)
  {
    upe.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Ugi = ugi.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Ugh = ugh.a(paramString.optJSONObject("trends_tab_strategy"));
    this.jdField_a_of_type_Uge = uge.a(paramString.optJSONObject("beacon_report_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Ugi).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Ugh != null) {}
    for (String str = this.jdField_a_of_type_Ugh.a;; str = "null") {
      return str + "mBeaconConfigInfo=" + this.jdField_a_of_type_Uge + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugf
 * JD-Core Version:    0.7.0.1
 */