import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class vay
{
  public vax a;
  public vba a;
  public vbb a;
  
  public vay()
  {
    this.jdField_a_of_type_Vbb = new vbb(null);
    this.jdField_a_of_type_Vba = new vba(null);
    this.jdField_a_of_type_Vax = new vax(null);
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
  
  public static vay a()
  {
    return (vay)aqxe.a().a(447);
  }
  
  public void a(String paramString)
  {
    vmp.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Vbb = vbb.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Vba = vba.a(paramString.optJSONObject("trends_tab_strategy"));
    this.jdField_a_of_type_Vax = vax.a(paramString.optJSONObject("beacon_report_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Vbb).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Vba != null) {}
    for (String str = this.jdField_a_of_type_Vba.a;; str = "null") {
      return str + "mBeaconConfigInfo=" + this.jdField_a_of_type_Vax + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vay
 * JD-Core Version:    0.7.0.1
 */