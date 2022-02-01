import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class oia
{
  public oic a;
  public oid a;
  
  public oia()
  {
    this.jdField_a_of_type_Oid = new oid(null);
    this.jdField_a_of_type_Oic = new oic(null);
  }
  
  public static oia a()
  {
    return (oia)aeif.a().o(447);
  }
  
  private static JSONObject j(String paramString)
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
  
  public void bj(String paramString)
  {
    ooz.d("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = j(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Oid = oid.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Oic = oic.a(paramString.optJSONObject("trends_tab_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Oid).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Oic != null) {}
    for (String str = this.jdField_a_of_type_Oic.aqd;; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oia
 * JD-Core Version:    0.7.0.1
 */