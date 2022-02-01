import android.text.TextUtils;
import org.json.JSONObject;

public class kko
{
  public String ZJ;
  public String ZK;
  public String appid;
  public String appname;
  public int businessType;
  public String pkgName;
  public String via;
  
  public void N(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.ZJ = paramJSONObject.optString("adDownloadApiUrl");
      this.pkgName = paramJSONObject.optString("pkg_name");
      this.appid = paramJSONObject.optString("appid");
      this.appname = paramJSONObject.optString("appname");
      this.ZK = paramJSONObject.optString("pkgurl");
      this.businessType = paramJSONObject.optInt("business_type", 0);
      paramJSONObject = paramJSONObject.optString("apk_url");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.ZK = paramJSONObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kko
 * JD-Core Version:    0.7.0.1
 */